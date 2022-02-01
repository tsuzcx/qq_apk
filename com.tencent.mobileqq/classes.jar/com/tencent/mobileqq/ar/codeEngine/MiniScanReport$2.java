package com.tencent.mobileqq.ar.codeEngine;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class MiniScanReport$2
  implements Runnable
{
  public MiniScanReport$2(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    label53:
    boolean bool;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      str = "1";
      localHashMap.put("report_key_so_suc", str);
      localHashMap.put("report_key_so_version", String.valueOf(this.jdField_a_of_type_Int));
      if (this.jdField_a_of_type_JavaLangString != null) {
        break label168;
      }
      str = "";
      localHashMap.put("report_key_so_md5", str);
      localHashMap.put("report_key_qq_version", "0");
      localHashMap.put("report_key_qq_subversion", "4875");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "report_tag_so_cover", true, 0L, 0L, localHashMap, "");
      if (QLog.isColorLevel())
      {
        bool = this.jdField_a_of_type_Boolean;
        i = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_JavaLangString != null) {
          break label176;
        }
      }
    }
    label168:
    label176:
    for (String str = "";; str = this.jdField_a_of_type_JavaLangString)
    {
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("onSoCoverReport [suc,ver,md5]=[%b,%d,%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), str }));
      return;
      str = "0";
      break;
      str = this.jdField_a_of_type_JavaLangString;
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniScanReport.2
 * JD-Core Version:    0.7.0.1
 */