package com.tencent.av.utils;

import android.opengl.GLES20;

public class GLTextureCopy
{
  private int[] a = new int[1];
  private int[] b = new int[1];
  
  public GLTextureCopy()
  {
    GLES20.glGenTextures(1, this.a, 0);
    GLES20.glBindTexture(3553, this.a[0]);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glGenFramebuffers(1, this.b, 0);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.a[0]);
    GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, paramInt1, paramInt2, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glBindTexture(3553, 0);
    return this.a[0];
  }
  
  public void a()
  {
    GLES20.glDeleteFramebuffers(1, this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GLTextureCopy
 * JD-Core Version:    0.7.0.1
 */