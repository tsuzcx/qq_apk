package com.tencent.mobileqq.ar;

import azri;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$8
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("upload_count", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("zoom_count", String.valueOf(this.b));
    azri.a(BaseApplication.getContext()).a("", "scanner_qr_success", true, this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.8
 * JD-Core Version:    0.7.0.1
 */