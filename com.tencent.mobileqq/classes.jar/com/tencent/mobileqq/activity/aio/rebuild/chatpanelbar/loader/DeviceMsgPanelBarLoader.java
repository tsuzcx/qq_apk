package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class DeviceMsgPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public DeviceMsgPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie) {}
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.a == 9501;
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof DeviceMsgChatPie))
    {
      paramSessionInfo = (DeviceMsgChatPie)paramBaseChatPie;
      if (paramSessionInfo.y()) {
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.a);
      }
      if (paramSessionInfo.x())
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
        paramBaseChatPie = this.jdField_a_of_type_JavaUtilList;
        if (bool) {
          paramQQAppInterface = AIOPanelUtiles.p;
        } else {
          paramQQAppInterface = AIOPanelUtiles.l;
        }
        paramBaseChatPie.add(paramQQAppInterface);
        c();
      }
      if (paramSessionInfo.u())
      {
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.E);
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.D);
      }
      if (paramSessionInfo.w()) {
        this.jdField_a_of_type_JavaUtilList.add(AIOPanelUtiles.J);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DeviceMsgPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */