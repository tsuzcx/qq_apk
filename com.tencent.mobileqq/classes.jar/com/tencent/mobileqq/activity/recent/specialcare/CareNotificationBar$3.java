package com.tencent.mobileqq.activity.recent.specialcare;

import ahek;
import android.view.View;

public class CareNotificationBar$3
  implements Runnable
{
  public CareNotificationBar$3(ahek paramahek) {}
  
  public void run()
  {
    if ((ahek.a(this.this$0) > 0) || (ahek.b(this.this$0) > 0))
    {
      ahek.a(this.this$0);
      this.this$0.c();
    }
    while (ahek.a(this.this$0) == null) {
      return;
    }
    ahek.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3
 * JD-Core Version:    0.7.0.1
 */