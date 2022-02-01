package com.tencent.avgame.gameroom.video;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingYUVProgram;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;

public class AVGameMediaRenderHelper
{
  protected int a;
  private long jdField_a_of_type_Long = 0L;
  protected Point a;
  protected Rect a;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  protected GreetingYUVProgram a;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  protected Boolean a;
  private ConcurrentHashMap<Long, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  protected volatile boolean a;
  protected byte[] a;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
  protected int b;
  private long jdField_b_of_type_Long = 0L;
  protected volatile boolean b;
  protected byte[] b;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  protected int c;
  private long c;
  protected boolean c;
  protected byte[] c;
  protected int d;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = -1;
  private long jdField_e_of_type_Long = 0L;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  
  public AVGameMediaRenderHelper()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private Point a()
  {
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    int i;
    int j;
    if (localRect != null)
    {
      i = localRect.right;
      i = this.jdField_a_of_type_AndroidGraphicsRect.left;
      j = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      int k = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i = this.jdField_a_of_type_AndroidGraphicsRect.left;
      j = this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidGraphicsRect.top - (j - k);
    }
    else
    {
      i = (this.jdField_a_of_type_Int - 640) / 2;
      j = this.jdField_b_of_type_Int - 480 - 40;
    }
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point(i, j);
    return this.jdField_a_of_type_AndroidGraphicsPoint;
  }
  
  private void a(long paramLong) {}
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null)
    {
      if (arrayOfByte.length == 1) {
        return;
      }
      if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] == null) || (this.jdField_a_of_type_ArrayOfInt[0] != paramArrayOfByte1.length)) {
        try
        {
          this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
          this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].order(ByteOrder.nativeOrder());
        }
        catch (Throwable localThrowable)
        {
          QLog.e("AVGameMediaRenderHelper", 1, "textureYUV fail.", localThrowable);
        }
      }
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].clear();
      this.jdField_a_of_type_ArrayOfInt[0] = paramArrayOfByte1.length;
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].put(paramArrayOfByte1);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].position(0);
      if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] == null) || (this.jdField_a_of_type_ArrayOfInt[1] != paramArrayOfByte2.length)) {
        try
        {
          this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] = ByteBuffer.allocateDirect(paramArrayOfByte2.length);
          this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].order(ByteOrder.nativeOrder());
        }
        catch (Throwable paramArrayOfByte1)
        {
          QLog.e("AVGameMediaRenderHelper", 1, "textureYUV fail.", paramArrayOfByte1);
        }
      }
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].clear();
      this.jdField_a_of_type_ArrayOfInt[1] = paramArrayOfByte2.length;
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].put(paramArrayOfByte2);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].position(0);
      if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] == null) || (this.jdField_a_of_type_ArrayOfInt[2] != paramArrayOfByte3.length)) {
        try
        {
          this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] = ByteBuffer.allocateDirect(paramArrayOfByte3.length);
          this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].order(ByteOrder.nativeOrder());
        }
        catch (Throwable paramArrayOfByte1)
        {
          QLog.e("AVGameMediaRenderHelper", 1, "textureYUV fail.", paramArrayOfByte1);
        }
      }
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].clear();
      this.jdField_a_of_type_ArrayOfInt[2] = paramArrayOfByte3.length;
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].put(paramArrayOfByte3);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].position(0);
    }
  }
  
  private void f()
  {
    ??? = this.jdField_a_of_type_ArrayOfByte;
    if (??? != null)
    {
      if (???.length == 1) {
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram.a()) {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram.a();
      }
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte);
          this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram.a(this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0], this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1], this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2], this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
          this.jdField_a_of_type_Boolean = false;
        }
        return;
      }
    }
  }
  
  private void g()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] != null) && (this.jdField_c_of_type_Int != 0))
    {
      Object localObject = this.jdField_a_of_type_ArrayOfByte;
      if (localObject != null)
      {
        if (localObject.length == 1) {
          return;
        }
        QLog.d("AVGameMediaRenderHelper", 1, "loadVerticalBuffer");
        this.jdField_c_of_type_Boolean = false;
        localObject = new float[8];
        Object tmp70_68 = localObject;
        tmp70_68[0] = -1.0F;
        Object tmp75_70 = tmp70_68;
        tmp75_70[1] = 1.0F;
        Object tmp79_75 = tmp75_70;
        tmp79_75[2] = 1.0F;
        Object tmp83_79 = tmp79_75;
        tmp83_79[3] = 1.0F;
        Object tmp87_83 = tmp83_79;
        tmp87_83[4] = -1.0F;
        Object tmp92_87 = tmp87_83;
        tmp92_87[5] = -1.0F;
        Object tmp97_92 = tmp92_87;
        tmp97_92[6] = 1.0F;
        Object tmp102_97 = tmp97_92;
        tmp102_97[7] = -1.0F;
        tmp102_97;
        Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        if (localRect != null)
        {
          int i = localRect.right;
          int j = this.jdField_a_of_type_AndroidGraphicsRect.left;
          int k = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
          int m = this.jdField_a_of_type_AndroidGraphicsRect.top;
          int n = this.jdField_c_of_type_Int;
          int i1 = this.jdField_d_of_type_Int;
          float f1 = i - j;
          float f2 = k - m;
          float f3 = f1 / f2;
          float f4 = n / i1;
          if (f3 < f4)
          {
            f1 = f4 * f1 / f2;
            localObject[0] *= f1;
            localObject[2] *= f1;
            localObject[4] *= f1;
            localObject[6] *= f1;
          }
          else if (f3 > f4)
          {
            f1 /= f4 * f2;
            localObject[1] *= f1;
            localObject[3] *= f1;
            localObject[5] *= f1;
            localObject[7] *= f1;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram.a((float[])localObject);
      }
    }
  }
  
  public void a()
  {
    QLog.d("AVGameMediaRenderHelper", 1, "onGLSurfaceDestroy");
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram.c();
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram = null;
    this.jdField_a_of_type_ArrayOfByte = new byte[1];
    this.jdField_b_of_type_ArrayOfByte = new byte[1];
    this.jdField_c_of_type_ArrayOfByte = new byte[1];
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("AVGameMediaRenderHelper", 1, "onGLSurfaceCreate");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram = new GreetingYUVProgram(0);
    this.jdField_a_of_type_ArrayOfByte = new byte[1];
    this.jdField_b_of_type_ArrayOfByte = new byte[1];
    this.jdField_c_of_type_ArrayOfByte = new byte[1];
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, 1.0F, -1.0F, 1.0F);
  }
  
  protected void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      Boolean localBoolean = this.jdField_a_of_type_JavaLangBoolean;
      if (localBoolean != null)
      {
        this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Int = paramInt2;
        if (localBoolean.booleanValue()) {
          c();
        } else {
          b();
        }
        d();
        return;
      }
    }
    QLog.d("AVGameMediaRenderHelper", 1, "renderVideoCover fail");
  }
  
  public void a(boolean paramBoolean)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("notifySelfMediaRender enable:=");
    ((StringBuilder)???).append(paramBoolean);
    QLog.d("AVGameMediaRenderHelper", 1, ((StringBuilder)???).toString());
    this.jdField_b_of_type_Boolean = paramBoolean;
    ??? = this.jdField_a_of_type_ArrayOfByte;
    if ((??? != null) && (???.length != 1) && (!this.jdField_b_of_type_Boolean)) {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[1];
        this.jdField_b_of_type_ArrayOfByte = new byte[1];
        this.jdField_c_of_type_ArrayOfByte = new byte[1];
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
        return;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfByte != null))
    {
      a(paramLong);
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      int i = this.jdField_a_of_type_ArrayOfByte.length;
      int j = paramInt1 * paramInt2;
      if (i != j)
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[j];
        i = j / 4;
        this.jdField_b_of_type_ArrayOfByte = new byte[i];
        this.jdField_c_of_type_ArrayOfByte = new byte[i];
        this.jdField_c_of_type_Boolean = true;
        QLog.d("AVGameMediaRenderHelper", 1, "onPushVideoMsg mRenderParamsChang;=true");
      }
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramInt2;
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_Boolean = true;
        System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
        System.arraycopy(paramArrayOfByte, this.jdField_a_of_type_ArrayOfByte.length, this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_b_of_type_ArrayOfByte.length);
        System.arraycopy(paramArrayOfByte, this.jdField_a_of_type_ArrayOfByte.length + this.jdField_b_of_type_ArrayOfByte.length, this.jdField_c_of_type_ArrayOfByte, 0, this.jdField_c_of_type_ArrayOfByte.length);
        e();
        return;
      }
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("onPushVideoMsg fail mEnablePlayYUV ");
    paramArrayOfByte.append(this.jdField_b_of_type_Boolean);
    QLog.d("AVGameMediaRenderHelper", 1, paramArrayOfByte.toString());
  }
  
  protected void b()
  {
    SurfaceTexture localSurfaceTexture = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if ((localSurfaceTexture != null) && (this.jdField_e_of_type_Int != -1))
    {
      if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
        return;
      }
      try
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
        GLES20.glViewport(a().x, a().x, this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_e_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
        GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        return;
      }
      finally {}
    }
  }
  
  protected void c()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_c_of_type_Int != 0) && (this.jdField_a_of_type_ArrayOfByte.length != 1) && (this.jdField_a_of_type_AndroidGraphicsRect != null))
    {
      f();
      g();
      if (this.jdField_a_of_type_ArrayOfByte.length == 1) {
        return;
      }
      GLES20.glViewport(a().x, a().y, this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram.b();
      GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = false;
      }
      return;
    }
    QLog.d("AVGameMediaRenderHelper", 1, "renderVideoCoverBySoft fail");
  }
  
  public void d()
  {
    this.jdField_c_of_type_Long += 1L;
    if (this.jdField_d_of_type_Long == 0L) {
      this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    }
    if (SystemClock.elapsedRealtime() - this.jdField_d_of_type_Long >= 1000L)
    {
      this.jdField_e_of_type_Long = this.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFPSRate mFrameRate:=");
        localStringBuilder.append(this.jdField_e_of_type_Long);
        QLog.d("AVGameMediaRenderHelper", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void e()
  {
    this.f += 1L;
    if (this.g == 0L) {
      this.g = SystemClock.elapsedRealtime();
    }
    if (SystemClock.elapsedRealtime() - this.g >= 1000L)
    {
      this.h = this.f;
      this.f = 0L;
      this.g = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFPSRate updateDecodeRate:=");
        localStringBuilder.append(this.jdField_e_of_type_Long);
        QLog.d("AVGameMediaRenderHelper", 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaRenderHelper
 * JD-Core Version:    0.7.0.1
 */