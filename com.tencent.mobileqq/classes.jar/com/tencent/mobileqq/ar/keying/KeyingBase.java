package com.tencent.mobileqq.ar.keying;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class KeyingBase
{
  public static final float[] w = new float[16];
  public String A = "//抠像算法相关定义片段\n";
  public String B = "//用户自己定义变量及方法相关片段\n";
  public String C = "void main() {\n    vec2 position = vTextureCoord;\n";
  public String D = "    //用户定义片段，用于在获取颜色值前处理, 如纹理坐标改变\n";
  public String E = "    gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n    #if defined(TEXTURE_TYPE_OES)\n        gl_FragColor = texture2D(samplerOES, position);\n        gl_FragColor.r = max(0.0, min(gl_FragColor.r, 1.0));\n        gl_FragColor.g = max(0.0, min(gl_FragColor.g, 1.0));\n        gl_FragColor.b = max(0.0, min(gl_FragColor.b, 1.0));\n    #endif\n    #if defined(TEXTURE_TYPE_SAMPLER2D)\n        gl_FragColor = texture2D(sampler2d1, position);\n    #endif\n    #if defined(TEXTURE_TYPE_Y_U_V)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        yuv.y = texture2D(sampler2d2, position).r-0.5;\n        yuv.z = texture2D(sampler2d3, position).r-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;\n        gl_FragColor.a = 1.0;\n    #endif\n    #if defined(TEXTURE_TYPE_Y_UV)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        vec2 uv = texture2D(sampler2d2, position).ra;\n        yuv.y = uv.x-0.5;\n        yuv.z = uv.y-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;//yuv->rgb\n        gl_FragColor.a = 1.0;\n    #endif\n";
  public String F = KeyingUtil.b;
  public String G = KeyingUtil.c;
  public String H = KeyingUtil.d;
  public float[] I;
  public short[] J;
  public KeyingBase.UserInterface K;
  private boolean a = false;
  public int d;
  public String e = "precision mediump float;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main() {\n   gl_Position = uMVPMatrix * aPosition;\n   vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}";
  public String f;
  public Plane g;
  public CylinderSide h;
  public FrameBuffer i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s = -1;
  public float t;
  public float u;
  public float v;
  public int x = 0;
  public String y = KeyingUtil.a;
  public String z = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES samplerOES;\nuniform sampler2D sampler2d1;\nuniform sampler2D sampler2d2;\nuniform sampler2D sampler2d3;\nuniform vec4 u_screenColor;\nvarying vec2 vTextureCoord;\n";
  
  static
  {
    Matrix.setIdentityM(w, 0);
  }
  
  public KeyingBase(int paramInt)
  {
    this.x = paramInt;
  }
  
  private final int a(KeyingParams paramKeyingParams, boolean paramBoolean)
  {
    a(paramKeyingParams);
    paramKeyingParams = this.K;
    if (paramKeyingParams != null) {
      paramKeyingParams.a();
    }
    if (this.s == 1) {
      this.h.a(this.j, this.k);
    } else {
      this.g.a();
    }
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    KeyingUtil.a("keyingHandleAfter");
    if (paramBoolean) {
      return this.i.b();
    }
    return 0;
  }
  
  private final void a(KeyingParams paramKeyingParams, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!this.a) {
      a(-1, 0.0F, 0.0F, 0.0F);
    }
    GLES20.glUseProgram(this.d);
    KeyingUtil.a("glUseProgram");
    if (paramBoolean)
    {
      this.i.a(paramInt1, paramInt2);
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
    }
    if (this.s != 1) {
      this.g.a(this.j, this.k);
    }
    GLES20.glUniformMatrix4fv(this.l, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(this.m, 1, false, paramArrayOfFloat2, 0);
    paramInt1 = this.r;
    if (paramInt1 != -1) {
      GLES20.glUniform4f(paramInt1, paramKeyingParams.b, paramKeyingParams.c, paramKeyingParams.d, 1.0F);
    }
    KeyingUtil.a("keyingHandleBefore");
  }
  
  public final int a(int[] paramArrayOfInt, KeyingParams paramKeyingParams, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return a(paramArrayOfInt, paramKeyingParams, paramArrayOfFloat1, paramArrayOfFloat2, false, 0, 0);
  }
  
  public final int a(int[] paramArrayOfInt, KeyingParams paramKeyingParams, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt != null)
    {
      a(paramKeyingParams, paramArrayOfFloat1, paramArrayOfFloat2, paramBoolean, paramInt1, paramInt2);
      paramInt1 = this.x;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if ((paramInt1 == 3) || (paramInt1 == 4)) {
            if (paramArrayOfInt.length >= 2)
            {
              GLES20.glActiveTexture(33984);
              GLES20.glBindTexture(3553, paramArrayOfInt[0]);
              GLES20.glTexParameterf(3553, 10240, 9729.0F);
              GLES20.glTexParameterf(3553, 10241, 9729.0F);
              GLES20.glTexParameterf(3553, 10242, 33071.0F);
              GLES20.glTexParameterf(3553, 10243, 33071.0F);
              GLES20.glUniform1i(this.n, 0);
              GLES20.glActiveTexture(33985);
              GLES20.glBindTexture(3553, paramArrayOfInt[1]);
              GLES20.glTexParameterf(3553, 10240, 9729.0F);
              GLES20.glTexParameterf(3553, 10241, 9729.0F);
              GLES20.glTexParameterf(3553, 10242, 33071.0F);
              GLES20.glTexParameterf(3553, 10243, 33071.0F);
              GLES20.glUniform1i(this.o, 1);
              if (this.x == 3) {
                if (paramArrayOfInt.length >= 3)
                {
                  GLES20.glActiveTexture(33986);
                  GLES20.glBindTexture(3553, paramArrayOfInt[2]);
                  GLES20.glTexParameterf(3553, 10240, 9729.0F);
                  GLES20.glTexParameterf(3553, 10241, 9729.0F);
                  GLES20.glTexParameterf(3553, 10242, 33071.0F);
                  GLES20.glTexParameterf(3553, 10243, 33071.0F);
                  GLES20.glUniform1i(this.p, 2);
                }
                else
                {
                  throw new IllegalArgumentException("textureIds.size should >= 3!");
                }
              }
            }
            else
            {
              throw new IllegalArgumentException("textureIds.size should >= 2!");
            }
          }
        }
        else if (paramArrayOfInt.length >= 1)
        {
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, paramArrayOfInt[0]);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLES20.glUniform1i(this.n, 0);
        }
        else
        {
          throw new IllegalArgumentException("textureIds.size should >= 1!");
        }
      }
      else
      {
        if (paramArrayOfInt.length < 1) {
          break label458;
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, paramArrayOfInt[0]);
        GLES20.glTexParameterf(36197, 10241, 9728.0F);
        GLES20.glTexParameterf(36197, 10240, 9729.0F);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glUniform1i(this.q, 0);
      }
      KeyingUtil.a("keyingTexture");
      return a(paramKeyingParams, paramBoolean);
      label458:
      throw new IllegalArgumentException("textureIds.size should >= 1!");
    }
    throw new IllegalArgumentException("textureIds can not be null!");
  }
  
  protected abstract void a();
  
  public final void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    long l1 = System.currentTimeMillis();
    if (!TextUtils.isEmpty(this.e))
    {
      if (this.a) {
        return;
      }
      this.a = true;
      this.s = paramInt;
      this.t = paramFloat1;
      this.u = paramFloat2;
      this.v = paramFloat3;
      this.f = b();
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init. markerType = ");
        ((StringBuilder)localObject).append(this.s);
        ((StringBuilder)localObject).append(", markerWidth = ");
        ((StringBuilder)localObject).append(this.t);
        ((StringBuilder)localObject).append(", markerHeight = ");
        ((StringBuilder)localObject).append(this.u);
        ((StringBuilder)localObject).append(", mFragmentShader = \n");
        ((StringBuilder)localObject).append(this.f);
        QLog.d("KeyingBase", 4, ((StringBuilder)localObject).toString());
      }
      if (this.s == 1)
      {
        this.h = new CylinderSide(1.0F, this.t, this.u, this.v);
      }
      else
      {
        localObject = this.I;
        if (localObject != null)
        {
          short[] arrayOfShort = this.J;
          if (arrayOfShort != null)
          {
            this.g = new Plane((float[])localObject, arrayOfShort);
            break label246;
          }
        }
        this.g = new Plane();
      }
      label246:
      this.i = new FrameBuffer();
      this.d = KeyingUtil.a(this.e, this.f);
      KeyingUtil.a("createProgram");
      paramInt = this.d;
      if (paramInt == 0) {
        return;
      }
      this.j = GLES20.glGetAttribLocation(paramInt, "aPosition");
      KeyingUtil.a("glGetAttribLocation aPosition");
      if (this.j != -1)
      {
        this.k = GLES20.glGetAttribLocation(this.d, "aTextureCoord");
        KeyingUtil.a("glGetAttribLocation aTextureCoord");
        if (this.k != -1)
        {
          this.l = GLES20.glGetUniformLocation(this.d, "uMVPMatrix");
          KeyingUtil.a("glGetUniformLocation uMVPMatrix");
          this.m = GLES20.glGetUniformLocation(this.d, "uSTMatrix");
          KeyingUtil.a("glGetUniformLocation uSTMatrix");
          this.q = GLES20.glGetUniformLocation(this.d, "samplerOES");
          KeyingUtil.a("glGetUniformLocation samplerOES");
          this.n = GLES20.glGetUniformLocation(this.d, "sampler2d1");
          KeyingUtil.a("glGetUniformLocation sampler2d1");
          this.o = GLES20.glGetUniformLocation(this.d, "sampler2d2");
          KeyingUtil.a("glGetUniformLocation sampler2d2");
          this.p = GLES20.glGetUniformLocation(this.d, "sampler2d3");
          KeyingUtil.a("glGetUniformLocation sampler2d3");
          this.r = GLES20.glGetUniformLocation(this.d, "u_screenColor");
          KeyingUtil.a("glGetUniformLocation u_screenColor");
          a();
          localObject = this.K;
          if (localObject != null) {
            ((KeyingBase.UserInterface)localObject).a(this.d);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" init need ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
          ((StringBuilder)localObject).append("ms");
          QLog.i("KeyingBase", 2, ((StringBuilder)localObject).toString());
          return;
        }
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
      }
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    throw new IllegalArgumentException("mVertexShader can not be empty!");
  }
  
  protected abstract void a(KeyingParams paramKeyingParams);
  
  public void a(String paramString1, String paramString2, String paramString3, KeyingBase.UserInterface paramUserInterface)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.B = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.D = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      this.G = paramString3;
    }
    this.K = paramUserInterface;
  }
  
  public void a(float[] paramArrayOfFloat, short[] paramArrayOfShort)
  {
    this.I = paramArrayOfFloat;
    this.J = paramArrayOfShort;
  }
  
  protected String b()
  {
    this.y = KeyingUtil.a(this.x);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.y);
    localStringBuilder.append(this.z);
    localStringBuilder.append(this.A);
    localStringBuilder.append(this.B);
    localStringBuilder.append(this.C);
    localStringBuilder.append(this.D);
    localStringBuilder.append(this.E);
    localStringBuilder.append(this.F);
    localStringBuilder.append(this.G);
    localStringBuilder.append(this.H);
    return localStringBuilder.toString();
  }
  
  public void c()
  {
    if (!this.a) {
      return;
    }
    GLES20.glDeleteProgram(this.d);
    FrameBuffer localFrameBuffer = this.i;
    if (localFrameBuffer != null)
    {
      localFrameBuffer.a();
      this.i = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.KeyingBase
 * JD-Core Version:    0.7.0.1
 */