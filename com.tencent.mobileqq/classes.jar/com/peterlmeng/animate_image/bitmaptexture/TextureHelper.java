package com.peterlmeng.animate_image.bitmaptexture;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.peterlmeng.animate_image.support.log.LogUtils;

public class TextureHelper
{
  private static final String TAG = "TextureHelper";
  
  public static TextureHelper.TextureBean loadTexture(Bitmap paramBitmap)
  {
    TextureHelper.TextureBean localTextureBean = new TextureHelper.TextureBean();
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      LogUtils.e("TextureHelper", "Could not generate a new OpenGL texture object.");
      return localTextureBean;
    }
    if (paramBitmap == null)
    {
      LogUtils.e("TextureHelper", "Resource ID $resourceId could not be decoded.");
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      return localTextureBean;
    }
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10241, 9987);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 10497);
    GLES20.glTexParameteri(3553, 10243, 10497);
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    GLES20.glGenerateMipmap(3553);
    localTextureBean.setWidth(paramBitmap.getWidth());
    localTextureBean.setHeight(paramBitmap.getHeight());
    GLES20.glBindTexture(3553, 0);
    localTextureBean.setTextureId(arrayOfInt[0]);
    return localTextureBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.bitmaptexture.TextureHelper
 * JD-Core Version:    0.7.0.1
 */