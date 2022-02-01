package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.luggage.wxa.qz.r;
import java.lang.ref.WeakReference;

public class WxaDefaultIcon
{
  private static volatile WeakReference<Bitmap> a;
  
  public static Drawable get()
  {
    if (a != null)
    {
      localObject = (Bitmap)a.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      a = new WeakReference(BitmapFactory.decodeResource(r.d(), 2130842125));
    }
    Object localObject = RoundedBitmapDrawableFactory.create(r.d(), (Bitmap)a.get());
    ((RoundedBitmapDrawable)localObject).setCircular(true);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.WxaDefaultIcon
 * JD-Core Version:    0.7.0.1
 */