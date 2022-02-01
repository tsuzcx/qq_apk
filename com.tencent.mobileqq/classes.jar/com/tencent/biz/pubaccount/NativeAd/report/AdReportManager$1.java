package com.tencent.biz.pubaccount.NativeAd.report;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import ohu;
import ohv;
import ohw;
import oie;
import oik;
import ufw;

public class AdReportManager$1
  implements Runnable
{
  public AdReportManager$1(ohu paramohu, ufw paramufw, String paramString) {}
  
  private void a(ReportAction paramReportAction, String paramString, Map<String, ohv> paramMap)
  {
    try
    {
      oie localoie = (oie)paramMap.get("common");
      if (localoie == null) {
        return;
      }
      localoie.a(ActionEntity.Default);
      paramMap = oik.a(paramMap);
      ohu.a(this.this$0, paramString, paramMap, paramReportAction);
      return;
    }
    catch (Throwable paramReportAction)
    {
      QLog.d("AdReportManager", 4, paramReportAction, new Object[0]);
    }
  }
  
  public void run()
  {
    String str;
    try
    {
      if (ohu.a(this.jdField_a_of_type_Ufw, this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      ReportAction localReportAction = oik.a(this.jdField_a_of_type_Ufw);
      str = oik.a(this.jdField_a_of_type_Ufw);
      if (TextUtils.isEmpty(str))
      {
        ohu.a(this.this$0, "action:" + localReportAction.getValue() + ",report fail:", "reportUrl is empty");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("AdReportManager", 4, localThrowable, new Object[0]);
      return;
    }
    Map localMap = oik.a(this.jdField_a_of_type_Ufw);
    if ((localMap == null) || (localMap.size() == 0))
    {
      ohu.a(this.this$0, "action:" + localThrowable.getValue() + ",report fail:", "reportObjs is empty");
      return;
    }
    ohw localohw = oik.a(localMap);
    if (localohw.a())
    {
      ohu.a(this.this$0, "action:" + localThrowable.getValue() + ",report fail:", "reportData is empty");
      return;
    }
    if (ohu.a(this.jdField_a_of_type_Ufw)) {
      ohu.a(this.this$0, str, localohw, this.jdField_a_of_type_JavaLangString, localThrowable);
    }
    while ((localThrowable == ReportAction.EXPOSE) && (this.jdField_a_of_type_Ufw.a() == ExposeMode.STRICT) && (oik.a(this.jdField_a_of_type_Ufw) == ActionEntity.OutSuperMask))
    {
      a(localThrowable, str, localMap);
      return;
      ohu.a(this.this$0, str, localohw, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.AdReportManager.1
 * JD-Core Version:    0.7.0.1
 */