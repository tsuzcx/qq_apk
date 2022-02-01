package com.tencent.mobileqq.app.automator.step;

import abwe;
import abwp;
import abwz;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bbli;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQUpdateVersion
  extends AsyncStep
{
  private final String b = "qq_update_5.6";
  private final String c = "qq_update_6.5.5";
  private final String d = "qq_update_version";
  
  private void a()
  {
    int i = 0;
    String str;
    int j;
    Object localObject3;
    Object localObject1;
    if (i < abwz.c.length)
    {
      str = abwz.c[i];
      j = abwz.u[i];
      localObject3 = this.a.app.getMessageFacade().getMsgList(str, j);
      localObject1 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
      if ((abwz.a(j) != 1001) && (abwz.a(j) != 10002)) {
        break label85;
      }
      localObject1 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
    }
    for (;;)
    {
      if ((localObject3 == null) || (((List)localObject3).isEmpty()))
      {
        return;
        label85:
        if (abwz.a(j) == 1010) {
          localObject1 = AppConstants.DATE_SAY_HELLO_LIST_UIN;
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
          if ((!((String)localObject1).equals(((MessageRecord)localObject3).senderuin)) && (abwz.d((MessageRecord)localObject3)))
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
          this.a.app.getMessageFacade().getC2CMessageManager().a(str, j, ((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).selfuin, false);
          ((MessageRecord)localObject3).frienduin = ((String)localObject1);
          ((MessageRecord)localObject3).setStatus(1000);
          localArrayList.add(localObject3);
          break label123;
          if (localArrayList.size() > 0) {
            this.a.app.getMessageFacade().addMessageStore(localArrayList);
          }
          if (localObject2 != null)
          {
            this.a.app.getMessageFacade().removeMsgFromMsgBox(str, j, localObject2.frienduin, localObject2.selfuin);
            localObject3 = bbli.a(localObject2.msgtype);
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject3, localObject2);
            ((MessageRecord)localObject3).senderuin = ((String)localObject1);
            ((MessageRecord)localObject3).frienduin = str;
            ((MessageRecord)localObject3).istroop = j;
            localObject1 = new ArrayList();
            ((List)localObject1).add(localObject3);
            this.a.app.getMessageFacade().addMessageStore((List)localObject1);
            this.a.app.getConversationFacade().b(str, j);
            this.a.app.getMessageFacade().getC2CMessageManager().a((MessageRecord)localObject3, true, 2);
            this.a.app.getMessageFacade().getC2CMessageManager().a(localObject2, true, 2);
            this.a.app.getMessageFacade().setChangeAndNotify(localObject3);
          }
          i += 1;
          break;
        }
      }
    }
  }
  
  private void d()
  {
    Object localObject = this.a.app.getMessageFacade().getMsgList(AppConstants.DATE_SAY_HELLO_LIST_UIN, 1010);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        this.a.app.getMessageFacade().getC2CMessageManager().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin);
      }
    }
    localObject = this.a.app.getMessageFacade().getMsgList(AppConstants.DATE_UIN, 1010);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        this.a.app.getMessageFacade().getC2CMessageManager().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin);
      }
    }
  }
  
  public int a()
  {
    localSharedPreferences = this.a.app.getApp().getSharedPreferences(this.a.app.getCurrentAccountUin(), 0);
    boolean bool1 = localSharedPreferences.getBoolean("qq_update_5.6", true);
    boolean bool2 = localSharedPreferences.getBoolean("qq_update_6.5.5", true);
    str = localSharedPreferences.getString("qq_update_version", "");
    if (bool1) {
      if (QLog.isColorLevel()) {
        QLog.d("QQUpdateVersion", 2, "do qq update 5.6");
      }
    }
    try
    {
      String[] arrayOfString = "8.4.8".split("\\.");
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
      try
      {
        do
        {
          d();
          localSharedPreferences.edit().putBoolean("qq_update_6.5.5", false).commit();
          if (!"8.4.8".equals(str))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQUpdateVersion", 2, String.format("version update, old=%s, new=%s", new Object[] { str, "8.4.8" }));
            }
            this.a.app.getApp().getSharedPreferences("loginwelcome_" + this.a.app.getCurrentAccountUin(), 0).edit().putBoolean("request_state", true).commit();
            localSharedPreferences.edit().putString("qq_update_version", "8.4.8").commit();
          }
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