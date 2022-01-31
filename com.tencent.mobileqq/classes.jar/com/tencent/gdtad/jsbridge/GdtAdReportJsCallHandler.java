package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.statistics.GdtTraceReporter;
import org.json.JSONObject;

public class GdtAdReportJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    try
    {
      paramGdtAdWebPlugin = new JSONObject(paramVarArgs[0]);
      if (paramGdtAdWebPlugin.getInt("reportType") == 1) {
        GdtTraceReporter.a(paramGdtAdWebPlugin.getInt("convType"), paramGdtAdWebPlugin.getString("traceId"), paramGdtAdWebPlugin.getString("productId"));
      }
      return true;
    }
    catch (Exception paramGdtAdWebPlugin)
    {
      paramGdtAdWebPlugin.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtAdReportJsCallHandler
 * JD-Core Version:    0.7.0.1
 */