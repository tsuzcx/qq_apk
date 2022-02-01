package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MsgTabStoryNodeListManager$15
  implements Runnable
{
  public void run()
  {
    if (this.this$0.q == 0)
    {
      if (MsgTabStoryNodeListManager.c(this.this$0)) {
        this.this$0.I = null;
      }
    }
    else {
      ThreadManager.getUIHandler().post(this.this$0.I);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.15
 * JD-Core Version:    0.7.0.1
 */