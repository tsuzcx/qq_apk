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
    PoiMapActivity localPoiMapActivity = this.a;
    localPoiMapActivity.N = PoiMapActivity.h(localPoiMapActivity).getMeasuredHeight();
    localPoiMapActivity = this.a;
    PoiMapActivity.a(localPoiMapActivity, PoiMapActivity.i(localPoiMapActivity).getMeasuredHeight());
    if ((this.a.N > 0) && (PoiMapActivity.j(this.a) > 0))
    {
      localPoiMapActivity = this.a;
      localPoiMapActivity.a((localPoiMapActivity.N - PoiMapActivity.k(this.a)) / 2 + this.a.T, false);
      PoiMapActivity.l(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
      PoiMapActivity.m(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.14
 * JD-Core Version:    0.7.0.1
 */