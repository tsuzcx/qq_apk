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
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.ad.tangram.version.AdVersion;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@Keep
public enum AdAnalysis
{
  INSTANCE;
  
  private static final String TAG = "AdAnalysis";
  private volatile boolean reporting = false;
  
  private AdAnalysis() {}
  
  private String getUIN()
  {
    return AdUin.INSTANCE.getUIN();
  }
  
  /* Error */
  private void report(WeakReference<Context> paramWeakReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/ad/tangram/analysis/AdAnalysis:reporting	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 31	com/tencent/ad/tangram/analysis/AdAnalysis:reporting	Z
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 31	com/tencent/ad/tangram/analysis/AdAnalysis:reporting	Z
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_0
    //   28: aload_1
    //   29: invokespecial 53	com/tencent/ad/tangram/analysis/AdAnalysis:reportInternal	(Ljava/lang/ref/WeakReference;)V
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 31	com/tencent/ad/tangram/analysis/AdAnalysis:reporting	Z
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	AdAnalysis
    //   0	52	1	paramWeakReference	WeakReference<Context>
    // Exception table:
    //   from	to	target	type
    //   34	41	42	finally
    //   43	45	42	finally
    //   10	19	47	finally
    //   20	27	47	finally
    //   48	50	47	finally
  }
  
  private void reportInternal(WeakReference<Context> paramWeakReference)
  {
    gdt_settings.Settings localSettings = AdSettingsManager.INSTANCE.getCache();
    if (localSettings == null) {
      return;
    }
    if (localSettings.settingsForAnalysis.mode != 1) {
      return;
    }
    if (!AdABTest.isABTestByUIN(getUIN(), localSettings.settingsForAnalysis.abTest)) {
      return;
    }
    List localList = d.query((Context)paramWeakReference.get(), localSettings.settingsForAnalysis.batch.limit);
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return;
      }
      if ((((b)localList.get(0)).strategy <= 101) || (localList.size() >= localSettings.settingsForAnalysis.batch.limit) || (System.currentTimeMillis() - ((b)localList.get(localList.size() - 1)).timeMillis >= localSettings.settingsForAnalysis.batch.intervalMillisMax))
      {
        if ((send(paramWeakReference, localSettings.settingsForAnalysis.urlForReport, localList)) && (d.delete((Context)paramWeakReference.get(), localList)))
        {
          reportInternal(paramWeakReference);
          return;
        }
        AdThreadManager.INSTANCE.postDelayed(new AdAnalysis.2(this, paramWeakReference), 4, localSettings.settingsForAnalysis.batch.intervalMillis);
      }
    }
  }
  
  public void handleAsync(WeakReference<Context> paramWeakReference, AdAnalysisEvent paramAdAnalysisEvent)
  {
    if ((paramAdAnalysisEvent != null) && (paramAdAnalysisEvent.isValid()))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramAdAnalysisEvent);
      handleAsync(paramWeakReference, localArrayList);
      return;
    }
    AdLog.e("AdAnalysis", "handleAsync error");
  }
  
  public void handleAsync(WeakReference<Context> paramWeakReference, List<AdAnalysisEvent> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = paramList.size();
      int j = paramList.size();
      Object localObject2 = null;
      if ((j == 1) && (paramList.get(0) != null)) {
        localObject1 = ((AdAnalysisEvent)paramList.get(0)).getId();
      } else {
        localObject1 = null;
      }
      AdLog.i("AdAnalysis", String.format("handleAsync size:%d eventId:%s", new Object[] { Integer.valueOf(i), localObject1 }));
      Object localObject1 = localObject2;
      if (paramWeakReference != null)
      {
        localObject1 = localObject2;
        if (paramWeakReference.get() != null) {
          localObject1 = new WeakReference(((Context)paramWeakReference.get()).getApplicationContext());
        }
      }
      if (localObject1 == null)
      {
        AdLog.e("AdAnalysis", "handleAsync error");
        return;
      }
      long l;
      if (AdSettingsManager.INSTANCE.getCache() == null) {
        l = 3000L;
      } else {
        l = 0L;
      }
      AdThreadManager.INSTANCE.postDelayed(new AdAnalysis.1(this, (WeakReference)localObject1, paramList), 4, l);
      return;
    }
    AdLog.e("AdAnalysis", "handleAsync error");
  }
  
  public boolean send(WeakReference<Context> paramWeakReference, String paramString, List<b> paramList)
  {
    paramString = AdUriUtil.replaceHttpsWithHttpForVivoY67OnAndroidM(paramString);
    AdLog.i("AdAnalysis", String.format("send %s", new Object[] { paramString }));
    if (paramWeakReference == null) {
      return false;
    }
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramList = AdAnalysisUtil.createBody(paramList);
      paramWeakReference = AdAnalysisUtil.createRequest((Context)paramWeakReference.get(), paramList, AdVersion.INSTANCE.getAppVersion());
      if (paramWeakReference == null) {
        return false;
      }
      paramWeakReference = AdJSON.fromObject(paramWeakReference);
      if (paramWeakReference == null) {
        return false;
      }
      paramWeakReference = paramWeakReference.toString();
      if (TextUtils.isEmpty(paramWeakReference)) {
        return false;
      }
      paramWeakReference = paramWeakReference.getBytes();
      if (paramWeakReference == null) {
        return false;
      }
      paramList = new AdHttp.Params();
      paramList.setUrl(paramString);
      paramList.method = "POST";
      paramList.contentType = "application/json";
      paramList.requestData = paramWeakReference;
      paramList.connectTimeoutMillis = 3000;
      paramList.readTimeoutMillis = 3000;
      if (!paramList.canSend()) {
        return false;
      }
      AdHttp.send(paramList);
      if (paramList.responseCode != 200) {
        return false;
      }
      if (paramList.responseData != null)
      {
        if (paramList.responseData.length <= 0) {
          return false;
        }
        paramWeakReference = (gdt_analysis_response)gdt_analysis_response.class.cast(AdJSON.toObject(new JSONObject(new String(paramList.responseData)), gdt_analysis_response.class));
        if (paramWeakReference == null) {
          return false;
        }
        int i = paramWeakReference.ret;
        return i == 0;
      }
    }
    catch (Throwable paramWeakReference)
    {
      AdLog.e("AdAnalysis", "send", paramWeakReference);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.AdAnalysis
 * JD-Core Version:    0.7.0.1
 */