package com.tencent.gdtad.api.interstitial;

import acqe;
import java.lang.ref.WeakReference;

public class GdtInterstitialNotifyReg$4
  implements Runnable
{
  public GdtInterstitialNotifyReg$4(acqe paramacqe, WeakReference paramWeakReference, int paramInt, long paramLong) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((GdtInterstitialFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_Int, 0, -2147483648, -2147483648, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.4
 * JD-Core Version:    0.7.0.1
 */