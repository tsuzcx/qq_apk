package com.tencent.mobileqq.activity.shortvideo;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.RelativeLayout;

class ShortVideoPlayActivity$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ShortVideoPlayActivity$1(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((this.a.mOperatorBar.getVisibility() == 0) && (Math.abs(this.a.mOperatorBar.getAlpha() - f) >= 0.02F)) {
        this.a.mOperatorBar.setAlpha(f);
      }
      if ((this.a.mTitleBar.getVisibility() == 0) && (Math.abs(this.a.mOperatorBar.getAlpha() - f) >= 0.02F)) {
        this.a.mTitleBar.setAlpha(Float.valueOf(f).floatValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.1
 * JD-Core Version:    0.7.0.1
 */