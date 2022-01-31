package com.tencent.mobileqq.ar;

import amud;
import azmz;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$5
  implements Runnable
{
  public ScanEntranceReport$5(amud paramamud, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    azmz.a(BaseApplication.getContext()).a("", "scanner_ar_cloud_first_result", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.5
 * JD-Core Version:    0.7.0.1
 */