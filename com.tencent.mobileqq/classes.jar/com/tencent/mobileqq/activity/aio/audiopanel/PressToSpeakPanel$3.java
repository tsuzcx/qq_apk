package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class PressToSpeakPanel$3
  implements Animation.AnimationListener
{
  PressToSpeakPanel$3(PressToSpeakPanel paramPressToSpeakPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      paramAnimation = new StringBuilder();
      paramAnimation.append("startRecord(),onAnimationEnd is called,time is:");
      paramAnimation.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, paramAnimation.toString());
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      paramAnimation = new StringBuilder();
      paramAnimation.append("startRecord(),onAnimationRepeat is called,time is:");
      paramAnimation.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, paramAnimation.toString());
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      paramAnimation = new StringBuilder();
      paramAnimation.append("startRecord(),onAnimationStart is called,time is:");
      paramAnimation.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, paramAnimation.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.3
 * JD-Core Version:    0.7.0.1
 */