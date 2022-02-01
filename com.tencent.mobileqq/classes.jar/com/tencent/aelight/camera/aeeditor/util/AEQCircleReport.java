package com.tencent.aelight.camera.aeeditor.util;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import java.util.HashMap;

public class AEQCircleReport
{
  private static final AEQCircleReport b = new AEQCircleReport();
  private HashMap<String, Long> a = new HashMap();
  
  public static AEQCircleReport a()
  {
    return b;
  }
  
  public void a(String paramString)
  {
    this.a.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    long l = b(paramString1);
    if (l > 0L)
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pMaterialCostEnd(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), paramString1), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext2(), paramString2), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext3(), String.valueOf(l)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), paramString3) }));
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("reportEnd... cost < 0 id:");
    paramString2.append(paramString1);
    AEQLog.b("AEQCircleReport", paramString2.toString());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    long l = b(paramString1);
    if (l > 0L)
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pMaterialCostEnd(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), paramString1), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext2(), paramString2), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext3(), String.valueOf(l)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext4(), paramString3), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), paramString4) }));
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("reportEnd... cost < 0 id:");
    paramString2.append(paramString1);
    AEQLog.b("AEQCircleReport", paramString2.toString());
  }
  
  public long b(String paramString)
  {
    if (this.a.containsKey(paramString))
    {
      long l = ((Long)this.a.get(paramString)).longValue();
      l = System.currentTimeMillis() - l;
      if (l < 0L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("endKey... cost < 0 id:");
        localStringBuilder.append(paramString);
        AEQLog.b("AEQCircleReport", localStringBuilder.toString());
        return -1L;
      }
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("endKey... clickTimesMap not contain id:");
    localStringBuilder.append(paramString);
    AEQLog.b("AEQCircleReport", localStringBuilder.toString());
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.util.AEQCircleReport
 * JD-Core Version:    0.7.0.1
 */