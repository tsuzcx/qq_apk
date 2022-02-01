package com.tencent.mm.modelappbrand.image;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.gl.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Set;

public final class AppBrandSimpleImageLoader$d
  implements AppBrandSimpleImageLoader.l
{
  private final b<String, Reference<Bitmap>> a = new AppBrandSimpleImageLoader.d.1(this, b());
  
  private static int b()
  {
    return 31457280;
  }
  
  public Bitmap a(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    synchronized (this.a)
    {
      Object localObject = (Reference)this.a.b(paramString);
      if (localObject == null) {
        return null;
      }
      localObject = (Bitmap)((Reference)localObject).get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        return localObject;
      }
      this.a.a(paramString);
      return null;
    }
  }
  
  public void a()
  {
    o.e("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
    synchronized (this.a)
    {
      this.a.b();
      return;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    o.e("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", new Object[] { paramBitmap });
    if (paramBitmap != null) {
      paramBitmap.isRecycled();
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (!af.c(paramString))
    {
      if (paramBitmap == null) {
        return;
      }
      o.e("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", new Object[] { paramString, paramBitmap });
    }
    try
    {
      synchronized (this.a)
      {
        this.a.a(paramString, new SoftReference(paramBitmap));
        return;
      }
      return;
    }
    catch (IllegalStateException paramString) {}
  }
  
  public void b(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    synchronized (this.a)
    {
      Iterator localIterator = this.a.a().iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).contains(paramString)) {
          localIterator.remove();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void c(String paramString)
  {
    synchronized (this.a)
    {
      this.a.a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.d
 * JD-Core Version:    0.7.0.1
 */