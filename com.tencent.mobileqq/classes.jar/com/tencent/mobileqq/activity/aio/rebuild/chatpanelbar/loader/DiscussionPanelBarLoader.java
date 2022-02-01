package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class DiscussionPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public DiscussionPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.a.add(AIOPanelUtiles.e);
    this.a.add(AIOPanelUtiles.p);
    a();
    b();
    this.a.add(AIOPanelUtiles.i);
    this.a.add(AIOPanelUtiles.z);
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    paramSessionInfo = this.c.a().j();
    boolean bool = this.c.a().i();
    this.a.add(AIOPanelUtiles.b);
    paramBaseChatPie = this.a;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.q;
    } else {
      paramQQAppInterface = AIOPanelUtiles.m;
    }
    paramBaseChatPie.add(paramQQAppInterface);
    a(paramSessionInfo);
    c();
    paramSessionInfo = this.a;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.j;
    } else {
      paramQQAppInterface = AIOPanelUtiles.f;
    }
    paramSessionInfo.add(paramQQAppInterface);
    this.a.add(AIOPanelUtiles.x);
  }
  
  public boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.a == 3000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DiscussionPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */