package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class DataLinePanelBarLoader
  extends BaseChatPanelBarLoader
{
  public DataLinePanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.a.add(AIOPanelUtiles.d);
    this.a.add(AIOPanelUtiles.o);
    a();
    b();
    this.a.add(AIOPanelUtiles.h);
    this.a.add(AIOPanelUtiles.J);
    this.a.add(AIOPanelUtiles.y);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return SessionTypeUtil.a(paramQQAppInterface, paramSessionInfo);
  }
  
  public void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.a.add(AIOPanelUtiles.d);
    this.a.add(AIOPanelUtiles.o);
    a();
    b();
    this.a.add(AIOPanelUtiles.h);
    this.a.add(AIOPanelUtiles.J);
    this.a.add(AIOPanelUtiles.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DataLinePanelBarLoader
 * JD-Core Version:    0.7.0.1
 */