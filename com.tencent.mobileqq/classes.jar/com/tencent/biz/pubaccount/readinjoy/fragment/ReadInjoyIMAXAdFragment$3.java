package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ClipLayout;

class ReadInjoyIMAXAdFragment$3
  implements ValueAnimator.AnimatorUpdateListener
{
  ReadInjoyIMAXAdFragment$3(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    ReadInjoyIMAXAdFragment.f(this.c).setAlpha(f1 * 0.5F + 0.5F);
    float f2;
    if (f1 <= 0.26F)
    {
      ReadInjoyIMAXAdFragment.f(this.c).a(ReadInjoyIMAXAdFragment.g(this.c), ReadInjoyIMAXAdFragment.h(this.c), ReadInjoyIMAXAdFragment.i(this.c), ReadInjoyIMAXAdFragment.j(this.c));
    }
    else if (f1 <= 0.866F)
    {
      paramValueAnimator = ReadInjoyIMAXAdFragment.f(this.c);
      f2 = ReadInjoyIMAXAdFragment.g(this.c);
      float f3 = f1 / 0.866F;
      paramValueAnimator.a((int)(f2 * (1.0F - f3)), (int)(ReadInjoyIMAXAdFragment.h(this.c) * (1.0F - f1)), (int)(ReadInjoyIMAXAdFragment.i(this.c) + (this.a - ReadInjoyIMAXAdFragment.i(this.c)) * f3), (int)(ReadInjoyIMAXAdFragment.j(this.c) + (this.b - ReadInjoyIMAXAdFragment.j(this.c)) * f1));
    }
    else
    {
      ReadInjoyIMAXAdFragment.f(this.c).a(0, (int)(ReadInjoyIMAXAdFragment.h(this.c) * (1.0F - f1)), this.a, (int)(ReadInjoyIMAXAdFragment.j(this.c) + (this.b - ReadInjoyIMAXAdFragment.j(this.c)) * f1));
    }
    if (f1 <= 0.22F)
    {
      ReadInjoyIMAXAdFragment.k(this.c).setVisibility(0);
      f1 = 0.97F - f1 / 0.22F * 0.4F;
      ReadInjoyIMAXAdFragment.k(this.c).setScaleX(f1);
      ReadInjoyIMAXAdFragment.k(this.c).setScaleY(f1);
      ReadInjoyIMAXAdFragment.k(this.c).setAlpha(f1);
      return;
    }
    if (f1 <= 0.44F)
    {
      f1 = (f1 - 0.22F) / 0.22F;
      f2 = f1 * 0.3F + 0.5700001F;
      ReadInjoyIMAXAdFragment.k(this.c).setScaleX(f2);
      ReadInjoyIMAXAdFragment.k(this.c).setScaleY(f2);
      ReadInjoyIMAXAdFragment.k(this.c).setAlpha(0.5700001F - 0.3F * f1);
      return;
    }
    if (f1 <= 0.68F)
    {
      f1 = (f1 - 0.52F) / 0.16F;
      ReadInjoyIMAXAdFragment.k(this.c).setAlpha(0.4F - f1 * 0.4F);
      return;
    }
    ReadInjoyIMAXAdFragment.k(this.c).setAlpha(0.0F);
    ReadInjoyIMAXAdFragment.k(this.c).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.3
 * JD-Core Version:    0.7.0.1
 */