package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;

public class NickNameLayoutViewWrapper
  extends BaseChatItemLayoutViewWrapper<INickNameLayoutProcessor>
{
  public NickNameLayoutViewWrapper(BaseChatItemLayout paramBaseChatItemLayout, Context paramContext)
  {
    super(paramBaseChatItemLayout, paramContext);
  }
  
  public INickNameLayoutProcessor d()
  {
    return new NickNameChatItemLayoutProcessor(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutViewWrapper
 * JD-Core Version:    0.7.0.1
 */