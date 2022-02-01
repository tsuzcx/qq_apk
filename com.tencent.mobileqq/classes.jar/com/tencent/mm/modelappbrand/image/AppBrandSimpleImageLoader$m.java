package com.tencent.mm.modelappbrand.image;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import java.lang.ref.WeakReference;
import java.util.Map;

class AppBrandSimpleImageLoader$m
  implements AppBrandSimpleImageLoader.k
{
  private final WeakReference<ImageView> a;
  private final AppBrandSimpleImageLoader b;
  boolean c = false;
  private final String d;
  
  private AppBrandSimpleImageLoader$m(@NonNull ImageView paramImageView, @NonNull AppBrandSimpleImageLoader paramAppBrandSimpleImageLoader)
  {
    this.a = new WeakReference(paramImageView);
    this.b = paramAppBrandSimpleImageLoader;
    this.d = "ImageView";
  }
  
  private void e()
  {
    if (this.a.get() != null) {
      AppBrandSimpleImageLoader.e(this.b).remove(Integer.valueOf(((ImageView)this.a.get()).hashCode()));
    }
  }
  
  public String a()
  {
    return this.d;
  }
  
  @MainThread
  public void a(Bitmap paramBitmap)
  {
    e();
    ImageView localImageView = (ImageView)this.a.get();
    if (localImageView != null)
    {
      if (!t.a()) {
        o.g("Luggage.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
      }
      localImageView.setImageDrawable(new d(localImageView.getResources(), paramBitmap));
    }
    this.c = true;
  }
  
  public void b() {}
  
  public void c()
  {
    e();
  }
  
  ImageView d()
  {
    return (ImageView)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
 * JD-Core Version:    0.7.0.1
 */