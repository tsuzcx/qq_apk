package com.tencent.gdtad.views.image;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;
import java.net.URL;

class GdtGifImageView$ImageLoadListener
  implements GdtDrawableLoader.Listener
{
  GdtGifImageView$ImageLoadListener(GdtGifImageView paramGdtGifImageView) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    String str;
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {
      str = paramURLDrawable.getURL().toString();
    } else {
      str = null;
    }
    GdtLog.b("GdtImageView", String.format("onLoadSuccessful %s", new Object[] { str }));
    if ((!GdtGifImageView.a(this.a)) || (!GdtGifImageView.b(this.a))) {
      GdtGifImageView.a(this.a, paramURLDrawable, str);
    }
    if ((GdtGifImageView.a(this.a) != null) && (GdtGifImageView.a(this.a).get() != null) && (GdtGifImageView.c(this.a))) {
      ((GdtGifImageView.LoadListener)GdtGifImageView.a(this.a).get()).a(true);
    }
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    String str;
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {
      str = paramURLDrawable.getURL().toString();
    } else {
      str = null;
    }
    GdtLog.b("GdtImageView", String.format("onLoadFailed %s", new Object[] { str }));
    if ((!GdtGifImageView.a(this.a)) || (!GdtGifImageView.b(this.a))) {
      GdtGifImageView.a(this.a, paramURLDrawable, str);
    }
    if ((GdtGifImageView.a(this.a) != null) && (GdtGifImageView.a(this.a).get() != null)) {
      ((GdtGifImageView.LoadListener)GdtGifImageView.a(this.a).get()).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtGifImageView.ImageLoadListener
 * JD-Core Version:    0.7.0.1
 */