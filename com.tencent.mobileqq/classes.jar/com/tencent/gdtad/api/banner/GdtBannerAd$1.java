package com.tencent.gdtad.api.banner;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;

class GdtBannerAd$1
  implements View.OnTouchListener
{
  GdtBannerAd$1(GdtBannerAd paramGdtBannerAd, GdtBannerView paramGdtBannerView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.getAntiSpamForClick().onTouch(paramView, paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
    {
      GdtBannerAd.access$002(this.b, paramMotionEvent.getX());
      GdtBannerAd.access$102(this.b, paramMotionEvent.getY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd.1
 * JD-Core Version:    0.7.0.1
 */