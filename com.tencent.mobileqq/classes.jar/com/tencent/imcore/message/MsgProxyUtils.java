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
  public static MsgProxyUtils.Callback a = new MsgProxyUtilsDummyCallback();
  public static final int[] b = { -2031, -2035, -2036, -2038, -2042, -2043, -5040, -5021 };
  public static final int[] c = { -3006, -2035, -2036, -2038 };
  public static final int[] d = { -1004, -1012, -4002, -4003, -4004, -1047, -1013, -2030, -4009, -4012, -1016, -1017, -1050, -2021, -1041, -1043, -1044, -1045, -5000, -5001, 1018, -2016, 2024, -2042, -5005, -5006, -1046, -3013, -3014, -2029, -2034, -2033, -2043, -2041, -5011, -2049, -2063, -3016 };
  public static final int[] e = { -4003, -4020, -4004, -4009, -5011 };
  public static final int[] f = { -1000, -2000, -2002, -2005, -1035, -1036, -1037, -20000, -2007, -2011, -1051, -8018 };
  public static final int[] g = { -2000, -2002, -2007, -2058, -2011, -2020, -2022, -1051, -1035, -2057, -7001, -2071, -8018 };
  public static final int[] h = { -1001, -2009, -2016, -4008 };
  public static final int[] i = { -2030, -1047, -5040 };
  public static final int[] j = { -5040, -5020, -5021, -5022, -5023 };
  public static final int[] k = { 1000, 1004, 1020 };
  public static final int[] l = { 1001, 10002, 1010 };
  public static final int[] m = { 0, 1, 3000, 1025, 1024, 10007 };
  static Comparator<MessageRecord> n = new MsgProxyUtils.1();
  
  static
  {
    InitMsgModule.a();
  }
  
  private static int a()
  {
    return a.a();
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
    int i2 = 0;
    int i1 = 0;
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return 0;
      }
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      for (;;)
      {
        i2 = i1;
        if (!paramList.hasNext()) {
          break;
        }
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((!localMessageRecord.isread) && (!localMessageRecord.isLongMsg()))
        {
          i1 += 1;
        }
        else if ((!localMessageRecord.isread) && (localMessageRecord.isLongMsg()) && (!paramMessageCache.b(localMessageRecord)) && (!localHashSet.contains(UinTypeUtil.a(localMessageRecord))))
        {
          i1 += 1;
          localHashSet.add(UinTypeUtil.a(localMessageRecord));
        }
      }
    }
    return i2;
  }
  
  @NonNull
  private static MessageRecord a(ArrayList<MessageRecord> paramArrayList)
  {
    return a.a(paramArrayList);
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, 15);
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList, boolean paramBoolean, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localArrayList;
      }
      if (paramBoolean) {
        Collections.sort(paramList, new MsgProxyUtils.2());
      }
      long l1 = ((MessageRecord)paramList.get(paramList.size() - 1)).shmsgseq;
      int i2 = paramList.size() - 1;
      int i3;
      for (int i1 = 0; i2 >= 0; i1 = i3)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i2);
        if ((k(localMessageRecord.msgtype)) && (localMessageRecord.shmsgseq == 0L))
        {
          localArrayList.add(0, paramList.get(i2));
          i3 = i1;
        }
        else
        {
          if (l1 - localMessageRecord.shmsgseq > 1L) {
            break;
          }
          if ((l1 != localMessageRecord.shmsgseq) || (i2 >= paramList.size() - 1)) {
            i1 += 1;
          }
          l1 = ((MessageRecord)paramList.get(i2)).shmsgseq;
          localArrayList.add(0, paramList.get(i2));
          i3 = i1;
          if (i1 >= paramInt) {
            return localArrayList;
          }
        }
        i2 -= 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(MsgProxyUtils.Callback paramCallback)
  {
    a = paramCallback;
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
      b(paramList2);
      paramList1.add(paramMessageRecord);
      a.a(localException, paramList2);
    }
  }
  
  public static <T extends MessageRecord> void a(List<T> paramList, T paramT, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if ((paramT.istroop != 3000) && (paramT.istroop != 1))
      {
        if (UinTypeUtil.b(paramT.istroop))
        {
          b(paramList, paramT, paramBoolean);
          return;
        }
        if (paramT.istroop == 10014)
        {
          c(paramList, paramT, paramBoolean);
          return;
        }
        paramList.add(paramT);
        return;
      }
      c(paramList, paramT, paramBoolean);
    }
  }
  
  public static boolean a(int paramInt)
  {
    int[] arrayOfInt = k;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return ((UinTypeUtil.e(paramInt1) == 1001) || (UinTypeUtil.e(paramInt1) == 10002)) && (paramInt2 != -3001) && (paramInt2 != -3000) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != -1003);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    int[] arrayOfInt = d;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramMessageRecord.msgtype) {
        return true;
      }
      i1 += 1;
    }
    return g(paramMessageRecord);
  }
  
  private static <T extends MessageRecord> boolean a(T paramT, MessageRecord paramMessageRecord)
  {
    return a.a(paramT, paramMessageRecord);
  }
  
  public static boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean)
  {
    int i1 = paramMessageRecord1.msgtype;
    int i2 = paramMessageRecord2.msgtype;
    boolean bool1 = true;
    boolean bool2 = false;
    if (i1 == i2)
    {
      if (paramMessageRecord1.msgUid != 0L)
      {
        if (paramBoolean)
        {
          paramBoolean = bool2;
          if (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid)
          {
            paramBoolean = bool2;
            if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) {
              paramBoolean = true;
            }
          }
          if ((!paramBoolean) && ((paramMessageRecord1.msgtype == -2005) || (paramMessageRecord1.msgtype == -2002)) && ((paramMessageRecord2.istroop != 1008) || (paramMessageRecord1.msgtype == -2005)) && (c(paramMessageRecord1, paramMessageRecord2)))
          {
            paramBoolean = bool1;
            break label756;
          }
          break label756;
        }
        if (c(paramMessageRecord1, paramMessageRecord2))
        {
          paramBoolean = bool1;
          break label756;
        }
      }
      else if (c(paramMessageRecord1, paramMessageRecord2))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2007))
    {
      if ((paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord1.msgtype == -2001) && (paramMessageRecord2.msgtype == -2000))
    {
      if ((paramMessageRecord1.time == paramMessageRecord2.time) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2011))
    {
      if ((paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2022))
    {
      if ((paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2025))
    {
      if ((paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if (f(paramMessageRecord1))
    {
      if ((paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord2.msgtype == -1051) && ((paramMessageRecord1.msgtype == -1000) || (paramMessageRecord1.msgtype == -2011)))
    {
      if ((paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord1.msgtype == -2011) && (paramMessageRecord2.msgtype == -1000))
    {
      if ((paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord1.msgtype == -1035) && (paramMessageRecord2.msgtype == -1051))
    {
      if ((paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord2.msgtype == -1035) && (paramMessageRecord1.msgtype == -1051))
    {
      if ((paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -5012))
    {
      if ((paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        paramBoolean = bool1;
        break label756;
      }
    }
    else if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2071) && (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
    {
      paramBoolean = bool1;
      break label756;
    }
    paramBoolean = false;
    label756:
    if ((paramBoolean) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("friend---------------msgFilter istroop: ");
      localStringBuilder.append(paramMessageRecord2.istroop);
      localStringBuilder.append(" friendUin: ");
      localStringBuilder.append(paramMessageRecord2.frienduin);
      localStringBuilder.append(" senderUin: ");
      localStringBuilder.append(paramMessageRecord2.senderuin);
      localStringBuilder.append(" LOC_shmsgseq: ");
      localStringBuilder.append(paramMessageRecord1.shmsgseq);
      localStringBuilder.append(" NEW_shmsgseq:");
      localStringBuilder.append(paramMessageRecord1.shmsgseq);
      localStringBuilder.append(" LOC_msgType: ");
      localStringBuilder.append(paramMessageRecord1.msgtype);
      localStringBuilder.append(" NEW_msgType");
      localStringBuilder.append(paramMessageRecord2.msgtype);
      localStringBuilder.append(" LOC_msgtime: ");
      localStringBuilder.append(paramMessageRecord1.time);
      localStringBuilder.append(" NEW_msgtime:");
      localStringBuilder.append(paramMessageRecord2.time);
      localStringBuilder.append(" LOC_msgUid:");
      localStringBuilder.append(paramMessageRecord1.msgUid);
      localStringBuilder.append(" NEW_msgUid:");
      localStringBuilder.append(paramMessageRecord2.msgUid);
      localStringBuilder.append(" LOC_msgContent: ");
      localStringBuilder.append(paramMessageRecord1.getLogColorContent());
      localStringBuilder.append(" NEW_msgContent:");
      localStringBuilder.append(paramMessageRecord2.getLogColorContent());
      QLog.w("Q.msg.MsgProxyUtils", 2, localStringBuilder.toString());
    }
    return paramBoolean;
  }
  
  public static boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramMessageRecord1.frienduin;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (str != null)
    {
      if (!paramMessageRecord1.frienduin.equals(paramMessageRecord2.frienduin)) {
        return false;
      }
      if (!paramBoolean1)
      {
        if (!paramBoolean2)
        {
          paramBoolean1 = bool2;
          if (Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) < 30L)
          {
            paramBoolean1 = bool2;
            if (b(paramMessageRecord1, paramMessageRecord2)) {
              paramBoolean1 = true;
            }
          }
          return paramBoolean1;
        }
        if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq)
        {
          if (paramMessageRecord1.msgtype == paramMessageRecord2.msgtype) {
            return true;
          }
          if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2007)) {
            return true;
          }
          if (paramMessageRecord1.msgtype != -2006)
          {
            if (paramMessageRecord2.msgtype == -2006) {
              return true;
            }
            if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2011)) {
              return true;
            }
            if (f(paramMessageRecord1)) {
              return true;
            }
            if ((paramMessageRecord2.msgtype == -1051) && ((paramMessageRecord1.msgtype == -1000) || (paramMessageRecord1.msgtype == -2011))) {
              return true;
            }
            if ((paramMessageRecord1.msgtype == -2011) && (paramMessageRecord2.msgtype == -1000)) {
              return true;
            }
            if ((paramMessageRecord2.msgtype == -1051) && (paramMessageRecord1.msgtype == -1035)) {
              return true;
            }
            return (paramMessageRecord1.msgtype == -1051) && (paramMessageRecord2.msgtype == -1035);
          }
          return true;
        }
        return false;
      }
      if (!paramMessageRecord1.isSendFromLocal()) {
        return false;
      }
      if ((!TextUtils.equals(paramMessageRecord1.getExtInfoFromExtStr("key_troop_sending_message_success"), "1")) && (paramMessageRecord1.extraflag != 32772) && (paramMessageRecord1.extraflag != 32768) && ((paramMessageRecord1.msgtype != -1035) || (paramMessageRecord1.extraflag != 32770))) {
        return false;
      }
      if (paramMessageRecord1.msgtype == -2006) {
        return false;
      }
      bool1 = bool3;
      if (paramMessageRecord1.senderuin != null)
      {
        if (!paramMessageRecord1.senderuin.equals(paramMessageRecord2.senderuin)) {
          return false;
        }
        if ((paramMessageRecord2.msgUid != 0L) && (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid))
        {
          if (QLog.isColorLevel())
          {
            paramMessageRecord2 = new StringBuilder();
            paramMessageRecord2.append("compTroopMsgContent RewriteSeq: find msg by uid=");
            paramMessageRecord2.append(paramMessageRecord1.msgUid);
            QLog.d("Q.msg.MsgProxyUtils", 2, paramMessageRecord2.toString());
          }
          return true;
        }
        if (Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) >= a() + 30)
        {
          bool1 = bool3;
          if (Math.abs(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) >= 2L) {}
        }
        else
        {
          bool1 = bool3;
          if (b(paramMessageRecord1, paramMessageRecord2)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    return (paramString != null) && (paramString.length() >= 6) && ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000));
  }
  
  public static boolean a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return false;
      }
      int i2 = paramList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i1);
        if ((!a(localMessageRecord)) && (localMessageRecord.msgtype != -2006)) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    return (UinTypeUtil.c(paramMessageRecord)) && (!UinTypeUtil.c(paramMessageRecord.frienduin, paramMessageRecord.istroop)) && (b(paramAppRuntime, paramMessageRecord));
  }
  
  private static void b(String paramString, int paramInt, List<MessageRecord> paramList, MessageCache paramMessageCache)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList2 = new ArrayList(paramList);
      Object localObject2 = new ArrayList();
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList3 = new ArrayList();
      Object localObject3 = paramList.iterator();
      int i1 = 0;
      int i2 = 0;
      Object localObject4;
      Object localObject1;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        if (((MessageRecord)localObject4).isLongMsg())
        {
          String str1 = UinTypeUtil.a((MessageRecord)localObject4);
          if (localHashMap.containsKey(str1))
          {
            if (Math.abs(((MessageRecord)((ArrayList)localHashMap.get(str1)).get(0)).time - ((MessageRecord)localObject4).time) <= 480L)
            {
              ((ArrayList)localHashMap.get(str1)).add(localObject4);
            }
            else
            {
              int i3 = i2 + 1;
              String str2 = UinTypeUtil.b(str1, i3);
              localHashMap.put(str2, localHashMap.get(str1));
              localObject1 = null;
              i2 = 0;
              while (i2 < localArrayList3.size())
              {
                localObject1 = (Pair)localArrayList3.get(i2);
                if (((String)((Pair)localObject1).first).equals(str1)) {
                  break;
                }
                i2 += 1;
              }
              if (localObject1 != null)
              {
                localArrayList3.remove(i2);
                localArrayList3.add(i2, new Pair(str2, ((Pair)localObject1).second));
              }
              localObject1 = new ArrayList();
              ((ArrayList)localObject1).add(localObject4);
              localHashMap.put(str1, localObject1);
              localArrayList3.add(new Pair(str1, Integer.valueOf(i1)));
              i2 = i3;
            }
          }
          else
          {
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(localObject4);
            localHashMap.put(str1, localObject1);
            localArrayList3.add(new Pair(str1, Integer.valueOf(i1)));
          }
          ((List)localObject2).add(localObject4);
        }
        else
        {
          i1 += 1;
        }
      }
      paramList.removeAll((Collection)localObject2);
      if ((!localHashMap.isEmpty()) && (!localArrayList3.isEmpty()))
      {
        if (paramMessageCache.d(paramString, paramInt) != null)
        {
          localObject2 = new ArrayList();
          localObject1 = localHashMap.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            localObject4 = (ArrayList)localHashMap.get(localObject3);
            if (!((ArrayList)localObject4).isEmpty()) {
              if ((((MessageRecord)((ArrayList)localObject4).get(0)).longMsgCount > ((ArrayList)localObject4).size()) && (!((MessageRecord)((ArrayList)localObject4).get(0)).isSendFromLocal()))
              {
                if (paramMessageCache.a(paramString, paramInt, (String)localObject3))
                {
                  if (QLog.isColorLevel())
                  {
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("mergeLongMsg: incomplete online msg: uin=");
                    ((StringBuilder)localObject4).append(paramString);
                    ((StringBuilder)localObject4).append(",istroop=");
                    ((StringBuilder)localObject4).append(paramInt);
                    ((StringBuilder)localObject4).append(",key=");
                    ((StringBuilder)localObject4).append((String)localObject3);
                    QLog.d("Q.msg.MsgProxyUtils", 2, ((StringBuilder)localObject4).toString());
                  }
                  ((ArrayList)localObject2).add(localObject3);
                  localObject4 = localArrayList3.iterator();
                }
              }
              else {
                while (((Iterator)localObject4).hasNext()) {
                  if (TextUtils.equals((CharSequence)((Pair)((Iterator)localObject4).next()).first, (CharSequence)localObject3))
                  {
                    ((Iterator)localObject4).remove();
                    break;
                    if (QLog.isColorLevel())
                    {
                      localObject4 = new StringBuilder();
                      ((StringBuilder)localObject4).append("mergeLongMsg: complete online msg: uin=");
                      ((StringBuilder)localObject4).append(paramString);
                      ((StringBuilder)localObject4).append(",istroop=");
                      ((StringBuilder)localObject4).append(paramInt);
                      ((StringBuilder)localObject4).append(",key=");
                      ((StringBuilder)localObject4).append((String)localObject3);
                      QLog.d("Q.msg.MsgProxyUtils", 2, ((StringBuilder)localObject4).toString());
                    }
                    paramMessageCache.b(paramString, paramInt, (String)localObject3);
                  }
                }
              }
            }
          }
          if (!((ArrayList)localObject2).isEmpty())
          {
            paramMessageCache = ((ArrayList)localObject2).iterator();
            while (paramMessageCache.hasNext()) {
              localHashMap.remove((String)paramMessageCache.next());
            }
          }
        }
        i2 = localArrayList3.size() - 1;
        paramMessageCache = localHashMap;
        while (i2 >= 0)
        {
          localObject1 = (Pair)localArrayList3.get(i2);
          localObject2 = (ArrayList)paramMessageCache.get(((Pair)localObject1).first);
          try
          {
            Collections.sort((List)localObject2, n);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxyUtils", 2, "sort long msg error", localException);
            }
          }
          ArrayList localArrayList1 = new ArrayList();
          localObject2 = ((ArrayList)localObject2).iterator();
          i1 = 0;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MessageRecord)((Iterator)localObject2).next();
            if (c((MessageRecord)localObject3))
            {
              localArrayList1.add(localObject3);
            }
            else
            {
              if (!localArrayList1.isEmpty())
              {
                if (QLog.isColorLevel())
                {
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("mergeLongMsg: uin=");
                  ((StringBuilder)localObject4).append(paramString);
                  ((StringBuilder)localObject4).append(",istroop=");
                  ((StringBuilder)localObject4).append(paramInt);
                  ((StringBuilder)localObject4).append(",key=");
                  ((StringBuilder)localObject4).append(UinTypeUtil.a((MessageRecord)localArrayList1.get(0)));
                  QLog.d("Q.msg.MsgProxyUtils", 2, ((StringBuilder)localObject4).toString());
                }
                localObject4 = a(localArrayList1);
                a(paramList, ((Integer)((Pair)localObject1).second).intValue() + i1, (MessageRecord)localObject4, localArrayList2);
                localArrayList1.clear();
                i1 += 1;
              }
              a(paramList, ((Integer)((Pair)localObject1).second).intValue() + i1, (MessageRecord)localObject3, localArrayList2);
              i1 += 1;
            }
          }
          if (!localArrayList1.isEmpty())
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("mergeLongMsg: uin=");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(",istroop=");
              ((StringBuilder)localObject2).append(paramInt);
              ((StringBuilder)localObject2).append(",key=");
              ((StringBuilder)localObject2).append(UinTypeUtil.a((MessageRecord)localArrayList1.get(0)));
              QLog.d("Q.msg.MsgProxyUtils", 2, ((StringBuilder)localObject2).toString());
            }
            localObject2 = a(localArrayList1);
            a(paramList, ((Integer)((Pair)localObject1).second).intValue() + i1, (MessageRecord)localObject2, localArrayList2);
            localArrayList1.clear();
          }
          i2 -= 1;
        }
      }
    }
  }
  
  private static void b(List<MessageRecord> paramList)
  {
    int i1 = 0;
    while (i1 < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("backupAioMsgList = [");
      localStringBuilder.append(i1);
      localStringBuilder.append("] = ");
      localStringBuilder.append(localMessageRecord);
      QLog.d("Q.msg.MsgProxyUtils", 1, localStringBuilder.toString());
      i1 += 1;
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
    int i1 = 0;
    boolean bool1 = false;
    boolean bool2;
    for (;;)
    {
      bool2 = bool1;
      if (!localIterator.hasNext()) {
        break;
      }
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord.time > paramT.time) {}
      do
      {
        bool2 = true;
        break label125;
        if (localMessageRecord.time != paramT.time) {
          break;
        }
        bool2 = a(paramT, localMessageRecord);
        if (bool2) {
          break label125;
        }
        bool1 = bool2;
      } while (!paramBoolean);
      i1 += 1;
    }
    label125:
    if (!bool2)
    {
      paramList.add(paramT);
      return;
    }
    paramList.add(i1, paramT);
  }
  
  public static boolean b(int paramInt)
  {
    int[] arrayOfInt = UinTypeUtil.e;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    int[] arrayOfInt = UinTypeUtil.g;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramMessageRecord.msgtype) {
        return true;
      }
      i1 += 1;
    }
    return g(paramMessageRecord);
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
    return a.a(paramMessageRecord1, paramMessageRecord2, str1, str2);
  }
  
  public static boolean b(String paramString)
  {
    return AppConstants.MSG_BOX_INTERACT_UIN.equals(paramString);
  }
  
  private static boolean b(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    return a.a(paramAppRuntime, paramMessageRecord);
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
    boolean bool1 = QLog.isColorLevel();
    int i1 = 0;
    if (bool1) {
      QLog.d("Q.msg.MsgProxyUtils", 2, new Object[] { "insertToListBySeq, list size: ", Integer.valueOf(paramList.size()) });
    }
    Iterator localIterator = paramList.iterator();
    bool1 = false;
    boolean bool2;
    for (;;)
    {
      bool2 = bool1;
      if (!localIterator.hasNext()) {
        break;
      }
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord.shmsgseq > paramT.shmsgseq) {}
      do
      {
        bool2 = true;
        break label163;
        if (localMessageRecord.shmsgseq != paramT.shmsgseq) {
          break;
        }
        bool2 = a(paramT, localMessageRecord);
        if (bool2) {
          break label163;
        }
        bool1 = bool2;
      } while (!paramBoolean);
      i1 += 1;
    }
    label163:
    if (!bool2)
    {
      paramList.add(paramT);
      return;
    }
    paramList.add(i1, paramT);
  }
  
  public static boolean c(int paramInt)
  {
    int[] arrayOfInt = UinTypeUtil.b;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return a.b(paramMessageRecord);
  }
  
  private static boolean c(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.msgtype == -1034) {
      return b(paramMessageRecord1, paramMessageRecord2);
    }
    if (paramMessageRecord1.msgtype == -1042) {
      return b(paramMessageRecord1, paramMessageRecord2);
    }
    if ((paramMessageRecord1.msgtype != -2000) && (paramMessageRecord1.msgtype != -1000))
    {
      if (paramMessageRecord1.msgtype == -2002) {
        return b(paramMessageRecord1, paramMessageRecord2);
      }
      if (paramMessageRecord1.msgtype == -2005) {
        return b(paramMessageRecord1, paramMessageRecord2);
      }
      if (paramMessageRecord1.msgtype == -5007) {
        return b(paramMessageRecord1, paramMessageRecord2);
      }
      if ((Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) < 30L) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("other equal : mr.shmsgseq = ");
          localStringBuilder.append(paramMessageRecord1.shmsgseq);
          QLog.i("Q.msg.MsgProxyUtils", 2, localStringBuilder.toString());
        }
        if (b(paramMessageRecord1, paramMessageRecord2)) {
          return true;
        }
      }
    }
    else if ((Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) < 30L) && (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq) && (b(paramMessageRecord1, paramMessageRecord2)))
    {
      return true;
    }
    return false;
  }
  
  public static boolean c(String paramString)
  {
    return AppConstants.MSG_BOX_FOLLOW_UIN.equals(paramString);
  }
  
  public static String d(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004))
    {
      if ((paramMessageRecord.istroop == 1) && (h(paramMessageRecord))) {
        return "80000000";
      }
      if (TextUtils.equals(AppConstants.FILE_ASSISTANT_UIN, paramMessageRecord.senderuin)) {
        paramMessageRecord.senderuin = paramMessageRecord.selfuin;
      }
      return paramMessageRecord.senderuin;
    }
    if (paramMessageRecord.isSend()) {
      return paramMessageRecord.selfuin;
    }
    return paramMessageRecord.frienduin;
  }
  
  public static boolean d(int paramInt)
  {
    int[] arrayOfInt = j;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.equals("1822701914");
  }
  
  public static boolean e(int paramInt)
  {
    boolean bool2 = d(paramInt);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = o(paramInt);
    }
    return bool1;
  }
  
  public static boolean e(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype == -5008) && (paramMessageRecord.shmsgseq == 0L)) {
      return "1".equals(paramMessageRecord.getExtInfoFromExtStr("troop_mini_app_sys"));
    }
    return false;
  }
  
  public static boolean f(int paramInt)
  {
    int[] arrayOfInt = b;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private static boolean f(MessageRecord paramMessageRecord)
  {
    return a.d(paramMessageRecord);
  }
  
  public static boolean g(int paramInt)
  {
    int[] arrayOfInt = c;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private static boolean g(MessageRecord paramMessageRecord)
  {
    return a.c(paramMessageRecord);
  }
  
  public static boolean h(int paramInt)
  {
    int[] arrayOfInt = f;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private static boolean h(MessageRecord paramMessageRecord)
  {
    return a.a(paramMessageRecord);
  }
  
  public static boolean i(int paramInt)
  {
    int[] arrayOfInt = g;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean j(int paramInt)
  {
    int[] arrayOfInt = h;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean k(int paramInt)
  {
    int[] arrayOfInt = i;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static String l(int paramInt)
  {
    if ((paramInt != 1001) && (paramInt != 10002))
    {
      if (paramInt != 1009)
      {
        if (paramInt != 1010) {
          return AppConstants.LBS_HELLO_UIN;
        }
        return AppConstants.DATE_UIN;
      }
      return AppConstants.SAME_STATE_BOX_UIN;
    }
    return AppConstants.LBS_HELLO_UIN;
  }
  
  public static boolean m(int paramInt)
  {
    return paramInt == 1025;
  }
  
  public static boolean n(int paramInt)
  {
    int[] arrayOfInt = m;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private static boolean o(int paramInt)
  {
    return a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyUtils
 * JD-Core Version:    0.7.0.1
 */