package com.tencent.mobileqq.ar;

import azri;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$2
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("first_init", String.valueOf(this.jdField_a_of_type_Boolean));
    localHashMap.put("init_delay", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("init_time", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("download_resource", String.valueOf(this.jdField_b_of_type_Boolean));
    azri.a(BaseApplication.getContext()).a("", "scanner_ar_init", true, this.c, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.2
 * JD-Core Version:    0.7.0.1
 */