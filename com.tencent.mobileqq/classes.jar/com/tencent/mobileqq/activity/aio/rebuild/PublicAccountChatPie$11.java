package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class PublicAccountChatPie$11
  extends MessageObserver
{
  PublicAccountChatPie$11(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onGetTroopMsgFin(boolean paramBoolean, String[] paramArrayOfString)
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
  
  public void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.p();
      }
    }
  }
  
  public void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.p();
      }
    }
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.q = true;
    this.a.a(262144, null, paramLong);
  }
  
  public void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.g(65536);
  }
  
  public void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    this.a.g(196608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.11
 * JD-Core Version:    0.7.0.1
 */