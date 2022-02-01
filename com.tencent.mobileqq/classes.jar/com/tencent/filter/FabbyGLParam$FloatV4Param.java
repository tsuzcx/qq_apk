package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.view.RendererUtils;

public class FabbyGLParam$FloatV4Param
  extends UniformParam
{
  private float[] value;
  
  public FabbyGLParam$FloatV4Param(String paramString, float[] paramArrayOfFloat)
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
      float[] arrayOfFloat = this.value;
      if ((arrayOfFloat.length > 0) && (arrayOfFloat.length % 4 == 0))
      {
        paramInt = this.handle;
        arrayOfFloat = this.value;
        GLES20.glUniform4fv(paramInt, arrayOfFloat.length / 4, arrayOfFloat, 0);
        RendererUtils.checkGlError("FloatsParam setParams");
        return;
      }
      throw new IllegalStateException("floats length can't be divided by 4");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append("=");
    localStringBuilder.append(this.value.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.FabbyGLParam.FloatV4Param
 * JD-Core Version:    0.7.0.1
 */