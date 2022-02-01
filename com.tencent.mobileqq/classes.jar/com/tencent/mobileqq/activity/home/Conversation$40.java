package com.tencent.mobileqq.activity.home;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.DiscMessageManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
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

class Conversation$40
  extends MessageObserver
{
  Conversation$40(Conversation paramConversation) {}
  
  public void onBoxMsgUnreadNumRefresh()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, onBoxMsgUnreadNumRefresh");
    }
    this.a.a(0L);
  }
  
  protected void onGetOfflineMsgFinished(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetOfflineMsgFinished|isSuc = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.c > 0L) {
      StartupTracker.a("Conversation_PullToRefresh_msgCB", SystemClock.uptimeMillis() - this.a.c);
    }
    if (this.a.jdField_a_of_type_Long != 1000L) {
      this.a.jdField_a_of_type_Long = 1000L;
    }
    this.a.b(new Conversation.40.1(this, paramBoolean));
    Object localObject = (IPublicAccountHandler)this.a.a().getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (localObject != null)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
      long l = localSharedPreferences.getLong("fresh_weather_time", 0L);
      l = System.currentTimeMillis() - l;
      if ((l > 86400000L) || (l < 0L))
      {
        ((IPublicAccountHandler)localObject).sendLocRequest(-1, 0, 0, 0);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetSubAccountMsgNotify.isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("  subAccount=");
      localStringBuilder.append(paramString);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      if (paramSubAccountBackProtocData != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetSubAccountMsgNotify.data.errorType=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_a_of_type_Int);
        localStringBuilder.append(" errorMsg=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" mainAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString);
        localStringBuilder.append("  subAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(" isNeedStartGetMsg=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
        QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      }
    }
    if (paramSubAccountBackProtocData != null)
    {
      int i = paramSubAccountBackProtocData.jdField_a_of_type_Int;
      if (i != 1002)
      {
        if (i != 1008)
        {
          if ((paramSubAccountBackProtocData.jdField_c_of_type_Boolean) && (!paramSubAccountBackProtocData.d) && (paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString != null) && (paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString.length() > 4))
          {
            ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(this.a.a(), paramString, 6);
            paramSubAccountBackProtocData.d = true;
          }
        }
        else {
          ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).unbindAllRecentItem(this.a.a(), 0);
        }
      }
      else {
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).unbindRecentItem(this.a.a(), paramString);
      }
      this.a.a(0L);
    }
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMsgRevokeNotice, isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("Q.recent.troop.revoked_troop_msg", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean1) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = (MessageRecord)paramList.get(0);
      TroopAioNavigateBarManager localTroopAioNavigateBarManager = (TroopAioNavigateBarManager)this.a.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      int i = ((MessageRecord)localObject).istroop;
      if (i != 1)
      {
        if (i == 3000)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((MessageRecord)localObject).frienduin);
          localStringBuilder.append("&");
          localStringBuilder.append(3000);
          if (localTroopAioNavigateBarManager.a(localStringBuilder.toString()) != -1)
          {
            ((DiscMessageManager)this.a.a().getMessageFacade().a(((MessageRecord)localObject).istroop)).a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).shmsgseq);
            this.a.a(8, ((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
          }
        }
      }
      else if (localTroopAioNavigateBarManager.a(((MessageRecord)localObject).frienduin) != -1)
      {
        ((TroopMessageManager)this.a.a().getMessageFacade().a(((MessageRecord)localObject).istroop)).a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).shmsgseq);
        this.a.a(8, ((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
      }
    }
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
  }
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Conversation.onPushSubAccountMsgNotify() isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" subAccount=");
      localStringBuilder.append(paramString);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      if (paramSubAccountBackProtocData != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Conversation.onPushSubAccountMsgNotify() mainAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(" subAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(" data.errorType=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_a_of_type_Int);
        localStringBuilder.append(" errorMsg=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" isNeedStartGetMsg=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
        QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      }
    }
    if (paramBoolean)
    {
      if (paramSubAccountBackProtocData == null) {
        return;
      }
      if (paramSubAccountBackProtocData.jdField_a_of_type_Int == 0)
      {
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(this.a.a(), paramString, 1);
        paramSubAccountBackProtocData = (ISubAccountControlService)this.a.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ISubAccountControlService.class, "");
        if (paramSubAccountBackProtocData != null) {
          paramSubAccountBackProtocData.cancelHintDialog(paramString, 1, true);
        }
      }
      else if (paramSubAccountBackProtocData.jdField_a_of_type_Int == 1)
      {
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).unbindRecentItem(this.a.a(), paramString);
        Conversation.k(this.a);
      }
      this.a.a(0L);
    }
  }
  
  protected void onPushUpdateLoginDevStatusNotify(int paramInt)
  {
    this.a.b(new Conversation.40.3(this, paramInt));
  }
  
  protected void onRefleshRecentListFinished(boolean paramBoolean)
  {
    this.a.b(new Conversation.40.2(this, paramBoolean));
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    paramString = RecentDataListManager.a(paramString, -2147483648);
    this.a.a(2, 9, paramString);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams)
  {
    onSendResult(paramBoolean, paramString, paramLong);
  }
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSubAccountThirdQQUnreadMsgNum.isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("  subAccount=");
      localStringBuilder.append(paramString);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      if (paramSubAccountThirdQQBackProtocData != null)
      {
        paramString = new StringBuilder();
        paramString.append("onSubAccountThirdQQUnreadMsgNum.data=");
        paramString.append(paramSubAccountThirdQQBackProtocData);
        QLog.d("SUB_ACCOUNT", 2, paramString.toString());
      }
    }
    if (this.a.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      if (!this.a.jdField_a_of_type_MqqAppAppRuntime.isRunning()) {
        return;
      }
      if ((paramBoolean) && (paramSubAccountThirdQQBackProtocData != null) && (paramSubAccountThirdQQBackProtocData.d != 0))
      {
        int i = ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).getAllThirdQQMsgUnreadLastTime(this.a.a());
        if (paramSubAccountThirdQQBackProtocData.d > i)
        {
          paramString = (IConversationFacade)this.a.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IConversationFacade.class, "");
          if (((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).getAllSubAccountMsgUnreadNum(this.a.a(), paramString) <= 0)
          {
            ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).updateAllThirdQQMsgUnreadLastTime(this.a.a(), paramSubAccountThirdQQBackProtocData.d);
            if (this.a.a().getProxyManager().a().b(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000) == null) {
              ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(this.a.a(), AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7);
            } else {
              ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(this.a.a(), AppConstants.SUBACCOUNT_ASSISTANT_UIN, 6);
            }
            this.a.a(0L);
          }
        }
      }
    }
  }
  
  public void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.a(8, paramString, -2147483648);
  }
  
  protected void onUpdateRecentList()
  {
    TroopAssistantManager.a().c(this.a.a());
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void onUpdateSecretfileStatus()
  {
    this.a.a(0L);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    paramString1 = RecentDataListManager.a(paramString1, -2147483648);
    this.a.a(2, 9, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.40
 * JD-Core Version:    0.7.0.1
 */