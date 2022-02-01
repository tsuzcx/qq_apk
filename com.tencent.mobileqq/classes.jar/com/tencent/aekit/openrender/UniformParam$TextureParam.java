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
    if (this.handle >= 0)
    {
      int[] arrayOfInt = this.texture;
      int i = 0;
      if (arrayOfInt[0] == 0) {
        return;
      }
      GLES20.glActiveTexture(this.textureId);
      GLES20.glBindTexture(3553, this.texture[0]);
      paramInt = i;
      switch (this.textureId)
      {
      default: 
        paramInt = i;
        break;
      case 33991: 
        paramInt = 7;
        break;
      case 33990: 
        paramInt = 6;
        break;
      case 33989: 
        paramInt = 5;
        break;
      case 33988: 
        paramInt = 4;
        break;
      case 33987: 
        paramInt = 3;
        break;
      case 33986: 
        paramInt = 2;
        break;
      case 33985: 
        paramInt = 1;
      }
      GLES20.glUniform1i(this.handle, paramInt);
      GlUtil.checkGlError("TextureParam setParams");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(" = ");
    localStringBuilder.append(this.texture[0]);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.TextureParam
 * JD-Core Version:    0.7.0.1
 */