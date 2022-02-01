package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListener.ChatLayoutListenerInfo;
import com.tencent.mobileqq.activity.aio.vasbubbleanimation.BubbleAnimation;
import com.tencent.mobileqq.data.ChatMessage;

class BaseBubbleBuilder$1$1
  implements Runnable
{
  BaseBubbleBuilder$1$1(BaseBubbleBuilder.1 param1, IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo) {}
  
  public void run()
  {
    if (BubbleAnimation.a().a(this.a)) {
      return;
    }
    if ((this.a.b == this.a.c - 1) && (this.a.e.mAnimFlag)) {
      this.b.a.a(this.a.g.h, this.a.e, this.a.g.i);
    }
    this.a.e.mAnimFlag = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.1.1
 * JD-Core Version:    0.7.0.1
 */