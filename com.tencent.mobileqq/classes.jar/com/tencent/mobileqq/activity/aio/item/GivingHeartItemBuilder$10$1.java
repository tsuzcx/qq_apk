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
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "onAnimationEnd " + paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "onAnimationRepeat " + paramAnimation);
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "onAnimationStart " + paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.10.1
 * JD-Core Version:    0.7.0.1
 */