package com.tencent.mobileqq.activity.history;

import android.widget.TextView;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class ChatHistoryTroopAllFragment$3$1
  implements Runnable
{
  ChatHistoryTroopAllFragment$3$1(ChatHistoryTroopAllFragment.3 param3, List paramList) {}
  
  public void run()
  {
    ChatHistoryBubbleListAdapter localChatHistoryBubbleListAdapter = this.b.this$0.u;
    List localList = this.a;
    boolean bool;
    if (localList.size() < 21) {
      bool = true;
    } else {
      bool = false;
    }
    localChatHistoryBubbleListAdapter.b(localList, bool);
    if (this.b.this$0.u.getCount() > 0)
    {
      this.b.this$0.w = ((MessageRecord)this.b.this$0.u.getItem(0)).shmsgseq;
      this.b.this$0.x = ((MessageRecord)this.b.this$0.u.getItem(this.b.this$0.u.getCount() - 1)).shmsgseq;
    }
    this.b.this$0.u.s = true;
    this.b.this$0.A.setText(HardCodeUtil.a(2131899889));
    this.b.this$0.a(this.b.this$0.u.s, this.b.this$0.u.t);
    if (this.b.this$0.u.getCount() == 0) {
      this.b.this$0.t.setEmptyView(ChatHistoryTroopAllFragment.a(this.b.this$0));
    }
    this.b.this$0.u.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.3.1
 * JD-Core Version:    0.7.0.1
 */