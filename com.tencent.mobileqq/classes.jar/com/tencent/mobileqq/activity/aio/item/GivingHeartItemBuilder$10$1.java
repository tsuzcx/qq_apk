package com.tencent.mobileqq.activity.aio.item;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class GivingHeartItemBuilder$10$1
  implements Animation.AnimationListener
{
  GivingHeartItemBuilder$10$1(GivingHeartItemBuilder.10 param10) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnimationEnd ");
      localStringBuilder.append(paramAnimation);
      QLog.d("GivingHeart", 2, localStringBuilder.toString());
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnimationRepeat ");
      localStringBuilder.append(paramAnimation);
      QLog.d("GivingHeart", 2, localStringBuilder.toString());
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAnimationStart ");
      localStringBuilder.append(paramAnimation);
      QLog.d("GivingHeart", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.10.1
 * JD-Core Version:    0.7.0.1
 */