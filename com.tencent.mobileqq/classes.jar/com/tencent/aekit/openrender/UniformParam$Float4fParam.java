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
    GlUtil.checkGlError("Float4fParam setParams: " + toString());
  }
  
  public String toString()
  {
    return this.name + " = " + this.x + ", " + this.y + ", " + this.z + ", " + this.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.Float4fParam
 * JD-Core Version:    0.7.0.1
 */