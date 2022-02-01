package com.tencent.mobileqq.ar;

import apkz;
import bdmc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ScanEntranceReport$9
  implements Runnable
{
  public ScanEntranceReport$9(apkz paramapkz) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    bdmc.a(BaseApplication.getContext()).a("", "scanner_zoom_camera", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport.9
 * JD-Core Version:    0.7.0.1
 */