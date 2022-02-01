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
    localPoiMapActivity.o = PoiMapActivity.e(localPoiMapActivity).getMeasuredHeight();
    localPoiMapActivity = this.a;
    PoiMapActivity.a(localPoiMapActivity, PoiMapActivity.a(localPoiMapActivity).getMeasuredHeight());
    if ((this.a.o > 0) && (PoiMapActivity.a(this.a) > 0))
    {
      localPoiMapActivity = this.a;
      localPoiMapActivity.a((localPoiMapActivity.o - PoiMapActivity.b(this.a)) / 2 + this.a.u, false);
      PoiMapActivity.f(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
      PoiMapActivity.b(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.14
 * JD-Core Version:    0.7.0.1
 */