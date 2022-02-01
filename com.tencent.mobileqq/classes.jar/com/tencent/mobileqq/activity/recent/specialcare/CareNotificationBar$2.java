package com.tencent.mobileqq.activity.recent.specialcare;

import almq;
import android.view.View;

public class CareNotificationBar$2
  implements Runnable
{
  public CareNotificationBar$2(almq paramalmq) {}
  
  public void run()
  {
    if (almq.a(this.this$0) == null) {}
    while (almq.a(this.this$0).getVisibility() != 0) {
      return;
    }
    almq.a(this.this$0).clearAnimation();
    almq.a(this.this$0).startAnimation(almq.a(this.this$0));
    almq.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2
 * JD-Core Version:    0.7.0.1
 */