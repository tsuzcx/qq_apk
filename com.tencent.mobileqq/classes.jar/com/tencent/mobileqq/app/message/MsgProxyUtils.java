package com.tencent.mobileqq.app.message;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkHelper;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import ztk;
import ztl;
import ztm;

public class MsgProxyUtils
{
  static Comparator jdField_a_of_type_JavaUtilComparator = new ztk();
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final int[] c;
  public static final String[] c;
  public static final int[] d;
  public static final int[] e;
  public static final int[] f;
  public static final int[] g;
  public static final int[] h;
  public static final int[] i;
  public static final int[] j;
  public static final int[] k;
  public static final int[] l;
  public static final int[] m;
  public static final int[] n;
  public static final int[] o;
  public static final int[] p;
  public static final int[] q;
  public static final int[] r;
  public static final int[] s;
  public static final int[] t;
  public static final int[] u;
  public static final int[] v;
  public static final int[] w;
  public static final int[] x;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1004, -1001, -1002, -2012, -2006, -4001, 193, 734, 230, -4002, -4003, -4004, -2015, -1014, -2061, -4008, -4009, -4012, -2021, -2018, -1040, -1039, -4005, -3009, -4020, -3010, -3011, -2019, -1041, -1043, -1044, -1045, -5000, -5006, -1017, 1018, -1042, 2024, -1026, -1027, -1028, -5005, -1046, -2027, -2037, -3013, -3014, -3015, -5007, -2030, -4021, -4022, -5011, -1013, -5020, -5022, -5023, -2060, -2023, -2062, -2065, -2064 };
    jdField_b_of_type_ArrayOfInt = new int[] { -2031, -2035, -2036, -2038, -2042, -2043, -5040, -5021 };
    jdField_c_of_type_ArrayOfInt = new int[] { -3006, -2035, -2036, -2038 };
    d = new int[] { -4004, -4003, -4009, -4020, -3010, -3011, -1044, -1026, -1027, -5005, -4021, -4022, -5011, -3014, -2064 };
    e = new int[] { -1034, -1042, -2015, -2061, -2003, -2004, -2009, -1001, -2012, -1013, -2030, -1019, -1018, -1014, -1043, -1045, -5000, -5001, -1024, -1028, 2024, -2042, -5005, -1046, -2027, -2037, -5006, -4011, -4012, -2029, -2034, -2033, -2041, -2060, -2062, -2065, -2063, -2066, -3016 };
    f = new int[] { -1004, -1012, -4002, -4003, -4004, -1047, -1013, -2030, -4009, -4012, -1016, -1017, -1050, -2021, -1041, -1043, -1044, -1045, -5000, -5001, 1018, -2016, 2024, -2042, -5005, -5006, -1046, -3013, -3014, -2029, -2034, -2033, -2043, -2041, -5011, -2049, -2063, -3016 };
    g = new int[] { -4003, -4020, -4004, -4009, -5011 };
    h = new int[] { -2006, -1034, -1042, -2015, -2061, -4002, -4003, -4004, -1001, -1047, -1013, -2030, -1019, -1018, -2012, -1014, -1004, -1016, -1017, -1050, -2021, -3011, -4020, -3009, -3010, -1041, -1043, -1044, -1045, -5000, -5001, -1024, -1028, 1018, 2024, -2042, -1012, -1046, -2027, -2029, -2043, -4021, -4022, -2049, -5021, -5023, -2065, -2060, -2062 };
    i = new int[0];
    j = new int[0];
    k = new int[] { 1008 };
    l = new int[] { -1000, -2000, -2002, -2005, -1035, -1036, -1037, -20000, -2007, -2011, -2010, -1051 };
    m = new int[] { -2000, -2002, -2007, -2058, -2011, -2020, -2022, -1051, -1035, -2057, -7001 };
    n = new int[] { -1001, -2009, -2016, -4008 };
    o = new int[] { -1047, -5040 };
    p = new int[] { -5040, -5020, -5021, -5022, -5023 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { AppConstants.G, AppConstants.v, AppConstants.X, AppConstants.ae, AppConstants.af, AppConstants.C, AppConstants.F, AppConstants.aE };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { AppConstants.as };
    q = new int[] { 0, 1000, 1004, 1020, 1006, 1001, 10002, 10004, 1009, 1003, 1005, 1008, 1023, 1021, 1029, 1022, 1024, 1025, 1010, 7400, 1032, 1033, 1034 };
    r = new int[] { 1033, 1034 };
    s = new int[] { 1000, 1004, 1020 };
    t = new int[] { 1, 3000, 1006, 7000, 9501, 10005, 1033, 1034 };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { AppConstants.G, AppConstants.X };
    u = new int[] { 1001, 10002, 1010 };
    v = new int[] { 0, 1, 3000, 1025, 1024 };
    w = new int[0];
    x = new int[] { 0, 1, 3000 };
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 1001: 
    case 10002: 
      return 1001;
    case 1010: 
      return 1010;
    case 1009: 
      return 1009;
    }
    return 1032;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return ConfessMsgUtil.a(paramInt1, paramInt2);
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
  
  public static int a(List paramList, QQAppInterface paramQQAppInterface)
  {
    int i2;
    if ((paramList == null) || (paramList.isEmpty())) {
      i2 = 0;
    }
    HashSet localHashSet;
    int i1;
    do
    {
      return i2;
      localHashSet = new HashSet();
      paramList = paramList.iterator();
      i1 = 0;
      i2 = i1;
    } while (!paramList.hasNext());
    MessageRecord localMessageRecord = (MessageRecord)paramList.next();
    if ((!localMessageRecord.isread) && (!localMessageRecord.isLongMsg())) {
      i1 += 1;
    }
    for (;;)
    {
      break;
      i2 = i1;
      if (!localMessageRecord.isread)
      {
        i2 = i1;
        if (localMessageRecord.isLongMsg())
        {
          if (paramQQAppInterface.a().a(localMessageRecord)) {
            break;
          }
          i2 = i1;
          if (!localHashSet.contains(b(localMessageRecord)))
          {
            i2 = i1 + 1;
            localHashSet.add(b(localMessageRecord));
          }
        }
      }
      i1 = i2;
    }
  }
  
  public static MessageRecord a(List paramList)
  {
    Object localObject;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject = null;
      return localObject;
    }
    int i1 = paramList.size() - 1;
    for (;;)
    {
      if (i1 < 0) {
        break label82;
      }
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i1);
      if (!TextUtils.equals(localMessageRecord.frienduin, AppConstants.as))
      {
        localObject = localMessageRecord;
        if (localMessageRecord.msgtype != -2006) {
          break;
        }
        localObject = localMessageRecord;
        if ((localMessageRecord instanceof MessageForFoldMsg)) {
          break;
        }
      }
      i1 -= 1;
    }
    label82:
    return null;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(jdField_a_of_type_ArrayOfInt.length * 8);
    localStringBuilder.append("not in (");
    int i1 = 0;
    if (i1 < jdField_a_of_type_ArrayOfInt.length)
    {
      localStringBuilder.append(jdField_a_of_type_ArrayOfInt[i1]);
      if (i1 == jdField_a_of_type_ArrayOfInt.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        i1 += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return AppConstants.G;
    case 1001: 
    case 10002: 
      return AppConstants.G;
    case 1010: 
      return AppConstants.X;
    }
    return AppConstants.v;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    int i1 = 1033;
    if (paramMessageRecord.istroop == 1032)
    {
      if (paramMessageRecord.isSelfConfessor()) {}
      for (;;)
      {
        return ConfessMsgUtil.a(paramMessageRecord.senderuin, i1, paramMessageRecord.getConfessTopicId());
        i1 = 1034;
      }
    }
    if ((paramMessageRecord.istroop == 1033) || (paramMessageRecord.istroop == 1034)) {
      return ConfessMsgUtil.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId());
    }
    return paramMessageRecord.senderuin;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
      return (String)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
    paramString = MD5.toMD5(str);
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 3000) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
    return paramString;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (e(paramInt)) {
      str = paramString + "&" + paramInt;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString != null);
    return "0";
  }
  
  public static List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((!m(localMessageRecord.msgtype)) && (((localMessageRecord.istroop != 3000) && (localMessageRecord.istroop != 1)) || (localMessageRecord.shmsgseq > 0L))) {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  public static List a(List paramList1, List paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList1 == null) || (paramList2 == null)) {
      return null;
    }
    paramList2 = paramList2.iterator();
    label191:
    for (;;)
    {
      MessageRecord localMessageRecord1;
      if (paramList2.hasNext())
      {
        localMessageRecord1 = (MessageRecord)paramList2.next();
        Iterator localIterator = paramList1.iterator();
        MessageRecord localMessageRecord2;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localMessageRecord2 = (MessageRecord)localIterator.next();
        } while ((localMessageRecord1.getId() != localMessageRecord1.getId()) || (localMessageRecord1.shmsgseq != localMessageRecord2.shmsgseq) || (localMessageRecord1.msgtype != localMessageRecord2.msgtype) || (localMessageRecord1.time != localMessageRecord2.time) || (localMessageRecord1.msgUid != localMessageRecord2.msgUid) || (localMessageRecord1.longMsgIndex != localMessageRecord2.longMsgIndex) || (localMessageRecord1.longMsgId != localMessageRecord2.longMsgId));
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label191;
        }
        localArrayList.add(localMessageRecord1);
        break;
        return localArrayList;
      }
    }
  }
  
  public static List a(List paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, 15);
  }
  
  public static List a(List paramList, boolean paramBoolean, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    if (paramBoolean) {
      Collections.sort(paramList, new ztl());
    }
    long l1 = ((MessageRecord)paramList.get(paramList.size() - 1)).shmsgseq;
    int i2 = paramList.size() - 1;
    int i1 = 0;
    int i3;
    while (i2 >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i2);
      if ((s(localMessageRecord.msgtype)) && (localMessageRecord.shmsgseq == 0L))
      {
        localArrayList.add(0, paramList.get(i2));
        i3 = i1;
        i2 -= 1;
        i1 = i3;
      }
      else if (l1 - localMessageRecord.shmsgseq <= 1L)
      {
        if ((l1 != localMessageRecord.shmsgseq) || (i2 >= paramList.size() - 1)) {
          break label224;
        }
      }
    }
    for (;;)
    {
      l1 = ((MessageRecord)paramList.get(i2)).shmsgseq;
      localArrayList.add(0, paramList.get(i2));
      i3 = i1;
      if (i1 < paramInt) {
        break;
      }
      return localArrayList;
      label224:
      i1 += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramQQAppInterface.a().b(paramString, paramInt1).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (paramInt2 == localMessageRecord.msgtype) {
        switch (paramInt2)
        {
        default: 
          paramQQAppInterface.a().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          break;
        case -3010: 
          paramQQAppInterface.a().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          break;
        case -4020: 
          paramQQAppInterface.a().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          break;
        case -4022: 
          paramQQAppInterface.a().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          break;
        case -4021: 
          paramQQAppInterface.a().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          break;
        case -3011: 
          if (!QlinkHelper.a()) {
            paramQQAppInterface.a().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          }
          break;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    for (;;)
    {
      int i2;
      try
      {
        if (!QLog.isColorLevel()) {
          break label450;
        }
        l1 = System.currentTimeMillis();
        i2 = 0;
        i3 = 0;
        List localList = paramQQAppInterface.a(1).c(paramString, 1);
        if (localList != null) {
          break label447;
        }
        localList = paramQQAppInterface.a(1).b(paramString, 1, 1L + paramLong, 2147483647L);
        if ((localList != null) && (localList.size() > 0))
        {
          i4 = localList.size() - 1;
          i2 = 0;
          i1 = 0;
          i3 = 0;
          if (i4 >= 0)
          {
            MessageRecord localMessageRecord = (MessageRecord)localList.get(i4);
            if (localMessageRecord.shmsgseq > paramLong)
            {
              if ((!a(localMessageRecord)) && (localMessageRecord.msgtype != -2006)) {
                break label426;
              }
              paramQQAppInterface.a().b(paramString, 1, localMessageRecord.uniseq);
              if (QLog.isColorLevel())
              {
                QLog.d(".troop.del_abnormal_troop_local_msg", 2, "delAbnormalLocalTroopMsg: " + paramLong + ", " + localMessageRecord.getBaseInfoString());
                i2 += 1;
                i1 = localMessageRecord.msgtype;
                i3 = 1;
                break label456;
              }
              QLog.d(".troop.del_abnormal_troop_local_msg", 1, "delAbnormalLocalTroopMsg: " + paramLong + ", " + localMessageRecord.getUserLogString());
              continue;
            }
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.del_abnormal_troop_local_msg", 2, "delAbnormalLocalTroopMsg:" + paramQQAppInterface.toString());
        }
        return;
      }
      for (;;)
      {
        QLog.d(".troop.del_abnormal_troop_local_msg", 2, "---delAbnormalLocalTroopMsg---:" + paramString + "," + paramLong + "," + (System.currentTimeMillis() - l1));
        if (i1 == 0) {
          break;
        }
        ReportController.b(paramQQAppInterface, "dc00899", "BizTechReport", "", "Grp_msg", "del_abnormal_local_msg", 0, 0, paramString, i2 + "", i3 + "", "");
        return;
        label426:
        i5 = i1;
        i1 = i3;
        i3 = i5;
        break label456;
        i1 = 0;
      }
      label447:
      continue;
      label450:
      long l1 = 0L;
      continue;
      label456:
      int i5 = i4 - 1;
      int i4 = i3;
      int i3 = i1;
      int i1 = i4;
      i4 = i5;
    }
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
  
  public static void a(String paramString, int paramInt, List paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      Object localObject2 = new ArrayList();
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = paramQQAppInterface.a();
      Object localObject3 = paramList.iterator();
      int i1 = 0;
      int i2 = 0;
      Object localObject4;
      label166:
      int i3;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        String str1;
        if (((MessageRecord)localObject4).isLongMsg())
        {
          str1 = b((MessageRecord)localObject4);
          if (localHashMap.containsKey(str1)) {
            if (Math.abs(((MessageRecord)((ArrayList)localHashMap.get(str1)).get(0)).time - ((MessageRecord)localObject4).time) <= 480L)
            {
              ((ArrayList)localHashMap.get(str1)).add(localObject4);
              ((List)localObject2).add(localObject4);
              i3 = i1;
              i1 = i2;
              i2 = i3;
            }
          }
        }
        for (;;)
        {
          i3 = i1;
          i1 = i2;
          i2 = i3;
          break;
          i3 = i1 + 1;
          String str2 = b(str1, i3);
          localHashMap.put(str2, localHashMap.get(str1));
          paramQQAppInterface = null;
          i1 = 0;
          for (;;)
          {
            if (i1 < localArrayList.size())
            {
              paramQQAppInterface = (Pair)localArrayList.get(i1);
              if (!((String)paramQQAppInterface.first).equals(str1)) {}
            }
            else
            {
              if (paramQQAppInterface != null)
              {
                localArrayList.remove(i1);
                localArrayList.add(i1, new Pair(str2, paramQQAppInterface.second));
              }
              paramQQAppInterface = new ArrayList();
              paramQQAppInterface.add(localObject4);
              localHashMap.put(str1, paramQQAppInterface);
              localArrayList.add(new Pair(str1, Integer.valueOf(i2)));
              i1 = i3;
              break;
            }
            i1 += 1;
          }
          paramQQAppInterface = new ArrayList();
          paramQQAppInterface.add(localObject4);
          localHashMap.put(str1, paramQQAppInterface);
          localArrayList.add(new Pair(str1, Integer.valueOf(i2)));
          break label166;
          i3 = i2 + 1;
          i2 = i1;
          i1 = i3;
        }
      }
      paramList.removeAll((Collection)localObject2);
      if ((!localHashMap.isEmpty()) && (!localArrayList.isEmpty()))
      {
        if (((MessageCache)localObject1).a(paramString, paramInt) != null)
        {
          paramQQAppInterface = new ArrayList();
          localObject2 = localHashMap.keySet().iterator();
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label766;
            }
            localObject3 = (String)((Iterator)localObject2).next();
            localObject4 = (ArrayList)localHashMap.get(localObject3);
            if (!((ArrayList)localObject4).isEmpty()) {
              if ((((MessageRecord)((ArrayList)localObject4).get(0)).longMsgCount <= ((ArrayList)localObject4).size()) || (((MessageRecord)((ArrayList)localObject4).get(0)).isSendFromLocal()))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: complete online msg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + (String)localObject3);
                }
                ((MessageCache)localObject1).a(paramString, paramInt, (String)localObject3);
              }
              else if (((MessageCache)localObject1).a(paramString, paramInt, (String)localObject3))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: incomplete online msg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + (String)localObject3);
                }
                paramQQAppInterface.add(localObject3);
                localObject4 = localArrayList.iterator();
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
          label766:
          if (!paramQQAppInterface.isEmpty())
          {
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext()) {
              localHashMap.remove((String)paramQQAppInterface.next());
            }
          }
        }
        i2 = localArrayList.size() - 1;
        while (i2 >= 0)
        {
          paramQQAppInterface = (Pair)localArrayList.get(i2);
          localObject2 = (ArrayList)localHashMap.get(paramQQAppInterface.first);
          try
          {
            Collections.sort((List)localObject2, jdField_a_of_type_JavaUtilComparator);
            localObject1 = new ArrayList();
            localObject2 = ((ArrayList)localObject2).iterator();
            i1 = 0;
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label1084;
              }
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if (!b((MessageRecord)localObject3)) {
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
                i3 = i1;
                if (!localException.isEmpty())
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + b((MessageRecord)localException.get(0)));
                  }
                  paramList.add(i1 + ((Integer)paramQQAppInterface.second).intValue(), new MessageForLongMsg(localException));
                  localException.clear();
                  i3 = i1 + 1;
                }
                paramList.add(i3 + ((Integer)paramQQAppInterface.second).intValue(), localObject3);
                i1 = i3 + 1;
              }
            }
            label1084:
            if (!localException.isEmpty())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxyUtils", 2, "mergeLongMsg: uin=" + paramString + ",istroop=" + paramInt + ",key=" + b((MessageRecord)localException.get(0)));
              }
              paramList.add(((Integer)paramQQAppInterface.second).intValue() + i1, new MessageForLongMsg(localException));
              localException.clear();
            }
            i2 -= 1;
          }
        }
      }
    }
  }
  
  public static void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(8);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord == null) {
        localArrayList.add(localMessageRecord);
      } else if ((localMessageRecord.msgtype == -2006) || (!localMessageRecord.isValid) || (localMessageRecord.msgtype == -2032)) {
        localArrayList.add(localMessageRecord);
      } else if ((localMessageRecord.msgtype == -2015) && ((localMessageRecord instanceof MessageForQzoneFeed))) {
        if (QZoneHelper.j())
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,空间下发配置屏蔽 aiofeeds，不再显示");
          }
          localArrayList.add(localMessageRecord);
        }
        else if (((MessageForQzoneFeed)localMessageRecord).isOldStructMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,空间aio feeds格式不兼容，不再显示");
          }
          localArrayList.add(localMessageRecord);
        }
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  public static void a(List paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1)) {
        c(paramList, paramMessageRecord, paramBoolean);
      }
    }
    else {
      return;
    }
    if (c(paramMessageRecord.istroop))
    {
      b(paramList, paramMessageRecord, paramBoolean);
      return;
    }
    paramList.add(paramMessageRecord);
  }
  
  public static boolean a(int paramInt)
  {
    if (j.length == 0) {}
    for (;;)
    {
      return false;
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
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return ((a(paramInt1) == 1001) || (a(paramInt1) == 10002)) && (paramInt2 != -3001) && (paramInt2 != -3000) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != -1003);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt == 1) {
      return !((HotChatManager)paramQQAppInterface.getManager(59)).b(paramString);
    }
    paramQQAppInterface = x;
    int i2 = paramQQAppInterface.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramQQAppInterface[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1)
    {
      if (((HotChatManager)paramQQAppInterface.getManager(59)).b(paramMessageRecord.frienduin)) {
        return true;
      }
    }
    else if (paramMessageRecord.istroop == 1026) {
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 3000)
    {
      DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(52);
      DiscussionInfo localDiscussionInfo = localDiscussionManager.a(paramString, true);
      if ((localDiscussionInfo == null) || (localDiscussionInfo.isHidden())) {
        return true;
      }
      paramQQAppInterface = localDiscussionManager.a(paramString, paramQQAppInterface.getCurrentAccountUin());
      if (paramQQAppInterface != null) {
        return (paramQQAppInterface.flag & 0x1) == 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxyUtils", 2, String.format("isDiscussionFilter, discuss meminfo not find, uin:%s, uinType: %d ", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    int[] arrayOfInt = f;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    boolean bool1;
    if (i1 < i2) {
      if (arrayOfInt[i1] == paramMessageRecord.msgtype) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          i1 += 1;
          break;
          bool1 = bool2;
        } while (!i(paramMessageRecord.msgtype));
        bool1 = bool2;
      } while (!(paramMessageRecord instanceof MessageForUniteGrayTip));
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      bool1 = bool2;
    } while (paramMessageRecord.tipParam == null);
    return paramMessageRecord.tipParam.f;
  }
  
  public static boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (paramMessageRecord1.isLongMsg()) && (paramMessageRecord2.isLongMsg()) && (paramMessageRecord1.longMsgId == paramMessageRecord2.longMsgId) && (paramMessageRecord1.longMsgCount == paramMessageRecord2.longMsgCount) && (TextUtils.equals(paramMessageRecord1.senderuin, paramMessageRecord2.senderuin)) && (Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) <= 480L);
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
          else if (UniteGrayTipUtil.a(paramMessageRecord1))
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
          else
          {
            paramBoolean = bool1;
            if (paramMessageRecord1.msgtype == -1000)
            {
              paramBoolean = bool1;
              if (paramMessageRecord2.msgtype == -5012)
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
                  } while (UniteGrayTipUtil.a(paramMessageRecord1));
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
        if ((paramMessageRecord1.msgUid == 0L) || (paramMessageRecord2.msgUid == 0L) || (paramMessageRecord1.msgUid != paramMessageRecord2.msgUid)) {
          break;
        }
        paramBoolean1 = bool;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MsgProxyUtils", 2, "compTroopMsgContent RewriteSeq: find msg by uid=" + paramMessageRecord1.msgUid);
      return true;
      if ((Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) >= 510L) && (Math.abs(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) >= 2L)) {
        break;
      }
      paramBoolean1 = bool;
    } while (b(paramMessageRecord1, paramMessageRecord2));
    label285:
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int i2 = arrayOfString.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfString[i1].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (((a(paramInt) == 1001) || (a(paramInt) == 10002)) && ((!AppConstants.G.equals(paramString)) && ((a(paramInt) != 1009) || (!AppConstants.v.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.X.equals(paramString))) && ((a(paramInt) != 1001) || (!AppConstants.ae.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.af.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.G.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.ae.equals(paramString))) && ((a(paramInt) != 1032) || (!AppConstants.aE.equals(paramString))))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject;
    do
    {
      while (!paramList.hasNext())
      {
        do
        {
          return false;
          paramString = new HashMap();
          paramList = paramList.iterator();
          paramInt = 0;
          if (paramList.hasNext())
          {
            localObject = (MessageRecord)paramList.next();
            String str;
            if (((MessageRecord)localObject).isLongMsg())
            {
              str = b((MessageRecord)localObject);
              if (paramString.containsKey(str)) {
                if (Math.abs(((MessageRecord)((ArrayList)paramString.get(str)).get(0)).time - ((MessageRecord)localObject).time) <= 480L) {
                  ((ArrayList)paramString.get(str)).add(localObject);
                }
              }
            }
            for (;;)
            {
              break;
              paramInt += 1;
              paramString.put(b(str, paramInt), paramString.get(str));
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localObject);
              paramString.put(str, localArrayList);
              continue;
              localArrayList = new ArrayList();
              localArrayList.add(localObject);
              paramString.put(str, localArrayList);
            }
          }
        } while (paramString.isEmpty());
        paramList = paramString.keySet().iterator();
      }
      localObject = (ArrayList)paramString.get((String)paramList.next());
    } while ((((ArrayList)localObject).isEmpty()) || (((MessageRecord)((ArrayList)localObject).get(0)).longMsgCount <= ((ArrayList)localObject).size()) || (((MessageRecord)((ArrayList)localObject).get(0)).isSendFromLocal()));
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((!e(paramInt1)) && (!e(paramInt2))) {
      return TextUtils.equals(paramString1, paramString2);
    }
    return (paramInt1 == paramInt2) && (TextUtils.equals(paramString1, paramString2));
  }
  
  public static boolean a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i1);
      if ((localMessageRecord.msgtype != -2006) || ((localMessageRecord instanceof MessageForFoldMsg))) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static byte[] a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)MessageRecordFactory.a(-2017);
    MessageRecord.copyMessageRecordBaseField(localMessageForTroopFile, paramMessageRecord1);
    localMessageForTroopFile.doParse();
    paramMessageRecord1 = (MessageForTroopFile)MessageRecordFactory.a(-2017);
    MessageRecord.copyMessageRecordBaseField(paramMessageRecord1, paramMessageRecord2);
    paramMessageRecord1.doParse();
    localMessageForTroopFile.bisID = paramMessageRecord1.bisID;
    localMessageForTroopFile.dspFileName = paramMessageRecord1.dspFileName;
    localMessageForTroopFile.dspFileSize = paramMessageRecord1.dspFileSize;
    localMessageForTroopFile.fileSize = paramMessageRecord1.fileSize;
    localMessageForTroopFile.fileName = paramMessageRecord1.fileName;
    localMessageForTroopFile.url = paramMessageRecord1.url;
    if ((paramMessageRecord1.width != 0) && (paramMessageRecord1.height != 0))
    {
      localMessageForTroopFile.width = paramMessageRecord1.width;
      localMessageForTroopFile.height = paramMessageRecord1.height;
    }
    if (paramMessageRecord1.duration != 0) {
      localMessageForTroopFile.duration = paramMessageRecord1.duration;
    }
    localMessageForTroopFile.serial();
    return localMessageForTroopFile.msgData;
  }
  
  static String[] a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0)
      {
        localObject1 = localObject2;
        if (paramString.charAt(0) == '\026') {
          localObject1 = paramString.split("\\|");
        }
      }
    }
    return localObject1;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(h.length * 8);
    localStringBuilder.append("not in (");
    int i1 = 0;
    if (i1 < h.length)
    {
      localStringBuilder.append(h[i1]);
      if (i1 == h.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        i1 += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.longMsgId + "&" + paramMessageRecord.senderuin + "&" + paramMessageRecord.longMsgCount;
  }
  
  public static String b(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new ztm(paramQQAppInterface, paramString, paramInt1, paramInt2), 8, null, true);
  }
  
  public static void b(List paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i3 = 0;
    Iterator localIterator = paramList.iterator();
    int i2 = 0;
    for (;;)
    {
      int i1 = i3;
      MessageRecord localMessageRecord;
      if (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.time <= paramMessageRecord.time) {
          break label67;
        }
        i1 = 1;
      }
      for (;;)
      {
        if (i1 != 0) {
          break label143;
        }
        paramList.add(paramMessageRecord);
        return;
        label67:
        if (localMessageRecord.time != paramMessageRecord.time) {
          break;
        }
        if (((localMessageRecord instanceof MessageForUniteGrayTip)) && ((paramMessageRecord instanceof MessageForUniteGrayTip)))
        {
          if (((MessageForUniteGrayTip)localMessageRecord).tipParam.d <= ((MessageForUniteGrayTip)localMessageRecord).tipParam.d) {
            break;
          }
          i1 = 1;
        }
        else
        {
          if (paramBoolean) {
            break;
          }
          i1 = 1;
        }
      }
      i2 += 1;
    }
    label143:
    paramList.add(i2, paramMessageRecord);
  }
  
  public static boolean b(int paramInt)
  {
    if (k.length == 0) {}
    for (;;)
    {
      return false;
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
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isOpenTroopMessage) {
      return true;
    }
    if (paramMessageRecord.istroop == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.f(paramMessageRecord.frienduin))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return false;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForReplyText));
  }
  
  private static boolean b(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    boolean bool = true;
    if (paramMessageRecord1.msgtype != paramMessageRecord2.msgtype) {
      bool = false;
    }
    String str;
    Object localObject;
    label513:
    label579:
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
                        return bool;
                        str = paramMessageRecord1.msg;
                        localObject = paramMessageRecord2.msg;
                        if (paramMessageRecord2.msgtype != -1000) {
                          break;
                        }
                      } while (TextUtils.equals(str, (CharSequence)localObject));
                      return false;
                      if (paramMessageRecord2.msgtype == -2002)
                      {
                        if (((paramMessageRecord2 instanceof MessageForPtt)) && ((paramMessageRecord1 instanceof MessageForPtt)) && (((MessageForPtt)paramMessageRecord1).urlAtServer != null) && (((MessageForPtt)paramMessageRecord1).urlAtServer.length() > 0) && (((MessageForPtt)paramMessageRecord2).urlAtServer != null) && (((MessageForPtt)paramMessageRecord2).urlAtServer.length() > 0)) {
                          return ((MessageForPtt)paramMessageRecord1).urlAtServer.equals(((MessageForPtt)paramMessageRecord2).urlAtServer);
                        }
                        return false;
                      }
                      if (paramMessageRecord2.msgtype == -2011)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("Debug", 2, "c2c" + Arrays.toString(paramMessageRecord1.msgData) + " : " + Arrays.toString(paramMessageRecord2.msgData));
                        }
                        return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                      }
                      if (paramMessageRecord2.msgtype != -2000) {
                        break label579;
                      }
                      if ((str == null) || (localObject == null) || (str.length() <= 0) || (((String)localObject).length() <= 0) || (str.charAt(0) != '\026') || (((String)localObject).charAt(0) != '\026')) {
                        break label513;
                      }
                      paramMessageRecord1 = a((String)localObject);
                      localObject = a(str);
                      if ((paramMessageRecord1 == null) || (localObject == null)) {
                        return false;
                      }
                      if ((!paramMessageRecord1[1].equals(localObject[1])) || (!paramMessageRecord1[2].equals(localObject[2]))) {
                        return false;
                      }
                      if ((paramMessageRecord2.issend != 2) && (!paramMessageRecord2.isSendFromLocal())) {
                        break;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.d("Q.msg.MsgProxyUtils", 2, "-------->compMsgContent: samePic: picSize:" + paramMessageRecord1[1] + ",picType:" + paramMessageRecord1[2] + ",isSend == true");
                    return true;
                    if (!str.contains(AppConstants.aJ)) {
                      break;
                    }
                    paramMessageRecord2 = localObject[0].split("/");
                    paramMessageRecord2 = paramMessageRecord2[(paramMessageRecord2.length - 1)].split("\\.")[0];
                    str = MD5.toMD5(paramMessageRecord1[4]);
                    if (!str.equals(paramMessageRecord2)) {
                      break label1048;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("Q.msg.MsgProxyUtils", 2, "-------->compMsgContent: samePic: picSize:" + paramMessageRecord1[1] + ",picType:" + paramMessageRecord1[2] + ",Path:" + str);
                  return true;
                  return localObject[0].equals(paramMessageRecord1[0]);
                  if ((((MessageForPic)paramMessageRecord1).uuid != null) && (((MessageForPic)paramMessageRecord1).uuid.length() > 0) && (((MessageForPic)paramMessageRecord2).uuid != null) && (((MessageForPic)paramMessageRecord2).uuid.length() > 0)) {
                    return ((MessageForPic)paramMessageRecord1).uuid.equals(((MessageForPic)paramMessageRecord2).uuid);
                  }
                  return false;
                  if ((paramMessageRecord2.msgtype == -2007) && (paramMessageRecord1.msgtype == -2007)) {
                    return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                  }
                  if ((paramMessageRecord2.msgtype == -2058) && (paramMessageRecord1.msgtype == -2058))
                  {
                    if (((!(paramMessageRecord2 instanceof MessageForMarketFace)) || (!(paramMessageRecord1 instanceof MessageForMarketFace))) && ((!(paramMessageRecord2 instanceof MessageForText)) || (!(paramMessageRecord1 instanceof MessageForText))) && ((!(paramMessageRecord2 instanceof MessageForPic)) || (!(paramMessageRecord1 instanceof MessageForPic)))) {
                      break label1048;
                    }
                    return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                  }
                  if ((paramMessageRecord2.msgtype == -1035) && (paramMessageRecord1.msgtype == -1035)) {
                    return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
                  }
                  if ((paramMessageRecord2.msgtype != -1034) || (paramMessageRecord1.msgtype != -1034)) {
                    break;
                  }
                } while ((paramMessageRecord2.time == paramMessageRecord1.time) && (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq));
                return false;
                if ((paramMessageRecord2.msgtype != -1042) || (paramMessageRecord1.msgtype != -1042)) {
                  break;
                }
              } while (paramMessageRecord2.time == paramMessageRecord1.time);
              return false;
              if ((paramMessageRecord2.msgtype != -2015) || (paramMessageRecord1.msgtype != -2015)) {
                break;
              }
            } while ((paramMessageRecord2.time == paramMessageRecord1.time) && (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq));
            return false;
            if ((paramMessageRecord2.msgtype == -2010) && (paramMessageRecord1.msgtype == -2010)) {
              return ((MessageForFunnyFace)paramMessageRecord2).msgEquals((MessageForFunnyFace)paramMessageRecord1);
            }
            if ((paramMessageRecord2.msgtype == -2060) && (paramMessageRecord1.msgtype == -2060)) {
              return ((MessageForPLNews)paramMessageRecord2).msgEquals((MessageForPLNews)paramMessageRecord1);
            }
            if ((paramMessageRecord2.msgtype == -2062) && (paramMessageRecord1.msgtype == -2062)) {
              return ((MessageForMedalNews)paramMessageRecord2).msgEquals((MessageForMedalNews)paramMessageRecord1);
            }
            if (paramMessageRecord2.msgtype != -2065) {
              break;
            }
          } while (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq);
          return false;
          if (paramMessageRecord2.msgtype != -2066) {
            break;
          }
        } while (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq);
        return false;
        if (paramMessageRecord2.msgtype != -2005) {
          break label1027;
        }
        if ((!(paramMessageRecord2 instanceof MessageForFile)) || (!(paramMessageRecord1 instanceof MessageForFile))) {
          break;
        }
      } while (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq);
      return false;
      return false;
      if (paramMessageRecord2.msgtype == -2017) {
        return false;
      }
    } while (TextUtils.equals(str, (CharSequence)localObject));
    label1027:
    label1048:
    return false;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (paramString.contains("&")))
    {
      bool1 = false;
      return bool1;
    }
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int i2 = arrayOfString.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label58;
      }
      bool1 = bool2;
      if (paramString.equals(arrayOfString[i1])) {
        break;
      }
      i1 += 1;
    }
    label58:
    arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
    i2 = arrayOfString.length;
    i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label95;
      }
      bool1 = bool2;
      if (paramString.equals(arrayOfString[i1])) {
        break;
      }
      i1 += 1;
    }
    label95:
    return false;
  }
  
  public static boolean b(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
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
    return false;
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(e.length * 8);
    localStringBuilder.append("not in (");
    int i1 = 0;
    if (i1 < e.length)
    {
      localStringBuilder.append(e[i1]);
      if (i1 == e.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        i1 += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1004))
    {
      if (paramMessageRecord.isSend()) {
        return paramMessageRecord.selfuin;
      }
      return paramMessageRecord.frienduin;
    }
    return paramMessageRecord.senderuin;
  }
  
  public static void c(List paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i3 = 0;
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxyUtils", 2, "insertToListBySeq, list is null");
      }
      return;
    }
    Iterator localIterator = paramList.iterator();
    int i2 = 0;
    for (;;)
    {
      int i1 = i3;
      MessageRecord localMessageRecord;
      if (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.shmsgseq <= paramMessageRecord.shmsgseq) {
          break label88;
        }
        i1 = 1;
      }
      for (;;)
      {
        if (i1 != 0) {
          break label164;
        }
        paramList.add(paramMessageRecord);
        return;
        label88:
        if (localMessageRecord.shmsgseq != paramMessageRecord.shmsgseq) {
          break;
        }
        if (((localMessageRecord instanceof MessageForUniteGrayTip)) && ((paramMessageRecord instanceof MessageForUniteGrayTip)))
        {
          if (((MessageForUniteGrayTip)localMessageRecord).tipParam.d <= ((MessageForUniteGrayTip)localMessageRecord).tipParam.d) {
            break;
          }
          i1 = 1;
        }
        else
        {
          if (paramBoolean) {
            break;
          }
          i1 = 1;
        }
      }
      i2 += 1;
    }
    label164:
    paramList.add(i2, paramMessageRecord);
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = q;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    return (c(paramMessageRecord)) && (!a(paramMessageRecord.frienduin, paramMessageRecord.istroop)) && (paramQQAppInterface.a().a(paramMessageRecord.frienduin));
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord.extLong & 0x1) == 1) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("one_way")));
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
    if (TextUtils.isEmpty(paramString)) {}
    while ((!AppConstants.ae.equals(paramString)) && (!AppConstants.af.equals(paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord != null) && (localMessageRecord.msgtype != -2006) && (localMessageRecord.msgtype != -2058)) {
        return false;
      }
    }
    return true;
  }
  
  public static String d()
  {
    if (i.length == 0) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(i.length * 8);
    localStringBuilder.append("not in (");
    int i1 = 0;
    if (i1 < i.length)
    {
      localStringBuilder.append(i[i1]);
      if (i1 == i.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        i1 += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean d(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = s;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1)
    {
      paramMessageRecord = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(true).a(paramMessageRecord.frienduin);
      if ((paramMessageRecord != null) && (paramMessageRecord.isGameRoom)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean d(String paramString)
  {
    return (AppConstants.ag.equals(paramString)) || (AppConstants.ah.equals(paramString));
  }
  
  public static boolean e(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = t;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean e(String paramString)
  {
    return AppConstants.ag.equals(paramString);
  }
  
  public static boolean f(int paramInt)
  {
    int[] arrayOfInt = e;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfInt[i1] == paramInt) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public static boolean f(String paramString)
  {
    return AppConstants.ah.equals(paramString);
  }
  
  public static boolean g(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean h(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = h;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean i(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = p;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean j(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_b_of_type_ArrayOfInt;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean k(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_c_of_type_ArrayOfInt;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean l(int paramInt)
  {
    if (i.length == 0) {}
    for (;;)
    {
      return false;
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
    }
  }
  
  public static boolean m(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = d;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean n(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = l;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean o(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = m;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean p(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = n;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean q(int paramInt)
  {
    return paramInt == -2006;
  }
  
  public static boolean r(int paramInt)
  {
    return (a(paramInt) == 1001) || (a(paramInt) == 10002) || (a(paramInt) == 1009) || (a(paramInt) == 1010) || (a(paramInt) == 1032);
  }
  
  public static boolean s(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = o;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean t(int paramInt)
  {
    return paramInt == 1025;
  }
  
  public static boolean u(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 10002);
  }
  
  public static boolean v(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = v;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (arrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MsgProxyUtils
 * JD-Core Version:    0.7.0.1
 */