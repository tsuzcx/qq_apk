package com.tencent.av.opengl.effects;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import com.tencent.av.utils.FramePerfData;
import com.tencent.qphone.base.util.QLog;

public class CameraFrame
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString;
  private static CameraFrame jdField_b_of_type_ComTencentAvOpenglEffectsCameraFrame;
  static long d;
  static long e;
  private static long g;
  private static int h = 0;
  private static int i;
  public int a;
  public long a;
  public SurfaceTexture a;
  private CameraFrame jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame;
  public FramePerfData a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  private boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  private boolean c;
  public int d;
  public int e;
  public int f;
  private long f;
  public int g;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    i = 0;
    jdField_g_of_type_Long = 0L;
    jdField_d_of_type_Long = 0L;
    jdField_e_of_type_Long = 0L;
  }
  
  private CameraFrame()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public static CameraFrame a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_ComTencentAvOpenglEffectsCameraFrame != null)
      {
        CameraFrame localCameraFrame = jdField_b_of_type_ComTencentAvOpenglEffectsCameraFrame;
        jdField_b_of_type_ComTencentAvOpenglEffectsCameraFrame = localCameraFrame.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame;
        localCameraFrame.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame = null;
        h -= 1;
        localCameraFrame.jdField_c_of_type_Boolean = false;
        return localCameraFrame;
      }
      return new CameraFrame();
    }
  }
  
  public static void a(SurfaceTexture paramSurfaceTexture)
  {
    jdField_d_of_type_Long += 1L;
  }
  
  static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    i = 0;
    jdField_g_of_type_Long = 0L;
  }
  
  public static boolean a(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool;
    if (jdField_d_of_type_Long == jdField_e_of_type_Long) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFrameDealRight, count[");
      localStringBuilder.append(jdField_d_of_type_Long);
      localStringBuilder.append(",");
      localStringBuilder.append(jdField_e_of_type_Long);
      localStringBuilder.append("], surfaceTexture[");
      localStringBuilder.append(paramSurfaceTexture);
      localStringBuilder.append("]");
      QLog.i("SurfaceTag", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static void b(SurfaceTexture paramSurfaceTexture)
  {
    jdField_e_of_type_Long += 1L;
  }
  
  public static void c(SurfaceTexture paramSurfaceTexture)
  {
    jdField_d_of_type_Long = 0L;
    jdField_e_of_type_Long = 0L;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearFrameCount, count[");
      localStringBuilder.append(jdField_d_of_type_Long);
      localStringBuilder.append(",");
      localStringBuilder.append(jdField_e_of_type_Long);
      localStringBuilder.append("], surfaceTexture[");
      localStringBuilder.append(paramSurfaceTexture);
      localStringBuilder.append("]");
      QLog.i("SurfaceTag", 2, localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte == null) {
      return 0;
    }
    return arrayOfByte.length;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) && (!this.jdField_b_of_type_Boolean))
    {
      try
      {
        a(null);
      }
      catch (Throwable localThrowable)
      {
        QLog.i("SurfaceTag", 1, "checkAfterFilterRender", localThrowable);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SurfaceTag", 2, "checkAfterFilterRender, not deal by filter render.");
      }
    }
  }
  
  public void a(long paramLong1, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_e_of_type_Int = paramInt5;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_b_of_type_Long = paramLong3;
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_e_of_type_Int = paramInt5;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_b_of_type_Long = paramLong3;
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    SurfaceTexture localSurfaceTexture = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (localSurfaceTexture != null)
    {
      localSurfaceTexture.updateTexImage();
      if (paramArrayOfFloat != null) {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramArrayOfFloat);
      }
      this.jdField_b_of_type_Boolean = true;
      b(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ArrayOfByte == null) && (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null);
  }
  
  public void b()
  {
    if ((QLog.isDevelopLevel()) && (this.jdField_f_of_type_Long != 0L))
    {
      long l = SystemClock.elapsedRealtime() - this.jdField_f_of_type_Long;
      i += 1;
      if (i == 1) {
        jdField_g_of_type_Long = l;
      } else {
        jdField_g_of_type_Long = (jdField_g_of_type_Long + l) / 2L;
      }
    }
    if ((this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) && (!this.jdField_b_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.i("SurfaceTag", 2, "recycle when tex not updated.");
    }
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        QLog.i("SurfaceTag", 2, "recycle, error.");
      }
      else
      {
        this.jdField_c_of_type_Boolean = true;
        if (h < 4)
        {
          this.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame = jdField_b_of_type_ComTencentAvOpenglEffectsCameraFrame;
          jdField_b_of_type_ComTencentAvOpenglEffectsCameraFrame = this;
          h += 1;
        }
      }
      return;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.CameraFrame
 * JD-Core Version:    0.7.0.1
 */