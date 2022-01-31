package com.tencent.mobileqq.activity.recent.specialcare;

import ajmw;
import android.view.View;

public class CareNotificationBar$1
  implements Runnable
{
  public CareNotificationBar$1(ajmw paramajmw) {}
  
  public void run()
  {
    if (ajmw.a(this.this$0) == null) {}
    while (ajmw.a(this.this$0).getVisibility() != 0) {
      return;
    }
    ajmw.a(this.this$0).clearAnimation();
    ajmw.a(this.this$0).startAnimation(ajmw.a(this.this$0));
    ajmw.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.1
 * JD-Core Version:    0.7.0.1
 */