package com.tencent.biz.pubaccount.weishi_new.verticalvideo.report;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.HashMap;
import java.util.Map;

public class WSArkBeaconReport
{
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = new WSStatisticsReporter.Builder().setSopName("chat_page").setTestId(WeishiUtils.a(10007)).setPushId("").setFlush(true).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("content", paramInt, paramstSimpleMetaFeed)).setOperationId("");
    HashMap localHashMap = new HashMap();
    localHashMap.put("qq_group_num", paramString);
    localHashMap.put("card_type", "1");
    paramstSimpleMetaFeed.addExtParams(localHashMap);
    a(paramstSimpleMetaFeed, "gzh_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSArkBeaconReport
 * JD-Core Version:    0.7.0.1
 */