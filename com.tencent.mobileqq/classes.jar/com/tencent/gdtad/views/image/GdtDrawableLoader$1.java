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
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadCanceled ");
    paramURLDrawable.append(GdtDrawableLoader.a(this.a));
    GdtLog.b("GdtDrawableLoader", paramURLDrawable.toString());
    GdtDrawableLoader.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    GdtDrawableLoader.a(this.a, paramURLDrawable);
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadFialed ");
    paramURLDrawable.append(GdtDrawableLoader.a(this.a));
    GdtLog.d("GdtDrawableLoader", paramURLDrawable.toString(), paramThrowable);
    if (!GdtDrawableLoader.b(this.a)) {
      GdtDrawableLoader.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    GdtDrawableLoader.a(this.a, paramURLDrawable);
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadProgressed ");
    paramURLDrawable.append(paramInt);
    paramURLDrawable.append(" ");
    paramURLDrawable.append(GdtDrawableLoader.a(this.a));
    GdtLog.b("GdtDrawableLoader", paramURLDrawable.toString());
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    GdtDrawableLoader.a(this.a, paramURLDrawable);
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadSuccessed ");
    paramURLDrawable.append(GdtDrawableLoader.a(this.a));
    GdtLog.b("GdtDrawableLoader", paramURLDrawable.toString());
    GdtDrawableLoader.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtDrawableLoader.1
 * JD-Core Version:    0.7.0.1
 */