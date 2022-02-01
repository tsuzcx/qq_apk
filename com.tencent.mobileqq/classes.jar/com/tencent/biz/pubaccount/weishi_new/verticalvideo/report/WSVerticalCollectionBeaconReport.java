package com.tencent.biz.pubaccount.weishi_new.verticalvideo.report;

import UserGrowth.stSimpleMetaFeed;
import java.util.Map;

public class WSVerticalCollectionBeaconReport
{
  public static void a(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "collection_list_follow", paramstSimpleMetaFeed, paramInt, paramMap);
  }
  
  public static void a(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "collection_list", paramstSimpleMetaFeed, paramMap);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, Map<String, String> paramMap)
  {
    WSVerticalBeaconReport.a(paramString1, paramString2, paramString3, paramstSimpleMetaFeed, paramInt, "", paramMap);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    WSVerticalBeaconReport.a(paramString1, paramString2, paramString3, paramstSimpleMetaFeed, "", paramMap);
  }
  
  public static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "collection_list_close", paramstSimpleMetaFeed, 1000001, paramMap);
  }
  
  public static void c(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "collection_list_close", paramstSimpleMetaFeed, 1000001, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalCollectionBeaconReport
 * JD-Core Version:    0.7.0.1
 */