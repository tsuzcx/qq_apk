package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ReadInJoyAdBrandOptimizationView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ReadInJoyAdBrandOptimizationView$2(ReadInJoyAdBrandOptimizationView paramReadInJoyAdBrandOptimizationView, RelativeLayout.LayoutParams paramLayoutParams1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, RelativeLayout.LayoutParams paramLayoutParams2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    ReadInJoyAdBrandOptimizationView.a(this.i, this.a, f1, this.b, this.c, this.d, this.e, this.f, this.g);
    paramValueAnimator = this.i;
    ReadInJoyAdBrandOptimizationView.a(paramValueAnimator, this.h, f1, ReadInJoyAdBrandOptimizationView.d(paramValueAnimator));
    paramValueAnimator = this.i;
    ReadInJoyAdBrandOptimizationView.a(paramValueAnimator, ReadInJoyAdBrandOptimizationView.e(paramValueAnimator), f1, 0.2F, 1.7F, AIOUtils.b(34.0F, ReadInJoyAdBrandOptimizationView.b(this.i).getResources()));
    paramValueAnimator = this.i;
    ReadInJoyAdBrandOptimizationView.a(paramValueAnimator, ReadInJoyAdBrandOptimizationView.f(paramValueAnimator), f1, 0.2F, 2.0F, AIOUtils.b(34.0F, ReadInJoyAdBrandOptimizationView.b(this.i).getResources()));
    paramValueAnimator = this.i;
    ReadInJoyAdBrandOptimizationView.a(paramValueAnimator, ReadInJoyAdBrandOptimizationView.g(paramValueAnimator), f1, 0.2F, 2.0F, AIOUtils.b(34.0F, ReadInJoyAdBrandOptimizationView.b(this.i).getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBrandOptimizationView.2
 * JD-Core Version:    0.7.0.1
 */