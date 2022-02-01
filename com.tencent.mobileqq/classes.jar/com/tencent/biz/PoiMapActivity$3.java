package com.tencent.biz;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.widget.QQMapView;

class PoiMapActivity$3
  implements Animation.AnimationListener
{
  PoiMapActivity$3(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, int paramInt, TranslateAnimation paramTranslateAnimation2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.e.u.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)PoiMapActivity.a(this.e).getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = PoiMapActivity.b(this.e).getLayoutParams();
    int i;
    int j;
    if (paramAnimation == this.a)
    {
      this.b.show();
      i = this.e.u.getHeight();
      j = this.c;
      localLayoutParams.height = (i + j);
      this.e.a(j / 2, true);
    }
    else if (paramAnimation == this.d)
    {
      i = this.e.u.getHeight();
      j = this.c;
      localLayoutParams.height = (i - j);
      this.e.a(-j / 2, true);
    }
    localLayoutParams1.height = -1;
    localLayoutParams2.height = -1;
    PoiMapActivity.c(this.e).setLayoutParams(localLayoutParams2);
    PoiMapActivity.d(this.e).setLayoutParams(localLayoutParams1);
    this.e.u.setLayoutParams(localLayoutParams);
    PoiMapActivity.e(this.e).setEnabled(true);
    if ((this.e.W) && (paramAnimation == this.d)) {
      this.e.f();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.3
 * JD-Core Version:    0.7.0.1
 */