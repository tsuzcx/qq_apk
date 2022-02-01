package com.tencent.gdtad.views.canvas.components.appbutton;

import acqy;
import acrm;
import acsl;
import acsm;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;

public class GdtDownloadReportManager$1$1
  implements Runnable
{
  public GdtDownloadReportManager$1$1(acsm paramacsm, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = acsl.a(acsl.a());
    if (localObject == null)
    {
      acqy.d("GdtDownloadReportManager", "fetch sigh MD5 failed no appbtndata:");
      acrm.a(acsl.a(this.jdField_a_of_type_Acsm.a), 284);
    }
    for (;;)
    {
      acsl.a(this.jdField_a_of_type_Acsm.a, this.b);
      return;
      localObject = ((AdAppBtnData)localObject).signatureMd5Molo;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        acqy.b("GdtDownloadReportManager", "fetch appbtndata sigh MD5 failed");
        acrm.a(acsl.a(this.jdField_a_of_type_Acsm.a), 284);
      }
      else if (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))
      {
        acqy.b("GdtDownloadReportManager", "fetch sigh MD5 matched");
        acrm.a(acsl.a(this.jdField_a_of_type_Acsm.a), 275);
      }
      else
      {
        acqy.b("GdtDownloadReportManager", "fetch sigh MD5 not matched");
        acrm.a(acsl.a(this.jdField_a_of_type_Acsm.a), 276);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1
 * JD-Core Version:    0.7.0.1
 */