package com.tencent.gdtad.views.canvas.components.appbutton;

import acho;
import acie;
import acix;
import aciy;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;

public class GdtDownloadReportManager$1$1
  implements Runnable
{
  public GdtDownloadReportManager$1$1(aciy paramaciy, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = acix.a(acix.a());
    if (localObject == null)
    {
      acho.d("GdtDownloadReportManager", "fetch sigh MD5 failed no appbtndata:");
      acie.a(acix.a(this.jdField_a_of_type_Aciy.a), 284);
    }
    for (;;)
    {
      acix.a(this.jdField_a_of_type_Aciy.a, this.b);
      return;
      localObject = ((AdAppBtnData)localObject).signatureMd5Molo;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        acho.b("GdtDownloadReportManager", "fetch appbtndata sigh MD5 failed");
        acie.a(acix.a(this.jdField_a_of_type_Aciy.a), 284);
      }
      else if (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))
      {
        acho.b("GdtDownloadReportManager", "fetch sigh MD5 matched");
        acie.a(acix.a(this.jdField_a_of_type_Aciy.a), 275);
      }
      else
      {
        acho.b("GdtDownloadReportManager", "fetch sigh MD5 not matched");
        acie.a(acix.a(this.jdField_a_of_type_Aciy.a), 276);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1
 * JD-Core Version:    0.7.0.1
 */