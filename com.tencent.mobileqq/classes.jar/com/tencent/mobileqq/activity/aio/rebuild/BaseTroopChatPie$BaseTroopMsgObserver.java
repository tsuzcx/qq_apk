package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatRecentUserMgr;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class BaseTroopChatPie$BaseTroopMsgObserver
  extends MessageObserver
{
  public BaseTroopChatPie$BaseTroopMsgObserver(BaseTroopChatPie paramBaseTroopChatPie) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseTroopChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    paramSendMessageHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
    if ((paramSendMessageHandler.b(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      HotChatHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSendMessageHandler.a(paramString1), paramString2, true);
      if ((paramInt2 == 112) || (paramInt2 == 113))
      {
        HotChatRecentUserMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 6);
        HotChatRecentUserMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.a.b(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    a(paramBoolean, paramString, paramLong, null);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, MessageHandler.MsgSendCostParams paramMsgSendCostParams)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.q = true;
    this.a.a(262144, paramMsgSendCostParams, paramLong);
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie.troop.revoked_troop_msg", 2, "isSuccess:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = (MessageRecord)paramList.get(0);
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        int i = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b();
        if (i != -1)
        {
          TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          long l = localTroopInfoManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (((MessageRecord)localObject).uniseq == l) {
            localTroopInfoManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(((MessageRecord)localObject).uniseq);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("onMsgRevokeNotice==>");
            ((StringBuilder)localObject).append("navigateType:").append(i).append("|navigaeSeq:").append(l);
            QLog.d("Q.aio.BaseTroopChatPie.troop.special_msg", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    super.a(paramBoolean1, paramList, paramBoolean2);
  }
  
  public void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.b(131072);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.b(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.BaseTroopMsgObserver
 * JD-Core Version:    0.7.0.1
 */