package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicManager;
import java.util.List;

public class ConfessPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public ConfessPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.d);
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.o);
    b();
    d();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.h);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return SessionTypeUtil.c(paramSessionInfo.a);
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().e())
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.b);
      paramBaseChatPie = this.jdField_a_of_type_JavaUtilList;
      if (bool) {
        paramSessionInfo = AIOPanelUtiles.q;
      } else {
        paramSessionInfo = AIOPanelUtiles.m;
      }
      paramBaseChatPie.add(paramSessionInfo);
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.t);
      if (HotPicManager.a(paramQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.R);
      }
      paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
      if (bool) {
        paramQQAppInterface = AIOPanelUtiles.j;
      } else {
        paramQQAppInterface = AIOPanelUtiles.f;
      }
      paramSessionInfo.add(paramQQAppInterface);
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.a);
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilList;
    if (bool) {
      paramSessionInfo = AIOPanelUtiles.p;
    } else {
      paramSessionInfo = AIOPanelUtiles.l;
    }
    paramBaseChatPie.add(paramSessionInfo);
    c();
    if (HotPicManager.a(paramQQAppInterface).b()) {
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.N);
    }
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.ConfessPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */