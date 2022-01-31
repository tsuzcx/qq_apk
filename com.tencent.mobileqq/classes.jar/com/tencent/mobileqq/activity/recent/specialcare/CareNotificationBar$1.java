package com.tencent.mobileqq.activity.recent.specialcare;

import ahek;
import android.view.View;

public class CareNotificationBar$1
  implements Runnable
{
  public CareNotificationBar$1(ahek paramahek) {}
  
  public void run()
  {
    if (ahek.a(this.this$0) == null) {}
    while (ahek.a(this.this$0).getVisibility() != 0) {
      return;
    }
    ahek.a(this.this$0).clearAnimation();
    ahek.a(this.this$0).startAnimation(ahek.a(this.this$0));
    ahek.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.1
 * JD-Core Version:    0.7.0.1
 */