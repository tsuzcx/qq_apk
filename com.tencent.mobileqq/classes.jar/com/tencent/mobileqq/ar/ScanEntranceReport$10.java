package com.tencent.mobileqq.ar;

import azri;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$10
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_name", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("memory_size", String.valueOf(this.jdField_a_of_type_Int));
    azri.a(BaseApplication.getContext()).a("", "scanner_average_fps", true, this.b, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.10
 * JD-Core Version:    0.7.0.1
 */