package com.tencent.mm.modelappbrand.image;

import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.sj.g;

class AppBrandSimpleImageLoader$a$2
  implements g
{
  AppBrandSimpleImageLoader$a$2(AppBrandSimpleImageLoader.a parama) {}
  
  public String a()
  {
    return "AppBrandSimpleImageLoaderDownloadThread";
  }
  
  public void run()
  {
    AppBrandSimpleImageLoader.n.a(this.a.b, this.a.e, AppBrandSimpleImageLoader.b(this.a.a));
    if (this.a.c != null) {}
    try
    {
      this.a.c.apply(AppBrandSimpleImageLoader.b(this.a.a).b(AppBrandSimpleImageLoader.p.a(this.a.b)));
      label75:
      AppBrandSimpleImageLoader.a.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.a.2
 * JD-Core Version:    0.7.0.1
 */