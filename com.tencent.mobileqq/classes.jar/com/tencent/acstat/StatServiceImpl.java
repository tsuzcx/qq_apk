package com.tencent.acstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.acstat.common.DeviceInfo;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.common.StatPreferences;
import com.tencent.acstat.event.c;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class StatServiceImpl
{
  private static volatile long A = -1L;
  private static StatSpecifyReportedInfo B = null;
  static volatile int a;
  static volatile long b;
  static volatile long c;
  private static Handler d;
  private static volatile Map<c, Long> e = new ConcurrentHashMap();
  private static volatile Map<String, Properties> f = new ConcurrentHashMap();
  private static volatile Map<Integer, Integer> g = new ConcurrentHashMap(10);
  private static volatile long h = 0L;
  private static volatile long i = 0L;
  private static volatile long j = 0L;
  private static String k = "";
  private static volatile int l = 0;
  private static volatile String m = "";
  private static volatile String n = "";
  private static Map<String, Long> o = new ConcurrentHashMap();
  private static Map<String, Long> p = new ConcurrentHashMap();
  private static StatLogger q = StatCommonHelper.getLogger();
  private static Thread.UncaughtExceptionHandler r = null;
  private static volatile boolean s = true;
  private static Context t;
  private static volatile boolean u;
  private static volatile boolean v;
  private static volatile boolean w;
  private static Handler x;
  private static List<StatActionListener> y;
  private static volatile Runnable z;
  
  static
  {
    a = 0;
    b = 0L;
    t = null;
    c = 0L;
    u = false;
    v = false;
    w = true;
    x = null;
    y = new CopyOnWriteArrayList();
    z = null;
  }
  
  static int a(Context paramContext, boolean paramBoolean, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    if ((paramBoolean) && (l1 - i >= StatConfig.getSessionTimoutMillis())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    i = l1;
    if (j == 0L) {
      j = StatCommonHelper.getTomorrowStartMilliseconds();
    }
    if (l1 >= j)
    {
      j = StatCommonHelper.getTomorrowStartMilliseconds();
      if (af.a(paramContext).b(paramContext).getUserType() != 1) {
        af.a(paramContext).b(paramContext).setUserType(1);
      }
      StatConfig.b(0);
      a = 0;
      k = StatCommonHelper.getDateString(0);
      i1 = 1;
    }
    Object localObject = k;
    if (StatCommonHelper.isSpecifyReportedValid(paramStatSpecifyReportedInfo))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramStatSpecifyReportedInfo.getAppKey());
      ((StringBuilder)localObject).append(k);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (!p.containsKey(localObject)) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      if (!StatCommonHelper.isSpecifyReportedValid(paramStatSpecifyReportedInfo))
      {
        if (StatConfig.c() < StatConfig.getMaxDaySessionNumbers())
        {
          StatCommonHelper.checkFirstTimeActivate(paramContext);
          a(paramContext, null);
        }
        else
        {
          q.e("Exceed StatConfig.getMaxDaySessionNumbers().");
        }
      }
      else {
        a(paramContext, paramStatSpecifyReportedInfo);
      }
      p.put(localObject, Long.valueOf(1L));
    }
    paramBoolean = s;
    s = false;
    return l;
  }
  
  static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext = paramContext.getApplicationContext();
      if (d == null)
      {
        boolean bool = b(paramContext);
        if (!bool) {
          return;
        }
        t = paramContext;
        HandlerThread localHandlerThread = new HandlerThread("StatService");
        localHandlerThread.start();
        d = new Handler(localHandlerThread.getLooper());
        k = StatCommonHelper.getDateString(0);
        h = System.currentTimeMillis() + StatConfig.i;
        d.post(new j(paramContext));
      }
      return;
    }
    finally {}
  }
  
  static void a(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (c(paramContext) != null)
    {
      if (StatConfig.isDebugEnable())
      {
        StatLogger localStatLogger = q;
        StringBuilder localStringBuilder = new StringBuilder("start new session, specifyReport:");
        localStringBuilder.append(paramStatSpecifyReportedInfo);
        localStatLogger.d(localStringBuilder.toString());
      }
      if ((paramStatSpecifyReportedInfo == null) || (l == 0)) {
        l = StatCommonHelper.getNextSessionID();
      }
      StatConfig.a(0);
      StatConfig.b();
      new ab(new com.tencent.acstat.event.g(paramContext, l, b(), paramStatSpecifyReportedInfo)).a();
    }
  }
  
  static boolean a()
  {
    if (a >= 2)
    {
      b = System.currentTimeMillis();
      return true;
    }
    return false;
  }
  
  static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static void addActionListener(StatActionListener paramStatActionListener)
  {
    y.add(paramStatActionListener);
  }
  
  static JSONObject b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      int i1 = StatConfig.b.d;
      if (i1 != 0) {
        localJSONObject2.put("v", StatConfig.b.d);
      }
      localJSONObject1.put(Integer.toString(StatConfig.b.a), localJSONObject2);
      localJSONObject2 = new JSONObject();
      if (StatConfig.a.d != 0) {
        localJSONObject2.put("v", StatConfig.a.d);
      }
      localJSONObject1.put(Integer.toString(StatConfig.a.a), localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      q.e(localJSONException);
    }
    return localJSONObject1;
  }
  
  private static void b(Context paramContext, StatAccount paramStatAccount, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    try
    {
      new ab(new com.tencent.acstat.event.a(paramContext, a(paramContext, false, paramStatSpecifyReportedInfo), paramStatAccount, paramStatSpecifyReportedInfo)).a();
      return;
    }
    catch (Throwable paramContext)
    {
      q.e(paramContext);
    }
  }
  
  static boolean b(Context paramContext)
  {
    long l1 = StatPreferences.getLong(paramContext, StatConfig.c, 0L);
    long l2 = StatCommonHelper.getSDKLongVersion("2.4.2");
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (l2 <= l1)
    {
      localObject = q;
      StringBuilder localStringBuilder = new StringBuilder("MTA is disable for current version:");
      localStringBuilder.append(l2);
      localStringBuilder.append(",wakeup version:");
      localStringBuilder.append(l1);
      ((StatLogger)localObject).error(localStringBuilder.toString());
      bool1 = false;
    }
    else
    {
      bool1 = true;
    }
    l1 = StatPreferences.getLong(paramContext, StatConfig.d, 0L);
    if (l1 > System.currentTimeMillis())
    {
      paramContext = q;
      localObject = new StringBuilder("MTA is disable for current time:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(",wakeup time:");
      ((StringBuilder)localObject).append(l1);
      paramContext.error(((StringBuilder)localObject).toString());
      bool1 = bool2;
    }
    StatConfig.setEnableStatService(bool1);
    return bool1;
  }
  
  static Handler c(Context paramContext)
  {
    if (d == null) {
      try
      {
        Handler localHandler = d;
        if (localHandler == null) {
          try
          {
            a(paramContext);
          }
          catch (Throwable paramContext)
          {
            q.error(paramContext);
            StatConfig.setEnableStatService(false);
          }
        }
      }
      finally {}
    }
    return d;
  }
  
  static void c()
  {
    a = 0;
    b = 0L;
  }
  
  public static void commitEvents(Context paramContext, int paramInt)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    if (StatConfig.isDebugEnable())
    {
      localObject = q;
      StringBuilder localStringBuilder = new StringBuilder("commitEvents, maxNumber=");
      localStringBuilder.append(paramInt);
      ((StatLogger)localObject).i(localStringBuilder.toString());
    }
    paramContext = getContext(paramContext);
    if (paramContext == null) {
      paramContext = q;
    }
    for (Object localObject = "The Context of StatService.commitEvents() can not be null!";; localObject = "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.")
    {
      paramContext.error(localObject);
      return;
      if ((paramInt >= -1) && (paramInt != 0))
      {
        if (!NetworkManager.getInstance(paramContext).isNetworkAvailable()) {
          return;
        }
        if (c(paramContext) != null) {
          d.post(new p(paramContext, paramInt));
        }
        return;
      }
      paramContext = q;
    }
  }
  
  static void d()
  {
    a += 1;
    b = System.currentTimeMillis();
    flushDataToDB(t);
  }
  
  static void d(Context paramContext)
  {
    c = System.currentTimeMillis() + StatConfig.getSendPeriodMinutes() * 60000;
    StatPreferences.putLong(paramContext, "last_period_ts", c);
    commitEvents(paramContext, -1);
  }
  
  static void e(Context paramContext)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.sendNetworkDetector() can not be null!");
      return;
    }
    try
    {
      com.tencent.acstat.event.e locale = new com.tencent.acstat.event.e(paramContext);
      g.b(paramContext).a(locale, new q());
      return;
    }
    catch (Throwable paramContext)
    {
      q.e(paramContext);
    }
  }
  
  public static void flushDataToDB(Context paramContext)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    if (StatConfig.m <= 0) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.testSpeed() can not be null!");
      return;
    }
    af.a(paramContext).c();
  }
  
  public static Properties getCommonKeyValueForKVEvent(String paramString)
  {
    return (Properties)f.get(paramString);
  }
  
  public static Context getContext(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext;
    }
    return t;
  }
  
  public static boolean isBackground()
  {
    return v;
  }
  
  public static boolean isForeground()
  {
    return v;
  }
  
  public static void onLowMemory(Context paramContext)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    if (c(getContext(paramContext)) != null) {
      d.post(new z(paramContext));
    }
  }
  
  public static void onStop(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (c(paramContext) != null) {
      d.post(new y(paramContext));
    }
  }
  
  public static void removeActionListener(StatActionListener paramStatActionListener)
  {
    y.remove(paramStatActionListener);
  }
  
  public static void reportQQ(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("context is null in reportQQ()");
      return;
    }
    StatConfig.f = paramString;
    if (c(paramContext) != null) {
      d.post(new w(paramString, paramContext, paramStatSpecifyReportedInfo));
    }
  }
  
  public static void setCommonKeyValueForKVEvent(String paramString, Properties paramProperties)
  {
    if (StatCommonHelper.isStringValid(paramString))
    {
      if ((paramProperties != null) && (paramProperties.size() > 0))
      {
        f.put(paramString, (Properties)paramProperties.clone());
        return;
      }
      f.remove(paramString);
      return;
    }
    q.e("event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
  }
  
  public static void setContext(Context paramContext)
  {
    if (paramContext != null) {
      t = paramContext.getApplicationContext();
    }
  }
  
  public static void setEnvAttributes(Context paramContext, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() <= 512)) {
      try
      {
        com.tencent.acstat.common.a.a(paramContext, paramMap);
        return;
      }
      catch (JSONException paramContext)
      {
        q.e(paramContext);
        return;
      }
    }
    q.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
  }
  
  public static void startNewSession(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.startNewSession() can not be null!");
      return;
    }
    if (c(paramContext) != null) {
      d.post(new v(paramContext, paramStatSpecifyReportedInfo));
    }
  }
  
  public static boolean startStatService(Context paramContext, String paramString1, String paramString2, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    try
    {
      if (!StatConfig.isEnableStatService())
      {
        q.error("MTA StatService is disable.");
        return false;
      }
      if (!StatConfig.isDebugEnable()) {
        break label230;
      }
      StatLogger localStatLogger = q;
      StringBuilder localStringBuilder = new StringBuilder("MTA SDK version, current: ");
      localStringBuilder.append("2.4.2");
      localStringBuilder.append(" ,required: ");
      localStringBuilder.append(paramString2);
      localStatLogger.d(localStringBuilder.toString());
    }
    catch (Throwable paramContext)
    {
      q.e(paramContext);
      return false;
    }
    if (StatCommonHelper.getSDKLongVersion("2.4.2") < StatCommonHelper.getSDKLongVersion(paramString2))
    {
      paramContext = new StringBuilder("MTA SDK version conflicted, current: ");
      paramContext.append("2.4.2");
      paramContext.append(",required: ");
      paramContext.append(paramString2);
      paramContext = paramContext.toString();
      paramString1 = new StringBuilder();
      paramString1.append(paramContext);
      paramString1.append(". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
      paramContext = paramString1.toString();
      q.error(paramContext);
      StatConfig.setEnableStatService(false);
      return false;
    }
    if (paramString1 != null) {
      StatConfig.setAppKey(paramContext, paramString1);
    }
    if (c(paramContext) != null)
    {
      d.post(new x(paramContext, paramStatSpecifyReportedInfo));
      break label241;
      for (;;)
      {
        q.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
        StatConfig.setEnableStatService(false);
        return false;
        label230:
        if (paramContext != null) {
          if (paramString2 != null) {
            break;
          }
        }
      }
    }
    label241:
    return true;
  }
  
  public static void stopSession()
  {
    i = 0L;
  }
  
  public static void trackBeginPage(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if ((paramContext != null) && (paramString != null) && (paramString.length() != 0))
    {
      paramString = new String(paramString);
      if (c(paramContext) != null) {
        d.post(new t(paramString, paramContext, paramStatSpecifyReportedInfo));
      }
      return;
    }
    q.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
  }
  
  public static void trackCustomBeginEvent(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, String... paramVarArgs)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
      return;
    }
    paramStatSpecifyReportedInfo = new c(paramString, paramVarArgs, null);
    if (c(paramContext) != null) {
      d.post(new l(paramString, paramStatSpecifyReportedInfo));
    }
  }
  
  public static void trackCustomBeginKVEvent(Context paramContext, String paramString, Properties paramProperties, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
      return;
    }
    paramProperties = new c(paramString, null, paramProperties);
    if (c(paramContext) != null) {
      d.post(new n(paramString, paramProperties));
    }
  }
  
  public static void trackCustomEndEvent(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, String... paramVarArgs)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
      return;
    }
    paramVarArgs = new c(paramString, paramVarArgs, null);
    if (c(paramContext) != null) {
      d.post(new m(paramString, paramVarArgs, paramContext, paramStatSpecifyReportedInfo));
    }
  }
  
  public static void trackCustomEndKVEvent(Context paramContext, String paramString, Properties paramProperties, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null)
    {
      q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
      return;
    }
    paramProperties = new c(paramString, null, paramProperties);
    if (c(paramContext) != null) {
      d.post(new o(paramString, paramProperties, paramContext, paramStatSpecifyReportedInfo));
    }
  }
  
  public static void trackCustomEvent(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo, String... paramVarArgs)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null) {
      paramContext = q;
    }
    for (paramString = "The Context of StatService.trackCustomEvent() can not be null!";; paramString = "The event_id of StatService.trackCustomEvent() can not be null or empty.")
    {
      paramContext.error(paramString);
      return;
      if (!a(paramString)) {
        break;
      }
      paramContext = q;
    }
    paramString = new c(paramString, paramVarArgs, null);
    if (c(paramContext) != null) {
      d.post(new aa(paramContext, paramStatSpecifyReportedInfo, paramString));
    }
  }
  
  public static void trackCustomKVEvent(Context paramContext, String paramString, Properties paramProperties, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null) {
      paramContext = q;
    }
    for (paramString = "The Context of StatService.trackCustomEvent() can not be null!";; paramString = "The event_id of StatService.trackCustomEvent() can not be null or empty.")
    {
      paramContext.error(paramString);
      return;
      if (!a(paramString)) {
        break;
      }
      paramContext = q;
    }
    paramString = new c(paramString, null, paramProperties);
    if (c(paramContext) != null) {
      d.post(new k(paramContext, paramStatSpecifyReportedInfo, paramString));
    }
  }
  
  public static void trackCustomKVTimeIntervalEvent(Context paramContext, String paramString, Properties paramProperties, int paramInt, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if (paramContext == null) {
      paramContext = q;
    }
    for (paramString = "The Context of StatService.trackCustomEndEvent() can not be null!";; paramString = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.")
    {
      paramContext.error(paramString);
      return;
      if (!a(paramString)) {
        break;
      }
      paramContext = q;
    }
    paramString = new c(paramString, null, paramProperties);
    if (c(paramContext) != null) {
      d.post(new r(paramContext, paramStatSpecifyReportedInfo, paramString, paramInt));
    }
  }
  
  public static void trackEndPage(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    paramContext = getContext(paramContext);
    if ((paramContext != null) && (paramString != null) && (paramString.length() != 0))
    {
      paramString = new String(paramString);
      if (c(paramContext) != null) {
        d.post(new u(paramContext, paramString, paramStatSpecifyReportedInfo));
      }
      return;
    }
    q.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.StatServiceImpl
 * JD-Core Version:    0.7.0.1
 */