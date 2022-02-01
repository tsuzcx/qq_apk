package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class BizCrmExtTmpLoader
  extends BaseChatPanelBarLoader
{
  public BizCrmExtTmpLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.d);
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.o);
    b();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.h);
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.y);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.a == 1025;
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
    paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.i;
    } else {
      paramQQAppInterface = AIOPanelUtiles.e;
    }
    paramSessionInfo.add(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.BizCrmExtTmpLoader
 * JD-Core Version:    0.7.0.1
 */