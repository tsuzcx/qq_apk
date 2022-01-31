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
    this.this$0.invalidate(this.this$0.jdField_a_of_type_AndroidGraphicsRect);
    if (!this.this$0.b) {
      if (this.a >= 110) {
        break label70;
      }
    }
    label70:
    for (this.a += 1;; this.a = -10)
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 1000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView.1
 * JD-Core Version:    0.7.0.1
 */