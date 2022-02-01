package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$Int1sParam
  extends UniformParam
{
  int[] value;
  
  public UniformParam$Int1sParam(String paramString, int[] paramArrayOfInt)
  {
    super(paramString);
    this.value = new int[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      this.value[i] = paramArrayOfInt[i];
      i += 1;
    }
  }
  
  public void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    paramInt = this.handle;
    int[] arrayOfInt = this.value;
    GLES20.glUniform1iv(paramInt, arrayOfInt.length, arrayOfInt, 0);
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
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.Int1sParam
 * JD-Core Version:    0.7.0.1
 */