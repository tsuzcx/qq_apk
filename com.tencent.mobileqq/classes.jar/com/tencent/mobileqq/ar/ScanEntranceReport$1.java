package com.tencent.mobileqq.ar;

import amys;
import azri;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$1
  implements Runnable
{
  public ScanEntranceReport$1(amys paramamys, long paramLong1, long paramLong2, String paramString, long paramLong3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("proc_exist", String.valueOf(amys.a(this.this$0)));
    localHashMap.put("proc_restart", String.valueOf(amys.b(this.this$0)));
    localHashMap.put("proc_load_time", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("activity_launch_time", String.valueOf(this.b));
    localHashMap.put("entry_source", this.jdField_a_of_type_JavaLangString);
    azri.a(BaseApplication.getContext()).a("", "scanner_activity_launch", true, this.c, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.1
 * JD-Core Version:    0.7.0.1
 */