package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ARReport$3
  implements Runnable
{
  ARReport$3(ARReport paramARReport, long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString, int paramInt2, long paramLong4, long paramLong5, long paramLong6, int paramInt3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (ARReport.a(this.this$0, this.jdField_a_of_type_Long)) {
      localHashMap.put("cloud_choose_time", String.valueOf(this.jdField_a_of_type_Long));
    }
    if (ARReport.a(this.this$0, this.jdField_b_of_type_Long)) {
      localHashMap.put("cloud_upload_time", String.valueOf(this.jdField_b_of_type_Long));
    }
    if (ARReport.a(this.this$0, this.jdField_c_of_type_Long)) {
      localHashMap.put("cloud_upload_size", String.valueOf(this.jdField_c_of_type_Long));
    }
    if (ARReport.a(this.this$0, this.jdField_a_of_type_Int)) {
      localHashMap.put("cloud_upload_times", String.valueOf(this.jdField_a_of_type_Int));
    }
    if (this.jdField_a_of_type_JavaLangString != null) {
      localHashMap.put("cloud_upload_imgid", this.jdField_a_of_type_JavaLangString);
    }
    if (ARReport.a(this.this$0, this.jdField_b_of_type_Int)) {
      localHashMap.put("cloud_recognize_time", String.valueOf(this.jdField_b_of_type_Int));
    }
    if (ARReport.a(this.this$0, this.d)) {
      localHashMap.put("cloud_all_size", String.valueOf(this.d));
    }
    if (ARReport.a(this.this$0, this.e)) {
      localHashMap.put("cloud_time", String.valueOf(this.e));
    }
    localHashMap.put("cloud_net_type", String.valueOf(NetworkUtil.a(BaseApplication.getContext())));
    if (ARReport.a(this.this$0, this.f)) {
      localHashMap.put("cloud_all_time", String.valueOf(this.f));
    }
    localHashMap.put("cloud_all_result", String.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("cloud_type", "0");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidactARCloud", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.3
 * JD-Core Version:    0.7.0.1
 */