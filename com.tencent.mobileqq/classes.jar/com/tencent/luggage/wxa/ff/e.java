package com.tencent.luggage.wxa.ff;

import android.content.Context;
import com.tencent.luggage.wxa.hv.h;
import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.lx.f.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/report/JsApiInvokeReportProtocol;", "", "()V", "IGNORED_APIS", "", "", "TAG", "TYPE_OFFLINE", "sErrMsgPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "sIgnoredApis", "", "[Ljava/lang/String;", "doReportInternal", "", "wxaRuntime", "Lcom/tencent/luggage/wxa/standalone_open_runtime/runtime/WxaRuntime;", "appId", "pagePath", "functionName", "dataStr", "permissionValue", "", "costTime", "", "ret", "extractJsApiErrMsg", "extractJsApiResult", "errMsg", "getNetworkTypeForReport", "context", "Landroid/content/Context;", "getServiceTypeForReport", "isIgnoredApi", "", "api", "makeKeyRequest", "data", "Lcom/tencent/mm/json/InnerJSONObject;", "makeKeyResult", "postReportJsApiInvoked", "apiName", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class e
{
  public static final e a = new e();
  private static final String[] b = { "addMapCircles", "addMapControls", "addMapLines", "addMapMarkers", "createAudioInstance", "createRequestTask", "createSocketTask", "destroyAudioInstance", "disableScrollBounce", "drawCanvas", "getAudioState", "getCurrentRoute", "getMapCenterLocation", "getStorage", "getStorageSync", "getSystemInfo", "hideToast", "moveToMapLocation", "onAccelerometerChange", "onCompassChange", "onKeyboardValueChange", "onMapRegionChange", "onSocketClose", "onSocketError", "onSocketMessage", "onSocketOpen", "onTouchEnd", "onTouchMove", "onTouchStart", "onVideoTimeUpdate", "operateAudio", "operateSocketTask", "removeStorageSync", "reportIDKey", "reportKeyValue", "reportRealtimeAction", "setStorage", "setStorageSync", "showModal", "showToast", "syncAudioEvent", "updateCanvas", "updateMap", "traceEvent" };
  private static final Set<String> c;
  private static final Pattern d = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");
  
  static
  {
    String[] arrayOfString = b;
    c = (Set)new HashSet((Collection)Arrays.asList((String[])Arrays.copyOf(arrayOfString, arrayOfString.length)));
  }
  
  private final int a(com.tencent.luggage.wxa.fk.e parame, String paramString)
  {
    if (Intrinsics.areEqual("@LibraryAppId", paramString)) {
      return 0;
    }
    com.tencent.luggage.wxa.eo.a locala = null;
    int j = b.a(paramString, 0, 2, null);
    int i = j;
    if (j < 0)
    {
      if (parame != null) {
        locala = parame.G();
      }
      if (locala != null)
      {
        i = locala.c;
        b.a(paramString, i);
      }
      else
      {
        o.d("Luggage.WXA.JsApiInvokeReportProtocol", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(j) });
        i = j;
      }
    }
    return i + 1000;
  }
  
  private final String a(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = r.a();
    }
    paramContext = com.tencent.luggage.wxa.lx.f.a(paramContext);
    if (f.a[paramContext.ordinal()] != 1)
    {
      paramContext = paramContext.h;
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "type.value");
      return paramContext;
    }
    return "offline";
  }
  
  private final String a(String paramString, com.tencent.luggage.wxa.hv.c paramc)
  {
    i locali = new i();
    if (paramString != null) {
      try
      {
        if ((paramString.hashCode() == -1701611132) && (paramString.equals("chooseImage"))) {
          locali.c("sizeType", paramc.optString("sizeType"));
        }
      }
      catch (com.tencent.luggage.wxa.hv.g paramString)
      {
        o.a("Luggage.WXA.JsApiInvokeReportProtocol", (Throwable)paramString, "get keyParam error!", new Object[0]);
      }
    }
    paramString = (String)null;
    try
    {
      paramc = URLEncoder.encode(locali.toString(), "UTF-8");
      return paramc;
    }
    catch (UnsupportedEncodingException paramc) {}
    return paramString;
  }
  
  private final String a(String paramString1, String paramString2)
  {
    if (!com.tencent.luggage.wxa.qz.af.c(paramString1))
    {
      if (com.tencent.luggage.wxa.qz.af.c(paramString2)) {
        return "";
      }
      if (paramString2 != null) {
        try
        {
          if ((paramString2.hashCode() == -316023509) && (paramString2.equals("getLocation")))
          {
            paramString1 = h.b(paramString1);
            Intrinsics.checkExpressionValueIsNotNull(paramString1, "JSONFactory.newJSONObject(ret)");
            paramString2 = StringCompanionObject.INSTANCE;
            paramString2 = new Object[7];
            paramString2[0] = paramString1.optString("latitude");
            paramString2[1] = paramString1.optString("longitude");
            paramString2[2] = paramString1.optString("speed");
            paramString2[3] = paramString1.optString("accuracy");
            paramString2[4] = paramString1.optString("altitude");
            paramString2[5] = paramString1.optString("verticalAccuracy");
            paramString2[6] = paramString1.optString("horizontalAccuracy");
            paramString1 = String.format("%s;%s;%s;%s;%s;%s;%s", Arrays.copyOf(paramString2, paramString2.length));
            Intrinsics.checkExpressionValueIsNotNull(paramString1, "java.lang.String.format(format, *args)");
            return paramString1;
          }
        }
        catch (com.tencent.luggage.wxa.hv.g paramString1)
        {
          o.a("Luggage.WXA.JsApiInvokeReportProtocol", (Throwable)paramString1, "get keyParam error!", new Object[0]);
        }
      }
      return "";
    }
    return "";
  }
  
  private final String b(String paramString)
  {
    boolean bool = com.tencent.luggage.wxa.qz.af.c(paramString);
    String str = "";
    if (bool) {
      return "";
    }
    Matcher localMatcher = d.matcher((CharSequence)paramString);
    paramString = str;
    if (localMatcher.matches())
    {
      paramString = com.tencent.luggage.wxa.qz.af.b(localMatcher.group(1));
      Intrinsics.checkExpressionValueIsNotNull(paramString, "Util.nullAsNil(matcher.group(1))");
    }
    return paramString;
  }
  
  private final void b(com.tencent.luggage.wxa.fk.e parame, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong, String paramString5)
  {
    com.tencent.luggage.wxa.ou.d locald;
    if (parame != null) {
      locald = parame.l();
    } else {
      locald = null;
    }
    if (locald == null)
    {
      o.b("Luggage.WXA.JsApiInvokeReportProtocol", "statObject is Null!");
      return;
    }
    if (CollectionsKt.contains((Iterable)c, paramString3)) {
      return;
    }
    boolean bool = com.tencent.luggage.wxa.qz.af.c(paramString4);
    Object localObject5 = "";
    Object localObject4;
    int j;
    int i;
    if ((!bool) && (!com.tencent.luggage.wxa.qz.af.c(paramString3)))
    {
      try
      {
        Object localObject1 = h.b(paramString4);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "JSONFactory.newJSONObject(dataStr)");
        localObject4 = a(paramString3, (com.tencent.luggage.wxa.hv.c)localObject1);
        try
        {
          if ((((com.tencent.luggage.wxa.hv.c)localObject1).has("url")) && ((Intrinsics.areEqual(paramString3, "openLink")) || (Intrinsics.areEqual(paramString3, "redirectTo")) || (Intrinsics.areEqual(paramString3, "navigateTo")) || (Intrinsics.areEqual(paramString3, "request")) || (Intrinsics.areEqual(paramString3, "connectSocket")) || (Intrinsics.areEqual(paramString3, "uploadFile")) || (Intrinsics.areEqual(paramString3, "downloadFile"))))
          {
            paramString4 = ((com.tencent.luggage.wxa.hv.c)localObject1).optString("url");
          }
          else
          {
            bool = Intrinsics.areEqual(paramString3, "authorize");
            if (bool)
            {
              try
              {
                paramString4 = h.c(((com.tencent.luggage.wxa.hv.c)localObject1).optString("scope"));
                Intrinsics.checkExpressionValueIsNotNull(paramString4, "JSONFactory.newJSONArray(data.optString(\"scope\"))");
                localObject1 = new LinkedList();
                j = paramString4.length();
                i = 0;
                while (i < j)
                {
                  ((LinkedList)localObject1).add(paramString4.optString(i));
                  i += 1;
                }
                paramString4 = ((LinkedList)localObject1).toString();
              }
              catch (Exception paramString4)
              {
                o.b("Luggage.WXA.JsApiInvokeReportProtocol", "Exception %s", new Object[] { paramString4.getMessage() });
                return;
              }
            }
            else
            {
              bool = Intrinsics.areEqual(paramString3, "shareAppMessage");
              if (bool)
              {
                try
                {
                  paramString4 = URLEncoder.encode(com.tencent.luggage.wxa.qz.af.b(localObject1.toString()), "UTF-8");
                }
                catch (UnsupportedEncodingException paramString4)
                {
                  o.a("Luggage.WXA.JsApiInvokeReportProtocol", (Throwable)paramString4, "", new Object[0]);
                  paramString4 = "";
                  localObject1 = localObject4;
                  break label675;
                }
              }
              else if (Intrinsics.areEqual(paramString3, "requestPayment"))
              {
                paramString4 = ((com.tencent.luggage.wxa.hv.c)localObject1).optString("package");
              }
              else if (Intrinsics.areEqual(paramString3, "reportSubmitForm"))
              {
                paramString4 = com.tencent.luggage.wxa.iu.g.c(paramString1).b;
              }
              else if (Intrinsics.areEqual(paramString3, "makePhoneCall"))
              {
                paramString4 = ((com.tencent.luggage.wxa.hv.c)localObject1).optString("phoneNumber");
              }
              else if (Intrinsics.areEqual(paramString3, "chooseVideo"))
              {
                paramString4 = ((com.tencent.luggage.wxa.hv.c)localObject1).optString("maxDuration");
              }
              else
              {
                Object localObject2;
                if (Intrinsics.areEqual(paramString3, "updateHTMLWebView"))
                {
                  paramString4 = ((com.tencent.luggage.wxa.hv.c)localObject1).optString("src");
                  try
                  {
                    localObject1 = URLEncoder.encode(((com.tencent.luggage.wxa.hv.c)localObject1).optString("src"), "UTF-8");
                    paramString4 = (String)localObject1;
                  }
                  catch (com.tencent.luggage.wxa.hv.g localg1)
                  {
                    break label642;
                  }
                  catch (Exception localException)
                  {
                    o.b("Luggage.WXA.JsApiInvokeReportProtocol", localException.toString());
                    localObject2 = localObject4;
                    break label675;
                  }
                }
                else if (Intrinsics.areEqual(paramString3, "showKeyboard"))
                {
                  paramString4 = localObject2.optString("confirmType");
                }
                else if (Intrinsics.areEqual(paramString3, "setAudioState"))
                {
                  paramString4 = localObject2.optString("volume");
                }
                else
                {
                  paramString4 = "";
                }
              }
            }
          }
        }
        catch (com.tencent.luggage.wxa.hv.g localg2)
        {
          paramString4 = "";
        }
        o.a("Luggage.WXA.JsApiInvokeReportProtocol", (Throwable)localg3, "get keyParam error!", new Object[0]);
      }
      catch (com.tencent.luggage.wxa.hv.g localg3)
      {
        paramString4 = "";
        localObject4 = paramString4;
      }
      label642:
      localObject3 = localObject4;
    }
    else
    {
      paramString4 = "";
    }
    label675:
    label757:
    String str1;
    for (Object localObject3 = paramString4;; localObject3 = str1)
    {
      String str6 = a(paramString5, paramString3);
      if (!com.tencent.luggage.wxa.qz.af.c(paramString2))
      {
        if (paramString2 == null) {
          Intrinsics.throwNpe();
        }
        localObject4 = (CharSequence)paramString2;
        if (StringsKt.contains$default((CharSequence)localObject4, (CharSequence)".html", false, 2, null))
        {
          paramString2 = paramString2.substring(0, StringsKt.lastIndexOf$default((CharSequence)localObject4, ".html", 0, false, 6, null) + 5);
          Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          break label757;
        }
      }
      paramString2 = "";
      try
      {
        localObject4 = URLEncoder.encode(com.tencent.luggage.wxa.qz.af.b(paramString2), "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        o.a("Luggage.WXA.JsApiInvokeReportProtocol", (Throwable)localUnsupportedEncodingException1, "encode page path error!", new Object[0]);
        str1 = "";
      }
      String str3;
      try
      {
        String str2 = URLEncoder.encode(com.tencent.luggage.wxa.qz.af.b(paramString4), "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        o.a("Luggage.WXA.JsApiInvokeReportProtocol", (Throwable)localUnsupportedEncodingException2, "encode keyParam path error!", new Object[0]);
        str3 = "";
      }
      try
      {
        String str4 = URLEncoder.encode(com.tencent.luggage.wxa.qz.af.b(str6), "UTF-8");
        localObject5 = str4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException3)
      {
        o.a("Luggage.WXA.JsApiInvokeReportProtocol", (Throwable)localUnsupportedEncodingException3, "encode keyResult path error!", new Object[0]);
      }
      paramString3 = com.tencent.luggage.wxa.qz.af.b(paramString3);
      paramString5 = b(paramString5);
      i = c(paramString5);
      String str5 = com.tencent.luggage.wxa.qz.af.b(locald.d);
      String str7 = a(r.a());
      if (locald.c == 0) {
        locald.c = 1000;
      }
      if (parame == null) {
        Intrinsics.throwNpe();
      }
      Object localObject6 = parame.i();
      Intrinsics.checkExpressionValueIsNotNull(localObject6, "wxaRuntime!!.sysConfig");
      l locall = (l)localObject6;
      localObject6 = parame.G();
      Intrinsics.checkExpressionValueIsNotNull(localObject6, "wxaRuntime!!.initConfig");
      localObject6 = (com.tencent.luggage.wxa.do.c)localObject6;
      j = locall.S.pkgVersion;
      int k = locall.c() + 1;
      int m = a(parame, paramString1);
      if (o.c() <= 1)
      {
        int n = locald.c;
        int i1 = locald.e;
        parame = (com.tencent.luggage.wxa.eo.a)localObject6;
        o.e("Luggage.WXA.JsApiInvokeReportProtocol", "jsapi invoke fields, scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d, appType %d, keyResult %s, keyRequest %s, instanceId:%s, sessionId:%s", new Object[] { Integer.valueOf(n), str5, paramString1, Integer.valueOf(j), Integer.valueOf(k), paramString2, str7, paramString3, paramString4, Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(0), Long.valueOf(paramLong), Integer.valueOf(0), paramString5, Integer.valueOf(i1), Integer.valueOf(m), str6, localObject3, parame.i(), parame.h() });
      }
      parame = new com.tencent.luggage.wxa.fj.d(0, null, null, 0, 0, null, null, null, null, 0, 0, 0, 0L, 0, null, 0, 0, null, 0, null, null, null, 4194303, null);
      parame.a(locald.c);
      parame.a(str5);
      parame.b(paramString1);
      parame.b(j);
      parame.c(k);
      parame.c(str1);
      parame.d(str7);
      parame.e(paramString3);
      parame.f(str3);
      parame.d(i);
      parame.e(paramInt);
      parame.f(0);
      parame.a(paramLong);
      parame.g(0);
      parame.g(paramString5);
      parame.h(locald.e);
      parame.i(locald.a);
      parame.h(locald.b);
      parame.j(m);
      parame.i((String)localObject5);
      parame.j((String)localObject3);
      parame.k(((com.tencent.luggage.wxa.eo.a)localObject6).i());
      paramString1 = Unit.INSTANCE;
      parame.a();
      return;
    }
  }
  
  private final int c(String paramString)
  {
    boolean bool = com.tencent.luggage.wxa.qz.af.c(paramString);
    int i = 1;
    if (bool) {
      return 1;
    }
    if (StringsKt.startsWith$default(paramString, "ok", false, 2, null)) {
      return 1;
    }
    if (StringsKt.startsWith$default(paramString, "fail", false, 2, null)) {
      i = 2;
    }
    return i;
  }
  
  public final void a(@Nullable com.tencent.luggage.wxa.fk.e parame, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, int paramInt, long paramLong, @NotNull String paramString5)
  {
    Intrinsics.checkParameterIsNotNull(paramString5, "ret");
    com.tencent.luggage.wxa.em.d locald = com.tencent.luggage.wxa.fa.b.a(paramString1);
    if (locald != null)
    {
      Object localObject = locald.l();
      int i;
      if (localObject != null) {
        i = ((com.tencent.luggage.wxa.ou.d)localObject).c;
      } else {
        i = 0;
      }
      localObject = locald.l();
      if (localObject != null) {
        localObject = ((com.tencent.luggage.wxa.ou.d)localObject).d;
      } else {
        localObject = null;
      }
      int j = locald.ab();
      int k = locald.b();
      com.tencent.luggage.wxa.rz.f.a.a((Runnable)new e.a(paramString1, paramString2, i, (String)localObject, j + 1, k, paramString3, paramString5, paramInt, parame, paramString4, paramLong), "Luggage.WXA.JsApiInvokeReportProtocol");
    }
  }
  
  public final boolean a(@Nullable String paramString)
  {
    paramString = (CharSequence)paramString;
    return (paramString == null) || (paramString.length() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ff.e
 * JD-Core Version:    0.7.0.1
 */