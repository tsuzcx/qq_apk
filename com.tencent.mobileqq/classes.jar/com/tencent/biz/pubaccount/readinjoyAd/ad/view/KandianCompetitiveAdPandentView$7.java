package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.URLImageView;

class KandianCompetitiveAdPandentView$7
  implements ValueAnimator.AnimatorUpdateListener
{
  KandianCompetitiveAdPandentView$7(KandianCompetitiveAdPandentView paramKandianCompetitiveAdPandentView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = KandianCompetitiveAdPandentView.g(this.a);
    f = f * 0.01F + 0.99F;
    paramValueAnimator.setScaleX(f);
    KandianCompetitiveAdPandentView.g(this.a).setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianCompetitiveAdPandentView.7
 * JD-Core Version:    0.7.0.1
 */