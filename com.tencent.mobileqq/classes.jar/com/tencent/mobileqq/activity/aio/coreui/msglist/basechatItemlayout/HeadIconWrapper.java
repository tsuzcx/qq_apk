package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;

public class HeadIconWrapper
  extends BaseChatItemLayoutViewWrapper<IHeadIconProcessor>
{
  public HeadIconWrapper(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    super(paramBaseChatItemLayout, paramContext);
  }
  
  protected IHeadIconProcessor d()
  {
    return new HeadIconProcessor(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper
 * JD-Core Version:    0.7.0.1
 */