package com.tencent.gdtad.api;

import java.lang.ref.WeakReference;
import yjz;
import yka;
import yny;

class GdtAd$1
  implements Runnable
{
  GdtAd$1(GdtAd paramGdtAd, WeakReference paramWeakReference, yjz paramyjz) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()) == null) || (GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).get() == null))
    {
      yny.d("GdtAd", "notifyFailedToLoad error");
      return;
    }
    ((yka)GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).get()).a((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_Yjz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.1
 * JD-Core Version:    0.7.0.1
 */