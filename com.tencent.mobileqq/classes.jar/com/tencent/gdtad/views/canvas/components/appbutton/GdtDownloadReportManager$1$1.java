package com.tencent.gdtad.views.canvas.components.appbutton;

import aanp;
import aaod;
import aapc;
import aapd;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;

public class GdtDownloadReportManager$1$1
  implements Runnable
{
  public GdtDownloadReportManager$1$1(aapd paramaapd, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = aapc.a(aapc.a());
    if (localObject == null)
    {
      aanp.d("GdtDownloadReportManager", "fetch sigh MD5 failed no appbtndata:");
      aaod.a(aapc.a(this.jdField_a_of_type_Aapd.a), 284);
    }
    for (;;)
    {
      aapc.a(this.jdField_a_of_type_Aapd.a, this.b);
      return;
      localObject = ((AdAppBtnData)localObject).signatureMd5Molo;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        aanp.b("GdtDownloadReportManager", "fetch appbtndata sigh MD5 failed");
        aaod.a(aapc.a(this.jdField_a_of_type_Aapd.a), 284);
      }
      else if (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))
      {
        aanp.b("GdtDownloadReportManager", "fetch sigh MD5 matched");
        aaod.a(aapc.a(this.jdField_a_of_type_Aapd.a), 275);
      }
      else
      {
        aanp.b("GdtDownloadReportManager", "fetch sigh MD5 not matched");
        aaod.a(aapc.a(this.jdField_a_of_type_Aapd.a), 276);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager.1.1
 * JD-Core Version:    0.7.0.1
 */