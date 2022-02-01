package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class AVActivity$AnimationTrigger
  implements Runnable
{
  final int a = 1000;
  VideoAppInterface b = null;
  float c = -1.0F;
  float d = -1.0F;
  boolean e = false;
  
  public AVActivity$AnimationTrigger(VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramVideoAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AnimationTrigger", 2, "[childLock] requestShowOrHiddenChildLockUI");
    }
    this.b.a(new Object[] { Integer.valueOf(119), Integer.valueOf(3) });
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = false;
    this.b.a().removeCallbacks(this);
    this.b.a().postDelayed(this, 1000L);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AnimationTrigger", 2, "[childLock] requestShowTips");
    }
    this.b.a(new Object[] { Integer.valueOf(119), Integer.valueOf(2) });
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AnimationTrigger", 2, "[childLock] cancel animation");
    }
    this.e = false;
    this.b.a(new Object[] { Integer.valueOf(119), Integer.valueOf(0) });
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public void run()
  {
    if (this.b != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[childLock] trigger animation, isTriggeredAnimation[");
        localStringBuilder.append(this.e);
        localStringBuilder.append("]");
        QLog.w("AnimationTrigger", 1, localStringBuilder.toString());
      }
      this.e = true;
      this.b.a(new Object[] { Integer.valueOf(119), Integer.valueOf(1), Float.valueOf(this.c), Float.valueOf(this.d) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.AnimationTrigger
 * JD-Core Version:    0.7.0.1
 */