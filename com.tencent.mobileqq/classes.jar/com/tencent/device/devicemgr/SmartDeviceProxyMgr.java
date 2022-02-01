package com.tencent.device.devicemgr;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.device.qfind.QFindConfig;
import com.tencent.device.qfind.QFindConfigUtil;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MsgProxyBannerProcessor;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xac7.BinderSig;
import tencent.im.oidb.cmd0xac7.DeviceInfo;
import tencent.im.oidb.cmd0xac7.ReceiveMessageDevices;
import tencent.im.oidb.cmd0xac7.ReqBody;
import tencent.im.oidb.cmd0xac7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.DpNotifyMsgBdoy;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.Head;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.NotifyItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.OccupyMicrophoneNotifyMsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.PushBody;

public class SmartDeviceProxyMgr
  extends BusinessHandler
{
  private static int s;
  DeviceInfo[] a = null;
  HashMap<Integer, ProductInfo> b = new HashMap();
  ArrayList<Long> c = new ArrayList();
  ArrayList<Long> d = new ArrayList();
  SmartDeviceProxyMgr.BroadcastHandler e = null;
  public int f = 0;
  public int g = 0;
  int h = 0;
  int i = 0;
  private SmartDeviceIPCHost j;
  private int k = 0;
  private boolean l = false;
  private long m = 0L;
  private ITransFileController n;
  private QQAppInterface o;
  private String p;
  private QFindBLEScanMgr q;
  private MqqHandler r = null;
  private TransProcessorHandler t;
  
  public SmartDeviceProxyMgr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    try
    {
      this.r = new MqqHandler(ThreadManager.getSubThreadLooper(), new SmartDeviceProxyMgr.1(this));
      label110:
      this.t = new SmartDeviceProxyMgr.4(this, ThreadManager.getSubThreadLooper());
      this.o = paramQQAppInterface;
      c("SmartDeviceProxyMgr create");
      if (this.r != null)
      {
        this.k = SettingCloneUtil.readValueForInt(BaseApplication.getContext(), paramQQAppInterface.getCurrentAccountUin(), null, "qqsetting_deviceplugin_bind_flag", 0);
        this.e = new SmartDeviceProxyMgr.BroadcastHandler(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("SmartDevice_devListChang");
        localIntentFilter.addAction("onDeviceDisconnected");
        localIntentFilter.addAction("onDeviceLogined");
        localIntentFilter.addAction("SmartDevice_login");
        localIntentFilter.addAction("SmartDevice_clickOnDeviceList");
        localIntentFilter.addAction("onQFindLostDeviceList");
        localIntentFilter.addAction("SmartDevice_devListChangeUI");
        localIntentFilter.addAction("SmartDevice_DeviceBindRst");
        localIntentFilter.addAction("mqq.intent.action.LOGOUT");
        localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
        localIntentFilter.addAction("SmartDevice_receiveDPMsg");
        BaseApplicationImpl.getContext().registerReceiver(this.e, localIntentFilter);
        this.r.sendEmptyMessageDelayed(1002, 300000L);
        this.r.sendEmptyMessageDelayed(1001, 30000L);
        if (!StringUtil.isEmpty(paramQQAppInterface.getCurrentUin())) {
          this.n = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class));
        }
        if (this.n != null)
        {
          this.t.addFilter(new Class[] { BDHCommonUploadProcessor.class });
          this.n.addHandle(this.t);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label110;
    }
  }
  
  public static DeviceInfo a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.g(paramLong);
    }
    return null;
  }
  
  private void a(int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    a(null);
    this.b.clear();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "login");
    localBundle.putInt("iAppID", paramInt);
    localBundle.putLong("uin", paramLong);
    localBundle.putByteArray("a2", paramArrayOfByte);
    localBundle.putBoolean("forceStart", true);
    if (paramString1 != null) {
      localBundle.putString("strOpenId", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("strAccessToken", paramString2);
    }
    paramArrayOfByte = this.j;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.b(localBundle);
    }
  }
  
  private void a(String paramString1, String paramString2, Boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.o.getApplication().getApplicationContext(), ChatActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(131072);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("bFromLightApp", paramBoolean);
    localIntent.putExtra("uintype", 9501);
    localIntent.putExtra("operType", paramInt1);
    localIntent.putExtra("jumpTab", paramInt2);
    this.o.getApplication().getApplicationContext().startActivity(localIntent);
  }
  
  private void a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    try
    {
      this.a = paramArrayOfDeviceInfo;
      return;
    }
    finally
    {
      paramArrayOfDeviceInfo = finally;
      throw paramArrayOfDeviceInfo;
    }
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SmartDeviceProxyMgr", 2, paramString);
    }
  }
  
  public static String d(int paramInt)
  {
    long l1 = paramInt & 0x7FFFFFFF;
    long l2 = paramInt >> 31 & 0x1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1 | l2 << 31);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  private void e(int paramInt)
  {
    this.k = paramInt;
    if (paramInt == 0)
    {
      QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**setAutoLoadDevicePlugin DEVICE_UNBINED");
      BannerManager.a().a(MsgProxyBannerProcessor.a, 0, null);
      s += 1;
    }
    if (s == 0)
    {
      QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**setAutoLoadDevicePlugin DEVICE_BINED");
      BannerManager.a().a(MsgProxyBannerProcessor.a, 0, null);
      f();
      s += 1;
    }
  }
  
  private DeviceInfo[] m()
  {
    try
    {
      DeviceInfo[] arrayOfDeviceInfo = this.a;
      return arrayOfDeviceInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private QFindConfig n()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getFilesDir());
    ((StringBuilder)localObject).append("/qfindconfig");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      localObject = FileUtils.readFileContent(new File((String)localObject));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = QFindConfigUtil.a((String)localObject);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  private boolean o()
  {
    try
    {
      if (this.j == null)
      {
        c("SmartDeviceProxyMgr::initIPCHost start");
        long l1 = System.currentTimeMillis();
        this.l = true;
        this.j = new SmartDeviceIPCHost(this.o);
        this.o.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
        long l2 = System.currentTimeMillis();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SmartDeviceProxyMgr::initIPCHost init SmartDeviceIPCHost:cost ");
        localStringBuilder.append(l2 - l1);
        c(localStringBuilder.toString());
        return true;
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a(long paramLong, String paramString, int paramInt)
  {
    c("SmartDeviceProxyMgr::sendAudioMsg");
    a(false);
    if (this.j == null) {
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendAudioMsg");
    localBundle.putString("filepath", paramString);
    localBundle.putInt("duration", paramInt);
    localBundle.putLong("din", paramLong);
    paramString = this.j;
    if (paramString != null)
    {
      paramString = paramString.a(localBundle);
      if (paramString != null) {
        return paramString.getInt("cookie");
      }
    }
    return 0;
  }
  
  public int a(long paramLong1, String paramString1, long paramLong2, int paramInt, String paramString2)
  {
    c("SmartDeviceProxyMgr::sendVideoMsg");
    a(false);
    if (this.j == null) {
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendVideoMsg");
    localBundle.putString("filepath", paramString1);
    localBundle.putString("thumbPath", paramString2);
    localBundle.putLong("din", paramLong1);
    localBundle.putLong("filesize", paramLong2);
    localBundle.putInt("duration", paramInt);
    paramString1 = this.j;
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(localBundle);
      if (paramString1 != null) {
        return paramString1.getInt("cookie");
      }
    }
    return 0;
  }
  
  public int a(long paramLong, String paramString1, String paramString2)
  {
    c("SmartDeviceProxyMgr::sendImageMsg");
    a(false);
    if (this.j == null) {
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendImageMsg");
    localBundle.putString("filepath", paramString1);
    localBundle.putString("thumbPath", paramString2);
    localBundle.putLong("din", paramLong);
    paramString1 = this.j;
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(localBundle);
      if (paramString1 != null) {
        return paramString1.getInt("cookie");
      }
    }
    return 0;
  }
  
  public long a(String paramString1, String paramString2, int paramInt)
  {
    c("SmartDeviceProxyMgr::downloadMiniFile");
    a(false);
    if (this.j == null) {
      return 0L;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "downloadMiniFile");
    localBundle.putString("filekey", paramString1);
    localBundle.putInt("filetype", paramInt);
    localBundle.putString("fileKey2", paramString2);
    paramString1 = this.j;
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(localBundle);
      if (paramString1 != null) {
        return paramString1.getLong("cookie");
      }
    }
    return 0L;
  }
  
  public DeviceInfo a(String paramString, int paramInt)
  {
    c("SmartDeviceProxyMgr::getDeviceInfoBySerialNum");
    int i1 = 0;
    a(false);
    if (this.j == null) {
      return null;
    }
    Object localObject = m();
    if (localObject != null) {
      while (i1 < localObject.length)
      {
        if ((paramString.compareToIgnoreCase(localObject[i1].serialNum) == 0) && (paramInt == localObject[i1].productId)) {
          return localObject[i1];
        }
        i1 += 1;
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getDeviceInfoBySerialNum");
    ((Bundle)localObject).putString("serialNum", paramString);
    ((Bundle)localObject).putInt("pid", paramInt);
    paramString = this.j.a((Bundle)localObject);
    if (paramString == null) {
      return null;
    }
    return (DeviceInfo)paramString.getParcelable("deviceinfo");
  }
  
  @TargetApi(18)
  void a()
  {
    Object localObject1;
    boolean bool1;
    int i2;
    int i1;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject1 = BaseApplication.getContext();
      try
      {
        bool1 = ((Context)localObject1).getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        bool1 = false;
      }
      if (bool1)
      {
        Object localObject2 = this.o.getCurrentAccountUin();
        if (localObject2 != null)
        {
          if ("".equals(localObject2)) {
            return;
          }
          Object localObject3 = ((Context)localObject1).getSharedPreferences("mobileQQ", 4);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("qfind_report_gps_bt_stat");
          localStringBuilder.append((String)localObject2);
          if (((SharedPreferences)localObject3).getBoolean(localStringBuilder.toString(), false))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("qfind_ble_gps_reported");
            localStringBuilder.append((String)localObject2);
            if (!((SharedPreferences)localObject3).getBoolean(localStringBuilder.toString(), false))
            {
              localObject3 = ((SharedPreferences)localObject3).edit();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("qfind_ble_gps_reported");
              localStringBuilder.append((String)localObject2);
              localObject2 = localStringBuilder.toString();
              i2 = 1;
              ((SharedPreferences.Editor)localObject3).putBoolean((String)localObject2, true).commit();
              try
              {
                localObject2 = ((BluetoothManager)((Context)localObject1).getSystemService("bluetooth")).getAdapter();
                if (localObject2 == null)
                {
                  i1 = 0;
                }
                else
                {
                  if (((BluetoothAdapter)localObject2).isEnabled()) {
                    break label465;
                  }
                  i1 = 1;
                }
                SmartDeviceReport.a(null, "QFind_BleState", i1, 0, 0);
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("QFind_BleState bleResult=");
                  ((StringBuilder)localObject2).append(i1);
                  QLog.i("QFind", 2, ((StringBuilder)localObject2).toString());
                }
              }
              catch (Throwable localThrowable3)
              {
                localThrowable3.printStackTrace();
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      boolean bool2;
      try
      {
        localObject1 = (LocationManager)((Context)localObject1).getSystemService("location");
        bool1 = ((LocationManager)localObject1).isProviderEnabled("gps");
        bool2 = ((LocationManager)localObject1).isProviderEnabled("network");
        if ((!bool1) || (!bool2)) {
          break label470;
        }
        i1 = i2;
        SmartDeviceReport.a(null, "QFind_GPSState", i1, 0, 0);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("QFind_GPSState gps=");
          ((StringBuilder)localObject1).append(bool1);
          ((StringBuilder)localObject1).append(", 2g network=");
          ((StringBuilder)localObject1).append(bool2);
          ((StringBuilder)localObject1).append(", gpsResult=");
          ((StringBuilder)localObject1).append(i1);
          QLog.i("QFind", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      return;
      label465:
      i1 = 2;
      break;
      label470:
      if (bool1) {
        i1 = 2;
      } else if (bool2) {
        i1 = 3;
      } else {
        i1 = 0;
      }
    }
  }
  
  public void a(int paramInt)
  {
    s = 0;
    e(paramInt);
    SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.o.getCurrentAccountUin(), null, "qqsetting_deviceplugin_bind_flag", this.k);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(false);
    if (paramInt == 39) {
      return;
    }
    if (paramInt == 111)
    {
      paramInt = paramBundle.getInt("msgtype", 0);
      int i1 = paramBundle.getInt("devtime", 0);
      long l1 = paramBundle.getLong("din", 0L);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("PushLostDevFound msgtype[");
        paramBundle.append(paramInt);
        paramBundle.append("], devtime=[");
        paramBundle.append(i1);
        paramBundle.append("], din[");
        paramBundle.append(l1);
        paramBundle.append("].");
        QLog.d("QFind", 2, paramBundle.toString());
      }
      a(false);
      paramBundle = new Bundle();
      paramBundle.putString("notify_cmd", "updateLostStatus");
      SmartDeviceIPCHost localSmartDeviceIPCHost = this.j;
      if (localSmartDeviceIPCHost != null) {
        localSmartDeviceIPCHost.b(paramBundle);
      }
      if (paramInt == 2) {
        return;
      }
      if (paramInt == 6)
      {
        a(l1, i1, HardCodeUtil.a(2131911611));
        return;
      }
      if (paramInt == 7) {
        return;
      }
      if (paramInt == 8)
      {
        a(l1, i1, HardCodeUtil.a(2131911610));
        return;
      }
      if (paramInt == 9) {
        a(l1, i1, HardCodeUtil.a(2131911616));
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    c("SmartDeviceProxyMgr::queryIsDeviceHasBeenBinded");
    a(false);
    if (this.j == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "queryIsDeviceHasBeenBinded");
    localBundle.putInt("productId", paramInt);
    localBundle.putString("serialNum", paramString);
    this.j.b(localBundle);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    c("SmartDeviceProxyMgr::setDeviceVasFlag");
    a(false);
    if (this.j == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "setDeviceVasFlag");
    localBundle.putInt("bitCount", paramInt2);
    localBundle.putInt("beginIndex", paramInt1);
    localBundle.putInt("bitValue", paramInt3);
    localBundle.putLong("din", paramLong);
    SmartDeviceIPCHost localSmartDeviceIPCHost = this.j;
    if (localSmartDeviceIPCHost != null) {
      localSmartDeviceIPCHost.b(localBundle);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceive Push Msg : ");
    ((StringBuilder)localObject).append(paramString);
    c(((StringBuilder)localObject).toString());
    b();
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "notifyCmdReceivePush");
    ((Bundle)localObject).putLong("fromUin", paramLong1);
    ((Bundle)localObject).putLong("toUin", paramLong2);
    ((Bundle)localObject).putInt("msgSeq", paramInt1);
    ((Bundle)localObject).putLong("msgUid", paramLong3);
    ((Bundle)localObject).putInt("msgType", paramInt2);
    ((Bundle)localObject).putBoolean("forceStart", true);
    if (paramString != null) {
      ((Bundle)localObject).putString("sServiceCmd", paramString);
    }
    if (paramArrayOfByte != null) {
      ((Bundle)localObject).putByteArray("buffer", paramArrayOfByte);
    }
    paramString = this.j;
    if (paramString != null) {
      paramString.b((Bundle)localObject);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString) {}
  
  public void a(long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    c("SmartDeviceProxyMgr::sendStructingShareMsg");
    a(false);
    if ((paramAbsStructMsg != null) && ((paramAbsStructMsg instanceof AbsShareMsg)))
    {
      Object localObject1 = new DataPoint();
      Object localObject2 = (AbsShareMsg)paramAbsStructMsg;
      if (paramAbsStructMsg.mMsgServiceID == 2) {
        ((DataPoint)localObject1).mProperityId = 11003;
      } else if (paramAbsStructMsg.mMsgServiceID == 32) {
        ((DataPoint)localObject1).mProperityId = 32;
      } else if (paramAbsStructMsg.mMsgServiceID == 1) {
        ((DataPoint)localObject1).mProperityId = 11005;
      }
      ((DataPoint)localObject1).mApiName = "set_data_point";
      ((DataPoint)localObject1).mDin = paramLong;
      try
      {
        ((DataPoint)localObject1).mValue = new JSONObject().put("msg_time", (int)MessageCache.c()).put("senderDin", paramLong).put("msgUrl", ((AbsShareMsg)localObject2).mMsgUrl).put("contentSrc", ((AbsShareMsg)localObject2).mContentSrc).put("contentCover", ((AbsShareMsg)localObject2).mContentCover).put("contentTitle", ((AbsShareMsg)localObject2).mContentTitle).put("contentSummary", ((AbsShareMsg)localObject2).mContentSummary).put("msgAction", ((AbsShareMsg)localObject2).mMsgAction).put("msgActionData", ((AbsShareMsg)localObject2).mMsgActionData).put("msg_A_ActionData", ((AbsShareMsg)localObject2).mMsg_A_ActionData).put("msg_I_ActionData", ((AbsShareMsg)localObject2).mMsg_I_ActionData).put("sourceAppid", ((AbsShareMsg)localObject2).mSourceAppid).put("sourceUrl", ((AbsShareMsg)localObject2).mSourceUrl).put("sourceAction", ((AbsShareMsg)localObject2).mSourceAction).put("sourceActionData", ((AbsShareMsg)localObject2).mSourceActionData).put("source_A_ActionData", ((AbsShareMsg)localObject2).mSource_A_ActionData).put("source_I_ActionData", ((AbsShareMsg)localObject2).mSource_I_ActionData).put("sourceIcon", ((AbsShareMsg)localObject2).mSourceIcon).put("sourceName", ((AbsShareMsg)localObject2).mSourceName).put("msgBrief", ((AbsShareMsg)localObject2).mMsgBrief).put("fileName", ((AbsShareMsg)localObject2).mFileName).put("fileSize", ((AbsShareMsg)localObject2).mFileSize).put("compatibleText", ((AbsShareMsg)localObject2).mCompatibleText).toString();
      }
      catch (JSONException paramAbsStructMsg)
      {
        paramAbsStructMsg.printStackTrace();
      }
      ((DataPoint)localObject1).mValueType = "string";
      paramAbsStructMsg = new Bundle();
      paramAbsStructMsg.putParcelable("datapoint", (Parcelable)localObject1);
      paramAbsStructMsg.putLong("din", paramLong);
      paramAbsStructMsg.putString("notify_cmd", "sendStructMsg");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SmartDeviceProxyMgr::sendStructingShareMsg dataPoint.mValue = ");
      ((StringBuilder)localObject2).append(((DataPoint)localObject1).mValue);
      c(((StringBuilder)localObject2).toString());
      localObject1 = this.j;
      if (localObject1 != null) {
        ((SmartDeviceIPCHost)localObject1).b(paramAbsStructMsg);
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, Bundle paramBundle)
  {
    c("SmartDeviceProxyMgr::sendCloudPrintCmd");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCloudPrintCmd");
    localBundle.putLong("din", paramLong);
    localBundle.putString("fileIndex", paramString1);
    localBundle.putString("jobId", paramString2);
    localBundle.putString("fileName", paramString3);
    localBundle.putInt("fileType", paramInt);
    localBundle.putBundle("otherParams", paramBundle);
    paramString1 = this.j;
    if (paramString1 != null) {
      paramString1.b(localBundle);
    }
  }
  
  public void a(Activity paramActivity, DeviceInfo paramDeviceInfo, boolean paramBoolean)
  {
    a(paramActivity, paramDeviceInfo, paramBoolean, null);
  }
  
  public void a(Activity paramActivity, DeviceInfo paramDeviceInfo, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("liteAppEntry:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("SDKQQAgentPerf", 2, localStringBuilder.toString());
    }
    a(false);
    if (paramDeviceInfo == null)
    {
      ToastUtil.a().a(HardCodeUtil.a(2131911619));
      return;
    }
    paramDeviceInfo.displayName = SmartDeviceUtil.a(paramDeviceInfo);
    new LightAppUtil(paramActivity).a(paramDeviceInfo, paramBundle, paramBoolean);
  }
  
  public void a(Bundle paramBundle)
  {
    c("SmartDeviceProxyMgr::InvokeOpenChatMsgActivity");
    if ((this.o != null) && (paramBundle != null))
    {
      String str1 = paramBundle.getString("din");
      String str2 = paramBundle.getString("devName");
      Boolean localBoolean = Boolean.valueOf(paramBundle.getBoolean("bFromLightApp", false));
      int i1 = paramBundle.getInt("operType");
      int i2 = paramBundle.getInt("jumpTab");
      paramBundle = Looper.getMainLooper();
      if (Thread.currentThread() != paramBundle.getThread())
      {
        new Handler(paramBundle).post(new SmartDeviceProxyMgr.3(this, str1, str2, localBoolean, i1, i2));
        return;
      }
      a(str1, str2, localBoolean, i1, i2);
      return;
    }
    c("in SmartDeviceProxyMgr InvokeOpenChatMsgActivity app is null or params is null");
  }
  
  public void a(DataPoint paramDataPoint, int paramInt1, long paramLong, int paramInt2)
  {
    c("SmartDeviceProxyMgr::sendCCDataPointMsg");
    a(false);
    if (this.j == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCCDataPointMsg");
    localBundle.putParcelable("datapoint", paramDataPoint);
    localBundle.putInt("cookie", paramInt1);
    localBundle.putLong("din", paramLong);
    localBundle.putInt("lifetime", paramInt2);
    this.j.b(localBundle);
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new SmartDeviceProxyMgr.2(this, paramConfig));
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    c("SmartDeviceProxyMgr::sendTextMsg");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendTextMsg");
    localBundle.putLong("din", paramLong1);
    localBundle.putString("text", paramString);
    localBundle.putLong("msg_time", paramLong2);
    localBundle.putLong("msgSeq", paramLong3);
    paramString = this.j;
    if (paramString != null) {
      paramString.b(localBundle);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getFilesDir());
    ((StringBuilder)localObject).append("/qfindpidlist");
    localObject = ((StringBuilder)localObject).toString();
    if (paramBoolean) {
      FileUtils.deleteFile((String)localObject);
    } else if (paramString != null) {
      FileUtils.writeFile((String)localObject, paramString);
    }
    try
    {
      paramString = FileUtils.readFileContent(new File((String)localObject));
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString).getJSONArray("pidlist");
        this.d.clear();
        int i1 = 0;
        while (i1 < paramString.length())
        {
          long l1 = paramString.getLong(i1);
          this.d.add(Long.valueOf(l1));
          i1 += 1;
        }
      }
      if (paramString.size() <= 0) {
        break label294;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      paramString = this.d;
      if (paramString == null) {
        break label294;
      }
    }
    paramString = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
    localObject = this.o.getCurrentAccountUin();
    if (localObject != null)
    {
      if ("".equals(localObject)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qfind_assist");
      localStringBuilder.append((String)localObject);
      paramString = paramString.getString(localStringBuilder.toString(), "0");
      if (TextUtils.isEmpty(paramString)) {}
    }
    try
    {
      this.i = Integer.parseInt(paramString);
    }
    catch (Exception paramString)
    {
      label260:
      break label260;
    }
    this.i = 0;
    if ((this.i + this.h > 1) && (this.q != null))
    {
      n();
      break label294;
      return;
    }
    label294:
    if ((this.d != null) && (QLog.isColorLevel()))
    {
      paramString = new StringBuilder();
      paramString.append("qfind pid count=");
      paramString.append(this.d.size());
      QLog.w("QFind", 2, paramString.toString());
    }
  }
  
  public void a(ArrayList<LightAppSettingInfo> paramArrayList)
  {
    c("SmartDeviceProxyMgr::transferAppSettingList");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "transferLiteAppSettingList");
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localBundle.putParcelableArrayList("settinglist", paramArrayList);
    }
    paramArrayList = this.j;
    if (paramArrayList != null) {
      paramArrayList.b(localBundle);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startPlugin flag:");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append(" ipc:");
    ((StringBuilder)localObject).append(this.j);
    c(((StringBuilder)localObject).toString());
    if (this.k != 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SmartDeviceProxyMgr::startPlugin, forceRefresh: ");
    if (paramBoolean) {
      localObject = "yes";
    } else {
      localObject = "no";
    }
    localStringBuilder.append((String)localObject);
    c(localStringBuilder.toString());
    if (o()) {
      b(paramBoolean);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SubMsgType0x90.MsgBody();
    try
    {
      ((SubMsgType0x90.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      int i1 = ((SubMsgType0x90.MsgBody)localObject).msg_head.uint32_cmd.get();
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        paramArrayOfByte = ((SubMsgType0x90.MsgBody)localObject).msg_body.msg_occupy_microphone_body;
        localObject = new Intent();
        ((Intent)localObject).setAction("On_OccupyMicrophoneNotify_Push");
        ((Intent)localObject).putExtra("din", paramArrayOfByte.uint64_din.get());
        ((Intent)localObject).putExtra("uin", d(paramArrayOfByte.uint32_uin.get()));
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.smartdevice.permission.broadcast");
        return;
      }
      paramArrayOfByte = ((SubMsgType0x90.MsgBody)localObject).msg_body.msg_dp_notify_body;
      localObject = new Intent();
      ((Intent)localObject).setAction("On_DpNotify_Push");
      ((Intent)localObject).putExtra("productid", paramArrayOfByte.uint32_pid.get());
      ((Intent)localObject).putExtra("din", paramArrayOfByte.uint64_din.get());
      ((Intent)localObject).putExtra("extras", paramArrayOfByte.string_extend_info.get());
      int[] arrayOfInt = new int[paramArrayOfByte.rpt_msg_notify_info.size()];
      i1 = 0;
      while (i1 < paramArrayOfByte.rpt_msg_notify_info.size())
      {
        arrayOfInt[i1] = ((SubMsgType0x90.NotifyItem)paramArrayOfByte.rpt_msg_notify_info.get(i1)).uint32_propertyid.get();
        i1 += 1;
      }
      ((Intent)localObject).putExtra("pids", arrayOfInt);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.smartdevice.permission.broadcast");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label245:
      break label245;
    }
    c("onRecvPush0x210_0x90, parse error");
  }
  
  public boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    c("SmartDeviceProxyMgr::datalineSendCSMsg");
    a(false);
    if (this.j == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "datalineSendCSMsg");
    localBundle.putInt("subType", paramInt1);
    localBundle.putInt("cookie", paramInt2);
    localBundle.putByteArray("data", paramArrayOfByte);
    this.j.b(localBundle);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return this.c.contains(Long.valueOf(paramLong));
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    Object localObject = g(paramLong);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = b(((DeviceInfo)localObject).productId);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((ProductInfo)localObject).deviceType == paramInt) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    c("SmartDeviceProxyMgr::datalineSendCCMsg");
    a(false);
    if (this.j == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "datalineSendCCMsg");
    localBundle.putLong("din", paramLong);
    localBundle.putInt("sendCookie", paramInt);
    localBundle.putByteArray("bodyContent", paramArrayOfByte);
    this.j.b(localBundle);
    return true;
  }
  
  public boolean a(String paramString)
  {
    return b(Long.parseLong(paramString));
  }
  
  public long b(String paramString, int paramInt)
  {
    c("SmartDeviceProxyMgr::uploadMiniFile");
    a(false);
    if (this.j == null) {
      return 0L;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "uploadMiniFile");
    localBundle.putString("filepath", paramString);
    localBundle.putInt("filetype", paramInt);
    paramString = this.j;
    if (paramString != null)
    {
      paramString = paramString.a(localBundle);
      if (paramString != null) {
        return paramString.getLong("cookie");
      }
    }
    return 0L;
  }
  
  public ProductInfo b(int paramInt)
  {
    a(false);
    if (this.j == null) {
      return null;
    }
    if (this.b.containsKey(Integer.valueOf(paramInt))) {
      return (ProductInfo)this.b.get(Integer.valueOf(paramInt));
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getProductInfo");
    ((Bundle)localObject).putInt("productId", paramInt);
    localObject = this.j.a((Bundle)localObject);
    if (localObject == null) {
      return null;
    }
    localObject = (ProductInfo)((Bundle)localObject).getParcelable("productInfo");
    this.b.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPlugin force flag:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" ipc:");
    localStringBuilder.append(this.j);
    c(localStringBuilder.toString());
    if (o()) {
      b(false);
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    c("SmartDeviceProxyMgr::sendToDealTipCmd");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendDealTipCmd");
    localBundle.putString("uin", this.o.getCurrentAccountUin());
    localBundle.putLong("din", paramLong);
    localBundle.putInt("productId", paramInt);
    SmartDeviceIPCHost localSmartDeviceIPCHost = this.j;
    if (localSmartDeviceIPCHost != null) {
      localSmartDeviceIPCHost.b(localBundle);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("LocalPath");
    String str2 = paramBundle.getString("PeerUin");
    long l1 = paramBundle.getLong("Uniseq");
    paramBundle = new TransferRequest();
    paramBundle.mIsUp = true;
    paramBundle.mCommandId = 7;
    paramBundle.mLocalPath = str1;
    paramBundle.mPeerUin = str2;
    paramBundle.mUniseq = l1;
    paramBundle.mFileType = 24;
    paramBundle.mRichTag = "facePicUploadProcess";
    this.n.transferAsync(paramBundle);
  }
  
  public void b(String paramString)
  {
    this.p = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SmartDeviceProxyMgr::loginAndFetchDeviceListInternal, forceRefresh: ");
        if (paramBoolean)
        {
          String str1 = "yes";
          localStringBuilder.append(str1);
          c(localStringBuilder.toString());
          if ((1 != this.f) && (1 != this.g))
          {
            if (paramBoolean)
            {
              this.f = 0;
              this.g = 0;
            }
            if (((this.f == 0) || (3 == this.f)) && (this.o != null) && (this.o.getCurrentAccountUin() != null))
            {
              a(1300000607, Long.parseLong(this.o.getCurrentAccountUin()), k(), "", "");
              this.f = 1;
            }
            return;
          }
          return;
        }
      }
      finally {}
      String str2 = "no";
    }
  }
  
  public boolean b(long paramLong)
  {
    if (f(paramLong).booleanValue()) {
      return true;
    }
    Object localObject = g(paramLong);
    if (localObject == null) {
      return false;
    }
    if (((DeviceInfo)localObject).SSOBid_Platform == 1027) {
      return true;
    }
    if (((DeviceInfo)localObject).SSOBid_Version == null) {
      return false;
    }
    if ((((DeviceInfo)localObject).SSOBid_Platform == 0) && (((DeviceInfo)localObject).SSOBid_Version.equals(""))) {
      return true;
    }
    localObject = ((DeviceInfo)localObject).SSOBid_Version.split("\\.");
    if (localObject != null)
    {
      if (localObject.length < 2) {
        return false;
      }
      if (Integer.parseInt(localObject[0]) < 1) {
        return false;
      }
      return (Integer.parseInt(localObject[0]) != 1) || (Integer.parseInt(localObject[1]) >= 1);
    }
    return false;
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
    SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.o.getCurrentAccountUin(), null, "qqsetting_antilost_key", this.h);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qfind mQfindAssist=");
      localStringBuilder.append(this.h);
      QLog.w("QFind", 2, localStringBuilder.toString());
    }
  }
  
  public boolean c()
  {
    return this.k == 1;
  }
  
  public boolean c(long paramLong)
  {
    Object localObject = g(paramLong);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = b(((DeviceInfo)localObject).productId);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((ProductInfo)localObject).uConnectType == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int d(long paramLong)
  {
    Object localObject = g(paramLong);
    int i3 = 0;
    int i2 = 0;
    int i1 = i3;
    if (localObject != null)
    {
      localObject = b(((DeviceInfo)localObject).productId);
      i1 = i3;
      if (localObject != null)
      {
        if (((ProductInfo)localObject).isSupportMainMsgType(8)) {
          i2 = 8;
        }
        i1 = i2;
        if (((ProductInfo)localObject).isSupportMainMsgType(2)) {
          i1 = i2 | 0x1;
        }
        i2 = i1;
        if (((ProductInfo)localObject).isSupportFuncMsgType(1)) {
          i2 = i1 | 0x4;
        }
        i1 = i2;
        if (((ProductInfo)localObject).isSupportFuncMsgType(2)) {
          i1 = i2 | 0x2;
        }
      }
    }
    return i1;
  }
  
  public ArrayList<LightAppSettingInfo> d()
  {
    c("SmartDeviceProxyMgr::getLiteAppSettingList");
    a(false);
    if (this.j == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getLiteAppSettingList");
    localBundle = this.j.a(localBundle);
    if (localBundle == null) {
      return null;
    }
    return localBundle.getParcelableArrayList("settinglist");
  }
  
  public void e(long paramLong)
  {
    QLog.d("SmartDeviceProxyMgr", 2, "sendUinSkeyMsg begin");
    if (!c()) {
      return;
    }
    Object localObject1 = new cmd0xac7.ReqBody();
    ((cmd0xac7.ReqBody)localObject1).uint32_cmd.set(443);
    ((cmd0xac7.ReqBody)localObject1).uint64_din.set(paramLong);
    Object localObject3 = this.o.getAccount();
    if (localObject3 == null) {
      return;
    }
    Object localObject2 = new cmd0xac7.BinderSig();
    ((cmd0xac7.BinderSig)localObject2).uint32_type.set(1);
    ((cmd0xac7.BinderSig)localObject2).uint64_uin.set(Long.valueOf((String)localObject3).longValue());
    localObject3 = (TicketManager)this.o.getManager(2);
    ((cmd0xac7.BinderSig)localObject2).bytes_sig.set(ByteStringMicro.copyFromUtf8(((TicketManager)localObject3).getSkey(this.o.getAccount())));
    ((cmd0xac7.ReqBody)localObject1).msg_binder_sig.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2759);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xac7.ReqBody)localObject1).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", this.o.getCurrentAccountUin(), "OidbSvc_device.0xac7");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public DeviceInfo[] e()
  {
    a(false);
    if (this.j == null) {
      return null;
    }
    DeviceInfo[] arrayOfDeviceInfo = m();
    if (arrayOfDeviceInfo == null)
    {
      MqqHandler localMqqHandler = this.r;
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1003);
      }
    }
    return arrayOfDeviceInfo;
  }
  
  public Boolean f(long paramLong)
  {
    c("SmartDeviceProxyMgr::isVasFlagEnable");
    Boolean localBoolean = Boolean.valueOf(false);
    a(false);
    if (this.j == null) {
      return localBoolean;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "isVasFlagEnable");
    localBundle.putInt("bitIndex", 0);
    localBundle.putLong("din", paramLong);
    SmartDeviceIPCHost localSmartDeviceIPCHost = this.j;
    if (localSmartDeviceIPCHost != null)
    {
      localBundle = localSmartDeviceIPCHost.a(localBundle);
      if (localBundle != null) {
        return Boolean.valueOf(localBundle.getBoolean("isVasFlagEnable"));
      }
    }
    return localBoolean;
  }
  
  public void f()
  {
    QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**sendMsgProxy");
    if (!c()) {
      return;
    }
    Object localObject1 = new cmd0xac7.ReqBody();
    ((cmd0xac7.ReqBody)localObject1).uint32_cmd.set(442);
    QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**sendMsgProxy ...");
    Object localObject2 = this.o.getCurrentAccountUin();
    if (localObject2 == null) {
      return;
    }
    ((cmd0xac7.ReqBody)localObject1).uint64_din.set(Long.valueOf((String)localObject2).longValue());
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2759);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xac7.ReqBody)localObject1).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", this.o.getCurrentAccountUin(), "OidbSvc_device.0xac7");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public DeviceInfo g(long paramLong)
  {
    c("SmartDeviceProxyMgr::getDeviceInfoByDin");
    int i1 = 0;
    a(false);
    if (this.j == null) {
      return new DeviceInfo();
    }
    Object localObject = m();
    if (localObject != null) {
      while (i1 < localObject.length)
      {
        if (paramLong == localObject[i1].din) {
          return localObject[i1];
        }
        i1 += 1;
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getinfobydin");
    ((Bundle)localObject).putLong("din", paramLong);
    localObject = this.j.a((Bundle)localObject);
    if (localObject == null) {
      return new DeviceInfo();
    }
    return (DeviceInfo)((Bundle)localObject).getParcelable("deviceinfo");
  }
  
  public void g()
  {
    if ((this.l) && (2 == this.f))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("notify_cmd", "logout");
      SmartDeviceIPCHost localSmartDeviceIPCHost = this.j;
      if (localSmartDeviceIPCHost != null) {
        localSmartDeviceIPCHost.b(localBundle);
      }
    }
    this.f = 0;
    this.g = 0;
    QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**logout");
    BannerManager.a().a(MsgProxyBannerProcessor.a, 0, null);
  }
  
  public void h()
  {
    c("SmartDeviceProxyMgr::updateDeviceStatus");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "updateDeviceStatus");
    SmartDeviceIPCHost localSmartDeviceIPCHost = this.j;
    if (localSmartDeviceIPCHost != null) {
      localSmartDeviceIPCHost.b(localBundle);
    }
  }
  
  public boolean h(long paramLong)
  {
    c("SmartDeviceProxyMgr::isDeviceHasUpdate");
    Object localObject = this.j;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "isDeviceHasUpdate");
    ((Bundle)localObject).putLong("din", paramLong);
    localObject = this.j.a((Bundle)localObject);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Bundle)localObject).getBoolean("hasUpdate", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long i()
  {
    c("SmartDeviceProxyMgr::getSelfUin");
    a(false);
    if (this.j == null) {
      return 0L;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getselfuin");
    localBundle = this.j.a(localBundle);
    long l1;
    if (localBundle != null) {
      l1 = localBundle.getLong("selfuin", 0L);
    } else {
      l1 = 0L;
    }
    if (l1 != 0L) {
      this.m = l1;
    }
    return this.m;
  }
  
  public String j()
  {
    TicketManager localTicketManager = (TicketManager)this.o.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getA2(this.o.getCurrentAccountUin());
    }
    return "";
  }
  
  public byte[] k()
  {
    String str = j();
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("device login,a2 len is:");
      localStringBuilder.append(str.length());
      c(localStringBuilder.toString());
      return HexUtil.hexStr2Bytes(j());
    }
    return HexUtil.hexStr2Bytes("");
  }
  
  public String l()
  {
    return this.p;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return SmartDeviceObserver.class;
  }
  
  public void onDestroy()
  {
    c("SmartDeviceProxyMgr onDestroy");
    super.onDestroy();
    if (this.e != null) {
      try
      {
        if (BaseApplicationImpl.getContext() != null) {
          BaseApplicationImpl.getContext().unregisterReceiver(this.e);
        }
        this.e = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Object localObject = this.r;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
      this.r = null;
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((ITransFileController)localObject).removeHandle(this.t);
      this.n.onDestroy();
      this.n = null;
    }
    localObject = this.t;
    if (localObject != null)
    {
      ((TransProcessorHandler)localObject).getFilter().clear();
      this.t.removeCallbacksAndMessages(null);
      this.t = null;
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((SmartDeviceIPCHost)localObject).a();
      this.j = null;
    }
    localObject = this.q;
    if (localObject != null)
    {
      ((QFindBLEScanMgr)localObject).c();
      this.q = null;
    }
    if (this.a != null) {
      this.a = null;
    }
    this.b.clear();
    this.b = null;
    this.c.clear();
    this.c = null;
    this.d.clear();
    this.d = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      Object localObject1;
      if ("QFindSvc.ReqReportDevs".equals(paramToServiceMsg.getServiceCmd()))
      {
        localObject1 = this.q;
        if (localObject1 != null) {
          ((QFindBLEScanMgr)localObject1).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
        return;
      }
      if ("OidbSvc_device.0xac7".equals(paramToServiceMsg.getServiceCmd()))
      {
        QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**onReceive sendMsgProxy");
        if (paramFromServiceMsg.isSuccess()) {
          try
          {
            QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**onReceive sendMsgProxy...");
            localObject1 = new cmd0xac7.RspBody();
            Object localObject2 = new oidb_sso.OIDBSSOPkg();
            ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom(paramFromServiceMsg.getWupBuffer());
            ((cmd0xac7.RspBody)localObject1).mergeFrom(((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray());
            localObject2 = new cmd0xac7.ReceiveMessageDevices();
            ((cmd0xac7.ReceiveMessageDevices)localObject2).mergeFrom(((cmd0xac7.RspBody)localObject1).bytes_extd.get().toByteArray());
            if (((cmd0xac7.ReceiveMessageDevices)localObject2).rpt_devices.size() > 0)
            {
              localObject2 = (cmd0xac7.DeviceInfo)((cmd0xac7.ReceiveMessageDevices)localObject2).rpt_devices.get(0);
              if (localObject2 != null)
              {
                localObject1 = ((cmd0xac7.DeviceInfo)localObject2).bytes_name.get().toStringUtf8();
                long l1 = ((cmd0xac7.DeviceInfo)localObject2).uint64_din.get();
                localObject2 = Message.obtain();
                ((Message)localObject2).what = 3000;
                ((Message)localObject2).obj = new Pair(Long.valueOf(l1), localObject1);
                BannerManager.a().a(MsgProxyBannerProcessor.a, 2, (Message)localObject2);
              }
            }
            else
            {
              BannerManager.a().a(MsgProxyBannerProcessor.a, 0, null);
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            BannerManager.a().a(MsgProxyBannerProcessor.a, 0, null);
          }
        }
      }
    }
    c("onReceive Ack Msg");
    b();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "notifyCmdReceiveData");
    if (paramToServiceMsg != null) {
      localBundle.putParcelable("req", paramToServiceMsg);
    }
    if (paramFromServiceMsg != null) {
      localBundle.putParcelable("res", paramFromServiceMsg);
    }
    if (paramObject != null) {
      localBundle.putByteArray("data", (byte[])paramObject);
    }
    localBundle.putBoolean("forceStart", true);
    paramToServiceMsg = this.j;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.b(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.devicemgr.SmartDeviceProxyMgr
 * JD-Core Version:    0.7.0.1
 */