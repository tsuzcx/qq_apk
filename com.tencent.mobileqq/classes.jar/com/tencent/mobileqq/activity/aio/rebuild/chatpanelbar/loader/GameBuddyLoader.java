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
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie) {}
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.a == 10009;
  }
  
  public void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.a);
    paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
    if (bool)
    {
      paramQQAppInterface = AIOPanelUtiles.p;
      paramSessionInfo.add(paramQQAppInterface);
      c();
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.N);
      paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
      if (!bool) {
        break label96;
      }
    }
    label96:
    for (paramQQAppInterface = AIOPanelUtiles.i;; paramQQAppInterface = AIOPanelUtiles.e)
    {
      paramSessionInfo.add(paramQQAppInterface);
      return;
      paramQQAppInterface = AIOPanelUtiles.l;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GameBuddyLoader
 * JD-Core Version:    0.7.0.1
 */