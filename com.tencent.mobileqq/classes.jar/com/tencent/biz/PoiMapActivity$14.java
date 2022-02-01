package com.tencent.biz;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.QQMapView;

class PoiMapActivity$14
  implements ViewTreeObserver.OnPreDrawListener
{
  PoiMapActivity$14(PoiMapActivity paramPoiMapActivity) {}
  
  public boolean onPreDraw()
  {
    this.a.o = PoiMapActivity.e(this.a).getMeasuredHeight();
    PoiMapActivity.a(this.a, PoiMapActivity.a(this.a).getMeasuredHeight());
    if ((this.a.o > 0) && (PoiMapActivity.a(this.a) > 0))
    {
      this.a.a((this.a.o - PoiMapActivity.b(this.a)) / 2 + this.a.u, false);
      PoiMapActivity.f(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
      PoiMapActivity.b(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.14
 * JD-Core Version:    0.7.0.1
 */