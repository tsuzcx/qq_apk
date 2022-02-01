package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class GameBuddyLoader
  extends BaseChatPanelBarLoader
{
  public GameBuddyLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie) {}
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.a == 10009;
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.a);
    paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.p;
    } else {
      paramQQAppInterface = AIOPanelUtiles.l;
    }
    paramSessionInfo.add(paramQQAppInterface);
    c();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.N);
    paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.i;
    } else {
      paramQQAppInterface = AIOPanelUtiles.e;
    }
    paramSessionInfo.add(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GameBuddyLoader
 * JD-Core Version:    0.7.0.1
 */