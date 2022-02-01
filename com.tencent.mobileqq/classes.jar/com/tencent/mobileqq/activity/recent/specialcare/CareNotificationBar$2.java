package com.tencent.mobileqq.activity.recent.specialcare;

import akou;
import android.view.View;

public class CareNotificationBar$2
  implements Runnable
{
  public CareNotificationBar$2(akou paramakou) {}
  
  public void run()
  {
    if (akou.a(this.this$0) == null) {}
    while (akou.a(this.this$0).getVisibility() != 0) {
      return;
    }
    akou.a(this.this$0).clearAnimation();
    akou.a(this.this$0).startAnimation(akou.a(this.this$0));
    akou.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2
 * JD-Core Version:    0.7.0.1
 */