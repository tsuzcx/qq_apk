package com.tencent.mobileqq.activity.home;

import android.view.View;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;

class Conversation$62
  implements Runnable
{
  Conversation$62(Conversation paramConversation, int paramInt) {}
  
  public void run()
  {
    View localView = Conversation.a(this.this$0).getChildAt(this.a - Conversation.a(this.this$0).getFirstVisiblePosition());
    if (localView != null)
    {
      localView = localView.findViewById(2131376894);
      this.this$0.a.a(this.this$0.a(), localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.62
 * JD-Core Version:    0.7.0.1
 */