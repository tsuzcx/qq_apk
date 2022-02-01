package com.tencent.biz.qqstory.msgTabNode.view;

import android.os.Handler;

class MsgTabStoryNodeView$1
  implements Runnable
{
  int a = 0;
  
  MsgTabStoryNodeView$1(MsgTabStoryNodeView paramMsgTabStoryNodeView) {}
  
  public void run()
  {
    this.this$0.a(this.a);
    MsgTabStoryNodeView localMsgTabStoryNodeView = this.this$0;
    localMsgTabStoryNodeView.invalidate(localMsgTabStoryNodeView.i);
    if (!this.this$0.g)
    {
      int i = this.a;
      if (i < 110) {
        this.a = (i + 1);
      } else {
        this.a = -10;
      }
      this.this$0.h.postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView.1
 * JD-Core Version:    0.7.0.1
 */