package com.tencent.mobileqq.activity.recent.specialcare;

import ajih;
import android.view.View;

public class CareNotificationBar$3
  implements Runnable
{
  public CareNotificationBar$3(ajih paramajih) {}
  
  public void run()
  {
    if ((ajih.a(this.this$0) > 0) || (ajih.b(this.this$0) > 0))
    {
      ajih.a(this.this$0);
      this.this$0.c();
    }
    while (ajih.a(this.this$0) == null) {
      return;
    }
    ajih.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3
 * JD-Core Version:    0.7.0.1
 */