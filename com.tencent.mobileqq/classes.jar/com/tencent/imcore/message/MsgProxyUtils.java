package com.tencent.imcore.message;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.msgproxy.MsgProxyUtilsDummyCallback;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class MsgProxyUtils
{
  public static MsgProxyUtils.Callback a;
  static Comparator<MessageRecord> a;
  public static final int[] a;
  public static final int[] b;
  public static final int[] c;
  public static final int[] d;
  public static final int[] e;
  public static final int[] f;
  public static final int[] g;
  public static final int[] h;
  public static final int[] i;
  public static final int[] j;
  public static final int[] k;
  public static final int[] l;
  
  static
  {
    jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback = new MsgProxyUtilsDummyCallback();
    jdField_a_of_type_ArrayOfInt = new int[] { -2031, -2035, -2036, -2038, -2042, -2043, -5040, -5021 };
    b = new int[] { -3006, -2035, -2036, -2038 };
    c = new int[] { -1004, -1012, -4002, -4003, -4004, -1047, -1013, -2030, -4009, -4012, -1016, -1017, -1050, -2021, -1041, -1043, -1044, -1045, -5000, -5001, 1018, -2016, 2024, -2042, -5005, -5006, -1046, -3013, -3014, -2029, -2034, -2033, -2043, -2041, -5011, -2049, -2063, -3016 };
    d = new int[] { -4003, -4020, -4004, -4009, -5011 };
    e = new int[] { -1000, -2000, -2002, -2005, -1035, -1036, -1037, -20000, -2007, -2011, -2010, -1051 };
    f = new int[] { -2000, -2002, -2007, -2058, -2011, -2020, -2022, -1051, -1035, -2057, -7001, -2071 };
    g = new int[] { -1001, -2009, -2016, -4008 };
    h = new int[] { -2030, -1047, -5040 };
    i = new int[] { -5040, -5020, -5021, -5022, -5023 };
    j = new int[] { 1000, 1004, 1020 };
    k = new int[] { 1001, 10002, 1010 };
    l = new int[] { 0, 1, 3000, 1025, 1024 };
    InitMsgModule.a();
    jdField_a_of_type_JavaUtilComparator = new MsgProxyUtils.1();
  }
  
  private static int a()
  {
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.a();
  }
  
  public static int a(String paramString)
  {
    if (paramString.startsWith("mr_discusssion")) {
      return 3000;
    }
    if (paramString.startsWith("mr_friend")) {
      return 0;
    }
    return 1;
  }
  
  public static int a(List<MessageRecord> paramList, MessageCache paramMessageCache)
  {
    int n;
    if ((paramList == null) || (paramList.isEmpty())) {
      n = 0;
    }
    HashSet localHashSet;
    int m;
    do
    {
      return n;
      localHashSet = new HashSet();
      paramList = paramList.iterator();
      m = 0;
      n = m;
    } while (!paramList.hasNext());
    MessageRecord localMessageRecord = (MessageRecord)paramList.next();
    if ((!localMessageRecord.isread) && (!localMessageRecord.isLongMsg())) {
      m += 1;
    }
    for (;;)
    {
      break;
      n = m;
      if (!localMessageRecord.isread)
      {
        n = m;
        if (localMessageRecord.isLongMsg())
        {
          if (paramMessageCache.a(localMessageRecord)) {
            break;
          }
          n = m;
          if (!localHashSet.contains(UinTypeUtil.a(localMessageRecord)))
          {
            n = m + 1;
            localHashSet.add(UinTypeUtil.a(localMessageRecord));
          }
        }
      }
      m = n;
    }
  }
  
  @NonNull
  private static MessageRecord a(ArrayList<MessageRecord> paramArrayList)
  {
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.a(paramArrayList);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return AppConstants.LBS_HELLO_UIN;
    case 1001: 
    case 10002: 
      return AppConstants.LBS_HELLO_UIN;
    case 1010: 
      return AppConstants.DATE_UIN;
    }
    return AppConstants.SAME_STATE_BOX_UIN;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1004))
    {
      if (paramMessageRecord.isSend()) {
        return paramMessageRecord.selfuin;
      }
      return paramMessageRecord.frienduin;
    }
    if ((paramMessageRecord.istroop == 1) && (g(paramMessageRecord))) {
      return "80000000";
    }
    if (TextUtils.equals(AppConstants.FILE_ASSISTANT_UIN, paramMessageRecord.senderuin)) {
      paramMessageRecord.senderuin = paramMessageRecord.selfuin;
    }
    return paramMessageRecord.senderuin;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, 15);
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList, boolean paramBoolean, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    if (paramBoolean) {
      Collections.sort(paramList, new MsgProxyUtils.2());
    }
    long l1 = ((MessageRecord)paramList.get(paramList.size() - 1)).shmsgseq;
    int n = paramList.size() - 1;
    int m = 0;
    int i1;
    while (n >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(n);
      if ((k(localMessageRecord.msgtype)) && (localMessageRecord.shmsgseq == 0L))
      {
        localArrayList.add(0, paramList.get(n));
        i1 = m;
        n -= 1;
        m = i1;
      }
      else if (l1 - localMessageRecord.shmsgseq <= 1L)
      {
        if ((l1 != localMessageRecord.shmsgseq) || (n >= paramList.size() - 1)) {
          break label224;
        }
      }
    }
    for (;;)
    {
      l1 = ((MessageRecord)paramList.get(n)).shmsgseq;
      localArrayList.add(0, paramList.get(n));
      i1 = m;
      if (m < paramInt) {
        break;
      }
      return localArrayList;
      label224:
      m += 1;
    }
  }
  
  public static void a(MsgProxyUtils.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback = paramCallback;
  }
  
  public static void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramMessageRecord.extLong |= 0x1;
      paramMessageRecord.saveExtInfoToExtStr("one_way", "true");
      return;
    }
    paramMessageRecord.removeExtInfoToExtStr("one_way");
  }
  
  public static void a(String paramString, int paramInt, List<MessageRecord> paramList, MessageCache paramMessageCache)
  {
    try
    {
      b(paramString, paramInt, paramList, paramMessageCache);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.msg.MsgProxyUtils", 1, "mergeLongMsg: ", paramString);
    }
  }
  
  private static void a(List<MessageRecord> paramList)
  {
    int m = 0;
    while (m < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(m);
      QLog.d("Q.msg.MsgProxyUtils", 1, "backupAioMsgList = [" + m + "] = " + localMessageRecord);
      m += 1;
    }
  }
  
  private static void a(List<MessageRecord> paramList1, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList2)
  {
    try
    {
      paramList1.add(paramInt, paramMessageRecord);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.msg.MsgProxyUtils", 1, "addToTailWhenException: ", localException);
      a(paramList2);
      paramList1.add(paramMessageRecord);
      jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.a(localException, paramList2);
    }
  }
  
  public static <T extends MessageRecord> void a(List<T> paramList, T paramT, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if ((paramT.istroop == 3000) || (paramT.istroop == 1)) {
        c(paramList, paramT, paramBoolean);
      }
    }
    else {
      return;
    }
    if (UinTypeUtil.b(paramT.istroop))
    {
      b(paramList, paramT, paramBoolean);
      return;
    }
    paramList.add(paramT);
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = j;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return ((UinTypeUtil.a(paramInt1) == 1001) || (UinTypeUtil.a(paramInt1) == 10002)) && (paramInt2 != -3001) && (paramInt2 != -3000) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != -1003);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    int[] arrayOfInt = c;
    int n = arrayOfInt.length;
    int m = 0;
    while (m < n)
    {
      if (arrayOfInt[m] == paramMessageRecord.msgtype) {
        return true;
      }
      m += 1;
    }
    return f(paramMessageRecord);
  }
  
  private static <T extends MessageRecord> boolean a(T paramT, MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.a(paramT, paramMessageRecord);
  }
  
  public static boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramMessageRecord1.msgtype == paramMessageRecord2.msgtype) {
      if (paramMessageRecord1.msgUid != 0L) {
        if (paramBoolean)
        {
          bool1 = bool2;
          if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
          {
            bool1 = bool2;
            if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
              bool1 = true;
            }
          }
          paramBoolean = bool1;
          if (!bool1) {
            if (paramMessageRecord1.msgtype != -2005)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.msgtype != -2002) {}
            }
            else if (paramMessageRecord2.istroop == 1008)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.msgtype != -2005) {}
            }
            else
            {
              paramBoolean = bool1;
              if (c(paramMessageRecord1, paramMessageRecord2)) {
                paramBoolean = true;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (QLog.isColorLevel())) {
        QLog.w("Q.msg.MsgProxyUtils", 2, "friend---------------msgFilter istroop: " + paramMessageRecord2.istroop + " friendUin: " + paramMessageRecord2.frienduin + " senderUin: " + paramMessageRecord2.senderuin + " LOC_shmsgseq: " + paramMessageRecord1.shmsgseq + " NEW_shmsgseq:" + paramMessageRecord1.shmsgseq + " LOC_msgType: " + paramMessageRecord1.msgtype + " NEW_msgType" + paramMessageRecord2.msgtype + " LOC_msgtime: " + paramMessageRecord1.time + " NEW_msgtime:" + paramMessageRecord2.time + " LOC_msgUid:" + paramMessageRecord1.msgUid + " NEW_msgUid:" + paramMessageRecord2.msgUid + " LOC_msgContent: " + paramMessageRecord1.getLogColorContent() + " NEW_msgContent:" + paramMessageRecord2.getLogColorContent());
      }
      return paramBoolean;
      paramBoolean = bool1;
      if (c(paramMessageRecord1, paramMessageRecord2))
      {
        paramBoolean = true;
        continue;
        paramBoolean = bool1;
        if (c(paramMessageRecord1, paramMessageRecord2))
        {
          paramBoolean = true;
          continue;
          if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2007))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -2001) && (paramMessageRecord2.msgtype == -2000))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.time == paramMessageRecord2.time)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2011))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2022))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2025))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if (e(paramMessageRecord1))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord2.msgtype == -1051) && ((paramMessageRecord1.msgtype == -1000) || (paramMessageRecord1.msgtype == -2011)))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -2011) && (paramMessageRecord2.msgtype == -1000))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -1035) && (paramMessageRecord2.msgtype == -1051))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord2.msgtype == -1035) && (paramMessageRecord1.msgtype == -1051))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -5012))
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
            {
              paramBoolean = bool1;
              if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                paramBoolean = true;
              }
            }
          }
          else
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgtype == -1000)
            {
              paramBoolean = bool1;
              if (paramMessageRecord2.msgtype == -2071)
              {
                paramBoolean = bool1;
                if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
                {
                  paramBoolean = bool1;
                  if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
                    paramBoolean = true;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if ((paramMessageRecord1.frienduin == null) || (!paramMessageRecord1.frienduin.equals(paramMessageRecord2.frienduin))) {
      paramBoolean1 = false;
    }
    label68:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return paramBoolean1;
                                if (paramBoolean1) {
                                  break label285;
                                }
                                if (paramBoolean2) {
                                  break label68;
                                }
                                if (Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) >= 30L) {
                                  break;
                                }
                                paramBoolean1 = bool;
                              } while (b(paramMessageRecord1, paramMessageRecord2));
                              return false;
                              if (paramMessageRecord1.shmsgseq != paramMessageRecord2.shmsgseq) {
                                break;
                              }
                              paramBoolean1 = bool;
                            } while (paramMessageRecord1.msgtype == paramMessageRecord2.msgtype);
                            if (paramMessageRecord1.msgtype != -1000) {
                              break;
                            }
                            paramBoolean1 = bool;
                          } while (paramMessageRecord2.msgtype == -2007);
                          paramBoolean1 = bool;
                        } while (paramMessageRecord1.msgtype == -2006);
                        paramBoolean1 = bool;
                      } while (paramMessageRecord2.msgtype == -2006);
                      if (paramMessageRecord1.msgtype != -1000) {
                        break;
                      }
                      paramBoolean1 = bool;
                    } while (paramMessageRecord2.msgtype == -2011);
                    paramBoolean1 = bool;
                  } while (e(paramMessageRecord1));
                  if (paramMessageRecord2.msgtype != -1051) {
                    break;
                  }
                  paramBoolean1 = bool;
                } while (paramMessageRecord1.msgtype == -1000);
                paramBoolean1 = bool;
              } while (paramMessageRecord1.msgtype == -2011);
              if (paramMessageRecord1.msgtype != -2011) {
                break;
              }
              paramBoolean1 = bool;
            } while (paramMessageRecord2.msgtype == -1000);
            if (paramMessageRecord2.msgtype != -1051) {
              break;
            }
            paramBoolean1 = bool;
          } while (paramMessageRecord1.msgtype == -1035);
          if (paramMessageRecord1.msgtype != -1051) {
            break;
          }
          paramBoolean1 = bool;
        } while (paramMessageRecord2.msgtype == -1035);
        return false;
        return false;
        if (!paramMessageRecord1.isSendFromLocal()) {
          return false;
        }
        if ((paramMessageRecord1.extraflag != 32772) && (paramMessageRecord1.extraflag != 32768)) {
          if (paramMessageRecord1.msgtype == -1035)
          {
            if (paramMessageRecord1.extraflag != 32770) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        if (paramMessageRecord1.msgtype == -2006) {
          return false;
        }
        if ((paramMessageRecord1.senderuin == null) || (!paramMessageRecord1.senderuin.equals(paramMessageRecord2.senderuin))) {
          return false;
        }
        if ((paramMessageRecord2.msgUid == 0L) || (paramMessageRecord1.msgUid != paramMessageRecord2.msgUid)) {
          break;
        }
        paramBoolean1 = bool;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MsgProxyUtils", 2, "compTroopMsgContent RewriteSeq: find msg by uid=" + paramMessageRecord1.msgUid);
      return true;
      if ((Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) >= a() + 30) && (Math.abs(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) >= 2L)) {
        break;
      }
      paramBoolean1 = bool;
    } while (b(paramMessageRecord1, paramMessageRecord2));
    label285:
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return AppConstants.MSG_BOX_INTERACT_UIN.equals(paramString);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    return (paramString != null) && (paramString.length() >= 6) && ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000));
  }
  
  public static boolean a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    int n = paramList.size();
    int m = 0;
    while (m < n)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(m);
      if ((!a(localMessageRecord)) && (localMessageRecord.msgtype != -2006)) {
        return true;
      }
      m += 1;
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    return (UinTypeUtil.a(paramMessageRecord)) && (!UinTypeUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop)) && (b(paramAppRuntime, paramMessageRecord));
  }
  
  private static void b(String paramString, int paramInt, List<MessageRecord> paramList, MessageCache paramMessageCache)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList1 = new ArrayList(paramList);
      Object localObject2 = new ArrayList();
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject3 = paramList.iterator();
      int m = 0;
      int n = 0;
      Object localObject4;
      label170:
      int i1;
      Object localObject1;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        String str1;
        if (((MessageRecord)localObject4).isLongMsg())
        {
          str1 = UinTypeUtil.a((MessageRecord)localObject4);
          if (localHashMap.containsKey(str1)) {
            if (Math.abs(((MessageRecord)((ArrayList)localHashMap.get(str1)).get(0)).time - ((MessageRecord)localObject4).time) <= 480L)
            {
              ((ArrayList)localHashMap.get(str1)).add(localObject4);
              ((List)localObject2).add(localObject4);
              i1 = m;
              m = n;
              n = i1;
            }
          }
        }
        for (;;)
        {
          i1 = m;
          m = n;
          n = i1;
          break;
          i1 = m + 1;
          String str2 = UinTypeUtil.b(str1, i1);
          localHashMap.put(str2, localHashMap.get(str1));
          localObject1 = null;
          m = 0;
          for (;;)
          {
            if (m < localArrayList2.size())
            {
              localObject1 = (Pair)localArrayList2.get(m);
              if (!((String)((Pair)localObject1).first).equals(str1)) {}
            }
            else
            {
              if (localObject1 != null)
              {
                localArrayList2.remove(m);
                localArrayList2.add(m, new Pair(str2, ((Pair)localObject1).second));
              }
              localObject1 = new ArrayList();
              ((ArrayList)localObject1).add(localObject4);
              localHashMap.put(str1, localObject1);
              localArrayList2.add(new Pair(str1, Integer.valueOf(n)));
              m = i1;
              break;
            }
            m += 1;
          }
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(localObject4);
          localHashMap.put(str1, localObject1);
          localArrayList2.add(new Pair(str1, Integer.valueOf(n)));
          break label170;
          i1 = n + 1;
          n = m;
          m = i1;
        }
      }
      paramList.removeAll((Collection)localObject2);
      if ((!localHashMap.isEmpty()) && (!localArrayList2.isEmpty()))
      {
        if (paramMessageCache.a(paramString, paramInt) != null)
        {
          localObject1 = new ArrayList();
          localObject2 = localHashMap.keySet().iterator();
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label778;
            }
            localObject3 = (String)((Iterator)localObject2).next();
            localObject4 = (ArrayList)localHashMap.get(localObject3);
            if (!((ArrayList)localObject4).isEmpty()) {
              if ((((MessageRecord)((ArrayList)localObject4).get(0)).longMsgCount <= ((ArrayList)localObject4).size()) || (((MessageRecord)((ArrayList)localObject4).get(0)).isSendFromLocal()))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: complete online msg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + (String)localObject3);
                }
                paramMessageCache.a(paramString, paramInt, (String)localObject3);
              }
              else if (paramMessageCache.a(paramString, paramInt, (String)localObject3))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: incomplete online msg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + (String)localObject3);
                }
                ((ArrayList)localObject1).add(localObject3);
                localObject4 = localArrayList2.iterator();
                if (((Iterator)localObject4).hasNext())
                {
                  if (!TextUtils.equals((CharSequence)((Pair)((Iterator)localObject4).next()).first, (CharSequence)localObject3)) {
                    break;
                  }
                  ((Iterator)localObject4).remove();
                }
              }
            }
          }
          label778:
          if (!((ArrayList)localObject1).isEmpty())
          {
            paramMessageCache = ((ArrayList)localObject1).iterator();
            while (paramMessageCache.hasNext()) {
              localHashMap.remove((String)paramMessageCache.next());
            }
          }
        }
        n = localArrayList2.size() - 1;
        while (n >= 0)
        {
          paramMessageCache = (Pair)localArrayList2.get(n);
          localObject2 = (ArrayList)localHashMap.get(paramMessageCache.first);
          try
          {
            Collections.sort((List)localObject2, jdField_a_of_type_JavaUtilComparator);
            localObject1 = new ArrayList();
            localObject2 = ((ArrayList)localObject2).iterator();
            m = 0;
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label1096;
              }
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if (!c((MessageRecord)localObject3)) {
                break;
              }
              ((ArrayList)localObject1).add(localObject3);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.MsgProxyUtils", 2, "sort long msg error", localException);
                continue;
                i1 = m;
                if (!localException.isEmpty())
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + UinTypeUtil.a((MessageRecord)localException.get(0)));
                  }
                  localObject4 = a(localException);
                  a(paramList, m + ((Integer)paramMessageCache.second).intValue(), (MessageRecord)localObject4, localArrayList1);
                  localException.clear();
                  i1 = m + 1;
                }
                a(paramList, i1 + ((Integer)paramMessageCache.second).intValue(), (MessageRecord)localObject3, localArrayList1);
                m = i1 + 1;
              }
            }
            label1096:
            if (!localException.isEmpty())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + UinTypeUtil.a((MessageRecord)localException.get(0)));
              }
              localObject2 = a(localException);
              a(paramList, ((Integer)paramMessageCache.second).intValue() + m, (MessageRecord)localObject2, localArrayList1);
              localException.clear();
            }
            n -= 1;
          }
        }
      }
    }
  }
  
  public static <T extends MessageRecord> void b(List<T> paramList, T paramT, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxyUtils", 2, "insertToListByTime, list is null");
      }
      return;
    }
    Iterator localIterator = paramList.iterator();
    int m = 0;
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1 = bool2;
      MessageRecord localMessageRecord;
      if (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.time <= paramT.time) {
          break label89;
        }
        bool1 = true;
      }
      for (;;)
      {
        if (bool1) {
          break label136;
        }
        paramList.add(paramT);
        return;
        label89:
        if (localMessageRecord.time != paramT.time) {
          break;
        }
        bool2 = a(paramT, localMessageRecord);
        bool1 = bool2;
        if (!bool2)
        {
          if (paramBoolean) {
            break;
          }
          bool1 = true;
        }
      }
      m += 1;
    }
    label136:
    paramList.add(m, paramT);
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = UinTypeUtil.d;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    int[] arrayOfInt = UinTypeUtil.e;
    int n = arrayOfInt.length;
    int m = 0;
    while (m < n)
    {
      if (arrayOfInt[m] == paramMessageRecord.msgtype) {
        return true;
      }
      m += 1;
    }
    return f(paramMessageRecord);
  }
  
  private static boolean b(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.msgtype != paramMessageRecord2.msgtype) {
      return false;
    }
    String str1 = paramMessageRecord1.msg;
    String str2 = paramMessageRecord2.msg;
    if (paramMessageRecord2.msgtype == -1000) {
      return TextUtils.equals(str1, str2);
    }
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.a(paramMessageRecord1, paramMessageRecord2, str1, str2);
  }
  
  public static boolean b(String paramString)
  {
    return AppConstants.MSG_BOX_FOLLOW_UIN.equals(paramString);
  }
  
  private static boolean b(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.a(paramAppRuntime, paramMessageRecord);
  }
  
  public static <T extends MessageRecord> void c(List<T> paramList, T paramT, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxyUtils", 2, "insertToListBySeq, list is null");
      }
      return;
    }
    Iterator localIterator = paramList.iterator();
    int m = 0;
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1 = bool2;
      MessageRecord localMessageRecord;
      if (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.shmsgseq <= paramT.shmsgseq) {
          break label89;
        }
        bool1 = true;
      }
      for (;;)
      {
        if (bool1) {
          break label136;
        }
        paramList.add(paramT);
        return;
        label89:
        if (localMessageRecord.shmsgseq != paramT.shmsgseq) {
          break;
        }
        bool2 = a(paramT, localMessageRecord);
        bool1 = bool2;
        if (!bool2)
        {
          if (paramBoolean) {
            break;
          }
          bool1 = true;
        }
      }
      m += 1;
    }
    label136:
    paramList.add(m, paramT);
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = UinTypeUtil.b;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.b(paramMessageRecord);
  }
  
  private static boolean c(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    boolean bool = true;
    if (paramMessageRecord1.msgtype == -1034) {
      bool = b(paramMessageRecord1, paramMessageRecord2);
    }
    do
    {
      return bool;
      if (paramMessageRecord1.msgtype == -1042) {
        return b(paramMessageRecord1, paramMessageRecord2);
      }
      if ((paramMessageRecord1.msgtype != -2000) && (paramMessageRecord1.msgtype != -1000)) {
        break;
      }
    } while ((Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) < 30L) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) && (b(paramMessageRecord1, paramMessageRecord2)));
    do
    {
      do
      {
        return false;
        if (paramMessageRecord1.msgtype == -2002) {
          return b(paramMessageRecord1, paramMessageRecord2);
        }
        if (paramMessageRecord1.msgtype == -2005) {
          return b(paramMessageRecord1, paramMessageRecord2);
        }
        if (paramMessageRecord1.msgtype == -5007) {
          return b(paramMessageRecord1, paramMessageRecord2);
        }
      } while ((Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) >= 30L) || (paramMessageRecord1.shmsgseq != paramMessageRecord2.shmsgseq));
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MsgProxyUtils", 2, "other equal : mr.shmsgseq = " + paramMessageRecord1.shmsgseq);
      }
    } while (!b(paramMessageRecord1, paramMessageRecord2));
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.equals("1822701914");
  }
  
  public static boolean d(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = i;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  public static boolean d(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype == -5008) && (paramMessageRecord.shmsgseq == 0L)) {
      return "1".equals(paramMessageRecord.getExtInfoFromExtStr("troop_mini_app_sys"));
    }
    return false;
  }
  
  public static boolean e(int paramInt)
  {
    boolean bool2 = d(paramInt);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = n(paramInt);
    }
    return bool1;
  }
  
  private static boolean e(MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.d(paramMessageRecord);
  }
  
  public static boolean f(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  private static boolean f(MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.c(paramMessageRecord);
  }
  
  public static boolean g(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = b;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  private static boolean g(MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.a(paramMessageRecord);
  }
  
  public static boolean h(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = e;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  public static boolean i(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = f;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  public static boolean j(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = g;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  public static boolean k(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = h;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  public static boolean l(int paramInt)
  {
    return paramInt == 1025;
  }
  
  public static boolean m(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = l;
    int n = arrayOfInt.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfInt[m] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  private static boolean n(int paramInt)
  {
    return jdField_a_of_type_ComTencentImcoreMessageMsgProxyUtils$Callback.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyUtils
 * JD-Core Version:    0.7.0.1
 */