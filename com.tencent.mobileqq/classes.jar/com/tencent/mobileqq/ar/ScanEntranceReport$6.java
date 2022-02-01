package com.tencent.mobileqq.ar;

import aoxj;
import bctj;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$6
  implements Runnable
{
  public ScanEntranceReport$6(aoxj paramaoxj, int paramInt, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("neon_opened", String.valueOf(this.jdField_a_of_type_Int));
    bctj.a(BaseApplication.getContext()).a("", "scanner_ar_cloud_first_success", true, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.6
 * JD-Core Version:    0.7.0.1
 */