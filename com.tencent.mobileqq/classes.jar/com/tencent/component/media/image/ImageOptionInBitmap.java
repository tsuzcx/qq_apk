package com.tencent.component.media.image;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ImageOptionInBitmap
{
  private static boolean hasHONEYCOMB;
  private static Set<SoftReference<Bitmap>> mReusableBitmaps = new HashSet();
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    } else {
      bool = false;
    }
    hasHONEYCOMB = bool;
  }
  
  @TargetApi(11)
  public static void addInBitmapOptions(BitmapFactory.Options paramOptions)
  {
    if (!hasHONEYCOMB) {
      return;
    }
    paramOptions.inMutable = true;
    Bitmap localBitmap = getBitmapFromReusableSet(paramOptions);
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  public static void addReusableBitmaps(Bitmap paramBitmap)
  {
    if (!hasHONEYCOMB) {
      return;
    }
    synchronized (mReusableBitmaps)
    {
      mReusableBitmaps.add(new SoftReference(paramBitmap));
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  private static boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i >= 19)
    {
      if (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * getBytesPerPixel(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount()) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramBitmap.getWidth() == paramOptions.outWidth)
    {
      bool1 = bool2;
      if (paramBitmap.getHeight() == paramOptions.outHeight)
      {
        bool1 = bool2;
        if (paramOptions.inSampleSize == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void clear()
  {
    synchronized (mReusableBitmaps)
    {
      mReusableBitmaps.clear();
      return;
    }
  }
  
  private static Bitmap getBitmapFromReusableSet(BitmapFactory.Options paramOptions)
  {
    Object localObject1 = mReusableBitmaps;
    Object localObject2 = null;
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty())) {
      synchronized (mReusableBitmaps)
      {
        Iterator localIterator = mReusableBitmaps.iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (Bitmap)((SoftReference)localIterator.next()).get();
          if ((localObject1 != null) && (((Bitmap)localObject1).isMutable()))
          {
            if (canUseForInBitmap((Bitmap)localObject1, paramOptions))
            {
              localIterator.remove();
              break;
            }
          }
          else {
            localIterator.remove();
          }
        }
        return localObject1;
      }
    }
    return null;
  }
  
  private static int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      return 4;
    }
    if (paramConfig == Bitmap.Config.RGB_565) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ARGB_4444) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ALPHA_8) {}
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageOptionInBitmap
 * JD-Core Version:    0.7.0.1
 */