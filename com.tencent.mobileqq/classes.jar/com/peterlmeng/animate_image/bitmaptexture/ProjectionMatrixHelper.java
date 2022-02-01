package com.peterlmeng.animate_image.bitmaptexture;

import android.opengl.GLES20;
import android.opengl.Matrix;

public class ProjectionMatrixHelper
{
  private float[] mProjectionMatrix = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  String name;
  int program;
  private int uMatrixLocation = 0;
  
  public ProjectionMatrixHelper(int paramInt, String paramString)
  {
    this.program = paramInt;
    this.name = paramString;
    this.uMatrixLocation = GLES20.glGetUniformLocation(this.program, paramString);
  }
  
  public void enable(int paramInt1, int paramInt2)
  {
    float f;
    if (paramInt1 > paramInt2)
    {
      f = 0.1F * (paramInt1 * 0.1F / paramInt2);
      Matrix.orthoM(this.mProjectionMatrix, 0, -f, f, -1.0F, 1.0F, -1.0F, 1.0F);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(this.uMatrixLocation, 1, false, this.mProjectionMatrix, 0);
      return;
      f = paramInt2 * 0.1F / paramInt1 * 0.1F;
      Matrix.orthoM(this.mProjectionMatrix, 0, -1.0F, 1.0F, -f, f, -1.0F, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.bitmaptexture.ProjectionMatrixHelper
 * JD-Core Version:    0.7.0.1
 */