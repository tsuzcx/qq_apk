package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicManager;
import java.util.List;

public class ConfessPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public ConfessPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.a.add(AIOPanelUtiles.e);
    this.a.add(AIOPanelUtiles.p);
    b();
    d();
    this.a.add(AIOPanelUtiles.i);
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.c.a().i();
    if (this.c.a().k())
    {
      this.a.clear();
      this.a.add(AIOPanelUtiles.c);
      paramBaseChatPie = this.a;
      if (bool) {
        paramSessionInfo = AIOPanelUtiles.r;
      } else {
        paramSessionInfo = AIOPanelUtiles.n;
      }
      paramBaseChatPie.add(paramSessionInfo);
      this.a.add(AIOPanelUtiles.u);
      if (HotPicManager.a(paramQQAppInterface).j()) {
        this.a.add(AIOPanelUtiles.S);
      }
      paramSessionInfo = this.a;
      if (bool) {
        paramQQAppInterface = AIOPanelUtiles.k;
      } else {
        paramQQAppInterface = AIOPanelUtiles.g;
      }
      paramSessionInfo.add(paramQQAppInterface);
      return;
    }
    this.a.add(AIOPanelUtiles.b);
    paramBaseChatPie = this.a;
    if (bool) {
      paramSessionInfo = AIOPanelUtiles.q;
    } else {
      paramSessionInfo = AIOPanelUtiles.m;
    }
    paramBaseChatPie.add(paramSessionInfo);
    c();
    if (HotPicManager.a(paramQQAppInterface).j()) {
      this.a.add(AIOPanelUtiles.O);
    }
    paramSessionInfo = this.a;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.j;
    } else {
      paramQQAppInterface = AIOPanelUtiles.f;
    }
    paramSessionInfo.add(paramQQAppInterface);
  }
  
  public boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return SessionTypeUtil.c(paramSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.ConfessPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */