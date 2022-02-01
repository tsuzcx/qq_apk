package com.tencent.mobileqq.activity.aio.troop;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.TroopFoldMsgBean;
import com.tencent.mobileqq.config.business.TroopFoldMsgConfProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<+Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/troop/TroopMsgSameFold;", "", "()V", "FOLD_GRAY_TIP_PRE_TEXT_LEN", "", "FOLD_GRAY_TIP_PRE_TEXT_WIDTH", "TAG", "", "TYPE_EXPAND", "TYPE_EXPAND_THEN_FOLD", "TYPE_FOLD", "configLoadMoreMsgCount", "configLoadMoreMsgCount$annotations", "getConfigLoadMoreMsgCount", "()I", "configMsgCount", "configMsgCount$annotations", "getConfigMsgCount", "configSwitch", "", "configSwitch$annotations", "getConfigSwitch", "()Z", "sHasReportShowExpandGrayTips", "", "", "sHasReportShowFoldGrayTips", "sLogSwitch", "getSLogSwitch", "setSLogSwitch", "(Z)V", "clearReportList", "", "isFirstOpenAIO", "filterSelfMsgList", "", "Lcom/tencent/mobileqq/data/ChatMessage;", "chatMessageList", "filterSelfUserSize", "findSameMsgIndexArr", "", "", "srcMsgList", "minSameMsgCount", "foldShMsgSeqArr", "", "foldMsgFirstShMsgSeqSet", "", "foldMsgShMsgSeqPair", "", "foldThenExpandMsgLastShMsgSeqArr", "(Ljava/util/List;I[JLjava/util/Set;Ljava/util/Map;[J)[[I", "foldSameMsg", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "openAIOFirstShmsgseq", "openAIOLastShmsgseq", "getAllUserNicknameGrayTipWording", "res", "Landroid/content/res/Resources;", "getCommonInitIndexArray", "shMsgSeqArr", "getFitTextSize", "dm", "Landroid/util/DisplayMetrics;", "textviewWidth", "source", "getFoldMsgGrayTipWording", "msgCount", "getGrayTipWording", "getInitSameMsgIndexArray", "maxGroup", "(I)[[I", "getNickSetFromMsgList", "troopUin", "getSameMsgPiots", "sameMsgArray", "index", "([[II)[I", "handleIndexEndIfNeed", "size", "sameMsgIndexArray", "sameMsgPointer", "curSameMsgCount", "foldIndexArray", "lastSameIndex", "foldThenExpandIndexArray", "chatMessage", "(I[JI[[III[II[J[ILcom/tencent/mobileqq/data/ChatMessage;)I", "handleOneSameNodeIfExit", "(Ljava/util/List;I[J[[III[II[J[I)I", "handleSameMsg", "i", "([[IIIILcom/tencent/mobileqq/data/ChatMessage;)I", "handleSameNodeEndIndexMsg", "dstMsgList", "needHandleMsgList", "tempSameMsgList", "Ljava/util/ArrayList;", "tempNoFoldMsgList", "needHandleSize", "firstSameMsg", "curMsg", "sameArray", "isFoldCareMsgType", "isFoldGrayMsg", "message", "isIgnoreMsg", "isInSameMsgs", "isMsgNoFold", "msg", "isTowMsgSame", "left", "right", "isWordingExceed", "lineCount", "log", "logStr", "param", "(Ljava/lang/String;[Ljava/lang/Object;)V", "logSameIndexArrayForDebug", "resultSameMsgIndexArray", "([[I[I)V", "makeCommonFoldMsgGrayTip", "firstShMsgSeq", "wording", "highStartIndex", "highEndIndex", "actionType", "isFold", "makeFoldMsgGrayTip", "makeGrayTipBundle", "Landroid/os/Bundle;", "lastShMsgSeq", "makeSameIndexArray", "([[II[I[I)[[I", "replaceSameMsgToGrayTip", "report", "replaceMsg", "reportAddFoldGrayTip", "foldMsgGrayTip", "updateFoldMsgIndexArr", "updateFoldMsgIndexArrPreMsg", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopMsgSameFold
{
  @JvmField
  @NotNull
  public static List<Long> a = (List)new ArrayList();
  @JvmField
  @NotNull
  public static List<Long> b = (List)new ArrayList();
  public static final TroopMsgSameFold c = new TroopMsgSameFold();
  private static boolean d;
  
  private final int a(int paramInt1, long[] paramArrayOfLong1, int paramInt2, int[][] paramArrayOfInt, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, long[] paramArrayOfLong2, int[] paramArrayOfInt2, ChatMessage paramChatMessage)
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
  
  private final int a(DisplayMetrics paramDisplayMetrics, int paramInt, String paramString)
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
        break label106;
      }
      if (paramString == null) {
        break;
      }
      paramDisplayMetrics = paramString.substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(paramDisplayMetrics, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (localTextPaint.measureText(paramDisplayMetrics) * f > paramInt)
      {
        j = i - 1;
        break label106;
      }
      i += 1;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    label106:
    a("getFitTextSize = fitSize = %d", new Object[] { Integer.valueOf(j) });
    return j;
  }
  
  @JvmStatic
  public static final int a(@NotNull List<? extends ChatMessage> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "chatMessageList");
    return ListUtils.b((Collection)c.b(paramList));
  }
  
  private final int a(List<? extends ChatMessage> paramList, int paramInt1, long[] paramArrayOfLong1, int[][] paramArrayOfInt, int paramInt2, int paramInt3, int[] paramArrayOfInt1, int paramInt4, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    if (paramInt3 >= paramInt1)
    {
      paramArrayOfInt[paramInt2][1] = paramInt4;
      a(paramArrayOfLong1, paramArrayOfInt1, paramInt4, paramArrayOfLong2, paramArrayOfInt2, (ChatMessage)paramList.get(paramInt4));
      return paramInt2 + 1;
    }
    return paramInt2;
  }
  
  private final int a(int[][] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, ChatMessage paramChatMessage)
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
  
  private final Bundle a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_action_DATA", String.valueOf(paramLong1));
    localBundle.putString("key_a_action_DATA", String.valueOf(paramLong2));
    return localBundle;
  }
  
  private final ChatMessage a(QQAppInterface paramQQAppInterface, List<? extends ChatMessage> paramList, long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = ListUtils.b((Collection)paramList);
    Object localObject = (ChatMessage)paramList.get(0);
    if (i > 1) {
      paramList = (ChatMessage)paramList.get(i - 1);
    } else {
      paramList = (List<? extends ChatMessage>)localObject;
    }
    if (paramList == null) {
      Intrinsics.throwNpe();
    }
    String str1 = paramList.frienduin;
    String str2 = paramQQAppInterface.getCurrentUin();
    long l1 = paramList.time;
    i = paramList.istroop;
    if (paramLong == -1L)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      paramLong = ((ChatMessage)localObject).shmsgseq;
    }
    long l2 = paramList.shmsgseq;
    long l3 = paramList.uniseq;
    paramList = new UniteGrayTipParam(str1, str2, paramString, i, -5040, 2, l1);
    paramList.a(paramInt1, paramInt2, a(paramInt3, paramLong, l2, paramBoolean));
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg((AppRuntime)paramQQAppInterface, paramList);
    ((MessageForUniteGrayTip)localObject).msg = paramString;
    ((MessageForUniteGrayTip)localObject).shmsgseq = l2;
    ((MessageForUniteGrayTip)localObject).uniseq = (l3 + 1L);
    return (ChatMessage)localObject;
  }
  
  private final ChatMessage a(QQAppInterface paramQQAppInterface, boolean paramBoolean, List<ChatMessage> paramList, List<? extends ChatMessage> paramList1, ArrayList<ChatMessage> paramArrayList, List<? extends ChatMessage> paramList2, int paramInt, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2, int[] paramArrayOfInt)
  {
    if (paramArrayList.size() > 0)
    {
      int i = paramArrayOfInt[0] - 1;
      if ((i >= 0) && (i < paramInt)) {
        paramList1 = (ChatMessage)paramList1.get(i);
      } else {
        paramList1 = paramChatMessage1;
      }
      long l;
      if (paramList1 != null) {
        l = paramList1.shmsgseq;
      } else {
        l = -1L;
      }
      paramChatMessage1 = paramQQAppInterface.getApp();
      Intrinsics.checkExpressionValueIsNotNull(paramChatMessage1, "app.app");
      paramChatMessage1 = paramChatMessage1.getResources();
      if (paramArrayOfInt[2] == 1)
      {
        paramList.addAll((Collection)paramArrayList);
      }
      else if (paramArrayOfInt[2] == 0)
      {
        paramList.addAll((Collection)paramList2);
        Intrinsics.checkExpressionValueIsNotNull(paramChatMessage1, "res");
        paramList2 = a(paramQQAppInterface, paramChatMessage1, (List)paramArrayList, l);
        paramList.add(paramList2);
        a(paramQQAppInterface, paramChatMessage2, paramArrayList.size(), paramList2);
      }
      else
      {
        paramList.addAll((Collection)paramArrayList);
        Intrinsics.checkExpressionValueIsNotNull(paramChatMessage1, "res");
        paramList2 = b(paramQQAppInterface, paramChatMessage1, (List)paramArrayList, l);
        paramList.add(paramList2);
        a(paramQQAppInterface, paramChatMessage2, paramList2);
      }
    }
    else
    {
      paramList1 = paramChatMessage1;
    }
    paramArrayList.clear();
    return paramList1;
  }
  
  private final String a(Resources paramResources, int paramInt)
  {
    paramResources = paramResources.getString(2131917470);
    try
    {
      Object localObject = StringCompanionObject.INSTANCE;
      Intrinsics.checkExpressionValueIsNotNull(paramResources, "formatStr");
      localObject = new Object[1];
      localObject[0] = Integer.valueOf(paramInt);
      paramResources = String.format(paramResources, Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(paramResources, "java.lang.String.format(format, *args)");
      return paramResources;
    }
    catch (Exception paramResources)
    {
      label51:
      break label51;
    }
    return "text";
  }
  
  private final String a(QQAppInterface paramQQAppInterface, Resources paramResources, List<? extends ChatMessage> paramList)
  {
    String str2 = paramResources.getString(2131917472);
    String str1 = paramResources.getString(2131917471);
    Object localObject1 = (ChatMessage)paramList.get(0);
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    Object localObject2 = ((ChatMessage)localObject1).frienduin;
    String str3 = ((MessageForText)localObject1).msg;
    localObject1 = new StringBuilder();
    paramList = b(paramList);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "troopUin");
    paramQQAppInterface = a(paramQQAppInterface, paramList, (String)localObject2);
    paramList = paramQQAppInterface.iterator();
    while (paramList.hasNext())
    {
      ((StringBuilder)localObject1).append((String)paramList.next());
      ((StringBuilder)localObject1).append("、");
    }
    ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
    paramList = StringCompanionObject.INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(str2, "firstLineResStr");
    paramList = new Object[2];
    localObject2 = (Collection)paramQQAppInterface;
    paramList[0] = Integer.valueOf(ListUtils.b((Collection)localObject2));
    paramList[1] = str3;
    paramList = String.format(str2, Arrays.copyOf(paramList, paramList.length));
    Intrinsics.checkExpressionValueIsNotNull(paramList, "java.lang.String.format(format, *args)");
    paramResources = paramResources.getDisplayMetrics();
    int i = ViewUtils.getScreenWidth() - ViewUtils.dip2px(57) - BaseChatItemLayout.y;
    Intrinsics.checkExpressionValueIsNotNull(paramResources, "dm");
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
          paramQQAppInterface = StringCompanionObject.INSTANCE;
          paramQQAppInterface = new Object[2];
          paramQQAppInterface[0] = Integer.valueOf(ListUtils.b((Collection)localObject2));
          paramResources = new StringBuilder();
          Intrinsics.checkExpressionValueIsNotNull(str3, "msgText");
          if (str3 != null)
          {
            paramList = str3.substring(0, i);
            Intrinsics.checkExpressionValueIsNotNull(paramList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            paramResources.append(paramList);
            paramResources.append("...");
            paramQQAppInterface[1] = paramResources.toString();
            paramQQAppInterface = String.format(str2, Arrays.copyOf(paramQQAppInterface, paramQQAppInterface.length));
            Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "java.lang.String.format(format, *args)");
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
        }
      }
    }
    ((StringBuilder)localObject1).insert(0, paramQQAppInterface);
    ((StringBuilder)localObject1).append(str1);
    paramQQAppInterface = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "stringBuilder.toString()");
    return paramQQAppInterface;
  }
  
  @JvmStatic
  @NotNull
  public static final List<ChatMessage> a(@NotNull QQAppInterface paramQQAppInterface, @NotNull List<ChatMessage> paramList, int paramInt, long paramLong1, long paramLong2, @Nullable long[] paramArrayOfLong1, @NotNull Set<Long> paramSet, @NotNull Map<Long, Long> paramMap, @Nullable long[] paramArrayOfLong2, boolean paramBoolean)
  {
    List<ChatMessage> localList = paramList;
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(localList, "srcMsgList");
    Intrinsics.checkParameterIsNotNull(paramSet, "foldMsgFirstShMsgSeqSet");
    Intrinsics.checkParameterIsNotNull(paramMap, "foldMsgShMsgSeqPair");
    boolean bool = QLog.isColorLevel();
    Object localObject1 = "TroopMsgSameFold";
    if (bool)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mOpenAIOFirstMsgShmsgseq =");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append("mOpenAIOLastMsgShmsgseq =");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append(",minSameMsgCount = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(",srcMsgList.size = ");
      ((StringBuilder)localObject2).append(paramList.size());
      QLog.i("TroopMsgSameFold", 2, ((StringBuilder)localObject2).toString());
    }
    c.a(paramBoolean);
    int m = paramList.size();
    int k = m - 1;
    int j = k;
    int i = 0;
    while (i < m)
    {
      if (((ChatMessage)localList.get(i)).shmsgseq == paramLong2) {
        j = i;
      }
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("foldSameMsg.start = srcMsgList = ");
    paramList.append(m);
    paramList.append(",ThreadName = ");
    Object localObject2 = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Thread.currentThread()");
    paramList.append(((Thread)localObject2).getName());
    a(paramList.toString(), new Object[0]);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("openAIOFirstMsgIndex =");
      paramList.append(0);
      paramList.append(",openAIOLastMsgIndex =");
      paramList.append(j);
      QLog.i((String)localObject1, 2, paramList.toString());
    }
    if (j < m) {
      paramList = localList.subList(0, j + 1);
    } else {
      paramList = localList;
    }
    paramSet = c.a(paramList, paramInt, paramArrayOfLong1, paramSet, paramMap, paramArrayOfLong2);
    if (QLog.isColorLevel())
    {
      paramArrayOfLong1 = new StringBuilder();
      paramArrayOfLong1.append("findSameMsgIndexArr = ");
      paramArrayOfLong1.append(NumberUtil.a(paramSet));
      QLog.d((String)localObject1, 2, paramArrayOfLong1.toString());
    }
    paramArrayOfLong1 = localList;
    if (paramSet != null)
    {
      paramArrayOfLong1 = new StringBuilder();
      paramArrayOfLong1.append("findSameMsgArray = ");
      paramArrayOfLong1.append(((Object[])paramSet).length);
      a(paramArrayOfLong1.toString(), new Object[0]);
      paramArrayOfLong1 = (List)new ArrayList();
      paramMap = new ArrayList();
      paramArrayOfLong2 = (List)new ArrayList();
      a("foldSameMsg.add fold msg = ", new Object[0]);
      paramInt = paramList.size();
      localObject1 = (ChatMessage)null;
      i = 0;
      while (i < paramInt)
      {
        localObject2 = (ChatMessage)paramList.get(i);
        int[] arrayOfInt = c.a(paramSet, i);
        if ((arrayOfInt != null) && (i != 0))
        {
          if (c.a(arrayOfInt, i))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("inSame.");
            localStringBuilder.append(i);
            a(localStringBuilder.toString(), new Object[0]);
            paramMap.add(localObject2);
            if (c((ChatMessage)localObject2)) {
              paramArrayOfLong2.add(localObject2);
            }
            if (i == arrayOfInt[1]) {
              localObject1 = c.a(paramQQAppInterface, paramBoolean, paramArrayOfLong1, paramList, paramMap, paramArrayOfLong2, paramInt, (ChatMessage)localObject1, (ChatMessage)localObject2, arrayOfInt);
            }
          }
          else
          {
            paramArrayOfLong1.add(localObject2);
            paramMap.clear();
            paramArrayOfLong2.clear();
          }
        }
        else
        {
          a("foldSameMsg.not same piots ", new Object[0]);
          paramArrayOfLong1.add(localObject2);
          paramMap.clear();
          paramArrayOfLong2.clear();
        }
        i += 1;
      }
      a("foldSameMsg.add after msg = ", new Object[0]);
      if (j < k) {
        paramArrayOfLong1.addAll((Collection)localList.subList(j + 1, m));
      }
    }
    return paramArrayOfLong1;
  }
  
  private final List<String> a(QQAppInterface paramQQAppInterface, List<? extends ChatMessage> paramList, String paramString)
  {
    List localList = (List)new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      if (paramList == null) {
        Intrinsics.throwNpe();
      }
      Object localObject = paramList.senderuin;
      paramList = (MessageRecord)paramList;
      String str;
      if (AnonymousChatHelper.c(paramList))
      {
        str = AnonymousChatHelper.g(paramList).c;
        Intrinsics.checkExpressionValueIsNotNull(str, "AnonymousChatHelper.getA…xtra(chatMessage).an_nick");
        paramList = str;
        if (TextUtils.isEmpty((CharSequence)str))
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject, "senderUin");
          paramList = (List<? extends ChatMessage>)localObject;
        }
      }
      else
      {
        str = ContactUtils.b((AppInterface)paramQQAppInterface, paramString, (String)localObject);
        Intrinsics.checkExpressionValueIsNotNull(str, "ContactUtils.getTroopMem…app, troopUin, senderUin)");
        if (!TextUtils.isEmpty((CharSequence)str))
        {
          paramList = str;
          if (!Intrinsics.areEqual(str, localObject)) {}
        }
        else
        {
          paramList = ContactUtils.a((AppRuntime)paramQQAppInterface, (String)localObject);
          Intrinsics.checkExpressionValueIsNotNull(paramList, "ContactUtils.getFriendNick(app, senderUin)");
        }
      }
      localObject = paramList;
      if (paramList.length() > 20)
      {
        localObject = new StringBuilder();
        if (paramList != null)
        {
          paramList = paramList.substring(0, 20);
          Intrinsics.checkExpressionValueIsNotNull(paramList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ((StringBuilder)localObject).append(paramList);
          ((StringBuilder)localObject).append("...");
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      localList.add(localObject);
    }
    return localList;
  }
  
  private final void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (!a.contains(Long.valueOf(paramChatMessage2.shmsgseq)))
    {
      ReportController.b((AppRuntime)paramQQAppInterface, "dc00898", "", "", "0X800B191", "0X800B191", 0, 1, paramChatMessage1.frienduin, String.valueOf(paramChatMessage1.shmsgseq), "", "");
      a.add(Long.valueOf(paramChatMessage2.shmsgseq));
    }
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "param");
    if (!d) {
      return;
    }
    StringCompanionObject localStringCompanionObject = StringCompanionObject.INSTANCE;
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
    paramString = String.format(paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(format, *args)");
    if (QLog.isColorLevel()) {
      QLog.i("TroopMsgSameFold", 2, paramString);
    }
  }
  
  private final void a(List<? extends ChatMessage> paramList, long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    if (paramInt > 0)
    {
      paramInt -= 1;
      a(paramArrayOfLong1, paramArrayOfInt1, paramInt, paramArrayOfLong2, paramArrayOfInt2, (ChatMessage)paramList.get(paramInt));
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a.clear();
      b.clear();
    }
  }
  
  private final void a(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2, ChatMessage paramChatMessage)
  {
    long l = paramChatMessage.shmsgseq;
    int j = 0;
    int k;
    int i;
    if (paramArrayOfLong2 != null)
    {
      k = paramArrayOfLong2.length;
      i = 0;
      while (i < k)
      {
        if (l == paramArrayOfLong2[i])
        {
          if (paramArrayOfInt2 == null) {
            Intrinsics.throwNpe();
          }
          if (paramArrayOfInt2[i] == -1)
          {
            paramArrayOfInt2[i] = paramInt;
            break;
          }
        }
        i += 1;
      }
    }
    if (paramArrayOfLong1 != null)
    {
      k = paramArrayOfLong1.length;
      i = j;
      while (i < k)
      {
        if (l == paramArrayOfLong1[i])
        {
          if (paramArrayOfInt1 == null) {
            Intrinsics.throwNpe();
          }
          if (paramArrayOfInt1[i] == -1)
          {
            paramArrayOfInt1[i] = paramInt;
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  private final void a(int[][] paramArrayOfInt, int[] paramArrayOfInt1)
  {
    boolean bool = d;
    int j = 0;
    int i;
    if (bool) {
      if (paramArrayOfInt == null)
      {
        a("find same msg result is null", new Object[0]);
      }
      else
      {
        int k = ((Object[])paramArrayOfInt).length;
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
      if (paramArrayOfInt != null) {
        i = ((Object[])paramArrayOfInt).length;
      } else {
        i = 0;
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
  
  public static final boolean a()
  {
    TroopFoldMsgBean localTroopFoldMsgBean = TroopFoldMsgConfProcessor.a();
    boolean bool;
    if (!localTroopFoldMsgBean.a) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigSwitch = ");
      localStringBuilder.append(localTroopFoldMsgBean.a);
      localStringBuilder.append(", openSwitch = ");
      localStringBuilder.append(bool);
      QLog.i("TroopMsgSameFold", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private final boolean a(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, String paramString)
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
      paramDisplayMetrics.append(ViewUtils.getScreenWidth());
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
  
  @JvmStatic
  public static final boolean a(@NotNull ChatMessage paramChatMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramChatMessage, "chatMessage");
    int i = paramChatMessage.msgtype;
    return (i == -1051) || (i == -1000);
  }
  
  @JvmStatic
  public static final boolean a(@Nullable ChatMessage paramChatMessage1, @Nullable ChatMessage paramChatMessage2)
  {
    if (paramChatMessage1 == null)
    {
      if (paramChatMessage2 == null) {
        return true;
      }
    }
    else {
      if (paramChatMessage2 != null) {
        break label16;
      }
    }
    label16:
    while ((paramChatMessage1.msgtype != paramChatMessage2.msgtype) || (!TextUtils.equals((CharSequence)paramChatMessage1.msg, (CharSequence)paramChatMessage2.msg))) {
      return false;
    }
    return true;
  }
  
  private final int[] a(long[] paramArrayOfLong)
  {
    Object localObject = (int[])null;
    if (paramArrayOfLong != null)
    {
      paramArrayOfLong = new int[paramArrayOfLong.length];
      int i = 0;
      int j = paramArrayOfLong.length;
      for (;;)
      {
        localObject = paramArrayOfLong;
        if (i >= j) {
          break;
        }
        paramArrayOfLong[i] = -1;
        i += 1;
      }
    }
    return localObject;
  }
  
  private final int[][] a(int paramInt)
  {
    int j = paramInt + 1;
    Object localObject = new int[j][];
    int i = 0;
    paramInt = 0;
    while (paramInt < j)
    {
      localObject[paramInt] = new int[3];
      paramInt += 1;
    }
    localObject = (int[][])localObject;
    j = localObject.length;
    paramInt = i;
    while (paramInt < j)
    {
      localObject[paramInt][2] = -1;
      paramInt += 1;
    }
    return localObject;
  }
  
  private final int[][] a(int[][] paramArrayOfInt, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Object localObject = (int[][])null;
    int i;
    if (paramInt >= 0)
    {
      i = paramInt + 1;
      localObject = new int[i][];
      paramInt = 0;
      while (paramInt < i)
      {
        localObject[paramInt] = new int[3];
        paramInt += 1;
      }
      localObject = (int[][])localObject;
      System.arraycopy(paramArrayOfInt, 0, localObject, 0, i);
    }
    int j;
    int k;
    int m;
    if ((paramArrayOfInt2 != null) && (localObject != null))
    {
      j = paramArrayOfInt2.length;
      paramInt = 0;
      while (paramInt < j)
      {
        k = paramArrayOfInt2[paramInt];
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("find foldThenExpandIndex index = ");
        paramArrayOfInt.append(k);
        a(paramArrayOfInt.toString(), new Object[0]);
        m = localObject.length;
        i = 0;
        while (i < m)
        {
          if (localObject[i][1] == k) {
            localObject[i][2] = 1;
          }
          i += 1;
        }
        paramInt += 1;
      }
    }
    if ((paramArrayOfInt1 != null) && (localObject != null))
    {
      j = paramArrayOfInt1.length;
      paramInt = 0;
      while (paramInt < j)
      {
        k = paramArrayOfInt1[paramInt];
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("find fold index = ");
        paramArrayOfInt.append(k);
        a(paramArrayOfInt.toString(), new Object[0]);
        m = localObject.length;
        i = 0;
        while (i < m)
        {
          if (localObject[i][1] == k) {
            localObject[i][2] = 0;
          }
          i += 1;
        }
        paramInt += 1;
      }
    }
    return localObject;
  }
  
  public static final int b()
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
  
  private final ChatMessage b(QQAppInterface paramQQAppInterface, Resources paramResources, List<? extends ChatMessage> paramList, long paramLong)
  {
    paramResources = a(paramResources, a(paramList));
    int i = paramResources.length();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramResources);
    localStringBuilder.append(HardCodeUtil.a(2131917411));
    paramResources = localStringBuilder.toString();
    return a(paramQQAppInterface, paramList, paramLong, paramResources, i, paramResources.length(), 61, false);
  }
  
  private final List<ChatMessage> b(List<? extends ChatMessage> paramList)
  {
    List localList = (List)new ArrayList();
    Set localSet1 = (Set)new HashSet();
    Set localSet2 = (Set)new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!c(localChatMessage))
      {
        paramList = (MessageRecord)localChatMessage;
        if (AnonymousChatHelper.c(paramList))
        {
          String str = AnonymousChatHelper.g(paramList).c;
          paramList = str;
          if (TextUtils.isEmpty((CharSequence)str))
          {
            if (localChatMessage == null) {
              Intrinsics.throwNpe();
            }
            paramList = localChatMessage.senderuin;
          }
          Intrinsics.checkExpressionValueIsNotNull(paramList, "nickName");
          if (localSet2.add(paramList)) {
            localList.add(localChatMessage);
          }
        }
        else
        {
          if (localChatMessage == null) {
            Intrinsics.throwNpe();
          }
          paramList = localChatMessage.senderuin;
          Intrinsics.checkExpressionValueIsNotNull(paramList, "msg!!.senderuin");
          if (localSet1.add(paramList)) {
            localList.add(localChatMessage);
          }
        }
      }
    }
    return localList;
  }
  
  @JvmStatic
  public static final boolean b(@Nullable ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null)
    {
      bool1 = bool2;
      if ((paramChatMessage instanceof MessageForUniteGrayTip))
      {
        bool1 = bool2;
        if (((MessageForUniteGrayTip)paramChatMessage).tipParam.i == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static final int c()
  {
    TroopFoldMsgBean localTroopFoldMsgBean = TroopFoldMsgConfProcessor.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigSwitch = ");
      localStringBuilder.append(localTroopFoldMsgBean.c);
      QLog.i("TroopMsgSameFold", 2, localStringBuilder.toString());
    }
    return localTroopFoldMsgBean.c;
  }
  
  @JvmStatic
  public static final boolean c(@Nullable ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      Intrinsics.throwNpe();
    }
    return (paramChatMessage.isSend()) || (d(paramChatMessage));
  }
  
  @JvmStatic
  public static final boolean d(@Nullable ChatMessage paramChatMessage)
  {
    return (paramChatMessage != null) && (((paramChatMessage instanceof MessageForUniteGrayTip)) || ((paramChatMessage instanceof MessageForGrayTips)));
  }
  
  @NotNull
  public final ChatMessage a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Resources paramResources, @NotNull List<? extends ChatMessage> paramList, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramResources, "res");
    Intrinsics.checkParameterIsNotNull(paramList, "chatMessageList");
    paramResources = a(paramQQAppInterface, paramResources, paramList);
    int i = paramResources.length();
    return a(paramQQAppInterface, paramList, paramLong, paramResources, i - 6, i, 54, true);
  }
  
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @NotNull ChatMessage paramChatMessage1, int paramInt, @NotNull ChatMessage paramChatMessage2)
  {
    Intrinsics.checkParameterIsNotNull(paramChatMessage1, "chatMessage");
    Intrinsics.checkParameterIsNotNull(paramChatMessage2, "replaceMsg");
    if (!b.contains(Long.valueOf(paramChatMessage2.shmsgseq)))
    {
      if (paramInt > 15) {
        paramInt = 15;
      }
      paramQQAppInterface = (AppRuntime)paramQQAppInterface;
      String str = paramChatMessage1.frienduin;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramChatMessage1.shmsgseq);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800ADF2", "0X800ADF2", paramInt, 1, str, localStringBuilder.toString(), "", "");
      b.add(Long.valueOf(paramChatMessage2.shmsgseq));
    }
  }
  
  public final boolean a(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "sameMsgArray");
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
  
  @Nullable
  public final int[] a(@NotNull int[][] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "sameMsgArray");
    int[] arrayOfInt = (int[])null;
    int j = ((Object[])paramArrayOfInt).length;
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
    return arrayOfInt;
  }
  
  @Nullable
  public final int[][] a(@NotNull List<? extends ChatMessage> paramList, int paramInt, @Nullable long[] paramArrayOfLong1, @NotNull Set<Long> paramSet, @NotNull Map<Long, Long> paramMap, @Nullable long[] paramArrayOfLong2)
  {
    int i1 = paramInt;
    Object localObject6 = paramSet;
    Object localObject3 = paramMap;
    Intrinsics.checkParameterIsNotNull(paramList, "srcMsgList");
    Intrinsics.checkParameterIsNotNull(localObject6, "foldMsgFirstShMsgSeqSet");
    Intrinsics.checkParameterIsNotNull(localObject3, "foldMsgShMsgSeqPair");
    if (i1 == 0) {
      return null;
    }
    int m = paramList.size();
    Object localObject5 = a(Math.max(1, m / i1));
    ChatMessage localChatMessage1 = (ChatMessage)null;
    boolean bool = ListUtils.a((Collection)localObject6);
    Object localObject1 = a(paramArrayOfLong1);
    Object localObject4 = a(paramArrayOfLong2);
    long l1 = -1L;
    Object localObject2 = localChatMessage1;
    int i2 = 0;
    int j = 0;
    int i = 0;
    int k = 0;
    int n = 0;
    while (i2 < m)
    {
      ChatMessage localChatMessage2 = (ChatMessage)paramList.get(i2);
      if (!a(localChatMessage2))
      {
        if ((d(localChatMessage2)) && (i2 < m - 1)) {
          break label200;
        }
        i = a(paramList, paramInt, paramArrayOfLong1, (int[][])localObject5, i, k, (int[])localObject1, j, paramArrayOfLong2, (int[])localObject4);
        localObject2 = localChatMessage1;
        k = 0;
        label200:
        i2 += 1;
        i3 = i1;
      }
      Object localObject9;
      Object localObject8;
      Object localObject7;
      for (;;)
      {
        i1 = i3;
        break;
        localObject9 = localObject4;
        localObject8 = localObject1;
        localObject7 = localObject5;
        i3 = m;
        int i4 = k;
        int i5 = n;
        n = i2;
        k = i;
        Object localObject10 = localObject6;
        i2 = i1;
        localObject6 = localObject3;
        localObject3 = localObject2;
        i1 = i5;
        i = i4;
        localObject2 = localChatMessage2;
        for (;;)
        {
          localChatMessage2 = (ChatMessage)paramList.get(n);
          if (bool) {
            break;
          }
          long l2;
          if (((Set)localObject10).contains(Long.valueOf(localChatMessage2.shmsgseq)))
          {
            l2 = localChatMessage2.shmsgseq;
            localObject6 = (Long)((Map)localObject6).get(Long.valueOf(l2));
            if (localObject6 != null)
            {
              i4 = n + 1;
              if (i4 < i3)
              {
                if ((i >= i2) && (!a((ChatMessage)localObject3, localChatMessage2)))
                {
                  localObject7[k][1] = (n - 1);
                  a(paramList, paramArrayOfLong1, localObject8, n, paramArrayOfLong2, localObject9);
                  k += 1;
                }
                l1 = ((Long)localObject6).longValue();
                localObject7[k][0] = i4;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("find fold msg, index = ");
                ((StringBuilder)localObject3).append(n);
                ((StringBuilder)localObject3).append(", shMsgSeq = ");
                ((StringBuilder)localObject3).append(l2);
                a(((StringBuilder)localObject3).toString(), new Object[0]);
                localObject3 = localChatMessage1;
                i = 0;
                i1 = 1;
                break label771;
              }
            }
            break;
          }
          else
          {
            localObject6 = localObject2;
            l2 = l1;
            if (i1 == 0) {
              break;
            }
            if (l2 == localChatMessage2.shmsgseq)
            {
              localObject7[k][1] = n;
              a(paramArrayOfLong1, localObject8, n, paramArrayOfLong2, localObject9, localChatMessage2);
              k += 1;
              n += 1;
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("end fold msg, index = ");
              ((StringBuilder)localObject6).append(n);
              ((StringBuilder)localObject6).append(", shMsgSeq = ");
              ((StringBuilder)localObject6).append(l2);
              a(((StringBuilder)localObject6).toString(), new Object[0]);
            }
            for (;;)
            {
              i2 = 0;
              i1 = i;
              i = i2;
              break label829;
              if (l2 >= localChatMessage2.shmsgseq) {
                break;
              }
              localObject7[k][1] = (n - 1);
              a(paramList, paramArrayOfLong1, localObject8, n, paramArrayOfLong2, localObject9);
              k += 1;
              n += 1;
              if (!localChatMessage2.isSend()) {
                localObject3 = localChatMessage2;
              }
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("end fold msg, index = ");
              ((StringBuilder)localObject6).append(n);
              ((StringBuilder)localObject6).append(", shMsgSeq = ");
              ((StringBuilder)localObject6).append(l2);
              ((StringBuilder)localObject6).append(", msg.shmsgseq = ");
              ((StringBuilder)localObject6).append(localChatMessage2.shmsgseq);
              a(((StringBuilder)localObject6).toString(), new Object[0]);
            }
            l1 = l2;
            localObject2 = localObject6;
          }
          label771:
          n += 1;
          if (n >= i3)
          {
            i2 = i1;
            i1 = i;
            i = n;
            n = i2;
            break label841;
          }
          localObject10 = paramSet;
          localObject6 = paramMap;
          i2 = paramInt;
        }
        i2 = i1;
        i1 = i;
        i = i2;
        label829:
        i2 = n;
        n = i;
        i = i2;
        label841:
        if (i >= i3)
        {
          i = k;
          break label1083;
        }
        if (localObject3 != null) {
          break label923;
        }
        if (!((ChatMessage)localObject2).isSend())
        {
          localObject2 = (ChatMessage)paramList.get(i);
          j = i;
          i1 = 0;
        }
        else
        {
          localObject2 = localObject3;
        }
        i2 = i + 1;
        i3 = paramInt;
        localObject6 = paramSet;
        localObject3 = paramMap;
        i = k;
        k = i1;
      }
      label923:
      if (a((ChatMessage)localObject3, (ChatMessage)localObject2))
      {
        m = a(localObject7, k, i1, i, (ChatMessage)localObject2);
        k = a(paramInt, paramArrayOfLong1, i3, localObject7, k, m, localObject8, i, paramArrayOfLong2, localObject9, (ChatMessage)localObject2);
        localObject1 = localObject3;
        j = i;
      }
      else
      {
        k = a(paramList, paramInt, paramArrayOfLong1, localObject7, k, i1, localObject8, j, paramArrayOfLong2, localObject9);
        localObject1 = localObject2;
        if (((ChatMessage)localObject2).isSend()) {
          localObject1 = null;
        }
        m = 0;
      }
      i2 = i + 1;
      localObject6 = paramSet;
      localObject3 = paramMap;
      i = i3;
      int i3 = m;
      localObject4 = localObject9;
      localObject5 = localObject7;
      i1 = paramInt;
      localObject2 = localObject1;
      localObject1 = localObject8;
      m = i;
      i = k;
      k = i3;
    }
    label1083:
    paramList = this;
    paramArrayOfLong1 = paramList.a((int[][])localObject5, i, (int[])localObject1, (int[])localObject4);
    paramList.a(paramArrayOfLong1, (int[])localObject1);
    return paramArrayOfLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.troop.TroopMsgSameFold
 * JD-Core Version:    0.7.0.1
 */