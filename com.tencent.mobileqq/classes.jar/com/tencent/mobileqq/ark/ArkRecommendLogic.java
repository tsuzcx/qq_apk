package com.tencent.mobileqq.ark;

import aaqu;
import aaqy;
import aara;
import aarc;
import aard;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.ContextAnalyze;
import com.tencent.wordsegment.ContextItem;
import com.tencent.wordsegment.SemanticItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkRecommendLogic
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  public int a;
  protected String a;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public ArkRecommendLogic(String paramString, int paramInt)
  {
    a();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static Handler a()
  {
    try
    {
      if (jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ArkAnalyseThread", -1);
        jdField_a_of_type_AndroidOsHandlerThread.start();
        jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        jdField_a_of_type_AndroidOsHandler.post(new aaqu());
      }
      Handler localHandler = jdField_a_of_type_AndroidOsHandler;
      return localHandler;
    }
    finally {}
  }
  
  private static String a(RecommendCommonMessage paramRecommendCommonMessage)
  {
    String str3 = paramRecommendCommonMessage.getExtInfoFromExtStr("troop_at_info_list");
    String str2 = paramRecommendCommonMessage.getExtInfoFromExtStr("disc_at_info_list");
    String str1 = paramRecommendCommonMessage.msg;
    if (!TextUtils.isEmpty(str3)) {
      str1 = a(paramRecommendCommonMessage, str3);
    }
    while (TextUtils.isEmpty(str2)) {
      return str1;
    }
    return a(paramRecommendCommonMessage, str2);
  }
  
  public static String a(RecommendCommonMessage paramRecommendCommonMessage, String paramString)
  {
    paramRecommendCommonMessage.atInfoParsed = true;
    j = 0;
    k = 0;
    int i = 0;
    localObject = new StringBuilder(paramRecommendCommonMessage.msg);
    for (;;)
    {
      try
      {
        localJSONArray = new JSONArray(paramString);
        i2 = localJSONArray.length();
        if (i2 > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkRecommendLogic", 2, "removeAtTroopInfo before remove at size >0");
          }
          paramRecommendCommonMessage.clearAtInfo();
          m = 0;
          paramString = (String)localObject;
          if (m >= i2) {
            continue;
          }
        }
      }
      catch (JSONException paramRecommendCommonMessage)
      {
        JSONArray localJSONArray;
        int i2;
        int m;
        int i3;
        int i1;
        paramString = (String)localObject;
        QLog.e("ArkApp.ArkRecommendLogic", 1, new Object[] { "removeAtTroopInfo ", paramRecommendCommonMessage + "" + paramString });
        paramRecommendCommonMessage = paramString;
        continue;
      }
      catch (Exception paramRecommendCommonMessage)
      {
        paramString = (String)localObject;
        QLog.e("ArkApp.ArkRecommendLogic", 1, "removeAtTroopInfo", paramRecommendCommonMessage);
        paramRecommendCommonMessage = paramString;
        continue;
      }
      try
      {
        localObject = localJSONArray.getJSONObject(m);
        i3 = (byte)((JSONObject)localObject).optInt("flag", 1);
        ((JSONObject)localObject).optString("uin");
        i1 = ((JSONObject)localObject).optInt("startPos", 0);
        n = ((JSONObject)localObject).optInt("textLen", 0);
        if (i3 != 0) {
          break label418;
        }
        paramRecommendCommonMessage.addAtInfo(i1 + 1, n - 1);
        k = i1 - i;
        i1 = i1 + n - i;
        i3 = paramString.charAt(i1);
        j = i;
        if (!TextUtils.isEmpty(paramString))
        {
          j = i;
          if (i3 == 32)
          {
            paramString.replace(i1, i1 + 1, "");
            j = i + 1;
          }
        }
        if (k != 0) {
          continue;
        }
        localObject = paramString.replace(k, i1, "");
        paramString = (String)localObject;
        i = n;
        i += j;
        j = i1;
      }
      catch (Exception paramRecommendCommonMessage)
      {
        continue;
      }
      catch (JSONException paramRecommendCommonMessage)
      {
        continue;
        n = j;
        j = k;
        k = n;
        continue;
      }
      n = m + 1;
      m = k;
      k = j;
      j = m;
      m = n;
      continue;
      paramRecommendCommonMessage = ((StringBuilder)localObject).toString();
      return paramRecommendCommonMessage;
      localObject = paramString.replace(k, i1, " ");
      i = n - 1;
      paramString = (String)localObject;
    }
    paramRecommendCommonMessage = paramString;
    if (QLog.isColorLevel())
    {
      paramRecommendCommonMessage = paramString;
      if (i2 > 0)
      {
        QLog.d("ArkApp.ArkRecommendLogic", 2, "removeAtTroopInfo after remove replace start= " + j + "end=" + k);
        paramRecommendCommonMessage = paramString;
      }
    }
    return paramRecommendCommonMessage.toString();
  }
  
  public static String a(ContextItem paramContextItem)
  {
    if (paramContextItem == null) {
      return "(null)";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramContextItem.semantic.size();
    int i = 0;
    while (i < j)
    {
      SemanticItem localSemanticItem = (SemanticItem)paramContextItem.semantic.get(i);
      localStringBuffer.append(String.format("%s=%s;", new Object[] { localSemanticItem.key, localSemanticItem.value }));
      i += 1;
    }
    return String.format("intent=%s, meta=%s", new Object[] { paramContextItem.contextName, localStringBuffer.toString() });
  }
  
  protected static String a(String paramString, RecommendCommonMessage.ArkContextInfo paramArkContextInfo, ArrayList paramArrayList)
  {
    if (paramArkContextInfo == null) {
      return "";
    }
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      Iterator localIterator = paramArkContextInfo.semantic.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        SemanticItem localSemanticItem = new SemanticItem();
        localSemanticItem.key = str;
        localSemanticItem.value = ((String)paramArkContextInfo.semantic.get(str));
        paramArrayList.add(localSemanticItem);
      }
      if (!TextUtils.isEmpty(paramString)) {
        break label138;
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkRecommendLogic", 2, "ArkRecommendLogic.getMetaList.jsonParseError");
      }
      return "";
    }
    ArkAppCenter.b("ArkApp.ArkRecommendLogic", String.format("contextName is empty", new Object[0]));
    return "";
    label138:
    if (TextUtils.isEmpty(paramArkContextInfo.meta))
    {
      ArkAppCenter.b("ArkApp.ArkRecommendLogic", String.format("intentMeta is empty", new Object[0]));
      return "";
    }
    localJSONObject.put(paramString, new JSONObject(paramArkContextInfo.meta));
    paramString = localJSONObject.toString();
    return paramString;
  }
  
  private static String a(String paramString, AtTroopMemberSpan[] paramArrayOfAtTroopMemberSpan)
  {
    String str1 = paramString;
    if (paramArrayOfAtTroopMemberSpan != null)
    {
      str1 = paramString;
      if (paramArrayOfAtTroopMemberSpan.length != 0)
      {
        int i = 0;
        for (;;)
        {
          str1 = paramString;
          if (i >= paramArrayOfAtTroopMemberSpan.length) {
            break;
          }
          String str2 = paramArrayOfAtTroopMemberSpan[i].b();
          paramArrayOfAtTroopMemberSpan[i].a();
          if ((QLog.isColorLevel()) && (str2 != null) && (str2.length() > 4)) {
            QLog.d("ArkApp.ArkRecommendLogic", 2, "trimTroopOrDiscussAtInfo LocalAnalyze atMember cNickname=" + str2.substring(0, 4));
          }
          str1 = paramString;
          if (str2 != null) {
            str1 = paramString.replace(str2, " ");
          }
          i += 1;
          paramString = str1;
        }
      }
    }
    return str1;
  }
  
  private void a(ArrayList paramArrayList, RecommendCommonMessage paramRecommendCommonMessage, WeakReference paramWeakReference, int paramInt)
  {
    if (paramArrayList == null) {
      ArkAppCenter.a("ArkApp.ArkRecommendLogic", String.format("ArkRecommendLogic.handleContext contentArray is null", new Object[0]));
    }
    int i;
    RecommendCommonMessage.ArkContextInfo localArkContextInfo;
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        i = 0;
      } while (i >= paramArrayList.size());
      if (paramArrayList.get(i) == null)
      {
        ArkAppCenter.a("ArkApp.ArkRecommendLogic", String.format("ArkRecommendLogic.handleContext ArkContextInfo is null", new Object[0]));
        return;
      }
      localArkContextInfo = (RecommendCommonMessage.ArkContextInfo)paramArrayList.get(i);
      localObject1 = localArkContextInfo.context;
      localObject2 = localArkContextInfo.meta;
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        ArkAppCenter.a("ArkApp.ArkRecommendLogic", String.format("ArkRecommendLogic.handleContext contextName or intentMeta is null", new Object[0]));
        return;
      }
      if (!((String)localObject1).contains(".")) {
        break label242;
      }
      if (((String)localObject1).split("\\.").length != 2)
      {
        ArkAppCenter.a("ArkApp.ArkRecommendLogic", String.format("ArkRecommendLogic.handleContext split contextName failed. contextName: %s", new Object[] { localObject1 }));
        return;
      }
      localObject2 = (ArkRecommendLogic.SemanticAnalysisResult)paramWeakReference.get();
      if (localObject2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ArkApp.ArkRecommendLogic", 2, "ArkRecommendLogic handleContext callback == null");
    return;
    if (paramRecommendCommonMessage != null) {}
    for (;;)
    {
      try
      {
        localObject3 = new ArkAiInfo();
        ((ArkAiInfo)localObject3).jdField_a_of_type_Int = paramInt;
        ((ArkAiInfo)localObject3).b = localArkContextInfo.contextMatchType;
        ((ArkAiInfo)localObject3).h = ((String)localObject1);
        ((ArkRecommendLogic.SemanticAnalysisResult)localObject2).a(paramRecommendCommonMessage, (ArkAiInfo)localObject3, localArkContextInfo, a(paramRecommendCommonMessage));
        label242:
        i += 1;
      }
      catch (Exception localException)
      {
        ArkAppCenter.a("ArkApp.ArkRecommendLogic", String.format("ArkRecommendLogic.handleContext rawContextItem.semantic is error. contextName: %s", new Object[] { localObject1 }));
        continue;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localQQAppInterface == null) {
        break;
      }
      ArrayList localArrayList = new ArrayList();
      ArkAiInfo localArkAiInfo = new ArkAiInfo();
      localArkAiInfo.jdField_a_of_type_Int = paramInt;
      localArkAiInfo.b = localException.contextMatchType;
      localArkAiInfo.h = ((String)localObject1);
      localArkAiInfo.f = a((String)localObject1, localException, localArrayList);
      Object localObject3 = (ArkAppCenter)localQQAppInterface.getManager(120);
      localObject1 = new aard(this, localArrayList, localArkAiInfo, paramRecommendCommonMessage, localQQAppInterface, (String)localObject1, localException, (ArkRecommendLogic.SemanticAnalysisResult)localObject2);
      ((ArkAppCenter)localObject3).a().a(localException.appName, localException.context, 2, (ArkLocalAppMgr.IGetAppViewByIntentCallback)localObject1);
      ArkAppCenter.a("ArkBubbleState", String.format("ArkRecommendLogic.handleContext appname=%s,context=%s", new Object[] { localException.appName, localException.context }));
    }
  }
  
  private boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 1) || (paramString.length() > 60))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkRecommendLogic", 2, "shouldAnalyzeTextByServer text length not match");
      }
      return false;
    }
    if ((ArkAiAppCenter.a == null) || (ArkAiAppCenter.a.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkRecommendLogic", 2, "shouldAnalyzeTextByServer keyword pattern config is null");
      }
      return false;
    }
    Iterator localIterator = ArkAiAppCenter.a.values().iterator();
    while (localIterator.hasNext())
    {
      ArkAiAppCenter.ArkAiKeywordConfig localArkAiKeywordConfig = (ArkAiAppCenter.ArkAiKeywordConfig)localIterator.next();
      if ((localArkAiKeywordConfig != null) && (!TextUtils.isEmpty(localArkAiKeywordConfig.c)))
      {
        boolean bool = Pattern.matches(localArkAiKeywordConfig.c, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkRecommendLogic", 2, "shouldAnalyzeTextByServer pattern = " + localArkAiKeywordConfig.c + ", isMatch = " + bool);
        }
        if (bool)
        {
          ArkAppDataReport.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "com.tencent.arkplatform", localArkAiKeywordConfig.b);
          return true;
        }
      }
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
  }
  
  public void a(RecommendCommonMessage paramRecommendCommonMessage, ArkRecommendLogic.SemanticAnalysisResult paramSemanticAnalysisResult)
  {
    if (!ArkAiDictMgr.jdField_a_of_type_Boolean) {
      return;
    }
    WeakReference localWeakReference = new WeakReference(this);
    paramSemanticAnalysisResult = new WeakReference(paramSemanticAnalysisResult);
    ArkMessageServerLogic.a(a(paramRecommendCommonMessage), null, new aaqy(this, localWeakReference, paramSemanticAnalysisResult, paramRecommendCommonMessage));
  }
  
  public void a(String paramString, SessionInfo paramSessionInfo, ArkRecommendLogic.SemanticAnalysisResult paramSemanticAnalysisResult)
  {
    if (!ArkAiDictMgr.jdField_a_of_type_Boolean) {
      return;
    }
    ArkMessageServerLogic.a(paramString, null, new aara(this, new WeakReference(this), new WeakReference(paramSemanticAnalysisResult), paramSessionInfo));
  }
  
  /* Error */
  public void a(String paramString, AtTroopMemberSpan[] paramArrayOfAtTroopMemberSpan, ArkRecommendLogic.SemanticAnalysisResult paramSemanticAnalysisResult)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: getfield 32	com/tencent/mobileqq/ark/ArkRecommendLogic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: getstatic 463	com/tencent/mobileqq/ark/ArkAiDictMgr:jdField_a_of_type_Boolean	Z
    //   15: ifeq -4 -> 11
    //   18: aload_1
    //   19: aload_2
    //   20: invokestatic 492	com/tencent/mobileqq/ark/ArkRecommendLogic:a	(Ljava/lang/String;[Lcom/tencent/mobileqq/troop/text/AtTroopMemberSpan;)Ljava/lang/String;
    //   23: astore 10
    //   25: invokestatic 494	com/tencent/mobileqq/ark/ArkAiAppCenter:b	()Z
    //   28: ifeq +42 -> 70
    //   31: aload_0
    //   32: aload 10
    //   34: invokespecial 496	com/tencent/mobileqq/ark/ArkRecommendLogic:a	(Ljava/lang/String;)Z
    //   37: ifeq +33 -> 70
    //   40: aload 10
    //   42: aconst_null
    //   43: new 498	aaqv
    //   46: dup
    //   47: aload_0
    //   48: new 340	java/lang/ref/WeakReference
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 466	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   56: new 340	java/lang/ref/WeakReference
    //   59: dup
    //   60: aload_3
    //   61: invokespecial 466	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   64: invokespecial 501	aaqv:<init>	(Lcom/tencent/mobileqq/ark/ArkRecommendLogic;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V
    //   67: invokestatic 504	com/tencent/mobileqq/ark/ArkMessageServerLogic:a	(Ljava/lang/String;Ljava/lang/Object;Lcom/tencent/mobileqq/ark/ArkMessageServerLogic$IAnalyzeTextIntentByServerHandler;)V
    //   70: new 207	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 381	java/util/ArrayList:<init>	()V
    //   77: astore 9
    //   79: new 207	java/util/ArrayList
    //   82: dup
    //   83: invokespecial 381	java/util/ArrayList:<init>	()V
    //   86: astore 8
    //   88: iconst_0
    //   89: istore 5
    //   91: invokestatic 510	java/lang/System:currentTimeMillis	()J
    //   94: ldc2_w 511
    //   97: ldiv
    //   98: lstore 6
    //   100: invokestatic 514	com/tencent/mobileqq/ark/ArkAiAppCenter:a	()Z
    //   103: ifeq +134 -> 237
    //   106: aload_0
    //   107: getfield 32	com/tencent/mobileqq/ark/ArkRecommendLogic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   110: lload 6
    //   112: iconst_1
    //   113: iconst_0
    //   114: aload 10
    //   116: aload 9
    //   118: aload 8
    //   120: invokestatic 520	com/tencent/wordsegment/ContextAnalyze:parse	(Ljava/lang/String;JZZLjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
    //   123: istore 4
    //   125: getstatic 374	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   128: invokevirtual 378	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   131: checkcast 380	com/tencent/mobileqq/app/QQAppInterface
    //   134: astore 8
    //   136: iload 4
    //   138: istore 5
    //   140: getstatic 523	com/tencent/mobileqq/ark/ArkAiAppCenter:j	Z
    //   143: ifeq +94 -> 237
    //   146: iload 4
    //   148: istore 5
    //   150: aload 9
    //   152: invokevirtual 525	java/util/ArrayList:isEmpty	()Z
    //   155: ifne +82 -> 237
    //   158: aload 10
    //   160: invokestatic 530	com/tencent/wordsegment/WordSegment:bussinesReport	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 10
    //   165: aload 10
    //   167: ldc_w 532
    //   170: invokevirtual 336	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   173: astore 11
    //   175: iload 4
    //   177: istore 5
    //   179: aload 10
    //   181: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   184: ifne +53 -> 237
    //   187: ldc 117
    //   189: ldc_w 534
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload 10
    //   200: aastore
    //   201: invokestatic 230	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokestatic 281	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload 8
    //   209: ldc 157
    //   211: ldc_w 536
    //   214: ldc_w 538
    //   217: lconst_0
    //   218: lconst_0
    //   219: lconst_0
    //   220: lconst_0
    //   221: lconst_0
    //   222: aload 11
    //   224: iconst_0
    //   225: aaload
    //   226: aload 11
    //   228: iconst_1
    //   229: aaload
    //   230: invokestatic 543	com/tencent/mobileqq/statistics/ArkAppReportController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJLjava/lang/String;Ljava/lang/String;)V
    //   233: iload 4
    //   235: istore 5
    //   237: iload 5
    //   239: istore 4
    //   241: iload 4
    //   243: ifeq +11 -> 254
    //   246: aload 9
    //   248: invokevirtual 210	java/util/ArrayList:size	()I
    //   251: ifgt +95 -> 346
    //   254: aload_0
    //   255: invokevirtual 545	com/tencent/mobileqq/ark/ArkRecommendLogic:a	()V
    //   258: return
    //   259: astore_1
    //   260: iconst_0
    //   261: istore 4
    //   263: ldc 117
    //   265: ldc_w 547
    //   268: iconst_1
    //   269: anewarray 4	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: aload_1
    //   275: invokevirtual 550	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   278: aastore
    //   279: invokestatic 230	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   282: invokestatic 281	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: goto -44 -> 241
    //   288: astore 8
    //   290: iconst_0
    //   291: istore 4
    //   293: ldc 117
    //   295: new 99	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 552
    //   305: iconst_1
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: aload 8
    //   313: invokevirtual 553	java/lang/IndexOutOfBoundsException:getMessage	()Ljava/lang/String;
    //   316: aastore
    //   317: invokestatic 230	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   320: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_1
    //   324: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 555
    //   330: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_2
    //   334: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 281	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: goto -102 -> 241
    //   346: aload 9
    //   348: iconst_0
    //   349: lconst_0
    //   350: new 557	aaqx
    //   353: dup
    //   354: aload_0
    //   355: new 340	java/lang/ref/WeakReference
    //   358: dup
    //   359: aload_3
    //   360: invokespecial 466	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   363: invokespecial 560	aaqx:<init>	(Lcom/tencent/mobileqq/ark/ArkRecommendLogic;Ljava/lang/ref/WeakReference;)V
    //   366: invokestatic 563	com/tencent/mobileqq/ark/ArkMessageServerLogic:a	(Ljava/util/ArrayList;ZJLcom/tencent/mobileqq/ark/ArkMessageServerLogic$ServerCheckCallback;)V
    //   369: return
    //   370: astore 8
    //   372: goto -79 -> 293
    //   375: astore_1
    //   376: goto -113 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	ArkRecommendLogic
    //   0	379	1	paramString	String
    //   0	379	2	paramArrayOfAtTroopMemberSpan	AtTroopMemberSpan[]
    //   0	379	3	paramSemanticAnalysisResult	ArkRecommendLogic.SemanticAnalysisResult
    //   123	169	4	bool1	boolean
    //   89	149	5	bool2	boolean
    //   98	13	6	l	long
    //   86	122	8	localObject	Object
    //   288	24	8	localIndexOutOfBoundsException1	java.lang.IndexOutOfBoundsException
    //   370	1	8	localIndexOutOfBoundsException2	java.lang.IndexOutOfBoundsException
    //   77	270	9	localArrayList	ArrayList
    //   23	176	10	str	String
    //   173	54	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   100	125	259	java/lang/UnsatisfiedLinkError
    //   100	125	288	java/lang/IndexOutOfBoundsException
    //   125	136	370	java/lang/IndexOutOfBoundsException
    //   140	146	370	java/lang/IndexOutOfBoundsException
    //   150	175	370	java/lang/IndexOutOfBoundsException
    //   179	233	370	java/lang/IndexOutOfBoundsException
    //   125	136	375	java/lang/UnsatisfiedLinkError
    //   140	146	375	java/lang/UnsatisfiedLinkError
    //   150	175	375	java/lang/UnsatisfiedLinkError
    //   179	233	375	java/lang/UnsatisfiedLinkError
  }
  
  public boolean a(RecommendCommonMessage paramRecommendCommonMessage, ArkRecommendLogic.SemanticAnalysisResult paramSemanticAnalysisResult)
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    while ((paramRecommendCommonMessage == null) || (paramRecommendCommonMessage.msg == null) || (!ArkAiDictMgr.jdField_a_of_type_Boolean)) {
      return false;
    }
    if (paramRecommendCommonMessage.issend == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ArrayList localArrayList1;
      long l;
      String str1;
      for (;;)
      {
        localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        String str2 = a(paramRecommendCommonMessage);
        l = paramRecommendCommonMessage.time;
        try
        {
          bool = ContextAnalyze.parse(this.jdField_a_of_type_JavaLangString, l, bool, true, str2, localArrayList1, localArrayList2);
          if ((!bool) || (localArrayList1.size() <= 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ArkApp.ArkRecommendLogic", 2, "ContextAnalyze parse retCode=" + bool + ", context info size=" + localArrayList1.size());
            return false;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ArkApp.ArkRecommendLogic", 2, "UnsatisfiedLinkError, err:" + localUnsatisfiedLinkError.getMessage());
            }
            bool = false;
          }
          str1 = paramRecommendCommonMessage.senderuin;
        }
      }
      if (str1 == null) {
        break;
      }
      b = str1.equals(paramRecommendCommonMessage.selfuin);
      paramSemanticAnalysisResult = new WeakReference(paramSemanticAnalysisResult);
      c = false;
      ArkMessageServerLogic.a(localArrayList1, true, l, new aarc(this, paramRecommendCommonMessage, paramSemanticAnalysisResult));
      return c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkRecommendLogic
 * JD-Core Version:    0.7.0.1
 */