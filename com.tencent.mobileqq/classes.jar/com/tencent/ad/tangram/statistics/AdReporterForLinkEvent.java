package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.analysis.AdABTest;
import com.tencent.ad.tangram.analysis.AdUin;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForLinkEventReporter;
import com.tencent.ad.tangram.protocol.link_report.LinkReport;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportBiz;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportEvent;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportExt;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.version.AdVersion;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
public final class AdReporterForLinkEvent
{
  public static final String TAG = "AdReporterForLinkEvent";
  
  protected static JSONObject buildParams(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        link_report.LinkReport localLinkReport = new link_report.LinkReport();
        localLinkReport.av = AdVersion.INSTANCE.getAppVersion();
        localLinkReport.ct = AdNet.getType(paramContext);
        localLinkReport.os = 2;
        localLinkReport.ov = Build.VERSION.RELEASE;
        if ((paramContext == null) || (paramContext.getApplicationContext() == null)) {
          break label110;
        }
        paramContext = paramContext.getApplicationContext().getPackageName();
        localLinkReport.pkg = paramContext;
        localLinkReport.sdk_st = 9;
        paramContext = AdJSON.fromObject(localLinkReport);
        if ((paramContext instanceof JSONObject))
        {
          paramContext = (JSONObject)paramContext;
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        AdLog.e("AdReporterForLinkEvent", paramContext.getMessage());
      }
      return localJSONObject;
      label110:
      paramContext = "";
    }
  }
  
  public static void reportAsync(Context paramContext, int paramInt, Ad paramAd, link_report.LinkReport.ReportBiz paramReportBiz, link_report.LinkReport.ReportExt paramReportExt)
  {
    link_report.LinkReport.ReportBiz localReportBiz = paramReportBiz;
    if (paramAd != null)
    {
      localReportBiz = paramReportBiz;
      if (paramReportBiz == null) {
        localReportBiz = new link_report.LinkReport.ReportBiz();
      }
      localReportBiz.aid = String.valueOf(paramAd.getAId());
      localReportBiz.pid = paramAd.getPosId();
      localReportBiz.traceid = paramAd.getTraceId();
    }
    reportAsync(paramContext, paramInt, localReportBiz, paramReportExt);
  }
  
  private static void reportAsync(Context paramContext, int paramInt, link_report.LinkReport.ReportBiz paramReportBiz, link_report.LinkReport.ReportExt paramReportExt)
  {
    Object localObject1 = AdSettingsManager.INSTANCE.getCache();
    if ((localObject1 != null) && (((gdt_settings.Settings)localObject1).settingsForLinkEventReporter != null))
    {
      if (!AdABTest.isABTestByUIN(AdUin.INSTANCE.getUIN(), ((gdt_settings.Settings)localObject1).settingsForLinkEventReporter.abTest)) {
        return;
      }
      localObject1 = buildParams(paramContext);
      try
      {
        Object localObject2 = new link_report.LinkReport.ReportEvent();
        ((link_report.LinkReport.ReportEvent)localObject2).seq = 1;
        ((link_report.LinkReport.ReportEvent)localObject2).ts = System.currentTimeMillis();
        ((link_report.LinkReport.ReportEvent)localObject2).ei = paramInt;
        paramContext = new JSONObject();
        localObject2 = AdJSON.fromObject(localObject2);
        if ((localObject2 instanceof JSONObject)) {
          paramContext = (JSONObject)localObject2;
        }
        paramContext.put("biz", AdJSON.fromObject(paramReportBiz));
        paramContext.put("ext", AdJSON.fromObject(paramReportExt));
        paramReportBiz = new JSONArray();
        paramReportBiz.put(paramContext);
        ((JSONObject)localObject1).put("events", paramReportBiz);
      }
      catch (Throwable paramContext)
      {
        AdLog.e("AdReporterForLinkEvent", "reportAsync buildParams", paramContext);
      }
      paramContext = new StringBuilder();
      paramContext.append("reportAsync ");
      paramContext.append(((JSONObject)localObject1).toString());
      AdLog.i("AdReporterForLinkEvent", paramContext.toString());
      reportAsync((JSONObject)localObject1);
      return;
    }
    AdLog.d("AdReporterForLinkEvent", "invalid settingsForLinkEventReporter");
  }
  
  private static void reportAsync(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      if (paramJSONObject.length() <= 0) {
        return;
      }
      byte[] arrayOfByte = paramJSONObject.toString().getBytes();
      AdThreadManager.INSTANCE.post(new AdReporterForLinkEvent.1(arrayOfByte, paramJSONObject), 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdReporterForLinkEvent
 * JD-Core Version:    0.7.0.1
 */