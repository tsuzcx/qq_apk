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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IntParam setParams: ");
    localStringBuilder.append(toString());
    GlUtil.checkGlError(localStringBuilder.toString());
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
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.IntParam
 * JD-Core Version:    0.7.0.1
 */