package com.tencent.mm.modelappbrand.image;

import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.io.InputStream;

final class AppBrandSimpleImageLoader$a
  implements AppBrandSimpleImageLoader.e.a, Runnable
{
  private boolean g = false;
  
  private void c()
  {
    AppBrandSimpleImageLoader.a(this.a).a(new AppBrandSimpleImageLoader.a.1(this));
  }
  
  public void a()
  {
    if (this.g) {
      return;
    }
    try
    {
      InputStream localInputStream = AppBrandSimpleImageLoader.b(this.a).b(AppBrandSimpleImageLoader.p.a(this.b));
      if (localInputStream != null)
      {
        if (this.c != null) {
          this.c.apply(localInputStream);
        }
        c();
        return;
      }
      f.a.c(new AppBrandSimpleImageLoader.a.2(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      o.b("Luggage.AppBrandSimpleImageLoader", "loadIntoDiskCache diskCache.openRead failed, url=%s, e=%s", new Object[] { this.d, localThrowable });
      Function localFunction = this.c;
      if (localFunction != null) {
        localFunction.apply(null);
      }
      c();
    }
  }
  
  public void b()
  {
    this.g = true;
  }
  
  public void run()
  {
    if (AppBrandSimpleImageLoader.a(this.a).b(AppBrandSimpleImageLoader.p.a(this.b)))
    {
      AppBrandSimpleImageLoader.a(this.a).a(AppBrandSimpleImageLoader.p.a(this.b), this);
      return;
    }
    AppBrandSimpleImageLoader.a(this.a).c(AppBrandSimpleImageLoader.p.a(this.b));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.a
 * JD-Core Version:    0.7.0.1
 */