package com.tencent.gdtad.api;

import acor;
import acos;
import acvc;
import java.lang.ref.WeakReference;

class GdtAd$1
  implements Runnable
{
  GdtAd$1(GdtAd paramGdtAd, WeakReference paramWeakReference, acor paramacor) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()) == null) || (GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).get() == null))
    {
      acvc.d("GdtAd", "notifyFailedToLoad error");
      return;
    }
    ((acos)GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).get()).onAdFailedToLoad((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_Acor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.1
 * JD-Core Version:    0.7.0.1
 */