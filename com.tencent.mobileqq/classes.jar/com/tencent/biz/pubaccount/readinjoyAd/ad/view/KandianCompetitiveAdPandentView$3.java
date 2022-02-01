package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.image.URLImageView;

class KandianCompetitiveAdPandentView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  KandianCompetitiveAdPandentView$3(KandianCompetitiveAdPandentView paramKandianCompetitiveAdPandentView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    KandianCompetitiveAdPandentView.g(this.a).setScaleX(f);
    KandianCompetitiveAdPandentView.g(this.a).setScaleY(f);
    KandianCompetitiveAdPandentView.h(this.a).setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianCompetitiveAdPandentView.3
 * JD-Core Version:    0.7.0.1
 */