package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$FloatParam
  extends UniformParam
{
  float value;
  
  public UniformParam$FloatParam(String paramString, float paramFloat)
  {
    super(paramString);
    this.value = paramFloat;
  }
  
  public void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform1f(this.handle, this.value);
    GlUtil.checkGlError("FloatParam setParams");
  }
  
  public String toString()
  {
    return this.name + " = " + this.value;
  }
  
  public float value()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.FloatParam
 * JD-Core Version:    0.7.0.1
 */