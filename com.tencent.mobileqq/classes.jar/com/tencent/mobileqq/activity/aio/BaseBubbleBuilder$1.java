package com.tencent.mobileqq.activity.aio;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.coreui.msglist.bubblebghandlerexecutor.ChatLayoutBubbleBgExecutorImpl;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.BubbleBgHandler.BubbleBgHandlerListenerInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutListenerController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListener;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListener.ChatLayoutListenerInfo;

class BaseBubbleBuilder$1
  implements IChatLayoutListener
{
  BaseBubbleBuilder$1(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public void a(int paramInt, IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo)
  {
    if ((paramInt == ChatLayoutListenerController.c) && (paramChatLayoutListenerInfo != null))
    {
      boolean bool = paramChatLayoutListenerInfo instanceof BubbleBgHandler.BubbleBgHandlerListenerInfo;
      if ((bool) && (((BubbleBgHandler.BubbleBgHandlerListenerInfo)paramChatLayoutListenerInfo).a != ChatLayoutBubbleBgExecutorImpl.e))
      {
        this.a.a(paramChatLayoutListenerInfo.g, paramChatLayoutListenerInfo.f, paramChatLayoutListenerInfo.e, paramChatLayoutListenerInfo.g.i);
        this.a.a(paramChatLayoutListenerInfo.g, paramChatLayoutListenerInfo.e);
        this.a.b(paramChatLayoutListenerInfo.g, paramChatLayoutListenerInfo.e);
      }
      if ((bool) && (((BubbleBgHandler.BubbleBgHandlerListenerInfo)paramChatLayoutListenerInfo).a == ChatLayoutBubbleBgExecutorImpl.d))
      {
        BaseBubbleBuilder.1.1 local1 = new BaseBubbleBuilder.1.1(this, paramChatLayoutListenerInfo);
        if (paramChatLayoutListenerInfo.b == paramChatLayoutListenerInfo.c - 1)
        {
          if (BaseBubbleBuilder.a(this.a) != null) {
            BaseBubbleBuilder.h.removeCallbacks(BaseBubbleBuilder.a(this.a));
          }
          BaseBubbleBuilder.a(this.a, local1);
          BaseBubbleBuilder.h.postDelayed(BaseBubbleBuilder.a(this.a), 200L);
        }
        else
        {
          BaseBubbleBuilder.h.postDelayed(local1, 0L);
        }
      }
      if (paramChatLayoutListenerInfo.g.h != null)
      {
        paramChatLayoutListenerInfo.f.setBubbleView(paramChatLayoutListenerInfo.g.h);
        this.a.a(paramChatLayoutListenerInfo.g.h, paramChatLayoutListenerInfo.e);
        paramChatLayoutListenerInfo.g.h.setTag(2131430083, paramChatLayoutListenerInfo.g.i);
        paramChatLayoutListenerInfo.g.h.setTag(2131430627, paramChatLayoutListenerInfo.e);
      }
      this.a.a(paramChatLayoutListenerInfo.e, this.a.e, paramChatLayoutListenerInfo.f, paramChatLayoutListenerInfo.g, paramChatLayoutListenerInfo.b, paramChatLayoutListenerInfo.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.1
 * JD-Core Version:    0.7.0.1
 */