package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

final class StickerBubbleAnimationHelper$1
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAllAnimationEnd ");
      localStringBuilder.append(paramAnimation);
      QLog.d("StickerBubbleHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnimationStart ");
      localStringBuilder.append(paramAnimation);
      QLog.d("StickerBubbleHelper", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper.1
 * JD-Core Version:    0.7.0.1
 */