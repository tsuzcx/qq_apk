package com.tencent.biz.pubaccount.weishi_new.player.report;

import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import java.util.HashMap;
import java.util.Map;

public class WSPlayerReporter
{
  private static WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setPushId(WSInitializeHelper.a().f()).setFlush(true);
  }
  
  public static void a(WSPlayerReportData paramWSPlayerReportData)
  {
    if (paramWSPlayerReportData == null) {
      return;
    }
    HashMap localHashMap = new HashMap(35);
    localHashMap.put("player_type", String.valueOf(paramWSPlayerReportData.a));
    localHashMap.put("video_play_scene", paramWSPlayerReportData.b);
    localHashMap.put("video_id", paramWSPlayerReportData.c);
    localHashMap.put("video_format", paramWSPlayerReportData.d);
    localHashMap.put("video_file_size", String.valueOf(paramWSPlayerReportData.e));
    localHashMap.put("video_bit_rate", String.valueOf(paramWSPlayerReportData.h));
    boolean bool = paramWSPlayerReportData.i;
    String str2 = "1";
    String str1;
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("is_hit_cache", str1);
    if (paramWSPlayerReportData.j) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("is_pre_download_hit", str1);
    localHashMap.put("preload_status", String.valueOf(paramWSPlayerReportData.k));
    localHashMap.put("second_buffer_time", String.valueOf(paramWSPlayerReportData.l));
    localHashMap.put("second_buffer_count", String.valueOf(paramWSPlayerReportData.m));
    localHashMap.put("list_speed_kbs", paramWSPlayerReportData.n);
    localHashMap.put("max_speed_kbs", String.valueOf(paramWSPlayerReportData.o));
    localHashMap.put("min_speed_kbs", String.valueOf(paramWSPlayerReportData.p));
    localHashMap.put("average_speed_kbs", String.valueOf(paramWSPlayerReportData.q));
    localHashMap.put("downloaded_duration", String.valueOf(paramWSPlayerReportData.r));
    localHashMap.put("play_time", String.valueOf(paramWSPlayerReportData.s));
    localHashMap.put("http_dns_time", String.valueOf(paramWSPlayerReportData.t));
    localHashMap.put("http_redirect_time", String.valueOf(paramWSPlayerReportData.u));
    localHashMap.put("http_first_receive_time", String.valueOf(paramWSPlayerReportData.v));
    localHashMap.put("http_connect_time", String.valueOf(paramWSPlayerReportData.w));
    localHashMap.put("mp4_header_time", String.valueOf(paramWSPlayerReportData.x));
    localHashMap.put("cache_frame_time", String.valueOf(paramWSPlayerReportData.y));
    localHashMap.put("video_prepare_time", String.valueOf(paramWSPlayerReportData.z));
    localHashMap.put("http_connect_quality_json", paramWSPlayerReportData.H);
    localHashMap.put("prepare_performance_json", paramWSPlayerReportData.A);
    localHashMap.put("skip_frames_total_count", String.valueOf(paramWSPlayerReportData.B));
    localHashMap.put("error_code", paramWSPlayerReportData.C);
    localHashMap.put("error_detail_info", paramWSPlayerReportData.D);
    localHashMap.put("hw_codec_error_code", paramWSPlayerReportData.E);
    if (paramWSPlayerReportData.F) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("is_change_hw_backup", str1);
    if (paramWSPlayerReportData.G) {
      paramWSPlayerReportData = str2;
    } else {
      paramWSPlayerReportData = "0";
    }
    localHashMap.put("enable_codec_reuse", paramWSPlayerReportData);
    a(a().addParams(localHashMap));
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder)
  {
    paramBuilder.build("gzh_player_performance").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReporter
 * JD-Core Version:    0.7.0.1
 */