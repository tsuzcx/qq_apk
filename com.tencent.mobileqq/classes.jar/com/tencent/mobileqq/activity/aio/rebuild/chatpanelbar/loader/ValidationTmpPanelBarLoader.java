package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qidian.QidianManager;
import java.util.List;

public class ValidationTmpPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public ValidationTmpPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    int i = paramSessionInfo.a;
    if ((i == 1024) && (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).m(paramSessionInfo.b))) {
      this.a.add(AIOPanelUtiles.e);
    }
    this.a.add(AIOPanelUtiles.p);
    b();
    this.a.add(AIOPanelUtiles.i);
    this.a.add(AIOPanelUtiles.B);
    if ((i == 1024) && (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).m(paramSessionInfo.b)))
    {
      this.a.remove(AIOPanelUtiles.A);
      this.a.add(AIOPanelUtiles.z);
    }
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.c.a().i();
    int i = paramSessionInfo.a;
    if ((i == 1024) && (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).m(paramSessionInfo.b))) {
      this.a.add(AIOPanelUtiles.b);
    }
    List localList = this.a;
    if (bool) {
      paramBaseChatPie = AIOPanelUtiles.q;
    } else {
      paramBaseChatPie = AIOPanelUtiles.m;
    }
    localList.add(paramBaseChatPie);
    c();
    localList = this.a;
    if (bool) {
      paramBaseChatPie = AIOPanelUtiles.j;
    } else {
      paramBaseChatPie = AIOPanelUtiles.f;
    }
    localList.add(paramBaseChatPie);
    this.a.add(AIOPanelUtiles.A);
    if ((i == 1024) && (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).m(paramSessionInfo.b)))
    {
      this.a.remove(AIOPanelUtiles.A);
      this.a.add(AIOPanelUtiles.x);
    }
  }
  
  public boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return SessionTypeUtil.b(paramSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.ValidationTmpPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */