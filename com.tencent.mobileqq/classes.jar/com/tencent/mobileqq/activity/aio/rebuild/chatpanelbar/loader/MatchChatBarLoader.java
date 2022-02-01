package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class MatchChatBarLoader
  extends BaseChatPanelBarLoader
{
  public MatchChatBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie) {}
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatBarLoader", 2, "[loadDefaultAioIcons]");
    }
    boolean bool = this.c.a().i();
    this.a.clear();
    if (HotPicManager.a(paramQQAppInterface).j()) {
      this.a.add(AIOPanelUtiles.O);
    }
    paramSessionInfo = this.a;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.l;
    } else {
      paramQQAppInterface = AIOPanelUtiles.h;
    }
    paramSessionInfo.add(paramQQAppInterface);
    this.a.add(AIOPanelUtiles.x);
  }
  
  public boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return (paramSessionInfo.a == 1044) || (paramSessionInfo.a == 1045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.MatchChatBarLoader
 * JD-Core Version:    0.7.0.1
 */