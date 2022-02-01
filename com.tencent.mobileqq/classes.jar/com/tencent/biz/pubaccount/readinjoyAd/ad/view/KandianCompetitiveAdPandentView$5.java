package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.URLImageView;

class KandianCompetitiveAdPandentView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  KandianCompetitiveAdPandentView$5(KandianCompetitiveAdPandentView paramKandianCompetitiveAdPandentView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = KandianCompetitiveAdPandentView.a(this.a);
    float f2 = 1.1F * f1;
    paramValueAnimator.setScaleX(f2);
    KandianCompetitiveAdPandentView.a(this.a).setScaleY(f2);
    KandianCompetitiveAdPandentView.a(this.a).setAlpha(f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianCompetitiveAdPandentView.5
 * JD-Core Version:    0.7.0.1
 */