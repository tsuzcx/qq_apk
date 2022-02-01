package com.tencent.mobileqq.activity.recent.specialcare;

import android.view.View;

class CareNotificationBar$4
  implements Runnable
{
  CareNotificationBar$4(CareNotificationBar paramCareNotificationBar) {}
  
  public void run()
  {
    if ((CareNotificationBar.a(this.this$0) > 0) || (CareNotificationBar.b(this.this$0) > 0))
    {
      CareNotificationBar.a(this.this$0);
      this.this$0.c();
    }
    while (CareNotificationBar.a(this.this$0) == null) {
      return;
    }
    CareNotificationBar.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.4
 * JD-Core Version:    0.7.0.1
 */