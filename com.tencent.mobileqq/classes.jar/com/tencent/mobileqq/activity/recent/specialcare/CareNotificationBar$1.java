package com.tencent.mobileqq.activity.recent.specialcare;

import ahqy;
import android.view.View;

public class CareNotificationBar$1
  implements Runnable
{
  public CareNotificationBar$1(ahqy paramahqy) {}
  
  public void run()
  {
    if (ahqy.a(this.this$0) == null) {}
    while (ahqy.a(this.this$0).getVisibility() != 0) {
      return;
    }
    ahqy.a(this.this$0).clearAnimation();
    ahqy.a(this.this$0).startAnimation(ahqy.a(this.this$0));
    ahqy.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.1
 * JD-Core Version:    0.7.0.1
 */