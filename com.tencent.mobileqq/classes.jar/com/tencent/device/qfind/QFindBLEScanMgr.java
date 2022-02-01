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
  private static QFindBLEScanMgr jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr;
  private static String jdField_a_of_type_JavaLangString = "Q_Find_Scan_Intent";
  private static String jdField_b_of_type_JavaLangString = "com.tencent.mobileqq.msf.wakeup";
  private static boolean jdField_c_of_type_Boolean = false;
  int jdField_a_of_type_Int = 300000;
  long jdField_a_of_type_Long = 0L;
  public BluetoothAdapter.LeScanCallback a;
  public BluetoothAdapter a;
  private Context jdField_a_of_type_AndroidContentContext;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private QFindBLEScanMgr.NotifyReceiver jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver;
  private QFindBLEScanMgr.ScanReceiver jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$ScanReceiver;
  public QQAppInterface a;
  public ArrayList<String> a;
  private Dictionary<QFindBLEScanMgr.GroupLogItem, Long> jdField_a_of_type_JavaUtilDictionary = new Hashtable();
  public HashMap<String, BlePeerInfo> a;
  public MqqHandler a;
  public volatile boolean a;
  int jdField_b_of_type_Int = 300000;
  long jdField_b_of_type_Long = 0L;
  public ArrayList<Long> b;
  public HashMap<String, Long> b;
  public boolean b;
  int jdField_c_of_type_Int = 3600000;
  private long jdField_c_of_type_Long;
  public HashMap<String, QFind.DeviceInfo> c;
  int d = 10;
  int e = 300000;
  int f = 3600000;
  int g = 0;
  public int h;
  public int i;
  public int j = 0;
  
  static
  {
    try
    {
      jdField_c_of_type_Boolean = BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public QFindBLEScanMgr()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    if (a()) {
      ThreadManager.getSubThreadHandler().post(new QFindBLEScanMgr.4(this));
    }
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    try
    {
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = ((BluetoothManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("bluetooth")).getAdapter();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter == null) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
    }
    try
    {
      d();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver = new QFindBLEScanMgr.NotifyReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED");
    localIntentFilter.addAction("onDeviceVerifyRsp");
    localIntentFilter.addAction("QFIND_BLE_CONNECT_ERROR");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver, localIntentFilter);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidOsPowerManager$WakeLock;
    if (localObject != null)
    {
      ((PowerManager.WakeLock)localObject).release();
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
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
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new QFindBLEScanMgr.1(this, 0, true, true, 0L, false, false, "smartdevice:lightapp", paramString));
    }
  }
  
  private void a(BlePeerInfo paramBlePeerInfo, SosoLbsInfo paramSosoLbsInfo, boolean paramBoolean)
  {
    try
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      if (this.jdField_b_of_type_Long > 0L)
      {
        long l2 = this.jdField_b_of_type_Long;
        if (l1 - l2 <= 600000L) {}
      }
      else
      {
        try
        {
          c();
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
          ((StringBuilder)localObject).append(paramBlePeerInfo.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(", ble_id = ");
          ((StringBuilder)localObject).append(paramBlePeerInfo.jdField_c_of_type_Int);
          ((StringBuilder)localObject).append(", lastreportcount=");
          ((StringBuilder)localObject).append(this.g);
          ((StringBuilder)localObject).append(", run = ");
          ((StringBuilder)localObject).append(paramBlePeerInfo.f);
          ((StringBuilder)localObject).append(" , walk = ");
          ((StringBuilder)localObject).append(paramBlePeerInfo.e);
          QLog.w("QFindBLE", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report lost dev sn=");
        ((StringBuilder)localObject).append(paramBlePeerInfo.a());
        ((StringBuilder)localObject).append(", pid=");
        ((StringBuilder)localObject).append(paramBlePeerInfo.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" has loc(");
        ((StringBuilder)localObject).append(paramSosoLbsInfo.mLocation.mLat02);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(paramSosoLbsInfo.mLocation.mLon02);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramSosoLbsInfo.mLocation.accuracy);
        ((StringBuilder)localObject).append("), ble_id = ");
        ((StringBuilder)localObject).append(paramBlePeerInfo.jdField_c_of_type_Int);
        ((StringBuilder)localObject).append(", lastreportcount=");
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append(", run = ");
        ((StringBuilder)localObject).append(paramBlePeerInfo.f);
        ((StringBuilder)localObject).append(" , walk = ");
        ((StringBuilder)localObject).append(paramBlePeerInfo.e);
        QLog.i("QFindBLE", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = new QFind.ReqReportDevs();
      ArrayList localArrayList1 = new ArrayList();
      QFind.DeviceInfo localDeviceInfo = new QFind.DeviceInfo();
      localDeviceInfo.pid.set(paramBlePeerInfo.jdField_a_of_type_Int);
      localDeviceInfo.service_uuid.set(2L);
      localDeviceInfo.sn.set(ByteStringMicro.copyFromUtf8(paramBlePeerInfo.a()));
      if (paramBoolean) {
        localDeviceInfo.bytes_sig.set(ByteStringMicro.copyFrom(paramBlePeerInfo.jdField_b_of_type_ArrayOfByte));
      }
      localDeviceInfo.timestamp.set((int)(l1 / 1000L));
      ArrayList localArrayList2 = new ArrayList();
      QFind.HistoryDetail localHistoryDetail = new QFind.HistoryDetail();
      localHistoryDetail.run.set(paramBlePeerInfo.f);
      localHistoryDetail.walk.set(paramBlePeerInfo.e);
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
    return jdField_c_of_type_Boolean;
  }
  
  private boolean a(BlePeerInfo paramBlePeerInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramBlePeerInfo.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(paramBlePeerInfo.a());
    paramBlePeerInfo = localStringBuilder.toString();
    return this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramBlePeerInfo);
  }
  
  private boolean a(BlePeerInfo paramBlePeerInfo, boolean paramBoolean)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if ((l2 <= 0L) || (l1 - l2 > this.jdField_c_of_type_Int))
    {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      this.g = 0;
    }
    if ((this.g > this.d) && (!paramBoolean)) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramBlePeerInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramBlePeerInfo.a());
    localObject = ((StringBuilder)localObject).toString();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject))
    {
      BlePeerInfo localBlePeerInfo = (BlePeerInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      localBlePeerInfo.f = paramBlePeerInfo.f;
      localBlePeerInfo.e = paramBlePeerInfo.e;
      if ((!paramBoolean) && (l1 - localBlePeerInfo.jdField_a_of_type_Long < this.jdField_a_of_type_Int)) {
        return false;
      }
      if ((paramBoolean) && (l1 - localBlePeerInfo.jdField_b_of_type_Long < this.e)) {
        return false;
      }
      if ((paramBoolean) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject)) && (l1 - ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(localObject)).longValue() > this.f) && (l1 - localBlePeerInfo.jdField_b_of_type_Long < this.jdField_a_of_type_Int))
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
      localBlePeerInfo.jdField_a_of_type_Long = l1;
      if (paramBoolean) {
        localBlePeerInfo.jdField_b_of_type_Long = l1;
      }
    }
    else
    {
      paramBlePeerInfo.jdField_a_of_type_Long = l1;
      if (paramBoolean) {
        paramBlePeerInfo.jdField_b_of_type_Long = l1;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject, paramBlePeerInfo);
    }
    localObject = (BlePeerInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (!((BlePeerInfo)localObject).jdField_b_of_type_Boolean)
    {
      ((BlePeerInfo)localObject).jdField_c_of_type_Int = paramBlePeerInfo.jdField_c_of_type_Int;
      ((BlePeerInfo)localObject).jdField_a_of_type_Boolean = false;
    }
    this.g += 1;
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    try
    {
      if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter == null) || (!this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled())) {
        break label146;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("call native mBluetoothAdapter.startLeScan with cb=");
        localStringBuilder.append(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
        localStringBuilder.append(", mScanning=");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.i("QFindBLE", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.startLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
      if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
        break label146;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new QFindBLEScanMgr.2(this), this.i);
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder;
      label141:
      break label141;
    }
    this.jdField_a_of_type_Boolean = false;
    label146:
    paramBoolean = this.jdField_a_of_type_Boolean;
    return this.jdField_a_of_type_Boolean;
    f();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      try
      {
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("call native mBluetoothAdapter.stopLeScan with cb=");
            localStringBuilder.append(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
            localStringBuilder.append(", mScanning=");
            localStringBuilder.append(this.jdField_a_of_type_Boolean);
            QLog.i("QFindBLE", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.stopLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
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
  
  private void c()
  {
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (str != null)
    {
      if ("".equals(str)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_SAME_DEVICE_INTERVAL");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.jdField_a_of_type_Int);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_ANY_DEVICE_INTERVAL");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.jdField_b_of_type_Int);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_OFTEN_FREQUENCE");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.d);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_OFTEN_PERIOD");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.jdField_c_of_type_Int);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_LAST_REPORT_PERIOD_START");
      localStringBuilder.append(str);
      localEditor.putLong(localStringBuilder.toString(), this.jdField_a_of_type_Long);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_LAST_REPORT_COUNT");
      localStringBuilder.append(str);
      localEditor.putInt(localStringBuilder.toString(), this.g);
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
  
  private void d()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (str != null)
    {
      if ("".equals(str)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_SAME_DEVICE_INTERVAL");
      localStringBuilder.append(str);
      this.jdField_a_of_type_Int = localSharedPreferences.getInt(localStringBuilder.toString(), 300000);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_ANY_DEVICE_INTERVAL");
      localStringBuilder.append(str);
      this.jdField_b_of_type_Int = localSharedPreferences.getInt(localStringBuilder.toString(), 300000);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_OFTEN_PERIOD");
      localStringBuilder.append(str);
      this.jdField_c_of_type_Int = localSharedPreferences.getInt(localStringBuilder.toString(), 3600000);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_REPORT_OFTEN_FREQUENCE");
      localStringBuilder.append(str);
      this.d = localSharedPreferences.getInt(localStringBuilder.toString(), 3600000);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_LAST_REPORT_COUNT");
      localStringBuilder.append(str);
      this.g = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFIND_SETTING_LAST_REPORT_PERIOD_START");
      localStringBuilder.append(str);
      this.jdField_a_of_type_Long = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
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
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null)
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("power")).newWakeLock(536870913, "QFindBLE");
      PowerManager.WakeLock localWakeLock = this.jdField_a_of_type_AndroidOsPowerManager$WakeLock;
      if (localWakeLock != null) {
        localWakeLock.acquire();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr acquireWakeLock");
      }
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLE", 2, "QFindBLEScanMgr cancelReceiver");
    }
    a(2);
    QFindBLEScanMgr.ScanReceiver localScanReceiver = this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$ScanReceiver;
    if (localScanReceiver != null) {
      try
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(localScanReceiver);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void g()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ble_scan_task", 0);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback = new QFindBLEScanMgr.3(this);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected PeerInfo a(BlePeerInfo paramBlePeerInfo)
  {
    PeerInfo localPeerInfo = new PeerInfo();
    localPeerInfo.jdField_a_of_type_Int = paramBlePeerInfo.jdField_c_of_type_Int;
    localPeerInfo.jdField_a_of_type_JavaLangString = paramBlePeerInfo.jdField_a_of_type_JavaLangString;
    localPeerInfo.jdField_b_of_type_JavaLangString = paramBlePeerInfo.jdField_b_of_type_JavaLangString;
    localPeerInfo.jdField_a_of_type_ArrayOfByte = paramBlePeerInfo.jdField_a_of_type_ArrayOfByte;
    localPeerInfo.jdField_a_of_type_JavaUtilList = paramBlePeerInfo.jdField_a_of_type_JavaUtilList;
    localPeerInfo.jdField_b_of_type_Int = paramBlePeerInfo.jdField_a_of_type_Int;
    return localPeerInfo;
  }
  
  public void a()
  {
    if (!a()) {
      return;
    }
    a(false);
    this.jdField_b_of_type_Boolean = false;
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 339	tencent/im/oidb/qfind/QFind$ReqReportDevs
    //   3: dup
    //   4: invokespecial 340	tencent/im/oidb/qfind/QFind$ReqReportDevs:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: invokevirtual 709	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   15: iconst_4
    //   16: aload_1
    //   17: invokevirtual 709	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   20: arraylength
    //   21: iconst_4
    //   22: isub
    //   23: invokevirtual 713	tencent/im/oidb/qfind/QFind$ReqReportDevs:mergeFrom	([BII)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   26: pop
    //   27: new 715	tencent/im/oidb/qfind/QFind$RspReportDevs
    //   30: dup
    //   31: invokespecial 716	tencent/im/oidb/qfind/QFind$RspReportDevs:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: aload_2
    //   37: invokevirtual 719	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   40: invokevirtual 722	tencent/im/oidb/qfind/QFind$RspReportDevs:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   43: pop
    //   44: aload_1
    //   45: invokevirtual 725	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   48: istore 4
    //   50: aload_0
    //   51: getfield 113	com/tencent/device/qfind/QFindBLEScanMgr:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   54: invokevirtual 729	java/util/HashMap:values	()Ljava/util/Collection;
    //   57: invokeinterface 735 1 0
    //   62: astore_1
    //   63: aload_1
    //   64: invokeinterface 740 1 0
    //   69: ifeq +20 -> 89
    //   72: iload 4
    //   74: aload_1
    //   75: invokeinterface 744 1 0
    //   80: checkcast 283	com/tencent/device/qfind/BlePeerInfo
    //   83: getfield 745	com/tencent/device/qfind/BlePeerInfo:jdField_b_of_type_Int	I
    //   86: if_icmpne -23 -> 63
    //   89: aload_3
    //   90: getfield 749	tencent/im/oidb/qfind/QFind$RspReportDevs:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   93: invokevirtual 753	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   96: istore 4
    //   98: iload 4
    //   100: ifne +644 -> 744
    //   103: new 103	java/util/ArrayList
    //   106: dup
    //   107: invokespecial 104	java/util/ArrayList:<init>	()V
    //   110: astore_2
    //   111: new 103	java/util/ArrayList
    //   114: dup
    //   115: invokespecial 104	java/util/ArrayList:<init>	()V
    //   118: astore_1
    //   119: aload 6
    //   121: getfield 429	tencent/im/oidb/qfind/QFind$ReqReportDevs:dev_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   124: invokevirtual 756	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   127: invokeinterface 757 1 0
    //   132: astore 7
    //   134: aload 7
    //   136: invokeinterface 740 1 0
    //   141: istore 5
    //   143: iload 5
    //   145: ifeq +98 -> 243
    //   148: aload 7
    //   150: invokeinterface 744 1 0
    //   155: checkcast 342	tencent/im/oidb/qfind/QFind$DeviceInfo
    //   158: astore 8
    //   160: new 221	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   167: astore 9
    //   169: aload 9
    //   171: ldc 243
    //   173: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 9
    //   179: aload 8
    //   181: getfield 347	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   184: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   187: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 9
    //   193: ldc 245
    //   195: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 9
    //   201: aload 8
    //   203: getfield 367	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   206: invokevirtual 761	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   209: invokevirtual 764	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   212: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 9
    //   218: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore 8
    //   223: aload_2
    //   224: aload 8
    //   226: invokevirtual 765	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: aload_0
    //   231: getfield 117	com/tencent/device/qfind/QFindBLEScanMgr:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   234: aload 8
    //   236: invokevirtual 768	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   239: pop
    //   240: goto -106 -> 134
    //   243: aload_3
    //   244: getfield 771	tencent/im/oidb/qfind/QFind$RspReportDevs:lost_devs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   247: invokevirtual 756	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   250: invokeinterface 757 1 0
    //   255: astore 7
    //   257: aload 7
    //   259: invokeinterface 740 1 0
    //   264: ifeq +281 -> 545
    //   267: aload 7
    //   269: invokeinterface 744 1 0
    //   274: checkcast 342	tencent/im/oidb/qfind/QFind$DeviceInfo
    //   277: astore 8
    //   279: new 221	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   286: astore 9
    //   288: aload 9
    //   290: ldc 243
    //   292: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 9
    //   298: aload 8
    //   300: getfield 347	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   303: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   306: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 9
    //   312: ldc 245
    //   314: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 9
    //   320: aload 8
    //   322: getfield 367	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   325: invokevirtual 761	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   328: invokevirtual 764	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   331: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 9
    //   337: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: astore 9
    //   342: aload_0
    //   343: getfield 117	com/tencent/device/qfind/QFindBLEScanMgr:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   346: aload 9
    //   348: invokevirtual 249	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   351: ifeq +13 -> 364
    //   354: aload_0
    //   355: getfield 117	com/tencent/device/qfind/QFindBLEScanMgr:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   358: aload 9
    //   360: invokevirtual 768	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: aload_0
    //   365: getfield 117	com/tencent/device/qfind/QFindBLEScanMgr:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   368: aload 9
    //   370: aload 8
    //   372: invokevirtual 529	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   375: pop
    //   376: new 221	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   383: astore 9
    //   385: aload 9
    //   387: ldc 243
    //   389: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 9
    //   395: aload 8
    //   397: getfield 347	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   400: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   403: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 9
    //   409: ldc 245
    //   411: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 9
    //   417: aload 8
    //   419: getfield 367	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   422: invokevirtual 761	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   425: invokevirtual 764	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   428: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_1
    //   433: aload 9
    //   435: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokevirtual 765	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   441: pop
    //   442: new 221	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   449: astore 9
    //   451: aload 9
    //   453: ldc 243
    //   455: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 9
    //   461: aload 8
    //   463: getfield 347	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   466: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   469: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload 9
    //   475: ldc 245
    //   477: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 9
    //   483: aload 8
    //   485: getfield 367	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   488: invokevirtual 761	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   491: invokevirtual 764	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   494: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload_2
    //   499: aload 9
    //   501: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokevirtual 773	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   507: pop
    //   508: aload 6
    //   510: getfield 460	tencent/im/oidb/qfind/QFind$ReqReportDevs:dev_loc	Ltencent/im/oidb/qfind/QFind$DeviceLoc;
    //   513: invokevirtual 776	tencent/im/oidb/qfind/QFind$DeviceLoc:has	()Z
    //   516: ifne -259 -> 257
    //   519: aload_0
    //   520: aload 8
    //   522: getfield 347	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   525: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   528: aload 8
    //   530: getfield 367	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   533: invokevirtual 761	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   536: invokevirtual 764	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   539: invokespecial 507	com/tencent/device/qfind/QFindBLEScanMgr:a	(ILjava/lang/String;)V
    //   542: goto -285 -> 257
    //   545: aload_2
    //   546: invokevirtual 777	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   549: astore_2
    //   550: aload_2
    //   551: invokeinterface 740 1 0
    //   556: ifeq +27 -> 583
    //   559: aload_2
    //   560: invokeinterface 744 1 0
    //   565: checkcast 599	java/lang/String
    //   568: astore 6
    //   570: aload_0
    //   571: getfield 115	com/tencent/device/qfind/QFindBLEScanMgr:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   574: aload 6
    //   576: invokevirtual 768	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: goto -30 -> 550
    //   583: aload_1
    //   584: invokevirtual 777	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   587: astore_1
    //   588: aload_1
    //   589: invokeinterface 740 1 0
    //   594: ifeq +42 -> 636
    //   597: aload_1
    //   598: invokeinterface 744 1 0
    //   603: checkcast 599	java/lang/String
    //   606: astore_2
    //   607: aload_0
    //   608: getfield 115	com/tencent/device/qfind/QFindBLEScanMgr:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   611: aload_2
    //   612: invokevirtual 249	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   615: ifne -27 -> 588
    //   618: aload_0
    //   619: getfield 115	com/tencent/device/qfind/QFindBLEScanMgr:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   622: aload_2
    //   623: invokestatic 275	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   626: invokestatic 780	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   629: invokevirtual 529	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   632: pop
    //   633: goto -45 -> 588
    //   636: aload_0
    //   637: aload_3
    //   638: getfield 783	tencent/im/oidb/qfind/QFind$RspReportDevs:report_same_dev_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   641: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   644: sipush 1000
    //   647: imul
    //   648: ldc 78
    //   650: invokestatic 789	java/lang/Math:max	(II)I
    //   653: putfield 80	com/tencent/device/qfind/QFindBLEScanMgr:jdField_a_of_type_Int	I
    //   656: aload_0
    //   657: aload_3
    //   658: getfield 792	tencent/im/oidb/qfind/QFind$RspReportDevs:report_any_devs_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   661: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   664: sipush 1000
    //   667: imul
    //   668: ldc 78
    //   670: invokestatic 789	java/lang/Math:max	(II)I
    //   673: putfield 82	com/tencent/device/qfind/QFindBLEScanMgr:jdField_b_of_type_Int	I
    //   676: aload_0
    //   677: aload_3
    //   678: getfield 795	tencent/im/oidb/qfind/QFind$RspReportDevs:report_often_period	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   681: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   684: sipush 1000
    //   687: imul
    //   688: ldc 83
    //   690: invokestatic 789	java/lang/Math:max	(II)I
    //   693: putfield 85	com/tencent/device/qfind/QFindBLEScanMgr:jdField_c_of_type_Int	I
    //   696: aload_0
    //   697: aload_3
    //   698: getfield 798	tencent/im/oidb/qfind/QFind$RspReportDevs:report_often_frequence	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   701: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   704: bipush 10
    //   706: invokestatic 789	java/lang/Math:max	(II)I
    //   709: putfield 87	com/tencent/device/qfind/QFindBLEScanMgr:d	I
    //   712: aload_0
    //   713: aload_3
    //   714: getfield 801	tencent/im/oidb/qfind/QFind$RspReportDevs:force_report_lbs_period	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   717: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   720: ldc 83
    //   722: invokestatic 789	java/lang/Math:max	(II)I
    //   725: putfield 91	com/tencent/device/qfind/QFindBLEScanMgr:f	I
    //   728: aload_0
    //   729: aload_3
    //   730: getfield 804	tencent/im/oidb/qfind/QFind$RspReportDevs:report_same_lost_devs_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   733: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   736: ldc 78
    //   738: invokestatic 789	java/lang/Math:max	(II)I
    //   741: putfield 89	com/tencent/device/qfind/QFindBLEScanMgr:e	I
    //   744: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   747: ifeq +562 -> 1309
    //   750: new 806	java/lang/StringBuffer
    //   753: dup
    //   754: invokespecial 807	java/lang/StringBuffer:<init>	()V
    //   757: astore_1
    //   758: new 221	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   765: astore_2
    //   766: aload_2
    //   767: ldc_w 809
    //   770: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: aload_2
    //   775: aload_3
    //   776: getfield 749	tencent/im/oidb/qfind/QFind$RspReportDevs:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   779: invokevirtual 753	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   782: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload_1
    //   787: aload_2
    //   788: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   794: pop
    //   795: new 221	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   802: astore_2
    //   803: aload_2
    //   804: ldc_w 814
    //   807: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload_2
    //   812: aload_3
    //   813: getfield 783	tencent/im/oidb/qfind/QFind$RspReportDevs:report_same_dev_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   816: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   819: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload_1
    //   824: aload_2
    //   825: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   831: pop
    //   832: new 221	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   839: astore_2
    //   840: aload_2
    //   841: ldc_w 816
    //   844: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: aload_2
    //   849: aload_3
    //   850: getfield 792	tencent/im/oidb/qfind/QFind$RspReportDevs:report_any_devs_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   853: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   856: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload_1
    //   861: aload_2
    //   862: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   868: pop
    //   869: new 221	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   876: astore_2
    //   877: aload_2
    //   878: ldc_w 818
    //   881: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: pop
    //   885: aload_2
    //   886: aload_3
    //   887: getfield 795	tencent/im/oidb/qfind/QFind$RspReportDevs:report_often_period	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   890: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   893: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload_1
    //   898: aload_2
    //   899: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   905: pop
    //   906: new 221	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   913: astore_2
    //   914: aload_2
    //   915: ldc_w 820
    //   918: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload_2
    //   923: aload_3
    //   924: getfield 798	tencent/im/oidb/qfind/QFind$RspReportDevs:report_often_frequence	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   927: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   930: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   933: pop
    //   934: aload_1
    //   935: aload_2
    //   936: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   942: pop
    //   943: new 221	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   950: astore_2
    //   951: aload_2
    //   952: ldc_w 822
    //   955: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: aload_2
    //   960: aload_3
    //   961: getfield 825	tencent/im/oidb/qfind/QFind$RspReportDevs:freq_limit_report_any_devs_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   964: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   967: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   970: pop
    //   971: aload_1
    //   972: aload_2
    //   973: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   979: pop
    //   980: new 221	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   987: astore_2
    //   988: aload_2
    //   989: ldc_w 827
    //   992: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload_2
    //   997: aload_3
    //   998: getfield 830	tencent/im/oidb/qfind/QFind$RspReportDevs:force_report_lbs	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1001: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1004: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1007: pop
    //   1008: aload_1
    //   1009: aload_2
    //   1010: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1016: pop
    //   1017: new 221	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1024: astore_2
    //   1025: aload_2
    //   1026: ldc_w 832
    //   1029: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload_2
    //   1034: aload_3
    //   1035: getfield 801	tencent/im/oidb/qfind/QFind$RspReportDevs:force_report_lbs_period	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1038: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1041: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: aload_1
    //   1046: aload_2
    //   1047: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1053: pop
    //   1054: new 221	java/lang/StringBuilder
    //   1057: dup
    //   1058: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1061: astore_2
    //   1062: aload_2
    //   1063: ldc_w 834
    //   1066: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: pop
    //   1070: aload_2
    //   1071: aload_3
    //   1072: getfield 804	tencent/im/oidb/qfind/QFind$RspReportDevs:report_same_lost_devs_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1075: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1078: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1081: pop
    //   1082: aload_1
    //   1083: aload_2
    //   1084: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1090: pop
    //   1091: new 221	java/lang/StringBuilder
    //   1094: dup
    //   1095: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1098: astore_2
    //   1099: aload_2
    //   1100: ldc_w 836
    //   1103: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: pop
    //   1107: aload_2
    //   1108: aload_3
    //   1109: getfield 839	tencent/im/oidb/qfind/QFind$RspReportDevs:report_max_dev_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1112: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1115: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload_1
    //   1120: aload_2
    //   1121: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1124: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1127: pop
    //   1128: aload_1
    //   1129: ldc_w 841
    //   1132: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1135: pop
    //   1136: aload_3
    //   1137: getfield 771	tencent/im/oidb/qfind/QFind$RspReportDevs:lost_devs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1140: invokevirtual 756	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1143: invokeinterface 757 1 0
    //   1148: astore_2
    //   1149: aload_2
    //   1150: invokeinterface 740 1 0
    //   1155: ifeq +102 -> 1257
    //   1158: aload_2
    //   1159: invokeinterface 744 1 0
    //   1164: checkcast 342	tencent/im/oidb/qfind/QFind$DeviceInfo
    //   1167: astore_3
    //   1168: new 221	java/lang/StringBuilder
    //   1171: dup
    //   1172: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1175: astore 6
    //   1177: aload 6
    //   1179: aload_3
    //   1180: getfield 347	tencent/im/oidb/qfind/QFind$DeviceInfo:pid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1183: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1186: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1189: pop
    //   1190: aload 6
    //   1192: ldc 245
    //   1194: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: pop
    //   1198: aload 6
    //   1200: aload_3
    //   1201: getfield 367	tencent/im/oidb/qfind/QFind$DeviceInfo:sn	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1204: invokevirtual 761	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1207: invokevirtual 764	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1210: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: pop
    //   1214: aload 6
    //   1216: ldc 245
    //   1218: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: pop
    //   1222: aload 6
    //   1224: aload_3
    //   1225: getfield 391	tencent/im/oidb/qfind/QFind$DeviceInfo:timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1228: invokevirtual 758	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1231: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1234: pop
    //   1235: aload 6
    //   1237: ldc_w 323
    //   1240: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: pop
    //   1244: aload_1
    //   1245: aload 6
    //   1247: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1253: pop
    //   1254: goto -105 -> 1149
    //   1257: aload_1
    //   1258: ldc_w 843
    //   1261: invokevirtual 812	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1264: pop
    //   1265: new 221	java/lang/StringBuilder
    //   1268: dup
    //   1269: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1272: astore_2
    //   1273: aload_2
    //   1274: ldc_w 845
    //   1277: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: pop
    //   1281: aload_2
    //   1282: aload_1
    //   1283: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1286: pop
    //   1287: ldc 233
    //   1289: iconst_2
    //   1290: aload_2
    //   1291: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1294: invokestatic 302	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1297: goto +12 -> 1309
    //   1300: astore_1
    //   1301: goto +14 -> 1315
    //   1304: astore_1
    //   1305: aload_1
    //   1306: invokevirtual 165	java/lang/Throwable:printStackTrace	()V
    //   1309: aload_0
    //   1310: iconst_3
    //   1311: invokespecial 504	com/tencent/device/qfind/QFindBLEScanMgr:a	(I)V
    //   1314: return
    //   1315: aload_0
    //   1316: iconst_3
    //   1317: invokespecial 504	com/tencent/device/qfind/QFindBLEScanMgr:a	(I)V
    //   1320: goto +5 -> 1325
    //   1323: aload_1
    //   1324: athrow
    //   1325: goto -2 -> 1323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1328	0	this	QFindBLEScanMgr
    //   0	1328	1	paramToServiceMsg	ToServiceMsg
    //   0	1328	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	1328	3	paramObject	Object
    //   48	51	4	k	int
    //   141	3	5	bool	boolean
    //   7	1239	6	localObject1	Object
    //   132	136	7	localIterator	java.util.Iterator
    //   158	371	8	localObject2	Object
    //   167	333	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	63	1300	finally
    //   63	89	1300	finally
    //   89	98	1300	finally
    //   103	134	1300	finally
    //   134	143	1300	finally
    //   148	240	1300	finally
    //   243	257	1300	finally
    //   257	364	1300	finally
    //   364	542	1300	finally
    //   545	550	1300	finally
    //   550	580	1300	finally
    //   583	588	1300	finally
    //   588	633	1300	finally
    //   636	744	1300	finally
    //   744	1149	1300	finally
    //   1149	1254	1300	finally
    //   1257	1297	1300	finally
    //   1305	1309	1300	finally
    //   0	63	1304	java/lang/Throwable
    //   63	89	1304	java/lang/Throwable
    //   89	98	1304	java/lang/Throwable
    //   103	134	1304	java/lang/Throwable
    //   134	143	1304	java/lang/Throwable
    //   148	240	1304	java/lang/Throwable
    //   243	257	1304	java/lang/Throwable
    //   257	364	1304	java/lang/Throwable
    //   364	542	1304	java/lang/Throwable
    //   545	550	1304	java/lang/Throwable
    //   550	580	1304	java/lang/Throwable
    //   583	588	1304	java/lang/Throwable
    //   588	633	1304	java/lang/Throwable
    //   636	744	1304	java/lang/Throwable
    //   744	1149	1304	java/lang/Throwable
    //   1149	1254	1304	java/lang/Throwable
    //   1257	1297	1304	java/lang/Throwable
  }
  
  public void b()
  {
    a();
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_MqqOsMqqHandler.getLooper().quit();
    }
    localObject = this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver((BroadcastReceiver)localObject);
      this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver = null;
    }
    localObject = this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter;
    if (localObject != null)
    {
      ((BluetoothAdapter)localObject).stopLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = null;
    }
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback != null) {
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quitSafely();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    QFindGattManager.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr
 * JD-Core Version:    0.7.0.1
 */