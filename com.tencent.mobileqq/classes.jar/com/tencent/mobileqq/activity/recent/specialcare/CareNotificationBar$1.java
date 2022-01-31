package com.tencent.mobileqq.activity.recent.specialcare;

import ajih;
import android.view.View;

public class CareNotificationBar$1
  implements Runnable
{
  public CareNotificationBar$1(ajih paramajih) {}
  
  public void run()
  {
    if (ajih.a(this.this$0) == null) {}
    while (ajih.a(this.this$0).getVisibility() != 0) {
      return;
    }
    ajih.a(this.this$0).clearAnimation();
    ajih.a(this.this$0).startAnimation(ajih.a(this.this$0));
    ajih.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.1
 * JD-Core Version:    0.7.0.1
 */