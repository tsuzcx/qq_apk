package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$Float4fParam
  extends UniformParam
{
  float w;
  float x;
  float y;
  float z;
  
  public UniformParam$Float4fParam(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramString);
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
  }
  
  public void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform4f(this.handle, this.x, this.y, this.z, this.w);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Float4fParam setParams: ");
    localStringBuilder.append(toString());
    GlUtil.checkGlError(localStringBuilder.toString());
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
    localStringBuilder.append(", ");
    localStringBuilder.append(this.w);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.Float4fParam
 * JD-Core Version:    0.7.0.1
 */