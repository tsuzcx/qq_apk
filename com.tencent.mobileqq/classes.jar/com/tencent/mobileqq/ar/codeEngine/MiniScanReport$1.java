package com.tencent.mobileqq.ar.codeEngine;

import anak;
import azmz;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$1
  implements Runnable
{
  public MiniScanReport$1(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {}
  
  public void run()
  {
    azmz localazmz = azmz.a(BaseApplication.getContext());
    HashMap localHashMap;
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int < 180000))
    {
      localHashMap = new HashMap();
      localHashMap.put("report_key_scan_total", String.valueOf(this.jdField_a_of_type_Long));
      localHashMap.put("report_key_scan_cnt", String.valueOf(this.b));
      localHashMap.put("report_key_scan_avg", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("report_key_scan_suc", String.valueOf(this.c));
      anak.a(localHashMap);
      localazmz.a("", "report_tag_scan_avg_qr", true, 0L, 0L, localHashMap, "");
    }
    if ((this.d > 0) && (this.e > 0) && (this.e < 180000))
    {
      localHashMap = new HashMap();
      localHashMap.put("report_key_scan_total", String.valueOf(this.jdField_a_of_type_Long));
      localHashMap.put("report_key_scan_cnt", String.valueOf(this.d));
      localHashMap.put("report_key_scan_avg", String.valueOf(this.e));
      localHashMap.put("report_key_scan_suc", String.valueOf(this.c));
      anak.a(localHashMap);
      localazmz.a("", "report_tag_scan_avg_minidecode", true, 0L, 0L, localHashMap, "");
    }
    if ((this.f > 0) && (this.g > 0) && (this.g < 180000))
    {
      localHashMap = new HashMap();
      localHashMap.put("report_key_scan_total", String.valueOf(this.jdField_a_of_type_Long));
      localHashMap.put("report_key_scan_cnt", String.valueOf(this.f));
      localHashMap.put("report_key_scan_avg", String.valueOf(this.g));
      localHashMap.put("report_key_scan_suc", String.valueOf(this.c));
      anak.a(localHashMap);
      localazmz.a("", "report_tag_scan_avg_minidetect", true, 0L, 0L, localHashMap, "");
    }
    if ((QLog.isColorLevel()) || (anak.a())) {
      QLog.i("MiniRecog.MiniScanReport", 1, String.format("base_test_scan markScanEnd [sucType,totalConsume,qrAvg,decodeAvg,detectAvg]=[%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(this.c), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.e), Integer.valueOf(this.g) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.1
 * JD-Core Version:    0.7.0.1
 */