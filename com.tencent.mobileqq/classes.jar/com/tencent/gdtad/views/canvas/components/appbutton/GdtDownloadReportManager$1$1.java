package com.tencent.gdtad.views.canvas.components.appbutton;

import abrl;
import absb;
import absy;
import absz;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;

public class GdtDownloadReportManager$1$1
  implements Runnable
{
  public GdtDownloadReportManager$1$1(absz paramabsz, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = absy.a(absy.a());
    if (localObject == null)
    {
      abrl.d("GdtDownloadReportManager", "fetch sigh MD5 failed no appbtndata:");
      absb.a(absy.a(this.jdField_a_of_type_Absz.a), 284);
    }
    for (;;)
    {
      absy.a(this.jdField_a_of_type_Absz.a, this.b);
      return;
      localObject = ((AdAppBtnData)localObject).signatureMd5Molo;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        abrl.b("GdtDownloadReportManager", "fetch appbtndata sigh MD5 failed");
        absb.a(absy.a(this.jdField_a_of_type_Absz.a), 284);
      }
      else if (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))
      {
        abrl.b("GdtDownloadReportManager", "fetch sigh MD5 matched");
        absb.a(absy.a(this.jdField_a_of_type_Absz.a), 275);
      }
      else
      {
        abrl.b("GdtDownloadReportManager", "fetch sigh MD5 not matched");
        absb.a(absy.a(this.jdField_a_of_type_Absz.a), 276);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1
 * JD-Core Version:    0.7.0.1
 */