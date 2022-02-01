package com.tencent.ad.tangram.offline;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.sqlite.b;
import com.tencent.ad.tangram.canvas.AdCanvasJsonManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAnalysis;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForXJ;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
public enum AdOffline
{
  INSTANCE;
  
  private static final String TAG = "AdOffline";
  private WeakReference<AdOfflineAdapter> adapter;
  private Map<String, String> map = new HashMap();
  
  private AdOffline() {}
  
  private String getAppVersion()
  {
    AdOfflineAdapter localAdOfflineAdapter = getAdapter();
    if (localAdOfflineAdapter != null) {
      return localAdOfflineAdapter.getAppVersion();
    }
    return null;
  }
  
  private boolean isReportForTianQinEnable(Context paramContext)
  {
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext != null) {
      return paramContext.settingsForXJ.enableOfflineReportForTianQin;
    }
    return false;
  }
  
  private void reportOnClickForAnalysis(Context paramContext, Ad paramAd, AdClickUtil.Result paramResult)
  {
    Object localObject1 = getVersionIfExists(paramAd.getBusinessIdForXiJingOffline());
    Object localObject2 = AdReporterForAnalysis.createEventForAd(paramContext, 1106, paramAd);
    int i;
    if ((paramResult != null) && (paramResult.urlType == 3))
    {
      ((gdt_analysis_event)localObject2).internalErrorCode = 0;
      if (paramResult == null) {
        break label241;
      }
      i = paramResult.action;
      label50:
      ((gdt_analysis_event)localObject2).actionId = i;
      ((gdt_analysis_event)localObject2).businessId = paramAd.getBusinessIdForXiJingOffline();
      ((gdt_analysis_event)localObject2).offlineVersion = ((String)localObject1);
      if (paramResult == null) {
        break label247;
      }
      i = paramResult.urlType;
      label85:
      ((gdt_analysis_event)localObject2).urlType = i;
      paramResult = new b(new AdAnalysisEvent((gdt_analysis_event)localObject2, 101));
      paramAd = new ArrayList();
      paramAd.add(paramResult);
      localObject2 = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
      paramResult = AdAnalysis.INSTANCE;
      localObject1 = new WeakReference(paramContext);
      if (localObject2 == null) {
        break label253;
      }
    }
    label241:
    label247:
    label253:
    for (paramContext = ((gdt_settings.Settings)localObject2).settingsForAnalysis.urlForReport;; paramContext = "https://dp3.qq.com/stdlog")
    {
      AdLog.i("AdOffline", String.format("reportOnClickForAnalysis %d", new Object[] { Integer.valueOf(paramResult.send((WeakReference)localObject1, paramContext, paramAd)) }));
      return;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((gdt_analysis_event)localObject2).internalErrorCode = 105;
        break;
      }
      if (!TextUtils.isEmpty(AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramAd, paramAd.getJSONKeyForXiJingOffline(), false))) {
        break;
      }
      ((gdt_analysis_event)localObject2).internalErrorCode = 104;
      break;
      i = 0;
      break label50;
      i = 0;
      break label85;
    }
  }
  
  private void reportOnClickForTianQin(Context paramContext, Ad paramAd, AdClickUtil.Result paramResult)
  {
    if (!isReportForTianQinEnable(paramContext)) {
      return;
    }
    paramContext = new JSONArray();
    String str = getVersionIfExists(paramAd.getBusinessIdForXiJingOffline());
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("attr", "xj_qq_click");
        localJSONObject.put("val", 1);
        localJSONObject.put("count", 1);
        localJSONObject.put("product_type", paramAd.getProductType());
        localJSONObject.put("bid", paramAd.getBusinessIdForXiJingOffline());
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        bool = true;
        localJSONObject.put("has_offline_package", bool);
        if (TextUtils.isEmpty(AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramAd, paramAd.getJSONKeyForXiJingOffline(), false))) {
          continue;
        }
        bool = true;
        localJSONObject.put("has_canvas_json", bool);
        if (paramResult == null) {
          continue;
        }
        if (paramResult.urlType != 3) {
          continue;
        }
        bool = true;
        localJSONObject.put("is_offline", bool);
        localJSONObject.put("offline_version", str);
        localJSONObject.put("app_version", getAppVersion());
        localJSONObject.put("os_type", 2);
        paramContext.put(localJSONObject);
      }
      catch (Throwable paramAd)
      {
        boolean bool;
        AdLog.e("AdOffline", "reportOnClickForTianQin", paramAd);
        continue;
      }
      paramContext = String.format("https://tianqin.qq.com/batch/gxt?tqEncodeJson=%s&_tk=a3d32964452c0a14&_nf=1", new Object[] { URLEncoder.encode(paramContext.toString()) });
      paramAd = new AdHttp.Params();
      paramAd.setUrl(paramContext);
      paramAd.method = "GET";
      AdHttp.send(paramAd);
      AdLog.i("AdOffline", String.format("reportForTianQin url:%s responseCode:%d", new Object[] { paramContext, Integer.valueOf(paramAd.responseCode) }));
      return;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private void reportOnGetCanvasJsonForTianQin(Context paramContext, Ad paramAd, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (!isReportForTianQinEnable(paramContext)) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    String str;
    if (paramAd != null)
    {
      paramContext = paramAd.getBusinessIdForXiJingOffline();
      str = getVersionIfExists(paramContext);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("attr", "xj_qq_get_canvas_json");
        localJSONObject.put("val", paramLong);
        localJSONObject.put("count", 1);
        localJSONObject.put("status", paramInt);
        if (paramAd == null) {
          continue;
        }
        paramInt = paramAd.getCreativeSize();
        localJSONObject.put("creative_size", paramInt);
        if (paramAd == null) {
          continue;
        }
        paramInt = paramAd.getProductType();
        localJSONObject.put("product_type", paramInt);
        localJSONObject.put("bid", paramContext);
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        bool = true;
        localJSONObject.put("has_offline_package", bool);
        localJSONObject.put("offline_version", str);
        if (paramAd == null) {
          continue;
        }
        bool = true;
        localJSONObject.put("has_ad_info", bool);
        localJSONObject.put("has_canvas_json", paramBoolean);
        localJSONObject.put("app_version", getAppVersion());
        localJSONObject.put("os_type", 2);
        localJSONArray.put(localJSONObject);
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        AdLog.e("AdOffline", "reportOnGetCanvasJsonForTianQin", paramContext);
        continue;
      }
      paramContext = String.format("https://tianqin.qq.com/batch/gxt?tqEncodeJson=%s&_tk=a3d32964452c0a14&_nf=1", new Object[] { URLEncoder.encode(localJSONArray.toString()) });
      paramAd = new AdHttp.Params();
      paramAd.setUrl(paramContext);
      paramAd.method = "GET";
      AdHttp.send(paramAd);
      AdLog.i("AdOffline", String.format("reportOnGetCanvasJsonForTianQin url:%s responseCode:%d", new Object[] { paramContext, Integer.valueOf(paramAd.responseCode) }));
      return;
      paramContext = null;
      break;
      paramInt = 0;
      continue;
      paramInt = 0;
      continue;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private void update(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString2))
      {
        this.map.put(paramString1, paramString2);
        return;
      }
    } while (!this.map.containsKey(paramString1));
    this.map.remove(paramString1);
  }
  
  public AdOfflineAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdOfflineAdapter)this.adapter.get();
    }
    return null;
  }
  
  public String getVersionIfExists(String paramString)
  {
    Object localObject = getAdapter();
    if (localObject != null) {}
    for (localObject = ((AdOfflineAdapter)localObject).getVersionIfExists(paramString);; localObject = null)
    {
      update(paramString, (String)localObject);
      AdLog.i("AdOffline", String.format("getVersionIfExists businessId:%s version:%s", new Object[] { paramString, localObject }));
      return localObject;
    }
  }
  
  public String getVersionIfExistsFromMemory(String paramString)
  {
    return (String)this.map.get(paramString);
  }
  
  public boolean isEnable(Context paramContext)
  {
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext != null) {
      return paramContext.settingsForXJ.offline;
    }
    return false;
  }
  
  public void reportOnClick(Context paramContext, Ad paramAd, AdClickUtil.Result paramResult)
  {
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      paramContext = new WeakReference(paramContext);
      AdThreadManager.INSTANCE.post(new AdOffline.1(this, paramAd, paramContext, paramResult), 4);
      return;
    }
  }
  
  public void reportOnGetCanvasJson(Context paramContext, Ad paramAd, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      paramContext = new WeakReference(paramContext);
      AdThreadManager.INSTANCE.post(new AdOffline.2(this, paramContext, paramAd, paramBoolean, paramLong1, paramLong2), 4);
      return;
    }
  }
  
  public void setAdapter(WeakReference<AdOfflineAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.offline.AdOffline
 * JD-Core Version:    0.7.0.1
 */