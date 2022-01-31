package com.tencent.TMG.opengl.texture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import junit.framework.Assert;

public class ResourceTexture
  extends UploadedTexture
{
  protected final Context mContext;
  protected final int mResId;
  
  public ResourceTexture(Context paramContext, int paramInt)
  {
    Assert.assertNotNull(paramContext);
    this.mContext = paramContext;
    this.mResId = paramInt;
    setOpaque(false);
  }
  
  protected void onFreeBitmap(Bitmap paramBitmap)
  {
    if (!inFinalizer()) {
      paramBitmap.recycle();
    }
  }
  
  protected Bitmap onGetBitmap()
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
    ((BitmapFactory.Options)localObject).inScaled = false;
    int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
    if (i <= 480) {
      ((BitmapFactory.Options)localObject).inSampleSize = 2;
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap1 = BitmapFactory.decodeResource(this.mContext.getResources(), this.mResId, (BitmapFactory.Options)localObject);
        return localBitmap1;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        ((BitmapFactory.Options)localObject).inSampleSize *= 2;
        try
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), this.mResId, (BitmapFactory.Options)localObject);
          return localBitmap2;
        }
        catch (OutOfMemoryError localOutOfMemoryError3)
        {
          ((BitmapFactory.Options)localObject).inSampleSize *= 2;
          try
          {
            localObject = BitmapFactory.decodeResource(this.mContext.getResources(), this.mResId, (BitmapFactory.Options)localObject);
            return localObject;
          }
          catch (OutOfMemoryError localOutOfMemoryError1) {}
        }
      }
      if (i <= 720) {
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
      } else {
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.texture.ResourceTexture
 * JD-Core Version:    0.7.0.1
 */