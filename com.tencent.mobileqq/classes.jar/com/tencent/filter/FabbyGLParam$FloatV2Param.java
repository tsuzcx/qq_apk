package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.view.RendererUtils;

public class FabbyGLParam$FloatV2Param
  extends UniformParam
{
  private float[] value;
  
  public FabbyGLParam$FloatV2Param(String paramString, float[] paramArrayOfFloat)
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
    if (this.handle >= 0)
    {
      if ((this.value.length > 0) && (this.value.length % 2 == 0))
      {
        GLES20.glUniform2fv(this.handle, this.value.length / 2, this.value, 0);
        RendererUtils.checkGlError("FloatsParam setParams");
      }
    }
    else {
      return;
    }
    throw new IllegalStateException("floats length can't be divided by 4");
  }
  
  public String toString()
  {
    return this.name + "=" + this.value.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.FabbyGLParam.FloatV2Param
 * JD-Core Version:    0.7.0.1
 */