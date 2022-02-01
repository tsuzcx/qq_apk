package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyAdBubbleNativeView$SingleBubble$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ReadInJoyAdBubbleNativeView$SingleBubble$1(ReadInJoyAdBubbleNativeView.SingleBubble paramSingleBubble, GradientDrawable paramGradientDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    int j = (int)((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).px2dp(i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView$SingleBubble.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView$SingleBubble.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(i);
    i = -j - 29;
    float f = i * 64 / 30.0F;
    j = (int)(255.0F - i * 127 / 30.0F);
    i = j;
    if (j > 255) {
      i = 255;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.argb((int)(102.0F - f), 0, 0, 0));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView$SingleBubble.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView$SingleBubble.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(i, 255, 255, 255));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView.SingleBubble.1
 * JD-Core Version:    0.7.0.1
 */