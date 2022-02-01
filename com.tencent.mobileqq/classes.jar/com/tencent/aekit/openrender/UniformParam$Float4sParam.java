package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$Float4sParam
  extends UniformParam
{
  float[] value;
  
  public UniformParam$Float4sParam(String paramString, float[] paramArrayOfFloat)
  {
    super(paramString);
    this.value = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      this.value[i] = paramArrayOfFloat[i];
      i += 1;
    }
  }
  
  public void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform4fv(this.handle, this.value.length / 4, this.value, 0);
    GlUtil.checkGlError("Float4sParam setParams");
  }
  
  public String toString()
  {
    return this.name + " = " + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.Float4sParam
 * JD-Core Version:    0.7.0.1
 */