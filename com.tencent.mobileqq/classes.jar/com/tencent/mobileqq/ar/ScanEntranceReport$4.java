package com.tencent.mobileqq.ar;

import aldn;
import axrn;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$4
  implements Runnable
{
  public ScanEntranceReport$4(aldn paramaldn, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("first_init", String.valueOf(this.jdField_a_of_type_Boolean));
    localHashMap.put("start_delay", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("first_select_time", String.valueOf(this.b));
    localHashMap.put("first_upload_delay", String.valueOf(this.c));
    localHashMap.put("neon_opened", String.valueOf(this.jdField_a_of_type_Int));
    axrn.a(BaseApplication.getContext()).a("", "scanner_ar_cloud_first_upload", true, this.d, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.4
 * JD-Core Version:    0.7.0.1
 */