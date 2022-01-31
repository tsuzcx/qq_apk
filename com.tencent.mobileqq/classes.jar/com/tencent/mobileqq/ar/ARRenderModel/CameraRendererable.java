package com.tencent.mobileqq.ar.ARRenderModel;

import aaam;
import aaan;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import com.hiar.sdk.utils.Drawable2d;
import com.hiar.sdk.utils.GlUtil;
import com.tencent.mobileqq.ar.DrawView2;
import com.tencent.qphone.base.util.QLog;
import java.nio.FloatBuffer;
import java.util.Random;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(14)
public class CameraRendererable
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  private static String jdField_a_of_type_JavaLangString = "AREngine_CameraRendererable";
  private static int f;
  private static int g;
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private Drawable2d jdField_a_of_type_ComHiarSdkUtilsDrawable2d = new Drawable2d();
  private ARRenderMangerInnerCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
  ARRenerArumentManager jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager;
  Runnable jdField_a_of_type_JavaLangRunnable = new aaam(this);
  private Random jdField_a_of_type_JavaUtilRandom;
  public boolean a;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private aaan[] jdField_a_of_type_ArrayOfAaan = new aaan[300];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = true;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[600];
  private float jdField_c_of_type_Float = 1.0F;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u = 255;
  private int v;
  
  public CameraRendererable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback = paramARRenderMangerInnerCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager = paramARRenderMangerInnerCallback.a();
  }
  
  protected void a()
  {
    this.jdField_e_of_type_Int = GLES20.glGetUniformLocation(this.h, "uTexture");
    this.jdField_a_of_type_Int = GLES20.glGetAttribLocation(this.h, "aPosition");
    this.jdField_b_of_type_Int = GLES20.glGetUniformLocation(this.h, "uMVPMatrix");
    this.jdField_c_of_type_Int = GLES20.glGetUniformLocation(this.h, "uTexMatrix");
    this.jdField_d_of_type_Int = GLES20.glGetAttribLocation(this.h, "aTextureCoord");
    this.i = GLES20.glGetUniformLocation(this.h, "cameraVideoWidth");
    this.j = GLES20.glGetUniformLocation(this.h, "cameraVideoHeight");
    this.k = GLES20.glGetUniformLocation(this.h, "cameraEdgeStart");
    this.l = GLES20.glGetUniformLocation(this.h, "cameraEdgeEnd");
    this.m = GLES20.glGetUniformLocation(this.h, "cameraScanLineTexture");
    this.n = GLES20.glGetUniformLocation(this.h, "cameraScanNetTexture");
    this.o = GLES20.glGetUniformLocation(this.h, "cameraScanNoiseTexture");
    this.p = GLES20.glGetUniformLocation(this.h, "noiseMode");
    Object localObject = new int[3];
    GLES20.glGenTextures(3, (int[])localObject, 0);
    this.r = localObject[0];
    this.s = localObject[1];
    this.t = localObject[2];
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "textureLightId:" + this.r + "   textureNetId:" + this.s + "   textureNoiseId:" + this.t);
    }
    GLES20.glBindTexture(3553, this.r);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
      localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().getResources(), 2130842228, (BitmapFactory.Options)localObject);
      if (localObject != null)
      {
        GLUtils.texImage2D(3553, 0, (Bitmap)localObject, 0);
        ((Bitmap)localObject).recycle();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        localOutOfMemoryError1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getGLSLValues", localOutOfMemoryError1);
        }
      }
    }
    GLES20.glBindTexture(3553, this.s);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
      localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().getResources(), 2130842230, (BitmapFactory.Options)localObject);
      if (localObject != null)
      {
        GLUtils.texImage2D(3553, 0, (Bitmap)localObject, 0);
        ((Bitmap)localObject).recycle();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      for (;;)
      {
        localOutOfMemoryError2.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getGLSLValues 2 ", localOutOfMemoryError2);
        }
      }
    }
    GLES20.glBindTexture(3553, this.t);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  protected void a(int paramInt)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, paramInt);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.r);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.s);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.jdField_e_of_type_Int, 0);
    GLES20.glUniform1i(this.m, 1);
    GLES20.glUniform1i(this.n, 2);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, this.t);
    c();
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.o, 3);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.v = 0;
    }
    GLES20.glUniform1i(this.p, this.v);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Float <= 0.0F) || (this.jdField_e_of_type_Float <= 0.0F)) {
      return;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glDrawArrays(5, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    f = paramInt3;
    g = paramInt4;
    float f4 = f / g;
    float f5 = paramInt2 / paramInt1;
    float f3 = 1.0F;
    float f2 = 1.0F;
    DrawView2.jdField_d_of_type_Int = g;
    DrawView2.jdField_c_of_type_Int = f;
    DrawView2.jdField_b_of_type_Int = paramInt1 / 2;
    DrawView2.jdField_a_of_type_Int = paramInt2 / 2;
    float f1;
    if (f4 < f5)
    {
      f1 = g * f5 / f;
      DrawView2.jdField_a_of_type_Float = f1;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[debugRay] setPreviewFrameSize  height = " + paramInt1 + ",width = " + paramInt2 + ",screenWidth = " + f + ",screenHeight = " + g + ",scaleX = " + f1 + ",scaleY = " + f2);
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[debugRay] setPreviewFrameSize  DrawView2.scaleX = " + DrawView2.jdField_a_of_type_Float + ",DrawView2.scaleY = " + DrawView2.jdField_b_of_type_Float);
      }
      Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, f1, f2, 1.0F);
      this.jdField_a_of_type_Float = f2;
      this.jdField_d_of_type_Float = paramInt2;
      this.jdField_e_of_type_Float = paramInt1;
      if (paramInt2 <= paramInt1) {
        break label473;
      }
      paramInt3 = paramInt1;
      label260:
      if (paramInt2 <= paramInt1) {
        break label478;
      }
      paramInt1 = paramInt2;
    }
    label473:
    label478:
    for (;;)
    {
      if (paramInt3 > 0)
      {
        paramInt2 = paramInt1;
        if (paramInt1 > 0) {}
      }
      else
      {
        paramInt3 = 720;
        paramInt2 = 1280;
      }
      paramInt3 = (int)(paramInt3 * 0.42D);
      paramInt4 = (int)(paramInt2 * 0.6D * 0.25D * 0.42D);
      paramInt2 = paramInt4;
      paramInt1 = paramInt3;
      if (paramInt3 < 240)
      {
        f1 = paramInt4 * 1.0F / paramInt3;
        paramInt1 = 240;
        paramInt2 = (int)(f1 * 'ð');
      }
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "create noiseBmp width:", Integer.valueOf(paramInt1), " height:", Integer.valueOf(paramInt2) });
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ALPHA_8);
        this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        localOutOfMemoryError.printStackTrace();
        QLog.d(jdField_a_of_type_JavaLangString, 1, "create noiseBmp error ", localOutOfMemoryError);
        return;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        localException.printStackTrace();
        QLog.d(jdField_a_of_type_JavaLangString, 1, "create noiseBmp error2 ", localException);
      }
      f1 = f3;
      if (f4 <= f5) {
        break;
      }
      f2 = f / (g * f5);
      DrawView2.jdField_b_of_type_Float = f2;
      f1 = f3;
      break;
      paramInt3 = paramInt2;
      break label260;
    }
  }
  
  public void a(int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.c = 0L;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.jdField_b_of_type_Long = 0L;
    if ((this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) && (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != paramSurfaceTexture))
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
      if (!Build.MODEL.equalsIgnoreCase("NX512J")) {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      }
      this.q = 0;
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    this.q = paramInt;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected void a(float[] paramArrayOfFloat1, FloatBuffer paramFloatBuffer1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, FloatBuffer paramFloatBuffer2, int paramInt3)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Long == -1L) {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      long l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      if ((float)l1 < 4000.0F)
      {
        float f1 = (float)l1 * 1.0F / 4000.0F;
        this.jdField_b_of_type_Float = (f1 * (f1 * f1));
        this.jdField_b_of_type_Float *= 1.35F;
      }
    }
    for (this.v = 1;; this.v = 0)
    {
      GLES20.glUniform1f(this.i, this.jdField_d_of_type_Float);
      GLES20.glUniform1f(this.j, this.jdField_e_of_type_Float);
      GLES20.glUniform1f(this.k, this.jdField_b_of_type_Float);
      GLES20.glUniform1f(this.l, this.jdField_c_of_type_Float);
      GLES20.glUniformMatrix4fv(this.jdField_b_of_type_Int, 1, false, paramArrayOfFloat1, 0);
      GLES20.glUniformMatrix4fv(this.jdField_c_of_type_Int, 1, false, paramArrayOfFloat2, 0);
      GLES20.glEnableVertexAttribArray(this.jdField_a_of_type_Int);
      GLES20.glVertexAttribPointer(this.jdField_a_of_type_Int, paramInt1, 5126, false, paramInt2, paramFloatBuffer1);
      GLES20.glEnableVertexAttribArray(this.jdField_d_of_type_Int);
      GLES20.glVertexAttribPointer(this.jdField_d_of_type_Int, 2, 5126, false, paramInt3, paramFloatBuffer2);
      return;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      break;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_b_of_type_Long = -1L;
    }
  }
  
  protected void b()
  {
    GLES20.glUseProgram(this.h);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long += 1L;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.v == 0) || (this.jdField_a_of_type_Long % 3L != 1L)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilRandom == null) {
      this.jdField_a_of_type_JavaUtilRandom = new Random();
    }
    System.currentTimeMillis();
    int i5 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int i6 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    int i7 = this.u;
    int i2 = 0;
    int i1 = 0;
    float f1 = 1.0F / i6;
    float f2 = 5.0F / i6;
    int i4 = 0;
    aaan localaaan2;
    label184:
    aaan localaaan1;
    int i3;
    if (i4 < 300)
    {
      localaaan2 = this.jdField_a_of_type_ArrayOfAaan[i4];
      if ((localaaan2 != null) && (!localaaan2.jdField_a_of_type_Boolean))
      {
        if (this.jdField_a_of_type_JavaUtilRandom.nextFloat() > 0.7F - localaaan2.jdField_b_of_type_Float * 0.35F - Math.abs(localaaan2.jdField_a_of_type_Float * 0.3F - 0.15F)) {
          localaaan2.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        if (localaaan2 != null)
        {
          localaaan1 = localaaan2;
          i3 = i2;
          if (!localaaan2.jdField_a_of_type_Boolean) {
            break label370;
          }
        }
        if (i2 <= i7) {
          break label281;
        }
      }
    }
    for (;;)
    {
      i4 += 1;
      break;
      float f3 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      float f4 = localaaan2.jdField_b_of_type_Float;
      localaaan2.jdField_b_of_type_Float = (f3 * 0.3F + 0.2F * localaaan2.jdField_b_of_type_Float + f2 + f4);
      if (localaaan2.jdField_b_of_type_Float <= 1.0D) {
        break label184;
      }
      localaaan2.jdField_a_of_type_Boolean = true;
      break label184;
      label281:
      localaaan1 = localaaan2;
      if (localaaan2 == null)
      {
        localaaan1 = new aaan(this);
        this.jdField_a_of_type_ArrayOfAaan[i4] = localaaan1;
      }
      f3 = this.jdField_a_of_type_JavaUtilRandom.nextFloat();
      if (f3 < 0.4D) {
        localaaan1.jdField_a_of_type_Float = (f3 * 2.35F + 0.02F);
      }
      for (;;)
      {
        localaaan1.jdField_b_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * 0.05F + f1);
        localaaan1.jdField_a_of_type_Boolean = false;
        i3 = i2 + 1;
        label370:
        if ((localaaan1 == null) || (localaaan1.jdField_a_of_type_Boolean) || (localaaan1.jdField_b_of_type_Float >= 1.0D)) {
          break label542;
        }
        this.jdField_b_of_type_ArrayOfFloat[(i1 * 2)] = (this.jdField_a_of_type_ArrayOfAaan[i4].jdField_a_of_type_Float * i5);
        this.jdField_b_of_type_ArrayOfFloat[(i1 * 2 + 1)] = (this.jdField_a_of_type_ArrayOfAaan[i4].jdField_b_of_type_Float * i6);
        i1 += 1;
        i2 = i3;
        break;
        if (f3 > 0.6F) {
          localaaan1.jdField_a_of_type_Float = ((1.0F - f3) * 2.35F + 0.02F);
        }
      }
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawPoints(this.jdField_b_of_type_ArrayOfFloat, 0, i1, this.jdField_a_of_type_AndroidGraphicsPaint);
      GLUtils.texImage2D(3553, 0, this.jdField_a_of_type_AndroidGraphicsBitmap, 0);
      return;
      label542:
      i2 = i3;
    }
  }
  
  protected void d()
  {
    GLES20.glDisableVertexAttribArray(this.jdField_a_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.jdField_d_of_type_Int);
  }
  
  protected void e()
  {
    GLES20.glBindTexture(36197, 0);
  }
  
  protected void f()
  {
    GLES20.glUseProgram(0);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.q = 0;
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    System.currentTimeMillis();
    if (Build.MODEL.equalsIgnoreCase("MI 5C")) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        b();
        a(this.q);
        paramGL10 = new float[16];
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramGL10);
        a(this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.a(), this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.d(), this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.b(), paramGL10, this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.b(), this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.c());
        a(0, this.jdField_a_of_type_ComHiarSdkUtilsDrawable2d.a());
        d();
        e();
        f();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30L);
        return;
      }
      catch (Exception paramGL10)
      {
        paramGL10.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onDrawFrame updateTexImage error", paramGL10);
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.jdField_a_of_type_Long == 0L) {
        break;
      }
      while (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.c > this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.jdField_b_of_type_Long)
      {
        paramGL10 = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager;
        paramGL10.jdField_b_of_type_Long += 1L;
        try
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        }
        catch (Exception paramGL10)
        {
          paramGL10.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onDrawFrame updateTexImage error", paramGL10);
        }
      }
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.h = GlUtil.a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\n\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\n\nvarying vec2 vTextureCoord;\nvarying vec2 edgeTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n    edgeTextureCoord = vec2(aTextureCoord.x,1.0 - aTextureCoord.y);\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n\nvarying vec2 vTextureCoord;\nvarying vec2 edgeTextureCoord;\nuniform samplerExternalOES uTexture;\nuniform sampler2D cameraScanLineTexture;\nuniform sampler2D cameraScanNetTexture;\nuniform sampler2D cameraScanNoiseTexture;\nuniform int noiseMode;\nuniform float cameraVideoWidth;\nuniform float cameraVideoHeight;\nuniform float cameraEdgeStart;\nuniform float cameraEdgeEnd;\nvoid getEdgeRGBSobel(vec2 vTextureCoord){\n   float gadthis =  cameraEdgeStart - edgeTextureCoord.y;\n   vec4 cTemp4 = texture2D(uTexture, vTextureCoord);\n   const float gad = 0.6;\n   if(edgeTextureCoord.y > cameraEdgeEnd || gadthis < 0.0 || gadthis>gad){\n       gl_FragColor=cTemp4;\n    }else{\n        vec2 thistexcoord = vec2( edgeTextureCoord.x , 1.0 - gadthis / gad);\n        vec4 netColor = texture2D(cameraScanNetTexture, thistexcoord);\n        cTemp4.rgb = cTemp4.rgb * (1.0 - netColor.w) + vec3(1.0, 1.0, 1.0) * netColor.w;\n        vec2 offset0=vec2(-1.0/cameraVideoWidth,-1.0/cameraVideoHeight); vec2 offset1=vec2(0.0,-1.0/cameraVideoHeight); vec2 offset2=vec2(1.0/cameraVideoWidth,-1.0/cameraVideoHeight);\n        vec2 offset3=vec2(-1.0/cameraVideoWidth,0.0); vec2 offset5=vec2(1.0/cameraVideoWidth,0.0);\n        vec2 offset6=vec2(-1.0/cameraVideoWidth,1.0/cameraVideoHeight); vec2 offset7=vec2(0.0,1.0/cameraVideoHeight); vec2 offset8=vec2(1.0/cameraVideoWidth,1.0/cameraVideoHeight);\n        vec4 cTemp0,cTemp1,cTemp2,cTemp3,cTemp5,cTemp6,cTemp7,cTemp8;\n        cTemp0=texture2D(uTexture, vTextureCoord + offset0);\n        cTemp1=texture2D(uTexture, vTextureCoord + offset1);\n        cTemp2=texture2D(uTexture, vTextureCoord + offset2);\n        cTemp3=texture2D(uTexture, vTextureCoord + offset3);\n        cTemp5=texture2D(uTexture, vTextureCoord + offset5);\n        cTemp6=texture2D(uTexture, vTextureCoord + offset6);\n        cTemp7=texture2D(uTexture, vTextureCoord + offset7);\n        cTemp8=texture2D(uTexture, vTextureCoord + offset8);\n        vec4 sumx = -cTemp0 -  cTemp1 - cTemp2 + cTemp6.r +  cTemp7 + cTemp8;\n        vec4 sumy = -cTemp6 -  cTemp3 - cTemp0 + cTemp8 +  cTemp5 + cTemp2;\n        float sumxy = 0.3*sumx.r+0.59*sumx.g+0.11*sumx.b;\n        float sumyy = 0.3*sumy.r+0.59*sumy.g+0.11*sumy.b;\n        float sum  = length(vec2(sumxy, sumyy));\n        if(sum > 0.45){\n            sum+=0.2;\n            sum = min(sum,1.0);\n            float weightT = ((gad - gadthis)/gad *0.8);\n            sum = 0.8 * sum * weightT;\n            cTemp4 = vec4(0.0*weightT,0.9725*weightT,weightT*1.0,weightT) + cTemp4 * (1.0 - weightT - sum)+vec4(sum,sum,sum,1.0);\n        }\n        vec4 fugaicolor = texture2D(cameraScanLineTexture, thistexcoord);\n        float alphaW = fugaicolor.w * (gad - gadthis)/gad;\n        gl_FragColor = cTemp4 * (1.0 - alphaW) + fugaicolor * alphaW;\n        if(sum <= 0.45 && thistexcoord.y > 0.75 && noiseMode == 1){\n            float noiseAlpha = texture2D(cameraScanNoiseTexture, vec2(thistexcoord.x, (1.0-thistexcoord.y)/0.25)).a;\n            noiseAlpha = noiseAlpha*(4.0*thistexcoord.y-3.0);\n            if(noiseAlpha > 0.0626 && noiseAlpha<=1.0){\n                gl_FragColor.rgb = gl_FragColor.rgb * (1.0 - noiseAlpha) + vec3(0.753, 0.988, 1.0) * noiseAlpha;\n            }\n        }\n        gl_FragColor.a = 1.0;\n    }\n}\nvoid main() {\n   getEdgeRGBSobel(vTextureCoord);\n}");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.CameraRendererable
 * JD-Core Version:    0.7.0.1
 */