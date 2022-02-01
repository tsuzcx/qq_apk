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
    return new WSStatisticsReporter.Builder().setPushId(WSInitializeHelper.a().a()).setFlush(true);
  }
  
  public static void a(WSPlayerReportData paramWSPlayerReportData)
  {
    if (paramWSPlayerReportData == null) {
      return;
    }
    HashMap localHashMap = new HashMap(35);
    localHashMap.put("player_type", String.valueOf(paramWSPlayerReportData.jdField_a_of_type_Int));
    localHashMap.put("video_play_scene", paramWSPlayerReportData.jdField_a_of_type_JavaLangString);
    localHashMap.put("video_id", paramWSPlayerReportData.jdField_b_of_type_JavaLangString);
    localHashMap.put("video_format", paramWSPlayerReportData.jdField_c_of_type_JavaLangString);
    localHashMap.put("video_file_size", String.valueOf(paramWSPlayerReportData.jdField_a_of_type_Long));
    localHashMap.put("video_bit_rate", String.valueOf(paramWSPlayerReportData.jdField_b_of_type_Long));
    String str;
    if (paramWSPlayerReportData.jdField_a_of_type_Boolean)
    {
      str = "1";
      localHashMap.put("is_hit_cache", str);
      if (!paramWSPlayerReportData.jdField_b_of_type_Boolean) {
        break label533;
      }
      str = "1";
      label132:
      localHashMap.put("is_pre_download_hit", str);
      localHashMap.put("preload_status", String.valueOf(paramWSPlayerReportData.jdField_d_of_type_Int));
      localHashMap.put("second_buffer_time", String.valueOf(paramWSPlayerReportData.jdField_c_of_type_Long));
      localHashMap.put("second_buffer_count", String.valueOf(paramWSPlayerReportData.jdField_e_of_type_Int));
      localHashMap.put("list_speed_kbs", paramWSPlayerReportData.jdField_d_of_type_JavaLangString);
      localHashMap.put("max_speed_kbs", String.valueOf(paramWSPlayerReportData.jdField_d_of_type_Long));
      localHashMap.put("min_speed_kbs", String.valueOf(paramWSPlayerReportData.jdField_e_of_type_Long));
      localHashMap.put("average_speed_kbs", String.valueOf(paramWSPlayerReportData.jdField_f_of_type_Long));
      localHashMap.put("downloaded_duration", String.valueOf(paramWSPlayerReportData.jdField_g_of_type_Long));
      localHashMap.put("play_time", String.valueOf(paramWSPlayerReportData.jdField_h_of_type_Long));
      localHashMap.put("http_dns_time", String.valueOf(paramWSPlayerReportData.jdField_i_of_type_Long));
      localHashMap.put("http_redirect_time", String.valueOf(paramWSPlayerReportData.j));
      localHashMap.put("http_first_receive_time", String.valueOf(paramWSPlayerReportData.k));
      localHashMap.put("http_connect_time", String.valueOf(paramWSPlayerReportData.l));
      localHashMap.put("mp4_header_time", String.valueOf(paramWSPlayerReportData.m));
      localHashMap.put("cache_frame_time", String.valueOf(paramWSPlayerReportData.n));
      localHashMap.put("video_prepare_time", String.valueOf(paramWSPlayerReportData.o));
      localHashMap.put("http_connect_quality_json", paramWSPlayerReportData.jdField_i_of_type_JavaLangString);
      localHashMap.put("prepare_performance_json", paramWSPlayerReportData.jdField_e_of_type_JavaLangString);
      localHashMap.put("skip_frames_total_count", String.valueOf(paramWSPlayerReportData.jdField_f_of_type_Int));
      localHashMap.put("error_code", paramWSPlayerReportData.jdField_f_of_type_JavaLangString);
      localHashMap.put("error_detail_info", paramWSPlayerReportData.jdField_g_of_type_JavaLangString);
      localHashMap.put("hw_codec_error_code", paramWSPlayerReportData.jdField_h_of_type_JavaLangString);
      if (!paramWSPlayerReportData.jdField_c_of_type_Boolean) {
        break label539;
      }
      str = "1";
      label486:
      localHashMap.put("is_change_hw_backup", str);
      if (!paramWSPlayerReportData.jdField_d_of_type_Boolean) {
        break label545;
      }
    }
    label533:
    label539:
    label545:
    for (paramWSPlayerReportData = "1";; paramWSPlayerReportData = "0")
    {
      localHashMap.put("enable_codec_reuse", paramWSPlayerReportData);
      a(a().addParams(localHashMap));
      return;
      str = "0";
      break;
      str = "0";
      break label132;
      str = "0";
      break label486;
    }
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder)
  {
    paramBuilder.build("gzh_player_performance").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReporter
 * JD-Core Version:    0.7.0.1
 */