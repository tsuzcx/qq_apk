package com.tencent.avgame.gameroom.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AVGameControlUIImpl$4
  implements ValueAnimator.AnimatorUpdateListener
{
  AVGameControlUIImpl$4(AVGameControlUIImpl paramAVGameControlUIImpl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((AVGameControlUIImpl.e(this.a)) && (this.a.r != null)) {
      this.a.r.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.4
 * JD-Core Version:    0.7.0.1
 */