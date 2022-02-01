package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class GdtImpressionReporter
{
  private static int a(int paramInt)
  {
    if (paramInt == 7) {
      return 7;
    }
    return 0;
  }
  
  private static String a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong1);
        localStringBuilder.append("");
        ((JSONObject)localObject).put("bt", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("");
        ((JSONObject)localObject).put("et", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        int j = 0;
        if (paramLong1 > 0L)
        {
          i = 0;
          localStringBuilder.append(i);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("bf", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          i = j;
          if (paramBoolean) {
            i = 1;
          }
          localStringBuilder.append(i);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("ef", localStringBuilder.toString());
          ((JSONObject)localObject).put("pp", String.valueOf(a(paramInt)));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramGdtVideoReportInfo.a());
          localStringBuilder.append("");
          ((JSONObject)localObject).put("pa", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramGdtVideoReportInfo.b());
          localStringBuilder.append("");
          ((JSONObject)localObject).put("ft", localStringBuilder.toString());
          if (paramGdtVideoReportInfo.a()) {
            ((JSONObject)localObject).put("ps", String.valueOf(paramGdtVideoReportInfo.c()));
          }
          paramGdtVideoReportInfo = ((JSONObject)localObject).toString();
          return paramGdtVideoReportInfo;
        }
      }
      catch (JSONException paramGdtVideoReportInfo)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("json exception: ");
        ((StringBuilder)localObject).append(paramGdtVideoReportInfo.getMessage());
        QLog.e("GdtVideoStatisticsReport", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      int i = 1;
    }
  }
  
  public static void a(GdtAd paramGdtAd, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt, GdtImpressionReporter.GdtVideoReportInfo paramGdtVideoReportInfo)
  {
    paramGdtVideoReportInfo = a(paramLong1, paramLong2, paramBoolean, paramInt, paramGdtVideoReportInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report: ");
    localStringBuilder.append(paramGdtVideoReportInfo);
    QLog.i("GdtVideoStatisticsReport", 1, localStringBuilder.toString());
    a(paramGdtAd, paramGdtVideoReportInfo);
  }
  
  private static void a(GdtAd paramGdtAd, String paramString)
  {
    if (paramGdtAd != null)
    {
      if (TextUtils.isEmpty(paramGdtAd.getUrlForImpression())) {
        return;
      }
      a(paramGdtAd.getUrlForImpression(), paramString);
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&");
      localStringBuilder.append("video");
      localStringBuilder.append("=");
      localStringBuilder.append(URLEncoder.encode(paramString2));
      paramString1 = localStringBuilder.toString();
    }
    GdtReporter.doCgiReport(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtImpressionReporter
 * JD-Core Version:    0.7.0.1
 */