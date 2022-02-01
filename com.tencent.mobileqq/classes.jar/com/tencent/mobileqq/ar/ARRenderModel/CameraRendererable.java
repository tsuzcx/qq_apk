package com.tencent.mobileqq.ar.ARRenderModel;

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
import android.util.Size;
import com.hiar.sdk.utils.Drawable2d;
import com.hiar.sdk.utils.GlUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.DrawView2;
import com.tencent.mobileqq.ar.arcore.ArCoreNativeSoManager;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl;
import com.tencent.qphone.base.util.QLog;
import java.nio.FloatBuffer;
import java.util.Random;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(14)
public class CameraRendererable
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  private static String f = "AREngine_CameraRendererable";
  private static int l;
  private static int m;
  private float A;
  private boolean B = false;
  private float[] C = new float[16];
  private Drawable2d D = new Drawable2d();
  private SurfaceTexture E;
  private ARRenderMangerInnerCallback F;
  private int G = -1;
  private int H;
  private int I;
  private int J;
  private int K = 1;
  private float[] L = new float[16];
  private int M = 255;
  private CameraRendererable.Noise[] N = new CameraRendererable.Noise[300];
  private float[] O = new float[600];
  private Bitmap P;
  private Canvas Q;
  private Paint R;
  private int S = 0;
  private long T = 0L;
  private Random U;
  private long V = -1L;
  private FloatBuffer W;
  private Size X;
  BackgroundRenderer a = new BackgroundRenderer();
  Handler b = new Handler();
  ARRenerArumentManager c;
  public boolean d = true;
  Runnable e = new CameraRendererable.1(this);
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private float w = 1.0F;
  private float x;
  private float y = 1.0F;
  private float z;
  
  public CameraRendererable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    this.F = paramARRenderMangerInnerCallback;
    this.c = paramARRenderMangerInnerCallback.c();
  }
  
  public void a(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  protected void a(int paramInt)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, paramInt);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.H);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.I);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.k, 0);
    GLES20.glUniform1i(this.s, 1);
    GLES20.glUniform1i(this.t, 2);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, this.J);
    d();
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.u, 3);
    if (this.P == null) {
      this.S = 0;
    }
    GLES20.glUniform1i(this.v, this.S);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.z > 0.0F)
    {
      if (this.A <= 0.0F) {
        return;
      }
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      GLES20.glDrawArrays(5, paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    l = paramInt3;
    m = paramInt4;
    float f1 = l;
    paramInt3 = m;
    f1 /= paramInt3;
    float f4 = paramInt2;
    float f5 = paramInt1;
    float f2 = f4 / f5;
    DrawView2.f = paramInt3;
    DrawView2.e = l;
    DrawView2.d = paramInt1 / 2;
    DrawView2.c = paramInt2 / 2;
    if (f1 < f2)
    {
      f1 = f2 * m / l;
      DrawView2.a = f1;
    }
    else
    {
      if (f1 > f2)
      {
        f1 = l / (f2 * m);
        DrawView2.b = f1;
        f2 = 1.0F;
        break label140;
      }
      f1 = 1.0F;
    }
    float f3 = 1.0F;
    f2 = f1;
    f1 = f3;
    label140:
    if (QLog.isColorLevel())
    {
      String str = f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[debugRay] setPreviewFrameSize  height = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",width = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",screenWidth = ");
      localStringBuilder.append(l);
      localStringBuilder.append(",screenHeight = ");
      localStringBuilder.append(m);
      localStringBuilder.append(",scaleX = ");
      localStringBuilder.append(f2);
      localStringBuilder.append(",scaleY = ");
      localStringBuilder.append(f1);
      QLog.d(str, 2, localStringBuilder.toString());
      str = f;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[debugRay] setPreviewFrameSize  DrawView2.scaleX = ");
      localStringBuilder.append(DrawView2.a);
      localStringBuilder.append(",DrawView2.scaleY = ");
      localStringBuilder.append(DrawView2.b);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    Matrix.setIdentityM(this.C, 0);
    Matrix.scaleM(this.C, 0, f2, f1, 1.0F);
    this.w = f1;
    this.z = f4;
    this.A = f5;
    if (paramInt2 > paramInt1) {
      paramInt3 = paramInt1;
    } else {
      paramInt3 = paramInt2;
    }
    paramInt4 = paramInt1;
    if (paramInt2 > paramInt1) {
      paramInt4 = paramInt2;
    }
    if (paramInt3 > 0)
    {
      paramInt1 = paramInt4;
      if (paramInt4 > 0) {}
    }
    else
    {
      paramInt3 = 720;
      paramInt1 = 1280;
    }
    double d1 = paramInt3;
    Double.isNaN(d1);
    paramInt3 = (int)(d1 * 0.42D);
    d1 = paramInt1;
    Double.isNaN(d1);
    paramInt4 = (int)(d1 * 0.6D * 0.25D * 0.42D);
    paramInt2 = paramInt4;
    paramInt1 = paramInt3;
    if (paramInt3 < 240)
    {
      paramInt2 = (int)(paramInt4 * 1.0F / paramInt3 * 'ð');
      paramInt1 = 240;
    }
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(f, 2, new Object[] { "create noiseBmp width:", Integer.valueOf(paramInt1), " height:", Integer.valueOf(paramInt2) });
      }
      this.P = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ALPHA_8);
      this.Q = new Canvas(this.P);
      this.R = new Paint();
      this.R.setColor(-1);
      return;
    }
    catch (Exception localException)
    {
      this.P = null;
      localException.printStackTrace();
      QLog.d(f, 1, "create noiseBmp error2 ", localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.P = null;
      localOutOfMemoryError.printStackTrace();
      QLog.d(f, 1, "create noiseBmp error ", localOutOfMemoryError);
    }
  }
  
  public void a(int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    this.K = 1;
    Object localObject = this.c;
    ((ARRenerArumentManager)localObject).a = 0L;
    ((ARRenerArumentManager)localObject).c = 0L;
    ((ARRenerArumentManager)localObject).b = 0L;
    localObject = this.E;
    if ((localObject != null) && (localObject != paramSurfaceTexture))
    {
      ((SurfaceTexture)localObject).setOnFrameAvailableListener(null);
      if (!Build.MODEL.equalsIgnoreCase("NX512J")) {
        this.E.release();
      }
      this.G = 0;
      this.E = null;
    }
    this.G = paramInt;
    this.E = paramSurfaceTexture;
    paramSurfaceTexture = this.E;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.setOnFrameAvailableListener(this);
    }
    this.d = true;
  }
  
  @TargetApi(21)
  public void a(FloatBuffer paramFloatBuffer, Size paramSize)
  {
    this.W = paramFloatBuffer;
    if (this.X == null)
    {
      paramFloatBuffer = this.a;
      if (paramFloatBuffer != null)
      {
        this.X = paramSize;
        paramFloatBuffer.a(paramSize.getHeight(), paramSize.getWidth(), UniformGLRenderManagerImpl.b, UniformGLRenderManagerImpl.c);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  protected void a(float[] paramArrayOfFloat1, FloatBuffer paramFloatBuffer1, int paramInt1, int paramInt2, float[] paramArrayOfFloat2, FloatBuffer paramFloatBuffer2, int paramInt3)
  {
    if (this.B)
    {
      if (this.V == -1L) {
        this.V = System.currentTimeMillis();
      }
      float f1 = (float)(System.currentTimeMillis() - this.V);
      if (f1 < 4000.0F)
      {
        f1 = f1 * 1.0F / 4000.0F;
        this.x = (f1 * f1 * f1);
        this.x *= 1.35F;
      }
      else
      {
        this.x = 0.0F;
        this.V = System.currentTimeMillis();
      }
      this.S = 1;
    }
    else
    {
      this.x = 0.0F;
      this.V = -1L;
      this.S = 0;
    }
    GLES20.glUniform1f(this.o, this.z);
    GLES20.glUniform1f(this.p, this.A);
    GLES20.glUniform1f(this.q, this.x);
    GLES20.glUniform1f(this.r, this.y);
    GLES20.glUniformMatrix4fv(this.h, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(this.i, 1, false, paramArrayOfFloat2, 0);
    GLES20.glEnableVertexAttribArray(this.g);
    GLES20.glVertexAttribPointer(this.g, paramInt1, 5126, false, paramInt2, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.j);
    GLES20.glVertexAttribPointer(this.j, 2, 5126, false, paramInt3, paramFloatBuffer2);
  }
  
  public boolean a()
  {
    return this.B;
  }
  
  protected void b()
  {
    this.k = GLES20.glGetUniformLocation(this.n, "uTexture");
    this.g = GLES20.glGetAttribLocation(this.n, "aPosition");
    this.h = GLES20.glGetUniformLocation(this.n, "uMVPMatrix");
    this.i = GLES20.glGetUniformLocation(this.n, "uTexMatrix");
    this.j = GLES20.glGetAttribLocation(this.n, "aTextureCoord");
    this.o = GLES20.glGetUniformLocation(this.n, "cameraVideoWidth");
    this.p = GLES20.glGetUniformLocation(this.n, "cameraVideoHeight");
    this.q = GLES20.glGetUniformLocation(this.n, "cameraEdgeStart");
    this.r = GLES20.glGetUniformLocation(this.n, "cameraEdgeEnd");
    this.s = GLES20.glGetUniformLocation(this.n, "cameraScanLineTexture");
    this.t = GLES20.glGetUniformLocation(this.n, "cameraScanNetTexture");
    this.u = GLES20.glGetUniformLocation(this.n, "cameraScanNoiseTexture");
    this.v = GLES20.glGetUniformLocation(this.n, "noiseMode");
    Object localObject1 = new int[3];
    GLES20.glGenTextures(3, (int[])localObject1, 0);
    this.H = localObject1[0];
    this.I = localObject1[1];
    this.J = localObject1[2];
    if (QLog.isColorLevel())
    {
      localObject1 = f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("textureLightId:");
      localStringBuilder.append(this.H);
      localStringBuilder.append("   textureNetId:");
      localStringBuilder.append(this.I);
      localStringBuilder.append("   textureNoiseId:");
      localStringBuilder.append(this.J);
      QLog.d((String)localObject1, 1, localStringBuilder.toString());
    }
    GLES20.glBindTexture(3553, this.H);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ARGB_8888;
      localObject1 = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130846318, (BitmapFactory.Options)localObject1);
      if (localObject1 != null)
      {
        GLUtils.texImage2D(3553, 0, (Bitmap)localObject1, 0);
        ((Bitmap)localObject1).recycle();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      localOutOfMemoryError1.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "getGLSLValues", localOutOfMemoryError1);
      }
    }
    GLES20.glBindTexture(3553, this.I);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    try
    {
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
      localObject2 = BitmapFactory.decodeResource(this.F.a().getResources(), 2130846319, (BitmapFactory.Options)localObject2);
      if (localObject2 != null)
      {
        GLUtils.texImage2D(3553, 0, (Bitmap)localObject2, 0);
        ((Bitmap)localObject2).recycle();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      localOutOfMemoryError2.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d(f, 2, "getGLSLValues 2 ", localOutOfMemoryError2);
      }
    }
    GLES20.glBindTexture(3553, this.J);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
  }
  
  public void b(int paramInt)
  {
    this.K = 2;
    this.G = paramInt;
    this.d = true;
  }
  
  protected void c()
  {
    GLES20.glUseProgram(this.n);
  }
  
  public void d()
  {
    this.T += 1L;
    if ((this.P != null) && (this.S != 0))
    {
      if (this.T % 3L != 1L) {
        return;
      }
      if (this.U == null) {
        this.U = new Random();
      }
      System.currentTimeMillis();
      int i6 = this.P.getWidth();
      int i1 = this.P.getHeight();
      int i7 = this.M;
      float f2 = i1;
      float f3 = 1.0F / f2;
      float f1 = 5.0F / f2;
      int i3 = 0;
      int i4 = 0;
      int i2 = 0;
      while (i3 < 300)
      {
        CameraRendererable.Noise localNoise = this.N[i3];
        float f4;
        if ((localNoise != null) && (!localNoise.c)) {
          if (this.U.nextFloat() > 0.7F - localNoise.b * 0.35F - Math.abs(localNoise.a * 0.3F - 0.15F))
          {
            localNoise.c = true;
          }
          else
          {
            f4 = this.U.nextFloat();
            localNoise.b += f4 * 0.3F + localNoise.b * 0.2F + f1;
            if (localNoise.b > 1.0D) {
              localNoise.c = true;
            }
          }
        }
        Object localObject;
        if (localNoise != null)
        {
          i1 = i2;
          localObject = localNoise;
          if (!localNoise.c) {}
        }
        else
        {
          if (i2 > i7)
          {
            i5 = i4;
            break label511;
          }
          localObject = localNoise;
          if (localNoise == null)
          {
            localObject = new CameraRendererable.Noise(this);
            this.N[i3] = localObject;
          }
          f4 = this.U.nextFloat();
          if (f4 < 0.4D) {
            ((CameraRendererable.Noise)localObject).a = (f4 * 2.35F + 0.02F);
          } else if (f4 > 0.6F) {
            ((CameraRendererable.Noise)localObject).a = ((1.0F - f4) * 2.35F + 0.02F);
          }
          ((CameraRendererable.Noise)localObject).b = (this.U.nextFloat() * 0.05F + f3);
          ((CameraRendererable.Noise)localObject).c = false;
          i1 = i2 + 1;
        }
        int i5 = i4;
        i2 = i1;
        if (localObject != null)
        {
          i5 = i4;
          i2 = i1;
          if (!((CameraRendererable.Noise)localObject).c)
          {
            i5 = i4;
            i2 = i1;
            if (((CameraRendererable.Noise)localObject).b < 1.0D)
            {
              localObject = this.O;
              i2 = i4 * 2;
              localObject[i2] = (this.N[i3].a * i6);
              this.O[(i2 + 1)] = (this.N[i3].b * f2);
              i5 = i4 + 1;
              i2 = i1;
            }
          }
        }
        label511:
        i3 += 1;
        i4 = i5;
      }
      this.Q.drawColor(-16777216, PorterDuff.Mode.CLEAR);
      this.R.setStrokeWidth(1.0F);
      this.R.setColor(-1);
      this.Q.drawPoints(this.O, 0, i4, this.R);
      GLUtils.texImage2D(3553, 0, this.P, 0);
    }
  }
  
  protected void e()
  {
    GLES20.glDisableVertexAttribArray(this.g);
    GLES20.glDisableVertexAttribArray(this.j);
  }
  
  protected void f()
  {
    GLES20.glBindTexture(36197, 0);
  }
  
  protected void g()
  {
    GLES20.glUseProgram(0);
  }
  
  public int h()
  {
    return this.a.a();
  }
  
  public void i()
  {
    SurfaceTexture localSurfaceTexture = this.E;
    if (localSurfaceTexture != null)
    {
      localSurfaceTexture.setOnFrameAvailableListener(null);
      this.E.release();
      this.G = 0;
      this.E = null;
    }
    this.G = -1;
    this.X = null;
    this.d = false;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (((this.G == -1) && (this.K == 1)) || (!this.d)) {
      return;
    }
    System.currentTimeMillis();
    if ((this.E != null) && (this.K == 1)) {
      if (Build.MODEL.equalsIgnoreCase("MI 5C"))
      {
        try
        {
          this.E.updateTexImage();
        }
        catch (Exception paramGL10)
        {
          paramGL10.printStackTrace();
          if (!QLog.isColorLevel()) {
            break label171;
          }
        }
        QLog.d(f, 2, "onDrawFrame updateTexImage error", paramGL10);
      }
      else
      {
        if (this.c.a == 0L) {
          return;
        }
        while (this.c.c > this.c.b)
        {
          paramGL10 = this.c;
          paramGL10.b += 1L;
          try
          {
            this.E.updateTexImage();
          }
          catch (Exception paramGL10)
          {
            paramGL10.printStackTrace();
          }
          if (QLog.isColorLevel()) {
            QLog.d(f, 2, "onDrawFrame updateTexImage error", paramGL10);
          }
        }
      }
    }
    label171:
    if ((this.K == 1) && (this.E != null))
    {
      c();
      a(this.G);
      paramGL10 = new float[16];
      if (this.K == 1) {
        this.E.getTransformMatrix(paramGL10);
      } else {
        Matrix.setIdentityM(paramGL10, 0);
      }
      a(this.C, this.D.a(), this.D.f(), this.D.d(), paramGL10, this.D.b(), this.D.e());
      a(0, this.D.c());
      e();
      f();
      g();
    }
    else
    {
      paramGL10 = this.a;
      if ((paramGL10 != null) && (this.K == 2)) {
        paramGL10.a(this.W);
      }
    }
    this.b.removeCallbacks(this.e);
    this.b.postDelayed(this.e, 30L);
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.n = GlUtil.a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\n\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\n\nvarying vec2 vTextureCoord;\nvarying vec2 edgeTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n    edgeTextureCoord = vec2(aTextureCoord.x,1.0 - aTextureCoord.y);\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n\nvarying vec2 vTextureCoord;\nvarying vec2 edgeTextureCoord;\nuniform samplerExternalOES uTexture;\nuniform sampler2D cameraScanLineTexture;\nuniform sampler2D cameraScanNetTexture;\nuniform sampler2D cameraScanNoiseTexture;\nuniform int noiseMode;\nuniform float cameraVideoWidth;\nuniform float cameraVideoHeight;\nuniform float cameraEdgeStart;\nuniform float cameraEdgeEnd;\nvoid getEdgeRGBSobel(vec2 vTextureCoord){\n   float gadthis =  cameraEdgeStart - edgeTextureCoord.y;\n   vec4 cTemp4 = texture2D(uTexture, vTextureCoord);\n   const float gad = 0.6;\n   if(edgeTextureCoord.y > cameraEdgeEnd || gadthis < 0.0 || gadthis>gad){\n       gl_FragColor=cTemp4;\n    }else{\n        vec2 thistexcoord = vec2( edgeTextureCoord.x , 1.0 - gadthis / gad);\n        vec4 netColor = texture2D(cameraScanNetTexture, thistexcoord);\n        cTemp4.rgb = cTemp4.rgb * (1.0 - netColor.w) + vec3(1.0, 1.0, 1.0) * netColor.w;\n        vec2 offset0=vec2(-1.0/cameraVideoWidth,-1.0/cameraVideoHeight); vec2 offset1=vec2(0.0,-1.0/cameraVideoHeight); vec2 offset2=vec2(1.0/cameraVideoWidth,-1.0/cameraVideoHeight);\n        vec2 offset3=vec2(-1.0/cameraVideoWidth,0.0); vec2 offset5=vec2(1.0/cameraVideoWidth,0.0);\n        vec2 offset6=vec2(-1.0/cameraVideoWidth,1.0/cameraVideoHeight); vec2 offset7=vec2(0.0,1.0/cameraVideoHeight); vec2 offset8=vec2(1.0/cameraVideoWidth,1.0/cameraVideoHeight);\n        vec4 cTemp0,cTemp1,cTemp2,cTemp3,cTemp5,cTemp6,cTemp7,cTemp8;\n        cTemp0=texture2D(uTexture, vTextureCoord + offset0);\n        cTemp1=texture2D(uTexture, vTextureCoord + offset1);\n        cTemp2=texture2D(uTexture, vTextureCoord + offset2);\n        cTemp3=texture2D(uTexture, vTextureCoord + offset3);\n        cTemp5=texture2D(uTexture, vTextureCoord + offset5);\n        cTemp6=texture2D(uTexture, vTextureCoord + offset6);\n        cTemp7=texture2D(uTexture, vTextureCoord + offset7);\n        cTemp8=texture2D(uTexture, vTextureCoord + offset8);\n        vec4 sumx = -cTemp0 -  cTemp1 - cTemp2 + cTemp6.r +  cTemp7 + cTemp8;\n        vec4 sumy = -cTemp6 -  cTemp3 - cTemp0 + cTemp8 +  cTemp5 + cTemp2;\n        float sumxy = 0.3*sumx.r+0.59*sumx.g+0.11*sumx.b;\n        float sumyy = 0.3*sumy.r+0.59*sumy.g+0.11*sumy.b;\n        float sum  = length(vec2(sumxy, sumyy));\n        if(sum > 0.45){\n            sum+=0.2;\n            sum = min(sum,1.0);\n            float weightT = ((gad - gadthis)/gad *0.8);\n            sum = 0.8 * sum * weightT;\n            cTemp4 = vec4(0.0*weightT,0.9725*weightT,weightT*1.0,weightT) + cTemp4 * (1.0 - weightT - sum)+vec4(sum,sum,sum,1.0);\n        }\n        vec4 fugaicolor = texture2D(cameraScanLineTexture, thistexcoord);\n        float alphaW = fugaicolor.w * (gad - gadthis)/gad;\n        gl_FragColor = cTemp4 * (1.0 - alphaW) + fugaicolor * alphaW;\n        if(sum <= 0.45 && thistexcoord.y > 0.75 && noiseMode == 1){\n            float noiseAlpha = texture2D(cameraScanNoiseTexture, vec2(thistexcoord.x, (1.0-thistexcoord.y)/0.25)).a;\n            noiseAlpha = noiseAlpha*(4.0*thistexcoord.y-3.0);\n            if(noiseAlpha > 0.0626 && noiseAlpha<=1.0){\n                gl_FragColor.rgb = gl_FragColor.rgb * (1.0 - noiseAlpha) + vec3(0.753, 0.988, 1.0) * noiseAlpha;\n            }\n        }\n        gl_FragColor.a = 1.0;\n    }\n}\nvoid main() {\n   getEdgeRGBSobel(vTextureCoord);\n}");
    b();
    if (ArCoreNativeSoManager.a() != null) {
      this.a.a(BaseApplicationImpl.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.CameraRendererable
 * JD-Core Version:    0.7.0.1
 */