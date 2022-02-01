package com.tencent.av.opengl.utils;

import android.opengl.GLES20;
import android.opengl.Matrix;

public class AVGLUtils
{
  public static int NOINITID = -1;
  public static final float[] matrix = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public static float[] matrixV = { 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public static float[] matrixVRotate270;
  public static float[] matrixVRotate90 = { 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  
  static
  {
    matrixVRotate270 = new float[] { 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    Matrix.rotateM(matrixVRotate90, 0, 90.0F, 0.0F, 0.0F, 1.0F);
    Matrix.rotateM(matrixVRotate270, 0, 270.0F, 0.0F, 0.0F, 1.0F);
  }
  
  public static int initFrameBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
    GLES20.glBindFramebuffer(36160, 0);
    return arrayOfInt[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.utils.AVGLUtils
 * JD-Core Version:    0.7.0.1
 */