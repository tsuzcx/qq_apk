package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.util.GlUtil;

public class TextureFloatsParam
  extends UniformParam.TextureParam
{
  private int[] value;
  
  public TextureFloatsParam(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    super(paramString, 0, paramInt);
    this.value = paramArrayOfInt;
  }
  
  public void clear()
  {
    GLES20.glActiveTexture(this.textureId);
    GlUtil.glDeleteTextures(1, this.texture, 0);
    super.clear();
  }
  
  public void initialParams(int paramInt)
  {
    super.initialParams(paramInt);
    if (this.value == null) {
      return;
    }
    GLES20.glActiveTexture(this.textureId);
    GlUtil.glGenTextures(1, this.texture, 0);
    GLSLRender.nativeTextCure(this.value, this.texture[0]);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.TextureFloatsParam
 * JD-Core Version:    0.7.0.1
 */