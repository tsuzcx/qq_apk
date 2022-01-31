package com.tencent.av.opengl.texture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.av.utils.UITools;
import junit.framework.Assert;

public class ResourceTexture
  extends UploadedTexture
{
  protected final Context a;
  protected final int k;
  
  public ResourceTexture(Context paramContext, int paramInt)
  {
    Assert.assertNotNull(paramContext);
    this.a = paramContext;
    this.k = paramInt;
    a(false);
  }
  
  protected Bitmap a()
  {
    Object localObject = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inScaled = false;
    int i = UITools.a(this.a);
    localOptions.inSampleSize = 1;
    if (i <= 480) {
      localOptions.inSampleSize = 2;
    }
    Resources localResources = this.a.getResources();
    try
    {
      Bitmap localBitmap2 = BitmapFactory.decodeResource(localResources, this.k, localOptions);
      localObject = localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      do
      {
        localOptions.inSampleSize *= 2;
      } while (localResources == null);
      try
      {
        localObject = BitmapFactory.decodeResource(localResources, this.k, localOptions);
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localOptions.inSampleSize *= 2;
        i = this.k;
        try
        {
          Bitmap localBitmap1 = BitmapFactory.decodeResource(localResources, i, localOptions);
          return localBitmap1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2) {}
      }
    }
    return localObject;
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (!d()) {
      paramBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.texture.ResourceTexture
 * JD-Core Version:    0.7.0.1
 */