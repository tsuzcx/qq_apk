package com.tencent.mobileqq.ar.codeEngine;

import apqz;
import apra;
import bdmc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$7
  implements Runnable
{
  public MiniScanReport$7(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_key_detect_support_type", String.valueOf(this.a));
    localHashMap.put("report_key_detect_init_cost", String.valueOf(this.b));
    localHashMap.put("report_key_qq_version", "0");
    localHashMap.put("report_key_qq_subversion", "4745");
    String str2 = apqz.c("QMCF_qr");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localHashMap.put("report_key_so_md5", str1);
    apra.a(localHashMap);
    bdmc.a(BaseApplication.getContext()).a("", "report_tag_detect_init_cost", true, 0L, 0L, localHashMap, "");
    if ((QLog.isColorLevel()) || (apra.a())) {
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("base_test_scan onDetectInitCost [supportType,timeCost]=[%d,%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.7
 * JD-Core Version:    0.7.0.1
 */