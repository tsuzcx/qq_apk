package com.tencent.mfsdk.collector;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mfsdk.reporter.DFObservable;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;
import rij;
import rik;

@TargetApi(16)
public class DropFrameMonitor
{
  private static long jdField_a_of_type_Long;
  private static DropFrameMonitor jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor;
  private int jdField_a_of_type_Int;
  private Choreographer.FrameCallback jdField_a_of_type_AndroidViewChoreographer$FrameCallback;
  private Choreographer jdField_a_of_type_AndroidViewChoreographer;
  private final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(DropFrameMonitor.MonitorItem.class, 4);
  private DropFrameMonitor.MonitorItem jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem;
  private AbstractUnifiedMonitor.ThreadMonitorCallback jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = new rik(this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long d;
  
  @TargetApi(17)
  private float a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    if (Build.VERSION.SDK_INT >= 17) {
      try
      {
        float f = ((DisplayManager)localBaseApplicationImpl.getSystemService("display")).getDisplay(0).getRefreshRate();
        return f;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AutoMonitor.DropFrame", 2, "", localException);
        }
      }
    }
    return 60.0F;
  }
  
  private final int a(int paramInt)
  {
    int i = 1;
    if (paramInt <= 0) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
    }
    if (paramInt < 4) {
      return 2;
    }
    if (paramInt < 8) {
      return 3;
    }
    if (paramInt < 15) {
      return 4;
    }
    return 5;
  }
  
  private final long a(long paramLong)
  {
    return paramLong / 1000000L;
  }
  
  public static DropFrameMonitor a()
  {
    if (jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor == null) {
        jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor = new DropFrameMonitor();
      }
      return jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor;
    }
    finally {}
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  private boolean a()
  {
    return 1 == BaseApplicationImpl.sProcessId;
  }
  
  private boolean b()
  {
    return 2 == BaseApplicationImpl.sProcessId;
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem == null)
    {
      this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      this.d = 0L;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public int a()
  {
    return UnifiedMonitor.a().getThreshold(9);
  }
  
  public void a(long paramLong)
  {
    long l = paramLong - this.d;
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem != null)
    {
      if (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_b_of_type_Long == 0L) {
        this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_b_of_type_Long = paramLong;
      }
    }
    else if ((a()) && (this.jdField_b_of_type_Boolean))
    {
      if ((this.d == 0L) || (l <= this.jdField_b_of_type_Long)) {
        break label225;
      }
      if (UnifiedMonitor.a().whetherReportThisTime(10)) {
        break label186;
      }
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      if (UnifiedMonitor.a().whetherStackEnabled(10)) {
        UnifiedMonitor.a().reportStackIfTimeout(10);
      }
      this.d = paramLong;
      this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      return;
      int i = a((int)((l - this.jdField_c_of_type_Long) / this.jdField_c_of_type_Long));
      Object localObject = this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem;
      ((DropFrameMonitor.MonitorItem)localObject).jdField_a_of_type_Long += 1L;
      localObject = this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_ArrayOfLong;
      localObject[i] += 1L;
      this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_c_of_type_Long = paramLong;
      break;
      label186:
      localObject = UnifiedMonitor.a();
      UnifiedMonitor.a().addEvent(10, null, (int)a(paramLong - this.d), this.jdField_a_of_type_Int, (Map)localObject);
      this.jdField_a_of_type_Int = 0;
      continue;
      label225:
      if (UnifiedMonitor.a().whetherStackEnabled(10)) {
        UnifiedMonitor.a().notifyNotTimeout(10);
      }
      this.jdField_a_of_type_Int += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(9)) {}
    while ((!UnifiedMonitor.a().whetherReportThisTime(9)) || (!this.jdField_a_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem != null) && (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_JavaLangString.equals(paramString)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem = ((DropFrameMonitor.MonitorItem)this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(DropFrameMonitor.MonitorItem.class));
    this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_JavaLangString = paramString;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem != null) {
      if (!paramBoolean)
      {
        l1 = a(this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_c_of_type_Long - this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_b_of_type_Long);
        if ((this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_Long > 0L) && (l1 > a()))
        {
          long l2 = (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_c_of_type_Long - this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_b_of_type_Long) / this.jdField_c_of_type_Long + 1L - this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            Log.d("AutoMonitor.DropFrame", "tag = " + paramString + ", dropCount = " + l2 + ", " + Arrays.toString(this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_ArrayOfLong) + ", totalMs = " + l1);
          }
          if (b()) {}
          paramString = new HashMap(10);
          paramString.put("dropCount", String.valueOf(l2));
          paramString.put("totalMs", String.valueOf(l1));
          paramString.put("scene", this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_JavaLangString);
          paramString.put("dropTimes", Arrays.toString(this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_ArrayOfLong));
          paramString.put("isFirstLaunch", String.valueOf(BaseApplicationImpl.isFirstLaunchNew));
          if (jdField_a_of_type_Long <= 0L) {
            break label340;
          }
        }
      }
    }
    label340:
    for (long l1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;; l1 = -1L)
    {
      paramString.put("intervalAfterSyncMsg", String.valueOf(l1));
      UnifiedMonitor.a().addEvent(9, null, 0, 0, paramString);
      DFObservable.a().a(paramString);
      this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem);
      this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem = null;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
        this.d = 0L;
      }
      this.jdField_c_of_type_Boolean = false;
      return;
    }
  }
  
  @Deprecated
  public void b()
  {
    UnifiedMonitor.a().a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    float f;
    do
    {
      do
      {
        return;
        if (Build.VERSION.SDK_INT >= 16) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AutoMonitor.DropFrame", 2, "build version is low");
      return;
      f = a();
      if ((f >= 58.0F) && (f <= 62.0F)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AutoMonitor.DropFrame", 2, "refresh rate is valid, " + f);
    return;
    try
    {
      this.jdField_a_of_type_AndroidViewChoreographer = Choreographer.getInstance();
      this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback = new rij(this);
      this.jdField_c_of_type_Long = ((1.0E+009F / f));
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public String toString()
  {
    if (this.jdField_c_of_type_Boolean) {
      return "y";
    }
    return "n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mfsdk.collector.DropFrameMonitor
 * JD-Core Version:    0.7.0.1
 */