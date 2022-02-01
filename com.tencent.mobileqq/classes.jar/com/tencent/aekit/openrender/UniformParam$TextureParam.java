package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$TextureParam
  extends UniformParam
{
  public int[] texture = { 0 };
  public int textureId;
  
  public UniformParam$TextureParam(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.textureId = paramInt2;
    this.texture[0] = paramInt1;
  }
  
  public void clear()
  {
    super.clear();
    this.texture[0] = 0;
  }
  
  public void setParams(int paramInt)
  {
    int i = 0;
    if ((this.handle < 0) || (this.texture[0] == 0)) {
      return;
    }
    GLES20.glActiveTexture(this.textureId);
    GLES20.glBindTexture(3553, this.texture[0]);
    paramInt = i;
    switch (this.textureId)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      GLES20.glUniform1i(this.handle, paramInt);
      GlUtil.checkGlError("TextureParam setParams");
      return;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
      continue;
      paramInt = 6;
      continue;
      paramInt = 7;
    }
  }
  
  public String toString()
  {
    return this.name + " = " + this.texture[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.TextureParam
 * JD-Core Version:    0.7.0.1
 */