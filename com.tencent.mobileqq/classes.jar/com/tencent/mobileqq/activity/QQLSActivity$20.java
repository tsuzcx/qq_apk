package com.tencent.mobileqq.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import mqq.os.MqqHandler;

class QQLSActivity$20
  implements Animation.AnimationListener
{
  QQLSActivity$20(QQLSActivity paramQQLSActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.removeMessages(99);
    if (VersionUtils.g())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "do SmoothFinish");
      }
      QQLSActivity.g(this.a);
      this.a.finish();
      return;
    }
    this.a.a.postAtFrontOfQueue(new QQLSActivity.20.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.20
 * JD-Core Version:    0.7.0.1
 */