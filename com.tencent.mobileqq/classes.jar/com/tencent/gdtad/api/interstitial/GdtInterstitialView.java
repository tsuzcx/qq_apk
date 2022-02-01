package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.ark.open.ArkView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.GdtAdView;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class GdtInterstitialView
  implements GdtAdView
{
  private ArkView a;
  
  public GdtInterstitialView(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    this.a = a(paramContext, paramGdtInterstitialParams, paramGdtInterstitialStatus);
  }
  
  private static ArkView a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    WeakReference localWeakReference1 = new WeakReference(paramContext);
    WeakReference localWeakReference2 = new WeakReference(paramGdtInterstitialStatus);
    ArkView localArkView = null;
    Object localObject1;
    if (paramGdtInterstitialParams != null) {
      localObject1 = paramGdtInterstitialParams.c();
    } else {
      localObject1 = null;
    }
    paramGdtInterstitialStatus = localArkView;
    try
    {
      Object localObject2 = GdtInterstitialManager.a().d();
      paramGdtInterstitialStatus = localArkView;
      String str1 = a(paramContext, paramGdtInterstitialParams);
      paramGdtInterstitialStatus = localArkView;
      GdtLog.b("GdtInterstitialView", String.format("load appName:%s view:%s minver:%s", new Object[] { ((GdtArkApp)localObject2).a, ((GdtArkApp)localObject2).b, ((GdtArkApp)localObject2).c }));
      paramGdtInterstitialStatus = localArkView;
      long l = System.currentTimeMillis();
      paramGdtInterstitialStatus = localArkView;
      localArkView = new ArkView(paramContext, null);
      if (paramGdtInterstitialParams != null) {
        try
        {
          if ((paramGdtInterstitialParams.g >= 0) && (paramGdtInterstitialParams.h >= 0))
          {
            paramContext = new ArkAppInfo.Size(paramGdtInterstitialParams.g, paramGdtInterstitialParams.h);
            localArkView.setSize(paramContext, paramContext, paramContext);
          }
        }
        catch (Throwable paramContext)
        {
          paramGdtInterstitialStatus = localArkView;
          break label252;
        }
      }
      try
      {
        localArkView.setBorderType(0);
        String str2 = ((GdtArkApp)localObject2).a;
        String str3 = ((GdtArkApp)localObject2).b;
        localObject2 = ((GdtArkApp)localObject2).c;
        localObject1 = new GdtInterstitialView.1(l, (String)localObject1, localWeakReference2, localWeakReference1, paramGdtInterstitialParams);
        paramContext = localArkView;
        paramGdtInterstitialStatus = paramContext;
        localArkView.load(str2, str3, (String)localObject2, str1, null, (ArkViewImplement.LoadCallback)localObject1);
      }
      catch (Throwable paramContext)
      {
        paramGdtInterstitialStatus = localArkView;
      }
      AdLog.e("GdtInterstitialView", "createView", paramContext);
    }
    catch (Throwable paramContext) {}
    label252:
    paramContext = paramGdtInterstitialStatus;
    if (localWeakReference2.get() != null) {
      GdtAnalysisHelperForInterstitial.a((Context)localWeakReference1.get(), paramGdtInterstitialParams, (GdtInterstitialStatus)localWeakReference2.get());
    }
    return paramContext;
  }
  
  private static String a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.b()))
    {
      String str;
      int i;
      if (paramGdtInterstitialParams.e == 1)
      {
        str = "vertical";
        i = 1;
      }
      else if ((paramGdtInterstitialParams.e != 0) && (paramGdtInterstitialParams.e != 8))
      {
        str = null;
        i = -2147483648;
      }
      else
      {
        str = "horizontal";
        i = 0;
      }
      if ((!TextUtils.isEmpty(str)) && (i != -2147483648))
      {
        int j = AdUIUtils.px2dp(paramContext, paramGdtInterstitialParams.g);
        int k = AdUIUtils.px2dp(paramContext, paramGdtInterstitialParams.h);
        GdtLog.b("GdtInterstitialView", String.format("getMetaData width:%d height:%d ptWidth:%d ptHeight:%d", new Object[] { Integer.valueOf(paramGdtInterstitialParams.g), Integer.valueOf(paramGdtInterstitialParams.h), Integer.valueOf(j), Integer.valueOf(k) }));
        try
        {
          paramContext = new JSONObject();
          paramContext.put("style", i);
          paramContext.put("screenType", str);
          paramGdtInterstitialParams = GdtJsonPbUtil.a(paramGdtInterstitialParams.d.a.info);
          if ((paramGdtInterstitialParams != null) && (!JSONObject.NULL.equals(paramGdtInterstitialParams))) {
            paramContext.put("adInfo", paramGdtInterstitialParams);
          }
          paramContext.put("viewWidth", j);
          paramContext.put("viewHeight", k);
          paramGdtInterstitialParams = new JSONObject();
          paramGdtInterstitialParams.put("gdt", paramContext);
          paramContext = paramGdtInterstitialParams.toString();
          return paramContext;
        }
        catch (Throwable paramContext)
        {
          GdtLog.d("GdtInterstitialView", "getMetaData", paramContext);
          return null;
        }
      }
      GdtLog.d("GdtInterstitialView", "getMetaData error");
      return null;
    }
    GdtLog.d("GdtInterstitialView", "getMetaData error");
    return null;
  }
  
  private static void b(int paramInt1, int paramInt2, String paramString)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialView.2(paramString, paramInt1, paramInt2), 0);
  }
  
  public void a(Context paramContext)
  {
    GdtLog.b("GdtInterstitialView", "pause");
    paramContext = this.a;
    if (paramContext != null) {
      paramContext.onPause();
    }
  }
  
  public void b(Context paramContext)
  {
    GdtLog.b("GdtInterstitialView", "resume");
    paramContext = this.a;
    if (paramContext != null) {
      paramContext.onResume();
    }
  }
  
  public void c(Context paramContext)
  {
    GdtLog.b("GdtInterstitialView", "destroy");
    paramContext = this.a;
    if (paramContext != null) {
      paramContext.onDestroy();
    }
  }
  
  public View getView()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialView
 * JD-Core Version:    0.7.0.1
 */