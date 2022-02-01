package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class PressToChangeVoicePanel$4
  implements Animation.AnimationListener
{
  PressToChangeVoicePanel$4(PressToChangeVoicePanel paramPressToChangeVoicePanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationEnd is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationRepeat is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationStart is called,time is:" + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel.4
 * JD-Core Version:    0.7.0.1
 */