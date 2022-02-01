package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;

public class BubbleViewWrapper
  extends BaseChatItemLayoutViewWrapper<IBubbleViewProcessor>
{
  public BubbleViewWrapper(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    super(paramBaseChatItemLayout, paramContext);
  }
  
  protected IBubbleViewProcessor d()
  {
    return new BubbleViewProcessor(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BubbleViewWrapper
 * JD-Core Version:    0.7.0.1
 */