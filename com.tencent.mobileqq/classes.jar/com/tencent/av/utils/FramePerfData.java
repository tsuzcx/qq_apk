package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

@TargetApi(17)
public class FramePerfData
{
  private static long m;
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  public FramePerfData a;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  private int jdField_f_of_type_Int = 0;
  private long jdField_f_of_type_Long = 0L;
  private int jdField_g_of_type_Int = 0;
  private long jdField_g_of_type_Long = 0L;
  private int jdField_h_of_type_Int = 0;
  private long jdField_h_of_type_Long = 0L;
  private long i = 0L;
  private long j = 0L;
  private long k = 0L;
  private long l = 0L;
  private long n = 0L;
  private final long o;
  
  public FramePerfData(FramePerfData paramFramePerfData, long paramLong)
  {
    this.o = paramLong;
    this.jdField_a_of_type_ComTencentAvUtilsFramePerfData = paramFramePerfData;
  }
  
  static float a(float paramFloat, long paramLong)
  {
    if (paramFloat == 0.0F) {
      return (float)paramLong;
    }
    if (paramLong == 0L) {
      return paramFloat;
    }
    return paramFloat * 0.98F + (float)paramLong * 0.02F;
  }
  
  static int a(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(1000000.0F / paramFloat * 100.0F);
  }
  
  static long a(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 0L) {
      return 0L;
    }
    if (paramLong2 == 0L) {
      return 0L;
    }
    return paramLong1 - paramLong2;
  }
  
  private void a(String paramString)
  {
    a();
    b(paramString);
    this.jdField_a_of_type_ComTencentAvUtilsFramePerfData = null;
  }
  
  public static boolean a()
  {
    return true;
  }
  
  private void b(String paramString)
  {
    boolean bool = c();
    if (bool)
    {
      int i1 = a(this.jdField_a_of_type_Float);
      int i2 = a(this.jdField_b_of_type_Float);
      paramString = new StringBuilder();
      paramString.append("frameIndex[");
      paramString.append(this.jdField_a_of_type_ComTencentAvUtilsFramePerfData);
      paramString.append("->");
      paramString.append(this.o);
      paramString.append("], dataLen[");
      paramString.append(this.jdField_b_of_type_Int);
      paramString.append("], width[");
      paramString.append(this.jdField_c_of_type_Int);
      paramString.append("], height[");
      paramString.append(this.jdField_d_of_type_Int);
      paramString.append("], format[");
      paramString.append(this.jdField_e_of_type_Int);
      paramString.append("], CamAngle[");
      paramString.append(this.jdField_f_of_type_Int);
      paramString.append("], FinalAngle[");
      paramString.append(this.jdField_h_of_type_Int);
      paramString.append("], CamFPS[");
      paramString.append(this.n);
      paramString.append("], PreviewDataFPS[");
      paramString.append(i1);
      paramString.append("], SendFPS[");
      paramString.append(i2);
      paramString.append("], isFront[");
      paramString.append(this.jdField_c_of_type_Boolean);
      paramString.append("], effect[");
      paramString.append(this.jdField_d_of_type_Boolean);
      paramString.append("], business[");
      paramString.append(String.format("%08x", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      paramString.append("]");
      Object localObject = paramString.toString();
      paramString = null;
      if (b())
      {
        paramString = new StringBuilder();
        paramString.append(", intervalPreviewData[");
        paramString.append(this.jdField_b_of_type_Long);
        paramString.append("], intervalSendCameraFrame2Native[");
        paramString.append(this.l);
        paramString.append("], render[");
        paramString.append(a(this.j, this.jdField_c_of_type_Long));
        paramString.append("], CheckLowligh[");
        paramString.append(a(this.jdField_d_of_type_Long, this.jdField_c_of_type_Long));
        paramString.append("], Beauty2[");
        paramString.append(a(this.jdField_e_of_type_Long, this.jdField_d_of_type_Long));
        paramString.append("], DenoiseRender[");
        paramString.append(a(this.jdField_f_of_type_Long, this.jdField_e_of_type_Long));
        paramString.append("], LowLightRender[");
        paramString.append(a(this.jdField_g_of_type_Long, this.jdField_f_of_type_Long));
        paramString.append("], Beauty3[");
        paramString.append(a(this.jdField_h_of_type_Long, this.jdField_g_of_type_Long));
        paramString.append("], RenderChain[");
        paramString.append(a(this.i, this.jdField_h_of_type_Long));
        paramString.append("], post[");
        paramString.append(a(this.j, this.i));
        paramString.append("], buildExtInfo[");
        paramString.append(a(this.k, this.j));
        paramString.append("]");
        paramString = paramString.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PerfLog, ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", onPreviewData[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("], renderBegin[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject).append("], afterCheckLowligh[");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
      ((StringBuilder)localObject).append("], afterDenoiseRender[");
      ((StringBuilder)localObject).append(this.jdField_f_of_type_Long);
      ((StringBuilder)localObject).append("], afterLowLightRender[");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_Long);
      ((StringBuilder)localObject).append("], afterBeautyRender[");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_Long);
      ((StringBuilder)localObject).append("], afterRenderChain[");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append("], renderEnd[");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append("], sendCameraFrame2Native[");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append("]");
      paramString = ((StringBuilder)localObject).toString();
      if (bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FramePerfDataK_");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        QLog.w(((StringBuilder)localObject).toString(), 1, paramString);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FramePerfData_");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.w(((StringBuilder)localObject).toString(), 1, paramString);
    }
  }
  
  public static boolean b()
  {
    return QLog.isColorLevel();
  }
  
  void a()
  {
    for (FramePerfData localFramePerfData = this.jdField_a_of_type_ComTencentAvUtilsFramePerfData; (localFramePerfData != null) && (!localFramePerfData.jdField_a_of_type_Boolean); localFramePerfData = localFramePerfData.jdField_a_of_type_ComTencentAvUtilsFramePerfData) {
      localFramePerfData.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentAvUtilsFramePerfData = localFramePerfData;
    if (localFramePerfData != null)
    {
      long l1 = localFramePerfData.jdField_a_of_type_Long;
      if (l1 != 0L) {
        this.jdField_b_of_type_Long = (this.jdField_a_of_type_Long - l1);
      }
      l1 = localFramePerfData.k;
      if (l1 != 0L) {
        this.l = (this.k - l1);
      }
    }
    float f2 = 0.0F;
    float f1;
    if (localFramePerfData == null) {
      f1 = 0.0F;
    } else {
      f1 = localFramePerfData.jdField_a_of_type_Float;
    }
    this.jdField_a_of_type_Float = a(f1, this.jdField_b_of_type_Long / 1000L);
    if (localFramePerfData == null) {
      f1 = f2;
    } else {
      f1 = localFramePerfData.jdField_b_of_type_Float;
    }
    this.jdField_b_of_type_Float = a(f1, this.l / 1000L);
  }
  
  public void a(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt3;
    this.jdField_e_of_type_Int = paramInt4;
    this.jdField_f_of_type_Int = paramInt5;
    this.jdField_g_of_type_Int = paramInt6;
    this.n = paramLong;
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (b())
    {
      this.i = SystemClock.elapsedRealtimeNanos();
      if (paramBoolean1) {
        this.jdField_a_of_type_Int |= 0x20;
      }
      if (paramBoolean2) {
        this.jdField_a_of_type_Int |= 0x10;
      }
      if (paramBoolean3) {
        this.jdField_a_of_type_Int |= 0x40;
      }
      if (paramBoolean4) {
        this.jdField_a_of_type_Int |= 0x80;
      }
    }
  }
  
  public void b()
  {
    if (b()) {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
    }
  }
  
  public void c()
  {
    if (b()) {
      this.jdField_c_of_type_Long = SystemClock.elapsedRealtimeNanos();
    }
  }
  
  boolean c()
  {
    if (System.currentTimeMillis() - m >= 4000L)
    {
      m = System.currentTimeMillis();
      return true;
    }
    FramePerfData localFramePerfData = this.jdField_a_of_type_ComTencentAvUtilsFramePerfData;
    if (localFramePerfData != null)
    {
      if ((localFramePerfData.jdField_b_of_type_Int == this.jdField_b_of_type_Int) && (localFramePerfData.jdField_c_of_type_Int == this.jdField_c_of_type_Int) && (localFramePerfData.jdField_d_of_type_Int == this.jdField_d_of_type_Int) && (localFramePerfData.jdField_e_of_type_Int == this.jdField_e_of_type_Int) && (localFramePerfData.jdField_f_of_type_Int == this.jdField_f_of_type_Int) && (localFramePerfData.jdField_g_of_type_Int == this.jdField_g_of_type_Int) && (localFramePerfData.n == this.n) && (localFramePerfData.jdField_c_of_type_Boolean == this.jdField_c_of_type_Boolean) && (localFramePerfData.jdField_d_of_type_Boolean == this.jdField_d_of_type_Boolean) && (localFramePerfData.jdField_h_of_type_Int == this.jdField_h_of_type_Int) && (localFramePerfData.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (localFramePerfData.o + 1L == this.o)) {
        return false;
      }
      m = System.currentTimeMillis();
      return true;
    }
    m = System.currentTimeMillis();
    return true;
  }
  
  public void d()
  {
    if (b()) {
      this.j = SystemClock.elapsedRealtimeNanos();
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    a("clear");
    return false;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    if (b()) {
      this.k = SystemClock.elapsedRealtimeNanos();
    }
    a("finish");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.o);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.FramePerfData
 * JD-Core Version:    0.7.0.1
 */