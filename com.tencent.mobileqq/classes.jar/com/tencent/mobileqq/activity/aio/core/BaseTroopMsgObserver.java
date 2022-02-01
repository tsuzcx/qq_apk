package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatRecentUserMgr;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class BaseTroopMsgObserver
  extends MessageObserver
{
  protected SessionInfo a;
  protected BaseChatPie a;
  protected QQAppInterface a;
  
  public BaseTroopMsgObserver(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTroopMsgObserver.troop.revoked_troop_msg", 2, "isSuccess:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = (MessageRecord)paramList.get(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b();
        if (i != -1)
        {
          TroopAioNavigateBarManager localTroopAioNavigateBarManager = (TroopAioNavigateBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
          long l = localTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (((MessageRecord)localObject).uniseq == l) {
            localTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(((MessageRecord)localObject).uniseq);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("onMsgRevokeNotice==>");
            ((StringBuilder)localObject).append("navigateType:").append(i).append("|navigaeSeq:").append(l);
            QLog.d("BaseTroopMsgObserver.troop.special_msg", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
  }
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g(131072);
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandler.MsgSendCostParams paramMsgSendCostParams)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.q = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(262144, paramMsgSendCostParams, paramLong);
  }
  
  public void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g(65536);
  }
  
  public void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseTroopMsgObserver", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseTroopMsgObserver", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    paramSendMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true);
    if ((paramSendMessageHandler.b(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSendMessageHandler.a(paramString1), paramString2, true);
      if ((paramInt2 == 112) || (paramInt2 == 113))
      {
        HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 6);
        HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g(196608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseTroopMsgObserver
 * JD-Core Version:    0.7.0.1
 */