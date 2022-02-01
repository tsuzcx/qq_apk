package com.tencent.mobileqq.ar.keying;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

public class FrameBuffer
{
  private int[] a = null;
  private int[] b = null;
  private int c;
  private int d;
  
  private void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.c = paramInt1;
      this.d = paramInt2;
      int[] arrayOfInt = this.a;
      if (arrayOfInt != null)
      {
        GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
        this.a = null;
      }
      arrayOfInt = this.b;
      if (arrayOfInt != null)
      {
        GLES20.glDeleteTextures(1, arrayOfInt, 0);
        this.b = null;
      }
      this.a = new int[1];
      this.b = new int[1];
      GLES20.glGenFramebuffers(1, this.a, 0);
      GLES20.glGenTextures(1, this.b, 0);
      GLES20.glBindTexture(3553, this.b[0]);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glBindFramebuffer(36160, this.a[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.b[0], 0);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      return;
    }
    throw new IllegalArgumentException("width & height should > 0!");
  }
  
  public void a()
  {
    int[] arrayOfInt = this.b;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.b = null;
    }
    arrayOfInt = this.a;
    if (arrayOfInt != null)
    {
      GLES20.glDeleteFramebuffers(arrayOfInt.length, arrayOfInt, 0);
      this.a = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (this.b == null) || (paramInt1 != this.c) || (paramInt2 != this.d))
    {
      long l = System.currentTimeMillis();
      b(paramInt1, paramInt2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" init need ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.i("Keying_FrameBuffer", 2, localStringBuilder.toString());
    }
    GLES20.glBindFramebuffer(36160, this.a[0]);
  }
  
  public int b()
  {
    int[] arrayOfInt = this.b;
    if (arrayOfInt != null) {
      return arrayOfInt[0];
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.FrameBuffer
 * JD-Core Version:    0.7.0.1
 */