package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class HotChatStrangerLoader
  extends BaseChatPanelBarLoader
{
  public HotChatStrangerLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.a.add(AIOPanelUtiles.p);
    b();
    this.a.add(AIOPanelUtiles.i);
    this.a.add(AIOPanelUtiles.B);
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.c.a().i();
    paramSessionInfo = this.a;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.q;
    } else {
      paramQQAppInterface = AIOPanelUtiles.m;
    }
    paramSessionInfo.add(paramQQAppInterface);
    c();
    paramSessionInfo = this.a;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.j;
    } else {
      paramQQAppInterface = AIOPanelUtiles.f;
    }
    paramSessionInfo.add(paramQQAppInterface);
    this.a.add(AIOPanelUtiles.A);
  }
  
  public boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.a == 1020;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.HotChatStrangerLoader
 * JD-Core Version:    0.7.0.1
 */