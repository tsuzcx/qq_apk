package com.tencent.biz.pubaccount.util.monitor;

import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;

@RequiresApi(api=16)
class DropFrameCollector
  implements Choreographer.FrameCallback
{
  private static float jdField_a_of_type_Float;
  private static float[] jdField_a_of_type_ArrayOfFloat;
  private static float jdField_b_of_type_Float;
  private static float jdField_c_of_type_Float;
  private static float jdField_d_of_type_Float;
  private static float jdField_e_of_type_Float;
  private static float f;
  private static float g;
  private static float h;
  private static float i;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 0L;
  private Choreographer jdField_a_of_type_AndroidViewChoreographer;
  private DropFrameCollector.DropFrameCallback jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameCollector$DropFrameCallback;
  private DropFrameData jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameData;
  private StackSampler jdField_a_of_type_ComTencentBizPubaccountUtilMonitorStackSampler;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = 0L;
  private long jdField_c_of_type_Long = 0L;
  private long jdField_d_of_type_Long = 0L;
  private long jdField_e_of_type_Long = 0L;
  private float j = 0.0F;
  private float k = 0.0F;
  private float l = 0.0F;
  
  @RequiresApi(api=16)
  public DropFrameCollector(DropFrameCollector.DropFrameCallback paramDropFrameCallback, WindowManager paramWindowManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameCollector$DropFrameCallback = paramDropFrameCallback;
    this.jdField_a_of_type_AndroidViewChoreographer = Choreographer.getInstance();
    this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorStackSampler = new StackSampler();
    a(paramWindowManager);
  }
  
  private final float a(double paramDouble, int paramInt)
  {
    return (float)Math.round(paramInt * paramDouble) / paramInt;
  }
  
  private static final int a(int paramInt)
  {
    int m = 1;
    if (paramInt <= 0) {
      m = 0;
    }
    while (paramInt == 1) {
      return m;
    }
    if (paramInt <= 4) {
      return 2;
    }
    if (paramInt <= 8) {
      return 3;
    }
    if (paramInt <= 15) {
      return 4;
    }
    return 5;
  }
  
  private void a(long paramLong, DropFrameData paramDropFrameData)
  {
    if ((paramDropFrameData != null) && (!TextUtils.isEmpty(paramDropFrameData.jdField_a_of_type_JavaLangString)))
    {
      if (paramDropFrameData.jdField_b_of_type_Long != 0L) {
        break label34;
      }
      paramDropFrameData.jdField_b_of_type_Long = paramLong;
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = paramLong;
      return;
      label34:
      int m = (int)(((float)(paramLong - this.jdField_b_of_type_Long) - h) / h);
      int n = a(m);
      paramDropFrameData.jdField_a_of_type_Long += 1L;
      long[] arrayOfLong = paramDropFrameData.jdField_a_of_type_ArrayOfLong;
      arrayOfLong[n] += 1L;
      paramDropFrameData.jdField_c_of_type_Long = paramLong;
      if (m >= 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FPSMonitor", 2, "catch drop frame: dropCount=" + m);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorStackSampler.a(this.jdField_b_of_type_Long, paramLong);
      }
    }
  }
  
  private final void a(WindowManager paramWindowManager)
  {
    if (h <= 0.0F)
    {
      g = paramWindowManager.getDefaultDisplay().getRefreshRate();
      if (g > 0.0F)
      {
        i = 1000.0F / g;
        h = 1.0E+009F / g;
      }
      if (i > 0.0F)
      {
        jdField_a_of_type_Float = i;
        jdField_b_of_type_Float = i * 1.5F;
        jdField_c_of_type_Float = i * 3.0F;
        jdField_d_of_type_Float = i * 6.0F;
        jdField_e_of_type_Float = i * 11.5F;
        f = i * 15.0F;
      }
      jdField_a_of_type_ArrayOfFloat = new float[] { jdField_a_of_type_Float, jdField_b_of_type_Float, jdField_c_of_type_Float, jdField_d_of_type_Float, jdField_e_of_type_Float, f };
    }
    if (QLog.isColorLevel()) {
      QLog.d("FPSMonitor", 2, "init: sVsyncIntervalMs=" + i);
    }
  }
  
  @RequiresApi(api=16)
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this);
  }
  
  @RequiresApi(api=16)
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this);
  }
  
  public void doFrame(long paramLong)
  {
    a(paramLong, this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameData);
    if (this.jdField_a_of_type_Long <= 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this);
      return;
      long l1 = TimeUnit.NANOSECONDS.toMillis(paramLong - this.jdField_a_of_type_Long);
      this.jdField_c_of_type_Long += 1L;
      if (l1 > 500L)
      {
        float f1 = (float)(this.jdField_c_of_type_Long * 1000L) / (float)l1;
        this.jdField_c_of_type_Long = 0L;
        this.j = a(f1, 100);
        this.jdField_a_of_type_Long = paramLong;
        this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorDropFrameCollector$DropFrameCallback.a(this.j, this.k, this.l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.DropFrameCollector
 * JD-Core Version:    0.7.0.1
 */