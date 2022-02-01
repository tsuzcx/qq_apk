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

public class TmpPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public TmpPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.o);
    b();
    d();
    this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.h);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return SessionTypeUtil.a(paramSessionInfo.a);
  }
  
  public void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    paramBaseChatPie = this.jdField_a_of_type_JavaUtilList;
    if (bool)
    {
      paramSessionInfo = AIOPanelUtiles.p;
      paramBaseChatPie.add(paramSessionInfo);
      c();
      if (HotPicManager.a(paramQQAppInterface).b()) {
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.N);
      }
      paramSessionInfo = this.jdField_a_of_type_JavaUtilList;
      if (!bool) {
        break label93;
      }
    }
    label93:
    for (paramQQAppInterface = AIOPanelUtiles.i;; paramQQAppInterface = AIOPanelUtiles.e)
    {
      paramSessionInfo.add(paramQQAppInterface);
      return;
      paramSessionInfo = AIOPanelUtiles.l;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.TmpPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */