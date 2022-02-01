package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager.TimTipsShower;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.activity.aio.tips.TimTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;

public class AppGuideTipsMsgUpdateCallback
  implements AppGuideTipsManager.TimTipsShower, IMsgUpdateCallback
{
  protected TimTipsBar a;
  
  public boolean a(AIOContext paramAIOContext)
  {
    if (this.a == null)
    {
      this.a = new TimTipsBar(paramAIOContext.a(), paramAIOContext.b(), paramAIOContext.c());
      paramAIOContext.c().b(this.a);
    }
    return paramAIOContext.c().a(this.a, new Object[0]);
  }
  
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    AppGuideTipsManager localAppGuideTipsManager = (AppGuideTipsManager)paramAIOContext.a().getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER);
    if (!paramChatMessage.isSend())
    {
      localAppGuideTipsManager.a(paramChatMessage);
      return;
    }
    localAppGuideTipsManager.a(paramAIOContext, paramChatMessage, this);
  }
  
  public boolean d(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    ((AppGuideTipsManager)paramAIOContext.a().getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).a(paramAIOContext, paramChatMessage, this);
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.AppGuideTipsMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */