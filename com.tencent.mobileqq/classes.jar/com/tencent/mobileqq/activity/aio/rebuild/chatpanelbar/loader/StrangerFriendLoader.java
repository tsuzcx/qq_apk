package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.HotPicManager;
import java.util.List;

public class StrangerFriendLoader
  extends BaseChatPanelBarLoader
{
  public StrangerFriendLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.o);
    b();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.A);
    d();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.a == 1003;
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilList;
    if (bool) {
      paramSessionInfo = AIOPanelUtiles.p;
    } else {
      paramSessionInfo = AIOPanelUtiles.l;
    }
    paramBaseChatPie.add(paramSessionInfo);
    c();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.z);
    if (HotPicManager.a(paramQQAppInterface).b()) {
      this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.N);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.StrangerFriendLoader
 * JD-Core Version:    0.7.0.1
 */