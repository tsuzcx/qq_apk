package com.tencent.mobileqq.activity.recent.specialcare;

import ahra;
import android.view.View;

public class CareNotificationBar$1
  implements Runnable
{
  public CareNotificationBar$1(ahra paramahra) {}
  
  public void run()
  {
    if (ahra.a(this.this$0) == null) {}
    while (ahra.a(this.this$0).getVisibility() != 0) {
      return;
    }
    ahra.a(this.this$0).clearAnimation();
    ahra.a(this.this$0).startAnimation(ahra.a(this.this$0));
    ahra.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.1
 * JD-Core Version:    0.7.0.1
 */