package com.tencent.mobileqq.activity.chathistory;

import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class ChatHistoryBubbleListForTroopFragment$2$1
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$2$1(ChatHistoryBubbleListForTroopFragment.2 param2, List paramList) {}
  
  public void run()
  {
    ChatHistoryBubbleListAdapter localChatHistoryBubbleListAdapter = this.b.this$0.c;
    List localList = this.a;
    boolean bool;
    if (localList.size() < 20) {
      bool = true;
    } else {
      bool = false;
    }
    localChatHistoryBubbleListAdapter.a(localList, bool);
    if (this.b.this$0.c.getCount() > 0)
    {
      this.b.this$0.e = ((MessageRecord)this.b.this$0.c.getItem(0)).shmsgseq;
      this.b.this$0.f = ((MessageRecord)this.b.this$0.c.getItem(this.b.this$0.c.getCount() - 1)).shmsgseq;
    }
    this.b.this$0.a(this.b.this$0.c.s, this.b.this$0.c.t);
    this.b.this$0.c.notifyDataSetChanged();
    this.b.this$0.b.setSelection(this.b.this$0.c.getCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.2.1
 * JD-Core Version:    0.7.0.1
 */