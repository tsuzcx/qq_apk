package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.URLImageView;

class KandianCompetitiveAdPandentView$6
  implements ValueAnimator.AnimatorUpdateListener
{
  KandianCompetitiveAdPandentView$6(KandianCompetitiveAdPandentView paramKandianCompetitiveAdPandentView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = KandianCompetitiveAdPandentView.g(this.a);
    f = 1.1F - f * 0.11F;
    paramValueAnimator.setScaleX(f);
    KandianCompetitiveAdPandentView.g(this.a).setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianCompetitiveAdPandentView.6
 * JD-Core Version:    0.7.0.1
 */