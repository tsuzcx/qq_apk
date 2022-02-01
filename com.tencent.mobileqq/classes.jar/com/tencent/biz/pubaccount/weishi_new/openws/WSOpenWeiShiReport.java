package com.tencent.biz.pubaccount.weishi_new.openws;

import UserGrowth.stSimpleMetaFeed;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSReportParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;

public class WSOpenWeiShiReport
{
  @NonNull
  public static WSReportParams a(@Nullable stSimpleMetaFeed paramstSimpleMetaFeed, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    paramString1 = new WSReportParams(paramString1, localHashMap1, localHashMap2);
    if (paramstSimpleMetaFeed == null) {
      return paramString1;
    }
    localHashMap1.put("feed_id", paramstSimpleMetaFeed.id);
    localHashMap1.put("owner_id", paramstSimpleMetaFeed.poster_id);
    localHashMap1.put("global_key", WSRecommendReportManager.a().a(paramstSimpleMetaFeed.traceId));
    localHashMap1.put("feed_pass_key", new Gson().toJson(paramstSimpleMetaFeed.map_ext));
    localHashMap2.put("tab_id", paramString2);
    localHashMap2.put("play_scene", paramString3);
    return paramString1;
  }
  
  private static WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setFlush(true);
  }
  
  public static void a(@Nullable WSReportParams paramWSReportParams)
  {
    if (paramWSReportParams == null) {
      return;
    }
    Map localMap = paramWSReportParams.a();
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("position", "auth_float");
    a().setSopName(paramWSReportParams.a()).addParams((Map)localObject).addExtParams(paramWSReportParams.b()).build("gzh_exposure").report();
  }
  
  public static void b(@Nullable WSReportParams paramWSReportParams)
  {
    if (paramWSReportParams == null) {
      return;
    }
    Map localMap = paramWSReportParams.a();
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("position", "auth_weishi");
    ((Map)localObject).put("action_id", "1000003");
    a().setSopName(paramWSReportParams.a()).addParams((Map)localObject).addExtParams(paramWSReportParams.b()).build("gzh_click").report();
  }
  
  public static void c(@Nullable WSReportParams paramWSReportParams)
  {
    if (paramWSReportParams == null) {
      return;
    }
    Map localMap = paramWSReportParams.a();
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("position", "auth_close");
    ((Map)localObject).put("action_id", "1000001");
    a().setSopName(paramWSReportParams.a()).addParams((Map)localObject).addExtParams(paramWSReportParams.b()).build("gzh_click").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiReport
 * JD-Core Version:    0.7.0.1
 */