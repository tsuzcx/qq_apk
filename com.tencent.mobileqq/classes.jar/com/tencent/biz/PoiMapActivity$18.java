package com.tencent.biz;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;

class PoiMapActivity$18
  implements Animation.AnimationListener
{
  PoiMapActivity$18(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (PoiMapActivity.s(this.a) != null) {
      PoiMapActivity.t(this.a).getMap().getUiSettings().setLogoPositionWithMargin(0, 0, 0, 0, 0);
    }
    paramAnimation = (FrameLayout.LayoutParams)this.a.c.getLayoutParams();
    paramAnimation.bottomMargin = (-this.a.O);
    this.a.c.setLayoutParams(paramAnimation);
    if ((this.a.M != null) && (this.a.M.getVisibility() != 0)) {
      this.a.M.setVisibility(0);
    }
    PoiMapActivity.u(this.a).clearAnimation();
    this.a.s = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.18
 * JD-Core Version:    0.7.0.1
 */