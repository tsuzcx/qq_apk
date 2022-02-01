package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.qroute.QRoute;
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("BaseTroopMsgObserver.troop.revoked_troop_msg", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean1) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = (MessageRecord)paramList.get(0);
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
            ((StringBuilder)localObject).append("navigateType:");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append("|navigaeSeq:");
            ((StringBuilder)localObject).append(l);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(131072);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        paramString.m = true;
        paramString.a(262144, paramMsgSendCostParams, paramLong);
      }
    }
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel())
      {
        paramSendMessageHandler = new StringBuilder();
        paramSendMessageHandler.append("onUpdateSendMsgError uin ");
        paramSendMessageHandler.append(paramString1);
        paramSendMessageHandler.append(" type ");
        paramSendMessageHandler.append(paramInt1);
        paramSendMessageHandler.append(" uniseq ");
        paramSendMessageHandler.append(paramLong2);
        QLog.d("BaseTroopMsgObserver", 2, paramSendMessageHandler.toString());
      }
      paramSendMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true);
      if ((paramSendMessageHandler.b(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSendMessageHandler.a(paramString1), paramString2, true);
        if ((paramInt2 == 112) || (paramInt2 == 113))
        {
          paramSendMessageHandler = (IHotChatApi)QRoute.api(IHotChatApi.class);
          paramSendMessageHandler.delHotChatRecentUserNotNotifyUi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 6);
          paramSendMessageHandler.invokeRecentUserChangedToConversation(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramSendMessageHandler = new StringBuilder();
      paramSendMessageHandler.append("onUpdateSendMsgError exception uin ");
      paramSendMessageHandler.append(paramString1);
      paramSendMessageHandler.append(" type ");
      paramSendMessageHandler.append(paramInt1);
      paramSendMessageHandler.append(" uniseq ");
      paramSendMessageHandler.append(paramLong2);
      QLog.d("BaseTroopMsgObserver", 2, paramSendMessageHandler.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseTroopMsgObserver
 * JD-Core Version:    0.7.0.1
 */