package com.tencent.mobileqq.activity.recent.specialcare;

import ahqy;
import android.view.View;

public class CareNotificationBar$3
  implements Runnable
{
  public CareNotificationBar$3(ahqy paramahqy) {}
  
  public void run()
  {
    if ((ahqy.a(this.this$0) > 0) || (ahqy.b(this.this$0) > 0))
    {
      ahqy.a(this.this$0);
      this.this$0.c();
    }
    while (ahqy.a(this.this$0) == null) {
      return;
    }
    ahqy.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3
 * JD-Core Version:    0.7.0.1
 */