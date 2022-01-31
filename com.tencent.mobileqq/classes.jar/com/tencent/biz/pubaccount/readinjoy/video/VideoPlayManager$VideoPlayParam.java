package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo;

public class VideoPlayManager$VideoPlayParam
{
  public int a;
  public long a;
  public View a;
  public BaseArticleInfo a;
  public ReadinjoyVideoReportData a;
  public VideoViewGroup a;
  public TVK_NetVideoInfo.DefnInfo a;
  public String a;
  boolean a;
  public int b;
  public long b;
  public View b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d = -1;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public String l;
  public String m;
  
  public VideoPlayManager$VideoPlayParam()
  {
    this.jdField_f_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoPlayParam[");
    localStringBuilder.append(" articleID:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", videoVid:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", busitype:").append(this.e);
    localStringBuilder.append(", videoDuration:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", position:").append(this.jdField_f_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
      localStringBuilder.append(", title:").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam
 * JD-Core Version:    0.7.0.1
 */