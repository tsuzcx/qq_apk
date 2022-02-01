package com.tencent.mobileqq.activity.history;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.widget.PopupMenuDialog;

class ChatHistoryTroopMemberFragment$5
  implements View.OnTouchListener
{
  ChatHistoryTroopMemberFragment$5(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.5
 * JD-Core Version:    0.7.0.1
 */