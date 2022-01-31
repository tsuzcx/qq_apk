package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$Int2iParam
  extends UniformParam
{
  int x;
  int y;
  
  public UniformParam$Int2iParam(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  public void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform2i(this.handle, this.x, this.y);
    GlUtil.checkGlError("IntParam setParams");
  }
  
  public String toString()
  {
    return this.name + " = [ x = " + this.x + ", y = " + this.y + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.Int2iParam
 * JD-Core Version:    0.7.0.1
 */