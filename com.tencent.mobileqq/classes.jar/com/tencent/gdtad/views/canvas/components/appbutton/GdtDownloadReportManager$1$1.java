package com.tencent.gdtad.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtTraceReporter;

class GdtDownloadReportManager$1$1
  implements Runnable
{
  GdtDownloadReportManager$1$1(GdtDownloadReportManager.1 param1, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = GdtDownloadReportManager.a(GdtDownloadReportManager.a());
    if (localObject == null)
    {
      GdtLog.d("GdtDownloadReportManager", "fetch sigh MD5 failed no appbtndata:");
      GdtTraceReporter.a(GdtDownloadReportManager.a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtDownloadReportManager$1.a), 284);
    }
    else
    {
      localObject = ((AdAppBtnData)localObject).signatureMd5Molo;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        GdtLog.b("GdtDownloadReportManager", "fetch appbtndata sigh MD5 failed");
        GdtTraceReporter.a(GdtDownloadReportManager.a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtDownloadReportManager$1.a), 284);
      }
      else if (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))
      {
        GdtLog.b("GdtDownloadReportManager", "fetch sigh MD5 matched");
        GdtTraceReporter.a(GdtDownloadReportManager.a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtDownloadReportManager$1.a), 275);
      }
      else
      {
        GdtLog.b("GdtDownloadReportManager", "fetch sigh MD5 not matched");
        GdtTraceReporter.a(GdtDownloadReportManager.a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtDownloadReportManager$1.a), 276);
      }
    }
    GdtDownloadReportManager.a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtDownloadReportManager$1.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1
 * JD-Core Version:    0.7.0.1
 */