package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.UinType;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UinTypeUtil
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final int[] c;
  public static final int[] d;
  public static final int[] e = { -1034, -1042, -2015, -2061, -2003, -2004, -2009, -1001, -2076, -2012, -1013, -2030, -1019, -1018, -1014, -1043, -1045, -5000, -5001, -1024, -1028, 2024, -2042, -5005, -1046, -2027, -2037, -5006, -4011, -4012, -2029, -2034, -2033, -2041, -2060, -2062, -2065, -2063, -2066, -3016, -7007, -7010, -7009, -7011, -7012, -7015 };
  public static final int[] f = { -4004, -4003, -4009, -4020, -3010, -3011, -1044, -5005, -4021, -4022, -5011, -3014, -2064, -7005, -5022, -7013 };
  public static final int[] g = new int[0];
  public static final int[] h = new int[0];
  public static final int[] i = { 1008 };
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 3000, 1006, 7000, 9501, 10005, 1033, 1034, 1036 };
    jdField_b_of_type_ArrayOfInt = new int[] { -2006, -1034, -1042, -2015, -2061, -4002, -4003, -4004, -1001, -1047, -1013, -2030, -1019, -1018, -2012, -1014, -1004, -1016, -1017, -1050, -2021, -3011, -4020, -3009, -3010, -1041, -1043, -1044, -1045, -5000, -5001, -1024, -1028, 1018, 2024, -2042, -1012, -1046, -2027, -2029, -2043, -4021, -4022, -2049, -5021, -5023, -2065, -2060, -2062, -4023, -4024, -4025, -4026, -4027, -7007, -2077, -7010, -7009, -7011, -7012, -7013, -7015 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { AppConstants.LBS_HELLO_UIN, AppConstants.SAME_STATE_BOX_UIN, AppConstants.DATE_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN, AppConstants.DATE_SAY_HELLO_LIST_UIN, AppConstants.RECOMMEND_CONTACT_UIN, AppConstants.SYSTEM_MSG_UIN, AppConstants.CONFESS_UIN };
    c = new int[] { 0, 1000, 1004, 1020, 1006, 1001, 10002, 10004, 1009, 1003, 1005, 1008, 1023, 1021, 1022, 1024, 1025, 1010, 7400, 1037, 1044, 1045, 1032, 1033, 1034, 1036, 1038, 10007, 10008, 10009, 10010, 10011 };
    d = new int[] { -1004, -1001, -1002, -2012, -2006, -4001, 193, 734, 230, -4002, -4003, -4004, -2015, -1014, -2061, -4008, -4009, -4012, -2021, -2018, -1040, -1039, -4005, -3009, -4020, -3010, -3011, -2019, -7006, -1041, -1043, -1044, -1045, -5000, -5006, -1017, 1018, -1042, 2024, -1026, -1027, -1028, -5005, -1046, -2027, -2037, -3013, -3014, -3015, -5007, -2030, -4021, -4022, -5011, -1013, -5020, -5022, -5023, -2060, -2062, -2023, -2065, -2064, -3016, -2063, -5041, -2073, -7007, -4024, -4026, -4027, -2077, -7010, -7009, -7011, -7012, -7013, -7015 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { AppConstants.KANDIAN_MERGE_UIN };
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
    case 1032: 
    case 1033: 
    case 1034: 
      return 1032;
    }
    return 1044;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(jdField_b_of_type_ArrayOfInt.length * 8);
    localStringBuilder.append("not in (");
    int j = 0;
    if (j < jdField_b_of_type_ArrayOfInt.length)
    {
      localStringBuilder.append(jdField_b_of_type_ArrayOfInt[j]);
      if (j == jdField_b_of_type_ArrayOfInt.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.longMsgId + "&" + paramMessageRecord.senderuin + "&" + paramMessageRecord.longMsgCount;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (a(paramInt)) {
      str = paramString + "&" + paramInt;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString != null);
    return "0";
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    return paramString + "&" + paramInt1 + "&" + paramInt2;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((!d(localMessageRecord.msgtype)) && (((localMessageRecord.istroop != 3000) && (localMessageRecord.istroop != 1)) || (localMessageRecord.shmsgseq > 0L))) {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
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
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          break label191;
        }
        localArrayList.add(localMessageRecord1);
        break;
        return localArrayList;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt.length;
    int j = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j < k)
      {
        if (arrayOfInt[j] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord.extLong & 0x1) == 1) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("one_way")));
  }
  
  public static boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (paramMessageRecord1.isLongMsg()) && (paramMessageRecord2.isLongMsg()) && (paramMessageRecord1.longMsgId == paramMessageRecord2.longMsgId) && (paramMessageRecord1.longMsgCount == paramMessageRecord2.longMsgCount) && (TextUtils.equals(paramMessageRecord1.senderuin, paramMessageRecord2.senderuin)) && (Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) <= 480L);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int k = arrayOfString.length;
    int j = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j < k)
      {
        if (arrayOfString[j].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (((a(paramInt) == 1001) || (a(paramInt) == 10002)) && ((!AppConstants.LBS_HELLO_UIN.equals(paramString)) && (((a(paramInt) == 1001) || (a(paramInt) == 10002)) && ((!AppConstants.NEARBY_LBS_HELLO_UIN.equals(paramString)) && ((a(paramInt) != 1009) || (!AppConstants.SAME_STATE_BOX_UIN.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.DATE_UIN.equals(paramString))) && ((a(paramInt) != 1001) || (!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.LBS_HELLO_UIN.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString))) && ((a(paramInt) != 1032) || (!AppConstants.CONFESS_UIN.equals(paramString))) && ((a(paramInt) != 1044) || (!AppConstants.MATCH_CHAT_UIN.equals(paramString))) && ((a(paramInt) != 10008) || (!AppConstants.QCIRCLE_CHAT_UIN.equals(paramString))))))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, int paramInt, List<MessageRecord> paramList)
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
              str = a((MessageRecord)localObject);
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
    if ((!a(paramInt1)) && (!a(paramInt2))) {
      return TextUtils.equals(paramString1, paramString2);
    }
    return (paramInt1 == paramInt2) && (TextUtils.equals(paramString1, paramString2));
  }
  
  public static boolean a(List<MessageRecord> paramList)
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
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(d.length * 8);
    localStringBuilder.append("not in (");
    int j = 0;
    if (j < d.length)
    {
      localStringBuilder.append(d[j]);
      if (j == d.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    int j = 1033;
    if (paramMessageRecord.istroop == 1032)
    {
      if (paramMessageRecord.isSelfConfessor()) {}
      for (;;)
      {
        return a(paramMessageRecord.senderuin, j, paramMessageRecord.getConfessTopicId());
        j = 1034;
      }
    }
    if ((paramMessageRecord.istroop == 1033) || (paramMessageRecord.istroop == 1034)) {
      return a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId());
    }
    return paramMessageRecord.senderuin;
  }
  
  public static String b(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool = false;
    Object localObject = c;
    int k = localObject.length;
    int j = 0;
    if (j < k) {
      if (localObject[j] == paramInt) {
        bool = true;
      }
    }
    do
    {
      return bool;
      j += 1;
      break;
      localObject = UinType.valueOf(paramInt);
    } while (localObject == null);
    return ((UinType)localObject).isC2CConversation();
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
    int k = arrayOfString.length;
    int j = 0;
    for (;;)
    {
      if (j >= k) {
        break label57;
      }
      bool1 = bool2;
      if (paramString.equals(arrayOfString[j])) {
        break;
      }
      j += 1;
    }
    label57:
    arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
    k = arrayOfString.length;
    j = 0;
    for (;;)
    {
      if (j >= k) {
        break label94;
      }
      bool1 = bool2;
      if (paramString.equals(arrayOfString[j])) {
        break;
      }
      j += 1;
    }
    label94:
    return false;
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(e.length * 8);
    localStringBuilder.append("not in (");
    int j = 0;
    if (j < e.length)
    {
      localStringBuilder.append(e[j]);
      if (j == e.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean c(int paramInt)
  {
    int[] arrayOfInt = e;
    int k = arrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      if (arrayOfInt[j] == paramInt) {
        return false;
      }
      j += 1;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString)) && (!AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(paramString))) {
      return false;
    }
    return true;
  }
  
  public static String d()
  {
    if (h.length == 0) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(h.length * 8);
    localStringBuilder.append("not in (");
    int j = 0;
    if (j < h.length)
    {
      localStringBuilder.append(h[j]);
      if (j == h.length - 1) {
        localStringBuilder.append(")");
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean d(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = f;
    int k = arrayOfInt.length;
    int j = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j < k)
      {
        if (arrayOfInt[j] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  public static boolean d(String paramString)
  {
    return (AppConstants.MSG_BOX_INTERACT_UIN.equals(paramString)) || (AppConstants.MSG_BOX_FOLLOW_UIN.equals(paramString));
  }
  
  public static boolean e(int paramInt)
  {
    if (g.length == 0) {}
    for (;;)
    {
      return false;
      int[] arrayOfInt = g;
      int k = arrayOfInt.length;
      int j = 0;
      while (j < k)
      {
        if (arrayOfInt[j] == paramInt) {
          return true;
        }
        j += 1;
      }
    }
  }
  
  public static boolean e(String paramString)
  {
    return AppConstants.MSG_BOX_MYMOMMENT_UIN.equals(paramString);
  }
  
  public static boolean f(int paramInt)
  {
    if (h.length == 0) {}
    for (;;)
    {
      return false;
      int[] arrayOfInt = h;
      int k = arrayOfInt.length;
      int j = 0;
      while (j < k)
      {
        if (arrayOfInt[j] == paramInt) {
          return true;
        }
        j += 1;
      }
    }
  }
  
  public static boolean g(int paramInt)
  {
    return (paramInt == 3000) || (paramInt == 1) || (paramInt == 1026);
  }
  
  public static boolean h(int paramInt)
  {
    return (a(paramInt) == 1001) || (a(paramInt) == 10002) || (a(paramInt) == 1009) || (a(paramInt) == 1010) || (a(paramInt) == 1032);
  }
  
  public static boolean i(int paramInt)
  {
    if (i.length == 0) {}
    for (;;)
    {
      return false;
      int[] arrayOfInt = i;
      int k = arrayOfInt.length;
      int j = 0;
      while (j < k)
      {
        if (arrayOfInt[j] == paramInt) {
          return true;
        }
        j += 1;
      }
    }
  }
  
  public static boolean j(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 10002);
  }
  
  public static boolean k(int paramInt)
  {
    return paramInt == -2006;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.UinTypeUtil
 * JD-Core Version:    0.7.0.1
 */