package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$IntParam
  extends UniformParam
{
  int value;
  
  public UniformParam$IntParam(String paramString, int paramInt)
  {
    super(paramString);
    this.value = paramInt;
  }
  
  public void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform1i(this.handle, this.value);
    GlUtil.checkGlError("IntParam setParams: " + toString());
  }
  
  public String toString()
  {
    return this.name + " = " + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.IntParam
 * JD-Core Version:    0.7.0.1
 */