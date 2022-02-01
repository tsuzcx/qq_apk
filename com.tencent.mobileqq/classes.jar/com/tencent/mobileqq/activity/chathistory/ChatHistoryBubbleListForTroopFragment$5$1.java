package com.tencent.mobileqq.activity.chathistory;

import android.view.View;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatHistoryBubbleListForTroopFragment$5$1
  implements Runnable
{
  ChatHistoryBubbleListForTroopFragment$5$1(ChatHistoryBubbleListForTroopFragment.5 param5, List paramList) {}
  
  public void run()
  {
    if (this.b.a != this.b.this$0.j)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadingContext changed, ignored result local=");
        ((StringBuilder)localObject).append(this.b.a);
        ((StringBuilder)localObject).append(", global=");
        ((StringBuilder)localObject).append(this.b.this$0.j);
        QLog.d("chatHistory.troop.msgList", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = this.b.this$0.c;
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
    if (this.b.this$0.c.getCount() > 0)
    {
      this.b.this$0.e = ((MessageRecord)this.b.this$0.c.getItem(0)).shmsgseq;
      this.b.this$0.f = ((MessageRecord)this.b.this$0.c.getItem(this.b.this$0.c.getCount() - 1)).shmsgseq;
    }
    if ((i1 == 0) || (this.b.this$0.b.getChildCount() <= 0)) {
      j = 0;
    }
    if (j != 0)
    {
      int m = this.b.this$0.b.getFirstVisiblePosition();
      int n = this.b.this$0.b.getChildAt(0).getTop();
      k = m;
      i = n;
      if (this.b.this$0.b.getScrollY() < 0)
      {
        i = n - this.b.this$0.b.getScrollY();
        k = m;
      }
    }
    else
    {
      k = 0;
    }
    this.b.this$0.b.hideOverScrollHeaderView();
    this.b.this$0.a(this.b.this$0.c.s, this.b.this$0.c.t);
    this.b.this$0.c.notifyDataSetChanged();
    if (j != 0)
    {
      this.b.this$0.b.setSelectionFromTop(k + i1, i);
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
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment.5.1
 * JD-Core Version:    0.7.0.1
 */