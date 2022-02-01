package com.tencent.av.opengl.texture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.av.utils.UITools;
import com.tencent.util.Assert;

public class ResourceTexture
  extends UploadedTexture
{
  protected final Context o;
  protected final int p;
  
  public ResourceTexture(Context paramContext, int paramInt)
  {
    Assert.a(paramContext);
    this.o = paramContext;
    this.p = paramInt;
    b(false);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (!p()) {
      paramBitmap.recycle();
    }
  }
  
  protected Bitmap v()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inScaled = false;
    int i = UITools.a(this.o);
    localOptions.inSampleSize = 1;
    if (i <= 480) {
      localOptions.inSampleSize = 2;
    }
    Resources localResources = this.o.getResources();
    Bitmap localBitmap1 = null;
    try
    {
      Bitmap localBitmap2 = BitmapFactory.decodeResource(localResources, this.p, localOptions);
      return localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      for (;;)
      {
        try
        {
          localBitmap1 = BitmapFactory.decodeResource(localResources, i, localOptions);
          return localBitmap1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2) {}
        localOutOfMemoryError3 = localOutOfMemoryError3;
      }
    }
    localOptions.inSampleSize *= 2;
    if (localResources != null) {}
    try
    {
      localBitmap1 = BitmapFactory.decodeResource(localResources, this.p, localOptions);
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label99:
      break label99;
    }
    localOptions.inSampleSize *= 2;
    i = this.p;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.ResourceTexture
 * JD-Core Version:    0.7.0.1
 */