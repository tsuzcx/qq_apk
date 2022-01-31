package com.tencent.ad.tangram.analysis;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.protocol.gdt_analysis_request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class b
{
  private static final String TAG = "AdAnalysisUtil";
  public static final int VERSION = 4;
  
  public static gdt_analysis_event[] createBody(List<com.tencent.ad.tangram.analysis.sqlite.b> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AdLog.e("AdAnalysisUtil", "createBody error");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      gdt_analysis_event localgdt_analysis_event = createEvent((com.tencent.ad.tangram.analysis.sqlite.b)paramList.next());
      if (localgdt_analysis_event != null) {
        localArrayList.add(localgdt_analysis_event);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    paramList = new gdt_analysis_event[localArrayList.size()];
    localArrayList.toArray(paramList);
    return paramList;
  }
  
  private static gdt_analysis_event createEvent(com.tencent.ad.tangram.analysis.sqlite.b paramb)
  {
    if (paramb == null) {
      return null;
    }
    try
    {
      paramb = (gdt_analysis_event)gdt_analysis_event.class.cast(AdJSON.toObject(new JSONObject(paramb.eventString), gdt_analysis_event.class));
      return paramb;
    }
    catch (Throwable paramb)
    {
      AdLog.e("AdAnalysisUtil", "createEvent", paramb);
    }
    return null;
  }
  
  public static gdt_analysis_request createRequest(Context paramContext, gdt_analysis_event[] paramArrayOfgdt_analysis_event, String paramString)
  {
    if ((paramArrayOfgdt_analysis_event == null) || (paramArrayOfgdt_analysis_event.length <= 0) || (TextUtils.isEmpty(paramString)))
    {
      AdLog.e("AdAnalysisUtil", "getRequest error");
      return null;
    }
    paramContext = new gdt_analysis_request();
    paramContext.bid = 10001013;
    paramContext.androidSDK = Build.VERSION.SDK_INT;
    paramContext.androidBrand = Build.BRAND;
    paramContext.androidManufacturer = Build.MANUFACTURER;
    paramContext.Model = Build.MODEL;
    paramContext.appVersion = paramString;
    paramContext.osType = 2;
    paramContext.osVersion = Build.VERSION.RELEASE;
    paramContext.body = paramArrayOfgdt_analysis_event;
    return paramContext;
  }
  
  public static void initEvent(Context paramContext, int paramInt, gdt_analysis_event paramgdt_analysis_event)
  {
    if ((paramgdt_analysis_event == null) || (paramInt == -2147483648))
    {
      AdLog.e("AdAnalysisUtil", "initEvent error");
      return;
    }
    paramgdt_analysis_event.eventId = String.valueOf(paramInt);
    paramgdt_analysis_event.androidCurrentProcessName = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
    paramgdt_analysis_event.currentTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.b
 * JD-Core Version:    0.7.0.1
 */