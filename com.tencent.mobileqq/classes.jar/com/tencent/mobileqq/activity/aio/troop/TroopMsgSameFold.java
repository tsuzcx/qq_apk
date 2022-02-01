package com.tencent.mobileqq.activity.aio.troop;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.TroopFoldMsgBean;
import com.tencent.mobileqq.config.business.TroopFoldMsgConfProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TroopMsgSameFold
{
  protected static List<Long> a;
  public static boolean a = false;
  protected static List<Long> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static int a()
  {
    TroopFoldMsgBean localTroopFoldMsgBean = TroopFoldMsgConfProcessor.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigSwitch = ");
      localStringBuilder.append(localTroopFoldMsgBean.jdField_a_of_type_Int);
      QLog.i("TroopMsgSameFold", 2, localStringBuilder.toString());
    }
    return localTroopFoldMsgBean.jdField_a_of_type_Int;
  }
  
  private static int a(int paramInt1, long[] paramArrayOfLong1, int paramInt2, int[][] paramArrayOfInt, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, long[] paramArrayOfLong2, int[] paramArrayOfInt2, ChatMessage paramChatMessage)
  {
    if (paramInt5 == paramInt2 - 1) {
      if (paramInt4 >= paramInt1)
      {
        paramArrayOfInt[paramInt3][1] = paramInt5;
        a(paramArrayOfLong1, paramArrayOfInt1, paramInt5, paramArrayOfLong2, paramArrayOfInt2, paramChatMessage);
      }
      else
      {
        return paramInt3 - 1;
      }
    }
    return paramInt3;
  }
  
  private static int a(DisplayMetrics paramDisplayMetrics, int paramInt, String paramString)
  {
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = paramDisplayMetrics.density;
    float f = paramDisplayMetrics.scaledDensity;
    int k = paramString.length();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (i >= k) {
        break;
      }
      if (localTextPaint.measureText(paramString.substring(0, i)) * f > paramInt)
      {
        j = i - 1;
        break;
      }
      i += 1;
    }
    a("getFitTextSize = fitSize = %d", new Object[] { Integer.valueOf(j) });
    return j;
  }
  
  protected static int a(List<ChatMessage> paramList)
  {
    return ListUtils.a(a(paramList));
  }
  
  private static int a(@NonNull List<ChatMessage> paramList, int paramInt1, long[] paramArrayOfLong1, int[][] paramArrayOfInt, int paramInt2, int paramInt3, int[] paramArrayOfInt1, int paramInt4, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    int i = paramInt2;
    if (paramInt3 >= paramInt1)
    {
      paramArrayOfInt[paramInt2][1] = paramInt4;
      i = paramInt2 + 1;
      a(paramArrayOfLong1, paramArrayOfInt1, paramInt4, paramArrayOfLong2, paramArrayOfInt2, (ChatMessage)paramList.get(paramInt4));
    }
    return i;
  }
  
  private static int a(int[][] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, ChatMessage paramChatMessage)
  {
    int i = paramInt2;
    if (!paramChatMessage.isSend())
    {
      paramInt2 += 1;
      i = paramInt2;
      if (paramInt2 == 1)
      {
        paramArrayOfInt[paramInt1][0] = paramInt3;
        i = paramInt2;
      }
    }
    return i;
  }
  
  private static Bundle a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_action_DATA", String.valueOf(paramLong1));
    localBundle.putString("key_a_action_DATA", String.valueOf(paramLong2));
    return localBundle;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, Resources paramResources, List<ChatMessage> paramList, long paramLong)
  {
    paramResources = a(paramQQAppInterface, paramResources, paramList);
    int i = paramResources.length();
    return a(paramQQAppInterface, paramList, paramLong, paramResources, i - 6, i, 54, true);
  }
  
  private static ChatMessage a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = ListUtils.a(paramList);
    Object localObject = (ChatMessage)paramList.get(0);
    if (i > 1) {
      paramList = (ChatMessage)paramList.get(i - 1);
    } else {
      paramList = (List<ChatMessage>)localObject;
    }
    String str1 = paramList.frienduin;
    String str2 = paramQQAppInterface.getCurrentUin();
    long l1 = paramList.time;
    i = paramList.istroop;
    if (paramLong == -1L) {
      paramLong = ((ChatMessage)localObject).shmsgseq;
    }
    long l2 = paramList.shmsgseq;
    long l3 = paramList.uniseq;
    paramList = new UniteGrayTipParam(str1, str2, paramString, i, -5040, 2, l1);
    paramList.a(paramInt1, paramInt2, a(paramInt3, paramLong, l2, paramBoolean));
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramList);
    ((MessageForUniteGrayTip)localObject).msg = paramString;
    ((MessageForUniteGrayTip)localObject).shmsgseq = l2;
    ((MessageForUniteGrayTip)localObject).uniseq = (l3 + 1L);
    return localObject;
  }
  
  @Nullable
  private static ChatMessage a(@NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean, List<ChatMessage> paramList1, List<ChatMessage> paramList2, ArrayList<ChatMessage> paramArrayList, List<ChatMessage> paramList3, int paramInt, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2, int[] paramArrayOfInt)
  {
    ChatMessage localChatMessage = paramChatMessage1;
    if (paramArrayList.size() > 0)
    {
      int i = paramArrayOfInt[0] - 1;
      localChatMessage = paramChatMessage1;
      if (i >= 0)
      {
        localChatMessage = paramChatMessage1;
        if (i < paramInt) {
          localChatMessage = (ChatMessage)paramList2.get(i);
        }
      }
      long l;
      if (localChatMessage == null) {
        l = -1L;
      } else {
        l = localChatMessage.shmsgseq;
      }
      paramList2 = paramQQAppInterface.getApp().getResources();
      if (paramArrayOfInt[2] == 1)
      {
        paramList1.addAll(paramArrayList);
      }
      else if (paramArrayOfInt[2] == 0)
      {
        paramList1.addAll(paramList3);
        paramList2 = a(paramQQAppInterface, paramList2, paramArrayList, l);
        paramList1.add(paramList2);
        a(paramQQAppInterface, paramChatMessage2, paramArrayList.size(), paramList2);
      }
      else
      {
        paramList1.addAll(paramArrayList);
        paramList2 = b(paramQQAppInterface, paramList2, paramArrayList, l);
        paramList1.add(paramList2);
        a(paramQQAppInterface, paramChatMessage2, paramList2);
      }
    }
    paramArrayList.clear();
    return localChatMessage;
  }
  
  private static String a(Resources paramResources, int paramInt)
  {
    paramResources = paramResources.getString(2131719865);
    try
    {
      paramResources = String.format(paramResources, new Object[] { Integer.valueOf(paramInt) });
      return paramResources;
    }
    catch (Exception paramResources)
    {
      label25:
      break label25;
    }
    return "text";
  }
  
  private static String a(QQAppInterface paramQQAppInterface, Resources paramResources, List<ChatMessage> paramList)
  {
    String str2 = paramResources.getString(2131719867);
    String str1 = paramResources.getString(2131719866);
    Object localObject1 = (ChatMessage)paramList.get(0);
    Object localObject2 = ((ChatMessage)localObject1).frienduin;
    String str3 = ((MessageForText)localObject1).msg;
    localObject1 = new StringBuilder();
    localObject2 = a(paramQQAppInterface, a(paramList), (String)localObject2);
    paramQQAppInterface = ((List)localObject2).iterator();
    while (paramQQAppInterface.hasNext())
    {
      ((StringBuilder)localObject1).append((String)paramQQAppInterface.next());
      ((StringBuilder)localObject1).append("、");
    }
    ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
    paramList = String.format(str2, new Object[] { Integer.valueOf(ListUtils.a((Collection)localObject2)), str3 });
    paramResources = paramResources.getDisplayMetrics();
    int i = ViewUtils.a() - ViewUtils.a(57.0F) - BaseChatItemLayout.y;
    paramQQAppInterface = paramList;
    if (a(paramResources, i, 1, paramList))
    {
      i = a(paramResources, i, paramList) - 18;
      paramQQAppInterface = paramList;
      if (i > 0)
      {
        paramQQAppInterface = paramList;
        if (i < str3.length())
        {
          int j = ListUtils.a((Collection)localObject2);
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(str3.substring(0, i));
          paramQQAppInterface.append("...");
          paramQQAppInterface = String.format(str2, new Object[] { Integer.valueOf(j), paramQQAppInterface.toString() });
        }
      }
    }
    ((StringBuilder)localObject1).insert(0, paramQQAppInterface);
    ((StringBuilder)localObject1).append(str1);
    return ((StringBuilder)localObject1).toString();
  }
  
  public static List<ChatMessage> a(@NonNull QQAppInterface paramQQAppInterface, @NonNull List<ChatMessage> paramList, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOfLong1, Set<Long> paramSet, Map<Long, Long> paramMap, long[] paramArrayOfLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mOpenAIOFirstMsgShmsgseq =");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",mOpenAIOLastMsgShmsgseq =");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(",minSameMsgCount = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",srcMsgList.size = ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.i("TroopMsgSameFold", 2, ((StringBuilder)localObject).toString());
    }
    a(paramBoolean);
    int m = paramList.size();
    int k = m - 1;
    int j = k;
    int i = 0;
    while (i < m)
    {
      if (((ChatMessage)paramList.get(i)).shmsgseq == paramLong2) {
        j = i;
      }
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("foldSameMsg.start = srcMsgList = ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(",ThreadName = ");
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    a(((StringBuilder)localObject).toString(), new Object[0]);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openAIOFirstMsgIndex =");
      ((StringBuilder)localObject).append(0);
      ((StringBuilder)localObject).append(",openAIOLastMsgIndex =");
      ((StringBuilder)localObject).append(j);
      QLog.i("TroopMsgSameFold", 2, ((StringBuilder)localObject).toString());
    }
    if (j < m) {
      localObject = paramList.subList(0, j + 1);
    } else {
      localObject = paramList;
    }
    paramArrayOfLong2 = a((List)localObject, paramInt, paramArrayOfLong1, paramSet, paramMap, paramArrayOfLong2);
    if (QLog.isColorLevel())
    {
      paramArrayOfLong1 = new StringBuilder();
      paramArrayOfLong1.append("findSameMsgIndexArr = ");
      paramArrayOfLong1.append(NumberUtil.a(paramArrayOfLong2));
      QLog.d("TroopMsgSameFold", 2, paramArrayOfLong1.toString());
    }
    if (paramArrayOfLong2 != null)
    {
      paramArrayOfLong1 = new StringBuilder();
      paramArrayOfLong1.append("findSameMsgArray = ");
      paramArrayOfLong1.append(paramArrayOfLong2.length);
      a(paramArrayOfLong1.toString(), new Object[0]);
      paramMap = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      a("foldSameMsg.add fold msg = ", new Object[0]);
      i = ((List)localObject).size();
      paramArrayOfLong1 = null;
      paramInt = 0;
      while (paramInt < i)
      {
        ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(paramInt);
        int[] arrayOfInt = a(paramArrayOfLong2, paramInt);
        if ((arrayOfInt != null) && (paramInt != 0))
        {
          if (a(arrayOfInt, paramInt))
          {
            paramSet = new StringBuilder();
            paramSet.append("inSame.");
            paramSet.append(paramInt);
            a(paramSet.toString(), new Object[0]);
            localArrayList1.add(localChatMessage);
            if (c(localChatMessage)) {
              localArrayList2.add(localChatMessage);
            }
            paramSet = paramArrayOfLong1;
            if (paramInt == arrayOfInt[1]) {
              paramSet = a(paramQQAppInterface, paramBoolean, paramMap, (List)localObject, localArrayList1, localArrayList2, i, paramArrayOfLong1, localChatMessage, arrayOfInt);
            }
          }
          else
          {
            paramMap.add(localChatMessage);
            localArrayList1.clear();
            localArrayList2.clear();
            paramSet = paramArrayOfLong1;
          }
        }
        else
        {
          a("foldSameMsg.not same piots ", new Object[0]);
          paramMap.add(localChatMessage);
          localArrayList1.clear();
          localArrayList2.clear();
          paramSet = paramArrayOfLong1;
        }
        paramInt += 1;
        paramArrayOfLong1 = paramSet;
      }
      a("foldSameMsg.add after msg = ", new Object[0]);
      paramQQAppInterface = paramMap;
      if (j < k)
      {
        paramMap.addAll(paramList.subList(j + 1, m));
        return paramMap;
      }
    }
    else
    {
      paramQQAppInterface = paramList;
    }
    return paramQQAppInterface;
  }
  
  @NotNull
  private static List<String> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      Object localObject = paramList.senderuin;
      String str;
      if (AnonymousChatHelper.a(paramList))
      {
        str = AnonymousChatHelper.a(paramList).b;
        paramList = str;
        if (TextUtils.isEmpty(str)) {
          paramList = (List<ChatMessage>)localObject;
        }
      }
      else
      {
        str = ContactUtils.b(paramQQAppInterface, paramString, (String)localObject);
        if (!TextUtils.isEmpty(str))
        {
          paramList = str;
          if (!str.equals(localObject)) {}
        }
        else
        {
          paramList = ContactUtils.a(paramQQAppInterface, (String)localObject);
        }
      }
      localObject = paramList;
      if (paramList.length() > 20)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramList.substring(0, 20));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  private static List<ChatMessage> a(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!c(localChatMessage)) {
        if (AnonymousChatHelper.a(localChatMessage))
        {
          String str = AnonymousChatHelper.a(localChatMessage).b;
          paramList = str;
          if (TextUtils.isEmpty(str)) {
            paramList = localChatMessage.senderuin;
          }
          if (localHashSet2.add(paramList)) {
            localArrayList.add(localChatMessage);
          }
        }
        else if (localHashSet1.add(localChatMessage.senderuin))
        {
          localArrayList.add(localChatMessage);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage1, int paramInt, ChatMessage paramChatMessage2)
  {
    if (!b.contains(Long.valueOf(paramChatMessage2.shmsgseq)))
    {
      if (paramInt > 15) {
        paramInt = 15;
      }
      String str = paramChatMessage1.frienduin;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramChatMessage1.shmsgseq);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800ADF2", "0X800ADF2", paramInt, 1, str, localStringBuilder.toString(), "", "");
      b.add(Long.valueOf(paramChatMessage2.shmsgseq));
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (!jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramChatMessage2.shmsgseq)))
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B191", "0X800B191", 0, 1, paramChatMessage1.frienduin, String.valueOf(paramChatMessage1.shmsgseq), "", "");
      jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramChatMessage2.shmsgseq));
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    paramString = String.format(paramString, paramVarArgs);
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, paramString);
    }
  }
  
  private static void a(@NonNull List<ChatMessage> paramList, long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    if (paramInt > 0)
    {
      paramInt -= 1;
      a(paramArrayOfLong1, paramArrayOfInt1, paramInt, paramArrayOfLong2, paramArrayOfInt2, (ChatMessage)paramList.get(paramInt));
    }
  }
  
  private static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      jdField_a_of_type_JavaUtilList.clear();
      b.clear();
    }
  }
  
  private static void a(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2, ChatMessage paramChatMessage)
  {
    long l = paramChatMessage.shmsgseq;
    int j = 0;
    int i;
    if (paramArrayOfLong2 != null)
    {
      i = 0;
      while (i < paramArrayOfLong2.length)
      {
        if ((l == paramArrayOfLong2[i]) && (paramArrayOfInt2[i] == -1))
        {
          paramArrayOfInt2[i] = paramInt;
          break;
        }
        i += 1;
      }
    }
    if (paramArrayOfLong1 != null)
    {
      i = j;
      while (i < paramArrayOfLong1.length)
      {
        if ((l == paramArrayOfLong1[i]) && (paramArrayOfInt1[i] == -1))
        {
          paramArrayOfInt1[i] = paramInt;
          return;
        }
        i += 1;
      }
    }
  }
  
  private static void a(int[][] paramArrayOfInt, int[] paramArrayOfInt1)
  {
    boolean bool = jdField_a_of_type_Boolean;
    int j = 0;
    int i;
    if (bool) {
      if (paramArrayOfInt == null)
      {
        a("find same msg result is null", new Object[0]);
      }
      else
      {
        int k = paramArrayOfInt.length;
        StringBuilder localStringBuilder = new StringBuilder("find same msg result:size = %d,range : ");
        i = 0;
        while (i < k)
        {
          localStringBuilder.append(i);
          localStringBuilder.append("same start = ");
          localStringBuilder.append(paramArrayOfInt[i][0]);
          localStringBuilder.append(",");
          localStringBuilder.append(i);
          localStringBuilder.append("same end = ");
          localStringBuilder.append(paramArrayOfInt[i][1]);
          i += 1;
        }
        if (paramArrayOfInt1 != null)
        {
          k = paramArrayOfInt1.length;
          i = 0;
          while (i < k)
          {
            localStringBuilder.append(i);
            localStringBuilder.append("foldIndex ={ ");
            localStringBuilder.append(paramArrayOfInt1[i]);
            localStringBuilder.append(",");
            i += 1;
          }
          localStringBuilder.append("}");
        }
      }
    }
    if (QLog.isColorLevel())
    {
      if (paramArrayOfInt == null) {
        i = 0;
      } else {
        i = paramArrayOfInt.length;
      }
      if (paramArrayOfInt1 != null) {
        j = paramArrayOfInt1.length;
      }
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("find same msg result size = ");
      paramArrayOfInt.append(i);
      paramArrayOfInt.append(", fold len = ");
      paramArrayOfInt.append(j);
      QLog.i("TroopMsgSameFold", 2, paramArrayOfInt.toString());
    }
  }
  
  public static boolean a()
  {
    TroopFoldMsgBean localTroopFoldMsgBean = TroopFoldMsgConfProcessor.a();
    boolean bool;
    if (!localTroopFoldMsgBean.jdField_a_of_type_Boolean) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigSwitch = ");
      localStringBuilder.append(localTroopFoldMsgBean.jdField_a_of_type_Boolean);
      localStringBuilder.append(", openSwitch = ");
      localStringBuilder.append(bool);
      QLog.i("TroopMsgSameFold", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private static boolean a(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, String paramString)
  {
    paramInt1 *= paramInt2;
    boolean bool = true;
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.setTextSize(12.0F);
    localTextPaint.density = paramDisplayMetrics.density;
    float f1 = paramDisplayMetrics.scaledDensity;
    float f2 = localTextPaint.measureText(paramString);
    if (f2 * f1 <= paramInt1) {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      paramDisplayMetrics = new StringBuilder();
      paramDisplayMetrics.append("desirwidtch = ");
      paramDisplayMetrics.append(f2);
      paramDisplayMetrics.append(",limitWidth = ");
      paramDisplayMetrics.append(paramInt1);
      paramDisplayMetrics.append(",isExceed = ");
      paramDisplayMetrics.append(bool);
      QLog.d("TroopMsgSameFold", 4, paramDisplayMetrics.toString());
      paramDisplayMetrics = new StringBuilder();
      paramDisplayMetrics.append("test.a = ");
      paramDisplayMetrics.append(localTextPaint.measureText("a"));
      paramDisplayMetrics.append(",中 = ");
      paramDisplayMetrics.append(localTextPaint.measureText("中"));
      paramDisplayMetrics.append(",screenW = ");
      paramDisplayMetrics.append(ViewUtils.a());
      QLog.d("TroopMsgSameFold", 4, paramDisplayMetrics.toString());
      paramDisplayMetrics = new StringBuilder();
      paramDisplayMetrics.append("test.density = ");
      paramDisplayMetrics.append(localTextPaint.density);
      paramDisplayMetrics.append(",scaleDenisty = ");
      paramDisplayMetrics.append(f1);
      QLog.d("TroopMsgSameFold", 4, paramDisplayMetrics.toString());
    }
    return bool;
  }
  
  public static boolean a(@NonNull ChatMessage paramChatMessage)
  {
    int i = paramChatMessage.msgtype;
    return (i == -1051) || (i == -1000);
  }
  
  protected static boolean a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (paramChatMessage1 == null)
    {
      if (paramChatMessage2 == null) {
        return true;
      }
    }
    else if ((paramChatMessage2 != null) && (paramChatMessage1.msgtype == paramChatMessage2.msgtype) && (TextUtils.equals(paramChatMessage1.msg, paramChatMessage2.msg))) {
      return true;
    }
    return false;
  }
  
  public static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= paramArrayOfInt[0])
    {
      bool1 = bool2;
      if (paramInt <= paramArrayOfInt[1]) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static int[] a(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      int[] arrayOfInt = new int[paramArrayOfLong.length];
      int i = 0;
      for (;;)
      {
        paramArrayOfLong = arrayOfInt;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = -1;
        i += 1;
      }
    }
    paramArrayOfLong = null;
    return paramArrayOfLong;
  }
  
  public static int[] a(@NonNull int[][] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i][0];
      int m = paramArrayOfInt[i][1];
      int n = paramArrayOfInt[i][2];
      a("sameMsgArray.range start = %d,end = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      if ((paramInt >= k) && (paramInt <= m) && (m > k)) {
        return new int[] { k, m, n };
      }
      i += 1;
    }
    return null;
  }
  
  private static int[][] a(int paramInt)
  {
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt + 1, 3 });
    int i = arrayOfInt.length;
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfInt[paramInt][2] = -1;
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  public static int[][] a(@NonNull List<ChatMessage> paramList, int paramInt, long[] paramArrayOfLong1, @NonNull Set<Long> paramSet, @NonNull Map<Long, Long> paramMap, long[] paramArrayOfLong2)
  {
    int i = paramInt;
    if (i == 0) {
      return (int[][])null;
    }
    int m = paramList.size();
    int[][] arrayOfInt = a(Math.max(1, m / i));
    boolean bool = ListUtils.a(paramSet);
    int[] arrayOfInt2 = a(paramArrayOfLong1);
    int[] arrayOfInt1 = a(paramArrayOfLong2);
    long l1 = -1L;
    Object localObject1 = null;
    int n = 0;
    int i1 = 0;
    int j = 0;
    int k = 0;
    i = 0;
    while (j < m)
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(j);
      int i3;
      if (!a(localChatMessage)) {
        if ((d(localChatMessage)) && (j < m - 1))
        {
          i3 = m;
          i2 = j;
          j = n;
          m = i1;
          n = i3;
        }
        else
        {
          i1 = a(paramList, paramInt, paramArrayOfLong1, arrayOfInt, n, i1, arrayOfInt2, k, paramArrayOfLong2, arrayOfInt1);
          localObject1 = null;
          i2 = i;
          n = m;
          i = j;
          j = i1;
          m = 0;
        }
      }
      int[] arrayOfInt3;
      for (i1 = i;; i1 = i)
      {
        i = i2;
        i2 = i1;
        i1 = m;
        m = i2;
        break label976;
        arrayOfInt3 = arrayOfInt1;
        i3 = i;
        i2 = n;
        n = m;
        i = i1;
        Object localObject2 = (ChatMessage)paramList.get(j);
        if (!bool) {
          label750:
          for (;;)
          {
            Object localObject3;
            if (paramSet.contains(Long.valueOf(((ChatMessage)localObject2).shmsgseq)))
            {
              long l2 = ((ChatMessage)localObject2).shmsgseq;
              localObject3 = (Long)paramMap.get(Long.valueOf(l2));
              if (localObject3 != null)
              {
                m = j + 1;
                if (m >= n) {
                  break label750;
                }
                if ((i >= paramInt) && (!a((ChatMessage)localObject1, (ChatMessage)localObject2)))
                {
                  arrayOfInt[i2][1] = (j - 1);
                  a(paramList, paramArrayOfLong1, arrayOfInt2, j, paramArrayOfLong2, arrayOfInt3);
                  i2 += 1;
                }
                l1 = ((Long)localObject3).longValue();
                arrayOfInt[i2][0] = m;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("find fold msg, index = ");
                ((StringBuilder)localObject1).append(j);
                ((StringBuilder)localObject1).append(", shMsgSeq = ");
                ((StringBuilder)localObject1).append(l2);
                a(((StringBuilder)localObject1).toString(), new Object[0]);
                localObject1 = null;
                i = 0;
                i3 = 1;
              }
              else
              {
                break label750;
              }
            }
            else
            {
              if (i3 == 0) {
                break label750;
              }
              if (l1 == ((ChatMessage)localObject2).shmsgseq)
              {
                arrayOfInt[i2][1] = j;
                a(paramArrayOfLong1, arrayOfInt2, j, paramArrayOfLong2, arrayOfInt3, (ChatMessage)localObject2);
                j += 1;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("end fold msg, index = ");
                ((StringBuilder)localObject2).append(j);
                ((StringBuilder)localObject2).append(", shMsgSeq = ");
                ((StringBuilder)localObject2).append(l1);
                a(((StringBuilder)localObject2).toString(), new Object[0]);
              }
              for (m = i2 + 1;; m = i2 + 1)
              {
                i1 = 0;
                break label761;
                if (l1 >= ((ChatMessage)localObject2).shmsgseq) {
                  break;
                }
                arrayOfInt[i2][1] = (j - 1);
                a(paramList, paramArrayOfLong1, arrayOfInt2, j, paramArrayOfLong2, arrayOfInt3);
                j += 1;
                if (!((ChatMessage)localObject2).isSend()) {
                  localObject1 = localObject2;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("end fold msg, index = ");
                ((StringBuilder)localObject3).append(j);
                ((StringBuilder)localObject3).append(", shMsgSeq = ");
                ((StringBuilder)localObject3).append(l1);
                ((StringBuilder)localObject3).append(", msg.shmsgseq = ");
                ((StringBuilder)localObject3).append(((ChatMessage)localObject2).shmsgseq);
                a(((StringBuilder)localObject3).toString(), new Object[0]);
              }
            }
            i1 = n;
            m = j + 1;
            if (m >= i1)
            {
              j = i3;
              i3 = m;
              m = i2;
              i1 = i;
              i = i3;
              break label781;
            }
            n = i1;
            j = m;
            break;
          }
        }
        m = i2;
        i1 = i3;
        label761:
        i2 = j;
        i3 = i;
        j = i1;
        i = i2;
        i1 = i3;
        label781:
        if (i >= n) {
          break label1001;
        }
        if (localObject1 != null) {
          break label851;
        }
        if (!localChatMessage.isSend())
        {
          localObject1 = (ChatMessage)paramList.get(i);
          k = i;
          i2 = j;
          j = m;
          break;
        }
        i2 = j;
        j = m;
        m = i1;
      }
      label851:
      if (a((ChatMessage)localObject1, localChatMessage))
      {
        i1 = a(arrayOfInt, m, i1, i, localChatMessage);
        m = a(paramInt, paramArrayOfLong1, n, arrayOfInt, m, i1, arrayOfInt2, i, paramArrayOfLong2, arrayOfInt3, localChatMessage);
        k = i;
        i2 = j;
        j = m;
        m = i;
        i = i2;
      }
      else
      {
        i2 = a(paramList, paramInt, paramArrayOfLong1, arrayOfInt, m, i1, arrayOfInt2, k, paramArrayOfLong2, arrayOfInt3);
        localObject1 = localChatMessage;
        if (localChatMessage.isSend()) {
          localObject1 = null;
        }
        m = i;
        i = j;
        i1 = 0;
        j = i2;
      }
      label976:
      int i2 = m + 1;
      m = n;
      n = j;
      j = i2;
    }
    m = n;
    label1001:
    paramList = a(arrayOfInt, m, arrayOfInt2, arrayOfInt1);
    a(paramList, arrayOfInt2);
    return paramList;
  }
  
  private static int[][] a(int[][] paramArrayOfInt, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[][] arrayOfInt = (int[][])null;
    if (paramInt >= 0)
    {
      paramInt += 1;
      arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt, 3 });
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt);
    }
    int i;
    if ((paramArrayOfInt2 != null) && (arrayOfInt != null))
    {
      paramInt = 0;
      while (paramInt < paramArrayOfInt2.length)
      {
        long l = paramArrayOfInt2[paramInt];
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("find foldThenExpandIndex index = ");
        paramArrayOfInt.append(l);
        a(paramArrayOfInt.toString(), new Object[0]);
        i = 0;
        while (i < arrayOfInt.length)
        {
          if (arrayOfInt[i][1] == l) {
            arrayOfInt[i][2] = 1;
          }
          i += 1;
        }
        paramInt += 1;
      }
    }
    if ((paramArrayOfInt1 != null) && (arrayOfInt != null))
    {
      paramInt = 0;
      while (paramInt < paramArrayOfInt1.length)
      {
        int j = paramArrayOfInt1[paramInt];
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("find fold index = ");
        paramArrayOfInt.append(j);
        a(paramArrayOfInt.toString(), new Object[0]);
        i = 0;
        while (i < arrayOfInt.length)
        {
          if (arrayOfInt[i][1] == j) {
            arrayOfInt[i][2] = 0;
          }
          i += 1;
        }
        paramInt += 1;
      }
    }
    return arrayOfInt;
  }
  
  public static int b()
  {
    TroopFoldMsgBean localTroopFoldMsgBean = TroopFoldMsgConfProcessor.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigSwitch = ");
      localStringBuilder.append(localTroopFoldMsgBean.b);
      QLog.i("TroopMsgSameFold", 2, localStringBuilder.toString());
    }
    return localTroopFoldMsgBean.b;
  }
  
  private static ChatMessage b(QQAppInterface paramQQAppInterface, Resources paramResources, List<ChatMessage> paramList, long paramLong)
  {
    paramResources = a(paramResources, a(paramList));
    int i = paramResources.length();
    paramResources = paramResources.concat(HardCodeUtil.a(2131719806));
    return a(paramQQAppInterface, paramList, paramLong, paramResources, i, paramResources.length(), 61, false);
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null)
    {
      bool1 = bool2;
      if ((paramChatMessage instanceof MessageForUniteGrayTip))
      {
        bool1 = bool2;
        if (((MessageForUniteGrayTip)paramChatMessage).tipParam.b == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected static boolean c(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.isSend()) || (d(paramChatMessage));
  }
  
  public static boolean d(ChatMessage paramChatMessage)
  {
    return (paramChatMessage != null) && (((paramChatMessage instanceof MessageForUniteGrayTip)) || ((paramChatMessage instanceof MessageForGrayTips)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.troop.TroopMsgSameFold
 * JD-Core Version:    0.7.0.1
 */