package com.tencent.mobileqq.ar;

import awrn;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$12
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("last_total_time", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("upload_count", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("session_ids", this.jdField_a_of_type_JavaLangString);
    awrn.a(BaseApplication.getContext()).a("", "scanner_first_ar_recog", true, this.b, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.12
 * JD-Core Version:    0.7.0.1
 */