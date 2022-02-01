package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class PublicAccountChatPie$12
  extends MessageObserver
{
  PublicAccountChatPie$12(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  protected void onGetTroopMsgFin(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (paramArrayOfString != null))
    {
      paramArrayOfString = paramArrayOfString[0];
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b.contains(paramArrayOfString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a.put(paramArrayOfString, Integer.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramArrayOfString, 1)));
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.d();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.e();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.c();
      }
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        paramString = this.a;
        paramString.m = true;
        paramString.a(262144, null, paramLong);
      }
    }
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.e(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel())
      {
        paramSendMessageHandler = this.a.b;
        paramString2 = new StringBuilder();
        paramString2.append("onUpdateSendMsgError uin ");
        paramString2.append(paramString1);
        paramString2.append(" type ");
        paramString2.append(paramInt1);
        paramString2.append(" uniseq ");
        paramString2.append(paramLong2);
        QLog.d(paramSendMessageHandler, 2, paramString2.toString());
      }
      this.a.e(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramSendMessageHandler = this.a.b;
      paramString2 = new StringBuilder();
      paramString2.append("onUpdateSendMsgError exception uin ");
      paramString2.append(paramString1);
      paramString2.append(" type ");
      paramString2.append(paramInt1);
      paramString2.append(" uniseq ");
      paramString2.append(paramLong2);
      QLog.d(paramSendMessageHandler, 2, paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.12
 * JD-Core Version:    0.7.0.1
 */