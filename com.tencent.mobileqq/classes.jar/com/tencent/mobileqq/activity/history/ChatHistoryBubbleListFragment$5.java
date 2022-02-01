package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatHistoryBubbleListFragment$5
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryBubbleListFragment$5(ChatHistoryBubbleListFragment paramChatHistoryBubbleListFragment, ChatMessage paramChatMessage, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ThreadManager.post(new ChatHistoryBubbleListFragment.5.1(this), 5, null, false);
      this.c.e.c(this.a);
      this.c.e.notifyDataSetChanged();
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.5
 * JD-Core Version:    0.7.0.1
 */