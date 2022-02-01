package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatHistoryTroopAllFragment$4$1
  implements Runnable
{
  ChatHistoryTroopAllFragment$4$1(ChatHistoryTroopAllFragment.4 param4, List paramList) {}
  
  public void run()
  {
    if (this.b.a != this.b.this$0.B)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadingContext changed, ignored result local=");
        ((StringBuilder)localObject).append(this.b.a);
        ((StringBuilder)localObject).append(", global=");
        ((StringBuilder)localObject).append(this.b.this$0.B);
        QLog.d("chatHistory.troop.msgList", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = this.b.this$0.u;
    List localList = this.a;
    int j = localList.size();
    int i = 1;
    int k = 0;
    boolean bool;
    if (j < 20) {
      bool = true;
    } else {
      bool = false;
    }
    int m = ((ChatHistoryBubbleListAdapter)localObject).b(localList, bool);
    if (this.b.this$0.u.getCount() > 0)
    {
      this.b.this$0.w = ((MessageRecord)this.b.this$0.u.getItem(0)).shmsgseq;
      this.b.this$0.x = ((MessageRecord)this.b.this$0.u.getItem(this.b.this$0.u.getCount() - 1)).shmsgseq;
    }
    if ((m == 0) || (this.b.this$0.t.getChildCount() <= 0)) {
      i = 0;
    }
    if (i != 0)
    {
      j = this.b.this$0.t.getFirstVisiblePosition();
      k = this.b.this$0.t.getChildAt(0).getTop();
    }
    else
    {
      j = 0;
    }
    this.b.this$0.A.setText(HardCodeUtil.a(2131899838));
    this.b.this$0.a(this.b.this$0.u.s, this.b.this$0.u.t);
    if (this.b.this$0.u.getCount() == 0) {
      this.b.this$0.t.setEmptyView(ChatHistoryTroopAllFragment.a(this.b.this$0));
    }
    this.b.this$0.u.notifyDataSetChanged();
    if (i != 0)
    {
      this.b.this$0.t.setSelectionFromTop(j + m, k);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update position pos=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", offset=");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(", top=");
        ((StringBuilder)localObject).append(k);
        QLog.d("chatHistory.troop.msgList", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.4.1
 * JD-Core Version:    0.7.0.1
 */