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
    int i = paramSessionInfo.jdField_a_of_type_Int;
    if ((i == 1024) && (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.d);
    }
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.o);
    b();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.h);
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.A);
    if ((i == 1024) && (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(AIOPanelUtiles.z);
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.y);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return SessionTypeUtil.b(paramSessionInfo.jdField_a_of_type_Int);
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    int i = paramSessionInfo.jdField_a_of_type_Int;
    if ((i == 1024) && (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.a);
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (bool) {
      paramBaseChatPie = AIOPanelUtiles.p;
    } else {
      paramBaseChatPie = AIOPanelUtiles.l;
    }
    localList.add(paramBaseChatPie);
    c();
    localList = this.jdField_a_of_type_JavaUtilList;
    if (bool) {
      paramBaseChatPie = AIOPanelUtiles.i;
    } else {
      paramBaseChatPie = AIOPanelUtiles.e;
    }
    localList.add(paramBaseChatPie);
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.z);
    if ((i == 1024) && (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(AIOPanelUtiles.z);
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.w);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.ValidationTmpPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */