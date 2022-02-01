package com.tencent.mobileqq.activity.home;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class Conversation$48
  extends SubAccountBindObserver
{
  Conversation$48(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Conversation.onGetBindSubAccount() return, isSucc=");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" mSubUin=");
      if (paramSubAccountBackProtocData == null) {
        localObject1 = null;
      } else {
        localObject1 = paramSubAccountBackProtocData.c;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
    }
    if ((paramBoolean) && (paramSubAccountBackProtocData != null))
    {
      if (paramSubAccountBackProtocData.jdField_a_of_type_Int == 1008)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
        }
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).unbindAllRecentItem(this.a.a(), 0);
      }
      if (paramSubAccountBackProtocData.a())
      {
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(this.a.a(), paramSubAccountBackProtocData.a(), 2);
        this.a.a().mFirstGetSubAccountName = true;
      }
      if (paramSubAccountBackProtocData.b())
      {
        localObject1 = paramSubAccountBackProtocData.b();
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).unbindRecentItem(this.a.a(), (String)localObject2);
          }
        }
      }
      paramSubAccountBackProtocData.a();
      this.a.a(0L);
      Conversation.k(this.a);
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Conversation.onGetBindSubAccount() return:");
      if (paramBoolean) {
        paramSubAccountBackProtocData = "data=null";
      } else {
        paramSubAccountBackProtocData = "isSucc=false";
      }
      ((StringBuilder)localObject1).append(paramSubAccountBackProtocData);
      QLog.d("SUB_ACCOUNT", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Conversation.onBindSubAccount() isSucc=");
      localStringBuilder.append(paramBoolean);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      if (paramSubAccountBackProtocData != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Conversation.onBindSubAccount() mainAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.b);
        localStringBuilder.append(" subAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.c);
        localStringBuilder.append(" errType=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_a_of_type_Int);
        localStringBuilder.append(" errMsg=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
        QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      }
    }
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.c())) {
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(this.a.a(), paramSubAccountBackProtocData.c(), 1);
    } else if ((paramSubAccountBackProtocData != null) && (!TextUtils.isEmpty(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString))) {
      ThreadManager.getUIHandler().post(new Conversation.48.1(this, paramSubAccountBackProtocData));
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Conversation.onUnBindSubAccount() isSucc=");
      localStringBuilder.append(paramBoolean);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      if (paramSubAccountBackProtocData != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Conversation.onUnBindSubAccount() mainAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.b);
        localStringBuilder.append(" subAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.c);
        localStringBuilder.append(" errType=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_a_of_type_Int);
        localStringBuilder.append(" errMsg=");
        localStringBuilder.append(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
        QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      }
    }
    if (paramSubAccountBackProtocData == null) {
      return;
    }
    if ((paramBoolean) && (paramSubAccountBackProtocData.c != null) && (paramSubAccountBackProtocData.c.length() > 4))
    {
      this.a.a().getMessageFacade().a(paramSubAccountBackProtocData.c, 7000);
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).unbindRecentItem(this.a.a(), paramSubAccountBackProtocData.c);
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.48
 * JD-Core Version:    0.7.0.1
 */