package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$Float3fParam
  extends UniformParam
{
  float x;
  float y;
  float z;
  
  public UniformParam$Float3fParam(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString);
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform3f(this.handle, this.x, this.y, this.z);
    GlUtil.checkGlError("Float3fParam setParams");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(" = ");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.z);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.Float3fParam
 * JD-Core Version:    0.7.0.1
 */