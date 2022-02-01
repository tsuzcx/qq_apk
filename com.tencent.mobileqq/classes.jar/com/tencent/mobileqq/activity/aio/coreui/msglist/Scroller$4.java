package com.tencent.mobileqq.activity.aio.coreui.msglist;

import com.tencent.mobileqq.bubble.ChatXListView;

class Scroller$4
  implements Runnable
{
  Scroller$4(Scroller paramScroller) {}
  
  public void run()
  {
    Scroller.a(this.this$0).setSelectionFromBottom(Scroller.a(this.this$0).getCount() - 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller.4
 * JD-Core Version:    0.7.0.1
 */