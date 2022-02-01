package com.tencent.biz;

import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class PoiMapActivity$17
  implements ValueAnimation.AnimationUpdateListener<Integer>
{
  PoiMapActivity$17(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(ValueAnimation<Integer> paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramValueAnimation = (FrameLayout.LayoutParams)PoiMapActivity.c(this.a).getLayoutParams();
    paramValueAnimation.bottomMargin = (this.a.q + this.a.t);
    PoiMapActivity.c(this.a).setLayoutParams(paramValueAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.17
 * JD-Core Version:    0.7.0.1
 */