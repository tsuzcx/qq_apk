package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
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
  private static final String[] a = { AppConstants.LBS_HELLO_UIN, AppConstants.DATE_UIN };
  private final String b = "qq_update_5.6";
  private final String c = "qq_update_6.5.5";
  private final String d = "qq_update_version";
  
  private void a()
  {
    int i = 0;
    for (;;)
    {
      Object localObject1 = a;
      if (i >= localObject1.length) {
        break;
      }
      String str = localObject1[i];
      int j = com.tencent.imcore.message.MsgProxyUtils.l[i];
      Object localObject3 = this.mAutomator.k.getMessageFacade().h(str, j);
      localObject1 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
      if ((UinTypeUtil.e(j) != 1001) && (UinTypeUtil.e(j) != 10002))
      {
        if (UinTypeUtil.e(j) == 1010) {
          localObject1 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
        }
      }
      else {
        localObject1 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
      }
      if (localObject3 == null) {
        break;
      }
      if (((List)localObject3).isEmpty()) {
        return;
      }
      Object localObject2 = null;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (MessageRecord)localIterator.next();
        if ((!((String)localObject1).equals(((MessageRecord)localObject3).senderuin)) && (UinTypeUtil.c((MessageRecord)localObject3)))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("doMergeSayHelloBox oneWay=");
            localStringBuilder.append(((MessageRecord)localObject3).getBaseInfoString());
            QLog.d("QQUpdateVersion", 2, localStringBuilder.toString());
          }
          if (localObject2 == null) {
            localObject2 = localObject3;
          }
          this.mAutomator.k.getMessageFacade().r().a(str, j, ((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).selfuin, false);
          ((MessageRecord)localObject3).frienduin = ((String)localObject1);
          ((MessageRecord)localObject3).setStatus(1000);
          localArrayList.add(localObject3);
        }
      }
      if (localArrayList.size() > 0) {
        this.mAutomator.k.getMessageFacade().a(localArrayList);
      }
      if (localObject2 != null)
      {
        this.mAutomator.k.getMessageFacade().a(str, j, localObject2.frienduin, localObject2.selfuin);
        localObject3 = MessageRecordFactory.a(localObject2.msgtype);
        MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject3, localObject2);
        ((MessageRecord)localObject3).senderuin = ((String)localObject1);
        ((MessageRecord)localObject3).frienduin = str;
        ((MessageRecord)localObject3).istroop = j;
        localObject1 = new ArrayList();
        ((List)localObject1).add(localObject3);
        this.mAutomator.k.getMessageFacade().a((List)localObject1);
        this.mAutomator.k.getConversationFacade().k(str, j);
        this.mAutomator.k.getMessageFacade().r().a((MessageRecord)localObject3, true, 2);
        this.mAutomator.k.getMessageFacade().r().a(localObject2, true, 2);
        this.mAutomator.k.getMessageFacade().a(localObject3);
      }
      i += 1;
    }
  }
  
  private void b()
  {
    Object localObject = this.mAutomator.k.getMessageFacade().h(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        this.mAutomator.k.getMessageFacade().r().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin);
      }
    }
    localObject = this.mAutomator.k.getMessageFacade().h(AppConstants.DATE_UIN, 1010);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        this.mAutomator.k.getMessageFacade().r().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin);
      }
    }
  }
  
  protected int doStep()
  {
    SharedPreferences localSharedPreferences = this.mAutomator.k.getApp().getSharedPreferences(this.mAutomator.k.getCurrentAccountUin(), 0);
    boolean bool1 = localSharedPreferences.getBoolean("qq_update_5.6", true);
    boolean bool2 = localSharedPreferences.getBoolean("qq_update_6.5.5", true);
    Object localObject = localSharedPreferences.getString("qq_update_version", "");
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQUpdateVersion", 2, "do qq update 5.6");
      }
      try
      {
        String[] arrayOfString = "8.8.17".split("\\.");
        if ((arrayOfString != null) && (arrayOfString.length >= 2))
        {
          int i = Integer.parseInt(arrayOfString[0]);
          int j = Integer.parseInt(arrayOfString[1]);
          if ((i >= 5) && (j >= 6)) {
            a();
          }
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("QQUpdateVersion", 2, localException1.getMessage(), localException1);
        }
      }
      localSharedPreferences.edit().putBoolean("qq_update_5.6", false).commit();
    }
    if (bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQUpdateVersion", 2, "do qq update 6.5.5");
      }
      try
      {
        b();
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.w("QQUpdateVersion 6.5.5", 2, localException2.getMessage(), localException2);
        }
      }
      localSharedPreferences.edit().putBoolean("qq_update_6.5.5", false).commit();
    }
    if (!"8.8.17".equals(localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQUpdateVersion", 2, String.format("version update, old=%s, new=%s", new Object[] { localObject, "8.8.17" }));
      }
      localObject = this.mAutomator.k.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loginwelcome_");
      localStringBuilder.append(this.mAutomator.k.getCurrentAccountUin());
      ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("request_state", true).commit();
      localSharedPreferences.edit().putString("qq_update_version", "8.8.17").commit();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QQUpdateVersion
 * JD-Core Version:    0.7.0.1
 */