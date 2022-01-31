package com.tencent.ad.tangram.analysis;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.sqlite.b;
import com.tencent.ad.tangram.analysis.sqlite.d;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.protocol.gdt_analysis_response;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAnalysis;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForAnalysis.Batch;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@Keep
public enum AdAnalysis
{
  INSTANCE;
  
  private static final String TAG = "AdAnalysis";
  private WeakReference<AdAnalysisAdapter> adapter;
  private volatile boolean initialized = false;
  private volatile boolean reporting = false;
  
  private AdAnalysis() {}
  
  private AdAnalysisAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdAnalysisAdapter)this.adapter.get();
    }
    return null;
  }
  
  private String getAppVersion()
  {
    AdAnalysisAdapter localAdAnalysisAdapter = getAdapter();
    if (localAdAnalysisAdapter != null) {
      return localAdAnalysisAdapter.getAppVersion();
    }
    return null;
  }
  
  private String getUIN()
  {
    AdAnalysisAdapter localAdAnalysisAdapter = getAdapter();
    if (localAdAnalysisAdapter != null) {
      return localAdAnalysisAdapter.getUIN();
    }
    return null;
  }
  
  private void report(WeakReference<Context> paramWeakReference)
  {
    if (this.reporting) {
      return;
    }
    try
    {
      if (this.reporting) {
        return;
      }
    }
    finally {}
    this.reporting = true;
    reportInternal(paramWeakReference);
    try
    {
      this.reporting = false;
      return;
    }
    finally {}
  }
  
  private void reportInternal(WeakReference<Context> paramWeakReference)
  {
    gdt_settings.Settings localSettings = AdSettingsUtil.INSTANCE.getSettingsCache((Context)paramWeakReference.get());
    if (localSettings == null) {}
    List localList;
    do
    {
      do
      {
        return;
      } while ((localSettings.settingsForAnalysis.mode != 1) || (!a.isABTestByUIN(getUIN(), localSettings.settingsForAnalysis.abTest)));
      localList = d.query((Context)paramWeakReference.get(), localSettings.settingsForAnalysis.batch.limit);
    } while ((localList == null) || (localList.isEmpty()) || ((((b)localList.get(0)).strategy > 101) && (localList.size() < localSettings.settingsForAnalysis.batch.limit) && (System.currentTimeMillis() - ((b)localList.get(localList.size() - 1)).timeMillis < localSettings.settingsForAnalysis.batch.intervalMillisMax)));
    int i = send(paramWeakReference, localSettings.settingsForAnalysis.urlForReport, localList);
    AdSettingsUtil.INSTANCE.update((Context)paramWeakReference.get());
    if ((i <= 100) && (d.delete((Context)paramWeakReference.get(), localList)))
    {
      reportInternal(paramWeakReference);
      return;
    }
    AdThreadManager.INSTANCE.postDelayed(new AdAnalysis.3(this, paramWeakReference), 4, localSettings.settingsForAnalysis.batch.intervalMillis);
  }
  
  private int send(WeakReference<Context> paramWeakReference, String paramString, List<b> paramList)
  {
    AdLog.i("AdAnalysis", String.format("send %s", new Object[] { paramString }));
    int j = 100;
    if (paramWeakReference == null) {
      return 100;
    }
    int i = j;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return 100;
      }
      i = j;
      paramList = AdAnalysisUtil.createBody(paramList);
      i = j;
      paramWeakReference = AdAnalysisUtil.createRequest((Context)paramWeakReference.get(), paramList, getAppVersion());
      if (paramWeakReference == null) {
        return 100;
      }
      i = j;
      paramWeakReference = AdJSON.fromObject(paramWeakReference);
      if (paramWeakReference == null) {
        return 100;
      }
      i = j;
      paramWeakReference = paramWeakReference.toString();
      i = j;
      if (TextUtils.isEmpty(paramWeakReference)) {
        return 100;
      }
      i = j;
      paramWeakReference = paramWeakReference.getBytes();
      if (paramWeakReference == null) {
        return 100;
      }
      i = j;
      paramList = new AdHttp.Params();
      i = j;
      paramList.setUrl(paramString);
      i = j;
      paramList.method = "POST";
      i = j;
      paramList.contentType = "application/json";
      i = j;
      paramList.requestData = paramWeakReference;
      i = j;
      paramList.connectTimeoutMillis = 3000;
      i = j;
      paramList.readTimeoutMillis = 3000;
      i = j;
      if (!paramList.canSend()) {
        return 100;
      }
      i = j;
      AdHttp.send(paramList);
      i = j;
      if (paramList.responseCode != 200) {
        return 100;
      }
      j = 500;
      i = j;
      if (paramList.responseData != null)
      {
        i = j;
        if (paramList.responseData.length <= 0) {
          return 500;
        }
        i = j;
        paramWeakReference = (gdt_analysis_response)gdt_analysis_response.class.cast(AdJSON.toObject(new JSONObject(new String(paramList.responseData)), gdt_analysis_response.class));
        if (paramWeakReference == null) {
          return 500;
        }
        i = j;
        j = paramWeakReference.ret;
        if (j == 0) {
          return 0;
        }
      }
    }
    catch (Throwable paramWeakReference)
    {
      AdLog.e("AdAnalysis", "send", paramWeakReference);
      return i;
    }
    return 500;
  }
  
  public void handleAsync(WeakReference<Context> paramWeakReference, AdAnalysisEvent paramAdAnalysisEvent)
  {
    if ((paramAdAnalysisEvent == null) || (!paramAdAnalysisEvent.isValid()))
    {
      AdLog.e("AdAnalysis", "handleAsync error");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramAdAnalysisEvent);
    handleAsync(paramWeakReference, localArrayList);
  }
  
  public void handleAsync(WeakReference<Context> paramWeakReference, List<AdAnalysisEvent> paramList)
  {
    if (getAdapter() == null)
    {
      AdLog.e("AdAnalysis", "getAdapter() == null");
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AdLog.e("AdAnalysis", "handleAsync error");
      return;
    }
    int i = paramList.size();
    String str;
    if ((paramList.size() == 1) && (paramList.get(0) != null))
    {
      str = ((AdAnalysisEvent)paramList.get(0)).getId();
      AdLog.i("AdAnalysis", String.format("handleAsync size:%d eventId:%s", new Object[] { Integer.valueOf(i), str }));
      if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {
        break label155;
      }
    }
    label155:
    for (paramWeakReference = new WeakReference(((Context)paramWeakReference.get()).getApplicationContext());; paramWeakReference = null)
    {
      if (paramWeakReference != null) {
        break label160;
      }
      AdLog.e("AdAnalysis", "handleAsync error");
      return;
      str = null;
      break;
    }
    label160:
    if (AdSettingsUtil.INSTANCE.getSettingsCache((Context)paramWeakReference.get()) == null) {}
    for (long l = 3000L;; l = 0L)
    {
      AdThreadManager.INSTANCE.postDelayed(new AdAnalysis.2(this, paramWeakReference, paramList), 4, l);
      return;
    }
  }
  
  public void init(Context paramContext)
  {
    AdLog.i("AdAnalysis", String.format("init %b", new Object[] { Boolean.valueOf(this.initialized) }));
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
    }
    finally {}
    this.initialized = true;
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      paramContext = new WeakReference(paramContext);
      if ((paramContext == null) || (paramContext.get() == null)) {
        break;
      }
      AdThreadManager.INSTANCE.post(new AdAnalysis.1(this, paramContext), 4);
      return;
    }
  }
  
  public void setAdapter(WeakReference<AdAnalysisAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.AdAnalysis
 * JD-Core Version:    0.7.0.1
 */