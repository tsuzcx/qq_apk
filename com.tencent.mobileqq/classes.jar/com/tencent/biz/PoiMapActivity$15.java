package com.tencent.biz;

import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class PoiMapActivity$15
  implements ValueAnimation.AnimationUpdateListener<Integer>
{
  PoiMapActivity$15(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(ValueAnimation<Integer> paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramValueAnimation = (FrameLayout.LayoutParams)this.a.b.getLayoutParams();
    paramValueAnimation.bottomMargin = (this.a.o - paramInteger.intValue());
    this.a.b.setLayoutParams(paramValueAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.15
 * JD-Core Version:    0.7.0.1
 */