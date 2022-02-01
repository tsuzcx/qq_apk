package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class ChatHistoryTroopAllFragment$2$1
  implements Runnable
{
  ChatHistoryTroopAllFragment$2$1(ChatHistoryTroopAllFragment.2 param2, List paramList) {}
  
  public void run()
  {
    ChatHistoryBubbleListAdapter localChatHistoryBubbleListAdapter = this.b.this$0.u;
    List localList = this.a;
    boolean bool;
    if (localList.size() < 20) {
      bool = true;
    } else {
      bool = false;
    }
    localChatHistoryBubbleListAdapter.a(localList, bool);
    if (this.b.this$0.u.getCount() > 0)
    {
      this.b.this$0.w = ((MessageRecord)this.b.this$0.u.getItem(0)).shmsgseq;
      this.b.this$0.x = ((MessageRecord)this.b.this$0.u.getItem(this.b.this$0.u.getCount() - 1)).shmsgseq;
    }
    this.b.this$0.a(this.b.this$0.u.s, this.b.this$0.u.t);
    this.b.this$0.u.notifyDataSetChanged();
    this.b.this$0.t.setSelection(this.b.this$0.u.getCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.2.1
 * JD-Core Version:    0.7.0.1
 */