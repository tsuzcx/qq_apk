package com.tencent.mobileqq.ar;

import axrn;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$3
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("first_init", String.valueOf(this.jdField_a_of_type_Boolean));
    localHashMap.put("bind_time", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("got_config_time", String.valueOf(this.b));
    localHashMap.put("resource_check_time", String.valueOf(this.c));
    localHashMap.put("dependence_wait_time", String.valueOf(this.d));
    axrn.a(BaseApplication.getContext()).a("", "scanner_ar_init_pre", true, this.e, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.3
 * JD-Core Version:    0.7.0.1
 */