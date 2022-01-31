package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.C2CMessageManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQUpdateVersion
  extends AsyncStep
{
  private final String a;
  private final String c = "qq_update_6.5.5";
  private final String d = "QQUpdateVersion";
  
  public QQUpdateVersion()
  {
    this.jdField_a_of_type_JavaLangString = "qq_update_5.6";
  }
  
  private void b()
  {
    int i = 0;
    String str;
    int j;
    Object localObject3;
    Object localObject1;
    if (i < MsgProxyUtils.c.length)
    {
      str = MsgProxyUtils.c[i];
      j = MsgProxyUtils.u[i];
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().b(str, j);
      localObject1 = AppConstants.ae;
      if ((MsgProxyUtils.a(j) != 1001) && (MsgProxyUtils.a(j) != 10002)) {
        break label85;
      }
      localObject1 = AppConstants.ae;
    }
    for (;;)
    {
      if ((localObject3 == null) || (((List)localObject3).isEmpty()))
      {
        return;
        label85:
        if (MsgProxyUtils.a(j) == 1010) {
          localObject1 = AppConstants.af;
        }
      }
      else
      {
        Object localObject2 = null;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject3).iterator();
        label123:
        while (localIterator.hasNext())
        {
          localObject3 = (MessageRecord)localIterator.next();
          if ((!((String)localObject1).equals(((MessageRecord)localObject3).senderuin)) && (MsgProxyUtils.c((MessageRecord)localObject3)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQUpdateVersion", 2, "doMergeSayHelloBox oneWay=" + ((MessageRecord)localObject3).getBaseInfoString());
            }
            if (localObject2 != null) {
              break label469;
            }
            localObject2 = localObject3;
          }
        }
        label469:
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a().a(str, j, ((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).selfuin, false);
          ((MessageRecord)localObject3).frienduin = ((String)localObject1);
          ((MessageRecord)localObject3).setStatus(1000);
          localArrayList.add(localObject3);
          break label123;
          if (localArrayList.size() > 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a(localArrayList);
          }
          if (localObject2 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a(str, j, localObject2.frienduin, localObject2.selfuin);
            localObject3 = MessageRecordFactory.a(localObject2.msgtype);
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject3, localObject2);
            ((MessageRecord)localObject3).senderuin = ((String)localObject1);
            ((MessageRecord)localObject3).frienduin = str;
            ((MessageRecord)localObject3).istroop = j;
            localObject1 = new ArrayList();
            ((List)localObject1).add(localObject3);
            this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a((List)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().b(str, j);
            this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a().a((MessageRecord)localObject3, true, 2);
            this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a().a(localObject2, true, 2);
            this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a(localObject3);
          }
          i += 1;
          break;
        }
      }
    }
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().b(AppConstants.af, 1010);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().b(AppConstants.X, 1010);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin);
      }
    }
  }
  
  protected int a()
  {
    localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getCurrentAccountUin(), 0);
    boolean bool1 = localSharedPreferences.getBoolean("qq_update_5.6", true);
    boolean bool2 = localSharedPreferences.getBoolean("qq_update_6.5.5", true);
    if (bool1) {
      if (QLog.isColorLevel()) {
        QLog.d("QQUpdateVersion", 2, "do qq update 5.6");
      }
    }
    try
    {
      String[] arrayOfString = "7.6.8".split("\\.");
      if ((arrayOfString != null) && (arrayOfString.length >= 2))
      {
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[1]);
        if ((i >= 5) && (j >= 6)) {
          b();
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          d();
          localSharedPreferences.edit().putBoolean("qq_update_6.5.5", false).commit();
          return 7;
          localException1 = localException1;
        } while (!QLog.isColorLevel());
        QLog.w("QQUpdateVersion", 2, localException1.getMessage(), localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQUpdateVersion 6.5.5", 2, localException2.getMessage(), localException2);
          }
        }
      }
    }
    localSharedPreferences.edit().putBoolean("qq_update_5.6", false).commit();
    if (bool2) {
      if (QLog.isColorLevel()) {
        QLog.d("QQUpdateVersion", 2, "do qq update 6.5.5");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QQUpdateVersion
 * JD-Core Version:    0.7.0.1
 */