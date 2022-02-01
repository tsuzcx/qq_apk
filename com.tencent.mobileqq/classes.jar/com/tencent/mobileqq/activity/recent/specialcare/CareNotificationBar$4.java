package com.tencent.mobileqq.activity.recent.specialcare;

import alrd;
import android.view.View;

public class CareNotificationBar$4
  implements Runnable
{
  public CareNotificationBar$4(alrd paramalrd) {}
  
  public void run()
  {
    if ((alrd.a(this.this$0) > 0) || (alrd.b(this.this$0) > 0))
    {
      alrd.a(this.this$0);
      this.this$0.c();
    }
    while (alrd.a(this.this$0) == null) {
      return;
    }
    alrd.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.4
 * JD-Core Version:    0.7.0.1
 */