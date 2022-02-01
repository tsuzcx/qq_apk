package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.bubble.ChatXListView;

class PAListUI$1
  implements Runnable
{
  PAListUI$1(PAListUI paramPAListUI) {}
  
  public void run()
  {
    if (PAListUI.a(this.this$0) != null)
    {
      PAListUI.b(this.this$0).springBackOverScrollHeaderView();
      this.this$0.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI.1
 * JD-Core Version:    0.7.0.1
 */