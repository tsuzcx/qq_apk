package com.tencent.biz.pubaccount.ecshopassit.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.RedPointInfo;
import com.tencent.biz.pubaccount.ecshopassit.conf.QQShopFakeUrlHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.JsonUtil;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;

public class EcshopUtils
{
  public static int a(long paramLong)
  {
    int i = 0;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      i = SharedPreferencesUtil.a(localAppRuntime, "open_minus_view_cnt_" + paramLong + "_" + a(localAppRuntime));
    }
    return i;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 1;
    try
    {
      paramQQAppInterface = QQShopFakeUrlHelper.a(paramQQAppInterface, paramString, "maxShowCount");
      if (!StringUtil.a(paramQQAppInterface)) {
        i = Integer.parseInt(paramQQAppInterface);
      }
      return i;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("Ecshop_EcshopUtils", 1, paramQQAppInterface, new Object[0]);
    }
    return 1;
  }
  
  public static int a(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = b(paramMessageRecord);
    if (paramMessageRecord == null) {
      return 0;
    }
    return paramMessageRecord.optInt("is_hidden");
  }
  
  public static AppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if (!(localObject instanceof AppInterface)) {
          break label53;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label53:
    return null;
  }
  
  public static ChatMessage a(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
        Object localObject = a(localChatMessage);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Ecshop_EcshopUtils", 2, "mGdtActionType " + ((AbsStructMsgElement)localObject).c);
          }
          if ((((AbsStructMsgElement)localObject).c != 1) || (!(((AbsStructMsgElement)localObject).a instanceof StructMsgForGeneralShare))) {}
        }
        else
        {
          do
          {
            return localChatMessage;
            localObject = a(localChatMessage);
          } while ((localObject != null) && (String.valueOf(1).equals(((JSONObject)localObject).optString("action_type"))));
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public static AbsStructMsgElement a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
        if ((paramMessageRecord.mStructMsgItemLists != null) && (paramMessageRecord.mStructMsgItemLists.size() > 0)) {
          return (AbsStructMsgElement)paramMessageRecord.mStructMsgItemLists.get(0);
        }
      }
    }
    return null;
  }
  
  public static String a()
  {
    String str = "";
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      str = SharedPreferencesUtil.a(localAppRuntime, "qgg_msg_summary_" + a(localAppRuntime));
    }
    return str;
  }
  
  public static String a(long paramLong, String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE).format(new Date(paramLong));
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String a(Context paramContext, Date paramDate)
  {
    int i = 0;
    String str1 = paramContext.getString(2131718716);
    String str2 = paramContext.getString(2131718714);
    String str3 = paramContext.getString(2131718718);
    String str4 = paramContext.getString(2131718719);
    String str5 = paramContext.getString(2131718717);
    String str6 = paramContext.getString(2131718711);
    paramContext = paramContext.getString(2131718715);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int j = localCalendar.get(7) - 1;
    if (j < 0) {}
    for (;;)
    {
      return new String[] { str1, str2, str3, str4, str5, str6, paramContext }[i];
      i = j;
    }
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    AbsStructMsgElement localAbsStructMsgElement = a(paramMessageRecord);
    if (localAbsStructMsgElement != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopUtils", 2, "mGdtActionType " + localAbsStructMsgElement.c);
      }
      if (localAbsStructMsgElement.c == 0) {
        return "";
      }
      return String.valueOf(localAbsStructMsgElement.c);
    }
    paramMessageRecord = a(paramMessageRecord);
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.optString("action_type");
  }
  
  public static String a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (StringUtil.a(paramString)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str1 = (String)paramMap.get(str2);
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_EcshopUtils", 2, "appendKV2Schema key: " + str2 + " value: " + str1);
        }
        paramString = str1;
        if (paramBoolean) {}
        try
        {
          paramString = URLEncoder.encode(str1);
          if (localStringBuffer.toString().lastIndexOf("?") == -1)
          {
            localStringBuffer.append("?");
            localStringBuffer.append(String.format("%s=%s", new Object[] { str2, paramString }));
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            QLog.i("Ecshop_EcshopUtils", 2, "error encode key: " + str2 + " value: " + str1);
            paramString = str1;
            continue;
            localStringBuffer.append("&");
          }
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    String str = "";
    if ((paramAppRuntime instanceof QQAppInterface)) {
      str = ((QQAppInterface)paramAppRuntime).getCurrentUin();
    }
    while (!(paramAppRuntime instanceof ToolAppRuntime)) {
      return str;
    }
    paramAppRuntime = (ToolAppRuntime)paramAppRuntime;
    return paramAppRuntime.getLongAccountUin() + "";
  }
  
  public static ArrayList<RedPointInfo> a(List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new RedPointInfo().a((qq_ad.QQAdGetRsp.RedPointInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static Map<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashMap();
    }
    Object localObject = JsonUtil.a(paramString);
    if (localObject == null) {
      return new HashMap();
    }
    paramString = new HashMap(((Map)localObject).size());
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localEntry != null) {
        paramString.put(localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return paramString;
  }
  
  /* Error */
  public static JSONObject a(MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 347
    //   4: ifeq +90 -> 94
    //   7: aload_0
    //   8: checkcast 347	com/tencent/mobileqq/data/MessageForArkApp
    //   11: astore_1
    //   12: aload_1
    //   13: getfield 351	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +78 -> 96
    //   21: aload_0
    //   22: getfield 357	com/tencent/mobileqq/data/ArkAppMessage:mSourceAd	Ljava/lang/String;
    //   25: astore_0
    //   26: aload_0
    //   27: invokestatic 62	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   30: ifne +64 -> 94
    //   33: new 85	org/json/JSONObject
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 358	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_0
    //   42: aload_0
    //   43: ldc_w 360
    //   46: aload_1
    //   47: getfield 363	com/tencent/mobileqq/data/MessageForArkApp:msg	Ljava/lang/String;
    //   50: invokevirtual 366	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   53: pop
    //   54: aload_0
    //   55: areturn
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_0
    //   59: ldc 70
    //   61: iconst_1
    //   62: new 23	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 368
    //   72: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokestatic 372	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   79: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 374	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_0
    //   89: areturn
    //   90: astore_1
    //   91: goto -32 -> 59
    //   94: aconst_null
    //   95: areturn
    //   96: ldc 177
    //   98: astore_0
    //   99: goto -73 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramMessageRecord	MessageRecord
    //   11	36	1	localMessageForArkApp	com.tencent.mobileqq.data.MessageForArkApp
    //   56	20	1	localException1	Exception
    //   90	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   26	42	56	java/lang/Exception
    //   42	54	90	java/lang/Exception
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt == 1008) && ("3046055438".equals(paramString))) {
      if (!paramBoolean) {
        break label73;
      }
    }
    label73:
    for (paramInt = 1;; paramInt = 0)
    {
      ReportUtil.a(null, "gouwu.top.click", paramInt + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
      return;
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean) {}
  
  public static void a(long paramLong)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      SharedPreferencesUtil.a(localAppRuntime, "open_minus_view_cnt_" + paramLong + "_" + a(localAppRuntime));
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      SharedPreferencesUtil.a(localAppRuntime, "open_minus_view_cnt_" + paramLong + "_" + a(localAppRuntime), paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    try
    {
      if ((a(paramQQAppInterface)) && (!StringUtil.a(a())))
      {
        paramMsgSummary.suffix = "";
        paramMsgSummary.strContent = a();
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("Ecshop_EcshopUtils", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManagerV2.excute(new EcshopUtils.1(paramQQAppInterface, paramString), 16, null, true);
  }
  
  private static void a(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      SharedPreferencesUtil.a(localAppRuntime, "qgg_msg_summary_" + a(localAppRuntime), paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopUtils", 2, "qggSummary: " + paramString1);
    }
    if (!StringUtil.a(paramString1))
    {
      b(paramString2);
      a(paramString1);
    }
    while (BaseApplicationImpl.getApplication() == null) {
      return;
    }
    a(BaseApplicationImpl.getApplication().getString(2131691932));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().b("3046055438", 1008);
      if (localMessageRecord == null) {
        return false;
      }
      int i = a(localMessageRecord.uniseq);
      int j = a(paramQQAppInterface, QQShopFakeUrlHelper.b(paramQQAppInterface, b(localMessageRecord)));
      if (i >= j) {
        return true;
      }
    }
    catch (Throwable paramQQAppInterface) {}
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return String.valueOf(1).equals(paramString);
  }
  
  public static int b(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = b(paramMessageRecord);
    if (paramMessageRecord == null) {}
    do
    {
      return 0;
      paramMessageRecord = paramMessageRecord.optJSONObject("native_ext");
    } while (paramMessageRecord == null);
    return paramMessageRecord.optInt("hide_tabbar", 0);
  }
  
  public static String b()
  {
    String str = "";
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      str = SharedPreferencesUtil.a(localAppRuntime, "qgg_msg_id_" + a(localAppRuntime));
    }
    return str;
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = b(paramMessageRecord);
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.optString("page_type");
  }
  
  private static JSONObject b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      return null;
      paramMessageRecord = d(paramMessageRecord);
    } while (StringUtil.a(paramMessageRecord));
    try
    {
      paramMessageRecord = new JSONObject(paramMessageRecord);
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopUtils", 2, "qggExtJson<<<<<<<" + paramMessageRecord);
      }
      return paramMessageRecord;
    }
    catch (JSONException paramMessageRecord)
    {
      QLog.e("Ecshop_EcshopUtils", 2, paramMessageRecord, new Object[0]);
    }
    return null;
  }
  
  private static void b(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      SharedPreferencesUtil.a(localAppRuntime, "qgg_msg_id_" + a(localAppRuntime), paramString);
    }
  }
  
  public static int c(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = b(paramMessageRecord);
    if (paramMessageRecord == null) {}
    do
    {
      return 1;
      paramMessageRecord = paramMessageRecord.optJSONObject("native_ext");
    } while (paramMessageRecord == null);
    return paramMessageRecord.optInt("tab_id", 1);
  }
  
  public static String c(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = b(paramMessageRecord);
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.optString("web_ext");
  }
  
  private static String d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    AbsStructMsgElement localAbsStructMsgElement = a(paramMessageRecord);
    if (localAbsStructMsgElement != null)
    {
      if (localAbsStructMsgElement.W == null) {
        return "";
      }
      return localAbsStructMsgElement.W;
    }
    paramMessageRecord = a(paramMessageRecord);
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.optString("qgg_ext");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils
 * JD-Core Version:    0.7.0.1
 */