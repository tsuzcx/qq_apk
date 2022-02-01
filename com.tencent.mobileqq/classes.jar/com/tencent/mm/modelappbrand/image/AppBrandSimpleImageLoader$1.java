package com.tencent.mm.modelappbrand.image;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;

class AppBrandSimpleImageLoader$1
  implements Runnable
{
  AppBrandSimpleImageLoader$1(AppBrandSimpleImageLoader paramAppBrandSimpleImageLoader, String paramString1, AppBrandSimpleImageLoader.k paramk, String paramString2, AppBrandSimpleImageLoader.n paramn) {}
  
  public void run()
  {
    Object localObject = this.e.findCachedInMemory(this.a);
    if (localObject != null)
    {
      this.b.a((Bitmap)localObject);
      o.e("Luggage.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", new Object[] { this.c, localObject });
      return;
    }
    localObject = AppBrandSimpleImageLoader.n.b(this.d);
    AppBrandSimpleImageLoader.c(this.e).put(this.b, localObject);
    AppBrandSimpleImageLoader.d(this.e).put(localObject, this.b);
    this.b.b();
    this.d.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.1
 * JD-Core Version:    0.7.0.1
 */