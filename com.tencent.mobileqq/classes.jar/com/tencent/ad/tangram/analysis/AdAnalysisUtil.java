package com.tencent.ad.tangram.analysis;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.sqlite.b;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.protocol.gdt_analysis_request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@Keep
public final class AdAnalysisUtil
{
  private static final String TAG = "AdAnalysisUtil";
  public static final int VERSION = 4;
  
  public static gdt_analysis_event[] createBody(List<b> paramList)
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
      gdt_analysis_event localgdt_analysis_event = createEvent((b)paramList.next());
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
  
  private static gdt_analysis_event createEvent(b paramb)
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
    gdt_analysis_request localgdt_analysis_request = new gdt_analysis_request();
    localgdt_analysis_request.bid = 10001013;
    localgdt_analysis_request.androidSDK = Build.VERSION.SDK_INT;
    localgdt_analysis_request.androidBrand = Build.BRAND;
    localgdt_analysis_request.androidManufacturer = Build.MANUFACTURER;
    localgdt_analysis_request.ipType = AdNet.getIpFamily(paramContext);
    localgdt_analysis_request.Model = Build.MODEL;
    localgdt_analysis_request.appVersion = paramString;
    localgdt_analysis_request.osType = 2;
    localgdt_analysis_request.osVersion = Build.VERSION.RELEASE;
    localgdt_analysis_request.body = paramArrayOfgdt_analysis_event;
    return localgdt_analysis_request;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.AdAnalysisUtil
 * JD-Core Version:    0.7.0.1
 */