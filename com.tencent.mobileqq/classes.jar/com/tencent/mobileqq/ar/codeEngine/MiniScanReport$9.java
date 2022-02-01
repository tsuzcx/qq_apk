package com.tencent.mobileqq.ar.codeEngine;

import apnn;
import apno;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$9
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_key_detect_support_type", String.valueOf(this.a));
    localHashMap.put("report_key_detect_first_cost", String.valueOf(this.b));
    localHashMap.put("report_key_qq_version", "0");
    localHashMap.put("report_key_qq_subversion", "4875");
    String str2 = apnn.c("QMCF_qr");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localHashMap.put("report_key_so_md5", str1);
    localHashMap.put("report_key_detect_init_process", String.valueOf(RecogUtil.getProcessId()));
    apno.a(localHashMap);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "report_tag_detect_first_cost", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("onDetectFirstCost [supportType,timeCost]=[%d,%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.9
 * JD-Core Version:    0.7.0.1
 */