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
    jdField_b_of_type_ArrayOfInt = new int[] { -2006, -1034, -1042, -2015, -2061, -4002, -4003, -4004, -1001, -1047, -1013, -2030, -1019, -1018, -2012, -1014, -1004, -1016, -1017, -1050, -2021, -3011, -4020, -3009, -3010, -1041, -1043, -1044, -1045, -5000, -5001, -1024, -1028, 1018, 2024, -2042, -1012, -1046, -2027, -2029, -2043, -4021, -4022, -2049, -5021, -5023, -2065, -2060, -2062, -4023, -4024, -4025, -4026, -4027, -7007, -2077, -7010, -7009, -7011, -7012, -7013, -7015, -7016 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { AppConstants.LBS_HELLO_UIN, AppConstants.SAME_STATE_BOX_UIN, AppConstants.DATE_UIN, AppConstants.LBS_SAY_HELLO_LIST_UIN, AppConstants.DATE_SAY_HELLO_LIST_UIN, AppConstants.RECOMMEND_CONTACT_UIN, AppConstants.SYSTEM_MSG_UIN, AppConstants.CONFESS_UIN };
    c = new int[] { 0, 1000, 1004, 1020, 1006, 1001, 10002, 10004, 1009, 1003, 1005, 1008, 1023, 1021, 1022, 1024, 1025, 1010, 7400, 1044, 1045, 1032, 1033, 1034, 1036, 1038, 10007, 10008, 10009, 10010, 10011 };
    d = new int[] { -1004, -1001, -1002, -2012, -2006, -4001, 193, 734, 230, -4002, -4003, -4004, -2015, -1014, -2061, -4008, -4009, -4012, -2021, -2018, -1040, -1039, -4005, -3009, -4020, -3010, -3011, -2019, -7006, -1041, -1043, -1044, -1045, -5000, -5006, -1017, 1018, -1042, 2024, -1026, -1027, -1028, -5005, -1046, -2027, -2037, -3013, -3014, -3015, -5007, -2030, -4021, -4022, -5011, -1013, -5020, -5022, -5023, -2060, -2062, -2023, -2065, -2064, -3016, -2063, -5041, -2073, -7007, -4024, -4026, -4027, -2077, -7010, -7009, -7011, -7012, -7013, -7015, -7016, -1034, -2074 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { AppConstants.KANDIAN_MERGE_UIN };
  }
  
  public static int a(int paramInt)
  {
    int k = 1001;
    int j = k;
    if (paramInt != 1001)
    {
      j = k;
      if (paramInt != 10002)
      {
        j = 1009;
        if (paramInt != 1009)
        {
          j = 1010;
          if (paramInt != 1010)
          {
            k = 1044;
            j = k;
            if (paramInt != 1044)
            {
              j = k;
              if (paramInt != 1045)
              {
                switch (paramInt)
                {
                default: 
                  return paramInt;
                }
                return 1032;
              }
            }
          }
        }
      }
    }
    return j;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(jdField_b_of_type_ArrayOfInt.length * 8);
    localStringBuilder.append("not in (");
    int j = 0;
    for (;;)
    {
      int[] arrayOfInt = jdField_b_of_type_ArrayOfInt;
      if (j >= arrayOfInt.length) {
        break;
      }
      localStringBuilder.append(arrayOfInt[j]);
      if (j == jdField_b_of_type_ArrayOfInt.length - 1) {
        localStringBuilder.append(")");
      } else {
        localStringBuilder.append(",");
      }
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageRecord.longMsgId);
    localStringBuilder.append("&");
    localStringBuilder.append(paramMessageRecord.senderuin);
    localStringBuilder.append("&");
    localStringBuilder.append(paramMessageRecord.longMsgCount);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (a(paramInt))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(paramInt);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "0";
    }
    return localObject;
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("&");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
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
    if ((paramList1 != null) && (paramList2 != null))
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        MessageRecord localMessageRecord1 = (MessageRecord)paramList2.next();
        int k = 0;
        Iterator localIterator = paramList1.iterator();
        MessageRecord localMessageRecord2;
        do
        {
          j = k;
          if (!localIterator.hasNext()) {
            break;
          }
          localMessageRecord2 = (MessageRecord)localIterator.next();
        } while ((localMessageRecord1.getId() != localMessageRecord1.getId()) || (localMessageRecord1.shmsgseq != localMessageRecord2.shmsgseq) || (localMessageRecord1.msgtype != localMessageRecord2.msgtype) || (localMessageRecord1.time != localMessageRecord2.time) || (localMessageRecord1.msgUid != localMessageRecord2.msgUid) || (localMessageRecord1.longMsgIndex != localMessageRecord2.longMsgIndex) || (localMessageRecord1.longMsgId != localMessageRecord2.longMsgId));
        int j = 1;
        if (j == 0) {
          localArrayList.add(localMessageRecord1);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public static boolean a(int paramInt)
  {
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      if (arrayOfInt[j] == paramInt) {
        return true;
      }
      j += 1;
    }
    return false;
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
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int k = arrayOfString.length;
    int j = 0;
    while (j < k)
    {
      if (arrayOfString[j].equals(paramString)) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (((a(paramInt) != 1001) && (a(paramInt) != 10002)) || ((!AppConstants.LBS_HELLO_UIN.equals(paramString)) && (((a(paramInt) != 1001) && (a(paramInt) != 10002)) || ((!AppConstants.NEARBY_LBS_HELLO_UIN.equals(paramString)) && ((a(paramInt) != 1009) || (!AppConstants.SAME_STATE_BOX_UIN.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.DATE_UIN.equals(paramString))) && ((a(paramInt) != 1001) || (!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.LBS_HELLO_UIN.equals(paramString))) && ((a(paramInt) != 1010) || (!AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString))) && ((a(paramInt) != 1032) || (!AppConstants.CONFESS_UIN.equals(paramString))) && ((a(paramInt) != 1044) || (!AppConstants.MATCH_CHAT_UIN.equals(paramString)))))))
    {
      bool1 = bool2;
      if (a(paramInt) == 10008)
      {
        bool1 = bool2;
        if (!AppConstants.QCIRCLE_CHAT_UIN.equals(paramString)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      paramString = new HashMap();
      paramList = paramList.iterator();
      paramInt = 0;
      Object localObject;
      while (paramList.hasNext())
      {
        localObject = (MessageRecord)paramList.next();
        if (((MessageRecord)localObject).isLongMsg())
        {
          String str = a((MessageRecord)localObject);
          ArrayList localArrayList;
          if (paramString.containsKey(str))
          {
            if (Math.abs(((MessageRecord)((ArrayList)paramString.get(str)).get(0)).time - ((MessageRecord)localObject).time) <= 480L)
            {
              ((ArrayList)paramString.get(str)).add(localObject);
            }
            else
            {
              paramInt += 1;
              paramString.put(b(str, paramInt), paramString.get(str));
              localArrayList = new ArrayList();
              localArrayList.add(localObject);
              paramString.put(str, localArrayList);
            }
          }
          else
          {
            localArrayList = new ArrayList();
            localArrayList.add(localObject);
            paramString.put(str, localArrayList);
          }
        }
      }
      bool1 = bool2;
      if (!paramString.isEmpty())
      {
        paramList = paramString.keySet().iterator();
        do
        {
          bool1 = bool2;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (ArrayList)paramString.get((String)paramList.next());
        } while ((((ArrayList)localObject).isEmpty()) || (((MessageRecord)((ArrayList)localObject).get(0)).longMsgCount <= ((ArrayList)localObject).size()) || (((MessageRecord)((ArrayList)localObject).get(0)).isSendFromLocal()));
        bool1 = true;
      }
    }
    return bool1;
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
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
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
    return false;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(d.length * 8);
    localStringBuilder.append("not in (");
    int j = 0;
    for (;;)
    {
      int[] arrayOfInt = d;
      if (j >= arrayOfInt.length) {
        break;
      }
      localStringBuilder.append(arrayOfInt[j]);
      if (j == d.length - 1) {
        localStringBuilder.append(")");
      } else {
        localStringBuilder.append(",");
      }
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    int k = paramMessageRecord.istroop;
    int j = 1034;
    if (k == 1032)
    {
      if (paramMessageRecord.isSelfConfessor()) {
        j = 1033;
      }
      return a(paramMessageRecord.senderuin, j, paramMessageRecord.getConfessTopicId());
    }
    if ((paramMessageRecord.istroop != 1033) && (paramMessageRecord.istroop != 1034)) {
      return paramMessageRecord.senderuin;
    }
    return a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId());
  }
  
  public static String b(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static boolean b(int paramInt)
  {
    Object localObject = c;
    int k = localObject.length;
    int j = 0;
    while (j < k)
    {
      if (localObject[j] == paramInt) {
        return true;
      }
      j += 1;
    }
    localObject = UinType.valueOf(paramInt);
    if (localObject != null) {
      return ((UinType)localObject).isC2CConversation();
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.contains("&")) {
        return false;
      }
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int k = arrayOfString.length;
      int j = 0;
      while (j < k)
      {
        if (paramString.equals(arrayOfString[j])) {
          return true;
        }
        j += 1;
      }
      arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
      k = arrayOfString.length;
      j = 0;
      while (j < k)
      {
        if (paramString.equals(arrayOfString[j])) {
          return true;
        }
        j += 1;
      }
    }
    return false;
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(e.length * 8);
    localStringBuilder.append("not in (");
    int j = 0;
    for (;;)
    {
      int[] arrayOfInt = e;
      if (j >= arrayOfInt.length) {
        break;
      }
      localStringBuilder.append(arrayOfInt[j]);
      if (j == e.length - 1) {
        localStringBuilder.append(")");
      } else {
        localStringBuilder.append(",");
      }
      j += 1;
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
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(paramString)) || (AppConstants.DATE_SAY_HELLO_LIST_UIN.equals(paramString))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String d()
  {
    Object localObject = h;
    if (localObject.length == 0) {
      return null;
    }
    localObject = new StringBuilder(localObject.length * 8);
    ((StringBuilder)localObject).append("not in (");
    int j = 0;
    for (;;)
    {
      int[] arrayOfInt = h;
      if (j >= arrayOfInt.length) {
        break;
      }
      ((StringBuilder)localObject).append(arrayOfInt[j]);
      if (j == h.length - 1) {
        ((StringBuilder)localObject).append(")");
      } else {
        ((StringBuilder)localObject).append(",");
      }
      j += 1;
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean d(int paramInt)
  {
    int[] arrayOfInt = f;
    int k = arrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      if (arrayOfInt[j] == paramInt) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public static boolean d(String paramString)
  {
    return (AppConstants.MSG_BOX_INTERACT_UIN.equals(paramString)) || (AppConstants.MSG_BOX_FOLLOW_UIN.equals(paramString));
  }
  
  public static boolean e(int paramInt)
  {
    int[] arrayOfInt = g;
    if (arrayOfInt.length == 0) {
      return false;
    }
    int k = arrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      if (arrayOfInt[j] == paramInt) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public static boolean e(String paramString)
  {
    return AppConstants.MSG_BOX_MYMOMMENT_UIN.equals(paramString);
  }
  
  public static boolean f(int paramInt)
  {
    int[] arrayOfInt = h;
    if (arrayOfInt.length == 0) {
      return false;
    }
    int k = arrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      if (arrayOfInt[j] == paramInt) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public static boolean g(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 3000)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        if (paramInt == 1026) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean h(int paramInt)
  {
    return (a(paramInt) == 1001) || (a(paramInt) == 10002) || (a(paramInt) == 1009) || (a(paramInt) == 1010) || (a(paramInt) == 1032);
  }
  
  public static boolean i(int paramInt)
  {
    int[] arrayOfInt = i;
    if (arrayOfInt.length == 0) {
      return false;
    }
    int k = arrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      if (arrayOfInt[j] == paramInt) {
        return true;
      }
      j += 1;
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.UinTypeUtil
 * JD-Core Version:    0.7.0.1
 */