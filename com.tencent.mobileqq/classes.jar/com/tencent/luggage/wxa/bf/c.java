package com.tencent.luggage.wxa.bf;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class c
  implements GLSurfaceView.Renderer
{
  static float[] a = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  static float[] b = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  private static final float[] e = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private boolean A;
  private int B;
  private int C;
  private int D;
  private ByteBuffer E;
  ByteBuffer c;
  ByteBuffer d;
  private int f = 0;
  private int g = 0;
  private boolean h = false;
  private byte[] i = null;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private FloatBuffer u;
  private FloatBuffer v;
  private float[] w = new float[16];
  private boolean x = false;
  private float[] y = a;
  private float[] z;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float[] arrayOfFloat = e;
    this.z = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
    this.A = false;
    this.B = 0;
    this.C = 0;
    this.D = 0;
    this.E = null;
    this.C = b.a();
    this.D = b.b();
    GLES20.glBindFramebuffer(36160, this.D);
    GLES20.glBindTexture(3553, this.C);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt3, paramInt4, 0, 6408, 5121, null);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.C, 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
  }
  
  private void b()
  {
    if ((this.o != 0) && (this.m != -1) && (this.n != -1) && (this.j > 0) && (this.k > 0) && (this.i != null))
    {
      GLES20.glBindFramebuffer(36160, this.D);
      GLES20.glBindTexture(3553, this.C);
      GLES20.glTexImage2D(3553, 0, 6408, this.f, this.g, 0, 6408, 5121, null);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.C, 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glViewport(0, 0, this.f, this.g);
      GLES20.glUseProgram(this.o);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.m);
      GLES20.glTexImage2D(3553, 0, 6409, this.j, this.k, 0, 6409, 5121, this.c);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.r, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.n);
      GLES20.glTexImage2D(3553, 0, 6410, this.j / 2, this.k / 2, 0, 6410, 5121, this.d);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.s, 1);
      Matrix.setIdentityM(this.w, 0);
      int i1 = this.l;
      int i2 = this.B;
      if ((i2 == 90) || (i2 == 270)) {
        i1 = (this.l - this.B + 360 + 180) % 360;
      }
      Matrix.setRotateM(this.w, 0, i1, 0.0F, 0.0F, -1.0F);
      i1 = this.l;
      if ((i1 != 90) && (i1 != 270)) {
        Matrix.scaleM(this.w, 0, 1.0F, -1.0F, 1.0F);
      } else {
        Matrix.scaleM(this.w, 0, -1.0F, 1.0F, 1.0F);
      }
      GLES20.glUniformMatrix4fv(this.t, 1, false, this.w, 0);
      this.u.position(0);
      GLES20.glVertexAttribPointer(this.q, 2, 5126, false, 0, this.u);
      GLES20.glEnableVertexAttribArray(this.q);
      this.v.position(0);
      GLES20.glVertexAttribPointer(this.p, 2, 5126, false, 0, this.v);
      GLES20.glEnableVertexAttribArray(this.p);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.q);
      GLES20.glDisableVertexAttribArray(this.p);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFinish();
      this.E.position(0);
      GLES20.glReadPixels(0, 0, this.f, this.g, 6408, 5121, this.E);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glUseProgram(0);
    }
  }
  
  public void a()
  {
    int i1 = this.C;
    int[] arrayOfInt;
    if (i1 != 0)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = i1;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    i1 = this.D;
    if (i1 != 0)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = i1;
      GLES20.glDeleteFramebuffers(arrayOfInt.length, arrayOfInt, 0);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    this.E = paramByteBuffer;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      try
      {
        if ((this.k != paramInt2) || (this.j != paramInt1) || (this.l != paramInt3)) {
          break label342;
        }
        if (this.B == paramInt4) {
          break label336;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        byte[] arrayOfByte;
        o.b("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
      if (bool) {
        o.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.A), Boolean.valueOf(bool), this });
      }
      if ((this.i == null) || (this.i.length != paramArrayOfByte.length)) {
        this.i = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.i, 0, paramArrayOfByte.length);
      this.j = paramInt1;
      this.k = paramInt2;
      this.l = paramInt3;
      this.B = paramInt4;
      if (bool)
      {
        paramInt3 = paramInt2 * paramInt1;
        this.c = ByteBuffer.allocateDirect(paramInt3);
        this.d = ByteBuffer.allocateDirect(paramInt3 / 2);
        this.c.order(ByteOrder.nativeOrder());
        this.d.order(ByteOrder.nativeOrder());
        if (this.y != null)
        {
          this.u.put(this.y);
          this.u.position(0);
        }
      }
      if ((this.c != null) && (this.d != null))
      {
        paramArrayOfByte = this.c;
        arrayOfByte = this.i;
        paramInt1 *= paramInt2;
        paramArrayOfByte.put(arrayOfByte, 0, paramInt1);
        this.c.position(0);
        this.d.put(this.i, paramInt1, paramInt1 / 2);
        this.d.position(0);
        return;
      }
      return;
      label336:
      boolean bool = false;
      continue;
      label342:
      bool = true;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.E == null) {
      return;
    }
    long l1 = af.b();
    this.h = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.x)
    {
      o.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
      this.x = false;
      this.h = false;
      this.i = null;
      this.j = -1;
      this.k = -1;
      return;
    }
    b();
    this.h = false;
    o.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", new Object[] { Long.valueOf(af.c(l1)) });
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.f) || (paramInt2 != this.g))
    {
      o.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.f = paramInt1;
      this.g = paramInt2;
      float f1 = this.f / this.g / 2.0F;
      float f2 = -f1;
      b = new float[] { -1.0F, f2, 1.0F, f2, -1.0F, f1, 1.0F, f1 };
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    o.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.o = b.a("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.o == 0) {
      o.b("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
    }
    this.q = GLES20.glGetAttribLocation(this.o, "a_position");
    this.p = GLES20.glGetAttribLocation(this.o, "a_texCoord");
    this.r = GLES20.glGetUniformLocation(this.o, "y_texture");
    this.s = GLES20.glGetUniformLocation(this.o, "uv_texture");
    this.t = GLES20.glGetUniformLocation(this.o, "uMatrix");
    this.m = b.a();
    this.n = b.a();
    this.u = ByteBuffer.allocateDirect(this.y.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.u.put(this.y);
    this.u.position(0);
    this.v = ByteBuffer.allocateDirect(e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.v.put(e);
    this.v.position(0);
    o.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n), this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bf.c
 * JD-Core Version:    0.7.0.1
 */