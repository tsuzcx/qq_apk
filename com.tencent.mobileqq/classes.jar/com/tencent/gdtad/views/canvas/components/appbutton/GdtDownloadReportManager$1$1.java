package com.tencent.gdtad.views.canvas.components.appbutton;

import acvc;
import acvq;
import acwp;
import acwq;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;

public class GdtDownloadReportManager$1$1
  implements Runnable
{
  public GdtDownloadReportManager$1$1(acwq paramacwq, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = acwp.a(acwp.a());
    if (localObject == null)
    {
      acvc.d("GdtDownloadReportManager", "fetch sigh MD5 failed no appbtndata:");
      acvq.a(acwp.a(this.jdField_a_of_type_Acwq.a), 284);
    }
    for (;;)
    {
      acwp.a(this.jdField_a_of_type_Acwq.a, this.b);
      return;
      localObject = ((AdAppBtnData)localObject).signatureMd5Molo;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        acvc.b("GdtDownloadReportManager", "fetch appbtndata sigh MD5 failed");
        acvq.a(acwp.a(this.jdField_a_of_type_Acwq.a), 284);
      }
      else if (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))
      {
        acvc.b("GdtDownloadReportManager", "fetch sigh MD5 matched");
        acvq.a(acwp.a(this.jdField_a_of_type_Acwq.a), 275);
      }
      else
      {
        acvc.b("GdtDownloadReportManager", "fetch sigh MD5 not matched");
        acvq.a(acwp.a(this.jdField_a_of_type_Acwq.a), 276);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1
 * JD-Core Version:    0.7.0.1
 */