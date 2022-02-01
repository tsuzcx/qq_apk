package com.tencent.mobileqq.activity.qwallet.notifymsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GoldMsgTipsElem;
import tencent.im.oidb.cmd0x858.oidb_0x858.GoldMsgTipsElem;

public class NotifyMsgManager
{
  protected static int a;
  protected static NotifyMsgDBHelper a;
  protected static Object a;
  protected static ArrayList<NotifyMsgManager.WaitRecord> a;
  protected static ArrayList<NotifyMsgDBHelper.NotifyMsgRecord> b = new ArrayList();
  protected static ArrayList<NotifyMsgDBHelper.NotifyMsgRecord> c = new ArrayList(128);
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper = null;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static NotifyMsgDBHelper.NotifyMsgRecord a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    NotifyMsgDBHelper.NotifyMsgRecord localNotifyMsgRecord = null;
    ??? = localNotifyMsgRecord;
    if (a(paramInt))
    {
      ??? = localNotifyMsgRecord;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord != null) {
          break label32;
        }
        ??? = localNotifyMsgRecord;
      }
    }
    for (;;)
    {
      return ???;
      label32:
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord btype:" + paramInt + " bid:" + paramString + " dbstate:" + jdField_a_of_type_Int);
      }
      if (jdField_a_of_type_Int == 2)
      {
        localNotifyMsgRecord = a(c, paramInt, paramString);
        if (localNotifyMsgRecord != null) {
          a(paramMessageRecord, localNotifyMsgRecord, paramInt, paramString, true);
        }
        ??? = localNotifyMsgRecord;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord check in cache:" + localNotifyMsgRecord);
        return localNotifyMsgRecord;
      }
      if (paramInt != 2) {}
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        if (!a(paramInt, paramString, paramMessageRecord)) {
          jdField_a_of_type_JavaUtilArrayList.add(new NotifyMsgManager.WaitRecord(paramInt, paramString, paramMessageRecord));
        }
        ??? = localNotifyMsgRecord;
        if (jdField_a_of_type_Int != 0) {
          continue;
        }
        b();
        return null;
      }
    }
  }
  
  protected static NotifyMsgDBHelper.NotifyMsgRecord a(NotifyMsgDBHelper.NotifyMsgRecord paramNotifyMsgRecord1, NotifyMsgDBHelper.NotifyMsgRecord paramNotifyMsgRecord2)
  {
    if ((paramNotifyMsgRecord1 == null) || (paramNotifyMsgRecord2 == null)) {}
    while ((paramNotifyMsgRecord1.b != paramNotifyMsgRecord2.b) || (paramNotifyMsgRecord1.jdField_a_of_type_JavaLangString == null) || (!paramNotifyMsgRecord1.jdField_a_of_type_JavaLangString.equals(paramNotifyMsgRecord2.jdField_a_of_type_JavaLangString))) {
      return paramNotifyMsgRecord2;
    }
    int i;
    if (paramNotifyMsgRecord1.b == 1)
    {
      i = paramNotifyMsgRecord2.a("state", 0);
      int j = paramNotifyMsgRecord1.a("state", 0);
      if (i == 2) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      paramNotifyMsgRecord2.a("state", i);
      return paramNotifyMsgRecord2;
      paramNotifyMsgRecord2.jdField_a_of_type_OrgJsonJSONObject = paramNotifyMsgRecord1.jdField_a_of_type_OrgJsonJSONObject;
      return paramNotifyMsgRecord2;
    }
  }
  
  protected static NotifyMsgDBHelper.NotifyMsgRecord a(ArrayList<NotifyMsgDBHelper.NotifyMsgRecord> paramArrayList, int paramInt, String paramString)
  {
    Object localObject;
    if (paramArrayList == null)
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label75;
      }
      NotifyMsgDBHelper.NotifyMsgRecord localNotifyMsgRecord = (NotifyMsgDBHelper.NotifyMsgRecord)paramArrayList.get(i);
      if ((localNotifyMsgRecord != null) && (localNotifyMsgRecord.b == paramInt) && (localNotifyMsgRecord.jdField_a_of_type_JavaLangString != null))
      {
        localObject = localNotifyMsgRecord;
        if (localNotifyMsgRecord.jdField_a_of_type_JavaLangString.equals(paramString)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  public static ArrayList<NotifyMsgDBHelper.NotifyMsgRecord> a(int paramInt)
  {
    if (!a(paramInt)) {}
    label68:
    do
    {
      return null;
      if (jdField_a_of_type_Int == 2)
      {
        ArrayList localArrayList = a(c, paramInt);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("queryRecordsInMemory size:");
          if (localArrayList == null) {
            break label68;
          }
        }
        for (paramInt = localArrayList.size();; paramInt = 0)
        {
          QLog.i("NotifyMsgManager", 2, paramInt);
          return localArrayList;
        }
      }
    } while (jdField_a_of_type_Int != 0);
    b();
    return null;
  }
  
  protected static ArrayList<NotifyMsgDBHelper.NotifyMsgRecord> a(ArrayList<NotifyMsgDBHelper.NotifyMsgRecord> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      NotifyMsgDBHelper.NotifyMsgRecord localNotifyMsgRecord = (NotifyMsgDBHelper.NotifyMsgRecord)paramArrayList.get(i);
      if ((localNotifyMsgRecord != null) && (localNotifyMsgRecord.b == paramInt)) {
        localArrayList.add(localNotifyMsgRecord);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Int == 0) {
      b();
    }
  }
  
  public static void a(int paramInt, TroopTips0x857.GoldMsgTipsElem paramGoldMsgTipsElem, oidb_0x858.GoldMsgTipsElem paramGoldMsgTipsElem1)
  {
    if ((paramInt == 3000) && (paramGoldMsgTipsElem1 != null)) {
      if (!paramGoldMsgTipsElem1.type.has()) {
        break label310;
      }
    }
    label300:
    label310:
    for (paramInt = paramGoldMsgTipsElem1.type.get();; paramInt = 0)
    {
      if (paramGoldMsgTipsElem1.billno.has()) {}
      for (paramGoldMsgTipsElem = paramGoldMsgTipsElem1.billno.get();; paramGoldMsgTipsElem = null)
      {
        int i = paramInt;
        Object localObject = paramGoldMsgTipsElem;
        if (paramGoldMsgTipsElem1.action.has())
        {
          i = paramGoldMsgTipsElem1.action.get();
          if (QLog.isColorLevel()) {
            QLog.i("NotifyMsgManager", 2, "onReceiveAAPaySysNotify type:" + paramInt + " billno:" + paramGoldMsgTipsElem + " action:" + i);
          }
          if (paramInt != 3)
          {
            label123:
            do
            {
              return;
            } while (((paramInt != 1) && (paramInt != 0)) || (paramGoldMsgTipsElem == null));
            if (!paramGoldMsgTipsElem.type.has()) {
              break label300;
            }
          }
        }
        for (paramInt = paramGoldMsgTipsElem.type.get();; paramInt = 0)
        {
          if (paramGoldMsgTipsElem.billno.has()) {}
          for (paramGoldMsgTipsElem1 = paramGoldMsgTipsElem.billno.get();; paramGoldMsgTipsElem1 = null)
          {
            i = paramInt;
            localObject = paramGoldMsgTipsElem1;
            if (paramGoldMsgTipsElem.action.has())
            {
              i = paramGoldMsgTipsElem.action.get();
              paramGoldMsgTipsElem = paramGoldMsgTipsElem1;
              break;
              paramGoldMsgTipsElem1 = QWalletTools.a();
              if (paramGoldMsgTipsElem1 == null) {
                break label123;
              }
              localObject = new NotifyMsgDBHelper.NotifyMsgRecord(0, paramGoldMsgTipsElem1.getLongAccountUin(), 1, paramGoldMsgTipsElem, 0L, null);
              ((NotifyMsgDBHelper.NotifyMsgRecord)localObject).a("state", i);
              a(paramGoldMsgTipsElem1.getLongAccountUin(), (NotifyMsgDBHelper.NotifyMsgRecord)localObject);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("btype", 1);
              ((Bundle)localObject).putString("bid", paramGoldMsgTipsElem);
              paramGoldMsgTipsElem1.notifyObservers(NotifyMsgObserver.class, 1, true, (Bundle)localObject);
              return;
            }
            int j = 0;
            paramGoldMsgTipsElem = (TroopTips0x857.GoldMsgTipsElem)localObject;
            paramInt = i;
            i = j;
            break;
          }
        }
      }
    }
  }
  
  protected static void a(long paramLong, NotifyMsgDBHelper.NotifyMsgRecord paramNotifyMsgRecord)
  {
    if ((paramNotifyMsgRecord == null) || (!a(paramNotifyMsgRecord.b)) || (TextUtils.isEmpty(paramNotifyMsgRecord.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = a(c, paramNotifyMsgRecord.b, paramNotifyMsgRecord.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        if (jdField_a_of_type_Int == 2)
        {
          c.add(paramNotifyMsgRecord);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramNotifyMsgRecord);
          a((ArrayList)localObject, true);
          return;
        }
        localObject = a(b, paramNotifyMsgRecord.b, paramNotifyMsgRecord.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          b.add(paramNotifyMsgRecord);
        }
        while (jdField_a_of_type_Int == 0)
        {
          b();
          return;
          a(paramNotifyMsgRecord, (NotifyMsgDBHelper.NotifyMsgRecord)localObject);
        }
      }
    } while (paramNotifyMsgRecord.b == 2);
    a(paramNotifyMsgRecord, (NotifyMsgDBHelper.NotifyMsgRecord)localObject);
    paramNotifyMsgRecord = new ArrayList();
    paramNotifyMsgRecord.add(localObject);
    a(paramNotifyMsgRecord, false);
  }
  
  protected static void a(NotifyMsgManager.WaitRecord paramWaitRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgManager", 2, "notifyUI start");
    }
    QQAppInterface localQQAppInterface;
    if ((paramWaitRecord != null) && (paramWaitRecord.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      localQQAppInterface = QWalletTools.a();
      if (localQQAppInterface != null) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", paramWaitRecord.jdField_a_of_type_Int);
      localBundle.putString("bid", paramWaitRecord.jdField_a_of_type_JavaLangString);
      localQQAppInterface.notifyObservers(NotifyMsgObserver.class, 1, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.i("NotifyMsgManager", 2, "notifyUI btype:" + paramWaitRecord.jdField_a_of_type_Int + " bid:" + paramWaitRecord.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 1) && (paramInt != 3000)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = QWalletTools.a();
    } while (localQQAppInterface == null);
    paramString2 = new NotifyMsgDBHelper.NotifyMsgRecord(0, localQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
    paramString2.a("groupUin", paramString1);
    paramString2.a("groupType", paramInt);
    a(localQQAppInterface.getLongAccountUin(), paramString2);
  }
  
  protected static void a(ArrayList<NotifyMsgDBHelper.NotifyMsgRecord> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgManager.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  protected static void a(List<NotifyMsgManager.WaitRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        NotifyMsgManager.WaitRecord localWaitRecord = (NotifyMsgManager.WaitRecord)paramList.next();
        if ((localWaitRecord != null) && (a(localWaitRecord.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localWaitRecord.jdField_a_of_type_Int, localWaitRecord.jdField_a_of_type_JavaLangString, false))) {
          localArrayList.add(localWaitRecord);
        }
      }
    } while (localArrayList.size() <= 0);
    ThreadManager.post(new NotifyMsgManager.2(localArrayList), 5, null, false);
  }
  
  protected static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2);
  }
  
  protected static boolean a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < jdField_a_of_type_JavaUtilArrayList.size())
      {
        NotifyMsgManager.WaitRecord localWaitRecord = (NotifyMsgManager.WaitRecord)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localWaitRecord != null) && (localWaitRecord.jdField_a_of_type_Int == paramInt) && (localWaitRecord.jdField_a_of_type_JavaLangString != null) && (localWaitRecord.jdField_a_of_type_JavaLangString.equals(paramString)) && (localWaitRecord.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == paramMessageRecord)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord, NotifyMsgDBHelper.NotifyMsgRecord paramNotifyMsgRecord, int paramInt, String paramString, boolean paramBoolean)
  {
    NotifyMsgDBHelper.NotifyMsgRecord localNotifyMsgRecord;
    int i;
    if ((paramMessageRecord != null) && (paramString != null)) {
      if (paramInt == 1)
      {
        localNotifyMsgRecord = paramNotifyMsgRecord;
        if (paramNotifyMsgRecord == null) {
          localNotifyMsgRecord = a(c, paramInt, paramString);
        }
        if (localNotifyMsgRecord == null) {
          break label241;
        }
        i = localNotifyMsgRecord.a("state", -1);
        paramNotifyMsgRecord = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramNotifyMsgRecord)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(paramNotifyMsgRecord).intValue();
        if ((i == -1) || (i == paramInt)) {
          break label241;
        }
        paramMessageRecord.saveExtInfoToExtStr("qqpay_state", String.valueOf(i));
        bool = true;
        if ((bool) && (paramBoolean)) {
          ThreadManager.post(new NotifyMsgManager.3(paramMessageRecord), 5, null, false);
        }
        return bool;
      }
      catch (Exception paramNotifyMsgRecord)
      {
        if (QLog.isColorLevel()) {
          paramNotifyMsgRecord.printStackTrace();
        }
      }
      paramInt = -1;
      continue;
      if (paramInt == 2)
      {
        localNotifyMsgRecord = paramNotifyMsgRecord;
        if (paramNotifyMsgRecord == null) {
          localNotifyMsgRecord = a(c, paramInt, paramString);
        }
        if ((localNotifyMsgRecord != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          paramNotifyMsgRecord = (MessageForQQWalletMsg)paramMessageRecord;
          if ((paramNotifyMsgRecord.mQQWalletRedPacketMsg != null) && (paramNotifyMsgRecord.mQQWalletRedPacketMsg.isOpened))
          {
            paramNotifyMsgRecord.mQQWalletRedPacketMsg.isOpened = true;
            paramNotifyMsgRecord.msgData = paramNotifyMsgRecord.getBytes();
            paramString = QWalletTools.a();
            if (paramString != null) {
              paramString.getMessageFacade().a(paramNotifyMsgRecord.frienduin, paramNotifyMsgRecord.istroop, paramNotifyMsgRecord.uniseq, paramNotifyMsgRecord.msgData);
            }
          }
        }
      }
      label241:
      boolean bool = false;
    }
  }
  
  protected static void b()
  {
    jdField_a_of_type_Int = 1;
    ThreadManager.post(new NotifyMsgManager.1(), 10, null, false);
  }
  
  public static void c()
  {
    jdField_a_of_type_Int = 0;
    c.clear();
    jdField_a_of_type_JavaUtilArrayList.clear();
    b.clear();
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper != null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper.close();
      jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager
 * JD-Core Version:    0.7.0.1
 */