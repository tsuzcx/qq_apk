package com.tencent.gdtad.views.image;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class GdtDrawableLoader$1
  implements URLDrawable.URLDrawableListener
{
  GdtDrawableLoader$1(GdtDrawableLoader paramGdtDrawableLoader) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    GdtDrawableLoader.a(this.a, paramURLDrawable);
    GdtLog.b("GdtDrawableLoader", "onLoadCanceled " + GdtDrawableLoader.a(this.a));
    GdtDrawableLoader.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    GdtDrawableLoader.a(this.a, paramURLDrawable);
    GdtLog.d("GdtDrawableLoader", "onLoadFialed " + GdtDrawableLoader.a(this.a), paramThrowable);
    if (!GdtDrawableLoader.a(this.a)) {
      GdtDrawableLoader.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    GdtDrawableLoader.a(this.a, paramURLDrawable);
    GdtLog.b("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + GdtDrawableLoader.a(this.a));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    GdtDrawableLoader.a(this.a, paramURLDrawable);
    GdtLog.b("GdtDrawableLoader", "onLoadSuccessed " + GdtDrawableLoader.a(this.a));
    GdtDrawableLoader.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtDrawableLoader.1
 * JD-Core Version:    0.7.0.1
 */