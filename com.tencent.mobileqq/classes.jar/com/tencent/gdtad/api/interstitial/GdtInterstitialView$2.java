package com.tencent.gdtad.api.interstitial;

import aaoq;
import aase;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public final class GdtInterstitialView$2
  implements Runnable
{
  public GdtInterstitialView$2(String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      bool = false;
    }
    for (;;)
    {
      aase.b("GdtInterstitialView", String.format("close %b error:%d traceId:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      return;
      WeakReference localWeakReference = aaoq.a().a(this.jdField_a_of_type_JavaLangString);
      if (localWeakReference != null)
      {
        if (localWeakReference.get() == null)
        {
          bool = false;
        }
        else
        {
          ((GdtInterstitialFragment)localWeakReference.get()).a(4, this.jdField_a_of_type_Int, this.b, -2147483648, -2147483648L);
          bool = true;
        }
      }
      else {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialView.2
 * JD-Core Version:    0.7.0.1
 */