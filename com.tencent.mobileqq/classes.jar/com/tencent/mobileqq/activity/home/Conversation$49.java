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

class Conversation$49
  extends SubAccountBindObserver
{
  Conversation$49(Conversation paramConversation) {}
  
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
        localObject1 = paramSubAccountBackProtocData.d;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
    }
    if ((paramBoolean) && (paramSubAccountBackProtocData != null))
    {
      if (paramSubAccountBackProtocData.a == 1008)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
        }
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).unbindAllRecentItem(this.a.s(), 0);
      }
      if (paramSubAccountBackProtocData.a())
      {
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(this.a.s(), paramSubAccountBackProtocData.b(), 2);
        this.a.s().mFirstGetSubAccountName = true;
      }
      if (paramSubAccountBackProtocData.c())
      {
        localObject1 = paramSubAccountBackProtocData.d();
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).unbindRecentItem(this.a.s(), (String)localObject2);
          }
        }
      }
      paramSubAccountBackProtocData.g();
      this.a.a(0L);
      Conversation.u(this.a);
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
        localStringBuilder.append(paramSubAccountBackProtocData.c);
        localStringBuilder.append(" subAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.d);
        localStringBuilder.append(" errType=");
        localStringBuilder.append(paramSubAccountBackProtocData.a);
        localStringBuilder.append(" errMsg=");
        localStringBuilder.append(paramSubAccountBackProtocData.b);
        QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      }
    }
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.e())) {
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(this.a.s(), paramSubAccountBackProtocData.f(), 1);
    } else if ((paramSubAccountBackProtocData != null) && (!TextUtils.isEmpty(paramSubAccountBackProtocData.b))) {
      ThreadManager.getUIHandler().post(new Conversation.49.1(this, paramSubAccountBackProtocData));
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
        localStringBuilder.append(paramSubAccountBackProtocData.c);
        localStringBuilder.append(" subAccount=");
        localStringBuilder.append(paramSubAccountBackProtocData.d);
        localStringBuilder.append(" errType=");
        localStringBuilder.append(paramSubAccountBackProtocData.a);
        localStringBuilder.append(" errMsg=");
        localStringBuilder.append(paramSubAccountBackProtocData.b);
        QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      }
    }
    if (paramSubAccountBackProtocData == null) {
      return;
    }
    if ((paramBoolean) && (paramSubAccountBackProtocData.d != null) && (paramSubAccountBackProtocData.d.length() > 4))
    {
      this.a.s().getMessageFacade().a(paramSubAccountBackProtocData.d, 7000);
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).unbindRecentItem(this.a.s(), paramSubAccountBackProtocData.d);
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.49
 * JD-Core Version:    0.7.0.1
 */