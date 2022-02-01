package com.tencent.av.utils;

import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class FramePerfData
{
  private static float jdField_c_of_type_Float = 0.02F;
  private static long m = 0L;
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
    float f1;
    if (paramFloat == 0.0F) {
      f1 = (float)paramLong;
    }
    do
    {
      return f1;
      f1 = paramFloat;
    } while (paramLong == 0L);
    return (1.0F - jdField_c_of_type_Float) * paramFloat + (float)paramLong * jdField_c_of_type_Float;
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
    if (paramLong1 == 0L) {}
    while (paramLong2 == 0L) {
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
    if ((bool) || (AudioHelper.a(18) == 1))
    {
      int i1 = a(this.jdField_a_of_type_Float);
      int i2 = a(this.jdField_b_of_type_Float);
      String str = "frameIndex[" + this.jdField_a_of_type_ComTencentAvUtilsFramePerfData + "->" + this.o + "], dataLen[" + this.jdField_b_of_type_Int + "], width[" + this.jdField_c_of_type_Int + "], height[" + this.jdField_d_of_type_Int + "], format[" + this.jdField_e_of_type_Int + "], CamAngle[" + this.jdField_f_of_type_Int + "], FinalAngle[" + this.jdField_h_of_type_Int + "], CamFPS[" + this.n + "], PreviewDataFPS[" + i1 + "], SendFPS[" + i2 + "], isFront[" + this.jdField_c_of_type_Boolean + "], effect[" + this.jdField_d_of_type_Boolean + "], business[" + String.format("%08x", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }) + "]";
      paramString = null;
      if (b()) {
        paramString = ", intervalPreviewData[" + this.jdField_b_of_type_Long + "], intervalSendCameraFrame2Native[" + this.l + "], render[" + a(this.j, this.jdField_c_of_type_Long) + "], CheckLowligh[" + a(this.jdField_d_of_type_Long, this.jdField_c_of_type_Long) + "], Beauty2[" + a(this.jdField_e_of_type_Long, this.jdField_d_of_type_Long) + "], DenoiseRender[" + a(this.jdField_f_of_type_Long, this.jdField_e_of_type_Long) + "], LowLightRender[" + a(this.jdField_g_of_type_Long, this.jdField_f_of_type_Long) + "], Beauty3[" + a(this.jdField_h_of_type_Long, this.jdField_g_of_type_Long) + "], RenderChain[" + a(this.i, this.jdField_h_of_type_Long) + "], post[" + a(this.j, this.i) + "], buildExtInfo[" + a(this.k, this.j) + "]";
      }
      paramString = "PerfLog, " + str + paramString;
      paramString = paramString + ", onPreviewData[" + this.jdField_a_of_type_Long + "], renderBegin[" + this.jdField_c_of_type_Long + "], afterCheckLowligh[" + this.jdField_d_of_type_Long + "], afterDenoiseRender[" + this.jdField_f_of_type_Long + "], afterLowLightRender[" + this.jdField_g_of_type_Long + "], afterBeautyRender[" + this.jdField_h_of_type_Long + "], afterRenderChain[" + this.i + "], renderEnd[" + this.j + "], sendCameraFrame2Native[" + this.k + "]";
      if (bool) {
        QLog.w("FramePerfDataK_" + this.jdField_b_of_type_Boolean, 1, paramString);
      }
    }
    else
    {
      return;
    }
    QLog.w("FramePerfData_" + this.jdField_b_of_type_Boolean, 1, paramString);
  }
  
  public static boolean b()
  {
    return QLog.isColorLevel();
  }
  
  void a()
  {
    float f2 = 0.0F;
    for (FramePerfData localFramePerfData = this.jdField_a_of_type_ComTencentAvUtilsFramePerfData; (localFramePerfData != null) && (!localFramePerfData.jdField_a_of_type_Boolean); localFramePerfData = localFramePerfData.jdField_a_of_type_ComTencentAvUtilsFramePerfData) {
      localFramePerfData.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentAvUtilsFramePerfData = localFramePerfData;
    if (localFramePerfData != null)
    {
      if (localFramePerfData.jdField_a_of_type_Long != 0L) {
        this.jdField_b_of_type_Long = (this.jdField_a_of_type_Long - localFramePerfData.jdField_a_of_type_Long);
      }
      if (localFramePerfData.k != 0L) {
        this.l = (this.k - localFramePerfData.k);
      }
    }
    if (localFramePerfData == null)
    {
      f1 = 0.0F;
      this.jdField_a_of_type_Float = a(f1, this.jdField_b_of_type_Long / 1000L);
      if (localFramePerfData != null) {
        break label137;
      }
    }
    label137:
    for (float f1 = f2;; f1 = localFramePerfData.jdField_b_of_type_Float)
    {
      this.jdField_b_of_type_Float = a(f1, this.l / 1000L);
      return;
      f1 = localFramePerfData.jdField_a_of_type_Float;
      break;
    }
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
  
  public void a(boolean paramBoolean)
  {
    if (b())
    {
      this.jdField_e_of_type_Long = AudioHelper.c();
      if (paramBoolean) {
        this.jdField_a_of_type_Int |= 0x1;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (b())
    {
      this.i = AudioHelper.c();
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
      this.jdField_a_of_type_Long = AudioHelper.c();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (b())
    {
      this.jdField_f_of_type_Long = AudioHelper.c();
      if (paramBoolean) {
        this.jdField_a_of_type_Int |= 0x2;
      }
    }
  }
  
  public void c()
  {
    if (b()) {
      this.jdField_c_of_type_Long = AudioHelper.c();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (b())
    {
      this.jdField_g_of_type_Long = AudioHelper.c();
      if (paramBoolean) {
        this.jdField_a_of_type_Int |= 0x4;
      }
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
      if ((localFramePerfData.jdField_b_of_type_Int != this.jdField_b_of_type_Int) || (localFramePerfData.jdField_c_of_type_Int != this.jdField_c_of_type_Int) || (localFramePerfData.jdField_d_of_type_Int != this.jdField_d_of_type_Int) || (localFramePerfData.jdField_e_of_type_Int != this.jdField_e_of_type_Int) || (localFramePerfData.jdField_f_of_type_Int != this.jdField_f_of_type_Int) || (localFramePerfData.jdField_g_of_type_Int != this.jdField_g_of_type_Int) || (localFramePerfData.n != this.n) || (localFramePerfData.jdField_c_of_type_Boolean != this.jdField_c_of_type_Boolean) || (localFramePerfData.jdField_d_of_type_Boolean != this.jdField_d_of_type_Boolean) || (localFramePerfData.jdField_h_of_type_Int != this.jdField_h_of_type_Int) || (localFramePerfData.jdField_a_of_type_Int != this.jdField_a_of_type_Int) || (localFramePerfData.o + 1L != this.o))
      {
        m = System.currentTimeMillis();
        return true;
      }
    }
    else
    {
      m = System.currentTimeMillis();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    if (b()) {
      this.j = AudioHelper.c();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (b())
    {
      this.jdField_h_of_type_Long = AudioHelper.c();
      if (paramBoolean) {
        this.jdField_a_of_type_Int |= 0x8;
      }
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
    if (b()) {
      this.jdField_d_of_type_Long = AudioHelper.c();
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    if (b()) {
      this.k = AudioHelper.c();
    }
    a("finish");
  }
  
  public String toString()
  {
    return this.o + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.FramePerfData
 * JD-Core Version:    0.7.0.1
 */