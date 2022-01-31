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
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private static int a(Bitmap.Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  private static Bitmap a(BitmapFactory.Options paramOptions)
  {
    if ((jdField_a_of_type_JavaUtilSet != null) && (!jdField_a_of_type_JavaUtilSet.isEmpty())) {
      for (;;)
      {
        synchronized (jdField_a_of_type_JavaUtilSet)
        {
          Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
          if (localIterator.hasNext())
          {
            Bitmap localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
            if ((localBitmap != null) && (localBitmap.isMutable()))
            {
              if (!a(localBitmap, paramOptions)) {
                continue;
              }
              localIterator.remove();
              paramOptions = localBitmap;
              return paramOptions;
            }
            localIterator.remove();
          }
        }
        paramOptions = null;
      }
    }
    return null;
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      if (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * a(paramBitmap.getConfig()) > paramBitmap.getAllocationByteCount()) {}
    }
    while ((paramBitmap.getWidth() == paramOptions.outWidth) && (paramBitmap.getHeight() == paramOptions.outHeight) && (paramOptions.inSampleSize == 1))
    {
      return true;
      return false;
    }
    return false;
  }
  
  @TargetApi(11)
  public static void addInBitmapOptions(BitmapFactory.Options paramOptions)
  {
    if (!jdField_a_of_type_Boolean) {}
    Bitmap localBitmap;
    do
    {
      return;
      paramOptions.inMutable = true;
      localBitmap = a(paramOptions);
    } while (localBitmap == null);
    paramOptions.inBitmap = localBitmap;
  }
  
  public static void addReusableBitmaps(Bitmap paramBitmap)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      jdField_a_of_type_JavaUtilSet.add(new SoftReference(paramBitmap));
      return;
    }
  }
  
  public static void clear()
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      jdField_a_of_type_JavaUtilSet.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageOptionInBitmap
 * JD-Core Version:    0.7.0.1
 */