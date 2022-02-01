package com.tencent.mm.modelappbrand.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.luggage.wxa.qz.r;

public class c
  implements AppBrandSimpleImageLoader.h
{
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (i > 0) {
      if (j <= 0) {
        return null;
      }
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
    return null;
  }
  
  @NonNull
  public Bitmap a(@NonNull Bitmap paramBitmap)
  {
    if (paramBitmap.getWidth() > 0)
    {
      if (paramBitmap.getHeight() <= 0) {
        return paramBitmap;
      }
      Object localObject = RoundedBitmapDrawableFactory.create(r.d(), paramBitmap);
      ((RoundedBitmapDrawable)localObject).setCircular(true);
      localObject = a((Drawable)localObject);
      if (localObject != paramBitmap) {
        paramBitmap.recycle();
      }
      return localObject;
    }
    return paramBitmap;
  }
  
  @NonNull
  public String a()
  {
    return "RoundedBitmap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.c
 * JD-Core Version:    0.7.0.1
 */