package com.tencent.mobileqq.activity.recent.specialcare;

import ajmw;
import android.view.View;

public class CareNotificationBar$3
  implements Runnable
{
  public CareNotificationBar$3(ajmw paramajmw) {}
  
  public void run()
  {
    if ((ajmw.a(this.this$0) > 0) || (ajmw.b(this.this$0) > 0))
    {
      ajmw.a(this.this$0);
      this.this$0.c();
    }
    while (ajmw.a(this.this$0) == null) {
      return;
    }
    ajmw.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3
 * JD-Core Version:    0.7.0.1
 */