package com.tencent.mobileqq.ar.arengine;

import apcf;
import bctj;
import bgnt;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$2
  implements Runnable
{
  public ARReport$2(apcf paramapcf, String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int paramInt2, long paramLong5, int paramInt3, long paramLong6, long paramLong7, int paramInt4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_JavaLangString != null) {
      localHashMap.put("cloud_download_imgId", String.valueOf(this.jdField_a_of_type_JavaLangString));
    }
    if (this.jdField_a_of_type_Long > 0L) {
      localHashMap.put("cloud_download_feature_size", String.valueOf(this.jdField_a_of_type_Long));
    }
    if (apcf.a(this.this$0, this.jdField_b_of_type_Long)) {
      localHashMap.put("cloud_download_feature_time", String.valueOf(this.jdField_b_of_type_Long));
    }
    if (this.jdField_a_of_type_Int > -1) {
      localHashMap.put("cloud_download_feature_code", String.valueOf(this.jdField_a_of_type_Int));
    }
    if (this.jdField_c_of_type_Long > 0L) {
      localHashMap.put("cloud_download_model_size", String.valueOf(this.jdField_c_of_type_Long));
    }
    if (apcf.a(this.this$0, this.jdField_d_of_type_Long)) {
      localHashMap.put("cloud_download_model_time", String.valueOf(this.jdField_d_of_type_Long));
    }
    if (this.jdField_b_of_type_Int > -1) {
      localHashMap.put("cloud_download_model_code", String.valueOf(this.jdField_b_of_type_Int));
    }
    if (this.e > 0L) {
      localHashMap.put("cloud_download_unzip_time", String.valueOf(this.e));
    }
    if (this.jdField_c_of_type_Int > -1) {
      localHashMap.put("cloud_download_type", String.valueOf(this.jdField_c_of_type_Int));
    }
    localHashMap.put("cloud_download_net_type", String.valueOf(bgnt.a(BaseApplication.getContext())));
    if (apcf.a(this.this$0, this.f)) {
      localHashMap.put("cloud_download_all_time", String.valueOf(this.f));
    }
    if (this.g > 0L) {
      localHashMap.put("cloud_download_net_size", String.valueOf(this.g));
    }
    if (this.jdField_d_of_type_Int > -1) {
      localHashMap.put("cloud_download_all_result", String.valueOf(this.jdField_d_of_type_Int));
    }
    localHashMap.put("cloud_download_type", "0");
    bctj.a(BaseApplication.getContext()).a("", "AndroidactARCloudDownLoad", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.2
 * JD-Core Version:    0.7.0.1
 */