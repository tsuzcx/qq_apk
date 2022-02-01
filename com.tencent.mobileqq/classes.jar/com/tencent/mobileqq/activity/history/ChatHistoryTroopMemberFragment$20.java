package com.tencent.mobileqq.activity.history;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ChatHistoryTroopMemberFragment$20
  implements View.OnTouchListener
{
  ChatHistoryTroopMemberFragment$20(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.y();
      paramView = this.a.o;
      this.a.a("Clk_find", paramView, "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.20
 * JD-Core Version:    0.7.0.1
 */