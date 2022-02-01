package com.tencent.gdtad.api.banner.letter;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.image.GdtDrawableLoader.Listener;
import com.tencent.image.URLDrawable;
import java.net.URL;

class GdtBannerImageView$1
  implements GdtDrawableLoader.Listener
{
  GdtBannerImageView$1(GdtBannerImageView paramGdtBannerImageView) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (paramURLDrawable = paramURLDrawable.getURL().toString();; paramURLDrawable = null)
    {
      GdtLog.b("GdtBannerImageView", String.format("onLoadSuccessful %s", new Object[] { paramURLDrawable }));
      return;
    }
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (paramURLDrawable = paramURLDrawable.getURL().toString();; paramURLDrawable = null)
    {
      GdtLog.b("GdtBannerImageView", String.format("onLoadFailed %s", new Object[] { paramURLDrawable }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerImageView.1
 * JD-Core Version:    0.7.0.1
 */