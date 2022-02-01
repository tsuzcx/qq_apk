package com.tencent.acstat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.acstat.a.a.c;
import com.tencent.acstat.common.DeviceInfo;
import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.common.StatPreferences;
import com.tencent.acstat.common.Util;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class StatConfig
{
  private static String A;
  private static String B;
  private static String C;
  private static String D;
  private static int E;
  private static String F;
  private static int G;
  private static long H;
  private static long I;
  public static String IMEI;
  private static volatile String J;
  private static int K;
  private static volatile int L;
  private static int M;
  private static int N;
  private static boolean O;
  private static int P;
  private static boolean Q;
  private static String R;
  private static f S = null;
  private static JSONObject T = null;
  private static String U = null;
  private static JSONObject V = null;
  private static HashSet<String> W = new HashSet();
  static e a;
  static e b;
  static String c;
  static String d;
  static String e;
  static String f;
  static boolean g;
  static int h;
  static long i;
  public static boolean isAutoExceptionCaught;
  static boolean j;
  static volatile String k;
  static boolean l;
  static int m;
  static long n;
  static int o;
  private static StatLogger p = ;
  private static StatReportStrategy q;
  private static boolean r;
  private static boolean s;
  private static int t;
  private static int u;
  private static int v;
  private static int w;
  private static int x;
  private static int y;
  private static int z;
  
  static
  {
    a = new e(2);
    b = new e(1);
    q = StatReportStrategy.APP_LAUNCH;
    r = false;
    s = true;
    t = 30000;
    u = 100000;
    v = 30;
    w = 10;
    x = 100;
    y = 30;
    z = 1;
    c = "__HIBERNATE__";
    d = "__HIBERNATE__TIME";
    e = "__MTA_KILL__";
    A = null;
    IMEI = null;
    D = "mta_channel";
    f = "";
    E = 180;
    g = false;
    h = 1000;
    i = 10000L;
    G = 1024;
    j = true;
    H = 0L;
    I = 300000L;
    isAutoExceptionCaught = true;
    k = "pingma.qq.com:80";
    J = "http://pingma.qq.com:80/mstat/report";
    K = 0;
    L = 0;
    M = 20;
    N = 0;
    O = false;
    P = 4096;
    Q = false;
    R = null;
    l = true;
    m = 0;
    n = 10000L;
    o = 512;
  }
  
  static int a()
  {
    return v;
  }
  
  static String a(Context paramContext)
  {
    return Util.decode(StatPreferences.getString(paramContext, "_mta_ky_tag_", null));
  }
  
  static void a(int paramInt)
  {
    try
    {
      L = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void a(long paramLong)
  {
    StatPreferences.putLong(g.a(), c, paramLong);
    setEnableStatService(false);
    p.warn("MTA is disable for current SDK version");
  }
  
  static void a(Context paramContext, e parame)
  {
    if (parame.a == b.a)
    {
      b = parame;
      a(parame.b);
      if (!b.b.isNull("iplist")) {
        NetworkManager.getInstance(paramContext).updateIpList(b.b.getString("iplist"));
      }
      updateDontReportEventIdsSet(b.b.optString("__DONT_REPORT_EI_LIST__", null));
      return;
    }
    if (parame.a == a.a) {
      a = parame;
    }
  }
  
  static void a(Context paramContext, e parame, JSONObject paramJSONObject)
  {
    int i1 = 0;
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.equalsIgnoreCase("v"))
        {
          int i2 = paramJSONObject.getInt(str);
          if (parame.d != i2) {
            i1 = 1;
          }
          parame.d = i2;
        }
        else if (str.equalsIgnoreCase("c"))
        {
          str = paramJSONObject.getString("c");
          if (str.length() > 0) {
            parame.b = new JSONObject(str);
          }
        }
        else if (str.equalsIgnoreCase("m"))
        {
          parame.c = paramJSONObject.getString("m");
        }
      }
      if (i1 == 1)
      {
        paramJSONObject = af.a(g.a());
        if (paramJSONObject != null) {
          paramJSONObject.a(parame);
        }
        if (parame.a == b.a)
        {
          a(parame.b);
          b(parame.b);
        }
      }
      a(paramContext, parame);
      return;
    }
    catch (Throwable paramContext)
    {
      p.e(paramContext);
      return;
    }
    catch (JSONException paramContext)
    {
      label193:
      break label193;
    }
  }
  
  static void a(Context paramContext, String paramString)
  {
    if (paramString != null) {
      StatPreferences.putString(paramContext, "_mta_ky_tag_", Util.encode(paramString));
    }
  }
  
  static void a(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        Object localObject1 = (String)localIterator.next();
        if (((String)localObject1).equalsIgnoreCase(Integer.toString(b.a))) {
          localObject1 = paramJSONObject.getJSONObject((String)localObject1);
        }
        for (Object localObject2 = b;; localObject2 = a)
        {
          a(paramContext, (e)localObject2, (JSONObject)localObject1);
          break;
          if (!((String)localObject1).equalsIgnoreCase(Integer.toString(a.a))) {
            break label91;
          }
          localObject1 = paramJSONObject.getJSONObject((String)localObject1);
        }
        label91:
        if (!((String)localObject1).equalsIgnoreCase("rs")) {
          break;
        }
        localObject1 = StatReportStrategy.getStatReportStrategy(paramJSONObject.getInt((String)localObject1));
        if (localObject1 != null)
        {
          q = (StatReportStrategy)localObject1;
          if (isDebugEnable())
          {
            localObject2 = p;
            StringBuilder localStringBuilder = new StringBuilder("Change to ReportStrategy:");
            localStringBuilder.append(((StatReportStrategy)localObject1).name());
            ((StatLogger)localObject2).d(localStringBuilder.toString());
          }
        }
      }
      return;
    }
    catch (JSONException paramContext)
    {
      p.e(paramContext);
    }
  }
  
  static void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = StatReportStrategy.getStatReportStrategy(paramJSONObject.getInt("rs"));
      if (paramJSONObject != null) {
        setStatSendStrategy(paramJSONObject);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label20:
      break label20;
    }
    if (isDebugEnable()) {
      p.i("rs not found.");
    }
  }
  
  static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= paramInt2) && (paramInt1 <= paramInt3);
  }
  
  private static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = B;
    if (localObject == null)
    {
      B = paramString;
      return true;
    }
    if (!((String)localObject).contains(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(B);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString);
      B = ((StringBuilder)localObject).toString();
      return true;
    }
    return false;
  }
  
  static boolean a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (!paramJSONObject.isNull(paramString1))
    {
      paramJSONObject = paramJSONObject.optString(paramString1);
      if ((StatCommonHelper.isStringValid(paramString2)) && (StatCommonHelper.isStringValid(paramJSONObject)) && (paramString2.equalsIgnoreCase(paramJSONObject))) {
        return true;
      }
    }
    return false;
  }
  
  static void b()
  {
    N += 1;
  }
  
  static void b(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    N = paramInt;
  }
  
  static void b(Context paramContext, JSONObject paramJSONObject)
  {
    label675:
    label680:
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optString(e);
        if (StatCommonHelper.isStringValid(paramJSONObject))
        {
          Object localObject = new JSONObject(paramJSONObject);
          if (((JSONObject)localObject).length() == 0) {
            return;
          }
          boolean bool = ((JSONObject)localObject).isNull("sm");
          int i3 = 0;
          StringBuilder localStringBuilder;
          if (!bool)
          {
            paramJSONObject = ((JSONObject)localObject).get("sm");
            if ((paramJSONObject instanceof Integer))
            {
              paramJSONObject = (Integer)paramJSONObject;
              i1 = paramJSONObject.intValue();
            }
            else
            {
              if (!(paramJSONObject instanceof String)) {
                break label675;
              }
              paramJSONObject = Integer.valueOf((String)paramJSONObject);
              continue;
            }
            if (i1 > 0)
            {
              if (isDebugEnable())
              {
                paramJSONObject = p;
                localStringBuilder = new StringBuilder("match sleepTime:");
                localStringBuilder.append(i1);
                localStringBuilder.append(" minutes");
                paramJSONObject.i(localStringBuilder.toString());
              }
              long l1 = System.currentTimeMillis();
              long l2 = i1 * 60 * 1000;
              StatPreferences.putLong(paramContext, d, l1 + l2);
              setEnableStatService(false);
              p.warn("MTA is disable for current SDK version");
            }
          }
          bool = a((JSONObject)localObject, "sv", "2.4.2");
          int i2 = 1;
          i1 = i3;
          if (bool)
          {
            p.i("match sdk version:2.4.2");
            i1 = 1;
          }
          if (a((JSONObject)localObject, "md", Build.MODEL))
          {
            paramJSONObject = p;
            localStringBuilder = new StringBuilder("match MODEL:");
            localStringBuilder.append(Build.MODEL);
            paramJSONObject.i(localStringBuilder.toString());
            i1 = 1;
          }
          if (a((JSONObject)localObject, "av", StatCommonHelper.getCurAppVersion(paramContext)))
          {
            paramJSONObject = p;
            localStringBuilder = new StringBuilder("match app version:");
            localStringBuilder.append(StatCommonHelper.getCurAppVersion(paramContext));
            paramJSONObject.i(localStringBuilder.toString());
            i1 = 1;
          }
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(Build.MANUFACTURER);
          if (a((JSONObject)localObject, "mf", paramJSONObject.toString()))
          {
            paramJSONObject = p;
            localStringBuilder = new StringBuilder("match MANUFACTURER:");
            localStringBuilder.append(Build.MANUFACTURER);
            paramJSONObject.i(localStringBuilder.toString());
            i1 = 1;
          }
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(Build.VERSION.SDK_INT);
          bool = a((JSONObject)localObject, "osv", paramJSONObject.toString());
          if (bool)
          {
            paramJSONObject = p;
            localStringBuilder = new StringBuilder("match android SDK version:");
            localStringBuilder.append(Build.VERSION.SDK_INT);
            paramJSONObject.i(localStringBuilder.toString());
            i1 = 1;
          }
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(Build.VERSION.SDK_INT);
          if (a((JSONObject)localObject, "ov", paramJSONObject.toString()))
          {
            paramJSONObject = p;
            localStringBuilder = new StringBuilder("match android SDK version:");
            localStringBuilder.append(Build.VERSION.SDK_INT);
            paramJSONObject.i(localStringBuilder.toString());
            i1 = 1;
          }
          if (a((JSONObject)localObject, "ui", af.a(paramContext).b(paramContext).getImei()))
          {
            paramJSONObject = p;
            localStringBuilder = new StringBuilder("match imei:");
            localStringBuilder.append(af.a(paramContext).b(paramContext).getImei());
            paramJSONObject.i(localStringBuilder.toString());
            i1 = 1;
          }
          if (!a((JSONObject)localObject, "mid", getLocalMidOnly(paramContext))) {
            break label680;
          }
          paramJSONObject = p;
          localObject = new StringBuilder("match mid:");
          ((StringBuilder)localObject).append(getLocalMidOnly(paramContext));
          paramJSONObject.i(((StringBuilder)localObject).toString());
          i1 = i2;
          if (i1 != 0) {
            a(StatCommonHelper.getSDKLongVersion("2.4.2"));
          }
        }
        return;
      }
      catch (Exception paramContext)
      {
        p.e(paramContext);
        return;
      }
      int i1 = 0;
    }
  }
  
  static void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      if (paramJSONObject.length() == 0) {
        return;
      }
    }
    try
    {
      b(g.a(), paramJSONObject);
      paramJSONObject = paramJSONObject.getString(c);
      if (isDebugEnable())
      {
        StatLogger localStatLogger = p;
        StringBuilder localStringBuilder = new StringBuilder("hibernateVer:");
        localStringBuilder.append(paramJSONObject);
        localStringBuilder.append(", current version:2.4.2");
        localStatLogger.d(localStringBuilder.toString());
      }
      long l1 = StatCommonHelper.getSDKLongVersion(paramJSONObject);
      if (StatCommonHelper.getSDKLongVersion("2.4.2") <= l1) {
        a(l1);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label95:
      break label95;
    }
    p.d("__HIBERNATE__ not found.");
  }
  
  static int c()
  {
    return N;
  }
  
  public static String getAppKey(Context paramContext)
  {
    try
    {
      if (B != null)
      {
        paramContext = B;
        return paramContext;
      }
      if ((paramContext != null) && (B == null)) {
        B = StatCommonHelper.getAppKey(paramContext);
      }
      if ((B == null) || (B.trim().length() == 0)) {
        p.e("AppKey can not be null or empty, please read Developer's Guide first!");
      }
      paramContext = B;
      return paramContext;
    }
    finally {}
  }
  
  public static String getAppVersion()
  {
    return U;
  }
  
  public static JSONObject getCommonAttr(Context paramContext)
  {
    if (T == null)
    {
      paramContext = StatPreferences.getString(paramContext, "mta.common.attr.tag", new JSONObject().toString());
      try
      {
        T = new JSONObject(paramContext);
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return T;
  }
  
  public static int getCurSessionStatReportCount()
  {
    return L;
  }
  
  public static JSONObject getCustomGlobalReportContent()
  {
    return V;
  }
  
  public static String getCustomProperty(String paramString)
  {
    try
    {
      paramString = a.b.getString(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      p.e(paramString);
    }
    return null;
  }
  
  public static String getCustomProperty(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a.b.getString(paramString1);
      if (paramString1 != null) {
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      p.e(paramString1);
    }
    return paramString2;
  }
  
  public static String getCustomUserId(Context paramContext)
  {
    if (paramContext == null)
    {
      p.error("Context for getCustomUid is null.");
      return null;
    }
    if (R == null) {
      try
      {
        R = StatPreferences.getString(paramContext, "MTA_CUSTOM_UID", "");
      }
      catch (ClassCastException paramContext)
      {
        p.e(paramContext);
      }
    }
    return R;
  }
  
  public static long getFlushDBSpaceMS()
  {
    return n;
  }
  
  public static String getImei(Context paramContext)
  {
    if (paramContext == null)
    {
      p.error("ctx in StatConfig.is null");
      return null;
    }
    if (IMEI == null) {
      IMEI = StatPreferences.getString(paramContext, "_mta_imei_tag_", null);
    }
    return IMEI;
  }
  
  public static String getInstallChannel(Context paramContext)
  {
    try
    {
      if (C != null)
      {
        paramContext = C;
        return paramContext;
      }
      String str = StatPreferences.getString(paramContext, D, "");
      C = str;
      if ((str == null) || (C.trim().length() == 0)) {
        C = StatCommonHelper.getInstallChannel(paramContext);
      }
      if ((C == null) || (C.trim().length() == 0)) {
        p.w("installChannel can not be null or empty, please read Developer's Guide first!");
      }
      paramContext = C;
      return paramContext;
    }
    finally {}
  }
  
  public static String getLocalMidOnly(Context paramContext)
  {
    return c.a(paramContext).a();
  }
  
  public static String getMTAPreferencesFileName()
  {
    return F;
  }
  
  public static int getMaxBatchReportCount()
  {
    return y;
  }
  
  public static int getMaxDaySessionNumbers()
  {
    return M;
  }
  
  public static int getMaxImportantDataSendRetryCount()
  {
    return x;
  }
  
  public static int getMaxParallelTimmingEvents()
  {
    return G;
  }
  
  public static int getMaxReportEventLength()
  {
    return P;
  }
  
  public static int getMaxSendRetryCount()
  {
    return w;
  }
  
  public static int getMaxSessionStatReportCount()
  {
    return K;
  }
  
  public static int getMaxStoreEventCount()
  {
    return u;
  }
  
  public static String getMid(Context paramContext)
  {
    return c.a(paramContext).a();
  }
  
  public static long getMsPeriodForMethodsCalledLimitClear()
  {
    return i;
  }
  
  public static int getNumEventsCachedInMemory()
  {
    return m;
  }
  
  public static int getNumEventsCommitPerSec()
  {
    return z;
  }
  
  public static int getNumOfMethodsCalledLimit()
  {
    return h;
  }
  
  public static String getQQ()
  {
    return f;
  }
  
  public static String getQQ(Context paramContext)
  {
    return StatPreferences.getString(paramContext, "mta.acc.qq", f);
  }
  
  public static int getReportCompressedSize()
  {
    return o;
  }
  
  public static int getSendPeriodMinutes()
  {
    return E;
  }
  
  public static int getSessionTimoutMillis()
  {
    return t;
  }
  
  public static String getStatReportHost()
  {
    return k;
  }
  
  public static String getStatReportUrl()
  {
    return J;
  }
  
  public static StatReportStrategy getStatSendStrategy()
  {
    return q;
  }
  
  public static boolean isAutoExceptionCaught()
  {
    return isAutoExceptionCaught;
  }
  
  public static boolean isDebugEnable()
  {
    return r;
  }
  
  public static boolean isEnableConcurrentProcess()
  {
    return Q;
  }
  
  public static boolean isEnableSmartReporting()
  {
    return j;
  }
  
  public static boolean isEnableStatService()
  {
    return s;
  }
  
  public static boolean isEventIdInDontReportEventIdsSet(String paramString)
  {
    HashSet localHashSet = W;
    if ((localHashSet != null) && (localHashSet.size() != 0) && (StatCommonHelper.isStringValid(paramString))) {
      return W.contains(paramString.toLowerCase());
    }
    return false;
  }
  
  public static boolean isReportEventsByOrder()
  {
    return l;
  }
  
  public static void setAppKey(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      paramContext = p;
    }
    for (paramString = "ctx in StatConfig.setAppKey() is null";; paramString = "appkey in StatConfig.setAppKey() is null or exceed 256 bytes")
    {
      paramContext.error(paramString);
      return;
      if ((paramString != null) && (paramString.length() <= 256))
      {
        if (B == null) {
          B = a(paramContext);
        }
        if ((a(paramString) | a(StatCommonHelper.getAppKey(paramContext)))) {
          a(paramContext, B);
        }
        return;
      }
      paramContext = p;
    }
  }
  
  public static void setAppKey(String paramString)
  {
    StatLogger localStatLogger;
    if (paramString == null) {
      localStatLogger = p;
    }
    for (paramString = "appkey in StatConfig.setAppKey() is null";; paramString = "The length of appkey cann't exceed 256 bytes.")
    {
      localStatLogger.error(paramString);
      return;
      if (paramString.length() <= 256) {
        break;
      }
      localStatLogger = p;
    }
    B = paramString;
  }
  
  public static void setAppVersion(String paramString)
  {
    U = paramString;
  }
  
  public static void setAutoExceptionCaught(boolean paramBoolean)
  {
    isAutoExceptionCaught = paramBoolean;
  }
  
  public static void setCommonAttr(Context paramContext, JSONObject paramJSONObject)
  {
    T = paramJSONObject;
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    StatPreferences.putString(paramContext, "mta.common.attr.tag", paramJSONObject.toString());
  }
  
  public static void setCustomGlobalReportContent(JSONObject paramJSONObject)
  {
    V = paramJSONObject;
  }
  
  public static void setCustomUserId(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      p.error("Context for setCustomUid is null.");
      return;
    }
    StatPreferences.putString(paramContext, "MTA_CUSTOM_UID", paramString);
    R = paramString;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    r = paramBoolean;
    StatCommonHelper.getLogger().setDebugEnable(paramBoolean);
  }
  
  public static void setEnableConcurrentProcess(boolean paramBoolean)
  {
    Q = paramBoolean;
  }
  
  public static void setEnableSmartReporting(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  public static void setEnableStatService(boolean paramBoolean)
  {
    s = paramBoolean;
    if (!paramBoolean) {
      p.warn("!!!!!!MTA StatService has been disabled!!!!!!");
    }
  }
  
  public static void setFlushDBSpaceMS(long paramLong)
  {
    if (paramLong > 0L) {
      n = paramLong;
    }
  }
  
  public static void setImei(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      p.error("ctx in StatConfig.setAppKey() is null");
      return;
    }
    if ((paramString != null) && (paramString.length() <= 256))
    {
      String str = IMEI;
      if (str == null)
      {
        IMEI = paramString;
        StatPreferences.putString(paramContext, "_mta_imei_tag_", paramString);
        return;
      }
      if (!str.equals(paramString))
      {
        IMEI = paramString;
        StatPreferences.putString(paramContext, "_mta_imei_tag_", paramString);
      }
      return;
    }
    p.error("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
  }
  
  public static void setInstallChannel(Context paramContext, String paramString)
  {
    if (paramString.length() > 128)
    {
      p.error("the length of installChannel can not exceed the range of 128 bytes.");
      return;
    }
    C = paramString;
    StatPreferences.putString(paramContext, D, paramString);
  }
  
  public static void setInstallChannel(String paramString)
  {
    if (paramString.length() > 128)
    {
      p.error("the length of installChannel can not exceed the range of 128 bytes.");
      return;
    }
    C = paramString;
  }
  
  public static void setMTAPreferencesFileName(String paramString)
  {
    F = paramString;
  }
  
  public static void setMaxBatchReportCount(int paramInt)
  {
    if (!a(paramInt, 2, 1000))
    {
      p.error("setMaxBatchReportCount can not exceed the range of [2,1000].");
      return;
    }
    y = paramInt;
  }
  
  public static void setMaxDaySessionNumbers(int paramInt)
  {
    if (paramInt <= 0)
    {
      p.e("maxDaySessionNumbers must be greater than 0.");
      return;
    }
    M = paramInt;
  }
  
  public static void setMaxImportantDataSendRetryCount(int paramInt)
  {
    if (paramInt > 100) {
      x = paramInt;
    }
  }
  
  public static void setMaxParallelTimmingEvents(int paramInt)
  {
    if (!a(paramInt, 1, 4096))
    {
      p.error("setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
      return;
    }
    G = paramInt;
  }
  
  public static void setMaxReportEventLength(int paramInt)
  {
    if (paramInt <= 0)
    {
      p.error("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
      return;
    }
    P = paramInt;
  }
  
  public static void setMaxSendRetryCount(int paramInt)
  {
    if (!a(paramInt, 1, 1000))
    {
      p.error("setMaxSendRetryCount can not exceed the range of [1,1000].");
      return;
    }
    w = paramInt;
  }
  
  public static void setMaxSessionStatReportCount(int paramInt)
  {
    if (paramInt < 0)
    {
      p.error("maxSessionStatReportCount cannot be less than 0.");
      return;
    }
    K = paramInt;
  }
  
  public static void setMaxStoreEventCount(int paramInt)
  {
    if (!a(paramInt, 0, 500000))
    {
      p.error("setMaxStoreEventCount can not exceed the range of [0, 500000].");
      return;
    }
    u = paramInt;
  }
  
  public static void setNumEventsCachedInMemory(int paramInt)
  {
    if (paramInt >= 0) {
      m = paramInt;
    }
  }
  
  public static void setNumEventsCommitPerSec(int paramInt)
  {
    if (paramInt > 0) {
      z = paramInt;
    }
  }
  
  public static void setNumOfMethodsCalledLimit(int paramInt, long paramLong)
  {
    h = paramInt;
    if (paramLong >= 1000L) {
      i = paramLong;
    }
  }
  
  public static void setQQ(Context paramContext, String paramString)
  {
    StatPreferences.putString(paramContext, "mta.acc.qq", paramString);
    f = paramString;
  }
  
  public static void setReportCompressedSize(int paramInt)
  {
    if (paramInt > 0) {
      o = paramInt;
    }
  }
  
  public static void setReportEventsByOrder(boolean paramBoolean)
  {
    l = paramBoolean;
  }
  
  public static void setSendPeriodMinutes(int paramInt)
  {
    if (!a(paramInt, 1, 10080))
    {
      p.error("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
      return;
    }
    E = paramInt;
  }
  
  public static void setSessionTimoutMillis(int paramInt)
  {
    if (!a(paramInt, 1000, 86400000))
    {
      p.error("setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
      return;
    }
    t = paramInt;
  }
  
  public static void setStatExCallBack(f paramf)
  {
    S = paramf;
  }
  
  public static void setStatReportUrl(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      J = paramString;
      try
      {
        k = new URI(J).getHost();
      }
      catch (Exception paramString)
      {
        p.w(paramString);
      }
      if (isDebugEnable())
      {
        paramString = p;
        StringBuilder localStringBuilder = new StringBuilder("url:");
        localStringBuilder.append(J);
        localStringBuilder.append(", domain:");
        localStringBuilder.append(k);
        paramString.i(localStringBuilder.toString());
      }
      return;
    }
    p.error("statReportUrl cannot be null or empty.");
  }
  
  public static void setStatSendStrategy(StatReportStrategy paramStatReportStrategy)
  {
    q = paramStatReportStrategy;
    if (paramStatReportStrategy != StatReportStrategy.PERIOD) {
      StatServiceImpl.c = 0L;
    }
    if (isDebugEnable())
    {
      StatLogger localStatLogger = p;
      StringBuilder localStringBuilder = new StringBuilder("Change to statSendStrategy: ");
      localStringBuilder.append(paramStatReportStrategy);
      localStatLogger.d(localStringBuilder.toString());
    }
  }
  
  public static void updateDontReportEventIdsSet(String paramString)
  {
    if (StatCommonHelper.isStringValid(paramString))
    {
      paramString = paramString.toLowerCase().split(";");
      if (paramString.length > 0)
      {
        if (W == null) {
          W = new HashSet(paramString.length);
        }
        W.addAll(Arrays.asList(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.StatConfig
 * JD-Core Version:    0.7.0.1
 */