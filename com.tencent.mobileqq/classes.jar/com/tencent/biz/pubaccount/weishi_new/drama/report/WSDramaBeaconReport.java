package com.tencent.biz.pubaccount.weishi_new.drama.report;

import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryData;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WSDramaBeaconReport
{
  private static final Set<String> a = new HashSet();
  
  private static WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setSopName("drama_preview").setTestId(WeishiUtils.a(10012)).setPushId(WSInitializeHelper.a().f()).setFlush(true);
  }
  
  private static WSStatisticsReporter.Builder a(String paramString1, String paramString2, String paramString3)
  {
    return a().addParams("position", paramString1).addParams("feed_id", paramString2).addParams("owner_id", paramString3);
  }
  
  private static WSStatisticsReporter.Builder a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return a().addParams("position", paramString1).addParams("feed_id", paramString2).addParams("owner_id", paramString3).addParams("action_id", String.valueOf(paramInt));
  }
  
  public static void a(int paramInt, WSDramaVideoPlayReportParams paramWSDramaVideoPlayReportParams)
  {
    Object localObject = paramWSDramaVideoPlayReportParams.b();
    if (localObject != null)
    {
      WSVideoInfo localWSVideoInfo = ((WSPlayerParam)localObject).c;
      if (localWSVideoInfo == null) {
        return;
      }
      if (WSVerticalUtils.a(a, paramInt, localWSVideoInfo)) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("event_type", String.valueOf(paramInt));
      localHashMap.put("feed_id", localWSVideoInfo.a);
      localHashMap.put("owner_id", localWSVideoInfo.j);
      localHashMap.put("video_length", String.valueOf(localWSVideoInfo.d));
      localHashMap.put("recommend_id", "");
      if (paramInt == 2)
      {
        localObject = ((WSPlayerParam)localObject).d;
        long l2 = 0L;
        long l1;
        if (localObject != null) {
          l1 = ((WSPlayerWrapper)localObject).m();
        } else {
          l1 = 0L;
        }
        if (localObject != null) {
          l2 = ((WSPlayerWrapper)localObject).c(paramWSDramaVideoPlayReportParams.c());
        }
        localHashMap.put("duration", String.valueOf(l2));
        localHashMap.put("last_location", String.valueOf(l1));
      }
      localObject = new HashMap();
      ((Map)localObject).put("micro_drama_id", paramWSDramaVideoPlayReportParams.d());
      ((Map)localObject).put("micro_drama_num", String.valueOf(paramWSDramaVideoPlayReportParams.e()));
      ((Map)localObject).put("play_scene", c(paramWSDramaVideoPlayReportParams.a()));
      ((Map)localObject).put("poolType", String.valueOf(localWSVideoInfo.h));
      if (paramInt == 1)
      {
        if (paramWSDramaVideoPlayReportParams.f()) {
          paramWSDramaVideoPlayReportParams = "0";
        } else {
          paramWSDramaVideoPlayReportParams = "1";
        }
        ((Map)localObject).put("play_type", paramWSDramaVideoPlayReportParams);
      }
      a(a().addParams(localHashMap).addExtParams((Map)localObject), "gzh_video_play");
    }
  }
  
  public static void a(WSDramaItemData paramWSDramaItemData, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramWSDramaItemData == null) {
      return;
    }
    Object localObject = WSDramaDataManager.a().c();
    int i = 0;
    String str;
    if (localObject != null)
    {
      str = ((WSDramaItemData)localObject).b();
      i = ((WSDramaItemData)localObject).l();
    }
    else
    {
      str = "";
    }
    localObject = new HashMap();
    ((Map)localObject).put("micro_drama_id", str);
    ((Map)localObject).put("micro_drama_num", String.valueOf(i));
    ((Map)localObject).put("cover_drama_id", paramWSDramaItemData.b());
    ((Map)localObject).put("cover_drama_num", String.valueOf(paramWSDramaItemData.k()));
    ((Map)localObject).put("play_scene", c(paramString));
    ((Map)localObject).put("play_type", String.valueOf(paramInt2));
    if (paramBoolean) {
      paramString = "2";
    } else {
      paramString = "1";
    }
    ((Map)localObject).put("click_num", paramString);
    paramString = new StringBuilder();
    paramString.append("drama_list_video");
    paramString.append(paramInt1 + 1);
    a(a(paramString.toString(), paramWSDramaItemData.d(), paramWSDramaItemData.e(), 1000001).addExtParams((Map)localObject), "gzh_click");
  }
  
  public static void a(WSDramaItemData paramWSDramaItemData, int paramInt, String paramString)
  {
    if (paramWSDramaItemData == null) {
      return;
    }
    Object localObject = WSDramaDataManager.a().c();
    int i = 0;
    String str;
    if (localObject != null)
    {
      str = ((WSDramaItemData)localObject).b();
      i = ((WSDramaItemData)localObject).l();
    }
    else
    {
      str = "";
    }
    localObject = new HashMap();
    ((Map)localObject).put("micro_drama_id", str);
    ((Map)localObject).put("micro_drama_num", String.valueOf(i));
    ((Map)localObject).put("cover_drama_id", paramWSDramaItemData.b());
    ((Map)localObject).put("cover_drama_num", String.valueOf(paramWSDramaItemData.k()));
    ((Map)localObject).put("play_scene", c(paramString));
    paramString = new StringBuilder();
    paramString.append("drama_list_video");
    paramString.append(paramInt + 1);
    a(a(paramString.toString(), paramWSDramaItemData.d(), paramWSDramaItemData.e()).addExtParams((Map)localObject), "gzh_exposure");
  }
  
  public static void a(WSEpisodeItemData paramWSEpisodeItemData, int paramInt, long paramLong, String paramString)
  {
    if (paramWSEpisodeItemData == null) {
      return;
    }
    Object localObject = WSDramaDataManager.a().c();
    String str2 = "";
    String str1;
    int i;
    if (localObject != null)
    {
      str2 = ((WSDramaItemData)localObject).b();
      str1 = ((WSDramaItemData)localObject).e();
      i = ((WSDramaItemData)localObject).l();
    }
    else
    {
      str1 = "";
      i = 0;
    }
    localObject = new HashMap();
    ((Map)localObject).put("micro_drama_id", str2);
    ((Map)localObject).put("micro_drama_num", String.valueOf(i));
    ((Map)localObject).put("play_scene", c(paramString));
    ((Map)localObject).put("max_drama_num", String.valueOf(paramInt));
    ((Map)localObject).put("max_drama_times", String.valueOf(paramLong));
    a(a("drama_list_btn", paramWSEpisodeItemData.b(), str1).addExtParams((Map)localObject), "gzh_exposure");
  }
  
  public static void a(WSEpisodeItemData paramWSEpisodeItemData, int paramInt, String paramString)
  {
    if (paramWSEpisodeItemData == null) {
      return;
    }
    Object localObject = WSDramaDataManager.a().c();
    int i = 0;
    String str;
    if (localObject != null)
    {
      str = ((WSDramaItemData)localObject).b();
      i = ((WSDramaItemData)localObject).c();
    }
    else
    {
      str = "";
    }
    localObject = new HashMap();
    ((Map)localObject).put("micro_drama_id", str);
    ((Map)localObject).put("micro_drama_num", String.valueOf(i));
    ((Map)localObject).put("play_scene", c(paramString));
    ((Map)localObject).put("play_type", String.valueOf(paramInt));
    ((Map)localObject).put("num", String.valueOf(paramWSEpisodeItemData.c()));
    a(a("drama_list_btn", paramWSEpisodeItemData.b(), paramWSEpisodeItemData.d(), 1000001).addExtParams((Map)localObject), "gzh_click");
  }
  
  public static void a(WSDramaVideoPlayReportParams paramWSDramaVideoPlayReportParams)
  {
    a(1, paramWSDramaVideoPlayReportParams);
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("play_scene", c(paramString));
    WSPublicAccReport.getInstance().reportPageVisitEnter("drama_preview", localHashMap);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, WSDramaHistoryData paramWSDramaHistoryData, String paramString4, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("drama_more_drama");
    localStringBuilder.append(paramInt2 + 1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("micro_drama_id", paramString3);
    localHashMap.put("micro_drama_num", String.valueOf(paramInt1));
    localHashMap.put("play_scene", c(paramString4));
    localHashMap.put("cover_drama_id", paramWSDramaHistoryData.b());
    localHashMap.put("cover_drama_num", String.valueOf(paramWSDramaHistoryData.d()));
    boolean bool = paramWSDramaHistoryData.a();
    paramString4 = "1";
    if (bool) {
      paramString3 = "1";
    } else {
      paramString3 = "0";
    }
    localHashMap.put("is_play", paramString3);
    paramString3 = paramString4;
    if (paramWSDramaHistoryData.e()) {
      paramString3 = "0";
    }
    localHashMap.put("is_update", paramString3);
    localHashMap.put("update_num", String.valueOf(paramWSDramaHistoryData.d()));
    localHashMap.put("play_num", String.valueOf(paramWSDramaHistoryData.f()));
    a(a(localStringBuilder.toString(), paramString1, paramString2, 1000001).addExtParams(localHashMap), "gzh_click");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramInt, "drama_videoplay_video", paramString4);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("micro_drama_id", paramString3);
    localHashMap.put("micro_drama_num", String.valueOf(paramInt1));
    localHashMap.put("play_scene", c(paramString4));
    localHashMap.put("poolType", String.valueOf(paramInt2));
    a(a("drama_videoplay_video", paramString1, paramString2).addExtParams(localHashMap), "gzh_exposure");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("micro_drama_id", paramString3);
    localHashMap.put("micro_drama_num", String.valueOf(paramInt1));
    localHashMap.put("status", String.valueOf(paramInt2));
    localHashMap.put("data_status", String.valueOf(paramInt3));
    localHashMap.put("play_scene", c(paramString4));
    a(a("drama_more", paramString1, paramString2, 1000001).addExtParams(localHashMap), "gzh_click");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("micro_drama_id", paramString3);
    localHashMap.put("micro_drama_num", String.valueOf(paramInt));
    localHashMap.put("play_scene", c(paramString5));
    a(a(paramString4, paramString1, paramString2, 1000001).addExtParams(localHashMap), "gzh_click");
  }
  
  public static void b(WSDramaVideoPlayReportParams paramWSDramaVideoPlayReportParams)
  {
    a(2, paramWSDramaVideoPlayReportParams);
  }
  
  public static void b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("play_scene", c(paramString));
    WSPublicAccReport.getInstance().reportPageVisitExit("drama_preview", localHashMap);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt1, WSDramaHistoryData paramWSDramaHistoryData, String paramString4, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("drama_more_drama");
    localStringBuilder.append(paramInt2 + 1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("micro_drama_id", paramString3);
    localHashMap.put("micro_drama_num", String.valueOf(paramInt1));
    localHashMap.put("play_scene", c(paramString4));
    localHashMap.put("cover_drama_id", paramWSDramaHistoryData.b());
    localHashMap.put("cover_drama_num", String.valueOf(paramWSDramaHistoryData.d()));
    boolean bool = paramWSDramaHistoryData.a();
    paramString4 = "1";
    if (bool) {
      paramString3 = "1";
    } else {
      paramString3 = "0";
    }
    localHashMap.put("is_play", paramString3);
    paramString3 = paramString4;
    if (paramWSDramaHistoryData.e()) {
      paramString3 = "0";
    }
    localHashMap.put("is_update", paramString3);
    localHashMap.put("update_num", String.valueOf(paramWSDramaHistoryData.d()));
    localHashMap.put("play_num", String.valueOf(paramWSDramaHistoryData.f()));
    a(a(localStringBuilder.toString(), paramString1, paramString2).addExtParams(localHashMap), "gzh_exposure");
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramInt, "drama_fullscreen", paramString4);
  }
  
  private static String c(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1282366045)
    {
      if (i != -763476863)
      {
        if ((i == 836791522) && (paramString.equals("grid_drama_follow")))
        {
          i = 2;
          break label76;
        }
      }
      else if (paramString.equals("grid_drama_card"))
      {
        i = 0;
        break label76;
      }
    }
    else if (paramString.equals("aio_red_dot"))
    {
      i = 1;
      break label76;
    }
    i = -1;
    label76:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return "";
        }
        return "feeds_history";
      }
      return "direct";
    }
    return "feeds";
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("micro_drama_id", paramString3);
    localHashMap.put("micro_drama_num", String.valueOf(paramInt));
    localHashMap.put("play_scene", c(paramString4));
    a(a("drama_close", paramString1, paramString2, 1000001).addExtParams(localHashMap), "gzh_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport
 * JD-Core Version:    0.7.0.1
 */