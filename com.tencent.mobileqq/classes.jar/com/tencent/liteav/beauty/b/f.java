package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.j;

public class f
  extends j
{
  private int[] A;
  private float B = 4.0F;
  int r;
  int s;
  boolean t;
  private d u;
  private j v;
  private f.c w;
  private f.a x;
  private f.b y;
  private int[] z;
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.f == paramInt2) && (this.e == paramInt1)) {
      return;
    }
    super.a(paramInt1, paramInt2);
    if (!this.t) {
      if (paramInt1 < paramInt2)
      {
        if (paramInt1 < 540) {
          this.B = 1.0F;
        } else {
          this.B = 4.0F;
        }
      }
      else if (paramInt2 < 540) {
        this.B = 1.0F;
      } else {
        this.B = 4.0F;
      }
    }
    float f1 = paramInt1;
    float f2 = this.B;
    this.r = ((int)(f1 / f2));
    this.s = ((int)(paramInt2 / f2));
    this.v.a(this.r, this.s);
    this.w.a(this.r, this.s);
    this.x.a(this.r, this.s);
    this.y.a(paramInt1, paramInt2);
    this.u.a(this.r, this.s);
    int[] arrayOfInt = this.z;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteFramebuffers(arrayOfInt.length, arrayOfInt, 0);
      GLES20.glDeleteTextures(this.z.length, this.A, 0);
      this.z = null;
      this.A = null;
    }
    this.z = new int[8];
    arrayOfInt = this.z;
    this.A = new int[arrayOfInt.length];
    GLES20.glGenFramebuffers(arrayOfInt.length, arrayOfInt, 0);
    GLES20.glGenTextures(this.z.length, this.A, 0);
    int i = 0;
    while (i < this.z.length)
    {
      GLES20.glBindTexture(3553, this.A[i]);
      if (i >= 5) {
        GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      } else {
        GLES20.glTexImage2D(3553, 0, 6408, this.r, this.s, 0, 6408, 5121, null);
      }
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.z[i]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.A[i], 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      i += 1;
    }
  }
  
  public int b(int paramInt)
  {
    if (this.B != 1.0F)
    {
      GLES20.glViewport(0, 0, this.r, this.s);
      i = this.v.b(paramInt);
    }
    else
    {
      i = paramInt;
    }
    int j = this.u.a(i, this.z[4], this.A[4]);
    int i = this.w.a(i, j, this.z[0], this.A[0]);
    j = this.x.a(i, j, this.z[1], this.A[1]);
    int k = this.u.a(i, this.z[2], this.A[2]);
    int m = this.u.a(j, this.z[3], this.A[3]);
    j = k;
    i = m;
    if (this.B != 1.0F)
    {
      GLES20.glViewport(0, 0, this.e, this.f);
      j = this.v.a(k, this.z[5], this.A[5]);
      i = this.v.a(m, this.z[6], this.A[6]);
    }
    return this.y.a(j, i, paramInt, this.z[7], this.A[7]);
  }
  
  public boolean b()
  {
    boolean bool2 = super.b();
    if (bool2)
    {
      this.u = new d();
      boolean bool1 = bool2;
      if (bool2) {
        bool1 = this.u.a();
      }
      this.w = new f.c();
      bool2 = bool1;
      if (bool1) {
        bool2 = this.w.a();
      }
      this.x = new f.a("precision highp float;  \nuniform sampler2D inputImageTexture;  \nuniform sampler2D inputImageTexture2;  \nvarying vec2 textureCoordinate;  \nvarying vec2 textureCoordinate2;  \nvoid main()  \n{  \n\tgl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);  \n}  \n");
      bool1 = bool2;
      if (bool2) {
        bool1 = this.x.a();
      }
      this.y = new f.b("precision highp float;   \nuniform sampler2D inputImageTexture;   \nuniform sampler2D inputImageTexture2;  \nuniform sampler2D inputImageTexture3;   \nvarying vec2 textureCoordinate;   \nvarying vec2 textureCoordinate2;  \nvarying vec2 textureCoordinate3;    \nvoid main()   \n{   \n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);   \n}   \n");
      bool2 = bool1;
      if (bool1) {
        bool2 = this.y.a();
      }
      this.v = new j();
      this.v.a(true);
      bool1 = bool2;
      if (bool2) {
        bool1 = this.v.a();
      }
      if (bool1) {
        return true;
      }
    }
    d();
    return false;
  }
  
  public void e()
  {
    if (this.g)
    {
      super.e();
      this.u.d();
      this.w.d();
      this.x.d();
      this.y.d();
      this.v.d();
      int[] arrayOfInt = this.z;
      if (arrayOfInt != null)
      {
        GLES20.glDeleteFramebuffers(arrayOfInt.length, arrayOfInt, 0);
        GLES20.glDeleteTextures(this.z.length, this.A, 0);
        this.z = null;
      }
      this.A = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.f
 * JD-Core Version:    0.7.0.1
 */