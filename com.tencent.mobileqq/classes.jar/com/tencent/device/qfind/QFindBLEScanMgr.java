package com.tencent.device.qfind;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.ble.QFindGattManager;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.oidb.qfind.QFind.DeviceInfo;
import tencent.im.oidb.qfind.QFind.DeviceLoc;
import tencent.im.oidb.qfind.QFind.HistoryData;
import tencent.im.oidb.qfind.QFind.HistoryDetail;
import tencent.im.oidb.qfind.QFind.ReqReportDevs;

@TargetApi(18)
public class QFindBLEScanMgr
{
  private static QFindBLEScanMgr A;
  private static boolean F = false;
  private static String x = "Q_Find_Scan_Intent";
  private static String y = "com.tencent.mobileqq.msf.wakeup";
  private HandlerThread B;
  private PowerManager.WakeLock C;
  private QFindBLEScanMgr.ScanReceiver D;
  private Dictionary<QFindBLEScanMgr.GroupLogItem, Long> E = new Hashtable();
  private QFindBLEScanMgr.NotifyReceiver G;
  private Context H;
  int a = 300000;
  int b = 300000;
  int c = 3600000;
  int d = 10;
  int e = 300000;
  int f = 3600000;
  long g = 0L;
  int h = 0;
  long i = 0L;
  public BluetoothAdapter j;
  public BluetoothAdapter.LeScanCallback k;
  public volatile boolean l = false;
  public int m;
  public int n;
  public boolean o = true;
  public ArrayList<String> p = new ArrayList();
  public ArrayList<Long> q = new ArrayList();
  public HashMap<String, BlePeerInfo> r = new HashMap();
  public HashMap<String, Long> s = new HashMap();
  public HashMap<String, QFind.DeviceInfo> t = new HashMap();
  public int u = 0;
  public QQAppInterface v;
  public MqqHandler w;
  private long z;
  
  static
  {
    try
    {
      F = BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public QFindBLEScanMgr()
  {
    if (a()) {
      ThreadManager.getSubThreadHandler().post(new QFindBLEScanMgr.4(this));
    }
    if (!a()) {
      return;
    }
    this.H = BaseApplicationImpl.getContext();
    try
    {
      this.j = ((BluetoothManager)this.H.getSystemService("bluetooth")).getAdapter();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if (this.j == null) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.v = ((QQAppInterface)localAppRuntime);
    }
    try
    {
      e();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.G = new QFindBLEScanMgr.NotifyReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED");
    localIntentFilter.addAction("onDeviceVerifyRsp");
    localIntentFilter.addAction("QFIND_BLE_CONNECT_ERROR");
    this.H.registerReceiver(this.G, localIntentFilter);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.C;
    if (localObject != null)
    {
      ((PowerManager.WakeLock)localObject).release();
      this.C = null;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QFindBLEScanMgr releaseWakeLock:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.i("QFindBLE", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (this.r.containsKey(paramString)) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new QFindBLEScanMgr.1(this, 0, true, true, 0L, false, false, "smartdevice:lightapp", paramString));
    }
  }
  
  private void a(BlePeerInfo paramBlePeerInfo, SosoLbsInfo paramSosoLbsInfo, boolean paramBoolean)
  {
    try
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      if (this.i > 0L)
      {
        long l2 = this.i;
        if (l1 - l2 <= 600000L) {}
      }
      else
      {
        try
        {
          d();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      if (paramSosoLbsInfo == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start to report dev sn=");
          ((StringBuilder)localObject).append(paramBlePeerInfo.a());
          ((StringBuilder)localObject).append(", pid=");
          ((StringBuilder)localObject).append(paramBlePeerInfo.e);
          ((StringBuilder)localObject).append(", ble_id = ");
          ((StringBuilder)localObject).append(paramBlePeerInfo.i);
          ((StringBuilder)localObject).append(", lastreportcount=");
          ((StringBuilder)localObject).append(this.h);
          ((StringBuilder)localObject).append(", run = ");
          ((StringBuilder)localObject).append(paramBlePeerInfo.p);
          ((StringBuilder)localObject).append(" , walk = ");
          ((StringBuilder)localObject).append(paramBlePeerInfo.o);
          QLog.w("QFindBLE", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report lost dev sn=");
        ((StringBuilder)localObject).append(paramBlePeerInfo.a());
        ((StringBuilder)localObject).append(", pid=");
        ((StringBuilder)localObject).append(paramBlePeerInfo.e);
        ((StringBuilder)localObject).append(" has loc(");
        ((StringBuilder)localObject).append(paramSosoLbsInfo.mLocation.mLat02);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(paramSosoLbsInfo.mLocation.mLon02);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramSosoLbsInfo.mLocation.accuracy);
        ((StringBuilder)localObject).append("), ble_id = ");
        ((StringBuilder)localObject).append(paramBlePeerInfo.i);
        ((StringBuilder)localObject).append(", lastreportcount=");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append(", run = ");
        ((StringBuilder)localObject).append(paramBlePeerInfo.p);
        ((StringBuilder)localObject).append(" , walk = ");
        ((StringBuilder)localObject).append(paramBlePeerInfo.o);
        QLog.i("QFindBLE", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = new QFind.ReqReportDevs();
      ArrayList localArrayList1 = new ArrayList();
      QFind.DeviceInfo localDeviceInfo = new QFind.DeviceInfo();
      localDeviceInfo.pid.set(paramBlePeerInfo.e);
      localDeviceInfo.service_uuid.set(2L);
      localDeviceInfo.sn.set(ByteStringMicro.copyFromUtf8(paramBlePeerInfo.a()));
      if (paramBoolean) {
        localDeviceInfo.bytes_sig.set(ByteStringMicro.copyFrom(paramBlePeerInfo.k));
      }
      localDeviceInfo.timestamp.set((int)(l1 / 1000L));
      ArrayList localArrayList2 = new ArrayList();
      QFind.HistoryDetail localHistoryDetail = new QFind.HistoryDetail();
      localHistoryDetail.run.set(paramBlePeerInfo.p);
      localHistoryDetail.walk.set(paramBlePeerInfo.o);
      localArrayList2.add(localHistoryDetail);
      paramBlePeerInfo = new QFind.HistoryData();
      paramBlePeerInfo.details.set(localArrayList2);
      localDeviceInfo.msg_walking_history.set(paramBlePeerInfo);
      localArrayList1.add(localDeviceInfo);
      ((QFind.ReqReportDevs)localObject).dev_infos.set(localArrayList1);
      if (paramSosoLbsInfo != null)
      {
        paramBlePeerInfo = new QFind.DeviceLoc();
        paramBlePeerInfo.lat.set(Double.valueOf(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D).intValue());
        paramBlePeerInfo.lon.set(Double.valueOf(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D).intValue());
        paramBlePeerInfo.gps_type.set(1);
        paramBlePeerInfo.uint32_precision.set((int)paramSosoLbsInfo.mLocation.accuracy);
        ((QFind.ReqReportDevs)localObject).dev_loc.set(paramBlePeerInfo);
      }
      paramSosoLbsInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramBlePeerInfo = (SmartDeviceProxyMgr)paramSosoLbsInfo.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", paramSosoLbsInfo.getCurrentAccountUin(), "QFindSvc.ReqReportDevs");
      paramSosoLbsInfo.putWupBuffer(((QFind.ReqReportDevs)localObject).toByteArray());
      paramBlePeerInfo.sendPbReq(paramSosoLbsInfo);
      return;
    }
    catch (Throwable paramBlePeerInfo)
    {
      paramBlePeerInfo.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("SendReqReportAroundDevs  report exception :   ");
        paramSosoLbsInfo.append(paramBlePeerInfo.toString());
        QLog.i("QFindBLE", 2, paramSosoLbsInfo.toString());
      }
    }
  }
  
  public static boolean a()
  {
    return F;
  }
  
  private boolean a(BlePeerInfo paramBlePeerInfo, boolean paramBoolean)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.g;
    if ((l2 <= 0L) || (l1 - l2 > this.c))
    {
      this.g = NetConnInfoCenter.getServerTimeMillis();
      this.h = 0;
    }
    if ((this.h > this.d) && (!paramBoolean)) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramBlePeerInfo.e);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramBlePeerInfo.a());
    localObject = ((StringBuilder)localObject).toString();
    if (this.r.containsKey(localObject))
    {
      BlePeerInfo localBlePeerInfo = (BlePeerInfo)this.r.get(localObject);
      localBlePeerInfo.p = paramBlePeerInfo.p;
      localBlePeerInfo.o = paramBlePeerInfo.o;
      if ((!paramBoolean) && (l1 - localBlePeerInfo.g < this.a)) {
        return false;
      }
      if ((paramBoolean) && (l1 - localBlePeerInfo.h < this.e)) {
        return false;
      }
      if ((paramBoolean) && (this.s.containsKey(localObject)) && (l1 - ((Long)this.s.get(localObject)).longValue() > this.f) && (l1 - localBlePeerInfo.h < this.a))
      {
        if (QLog.isColorLevel())
        {
          paramBlePeerInfo = new StringBuilder();
          paramBlePeerInfo.append("report lost dev reach the period: ");
          paramBlePeerInfo.append(this.f);
          QLog.i("QFindBLE", 2, paramBlePeerInfo.toString());
        }
        return false;
      }
      localBlePeerInfo.g = l1;
      if (paramBoolean) {
        localBlePeerInfo.h = l1;
      }
    }
    else
    {
      paramBlePeerInfo.g = l1;
      if (paramBoolean) {
        paramBlePeerInfo.h = l1;
      }
      this.r.put(localObject, paramBlePeerInfo);
    }
    localObject = (BlePeerInfo)this.r.get(localObject);
    if (!((BlePeerInfo)localObject).n)
    {
      ((BlePeerInfo)localObject).i = paramBlePeerInfo.i;
      ((BlePeerInfo)localObject).m = false;
    }
    this.h += 1;
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.l) {
        return true;
      }
      this.p.clear();
    }
    try
    {
      if ((this.j == null) || (!this.j.isEnabled())) {
        break label147;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call native mBluetoothAdapter.startLeScan with cb=");
        localStringBuilder.append(this.k);
        localStringBuilder.append(", mScanning=");
        localStringBuilder.append(this.l);
        QLog.i("QFindBLE", 2, localStringBuilder.toString());
      }
      this.l = this.j.startLeScan(this.k);
      if (this.w == null) {
        break label147;
      }
      this.w.postDelayed(new QFindBLEScanMgr.2(this), this.n);
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder;
      label142:
      break label142;
    }
    this.l = false;
    label147:
    paramBoolean = this.l;
    return this.l;
    g();
    if (this.l)
    {
      this.l = false;
      try
      {
        if (this.j != null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("call native mBluetoothAdapter.stopLeScan with cb=");
            localStringBuilder.append(this.k);
            localStringBuilder.append(", mScanning=");
            localStringBuilder.append(this.l);
            QLog.i("QFindBLE", 2, localStringBuilder.toString());
          }
          this.j.stopLeScan(this.k);
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return true;
  }
  
  private boolean b(BlePeerInfo paramBlePeerInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramBlePeerInfo.e);
    localStringBuilder.append("|");
    localStringBuilder.append(paramBlePeerInfo.a());
    paramBlePeerInfo = localStringBuilder.toString();
    return this.s.containsKey(paramBlePeerInfo);
  }
  
  private void d()
  {
    this.i = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit();
    String str = this.v.getCurrentAccountUin();
    if (str != null)
    {
      if ("".equals(str)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_SAME_DEVICE_INTERVAL");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_ANY_DEVICE_INTERVAL");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.b);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_OFTEN_FREQUENCE");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.d);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_OFTEN_PERIOD");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.c);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_LAST_REPORT_PERIOD_START");
      localStringBuilder.append(str);
      localEditor.putLong(localStringBuilder.toString(), this.g);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_LAST_REPORT_COUNT");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.h);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_SAME_LOST_DEVS_INTERVAL");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.e);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_FORCE_REPORT_LBS_PERIOD");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.f);
      localEditor.commit();
    }
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
    String str = this.v.getCurrentAccountUin();
    if (str != null)
    {
      if ("".equals(str)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_SAME_DEVICE_INTERVAL");
      localStringBuilder.append(str);
      this.a = localSharedPreferences.getInt(localStringBuilder.toString(), 300000);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_ANY_DEVICE_INTERVAL");
      localStringBuilder.append(str);
      this.b = localSharedPreferences.getInt(localStringBuilder.toString(), 300000);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_OFTEN_PERIOD");
      localStringBuilder.append(str);
      this.c = localSharedPreferences.getInt(localStringBuilder.toString(), 3600000);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_OFTEN_FREQUENCE");
      localStringBuilder.append(str);
      this.d = localSharedPreferences.getInt(localStringBuilder.toString(), 3600000);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_LAST_REPORT_COUNT");
      localStringBuilder.append(str);
      this.h = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_LAST_REPORT_PERIOD_START");
      localStringBuilder.append(str);
      this.g = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_SAME_LOST_DEVS_INTERVAL");
      localStringBuilder.append(str);
      this.e = localSharedPreferences.getInt(localStringBuilder.toString(), 300000);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_FORCE_REPORT_LBS_PERIOD");
      localStringBuilder.append(str);
      this.f = localSharedPreferences.getInt(localStringBuilder.toString(), 3600000);
    }
  }
  
  private void f()
  {
    if (this.C == null)
    {
      this.C = ((PowerManager)this.H.getSystemService("power")).newWakeLock(536870913, "QFindBLE");
      PowerManager.WakeLock localWakeLock = this.C;
      if (localWakeLock != null) {
        localWakeLock.acquire();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr acquireWakeLock");
      }
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLE", 2, "QFindBLEScanMgr cancelReceiver");
    }
    a(2);
    QFindBLEScanMgr.ScanReceiver localScanReceiver = this.D;
    if (localScanReceiver != null) {
      try
      {
        this.H.unregisterReceiver(localScanReceiver);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void h()
  {
    try
    {
      this.B = ThreadManager.newFreeHandlerThread("ble_scan_task", 0);
      this.B.start();
      this.w = new MqqHandler(this.B.getLooper());
      this.k = new QFindBLEScanMgr.3(this);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected PeerInfo a(BlePeerInfo paramBlePeerInfo)
  {
    PeerInfo localPeerInfo = new PeerInfo();
    localPeerInfo.a = paramBlePeerInfo.i;
    localPeerInfo.b = paramBlePeerInfo.a;
    localPeerInfo.c = paramBlePeerInfo.b;
    localPeerInfo.d = paramBlePeerInfo.d;
    localPeerInfo.e = paramBlePeerInfo.c;
    localPeerInfo.f = paramBlePeerInfo.e;
    return localPeerInfo;
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 363	tencent/im/oidb/qfind/QFind$ReqReportDevs
    //   3: dup
    //   4: invokespecial 364	tencent/im/oidb/qfind/QFind$ReqReportDevs:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: invokevirtual 738	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   15: iconst_4
    //   16: aload_1
    //   17: invokevirtual 738	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   20: arraylength
    //   21: iconst_4
    //   22: isub
    //   23: invokevirtual 742	tencent/im/oidb/qfind/QFind$ReqReportDevs:mergeFrom	([BII)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   26: pop
    //   27: new 744	tencent/im/oidb/qfind/QFind$RspReportDevs
    //   30: dup
    //   31: invokespecial 745	tencent/im/oidb/qfind/QFind$RspReportDevs:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: aload_2
    //   37: invokevirtual 748	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   40: invokevirtual 751	tencent/im/oidb/qfind/QFind$RspReportDevs:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   43: pop
    //   44: aload_1
    //   45: invokevirtual 754	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   48: istore 4
    //   50: aload_0
    //   51: getfield 137	com/tencent/device/qfind/QFindBLEScanMgr:r	Ljava/util/HashMap;
    //   54: invokevirtual 758	java/util/HashMap:values	()Ljava/util/Collection;
    //   57: invokeinterface 764 1 0
    //   62: astore_1
    //   63: aload_1
    //   64: invokeinterface 769 1 0
    //   69: ifeq +20 -> 89
    //   72: iload 4
    //   74: aload_1
    //   75: invokeinterface 773 1 0
    //   80: checkcast 307	com/tencent/device/qfind/BlePeerInfo
    //   83: getfield 774	com/tencent/device/qfind/BlePeerInfo:f	I
    //   86: if_icmpne -23 -> 63
    //   89: aload_3
    //   90: getfield 778	tencent/im/oidb/qfind/QFind$RspReportDevs:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   93: invokevirtual 782	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   96: istore 4
    //   98: iload 4
    //   100: ifne +652 -> 752
    //   103: new 127	java/util/ArrayList
    //   106: dup
    //   107: invokespecial 128	java/util/ArrayList:<init>	()V
    //   110: astore_2
    //   111: new 127	java/util/ArrayList
    //   114: dup
    //   115: invokespecial 128	java/util/ArrayList:<init>	()V
    //   118: astore_1
    //   119: aload 6
    //   121: getfield 453	tencent/im/oidb/qfind/QFind$ReqReportDevs:dev_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   124: invokevirtual 785	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   127: invokeinterface 786 1 0
    //   132: astore 7
    //   134: aload 7
    //   136: invokeinterface 769 1 0
    //   141: istore 5
    //   143: iload 5
    //   145: ifeq +100 -> 245
    //   148: aload 7
    //   150: invokeinterface 773 1 0
    //   155: checkcast 366	tencent/im/oidb/qfind/QFind$DeviceInfo
    //   158: astore 8
    //   160: new 245	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   167: astore 9
    //   169: aload 9
    //   171: ldc_w 267
    //   174: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 9
    //   180: aload 8
    //   182: getfield 371	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   185: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   188: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 9
    //   194: ldc_w 269
    //   197: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 9
    //   203: aload 8
    //   205: getfield 391	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   208: invokevirtual 790	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   211: invokevirtual 793	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   214: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 9
    //   220: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: astore 8
    //   225: aload_2
    //   226: aload 8
    //   228: invokevirtual 794	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   231: pop
    //   232: aload_0
    //   233: getfield 141	com/tencent/device/qfind/QFindBLEScanMgr:t	Ljava/util/HashMap;
    //   236: aload 8
    //   238: invokevirtual 797	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   241: pop
    //   242: goto -108 -> 134
    //   245: aload_3
    //   246: getfield 800	tencent/im/oidb/qfind/QFind$RspReportDevs:lost_devs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   249: invokevirtual 785	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   252: invokeinterface 786 1 0
    //   257: astore 7
    //   259: aload 7
    //   261: invokeinterface 769 1 0
    //   266: ifeq +287 -> 553
    //   269: aload 7
    //   271: invokeinterface 773 1 0
    //   276: checkcast 366	tencent/im/oidb/qfind/QFind$DeviceInfo
    //   279: astore 8
    //   281: new 245	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   288: astore 9
    //   290: aload 9
    //   292: ldc_w 267
    //   295: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 9
    //   301: aload 8
    //   303: getfield 371	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   306: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   309: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 9
    //   315: ldc_w 269
    //   318: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 9
    //   324: aload 8
    //   326: getfield 391	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   329: invokevirtual 790	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   332: invokevirtual 793	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   335: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 9
    //   341: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: astore 9
    //   346: aload_0
    //   347: getfield 141	com/tencent/device/qfind/QFindBLEScanMgr:t	Ljava/util/HashMap;
    //   350: aload 9
    //   352: invokevirtual 273	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   355: ifeq +13 -> 368
    //   358: aload_0
    //   359: getfield 141	com/tencent/device/qfind/QFindBLEScanMgr:t	Ljava/util/HashMap;
    //   362: aload 9
    //   364: invokevirtual 797	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   367: pop
    //   368: aload_0
    //   369: getfield 141	com/tencent/device/qfind/QFindBLEScanMgr:t	Ljava/util/HashMap;
    //   372: aload 9
    //   374: aload 8
    //   376: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   379: pop
    //   380: new 245	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   387: astore 9
    //   389: aload 9
    //   391: ldc_w 267
    //   394: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 9
    //   400: aload 8
    //   402: getfield 371	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   405: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   408: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload 9
    //   414: ldc_w 269
    //   417: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 9
    //   423: aload 8
    //   425: getfield 391	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   428: invokevirtual 790	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   431: invokevirtual 793	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   434: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_1
    //   439: aload 9
    //   441: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokevirtual 794	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   447: pop
    //   448: new 245	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   455: astore 9
    //   457: aload 9
    //   459: ldc_w 267
    //   462: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 9
    //   468: aload 8
    //   470: getfield 371	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   473: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   476: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 9
    //   482: ldc_w 269
    //   485: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 9
    //   491: aload 8
    //   493: getfield 391	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   496: invokevirtual 790	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   499: invokevirtual 793	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   502: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_2
    //   507: aload 9
    //   509: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokevirtual 802	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   515: pop
    //   516: aload 6
    //   518: getfield 484	tencent/im/oidb/qfind/QFind$ReqReportDevs:dev_loc	Ltencent/im/oidb/qfind/QFind$DeviceLoc;
    //   521: invokevirtual 805	tencent/im/oidb/qfind/QFind$DeviceLoc:has	()Z
    //   524: ifne -265 -> 259
    //   527: aload_0
    //   528: aload 8
    //   530: getfield 371	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   533: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   536: aload 8
    //   538: getfield 391	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   541: invokevirtual 790	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   544: invokevirtual 793	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   547: invokespecial 529	com/tencent/device/qfind/QFindBLEScanMgr:a	(ILjava/lang/String;)V
    //   550: goto -291 -> 259
    //   553: aload_2
    //   554: invokevirtual 806	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   557: astore_2
    //   558: aload_2
    //   559: invokeinterface 769 1 0
    //   564: ifeq +27 -> 591
    //   567: aload_2
    //   568: invokeinterface 773 1 0
    //   573: checkcast 626	java/lang/String
    //   576: astore 6
    //   578: aload_0
    //   579: getfield 139	com/tencent/device/qfind/QFindBLEScanMgr:s	Ljava/util/HashMap;
    //   582: aload 6
    //   584: invokevirtual 797	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   587: pop
    //   588: goto -30 -> 558
    //   591: aload_1
    //   592: invokevirtual 806	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   595: astore_1
    //   596: aload_1
    //   597: invokeinterface 769 1 0
    //   602: ifeq +42 -> 644
    //   605: aload_1
    //   606: invokeinterface 773 1 0
    //   611: checkcast 626	java/lang/String
    //   614: astore_2
    //   615: aload_0
    //   616: getfield 139	com/tencent/device/qfind/QFindBLEScanMgr:s	Ljava/util/HashMap;
    //   619: aload_2
    //   620: invokevirtual 273	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   623: ifne -27 -> 596
    //   626: aload_0
    //   627: getfield 139	com/tencent/device/qfind/QFindBLEScanMgr:s	Ljava/util/HashMap;
    //   630: aload_2
    //   631: invokestatic 299	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   634: invokestatic 809	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   637: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   640: pop
    //   641: goto -45 -> 596
    //   644: aload_0
    //   645: aload_3
    //   646: getfield 812	tencent/im/oidb/qfind/QFind$RspReportDevs:report_same_dev_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   649: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   652: sipush 1000
    //   655: imul
    //   656: ldc 102
    //   658: invokestatic 818	java/lang/Math:max	(II)I
    //   661: putfield 104	com/tencent/device/qfind/QFindBLEScanMgr:a	I
    //   664: aload_0
    //   665: aload_3
    //   666: getfield 821	tencent/im/oidb/qfind/QFind$RspReportDevs:report_any_devs_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   669: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   672: sipush 1000
    //   675: imul
    //   676: ldc 102
    //   678: invokestatic 818	java/lang/Math:max	(II)I
    //   681: putfield 106	com/tencent/device/qfind/QFindBLEScanMgr:b	I
    //   684: aload_0
    //   685: aload_3
    //   686: getfield 824	tencent/im/oidb/qfind/QFind$RspReportDevs:report_often_period	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   689: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   692: sipush 1000
    //   695: imul
    //   696: ldc 107
    //   698: invokestatic 818	java/lang/Math:max	(II)I
    //   701: putfield 109	com/tencent/device/qfind/QFindBLEScanMgr:c	I
    //   704: aload_0
    //   705: aload_3
    //   706: getfield 827	tencent/im/oidb/qfind/QFind$RspReportDevs:report_often_frequence	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   709: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   712: bipush 10
    //   714: invokestatic 818	java/lang/Math:max	(II)I
    //   717: putfield 111	com/tencent/device/qfind/QFindBLEScanMgr:d	I
    //   720: aload_0
    //   721: aload_3
    //   722: getfield 830	tencent/im/oidb/qfind/QFind$RspReportDevs:force_report_lbs_period	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   725: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   728: ldc 107
    //   730: invokestatic 818	java/lang/Math:max	(II)I
    //   733: putfield 115	com/tencent/device/qfind/QFindBLEScanMgr:f	I
    //   736: aload_0
    //   737: aload_3
    //   738: getfield 833	tencent/im/oidb/qfind/QFind$RspReportDevs:report_same_lost_devs_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   741: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   744: ldc 102
    //   746: invokestatic 818	java/lang/Math:max	(II)I
    //   749: putfield 113	com/tencent/device/qfind/QFindBLEScanMgr:e	I
    //   752: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   755: ifeq +565 -> 1320
    //   758: new 835	java/lang/StringBuffer
    //   761: dup
    //   762: invokespecial 836	java/lang/StringBuffer:<init>	()V
    //   765: astore_1
    //   766: new 245	java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   773: astore_2
    //   774: aload_2
    //   775: ldc_w 838
    //   778: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload_2
    //   783: aload_3
    //   784: getfield 778	tencent/im/oidb/qfind/QFind$RspReportDevs:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   787: invokevirtual 782	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   790: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload_1
    //   795: aload_2
    //   796: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   802: pop
    //   803: new 245	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   810: astore_2
    //   811: aload_2
    //   812: ldc_w 843
    //   815: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload_2
    //   820: aload_3
    //   821: getfield 812	tencent/im/oidb/qfind/QFind$RspReportDevs:report_same_dev_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   824: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   827: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload_1
    //   832: aload_2
    //   833: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   839: pop
    //   840: new 245	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   847: astore_2
    //   848: aload_2
    //   849: ldc_w 845
    //   852: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload_2
    //   857: aload_3
    //   858: getfield 821	tencent/im/oidb/qfind/QFind$RspReportDevs:report_any_devs_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   861: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   864: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   867: pop
    //   868: aload_1
    //   869: aload_2
    //   870: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   876: pop
    //   877: new 245	java/lang/StringBuilder
    //   880: dup
    //   881: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   884: astore_2
    //   885: aload_2
    //   886: ldc_w 847
    //   889: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: aload_2
    //   894: aload_3
    //   895: getfield 824	tencent/im/oidb/qfind/QFind$RspReportDevs:report_often_period	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   898: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   901: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload_1
    //   906: aload_2
    //   907: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   913: pop
    //   914: new 245	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   921: astore_2
    //   922: aload_2
    //   923: ldc_w 849
    //   926: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload_2
    //   931: aload_3
    //   932: getfield 827	tencent/im/oidb/qfind/QFind$RspReportDevs:report_often_frequence	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   935: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   938: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   941: pop
    //   942: aload_1
    //   943: aload_2
    //   944: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   950: pop
    //   951: new 245	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   958: astore_2
    //   959: aload_2
    //   960: ldc_w 851
    //   963: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: aload_2
    //   968: aload_3
    //   969: getfield 854	tencent/im/oidb/qfind/QFind$RspReportDevs:freq_limit_report_any_devs_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   972: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   975: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload_1
    //   980: aload_2
    //   981: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   987: pop
    //   988: new 245	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   995: astore_2
    //   996: aload_2
    //   997: ldc_w 856
    //   1000: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: pop
    //   1004: aload_2
    //   1005: aload_3
    //   1006: getfield 859	tencent/im/oidb/qfind/QFind$RspReportDevs:force_report_lbs	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1009: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1012: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1015: pop
    //   1016: aload_1
    //   1017: aload_2
    //   1018: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1024: pop
    //   1025: new 245	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1032: astore_2
    //   1033: aload_2
    //   1034: ldc_w 861
    //   1037: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: aload_2
    //   1042: aload_3
    //   1043: getfield 830	tencent/im/oidb/qfind/QFind$RspReportDevs:force_report_lbs_period	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1046: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1049: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1052: pop
    //   1053: aload_1
    //   1054: aload_2
    //   1055: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1061: pop
    //   1062: new 245	java/lang/StringBuilder
    //   1065: dup
    //   1066: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1069: astore_2
    //   1070: aload_2
    //   1071: ldc_w 863
    //   1074: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload_2
    //   1079: aload_3
    //   1080: getfield 833	tencent/im/oidb/qfind/QFind$RspReportDevs:report_same_lost_devs_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1083: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1086: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1089: pop
    //   1090: aload_1
    //   1091: aload_2
    //   1092: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1098: pop
    //   1099: new 245	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1106: astore_2
    //   1107: aload_2
    //   1108: ldc_w 865
    //   1111: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: pop
    //   1115: aload_2
    //   1116: aload_3
    //   1117: getfield 868	tencent/im/oidb/qfind/QFind$RspReportDevs:report_max_dev_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1120: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1123: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1126: pop
    //   1127: aload_1
    //   1128: aload_2
    //   1129: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1132: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1135: pop
    //   1136: aload_1
    //   1137: ldc_w 870
    //   1140: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1143: pop
    //   1144: aload_3
    //   1145: getfield 800	tencent/im/oidb/qfind/QFind$RspReportDevs:lost_devs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1148: invokevirtual 785	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1151: invokeinterface 786 1 0
    //   1156: astore_2
    //   1157: aload_2
    //   1158: invokeinterface 769 1 0
    //   1163: ifeq +104 -> 1267
    //   1166: aload_2
    //   1167: invokeinterface 773 1 0
    //   1172: checkcast 366	tencent/im/oidb/qfind/QFind$DeviceInfo
    //   1175: astore_3
    //   1176: new 245	java/lang/StringBuilder
    //   1179: dup
    //   1180: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1183: astore 6
    //   1185: aload 6
    //   1187: aload_3
    //   1188: getfield 371	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1191: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1194: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1197: pop
    //   1198: aload 6
    //   1200: ldc_w 269
    //   1203: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: aload 6
    //   1209: aload_3
    //   1210: getfield 391	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1213: invokevirtual 790	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1216: invokevirtual 793	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1219: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: pop
    //   1223: aload 6
    //   1225: ldc_w 269
    //   1228: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload 6
    //   1234: aload_3
    //   1235: getfield 415	tencent/im/oidb/qfind/QFind$DeviceInfo:timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1238: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1241: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1244: pop
    //   1245: aload 6
    //   1247: ldc_w 348
    //   1250: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: aload_1
    //   1255: aload 6
    //   1257: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1260: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1263: pop
    //   1264: goto -107 -> 1157
    //   1267: aload_1
    //   1268: ldc_w 872
    //   1271: invokevirtual 841	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1274: pop
    //   1275: new 245	java/lang/StringBuilder
    //   1278: dup
    //   1279: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1282: astore_2
    //   1283: aload_2
    //   1284: ldc_w 874
    //   1287: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload_2
    //   1292: aload_1
    //   1293: invokevirtual 581	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: ldc_w 257
    //   1300: iconst_2
    //   1301: aload_2
    //   1302: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1305: invokestatic 328	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1308: goto +12 -> 1320
    //   1311: astore_1
    //   1312: goto +14 -> 1326
    //   1315: astore_1
    //   1316: aload_1
    //   1317: invokevirtual 189	java/lang/Throwable:printStackTrace	()V
    //   1320: aload_0
    //   1321: iconst_3
    //   1322: invokespecial 526	com/tencent/device/qfind/QFindBLEScanMgr:a	(I)V
    //   1325: return
    //   1326: aload_0
    //   1327: iconst_3
    //   1328: invokespecial 526	com/tencent/device/qfind/QFindBLEScanMgr:a	(I)V
    //   1331: goto +5 -> 1336
    //   1334: aload_1
    //   1335: athrow
    //   1336: goto -2 -> 1334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1339	0	this	QFindBLEScanMgr
    //   0	1339	1	paramToServiceMsg	ToServiceMsg
    //   0	1339	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	1339	3	paramObject	Object
    //   48	51	4	i1	int
    //   141	3	5	bool	boolean
    //   7	1249	6	localObject1	Object
    //   132	138	7	localIterator	java.util.Iterator
    //   158	379	8	localObject2	Object
    //   167	341	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	63	1311	finally
    //   63	89	1311	finally
    //   89	98	1311	finally
    //   103	134	1311	finally
    //   134	143	1311	finally
    //   148	242	1311	finally
    //   245	259	1311	finally
    //   259	368	1311	finally
    //   368	550	1311	finally
    //   553	558	1311	finally
    //   558	588	1311	finally
    //   591	596	1311	finally
    //   596	641	1311	finally
    //   644	752	1311	finally
    //   752	1157	1311	finally
    //   1157	1264	1311	finally
    //   1267	1308	1311	finally
    //   1316	1320	1311	finally
    //   0	63	1315	java/lang/Throwable
    //   63	89	1315	java/lang/Throwable
    //   89	98	1315	java/lang/Throwable
    //   103	134	1315	java/lang/Throwable
    //   134	143	1315	java/lang/Throwable
    //   148	242	1315	java/lang/Throwable
    //   245	259	1315	java/lang/Throwable
    //   259	368	1315	java/lang/Throwable
    //   368	550	1315	java/lang/Throwable
    //   553	558	1315	java/lang/Throwable
    //   558	588	1315	java/lang/Throwable
    //   591	596	1315	java/lang/Throwable
    //   596	641	1315	java/lang/Throwable
    //   644	752	1315	java/lang/Throwable
    //   752	1157	1315	java/lang/Throwable
    //   1157	1264	1315	java/lang/Throwable
    //   1267	1308	1315	java/lang/Throwable
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    a(false);
    this.o = false;
  }
  
  public void c()
  {
    b();
    Object localObject = this.w;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
      this.w.getLooper().quit();
    }
    localObject = this.G;
    if (localObject != null)
    {
      this.H.unregisterReceiver((BroadcastReceiver)localObject);
      this.G = null;
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((BluetoothAdapter)localObject).stopLeScan(this.k);
      this.j = null;
    }
    if (this.k != null) {
      this.k = null;
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quitSafely();
      this.B = null;
    }
    if (this.v != null) {
      this.v = null;
    }
    QFindGattManager.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr
 * JD-Core Version:    0.7.0.1
 */