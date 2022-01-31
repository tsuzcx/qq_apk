package com.tencent.gdtad.views.canvas.components.appbutton;

import aase;
import aass;
import aatr;
import aats;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;

public class GdtDownloadReportManager$1$1
  implements Runnable
{
  public GdtDownloadReportManager$1$1(aats paramaats, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = aatr.a(aatr.a());
    if (localObject == null)
    {
      aase.d("GdtDownloadReportManager", "fetch sigh MD5 failed no appbtndata:");
      aass.a(aatr.a(this.jdField_a_of_type_Aats.a), 284);
    }
    for (;;)
    {
      aatr.a(this.jdField_a_of_type_Aats.a, this.b);
      return;
      localObject = ((AdAppBtnData)localObject).signatureMd5Molo;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        aase.b("GdtDownloadReportManager", "fetch appbtndata sigh MD5 failed");
        aass.a(aatr.a(this.jdField_a_of_type_Aats.a), 284);
      }
      else if (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))
      {
        aase.b("GdtDownloadReportManager", "fetch sigh MD5 matched");
        aass.a(aatr.a(this.jdField_a_of_type_Aats.a), 275);
      }
      else
      {
        aase.b("GdtDownloadReportManager", "fetch sigh MD5 not matched");
        aass.a(aatr.a(this.jdField_a_of_type_Aats.a), 276);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1
 * JD-Core Version:    0.7.0.1
 */