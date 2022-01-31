package com.tencent.biz.pubaccount.readinjoy.struct;

import java.util.HashMap;

public class ReadinjoyVideoReportData
{
  public float a;
  public int a;
  public long a;
  public Long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public boolean d;
  public int e;
  public long e;
  public int f;
  public long f;
  public int g;
  public long g;
  public int h;
  public long h;
  public int i;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n = -1L;
  public long o;
  public long p;
  public long q;
  public long r;
  public long s;
  
  public ReadinjoyVideoReportData()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_f_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
  }
  
  public HashMap a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_articleID", String.valueOf(this.jdField_a_of_type_JavaLangLong));
    localHashMap.put("param_vid", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_busiType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_success", String.valueOf(this.jdField_a_of_type_Boolean).toLowerCase());
    localHashMap.put("param_playDuration", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_prepareDuration", String.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("param_bufferTime", String.valueOf(this.jdField_e_of_type_Long));
    localHashMap.put("param_errCode", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_playCompleteRate", String.valueOf(this.jdField_a_of_type_Float));
    localHashMap.put("param_bufferCount", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_sceneType", String.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("param_httpDNSTime", String.valueOf(this.jdField_f_of_type_Long));
    localHashMap.put("param_httpRedirectTime", String.valueOf(this.jdField_g_of_type_Long));
    localHashMap.put("param_cacheFrameTime", String.valueOf(this.jdField_h_of_type_Long));
    localHashMap.put("param_vid2UrlTime", String.valueOf(this.jdField_i_of_type_Long));
    localHashMap.put("param_firstRecvTime", String.valueOf(this.j));
    localHashMap.put("param_mp4HeaderTime", String.valueOf(this.k));
    localHashMap.put("param_httpConnectTime", String.valueOf(this.l));
    localHashMap.put("param_secondBufferTime", String.valueOf(this.m));
    localHashMap.put("param_secondBufferCount", String.valueOf(this.jdField_d_of_type_Int));
    localHashMap.put("param_videoFormat", String.valueOf(this.jdField_e_of_type_Int));
    localHashMap.put("param_isHitCache", String.valueOf(this.jdField_c_of_type_Boolean));
    localHashMap.put("param_errDetailInfo", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("param_scrollInterval", String.valueOf(this.n));
    localHashMap.put("param_jumpFromScene", String.valueOf(this.jdField_f_of_type_Int));
    localHashMap.put("param_index", String.valueOf(this.jdField_g_of_type_Int));
    localHashMap.put("param_videoBitRate", String.valueOf(this.o));
    localHashMap.put("param_fileSize", String.valueOf(this.p));
    localHashMap.put("param_averageSpeedKBS", String.valueOf(this.q));
    localHashMap.put("param_downloadedDuration", String.valueOf(this.r));
    localHashMap.put("param_width", String.valueOf(this.jdField_h_of_type_Int));
    localHashMap.put("param_height", String.valueOf(this.jdField_i_of_type_Int));
    localHashMap.put("param_totalDuration", String.valueOf(this.s));
    localHashMap.put("param_videoCodeFormat", String.valueOf(this.jdField_d_of_type_Boolean));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData
 * JD-Core Version:    0.7.0.1
 */