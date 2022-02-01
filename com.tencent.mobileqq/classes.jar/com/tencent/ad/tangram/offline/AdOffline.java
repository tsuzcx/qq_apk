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
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAnalysis;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  
  public void setAdapter(WeakReference<AdOfflineAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.offline.AdOffline
 * JD-Core Version:    0.7.0.1
 */