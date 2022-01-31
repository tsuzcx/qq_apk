package com.tencent.mobileqq.activity.history;

import aloz;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import bdbx;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.List;

class ChatHistoryTroopMemberFragment$3
  implements Runnable
{
  ChatHistoryTroopMemberFragment$3(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, aloz paramaloz) {}
  
  public void run()
  {
    Object localObject1 = bdbx.a().a(this.this$0.getActivity().app, this.this$0.c, this.this$0.w);
    bdbx.a().a(this.this$0.getActivity().app, this.this$0.c, this.this$0.w);
    if ((localObject1 != null) && (this.a != null))
    {
      this.this$0.a(this.this$0.w);
      synchronized (this.this$0)
      {
        localObject1 = this.this$0.a((TroopMemberInfo)localObject1, this.a);
        this.this$0.a.add(localObject1);
        this.this$0.b.sendEmptyMessage(9);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.3
 * JD-Core Version:    0.7.0.1
 */