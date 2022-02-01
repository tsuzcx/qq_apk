package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatHistoryTroopAllFragment$6
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryTroopAllFragment$6(ChatHistoryTroopAllFragment paramChatHistoryTroopAllFragment, ChatMessage paramChatMessage, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ThreadManager.post(new ChatHistoryTroopAllFragment.6.1(this), 5, null, false);
      this.c.u.c(this.a);
      if (this.c.u.getCount() == 0) {
        this.c.t.setEmptyView(ChatHistoryTroopAllFragment.a(this.c));
      }
      this.c.u.notifyDataSetChanged();
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.6
 * JD-Core Version:    0.7.0.1
 */