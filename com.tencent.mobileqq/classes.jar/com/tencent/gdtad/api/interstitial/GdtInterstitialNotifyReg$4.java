package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;

class GdtInterstitialNotifyReg$4
  implements Runnable
{
  GdtInterstitialNotifyReg$4(GdtInterstitialNotifyReg paramGdtInterstitialNotifyReg, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((GdtInterstitialFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, 0, -2147483648, -2147483648);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.4
 * JD-Core Version:    0.7.0.1
 */