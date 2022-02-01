package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ReadInJoyAdBubbleView$SingleBubble$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ReadInJoyAdBubbleView$SingleBubble$1(ReadInJoyAdBubbleView.SingleBubble paramSingleBubble, GradientDrawable paramGradientDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    int j = (int)AIOUtils.a(i, this.b.c.getResources());
    this.b.a.setTranslationY(i);
    i = -j - 29;
    float f = i * 64 / 30.0F;
    j = (int)(255.0F - i * 127 / 30.0F);
    i = j;
    if (j > 255) {
      i = 255;
    }
    this.a.setColor(Color.argb((int)(102.0F - f), 0, 0, 0));
    this.b.a.setBackgroundDrawable(this.a);
    this.b.a.setTextColor(Color.argb(i, 255, 255, 255));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleView.SingleBubble.1
 * JD-Core Version:    0.7.0.1
 */