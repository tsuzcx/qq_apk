package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

class KandianCompetitiveAdPandentView$10
  implements ValueAnimator.AnimatorUpdateListener
{
  KandianCompetitiveAdPandentView$10(KandianCompetitiveAdPandentView paramKandianCompetitiveAdPandentView, GradientDrawable paramGradientDrawable, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.argb(i, 0, 202, 252));
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(this.jdField_a_of_type_Int);
    KandianCompetitiveAdPandentView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewKandianCompetitiveAdPandentView).setTextColor(Color.argb(i, 255, 255, 255));
    KandianCompetitiveAdPandentView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewKandianCompetitiveAdPandentView).setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianCompetitiveAdPandentView.10
 * JD-Core Version:    0.7.0.1
 */