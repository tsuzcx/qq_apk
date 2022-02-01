package com.tencent.gdtad.api;

import acap;
import acaq;
import acho;
import java.lang.ref.WeakReference;

class GdtAd$1
  implements Runnable
{
  GdtAd$1(GdtAd paramGdtAd, WeakReference paramWeakReference, acap paramacap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()) == null) || (GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).get() == null))
    {
      acho.d("GdtAd", "notifyFailedToLoad error");
      return;
    }
    ((acaq)GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).get()).a((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_Acap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.1
 * JD-Core Version:    0.7.0.1
 */