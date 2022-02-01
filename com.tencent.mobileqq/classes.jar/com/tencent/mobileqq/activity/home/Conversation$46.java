package com.tencent.mobileqq.activity.home;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class Conversation$46
  extends SubAccountBindObserver
{
  Conversation$46(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (paramSubAccountBackProtocData == null)
      {
        localObject1 = null;
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramBoolean) && (paramSubAccountBackProtocData != null)) {
        break label113;
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder().append("Conversation.onGetBindSubAccount() return:");
        if (!paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramSubAccountBackProtocData = "data=null";; paramSubAccountBackProtocData = "isSucc=false")
    {
      QLog.d("SUB_ACCOUNT", 4, paramSubAccountBackProtocData);
      return;
      localObject1 = paramSubAccountBackProtocData.c;
      break;
    }
    label113:
    if (paramSubAccountBackProtocData.jdField_a_of_type_Int == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      SubAccountControll.a(this.a.a(), 0);
    }
    if (paramSubAccountBackProtocData.a())
    {
      SubAccountControll.a(this.a.a(), paramSubAccountBackProtocData.a(), 2);
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
          SubAccountControll.c(this.a.a(), (String)localObject2);
        }
      }
    }
    paramSubAccountBackProtocData.a();
    this.a.a(0L);
    Conversation.k(this.a);
  }
  
  public void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + " errMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.c())) {
      SubAccountControll.a(this.a.a(), paramSubAccountBackProtocData.c(), 1);
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      if ((paramSubAccountBackProtocData != null) && (!TextUtils.isEmpty(paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString))) {
        ThreadManager.getUIHandler().post(new Conversation.46.1(this, paramSubAccountBackProtocData));
      }
    }
  }
  
  public void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + " errMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
      }
    }
    if (paramSubAccountBackProtocData == null) {}
    while ((!paramBoolean) || (paramSubAccountBackProtocData.c == null) || (paramSubAccountBackProtocData.c.length() <= 4)) {
      return;
    }
    this.a.a().getMessageFacade().c(paramSubAccountBackProtocData.c, 7000);
    SubAccountControll.c(this.a.a(), paramSubAccountBackProtocData.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.46
 * JD-Core Version:    0.7.0.1
 */