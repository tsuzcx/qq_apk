package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class DefaultPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public DefaultPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.o);
    b();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.h);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return false;
  }
  
  public void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
    if (bool)
    {
      paramQQAppInterface = AIOPanelUtiles.p;
      paramSessionInfo.add(paramQQAppInterface);
      c();
      paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
      if (!bool) {
        break label70;
      }
    }
    label70:
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DefaultPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */