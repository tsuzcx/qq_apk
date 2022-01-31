package com.tencent.mobileqq.ar;

import azri;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$11
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("last_total_time", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("upload_count", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("session_ids", this.jdField_a_of_type_JavaLangString);
    azri.a(BaseApplication.getContext()).a("", "scanner_first_ocr_tips", true, this.b, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.11
 * JD-Core Version:    0.7.0.1
 */