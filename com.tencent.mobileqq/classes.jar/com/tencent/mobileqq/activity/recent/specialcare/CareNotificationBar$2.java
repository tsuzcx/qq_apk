package com.tencent.mobileqq.activity.recent.specialcare;

import alfl;
import android.view.View;

public class CareNotificationBar$2
  implements Runnable
{
  public CareNotificationBar$2(alfl paramalfl) {}
  
  public void run()
  {
    if (alfl.a(this.this$0) == null) {}
    while (alfl.a(this.this$0).getVisibility() != 0) {
      return;
    }
    alfl.a(this.this$0).clearAnimation();
    alfl.a(this.this$0).startAnimation(alfl.a(this.this$0));
    alfl.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2
 * JD-Core Version:    0.7.0.1
 */