package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;

public class TextureResParam
  extends UniformParam.TextureParam
{
  private int flipy = 0;
  private double ratio = 0.0D;
  private String textureResName = null;
  
  public TextureResParam(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1, 0, paramInt);
    this.textureResName = paramString2;
  }
  
  public TextureResParam(String paramString1, String paramString2, int paramInt, double paramDouble)
  {
    super(paramString1, 0, paramInt);
    this.textureResName = paramString2;
    this.ratio = paramDouble;
  }
  
  public TextureResParam(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramString1, 0, paramInt1);
    this.textureResName = paramString2;
    this.flipy = paramInt2;
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
    if (this.textureResName == null) {
      return;
    }
    GLES20.glActiveTexture(this.textureId);
    GlUtil.glGenTextures(1, this.texture, 0);
    GLES20.glBindTexture(3553, this.texture[0]);
    Object localObject1;
    if (this.textureResName.startsWith("assets://"))
    {
      localObject1 = BitmapUtils.decodeBitmap(FileUtils.getRealPath(this.textureResName), false);
    }
    else
    {
      localObject2 = BitmapUtils.decodeBitmap(this.textureResName, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = BitmapUtils.decodeBitmap(this.textureResName, true);
      }
    }
    Object localObject2 = null;
    if (localObject1 != null)
    {
      double d1 = this.ratio;
      if (d1 > 0.0D)
      {
        double d2;
        if (d1 < 1.0D)
        {
          d1 = ((Bitmap)localObject1).getHeight();
          d2 = this.ratio;
          Double.isNaN(d1);
          localObject2 = BitmapUtils.cropCenter((Bitmap)localObject1, (int)(d1 * d2), ((Bitmap)localObject1).getHeight(), false);
        }
        else
        {
          paramInt = ((Bitmap)localObject1).getWidth();
          d1 = ((Bitmap)localObject1).getWidth();
          d2 = this.ratio;
          Double.isNaN(d1);
          localObject2 = BitmapUtils.cropCenter((Bitmap)localObject1, paramInt, (int)(d1 / d2), false);
        }
        ((Bitmap)localObject1).recycle();
        localObject1 = null;
      }
      else
      {
        localObject2 = localObject1;
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lastBitmap is null ");
      localStringBuilder.append(this.textureResName);
      Log.e("Param", localStringBuilder.toString());
    }
    if (this.flipy == 1)
    {
      localObject2 = new Matrix();
      ((Matrix)localObject2).setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, ((Bitmap)localObject1).getHeight(), 0.0F, 0.0F, 1.0F });
      localObject2 = BitmapUtils.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject2);
      if (localObject2 != null)
      {
        ((Bitmap)localObject1).recycle();
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      GLUtils.texImage2D(3553, 0, (Bitmap)localObject1, 0);
      ((Bitmap)localObject1).recycle();
    }
    else
    {
      Log.e("Param", "bitmap is null");
    }
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.TextureResParam
 * JD-Core Version:    0.7.0.1
 */