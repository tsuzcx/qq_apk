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
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.d);
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.o);
    a();
    b();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.h);
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.y);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.a == 3000;
  }
  
  public void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    paramSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.a);
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilList;
    if (bool)
    {
      paramQQAppInterface = AIOPanelUtiles.p;
      paramBaseChatPie.add(paramQQAppInterface);
      a(paramSessionInfo);
      c();
      paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
      if (!bool) {
        break label114;
      }
    }
    label114:
    for (paramQQAppInterface = AIOPanelUtiles.i;; paramQQAppInterface = AIOPanelUtiles.e)
    {
      paramSessionInfo.add(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.w);
      return;
      paramQQAppInterface = AIOPanelUtiles.l;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DiscussionPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */