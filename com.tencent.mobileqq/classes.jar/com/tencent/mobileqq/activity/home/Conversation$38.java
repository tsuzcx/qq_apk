package com.tencent.mobileqq.activity.home;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.DiscMessageManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class Conversation$38
  extends MessageObserver
{
  Conversation$38(Conversation paramConversation) {}
  
  public void onBoxMsgUnreadNumRefresh()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, onBoxMsgUnreadNumRefresh");
    }
    this.a.a(0L);
  }
  
  public void onGetOfflineMsgFinished(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetOfflineMsgFinished|isSuc = " + paramBoolean);
    }
    if (this.a.c > 0L) {
      StartupTracker.a("Conversation_PullToRefresh_msgCB", SystemClock.uptimeMillis() - this.a.c);
    }
    if (this.a.jdField_a_of_type_Long != 1000L) {
      this.a.jdField_a_of_type_Long = 1000L;
    }
    this.a.b(new Conversation.38.1(this, paramBoolean));
    Object localObject = (PublicAccountHandler)this.a.a().getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (localObject != null)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
      long l = localSharedPreferences.getLong("fresh_weather_time", 0L);
      l = System.currentTimeMillis() - l;
      if ((l > 86400000L) || (l < 0L))
      {
        ((PublicAccountHandler)localObject).a(-1, 0, 0, 0);
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putLong("fresh_weather_time", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void onGetSubAccountMsg(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.data.errorType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + " errorMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if (paramSubAccountBackProtocData != null) {
      switch (paramSubAccountBackProtocData.jdField_a_of_type_Int)
      {
      default: 
        if ((paramSubAccountBackProtocData.jdField_c_of_type_Boolean) && (!paramSubAccountBackProtocData.d) && (paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString != null) && (paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString.length() > 4))
        {
          SubAccountControll.a(this.a.a(), paramString, 6);
          paramSubAccountBackProtocData.d = true;
        }
        break;
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      SubAccountControll.c(this.a.a(), paramString);
      continue;
      SubAccountControll.a(this.a.a(), 0);
    }
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.troop.revoked_troop_msg", 2, "onMsgRevokeNotice, isSuccess:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    MessageRecord localMessageRecord;
    TroopAioNavigateBarManager localTroopAioNavigateBarManager;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localMessageRecord = (MessageRecord)paramList.get(0);
      localTroopAioNavigateBarManager = (TroopAioNavigateBarManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      switch (localMessageRecord.istroop)
      {
      }
    }
    for (;;)
    {
      super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
      return;
      if (localTroopAioNavigateBarManager.a(localMessageRecord.frienduin) != -1)
      {
        ((TroopMessageManager)this.a.a().getMessageFacade().a(localMessageRecord.istroop)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
        this.a.a(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        continue;
        if (localTroopAioNavigateBarManager.a(localMessageRecord.frienduin + "&" + 3000) != -1)
        {
          ((DiscMessageManager)this.a.a().getMessageFacade().a(localMessageRecord.istroop)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
          this.a.a(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        }
      }
    }
  }
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() isSuccess=" + paramBoolean + " subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + " subAccount=" + paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString + " data.errorType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + " errorMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if ((!paramBoolean) || (paramSubAccountBackProtocData == null)) {
      return;
    }
    if (paramSubAccountBackProtocData.jdField_a_of_type_Int == 0)
    {
      SubAccountControll.a(this.a.a(), paramString, 1);
      paramSubAccountBackProtocData = (SubAccountControll)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
      if (paramSubAccountBackProtocData != null) {
        paramSubAccountBackProtocData.a(paramString, 1, true);
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      if (paramSubAccountBackProtocData.jdField_a_of_type_Int == 1)
      {
        SubAccountControll.c(this.a.a(), paramString);
        Conversation.k(this.a);
      }
    }
  }
  
  public void onPushUpdateLoginDevStatusNotify(int paramInt)
  {
    this.a.b(new Conversation.38.3(this, paramInt));
  }
  
  public void onRefleshRecentListFinished(boolean paramBoolean)
  {
    this.a.b(new Conversation.38.2(this, paramBoolean));
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    paramString = RecentDataListManager.a(paramString, -2147483648);
    this.a.a(2, 9, paramString);
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandler.MsgSendCostParams paramMsgSendCostParams)
  {
    onSendResult(paramBoolean, paramString, paramLong);
  }
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onSubAccountThirdQQUnreadMsgNum.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountThirdQQBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "onSubAccountThirdQQUnreadMsgNum.data=" + paramSubAccountThirdQQBackProtocData);
      }
    }
    if ((this.a.jdField_a_of_type_MqqAppAppRuntime == null) || (!this.a.jdField_a_of_type_MqqAppAppRuntime.isRunning())) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramSubAccountThirdQQBackProtocData == null) || (paramSubAccountThirdQQBackProtocData.d == 0));
      i = SubAccountControll.a(this.a.a());
    } while ((paramSubAccountThirdQQBackProtocData.d <= i) || (SubAccountControll.a(this.a.a(), this.a.a().getConversationFacade()) > 0));
    SubAccountControll.a(this.a.a(), paramSubAccountThirdQQBackProtocData.d);
    if (this.a.a().getProxyManager().a().b(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000) == null) {
      SubAccountControll.a(this.a.a(), AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7);
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      SubAccountControll.a(this.a.a(), AppConstants.SUBACCOUNT_ASSISTANT_UIN, 6);
    }
  }
  
  public void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.a(8, paramString, -2147483648);
  }
  
  public void onUpdateRecentList()
  {
    TroopAssistantManager.a().c(this.a.a());
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  public void onUpdateSecretfileStatus()
  {
    this.a.a(0L);
  }
  
  public void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    paramString1 = RecentDataListManager.a(paramString1, -2147483648);
    this.a.a(2, 9, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.38
 * JD-Core Version:    0.7.0.1
 */