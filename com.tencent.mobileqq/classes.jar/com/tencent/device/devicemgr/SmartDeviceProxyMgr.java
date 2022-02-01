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
  private static int f;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  SmartDeviceProxyMgr.BroadcastHandler jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr$BroadcastHandler = null;
  private QFindBLEScanMgr jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler;
  private ITransFileController jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController;
  private SmartDeviceIPCHost jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
  private String jdField_a_of_type_JavaLangString;
  ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Integer, ProductInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = null;
  private boolean jdField_a_of_type_Boolean = false;
  DeviceInfo[] jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = null;
  public int b;
  ArrayList<Long> b;
  int c = 0;
  int d = 0;
  private int e = 0;
  
  public SmartDeviceProxyMgr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    try
    {
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), new SmartDeviceProxyMgr.1(this));
      label110:
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new SmartDeviceProxyMgr.4(this, ThreadManager.getSubThreadLooper());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      b("SmartDeviceProxyMgr create");
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.e = SettingCloneUtil.readValueForInt(BaseApplication.getContext(), paramQQAppInterface.getCurrentAccountUin(), null, "qqsetting_deviceplugin_bind_flag", 0);
        this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr$BroadcastHandler = new SmartDeviceProxyMgr.BroadcastHandler(this);
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
        BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr$BroadcastHandler, localIntentFilter);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1002, 300000L);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1001, 30000L);
        if (!StringUtil.a(paramQQAppInterface.getCurrentUin())) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
          this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
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
      return paramQQAppInterface.a(paramLong);
    }
    return null;
  }
  
  private QFindConfig a()
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
  
  public static String a(int paramInt)
  {
    long l1 = paramInt & 0x7FFFFFFF;
    long l2 = paramInt >> 31 & 0x1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1 | l2 << 31);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, long paramLong, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    a(null);
    this.jdField_a_of_type_JavaUtilHashMap.clear();
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
    paramArrayOfByte = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(localBundle);
    }
  }
  
  private void a(String paramString1, String paramString2, Boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), ChatActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(131072);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("bFromLightApp", paramBoolean);
    localIntent.putExtra("uintype", 9501);
    localIntent.putExtra("operType", paramInt1);
    localIntent.putExtra("jumpTab", paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().startActivity(localIntent);
  }
  
  private void a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    try
    {
      this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = paramArrayOfDeviceInfo;
      return;
    }
    finally
    {
      paramArrayOfDeviceInfo = finally;
      throw paramArrayOfDeviceInfo;
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SmartDeviceProxyMgr", 2, paramString);
    }
  }
  
  private boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null)
      {
        b("SmartDeviceProxyMgr::initIPCHost start");
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost = new SmartDeviceIPCHost(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
        long l2 = System.currentTimeMillis();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SmartDeviceProxyMgr::initIPCHost init SmartDeviceIPCHost:cost ");
        localStringBuilder.append(l2 - l1);
        b(localStringBuilder.toString());
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
  
  private DeviceInfo[] b()
  {
    try
    {
      DeviceInfo[] arrayOfDeviceInfo = this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo;
      return arrayOfDeviceInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(int paramInt)
  {
    this.e = paramInt;
    if (paramInt == 0)
    {
      QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**setAutoLoadDevicePlugin DEVICE_UNBINED");
      BannerManager.a().a(MsgProxyBannerProcessor.jdField_a_of_type_Int, 0, null);
      f += 1;
    }
    if (f == 0)
    {
      QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**setAutoLoadDevicePlugin DEVICE_BINED");
      BannerManager.a().a(MsgProxyBannerProcessor.jdField_a_of_type_Int, 0, null);
      c();
      f += 1;
    }
  }
  
  public int a(long paramLong)
  {
    Object localObject = a(paramLong);
    int k = 0;
    int j = 0;
    int i = k;
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
      i = k;
      if (localObject != null)
      {
        if (((ProductInfo)localObject).isSupportMainMsgType(8)) {
          j = 8;
        }
        i = j;
        if (((ProductInfo)localObject).isSupportMainMsgType(2)) {
          i = j | 0x1;
        }
        j = i;
        if (((ProductInfo)localObject).isSupportFuncMsgType(1)) {
          j = i | 0x4;
        }
        i = j;
        if (((ProductInfo)localObject).isSupportFuncMsgType(2)) {
          i = j | 0x2;
        }
      }
    }
    return i;
  }
  
  public int a(long paramLong, String paramString, int paramInt)
  {
    b("SmartDeviceProxyMgr::sendAudioMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendAudioMsg");
    localBundle.putString("filepath", paramString);
    localBundle.putInt("duration", paramInt);
    localBundle.putLong("din", paramLong);
    paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
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
    b("SmartDeviceProxyMgr::sendVideoMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendVideoMsg");
    localBundle.putString("filepath", paramString1);
    localBundle.putString("thumbPath", paramString2);
    localBundle.putLong("din", paramLong1);
    localBundle.putLong("filesize", paramLong2);
    localBundle.putInt("duration", paramInt);
    paramString1 = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
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
    b("SmartDeviceProxyMgr::sendImageMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendImageMsg");
    localBundle.putString("filepath", paramString1);
    localBundle.putString("thumbPath", paramString2);
    localBundle.putLong("din", paramLong);
    paramString1 = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(localBundle);
      if (paramString1 != null) {
        return paramString1.getInt("cookie");
      }
    }
    return 0;
  }
  
  public long a()
  {
    b("SmartDeviceProxyMgr::getSelfUin");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return 0L;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getselfuin");
    localBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    long l;
    if (localBundle != null) {
      l = localBundle.getLong("selfuin", 0L);
    } else {
      l = 0L;
    }
    if (l != 0L) {
      this.jdField_a_of_type_Long = l;
    }
    return this.jdField_a_of_type_Long;
  }
  
  public long a(String paramString, int paramInt)
  {
    b("SmartDeviceProxyMgr::uploadMiniFile");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return 0L;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "uploadMiniFile");
    localBundle.putString("filepath", paramString);
    localBundle.putInt("filetype", paramInt);
    paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (paramString != null)
    {
      paramString = paramString.a(localBundle);
      if (paramString != null) {
        return paramString.getLong("cookie");
      }
    }
    return 0L;
  }
  
  public long a(String paramString1, String paramString2, int paramInt)
  {
    b("SmartDeviceProxyMgr::downloadMiniFile");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return 0L;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "downloadMiniFile");
    localBundle.putString("filekey", paramString1);
    localBundle.putInt("filetype", paramInt);
    localBundle.putString("fileKey2", paramString2);
    paramString1 = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (paramString1 != null)
    {
      paramString1 = paramString1.a(localBundle);
      if (paramString1 != null) {
        return paramString1.getLong("cookie");
      }
    }
    return 0L;
  }
  
  public DeviceInfo a(long paramLong)
  {
    b("SmartDeviceProxyMgr::getDeviceInfoByDin");
    int i = 0;
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return new DeviceInfo();
    }
    Object localObject = b();
    if (localObject != null) {
      while (i < localObject.length)
      {
        if (paramLong == localObject[i].din) {
          return localObject[i];
        }
        i += 1;
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getinfobydin");
    ((Bundle)localObject).putLong("din", paramLong);
    localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
    if (localObject == null) {
      return new DeviceInfo();
    }
    return (DeviceInfo)((Bundle)localObject).getParcelable("deviceinfo");
  }
  
  public DeviceInfo a(String paramString, int paramInt)
  {
    b("SmartDeviceProxyMgr::getDeviceInfoBySerialNum");
    int i = 0;
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return null;
    }
    Object localObject = b();
    if (localObject != null) {
      while (i < localObject.length)
      {
        if ((paramString.compareToIgnoreCase(localObject[i].serialNum) == 0) && (paramInt == localObject[i].productId)) {
          return localObject[i];
        }
        i += 1;
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getDeviceInfoBySerialNum");
    ((Bundle)localObject).putString("serialNum", paramString);
    ((Bundle)localObject).putInt("pid", paramInt);
    paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
    if (paramString == null) {
      return null;
    }
    return (DeviceInfo)paramString.getParcelable("deviceinfo");
  }
  
  public ProductInfo a(int paramInt)
  {
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (ProductInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "getProductInfo");
    ((Bundle)localObject).putInt("productId", paramInt);
    localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
    if (localObject == null) {
      return null;
    }
    localObject = (ProductInfo)((Bundle)localObject).getParcelable("productInfo");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public Boolean a(long paramLong)
  {
    b("SmartDeviceProxyMgr::isVasFlagEnable");
    Boolean localBoolean = Boolean.valueOf(false);
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return localBoolean;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "isVasFlagEnable");
    localBundle.putInt("bitIndex", 0);
    localBundle.putLong("din", paramLong);
    SmartDeviceIPCHost localSmartDeviceIPCHost = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (localSmartDeviceIPCHost != null)
    {
      localBundle = localSmartDeviceIPCHost.a(localBundle);
      if (localBundle != null) {
        return Boolean.valueOf(localBundle.getBoolean("isVasFlagEnable"));
      }
    }
    return localBoolean;
  }
  
  public String a()
  {
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    return "";
  }
  
  public ArrayList<LightAppSettingInfo> a()
  {
    b("SmartDeviceProxyMgr::getLiteAppSettingList");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getLiteAppSettingList");
    localBundle = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    if (localBundle == null) {
      return null;
    }
    return localBundle.getParcelableArrayList("settinglist");
  }
  
  @TargetApi(18)
  void a()
  {
    Object localObject1;
    boolean bool1;
    int j;
    int i;
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
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
              j = 1;
              ((SharedPreferences.Editor)localObject3).putBoolean((String)localObject2, true).commit();
              try
              {
                localObject2 = ((BluetoothManager)((Context)localObject1).getSystemService("bluetooth")).getAdapter();
                if (localObject2 == null)
                {
                  i = 0;
                }
                else
                {
                  if (((BluetoothAdapter)localObject2).isEnabled()) {
                    break label465;
                  }
                  i = 1;
                }
                SmartDeviceReport.a(null, "QFind_BleState", i, 0, 0);
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("QFind_BleState bleResult=");
                  ((StringBuilder)localObject2).append(i);
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
        i = j;
        SmartDeviceReport.a(null, "QFind_GPSState", i, 0, 0);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("QFind_GPSState gps=");
          ((StringBuilder)localObject1).append(bool1);
          ((StringBuilder)localObject1).append(", 2g network=");
          ((StringBuilder)localObject1).append(bool2);
          ((StringBuilder)localObject1).append(", gpsResult=");
          ((StringBuilder)localObject1).append(i);
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
      i = 2;
      break;
      label470:
      if (bool1) {
        i = 2;
      } else if (bool2) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public void a(int paramInt)
  {
    f = 0;
    c(paramInt);
    SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_deviceplugin_bind_flag", this.e);
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
      int i = paramBundle.getInt("devtime", 0);
      long l = paramBundle.getLong("din", 0L);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("PushLostDevFound msgtype[");
        paramBundle.append(paramInt);
        paramBundle.append("], devtime=[");
        paramBundle.append(i);
        paramBundle.append("], din[");
        paramBundle.append(l);
        paramBundle.append("].");
        QLog.d("QFind", 2, paramBundle.toString());
      }
      a(false);
      paramBundle = new Bundle();
      paramBundle.putString("notify_cmd", "updateLostStatus");
      SmartDeviceIPCHost localSmartDeviceIPCHost = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
      if (localSmartDeviceIPCHost != null) {
        localSmartDeviceIPCHost.a(paramBundle);
      }
      if (paramInt == 2) {
        return;
      }
      if (paramInt == 6)
      {
        a(l, i, HardCodeUtil.a(2131714080));
        return;
      }
      if (paramInt == 7) {
        return;
      }
      if (paramInt == 8)
      {
        a(l, i, HardCodeUtil.a(2131714079));
        return;
      }
      if (paramInt == 9) {
        a(l, i, HardCodeUtil.a(2131714085));
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    b("SmartDeviceProxyMgr::queryIsDeviceHasBeenBinded");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "queryIsDeviceHasBeenBinded");
    localBundle.putInt("productId", paramInt);
    localBundle.putString("serialNum", paramString);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(long paramLong)
  {
    QLog.d("SmartDeviceProxyMgr", 2, "sendUinSkeyMsg begin");
    if (!a()) {
      return;
    }
    Object localObject1 = new cmd0xac7.ReqBody();
    ((cmd0xac7.ReqBody)localObject1).uint32_cmd.set(443);
    ((cmd0xac7.ReqBody)localObject1).uint64_din.set(paramLong);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if (localObject3 == null) {
      return;
    }
    Object localObject2 = new cmd0xac7.BinderSig();
    ((cmd0xac7.BinderSig)localObject2).uint32_type.set(1);
    ((cmd0xac7.BinderSig)localObject2).uint64_uin.set(Long.valueOf((String)localObject3).longValue());
    localObject3 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    ((cmd0xac7.BinderSig)localObject2).bytes_sig.set(ByteStringMicro.copyFromUtf8(((TicketManager)localObject3).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
    ((cmd0xac7.ReqBody)localObject1).msg_binder_sig.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2759);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xac7.ReqBody)localObject1).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "OidbSvc_device.0xac7");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    b("SmartDeviceProxyMgr::sendToDealTipCmd");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendDealTipCmd");
    localBundle.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localBundle.putLong("din", paramLong);
    localBundle.putInt("productId", paramInt);
    SmartDeviceIPCHost localSmartDeviceIPCHost = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (localSmartDeviceIPCHost != null) {
      localSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    b("SmartDeviceProxyMgr::setDeviceVasFlag");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "setDeviceVasFlag");
    localBundle.putInt("bitCount", paramInt2);
    localBundle.putInt("beginIndex", paramInt1);
    localBundle.putInt("bitValue", paramInt3);
    localBundle.putLong("din", paramLong);
    SmartDeviceIPCHost localSmartDeviceIPCHost = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (localSmartDeviceIPCHost != null) {
      localSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceive Push Msg : ");
    ((StringBuilder)localObject).append(paramString);
    b(((StringBuilder)localObject).toString());
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
    paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (paramString != null) {
      paramString.a((Bundle)localObject);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString) {}
  
  public void a(long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    b("SmartDeviceProxyMgr::sendStructingShareMsg");
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
        ((DataPoint)localObject1).mValue = new JSONObject().put("msg_time", (int)MessageCache.a()).put("senderDin", paramLong).put("msgUrl", ((AbsShareMsg)localObject2).mMsgUrl).put("contentSrc", ((AbsShareMsg)localObject2).mContentSrc).put("contentCover", ((AbsShareMsg)localObject2).mContentCover).put("contentTitle", ((AbsShareMsg)localObject2).mContentTitle).put("contentSummary", ((AbsShareMsg)localObject2).mContentSummary).put("msgAction", ((AbsShareMsg)localObject2).mMsgAction).put("msgActionData", ((AbsShareMsg)localObject2).mMsgActionData).put("msg_A_ActionData", ((AbsShareMsg)localObject2).mMsg_A_ActionData).put("msg_I_ActionData", ((AbsShareMsg)localObject2).mMsg_I_ActionData).put("sourceAppid", ((AbsShareMsg)localObject2).mSourceAppid).put("sourceUrl", ((AbsShareMsg)localObject2).mSourceUrl).put("sourceAction", ((AbsShareMsg)localObject2).mSourceAction).put("sourceActionData", ((AbsShareMsg)localObject2).mSourceActionData).put("source_A_ActionData", ((AbsShareMsg)localObject2).mSource_A_ActionData).put("source_I_ActionData", ((AbsShareMsg)localObject2).mSource_I_ActionData).put("sourceIcon", ((AbsShareMsg)localObject2).mSourceIcon).put("sourceName", ((AbsShareMsg)localObject2).mSourceName).put("msgBrief", ((AbsShareMsg)localObject2).mMsgBrief).put("fileName", ((AbsShareMsg)localObject2).mFileName).put("fileSize", ((AbsShareMsg)localObject2).mFileSize).put("compatibleText", ((AbsShareMsg)localObject2).mCompatibleText).toString();
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
      b(((StringBuilder)localObject2).toString());
      localObject1 = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
      if (localObject1 != null) {
        ((SmartDeviceIPCHost)localObject1).a(paramAbsStructMsg);
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, Bundle paramBundle)
  {
    b("SmartDeviceProxyMgr::sendCloudPrintCmd");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCloudPrintCmd");
    localBundle.putLong("din", paramLong);
    localBundle.putString("fileIndex", paramString1);
    localBundle.putString("jobId", paramString2);
    localBundle.putString("fileName", paramString3);
    localBundle.putInt("fileType", paramInt);
    localBundle.putBundle("otherParams", paramBundle);
    paramString1 = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (paramString1 != null) {
      paramString1.a(localBundle);
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
      ToastUtil.a().a(HardCodeUtil.a(2131714088));
      return;
    }
    paramDeviceInfo.displayName = SmartDeviceUtil.a(paramDeviceInfo);
    new LightAppUtil(paramActivity).a(paramDeviceInfo, paramBundle, paramBoolean);
  }
  
  public void a(Bundle paramBundle)
  {
    b("SmartDeviceProxyMgr::InvokeOpenChatMsgActivity");
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramBundle != null))
    {
      String str1 = paramBundle.getString("din");
      String str2 = paramBundle.getString("devName");
      Boolean localBoolean = Boolean.valueOf(paramBundle.getBoolean("bFromLightApp", false));
      int i = paramBundle.getInt("operType");
      int j = paramBundle.getInt("jumpTab");
      paramBundle = Looper.getMainLooper();
      if (Thread.currentThread() != paramBundle.getThread())
      {
        new Handler(paramBundle).post(new SmartDeviceProxyMgr.3(this, str1, str2, localBoolean, i, j));
        return;
      }
      a(str1, str2, localBoolean, i, j);
      return;
    }
    b("in SmartDeviceProxyMgr InvokeOpenChatMsgActivity app is null or params is null");
  }
  
  public void a(DataPoint paramDataPoint, int paramInt1, long paramLong, int paramInt2)
  {
    b("SmartDeviceProxyMgr::sendCCDataPointMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendCCDataPointMsg");
    localBundle.putParcelable("datapoint", paramDataPoint);
    localBundle.putInt("cookie", paramInt1);
    localBundle.putLong("din", paramLong);
    localBundle.putInt("lifetime", paramInt2);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new SmartDeviceProxyMgr.2(this, paramConfig));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    b("SmartDeviceProxyMgr::sendTextMsg");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "sendTextMsg");
    localBundle.putLong("din", paramLong1);
    localBundle.putString("text", paramString);
    localBundle.putLong("msg_time", paramLong2);
    localBundle.putLong("msgSeq", paramLong3);
    paramString = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (paramString != null) {
      paramString.a(localBundle);
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
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        int i = 0;
        while (i < paramString.length())
        {
          long l = paramString.getLong(i);
          this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(l));
          i += 1;
        }
      }
      if (paramString.size() <= 0) {
        break label294;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      paramString = this.jdField_b_of_type_JavaUtilArrayList;
      if (paramString == null) {
        break label294;
      }
    }
    paramString = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
      this.d = Integer.parseInt(paramString);
    }
    catch (Exception paramString)
    {
      label260:
      break label260;
    }
    this.d = 0;
    if ((this.d + this.c > 1) && (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr != null))
    {
      a();
      break label294;
      return;
    }
    label294:
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel()))
    {
      paramString = new StringBuilder();
      paramString.append("qfind pid count=");
      paramString.append(this.jdField_b_of_type_JavaUtilArrayList.size());
      QLog.w("QFind", 2, paramString.toString());
    }
  }
  
  public void a(ArrayList<LightAppSettingInfo> paramArrayList)
  {
    b("SmartDeviceProxyMgr::transferAppSettingList");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "transferLiteAppSettingList");
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localBundle.putParcelableArrayList("settinglist", paramArrayList);
    }
    paramArrayList = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (paramArrayList != null) {
      paramArrayList.a(localBundle);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startPlugin flag:");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(" ipc:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost);
    b(((StringBuilder)localObject).toString());
    if (this.e != 1) {
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
    b(localStringBuilder.toString());
    if (b()) {
      b(paramBoolean);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SubMsgType0x90.MsgBody();
    try
    {
      ((SubMsgType0x90.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      int i = ((SubMsgType0x90.MsgBody)localObject).msg_head.uint32_cmd.get();
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramArrayOfByte = ((SubMsgType0x90.MsgBody)localObject).msg_body.msg_occupy_microphone_body;
        localObject = new Intent();
        ((Intent)localObject).setAction("On_OccupyMicrophoneNotify_Push");
        ((Intent)localObject).putExtra("din", paramArrayOfByte.uint64_din.get());
        ((Intent)localObject).putExtra("uin", a(paramArrayOfByte.uint32_uin.get()));
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
      i = 0;
      while (i < paramArrayOfByte.rpt_msg_notify_info.size())
      {
        arrayOfInt[i] = ((SubMsgType0x90.NotifyItem)paramArrayOfByte.rpt_msg_notify_info.get(i)).uint32_propertyid.get();
        i += 1;
      }
      ((Intent)localObject).putExtra("pids", arrayOfInt);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.smartdevice.permission.broadcast");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label246:
      break label246;
    }
    b("onRecvPush0x210_0x90, parse error");
  }
  
  public boolean a()
  {
    return this.e == 1;
  }
  
  public boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    b("SmartDeviceProxyMgr::datalineSendCSMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "datalineSendCSMsg");
    localBundle.putInt("subType", paramInt1);
    localBundle.putInt("cookie", paramInt2);
    localBundle.putByteArray("data", paramArrayOfByte);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong));
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    Object localObject = a(paramLong);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
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
    b("SmartDeviceProxyMgr::datalineSendCCMsg");
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "datalineSendCCMsg");
    localBundle.putLong("din", paramLong);
    localBundle.putInt("sendCookie", paramInt);
    localBundle.putByteArray("bodyContent", paramArrayOfByte);
    this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a(localBundle);
    return true;
  }
  
  public boolean a(String paramString)
  {
    return b(Long.parseLong(paramString));
  }
  
  public byte[] a()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("device login,a2 len is:");
      localStringBuilder.append(str.length());
      b(localStringBuilder.toString());
      return HexUtil.hexStr2Bytes(a());
    }
    return HexUtil.hexStr2Bytes("");
  }
  
  public DeviceInfo[] a()
  {
    a(false);
    if (this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost == null) {
      return null;
    }
    DeviceInfo[] arrayOfDeviceInfo = b();
    if (arrayOfDeviceInfo == null)
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1003);
      }
    }
    return arrayOfDeviceInfo;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPlugin force flag:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" ipc:");
    localStringBuilder.append(this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost);
    b(localStringBuilder.toString());
    if (b()) {
      b(false);
    }
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_antilost_key", this.c);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qfind mQfindAssist=");
      localStringBuilder.append(this.c);
      QLog.w("QFind", 2, localStringBuilder.toString());
    }
  }
  
  public void b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("LocalPath");
    String str2 = paramBundle.getString("PeerUin");
    long l = paramBundle.getLong("Uniseq");
    paramBundle = new TransferRequest();
    paramBundle.mIsUp = true;
    paramBundle.mCommandId = 7;
    paramBundle.mLocalPath = str1;
    paramBundle.mPeerUin = str2;
    paramBundle.mUniseq = l;
    paramBundle.mFileType = 24;
    paramBundle.mRichTag = "facePicUploadProcess";
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.transferAsync(paramBundle);
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
          b(localStringBuilder.toString());
          if ((1 != this.jdField_a_of_type_Int) && (1 != this.jdField_b_of_type_Int))
          {
            if (paramBoolean)
            {
              this.jdField_a_of_type_Int = 0;
              this.jdField_b_of_type_Int = 0;
            }
            if (((this.jdField_a_of_type_Int == 0) || (3 == this.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null))
            {
              a(1300000607, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), a(), "", "");
              this.jdField_a_of_type_Int = 1;
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
    if (a(paramLong).booleanValue()) {
      return true;
    }
    Object localObject = a(paramLong);
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
  
  public void c()
  {
    QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**sendMsgProxy");
    if (!a()) {
      return;
    }
    Object localObject1 = new cmd0xac7.ReqBody();
    ((cmd0xac7.ReqBody)localObject1).uint32_cmd.set(442);
    QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**sendMsgProxy ...");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (localObject2 == null) {
      return;
    }
    ((cmd0xac7.ReqBody)localObject1).uint64_din.set(Long.valueOf((String)localObject2).longValue());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("**davorteng**sendMsgProxy din:");
    localStringBuilder.append(Long.valueOf((String)localObject2).longValue());
    QLog.d("SmartDeviceProxyMgr", 2, localStringBuilder.toString());
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2759);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xac7.ReqBody)localObject1).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "OidbSvc_device.0xac7");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public boolean c(long paramLong)
  {
    Object localObject = a(paramLong);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = a(((DeviceInfo)localObject).productId);
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
  
  public void d()
  {
    if ((this.jdField_a_of_type_Boolean) && (2 == this.jdField_a_of_type_Int))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("notify_cmd", "logout");
      SmartDeviceIPCHost localSmartDeviceIPCHost = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
      if (localSmartDeviceIPCHost != null) {
        localSmartDeviceIPCHost.a(localBundle);
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    QLog.d("SmartDeviceProxyMgr", 2, "**davorteng**logout");
    BannerManager.a().a(MsgProxyBannerProcessor.jdField_a_of_type_Int, 0, null);
  }
  
  public boolean d(long paramLong)
  {
    b("SmartDeviceProxyMgr::isDeviceHasUpdate");
    Object localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "isDeviceHasUpdate");
    ((Bundle)localObject).putLong("din", paramLong);
    localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost.a((Bundle)localObject);
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
  
  public void e()
  {
    b("SmartDeviceProxyMgr::updateDeviceStatus");
    a(false);
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "updateDeviceStatus");
    SmartDeviceIPCHost localSmartDeviceIPCHost = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (localSmartDeviceIPCHost != null) {
      localSmartDeviceIPCHost.a(localBundle);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return SmartDeviceObserver.class;
  }
  
  public void onDestroy()
  {
    b("SmartDeviceProxyMgr onDestroy");
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr$BroadcastHandler != null) {
      try
      {
        if (BaseApplicationImpl.getContext() != null) {
          BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr$BroadcastHandler);
        }
        this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr$BroadcastHandler = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_MqqOsMqqHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController;
    if (localObject != null)
    {
      ((ITransFileController)localObject).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler;
    if (localObject != null)
    {
      ((TransProcessorHandler)localObject).getFilter().clear();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = null;
    }
    localObject = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (localObject != null)
    {
      ((SmartDeviceIPCHost)localObject).a();
      this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost = null;
    }
    localObject = this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr;
    if (localObject != null)
    {
      ((QFindBLEScanMgr)localObject).b();
      this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr = null;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo != null) {
      this.jdField_a_of_type_ArrayOfComTencentDeviceDatadefDeviceInfo = null;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      Object localObject1;
      if ("QFindSvc.ReqReportDevs".equals(paramToServiceMsg.getServiceCmd()))
      {
        localObject1 = this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr;
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
                long l = ((cmd0xac7.DeviceInfo)localObject2).uint64_din.get();
                localObject2 = Message.obtain();
                ((Message)localObject2).what = 3000;
                ((Message)localObject2).obj = new Pair(Long.valueOf(l), localObject1);
                BannerManager.a().a(MsgProxyBannerProcessor.jdField_a_of_type_Int, 2, (Message)localObject2);
              }
            }
            else
            {
              BannerManager.a().a(MsgProxyBannerProcessor.jdField_a_of_type_Int, 0, null);
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            BannerManager.a().a(MsgProxyBannerProcessor.jdField_a_of_type_Int, 0, null);
          }
        }
      }
    }
    b("onReceive Ack Msg");
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
    paramToServiceMsg = this.jdField_a_of_type_CooperationSmartdeviceIpcSmartDeviceIPCHost;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.a(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.devicemgr.SmartDeviceProxyMgr
 * JD-Core Version:    0.7.0.1
 */