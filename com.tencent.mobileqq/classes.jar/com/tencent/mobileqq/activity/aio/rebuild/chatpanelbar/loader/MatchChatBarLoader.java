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
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie) {}
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return (paramSessionInfo.a == 1044) || (paramSessionInfo.a == 1045);
  }
  
  public void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatBarLoader", 2, "[loadDefaultAioIcons]");
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.c);
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilList;
    if (bool)
    {
      paramSessionInfo = AIOPanelUtiles.r;
      paramBaseChatPie.add(paramSessionInfo);
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.u);
      if (HotPicManager.a(paramQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.N);
      }
      paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
      if (!bool) {
        break label138;
      }
    }
    label138:
    for (paramQQAppInterface = AIOPanelUtiles.k;; paramQQAppInterface = AIOPanelUtiles.g)
    {
      paramSessionInfo.add(paramQQAppInterface);
      return;
      paramSessionInfo = AIOPanelUtiles.n;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.MatchChatBarLoader
 * JD-Core Version:    0.7.0.1
 */