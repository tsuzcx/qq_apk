package com.tencent.mobileqq.activity.aio.core;

import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DiscussChatPie$8
  extends MessageObserver
{
  DiscussChatPie$8(DiscussChatPie paramDiscussChatPie) {}
  
  private void a(String paramString)
  {
    try
    {
      if (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        DialogUtil.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, HardCodeUtil.a(2131703365), this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131719021), new DiscussChatPie.8.3(this, paramString), null).show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(this.a.b, 1, "ERR!! send_discussion_msg_failed_not_member:" + paramString.getMessage());
    }
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onMsgRevokeNotice:" + paramBoolean1);
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
          TroopAioNavigateBarManager localTroopAioNavigateBarManager = (TroopAioNavigateBarManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
          long l = localTroopAioNavigateBarManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
          if (((MessageRecord)localObject).uniseq == l)
          {
            localTroopAioNavigateBarManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, i);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(i);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("onMsgRevokeNotice==>");
            ((StringBuilder)localObject).append("navigateType:").append(i).append("|navigaeSeq:").append(l);
            QLog.d(this.a.b + ".troop.special_msg", 2, ((StringBuilder)localObject).toString());
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
    this.a.g(131072);
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandler.MsgSendCostParams paramMsgSendCostParams)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.q = true;
    this.a.a(262144, paramMsgSendCostParams, paramLong);
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
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
        MultiMsgManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1, paramLong2, false);
      }
    }
    if (paramInt1 == 3000) {
      switch (paramInt2)
      {
      default: 
        if (paramInt2 > 100) {
          QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString2, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        }
        break;
      }
    }
    for (;;)
    {
      this.a.g(196608);
      return;
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131719020, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      continue;
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131719022, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      continue;
      DialogUtil.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, HardCodeUtil.a(2131703364), this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691872), new DiscussChatPie.8.1(this, paramString1), null).show();
      continue;
      if (Looper.myLooper() != Looper.getMainLooper()) {
        this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new DiscussChatPie.8.2(this, paramString1));
      } else {
        a(paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.8
 * JD-Core Version:    0.7.0.1
 */