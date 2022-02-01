package com.tencent.mobileqq.ar;

import apkz;
import bdmc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$5
  implements Runnable
{
  public ScanEntranceReport$5(apkz paramapkz, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    bdmc.a(BaseApplication.getContext()).a("", "scanner_ar_cloud_first_result", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.5
 * JD-Core Version:    0.7.0.1
 */