package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$Float1sParam
  extends UniformParam
{
  float[] value;
  
  public UniformParam$Float1sParam(String paramString, float[] paramArrayOfFloat)
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
    paramInt = this.handle;
    float[] arrayOfFloat = this.value;
    GLES20.glUniform1fv(paramInt, arrayOfFloat.length, arrayOfFloat, 0);
    GlUtil.checkGlError("FloatParam setParams");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(" = ");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.Float1sParam
 * JD-Core Version:    0.7.0.1
 */