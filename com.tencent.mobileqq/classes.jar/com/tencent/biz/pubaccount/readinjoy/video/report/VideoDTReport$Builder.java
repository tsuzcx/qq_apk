package com.tencent.biz.pubaccount.readinjoy.video.report;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtConstant;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import java.util.HashMap;

public class VideoDTReport$Builder
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private int g = -1;
  
  public static Builder a(VideoInfo paramVideoInfo)
  {
    Builder localBuilder = new Builder();
    if (paramVideoInfo == null) {
      return localBuilder;
    }
    localBuilder.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localBuilder.jdField_d_of_type_JavaLangString = paramVideoInfo.j;
    localBuilder.jdField_a_of_type_Long = 409409L;
    localBuilder.jdField_c_of_type_Int = VideoDTReport.a(paramVideoInfo.w);
    localBuilder.jdField_c_of_type_JavaLangString = paramVideoInfo.g;
    localBuilder.jdField_b_of_type_Int = paramVideoInfo.c();
    localBuilder.jdField_a_of_type_Int = paramVideoInfo.b();
    localBuilder.jdField_f_of_type_JavaLangString = paramVideoInfo.w;
    return localBuilder;
  }
  
  public static Builder a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    Builder localBuilder = new Builder();
    if (paramVideoPlayParam == null) {}
    do
    {
      return localBuilder;
      localBuilder.jdField_d_of_type_JavaLangString = paramVideoPlayParam.k;
      localBuilder.jdField_b_of_type_JavaLangString = paramVideoPlayParam.jdField_c_of_type_JavaLangString;
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
      {
        localBuilder.jdField_a_of_type_Long = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;
        localBuilder.jdField_c_of_type_Int = VideoDTReport.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
        localBuilder.jdField_f_of_type_JavaLangString = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo;
      }
    } while (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null);
    localBuilder.jdField_c_of_type_JavaLangString = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_JavaLangString;
    localBuilder.jdField_b_of_type_Int = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.l;
    localBuilder.jdField_a_of_type_Int = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.k;
    return localBuilder;
  }
  
  private boolean a()
  {
    return (this.jdField_f_of_type_JavaLangString != null) || (this.g > 0);
  }
  
  public Builder a(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_d_of_type_Int = i;
      return this;
    }
  }
  
  public HashMap<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", RIJDtConstant.jdField_a_of_type_JavaLangString);
    localHashMap.put("dt_pgid", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("channel_id", Long.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("rowkey", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("cid", "");
    localHashMap.put("cmsid", "");
    localHashMap.put("puin", this.jdField_d_of_type_JavaLangString);
    localHashMap.put("video_height", Integer.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("video_width", Integer.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("is_short", Integer.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("play_sessionid", this.jdField_e_of_type_JavaLangString);
    localHashMap.put("play_type", Integer.valueOf(this.jdField_d_of_type_Int));
    localHashMap.put("play_loop_type", Integer.valueOf(this.jdField_e_of_type_Int));
    localHashMap.put("backend_info", this.jdField_f_of_type_JavaLangString);
    return localHashMap;
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder f(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.report.VideoDTReport.Builder
 * JD-Core Version:    0.7.0.1
 */