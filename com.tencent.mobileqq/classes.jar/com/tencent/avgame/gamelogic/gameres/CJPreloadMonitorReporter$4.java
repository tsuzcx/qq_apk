package com.tencent.avgame.gamelogic.gameres;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Res;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import java.util.HashMap;
import java.util.Map;

final class CJPreloadMonitorReporter$4
  implements Runnable
{
  CJPreloadMonitorReporter$4(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (CJPreloadMonitorReporter.a(this.jdField_a_of_type_JavaLangString))
    {
      String str = QWalletTools.c(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", str);
        localHashMap.put("ext2", CJPreloadMonitorReporter.a(721) + "");
        localHashMap.put("ext3", CJPreloadMonitorReporter.b(721) + "");
        localHashMap.put("ext4", this.jdField_a_of_type_Int + "");
        SpringHbReporter.a(ReportConstant.Event.jdField_a_of_type_JavaLangString, 3, this.b, localHashMap, ReportConstant.Res.a(3));
      }
      if (this.b != 0) {
        break label164;
      }
    }
    label164:
    while (this.jdField_a_of_type_Int != 404) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.CJPreloadMonitorReporter.4
 * JD-Core Version:    0.7.0.1
 */