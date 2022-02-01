package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class ChatHistoryBubbleListFragment$1$1
  implements Runnable
{
  ChatHistoryBubbleListFragment$1$1(ChatHistoryBubbleListFragment.1 param1, List paramList) {}
  
  public void run()
  {
    ChatHistoryBubbleListAdapter localChatHistoryBubbleListAdapter = this.b.this$0.e;
    List localList = this.a;
    boolean bool;
    if (localList.size() < 20) {
      bool = true;
    } else {
      bool = false;
    }
    localChatHistoryBubbleListAdapter.a(localList, bool);
    if (this.b.this$0.e.getCount() > 0)
    {
      this.b.this$0.g = ((MessageRecord)this.b.this$0.e.getItem(0)).shmsgseq;
      this.b.this$0.h = ((MessageRecord)this.b.this$0.e.getItem(this.b.this$0.e.getCount() - 1)).shmsgseq;
    }
    this.b.this$0.a(this.b.this$0.e.s, this.b.this$0.e.t);
    this.b.this$0.e.notifyDataSetChanged();
    this.b.this$0.d.setSelection(this.b.this$0.e.getCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.1.1
 * JD-Core Version:    0.7.0.1
 */