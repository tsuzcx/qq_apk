package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper;
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import com.tencent.mobileqq.utils.ViewUtils;

public class AioApolloHeadIconController
  extends BaseDefaultHeadIconController
{
  private String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend()) {
      return paramChatMessage.selfuin;
    }
    return paramChatMessage.senderuin;
  }
  
  private void c(Object paramObject)
  {
    a(paramObject, 0, AIOUtils.b(5.0F, this.c.getResources()), ViewUtils.dip2px(45.0F), ViewUtils.dip2px(60.0F), false);
  }
  
  protected void b()
  {
    String str = a(this.a);
    c(Util.b(this.b, str));
  }
  
  public boolean h()
  {
    return AioApolloHelper.a(this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.AioApolloHeadIconController
 * JD-Core Version:    0.7.0.1
 */