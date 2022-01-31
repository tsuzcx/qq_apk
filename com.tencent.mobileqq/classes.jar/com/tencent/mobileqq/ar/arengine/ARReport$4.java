package com.tencent.mobileqq.ar.arengine;

import ando;
import azri;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$4
  implements Runnable
{
  public ARReport$4(ando paramando, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (ando.a(this.this$0, this.jdField_a_of_type_Long)) {
      localHashMap.put("local_load_feature_time", String.valueOf(this.jdField_a_of_type_Long));
    }
    if (this.b > 0L) {
      localHashMap.put("local_load_feature_count", String.valueOf(this.b));
    }
    if (ando.a(this.this$0, this.c)) {
      localHashMap.put("local_recognize_time", String.valueOf(this.c));
    }
    if (this.d > 0L) {
      localHashMap.put("local_recognize_times", String.valueOf(this.d));
    }
    if (this.e > 0L) {
      localHashMap.put("local_recognize_quality", String.valueOf(this.e));
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      localHashMap.put("local_recognize_featureid", this.jdField_a_of_type_JavaLangString);
    }
    azri.a(BaseApplication.getContext()).a("", "AndroidactARLocal", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.4
 * JD-Core Version:    0.7.0.1
 */