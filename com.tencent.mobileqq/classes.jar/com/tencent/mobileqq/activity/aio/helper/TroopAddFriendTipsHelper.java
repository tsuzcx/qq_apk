package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.haoliyou.orion.XorCipher;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class TroopAddFriendTipsHelper
  implements ILifeCycleHelper, Observer
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private TroopAddFriendTipsHelper.NewMsgRunnable jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAddFriendTipsHelper$NewMsgRunnable;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public TroopAddFriendTipsHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.a();
  }
  
  private void a(String paramString)
  {
    Object localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localObject != null)
    {
      localObject = ((TroopHandler)localObject).a();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).f(paramString);
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new TroopAddFriendTipsHelper.1(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin")), 2, null, true);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    for (;;)
    {
      return;
      String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (!str1.equalsIgnoreCase(paramMessageRecord.frienduin)) {
        continue;
      }
      TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
      String str2;
      if ((paramMessageRecord.msgtype == -1012) && (localTroopBatchAddFriendMgr.b("newMember"))) {
        str2 = paramMessageRecord.getExtInfoFromExtStr("troop_new_member_uin");
      }
      try
      {
        QLog.d("TroopAddFriendTipsHelper", 1, "checkTipsTriggerInAio update newMemberUin = " + XorCipher.a(str2) + " troop:" + str1);
        if ((localTroopBatchAddFriendMgr.a(str1)) && (!RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1))) {
          ThreadManager.getSubThreadHandler().postDelayed(new TroopAddFriendTipsHelper.2(this, str2, str1), 1000L);
        }
        if ((!paramMessageRecord.isSendFromLocal()) && (paramMessageRecord.mMessageInfo != null) && (!AnonymousChatHelper.a(paramMessageRecord)) && ((paramMessageRecord.mMessageInfo.a.b(24)) || (paramMessageRecord.mMessageInfo.a.b(22))) && (localTroopBatchAddFriendMgr.b("atMeOrReplyMe")) && (localTroopBatchAddFriendMgr.e(paramMessageRecord.senderuin))) {
          localTroopBatchAddFriendMgr.a(str1, paramMessageRecord.senderuin, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        }
        if (!paramMessageRecord.isSendFromLocal()) {
          continue;
        }
        if (paramMessageRecord.atInfoList != null)
        {
          i = 1;
          if (((i | paramMessageRecord instanceof MessageForReplyText) == 0) || (!localTroopBatchAddFriendMgr.b("atMeOrReplyMe"))) {
            continue;
          }
          localTroopBatchAddFriendMgr.a(paramMessageRecord, str1);
          return;
        }
      }
      catch (XorCipherException localXorCipherException)
      {
        for (;;)
        {
          localXorCipherException.printStackTrace();
          continue;
          int i = 0;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ThreadManager.postImmediately(new TroopAddFriendTipsHelper.3(this, paramBoolean, paramString), null, true);
  }
  
  public String getTag()
  {
    return "TroopAddFriendTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 8, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
      return;
      a();
      return;
      a(null);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAddFriendTipsHelper$NewMsgRunnable != null) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAddFriendTipsHelper$NewMsgRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() == null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof ChatMessage))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {
        break label30;
      }
    }
    label30:
    while ((!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramObservable.frienduin)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != paramObservable.istroop) || (MessageUtils.a(paramObservable.msgtype)) || (RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.senderuin))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAddFriendTipsHelper$NewMsgRunnable == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAddFriendTipsHelper$NewMsgRunnable = new TroopAddFriendTipsHelper.NewMsgRunnable(this, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAddFriendTipsHelper$NewMsgRunnable.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAddFriendTipsHelper$NewMsgRunnable);
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopAddFriendTipsHelper$NewMsgRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper
 * JD-Core Version:    0.7.0.1
 */