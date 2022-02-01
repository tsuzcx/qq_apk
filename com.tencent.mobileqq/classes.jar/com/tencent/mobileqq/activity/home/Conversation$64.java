package com.tencent.mobileqq.activity.home;

import android.view.View;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;

class Conversation$64
  implements Runnable
{
  Conversation$64(Conversation paramConversation, int paramInt) {}
  
  public void run()
  {
    View localView = Conversation.i(this.this$0).getChildAt(this.a - Conversation.i(this.this$0).getFirstVisiblePosition());
    if (localView != null)
    {
      localView = localView.findViewById(2131444600);
      this.this$0.al.a(this.this$0.s(), localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.64
 * JD-Core Version:    0.7.0.1
 */