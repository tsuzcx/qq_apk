package com.tencent.mobileqq.activity.recent.specialcare;

import alrd;
import android.view.View;

public class CareNotificationBar$2
  implements Runnable
{
  public CareNotificationBar$2(alrd paramalrd) {}
  
  public void run()
  {
    if (alrd.a(this.this$0) == null) {}
    while (alrd.a(this.this$0).getVisibility() != 0) {
      return;
    }
    alrd.a(this.this$0).clearAnimation();
    alrd.a(this.this$0).startAnimation(alrd.a(this.this$0));
    alrd.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2
 * JD-Core Version:    0.7.0.1
 */