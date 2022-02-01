package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$Float2fParam
  extends UniformParam
{
  public float x;
  public float y;
  
  public UniformParam$Float2fParam(String paramString, float paramFloat1, float paramFloat2)
  {
    super(paramString);
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform2f(this.handle, this.x, this.y);
    GlUtil.checkGlError("Float2fParam setParams");
  }
  
  public String toString()
  {
    return this.name + " = " + this.x + ", " + this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.Float2fParam
 * JD-Core Version:    0.7.0.1
 */