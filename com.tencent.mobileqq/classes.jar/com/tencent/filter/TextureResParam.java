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
    Object localObject2;
    label108:
    Object localObject3;
    if (this.textureResName.startsWith("assets://"))
    {
      localObject1 = BitmapUtils.decodeBitmap(FileUtils.getRealPath(this.textureResName), false);
      if (localObject1 == null) {
        break label326;
      }
      if (this.ratio <= 0.0D) {
        break label321;
      }
      if (this.ratio >= 1.0D) {
        break label297;
      }
      localObject2 = BitmapUtils.cropCenter((Bitmap)localObject1, (int)(((Bitmap)localObject1).getHeight() * this.ratio), ((Bitmap)localObject1).getHeight(), false);
      ((Bitmap)localObject1).recycle();
      localObject3 = null;
      localObject1 = localObject2;
      localObject2 = localObject3;
      label120:
      if (this.flipy != 1) {
        break label369;
      }
      localObject1 = new Matrix();
      ((Matrix)localObject1).setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, ((Bitmap)localObject2).getHeight(), 0.0F, 0.0F, 1.0F });
      localObject1 = BitmapUtils.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1);
      if (localObject1 != null) {
        break label365;
      }
      label208:
      if (localObject2 == null) {
        break label374;
      }
      GLUtils.texImage2D(3553, 0, (Bitmap)localObject2, 0);
      ((Bitmap)localObject2).recycle();
    }
    for (;;)
    {
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      return;
      localObject2 = BitmapUtils.decodeBitmap(this.textureResName, false);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = BitmapUtils.decodeBitmap(this.textureResName, true);
      break;
      label297:
      localObject2 = BitmapUtils.cropCenter((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), (int)(((Bitmap)localObject1).getWidth() / this.ratio), false);
      break label108;
      label321:
      localObject2 = localObject1;
      break label120;
      label326:
      Log.e("Param", "lastBitmap is null " + this.textureResName);
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label120;
      label365:
      ((Bitmap)localObject2).recycle();
      label369:
      localObject2 = localObject1;
      break label208;
      label374:
      Log.e("Param", "bitmap is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.TextureResParam
 * JD-Core Version:    0.7.0.1
 */