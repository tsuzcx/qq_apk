package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

final class GdtInterstitialView$2
  implements Runnable
{
  GdtInterstitialView$2(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      WeakReference localWeakReference = GdtInterstitialManager.a().a(this.jdField_a_of_type_JavaLangString);
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        ((GdtInterstitialFragment)localWeakReference.get()).a(4, this.jdField_a_of_type_Int, this.b, -2147483648);
        bool = true;
        break label67;
      }
    }
    boolean bool = false;
    label67:
    GdtLog.b("GdtInterstitialView", String.format("close %b error:%d traceId:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialView.2
 * JD-Core Version:    0.7.0.1
 */