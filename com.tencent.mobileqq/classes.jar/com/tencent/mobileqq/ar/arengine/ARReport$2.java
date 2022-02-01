package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ARReport$2
  implements Runnable
{
  ARReport$2(ARReport paramARReport, String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int paramInt2, long paramLong5, int paramInt3, long paramLong6, long paramLong7, int paramInt4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {
      localHashMap.put("cloud_download_imgId", String.valueOf(str));
    }
    long l = this.jdField_a_of_type_Long;
    if (l > 0L) {
      localHashMap.put("cloud_download_feature_size", String.valueOf(l));
    }
    if (ARReport.a(this.this$0, this.jdField_b_of_type_Long)) {
      localHashMap.put("cloud_download_feature_time", String.valueOf(this.jdField_b_of_type_Long));
    }
    int i = this.jdField_a_of_type_Int;
    if (i > -1) {
      localHashMap.put("cloud_download_feature_code", String.valueOf(i));
    }
    l = this.jdField_c_of_type_Long;
    if (l > 0L) {
      localHashMap.put("cloud_download_model_size", String.valueOf(l));
    }
    if (ARReport.a(this.this$0, this.jdField_d_of_type_Long)) {
      localHashMap.put("cloud_download_model_time", String.valueOf(this.jdField_d_of_type_Long));
    }
    i = this.jdField_b_of_type_Int;
    if (i > -1) {
      localHashMap.put("cloud_download_model_code", String.valueOf(i));
    }
    l = this.e;
    if (l > 0L) {
      localHashMap.put("cloud_download_unzip_time", String.valueOf(l));
    }
    i = this.jdField_c_of_type_Int;
    if (i > -1) {
      localHashMap.put("cloud_download_type", String.valueOf(i));
    }
    localHashMap.put("cloud_download_net_type", String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext())));
    if (ARReport.a(this.this$0, this.f)) {
      localHashMap.put("cloud_download_all_time", String.valueOf(this.f));
    }
    l = this.g;
    if (l > 0L) {
      localHashMap.put("cloud_download_net_size", String.valueOf(l));
    }
    i = this.jdField_d_of_type_Int;
    if (i > -1) {
      localHashMap.put("cloud_download_all_result", String.valueOf(i));
    }
    localHashMap.put("cloud_download_type", "0");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidactARCloudDownLoad", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.2
 * JD-Core Version:    0.7.0.1
 */