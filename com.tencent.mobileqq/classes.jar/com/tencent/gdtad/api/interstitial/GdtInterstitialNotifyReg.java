package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

final class GdtInterstitialNotifyReg
  implements IAppNotifyCallback
{
  private static int a(int paramInt)
  {
    if ((paramInt != 101) && (paramInt != 102) && (paramInt != 106))
    {
      if ((paramInt != 103) && (paramInt != 104) && (paramInt != 105) && (paramInt != 107))
      {
        if (paramInt == 108) {
          return 1;
        }
        GdtLog.d("GdtInterstitialNotifyReg", String.format("getError arkScriptError:%d not working", new Object[] { Integer.valueOf(paramInt) }));
      }
      return 1;
    }
    return 4;
  }
  
  private static int a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!JSONObject.NULL.equals(localJSONObject))
        {
          int i = localJSONObject.getInt("reason");
          return i;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      GdtLog.d("GdtInterstitialNotifyReg", String.format("getReasonForClose params:%s", new Object[] { paramString }), localThrowable);
    }
    return -2147483648;
  }
  
  private static GdtAd a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new JSONObject(paramString);
        if (!JSONObject.NULL.equals(localObject))
        {
          localObject = ((JSONObject)localObject).getJSONObject("adInfo");
          if ((localObject != null) && (!JSONObject.NULL.equals(localObject)))
          {
            localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject));
            if (localObject != null)
            {
              localObject = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
              boolean bool = ((GdtAd)localObject).isValid();
              if (bool) {
                return localObject;
              }
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      GdtLog.b("GdtInterstitialNotifyReg", String.format("getAd params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  private static JSONObject a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!JSONObject.NULL.equals(localJSONObject))
        {
          localJSONObject = localJSONObject.getJSONObject("options");
          if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)))
          {
            localJSONObject = localJSONObject.getJSONObject("antiSpamParamsOnCGI");
            return localJSONObject;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      GdtLog.b("GdtInterstitialNotifyReg", String.format("getAntiSpamParamsOnCGI params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus, "interstitial_view_resume_event");
  }
  
  private static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, String paramString)
  {
    paramContext = new WeakReference(paramContext);
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToLogicThread(new GdtInterstitialNotifyReg.1(paramGdtInterstitialParams, paramString, paramContext, paramGdtInterstitialStatus));
  }
  
  private boolean a(String paramString)
  {
    paramString = b(paramString);
    AdHttp.Params localParams;
    if (!TextUtils.isEmpty(paramString))
    {
      localParams = new AdHttp.Params();
      localParams.setUrl(paramString);
      localParams.method = "GET";
      if (localParams.canSend()) {}
    }
    else
    {
      bool = false;
      break label63;
    }
    boolean bool = AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.2(this, localParams), 4);
    label63:
    GdtLog.b("GdtInterstitialNotifyReg", String.format("receiveHTTPGet %b %s", new Object[] { Boolean.valueOf(bool), paramString }));
    return bool;
  }
  
  private static int b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!JSONObject.NULL.equals(localJSONObject))
        {
          int i = localJSONObject.getInt("errCode");
          return i;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      GdtLog.d("GdtInterstitialNotifyReg", String.format("getError params:%s", new Object[] { paramString }), localThrowable);
    }
    return -2147483648;
  }
  
  private static String b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new JSONObject(paramString);
        if (!JSONObject.NULL.equals(localObject))
        {
          localObject = ((JSONObject)localObject).getString("url");
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      GdtLog.d("GdtInterstitialNotifyReg", String.format("getUrl params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  private static WeakReference<GdtInterstitialFragment> b(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.isValid()))
    {
      paramString = paramString.getTraceId();
      if (!TextUtils.isEmpty(paramString)) {
        return GdtInterstitialManager.a().a(paramString);
      }
    }
    return null;
  }
  
  private static JSONObject b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!JSONObject.NULL.equals(localJSONObject))
        {
          localJSONObject = localJSONObject.getJSONObject("options");
          if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)))
          {
            localJSONObject = localJSONObject.getJSONObject("antiSpamParamsOnReportServer");
            return localJSONObject;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      GdtLog.b("GdtInterstitialNotifyReg", String.format("getAntiSpamParamsOnReportServer params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus, "interstitial_view_pause_event");
  }
  
  private boolean b(String paramString)
  {
    WeakReference localWeakReference = b(paramString);
    boolean bool;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      paramString = a(paramString);
      AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.3(this, localWeakReference, paramString), 0);
      bool = true;
    }
    else
    {
      bool = false;
    }
    GdtLog.b("GdtInterstitialNotifyReg", String.format("receiveClick %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  private static String c(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new JSONObject(paramString);
        if (!JSONObject.NULL.equals(localObject))
        {
          localObject = ((JSONObject)localObject).getString("key");
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      GdtLog.d("GdtInterstitialNotifyReg", String.format("getKey params:%s", new Object[] { paramString }), localThrowable);
    }
    return null;
  }
  
  public static void c(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus, "interstitial_view_destroy_event");
  }
  
  private boolean c(String paramString)
  {
    int i = a(paramString);
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.get() != null))
    {
      AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.4(this, paramString, i), 0);
      bool = true;
    }
    else
    {
      bool = false;
    }
    GdtLog.b("GdtInterstitialNotifyReg", String.format("receiveClose %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  private boolean d(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.get() != null))
    {
      AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.5(this, paramString), 0);
      bool = true;
    }
    else
    {
      bool = false;
    }
    GdtLog.b("GdtInterstitialNotifyReg", String.format("receiveLoaded %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  private boolean e(String paramString)
  {
    int i = b(paramString);
    int j = a(i);
    GdtLog.d("GdtInterstitialNotifyReg", String.format("receiveError error:%d arkScriptError:%d params:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramString }));
    if ((j != 4) && (j != 207)) {
      return true;
    }
    paramString = b(paramString);
    if (paramString != null)
    {
      if (paramString.get() == null) {
        return true;
      }
      AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.6(this, paramString, j, i), 0);
    }
    return true;
  }
  
  private boolean f(String paramString)
  {
    JSONObject localJSONObject = b(paramString);
    if ((localJSONObject != null) && (!JSONObject.NULL.equals(localJSONObject)) && (localJSONObject.length() > 0))
    {
      Object localObject = b(paramString);
      paramString = null;
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        localObject = ((GdtInterstitialFragment)((WeakReference)localObject).get()).a();
      } else {
        localObject = null;
      }
      if (localObject != null) {
        paramString = ((GdtInterstitialParams)localObject).a;
      }
      if ((paramString != null) && (!JSONObject.NULL.equals(paramString)) && (paramString.length() > 0))
      {
        GdtLog.b("GdtInterstitialNotifyReg", String.format("receiveReportForAntiSpamOnReportServer ark:%s position:%s", new Object[] { localJSONObject.toString(), paramString.toString() }));
        localObject = paramString.keys();
        while (((Iterator)localObject).hasNext()) {
          try
          {
            String str = (String)((Iterator)localObject).next();
            localJSONObject.put(str, paramString.get(str));
          }
          catch (Throwable localThrowable)
          {
            GdtLog.d("GdtInterstitialNotifyReg", "receiveReportForAntiSpamOnReportServer", localThrowable);
          }
        }
        GdtReportForAntiSpam.b(localJSONObject);
        return true;
      }
      GdtLog.d("GdtInterstitialNotifyReg", "receiveReportForAntiSpamOnReportServer error, antiSpamParamsFromPosition is null");
      return false;
    }
    GdtLog.d("GdtInterstitialNotifyReg", "receiveReportForAntiSpamOnReportServer error, antiSpamParams is null");
    return false;
  }
  
  private boolean g(String paramString)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialNotifyReg.7(this, paramString), 0);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    int i = 1;
    GdtLog.b("GdtInterstitialNotifyReg", String.format("notify appName:%s eventName:%s params:%s", new Object[] { paramString1, paramString2, paramString3 }));
    boolean bool1 = bool2;
    Object localObject1;
    if (GdtInterstitialManager.a().a().a.equals(paramString1))
    {
      if ("interstitial_http_get_event".equals(paramString2)) {
        bool1 = a(paramString3);
      }
      for (;;)
      {
        break;
        if ("interstitial_jump_click_event".equals(paramString2))
        {
          bool1 = b(paramString3);
          break label217;
        }
        if ("interstitial_close_click_event".equals(paramString2))
        {
          bool1 = c(paramString3);
          break label217;
        }
        if ("interstitial_success_event".equals(paramString2))
        {
          bool1 = d(paramString3);
          break label217;
        }
        if ("interstitial_error_event".equals(paramString2))
        {
          bool1 = e(paramString3);
          break label217;
        }
        if ("interstitial_antispam_report_event".equals(paramString2))
        {
          bool1 = f(paramString3);
        }
        else
        {
          bool1 = bool2;
          if ("interstitial_report_event".equals(paramString2))
          {
            localObject1 = c(paramString3);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              paramString2 = (String)localObject1;
            }
            bool1 = g(paramString3);
            break label217;
          }
        }
      }
    }
    i = 0;
    label217:
    if (i != 0)
    {
      WeakReference localWeakReference = b(paramString3);
      Object localObject2 = null;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        paramString3 = ((GdtInterstitialFragment)localWeakReference.get()).a();
      } else {
        paramString3 = null;
      }
      localObject1 = localObject2;
      if (localWeakReference != null)
      {
        localObject1 = localObject2;
        if (localWeakReference.get() != null) {
          localObject1 = ((GdtInterstitialFragment)localWeakReference.get()).a();
        }
      }
      GdtAnalysisHelperForInterstitial.a(BaseApplication.getContext(), paramString3, (GdtInterstitialStatus)localObject1, paramString2, paramString1);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg
 * JD-Core Version:    0.7.0.1
 */