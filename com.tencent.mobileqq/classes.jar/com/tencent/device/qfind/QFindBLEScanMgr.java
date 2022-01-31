package com.tencent.device.qfind;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.qfind.QFind.DeviceInfo;
import tencent.im.oidb.qfind.QFind.DeviceLoc;
import tencent.im.oidb.qfind.QFind.HistoryData;
import tencent.im.oidb.qfind.QFind.HistoryDetail;
import tencent.im.oidb.qfind.QFind.ReqReportDevs;
import tencent.im.oidb.qfind.QFind.RspReportDevs;
import xzu;
import yak;
import ygb;
import ygi;
import ygj;
import ygk;
import ygl;

@TargetApi(18)
public class QFindBLEScanMgr
{
  private static String jdField_a_of_type_JavaLangString = "Q_Find_Scan_Intent";
  private static String jdField_b_of_type_JavaLangString = "com.tencent.mobileqq.msf.wakeup";
  private static boolean jdField_c_of_type_Boolean;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public BluetoothAdapter.LeScanCallback a;
  public BluetoothAdapter a;
  private Context jdField_a_of_type_AndroidContentContext;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private QFindBLEScanMgr.NotifyReceiver jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver;
  public QQAppInterface a;
  public ArrayList<String> a;
  public HashMap<String, ygb> a;
  public MqqHandler a;
  private ygl jdField_a_of_type_Ygl;
  public volatile boolean a;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  public ArrayList<Long> b;
  public HashMap<String, Long> b;
  public boolean b;
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  public HashMap<String, QFind.DeviceInfo> c;
  int d;
  int e;
  int f;
  int g;
  public int h;
  public int i;
  
  static
  {
    try
    {
      jdField_c_of_type_Boolean = BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr releaseWakeLock:" + paramInt);
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    paramString = "" + paramInt + "|" + paramString;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      SosoInterface.a(new ygj(this, 0, true, true, 0L, false, false, "smartdevice:lightapp", paramString));
    }
  }
  
  private void a(ygb paramygb, SosoInterface.SosoLbsInfo paramSosoLbsInfo, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        l1 = NetConnInfoCenter.getServerTimeMillis();
        if (this.jdField_b_of_type_Long > 0L)
        {
          long l2 = this.jdField_b_of_type_Long;
          if (l1 - l2 <= 600000L) {
            continue;
          }
        }
      }
      catch (Throwable paramygb)
      {
        long l1;
        paramygb.printStackTrace();
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("QFindBLE", 2, "SendReqReportAroundDevs  report exception :   " + paramygb.toString());
        return;
        QLog.i("QFindBLE", 1, "report lost dev sn=" + paramygb.a() + ", pid=" + paramygb.jdField_a_of_type_Int + " has loc(" + paramSosoLbsInfo.a.jdField_a_of_type_Double + "," + paramSosoLbsInfo.a.b + ", " + paramSosoLbsInfo.a.jdField_a_of_type_Float + "), ble_id = " + paramygb.jdField_c_of_type_Int + ", lastreportcount=" + this.g + ", run = " + paramygb.f + " , walk = " + paramygb.e);
        continue;
      }
      try
      {
        c();
        if (paramSosoLbsInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QFindBLE", 2, "start to report dev sn=" + paramygb.a() + ", pid=" + paramygb.jdField_a_of_type_Int + ", ble_id = " + paramygb.jdField_c_of_type_Int + ", lastreportcount=" + this.g + ", run = " + paramygb.f + " , walk = " + paramygb.e);
          }
          QFind.ReqReportDevs localReqReportDevs = new QFind.ReqReportDevs();
          ArrayList localArrayList1 = new ArrayList();
          QFind.DeviceInfo localDeviceInfo = new QFind.DeviceInfo();
          localDeviceInfo.pid.set(paramygb.jdField_a_of_type_Int);
          localDeviceInfo.service_uuid.set(2L);
          localDeviceInfo.sn.set(ByteStringMicro.copyFromUtf8(paramygb.a()));
          if (paramBoolean) {
            localDeviceInfo.bytes_sig.set(ByteStringMicro.copyFrom(paramygb.jdField_b_of_type_ArrayOfByte));
          }
          localDeviceInfo.timestamp.set((int)(l1 / 1000L));
          ArrayList localArrayList2 = new ArrayList();
          QFind.HistoryDetail localHistoryDetail = new QFind.HistoryDetail();
          localHistoryDetail.run.set(paramygb.f);
          localHistoryDetail.walk.set(paramygb.e);
          localArrayList2.add(localHistoryDetail);
          paramygb = new QFind.HistoryData();
          paramygb.details.set(localArrayList2);
          localDeviceInfo.msg_walking_history.set(paramygb);
          localArrayList1.add(localDeviceInfo);
          localReqReportDevs.dev_infos.set(localArrayList1);
          if (paramSosoLbsInfo != null)
          {
            paramygb = new QFind.DeviceLoc();
            paramygb.lat.set(Double.valueOf(paramSosoLbsInfo.a.jdField_a_of_type_Double * 1000000.0D).intValue());
            paramygb.lon.set(Double.valueOf(paramSosoLbsInfo.a.b * 1000000.0D).intValue());
            paramygb.gps_type.set(1);
            paramygb.uint32_precision.set((int)paramSosoLbsInfo.a.jdField_a_of_type_Float);
            localReqReportDevs.dev_loc.set(paramygb);
          }
          paramSosoLbsInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          paramygb = (yak)paramSosoLbsInfo.a(51);
          paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", paramSosoLbsInfo.getCurrentAccountUin(), "QFindSvc.ReqReportDevs");
          paramSosoLbsInfo.putWupBuffer(localReqReportDevs.toByteArray());
          paramygb.sendPbReq(paramSosoLbsInfo);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static boolean a()
  {
    return jdField_c_of_type_Boolean;
  }
  
  private boolean a(ygb paramygb)
  {
    paramygb = "" + paramygb.jdField_a_of_type_Int + "|" + paramygb.a();
    return this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramygb);
  }
  
  private boolean a(ygb paramygb, boolean paramBoolean)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if ((this.jdField_a_of_type_Long <= 0L) || (l - this.jdField_a_of_type_Long > this.jdField_c_of_type_Int))
    {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      this.g = 0;
    }
    if ((this.g > this.d) && (!paramBoolean)) {
      return false;
    }
    Object localObject = "" + paramygb.jdField_a_of_type_Int + "|" + paramygb.a();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject))
    {
      ygb localygb = (ygb)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      localygb.f = paramygb.f;
      localygb.e = paramygb.e;
      if ((!paramBoolean) && (l - localygb.jdField_a_of_type_Long < this.jdField_a_of_type_Int)) {
        return false;
      }
      if ((paramBoolean) && (l - localygb.jdField_b_of_type_Long < this.e)) {
        return false;
      }
      if ((paramBoolean) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject)) && (l - ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(localObject)).longValue() > this.f) && (l - localygb.jdField_b_of_type_Long < this.jdField_a_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE", 2, "report lost dev reach the period: " + this.f);
        }
        return false;
      }
      localygb.jdField_a_of_type_Long = l;
      if (paramBoolean) {
        localygb.jdField_b_of_type_Long = l;
      }
    }
    for (;;)
    {
      localObject = (ygb)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if (!((ygb)localObject).jdField_b_of_type_Boolean)
      {
        ((ygb)localObject).jdField_c_of_type_Int = paramygb.jdField_c_of_type_Int;
        ((ygb)localObject).jdField_a_of_type_Boolean = false;
      }
      this.g += 1;
      return true;
      paramygb.jdField_a_of_type_Long = l;
      if (paramBoolean) {
        paramygb.jdField_b_of_type_Long = l;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject, paramygb);
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      try
      {
        if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) && (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QFindBLE", 2, "call native mBluetoothAdapter.startLeScan with cb=" + this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback + ", mScanning=" + this.jdField_a_of_type_Boolean);
          }
          this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.startLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
          if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
            this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new QFindBLEScanMgr.2(this), this.i);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      if (this.jdField_a_of_type_Boolean) {}
      return this.jdField_a_of_type_Boolean;
      e();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        try
        {
          if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("QFindBLE", 2, "call native mBluetoothAdapter.stopLeScan with cb=" + this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback + ", mScanning=" + this.jdField_a_of_type_Boolean);
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
    }
    return true;
  }
  
  private void c()
  {
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if ((str == null) || ("".equals(str))) {
      return;
    }
    localEditor.putInt("QFIND_SETTING_REPORT_SAME_DEVICE_INTERVAL" + str, this.jdField_a_of_type_Int);
    localEditor.putInt("QFIND_SETTING_REPORT_ANY_DEVICE_INTERVAL" + str, this.jdField_b_of_type_Int);
    localEditor.putInt("QFIND_SETTING_REPORT_OFTEN_FREQUENCE" + str, this.d);
    localEditor.putInt("QFIND_SETTING_REPORT_OFTEN_PERIOD" + str, this.jdField_c_of_type_Int);
    localEditor.putLong("QFIND_SETTING_LAST_REPORT_PERIOD_START" + str, this.jdField_a_of_type_Long);
    localEditor.putInt("QFIND_SETTING_LAST_REPORT_COUNT" + str, this.g);
    localEditor.putInt("QFIND_SETTING_REPORT_SAME_LOST_DEVS_INTERVAL" + str, this.e);
    localEditor.putInt("QFIND_SETTING_REPORT_FORCE_REPORT_LBS_PERIOD" + str, this.f);
    localEditor.commit();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null)
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("power")).newWakeLock(536870913, "QFindBLE");
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr acquireWakeLock");
      }
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLE", 2, "QFindBLEScanMgr cancelReceiver");
    }
    a(2);
    if (this.jdField_a_of_type_Ygl != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ygl);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void f()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ble_scan_task", 0);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback = new ygk(this);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public ygi a(ygb paramygb)
  {
    ygi localygi = new ygi();
    localygi.jdField_a_of_type_Int = paramygb.jdField_c_of_type_Int;
    localygi.jdField_a_of_type_JavaLangString = paramygb.jdField_a_of_type_JavaLangString;
    localygi.jdField_b_of_type_JavaLangString = paramygb.jdField_b_of_type_JavaLangString;
    localygi.jdField_a_of_type_ArrayOfByte = paramygb.jdField_a_of_type_ArrayOfByte;
    localygi.jdField_a_of_type_JavaUtilList = paramygb.jdField_a_of_type_JavaUtilList;
    localygi.jdField_b_of_type_Int = paramygb.jdField_a_of_type_Int;
    return localygi;
  }
  
  public void a()
  {
    if (!a()) {
      return;
    }
    a(false);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1;
    try
    {
      localObject1 = new QFind.ReqReportDevs();
      ((QFind.ReqReportDevs)localObject1).mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
      paramObject = new QFind.RspReportDevs();
      paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
      int j = paramToServiceMsg.getAppSeq();
      paramToServiceMsg = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while ((paramToServiceMsg.hasNext()) && (j != ((ygb)paramToServiceMsg.next()).jdField_b_of_type_Int)) {}
      if (paramObject.result.get() != 0) {
        break label696;
      }
      paramFromServiceMsg = new ArrayList();
      paramToServiceMsg = new ArrayList();
      Iterator localIterator = ((QFind.ReqReportDevs)localObject1).dev_infos.get().iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (QFind.DeviceInfo)localIterator.next();
        localObject2 = "" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8();
        paramFromServiceMsg.add(localObject2);
        this.jdField_c_of_type_JavaUtilHashMap.remove(localObject2);
      }
      String str;
      paramFromServiceMsg = paramFromServiceMsg.iterator();
    }
    catch (Throwable paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      return;
      localIterator = paramObject.lost_devs.get().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (QFind.DeviceInfo)localIterator.next();
        str = "" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8();
        if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(str)) {
          this.jdField_c_of_type_JavaUtilHashMap.remove(str);
        }
        this.jdField_c_of_type_JavaUtilHashMap.put(str, localObject2);
        paramToServiceMsg.add("" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8());
        paramFromServiceMsg.remove("" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8());
        if (!((QFind.ReqReportDevs)localObject1).dev_loc.has()) {
          a(((QFind.DeviceInfo)localObject2).pid.get(), ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8());
        }
      }
    }
    finally
    {
      a(3);
    }
    while (paramFromServiceMsg.hasNext())
    {
      localObject1 = (String)paramFromServiceMsg.next();
      this.jdField_b_of_type_JavaUtilHashMap.remove(localObject1);
    }
    paramToServiceMsg = paramToServiceMsg.iterator();
    while (paramToServiceMsg.hasNext())
    {
      paramFromServiceMsg = (String)paramToServiceMsg.next();
      if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramFromServiceMsg)) {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramFromServiceMsg, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      }
    }
    this.jdField_a_of_type_Int = Math.max(paramObject.report_same_dev_interval.get() * 1000, 300000);
    this.jdField_b_of_type_Int = Math.max(paramObject.report_any_devs_interval.get() * 1000, 300000);
    this.jdField_c_of_type_Int = Math.max(paramObject.report_often_period.get() * 1000, 3600000);
    this.d = Math.max(paramObject.report_often_frequence.get(), 10);
    this.f = Math.max(paramObject.force_report_lbs_period.get(), 3600000);
    this.e = Math.max(paramObject.report_same_lost_devs_interval.get(), 300000);
    label696:
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuffer();
      paramToServiceMsg.append(", result=" + paramObject.result.get());
      paramToServiceMsg.append(", report_same_dev_interval=" + paramObject.report_same_dev_interval.get());
      paramToServiceMsg.append(", report_any_devs_interval=" + paramObject.report_any_devs_interval.get());
      paramToServiceMsg.append(", report_often_period=" + paramObject.report_often_period.get());
      paramToServiceMsg.append(", report_often_frequence=" + paramObject.report_often_frequence.get());
      paramToServiceMsg.append(", freq_limit_report_any_devs_interval=" + paramObject.freq_limit_report_any_devs_interval.get());
      paramToServiceMsg.append(", force_report_lbs=" + paramObject.force_report_lbs.get());
      paramToServiceMsg.append(", force_report_lbs_period=" + paramObject.force_report_lbs_period.get());
      paramToServiceMsg.append(", report_same_lost_devs_interval=" + paramObject.report_same_lost_devs_interval.get());
      paramToServiceMsg.append(", report_max_dev_num=" + paramObject.report_max_dev_num.get());
      paramToServiceMsg.append(", lost_devs=[");
      paramFromServiceMsg = paramObject.lost_devs.get().iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (QFind.DeviceInfo)paramFromServiceMsg.next();
        paramToServiceMsg.append(paramObject.pid.get() + "|" + paramObject.sn.get().toStringUtf8() + "|" + paramObject.timestamp.get() + ",");
      }
      paramToServiceMsg.append("]");
      QLog.w("QFindBLE", 2, "get report dev result " + paramToServiceMsg);
    }
    a(3);
  }
  
  public void b()
  {
    a();
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_MqqOsMqqHandler.getLooper().quit();
    }
    if (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver);
      this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver = null;
    }
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
    {
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.stopLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = null;
    }
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback != null) {
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    xzu.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr
 * JD-Core Version:    0.7.0.1
 */