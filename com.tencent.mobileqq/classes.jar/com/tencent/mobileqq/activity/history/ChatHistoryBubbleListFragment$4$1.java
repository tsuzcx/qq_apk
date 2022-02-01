package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatHistoryBubbleListFragment$4$1
  implements Runnable
{
  ChatHistoryBubbleListFragment$4$1(ChatHistoryBubbleListFragment.4 param4, List paramList) {}
  
  public void run()
  {
    if (this.b.a != this.b.this$0.l)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadingContext changed, ignored result local=");
        ((StringBuilder)localObject).append(this.b.a);
        ((StringBuilder)localObject).append(", global=");
        ((StringBuilder)localObject).append(this.b.this$0.l);
        QLog.d("chatHistory.troop.msgList", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = this.b.this$0.e;
    List localList = this.a;
    int k = localList.size();
    int j = 1;
    int i = 0;
    boolean bool;
    if (k < 20) {
      bool = true;
    } else {
      bool = false;
    }
    int i1 = ((ChatHistoryBubbleListAdapter)localObject).a(localList, bool);
    if (this.b.this$0.e.getCount() > 0)
    {
      this.b.this$0.g = ((MessageRecord)this.b.this$0.e.getItem(0)).shmsgseq;
      this.b.this$0.h = ((MessageRecord)this.b.this$0.e.getItem(this.b.this$0.e.getCount() - 1)).shmsgseq;
    }
    if ((i1 == 0) || (this.b.this$0.d.getChildCount() <= 0)) {
      j = 0;
    }
    if (j != 0)
    {
      int m = this.b.this$0.d.getFirstVisiblePosition();
      int n = this.b.this$0.d.getChildAt(0).getTop();
      k = m;
      i = n;
      if (this.b.this$0.d.getScrollY() < 0)
      {
        i = n - this.b.this$0.d.getScrollY();
        k = m;
      }
    }
    else
    {
      k = 0;
    }
    this.b.this$0.d.hideOverScrollHeaderView();
    this.b.this$0.a(this.b.this$0.e.s, this.b.this$0.e.t);
    this.b.this$0.e.notifyDataSetChanged();
    if (j != 0)
    {
      this.b.this$0.d.setSelectionFromTop(k + i1, i);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update position pos=");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(", offset=");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", top=");
        ((StringBuilder)localObject).append(i);
        QLog.d("chatHistory.troop.msgList", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.4.1
 * JD-Core Version:    0.7.0.1
 */