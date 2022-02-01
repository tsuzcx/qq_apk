package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import java.util.Arrays;

public class UniformParam$Mat4Param
  extends UniformParam
{
  private final float[] mMatrix;
  
  public UniformParam$Mat4Param(String paramString, float[] paramArrayOfFloat)
  {
    super(paramString);
    this.mMatrix = paramArrayOfFloat;
  }
  
  public void setParams(int paramInt)
  {
    GLES20.glUniformMatrix4fv(this.handle, 1, false, this.mMatrix, 0);
  }
  
  public String toString()
  {
    return this.name + " = " + Arrays.toString(this.mMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.Mat4Param
 * JD-Core Version:    0.7.0.1
 */