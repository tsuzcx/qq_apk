package com.tencent.mobileqq.activity.qwallet.goldmsg;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.qwallet.GoldConfigObserver;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GoldMsgTipsElem;
import tencent.im.oidb.cmd0x858.oidb_0x858.GoldMsgTipsElem;
import xbm;
import xbn;

public class GoldMsgDbManager
{
  public static int a;
  public static GoldMsgDBHelper a;
  public static Object a;
  public static final String a;
  public static ArrayList a;
  public static HashMap a;
  public static ArrayList b;
  
  static
  {
    jdField_a_of_type_JavaLangString = GoldMsgChatHelper.class.getSimpleName();
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    b = new ArrayList();
    jdField_a_of_type_JavaUtilHashMap = new HashMap(128);
  }
  
  public static GoldMsgDBHelper.GoldMsgNotifyRecord a(MessageRecord paramMessageRecord)
  {
    String str;
    if (paramMessageRecord != null)
    {
      str = paramMessageRecord.getExtInfoFromExtStr("goldmsg_order_id");
      if (!TextUtils.isEmpty(str)) {
        break label25;
      }
    }
    label25:
    do
    {
      return null;
      str = null;
      break;
      if (jdField_a_of_type_Int == 2) {
        return (GoldMsgDBHelper.GoldMsgNotifyRecord)jdField_a_of_type_JavaUtilHashMap.get(str);
      }
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramMessageRecord)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramMessageRecord);
      }
    } while (jdField_a_of_type_Int != 0);
    a();
    return null;
  }
  
  protected static GoldMsgDBHelper.GoldMsgNotifyRecord a(String paramString, List paramList)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (paramList == null))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label66;
      }
      GoldMsgDBHelper.GoldMsgNotifyRecord localGoldMsgNotifyRecord = (GoldMsgDBHelper.GoldMsgNotifyRecord)paramList.get(i);
      if (localGoldMsgNotifyRecord != null)
      {
        localObject = localGoldMsgNotifyRecord;
        if (paramString.equals(localGoldMsgNotifyRecord.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label66:
    return null;
  }
  
  protected static void a()
  {
    jdField_a_of_type_Int = 1;
    ThreadManager.post(new xbm(), 10, null, false);
  }
  
  public static void a(int paramInt, String paramString, TroopTips0x857.GoldMsgTipsElem paramGoldMsgTipsElem, oidb_0x858.GoldMsgTipsElem paramGoldMsgTipsElem1)
  {
    int i5 = 0;
    int i = 0;
    Bundle localBundle = null;
    Object localObject = null;
    int j = -1;
    int k = 0;
    int i4 = 0;
    int i3 = 0;
    int m = 0;
    int i2 = 0;
    int n = 0;
    int i1 = -1;
    int i7;
    int i6;
    if ((paramInt == 3000) && (paramGoldMsgTipsElem1 != null))
    {
      k = i;
      if (paramGoldMsgTipsElem1.type.has()) {
        k = paramGoldMsgTipsElem1.type.get();
      }
      paramGoldMsgTipsElem = (TroopTips0x857.GoldMsgTipsElem)localObject;
      if (paramGoldMsgTipsElem1.billno.has()) {
        paramGoldMsgTipsElem = paramGoldMsgTipsElem1.billno.get();
      }
      i = j;
      if (paramGoldMsgTipsElem1.result.has()) {
        i = paramGoldMsgTipsElem1.result.get();
      }
      j = i4;
      if (paramGoldMsgTipsElem1.amount.has()) {
        j = paramGoldMsgTipsElem1.amount.get();
      }
      if (paramGoldMsgTipsElem1.total.has()) {
        m = paramGoldMsgTipsElem1.total.get();
      }
      if (paramGoldMsgTipsElem1.interval.has()) {
        n = paramGoldMsgTipsElem1.interval.get();
      }
      if (paramGoldMsgTipsElem1.finish.has()) {
        i1 = paramGoldMsgTipsElem1.finish.get();
      }
      i7 = k;
      localObject = paramGoldMsgTipsElem;
      i6 = i;
      i5 = j;
      i4 = m;
      i3 = n;
      i2 = i1;
      if (!paramGoldMsgTipsElem1.uin.has()) {
        break label899;
      }
      localObject = paramGoldMsgTipsElem1.uin.get();
      paramGoldMsgTipsElem1 = paramGoldMsgTipsElem;
      paramGoldMsgTipsElem = (TroopTips0x857.GoldMsgTipsElem)localObject;
    }
    for (;;)
    {
      if ((k != 1) && (k != 2)) {}
      label257:
      label814:
      do
      {
        do
        {
          do
          {
            break label257;
            do
            {
              return;
            } while ((paramInt != 1) || (paramGoldMsgTipsElem == null));
            i = i5;
            if (paramGoldMsgTipsElem.type.has()) {
              i = paramGoldMsgTipsElem.type.get();
            }
            paramGoldMsgTipsElem1 = localBundle;
            if (paramGoldMsgTipsElem.billno.has()) {
              paramGoldMsgTipsElem1 = paramGoldMsgTipsElem.billno.get();
            }
            if (paramGoldMsgTipsElem.result.has()) {
              j = paramGoldMsgTipsElem.result.get();
            }
            if (paramGoldMsgTipsElem.amount.has()) {
              k = paramGoldMsgTipsElem.amount.get();
            }
            m = i3;
            if (paramGoldMsgTipsElem.total.has()) {
              m = paramGoldMsgTipsElem.total.get();
            }
            n = i2;
            if (paramGoldMsgTipsElem.interval.has()) {
              n = paramGoldMsgTipsElem.interval.get();
            }
            if (paramGoldMsgTipsElem.finish.has()) {
              i1 = paramGoldMsgTipsElem.finish.get();
            }
            i7 = i;
            localObject = paramGoldMsgTipsElem1;
            i6 = j;
            i5 = k;
            i4 = m;
            i3 = n;
            i2 = i1;
            if (!paramGoldMsgTipsElem.uin.has()) {
              break label899;
            }
            paramGoldMsgTipsElem = paramGoldMsgTipsElem.uin.get();
            i2 = i;
            i = j;
            j = k;
            k = i2;
            break;
            localObject = QWalletTools.a();
          } while (localObject == null);
          localBundle = new Bundle();
          localBundle.putInt("receUinType", paramInt);
          localBundle.putString("receUin", paramString);
          localBundle.putInt("total", m);
          localBundle.putInt("current", j);
          if (i1 == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localBundle.putBoolean("isFinish", bool);
            localBundle.putString("listId", paramGoldMsgTipsElem1);
            paramString = new ArrayList();
            if ((k != 2) || (paramGoldMsgTipsElem == null)) {
              break;
            }
            paramInt = 0;
            while (paramInt < paramGoldMsgTipsElem.size())
            {
              paramString.add(String.valueOf(paramGoldMsgTipsElem.get(paramInt)));
              paramInt += 1;
            }
          }
          localBundle.putStringArrayList("uins", paramString);
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "onReceiveGroupSysNotify type:" + k + " billno:" + paramGoldMsgTipsElem1 + " result:" + i + " finishState:" + i1 + " amount:" + j + " total:" + m + " interval:" + n + " gLoadDbState:" + jdField_a_of_type_Int + " uins:" + paramString.toString());
          }
          if (k != 1) {
            break label814;
          }
        } while (i != 1);
        QWalletSetting.a(((QQAppInterface)localObject).getCurrentAccountUin(), "goldmsg_has_right", false);
        QWalletSetting.a(((QQAppInterface)localObject).getCurrentAccountUin(), "goldmsg_no_right_start_time", NetConnInfoCenter.getServerTime());
        paramString = ((QQAppInterface)localObject).getCurrentAccountUin();
        if (n > 259200L) {}
        for (long l = 259200L;; l = n)
        {
          QWalletSetting.a(paramString, "goldmsg_no_right_interval", l);
          return;
        }
      } while (k != 2);
      i = 0;
      paramInt = i;
      if (j > 0)
      {
        paramInt = i;
        if (m > 0)
        {
          paramInt = i;
          if (paramString.contains(((QQAppInterface)localObject).getCurrentAccountUin())) {
            paramInt = 1;
          }
        }
      }
      a(paramGoldMsgTipsElem1, paramString, i1, paramInt, j);
      if (paramInt == 1)
      {
        ((QQAppInterface)localObject).notifyObservers(GoldConfigObserver.class, 16, true, localBundle);
        return;
      }
      ((QQAppInterface)localObject).notifyObservers(GoldConfigObserver.class, 12, true, localBundle);
      return;
      label899:
      k = i7;
      paramGoldMsgTipsElem = null;
      paramGoldMsgTipsElem1 = (oidb_0x858.GoldMsgTipsElem)localObject;
      i = i6;
      j = i5;
      m = i4;
      n = i3;
      i1 = i2;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    Object localObject = QWalletTools.a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while ((paramMessageRecord == null) || (localObject == null));
      localObject = ((QQAppInterface)localObject).getHandler(ChatActivity.class);
    } while (localObject == null);
    Message localMessage = new Message();
    localMessage.what = 78;
    localMessage.arg1 = 890;
    Bundle localBundle = new Bundle();
    localBundle.putLong("messageUniseq", paramMessageRecord.uniseq);
    localMessage.setData(localBundle);
    ((MqqHandler)localObject).sendMessage(localMessage);
  }
  
  protected static void a(String paramString, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    GoldMsgDBHelper.GoldMsgNotifyRecord localGoldMsgNotifyRecord;
    for (;;)
    {
      return;
      localGoldMsgNotifyRecord = (GoldMsgDBHelper.GoldMsgNotifyRecord)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localGoldMsgNotifyRecord != null) {
        break;
      }
      if (paramArrayList != null) {
        i = paramArrayList.size();
      }
      paramArrayList = new GoldMsgDBHelper.GoldMsgNotifyRecord(paramString, paramInt1, paramArrayList, paramInt2, paramInt3, i);
      if (jdField_a_of_type_Int == 2)
      {
        jdField_a_of_type_JavaUtilHashMap.put(paramArrayList.jdField_a_of_type_JavaLangString, paramArrayList);
        paramString = new ArrayList();
        paramString.add(paramArrayList);
        a(paramString, true);
        return;
      }
      paramString = a(paramString, b);
      if (paramString == null) {
        b.add(paramArrayList);
      }
      while (jdField_a_of_type_Int == 0)
      {
        a();
        return;
        paramString.a(paramArrayList.jdField_a_of_type_JavaUtilArrayList);
        paramString.c = paramInt3;
        if (paramArrayList.jdField_a_of_type_Int == 1) {
          paramString.jdField_a_of_type_Int = 1;
        }
        if (paramArrayList.b == 1) {
          paramString.b = 1;
        }
      }
    }
    i = localGoldMsgNotifyRecord.a(paramArrayList);
    if (i > 0) {
      localGoldMsgNotifyRecord.d = (i + localGoldMsgNotifyRecord.d);
    }
    for (int j = 1;; j = 0)
    {
      i = j;
      if (paramInt1 == 1)
      {
        i = j;
        if (localGoldMsgNotifyRecord.jdField_a_of_type_Int != paramInt1)
        {
          localGoldMsgNotifyRecord.jdField_a_of_type_Int = paramInt1;
          i = 1;
        }
      }
      paramInt1 = i;
      if (paramInt2 == 1)
      {
        paramInt1 = i;
        if (localGoldMsgNotifyRecord.b != paramInt2)
        {
          localGoldMsgNotifyRecord.b = paramInt2;
          localGoldMsgNotifyRecord.c = paramInt3;
          paramInt1 = 1;
        }
      }
      if (paramInt1 == 0) {
        break;
      }
      paramString = new ArrayList();
      paramString.add(localGoldMsgNotifyRecord);
      a(paramString, false);
      return;
    }
  }
  
  public static void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new xbn(paramBoolean, paramArrayList), 5, null, false);
  }
  
  public static void b()
  {
    jdField_a_of_type_Int = 0;
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      jdField_a_of_type_JavaUtilHashMap.clear();
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        jdField_a_of_type_JavaUtilArrayList.clear();
        synchronized (b)
        {
          b.clear();
          if (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDBHelper == null) {}
        }
      }
    }
    try
    {
      jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDBHelper.close();
      jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDBHelper = null;
      return;
      localObject2 = finally;
      throw localObject2;
      localObject3 = finally;
      throw localObject3;
      localObject4 = finally;
      throw localObject4;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDbManager
 * JD-Core Version:    0.7.0.1
 */