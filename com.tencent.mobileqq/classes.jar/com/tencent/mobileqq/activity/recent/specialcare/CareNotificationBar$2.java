package com.tencent.mobileqq.activity.recent.specialcare;

import android.view.View;

class CareNotificationBar$2
  implements Runnable
{
  CareNotificationBar$2(CareNotificationBar paramCareNotificationBar) {}
  
  public void run()
  {
    if (CareNotificationBar.a(this.this$0) == null) {
      return;
    }
    if (CareNotificationBar.a(this.this$0).getVisibility() == 0)
    {
      CareNotificationBar.a(this.this$0).clearAnimation();
      CareNotificationBar.a(this.this$0).startAnimation(CareNotificationBar.a(this.this$0));
      CareNotificationBar.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2
 * JD-Core Version:    0.7.0.1
 */