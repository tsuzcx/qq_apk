package com.tencent.aekit.openrender;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.aekit.openrender.util.GlUtil;

public class UniformParam$TextureBitmapParam
  extends UniformParam.TextureParam
{
  boolean needRecycle = false;
  Bitmap textureBitmap;
  boolean update;
  
  public UniformParam$TextureBitmapParam(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    super(paramString, 0, paramInt);
    this.needRecycle = paramBoolean;
    this.textureBitmap = paramBitmap;
    paramBoolean = bool;
    if (paramBitmap != null)
    {
      paramBoolean = bool;
      if (!paramBitmap.isRecycled()) {
        paramBoolean = true;
      }
    }
    this.update = paramBoolean;
  }
  
  public void clear()
  {
    GLES20.glActiveTexture(this.textureId);
    GlUtil.glDeleteTextures(1, this.texture, 0);
    super.clear();
    if ((this.needRecycle) && (this.textureBitmap != null))
    {
      this.textureBitmap.recycle();
      this.textureBitmap = null;
    }
  }
  
  public Bitmap getTextureBitmap()
  {
    return this.textureBitmap;
  }
  
  public void initialParams(int paramInt)
  {
    super.initialParams(paramInt);
    GLES20.glActiveTexture(this.textureId);
    GlUtil.glGenTextures(1, this.texture, 0);
  }
  
  public void setParams(int paramInt)
  {
    if (this.update)
    {
      GLES20.glActiveTexture(this.textureId);
      GLES20.glBindTexture(3553, this.texture[0]);
    }
    try
    {
      GLUtils.texImage2D(3553, 0, this.textureBitmap, 0);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      super.setParams(paramInt);
      this.update = false;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
  
  public void swapTextureBitmap(Bitmap paramBitmap)
  {
    if ((this.needRecycle) && (this.textureBitmap != null) && (!this.textureBitmap.isRecycled())) {
      this.textureBitmap.recycle();
    }
    this.textureBitmap = paramBitmap;
    if ((this.textureBitmap != null) && (!this.textureBitmap.isRecycled())) {}
    for (boolean bool = true;; bool = false)
    {
      this.update = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.openrender.UniformParam.TextureBitmapParam
 * JD-Core Version:    0.7.0.1
 */