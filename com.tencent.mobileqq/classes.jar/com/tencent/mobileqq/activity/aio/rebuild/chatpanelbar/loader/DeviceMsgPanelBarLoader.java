package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class DeviceMsgPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public DeviceMsgPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie) {}
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof DeviceMsgChatPie))
    {
      paramSessionInfo = (DeviceMsgChatPie)paramBaseChatPie;
      if (paramSessionInfo.bF()) {
        this.a.add(AIOPanelUtiles.b);
      }
      if (paramSessionInfo.bE())
      {
        boolean bool = this.c.a().i();
        paramBaseChatPie = this.a;
        if (bool) {
          paramQQAppInterface = AIOPanelUtiles.q;
        } else {
          paramQQAppInterface = AIOPanelUtiles.m;
        }
        paramBaseChatPie.add(paramQQAppInterface);
        c();
      }
      if (paramSessionInfo.bB())
      {
        this.a.add(AIOPanelUtiles.F);
        this.a.add(AIOPanelUtiles.E);
      }
      if (paramSessionInfo.bD()) {
        this.a.add(AIOPanelUtiles.K);
      }
    }
  }
  
  public boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.a == 9501;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DeviceMsgPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */