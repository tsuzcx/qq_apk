package com.tencent.gdtad.api;

import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;

class GdtAd$1
  implements Runnable
{
  GdtAd$1(GdtAd paramGdtAd, WeakReference paramWeakReference, GdtAdError paramGdtAdError) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()) == null) || (GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).get() == null))
    {
      GdtLog.d("GdtAd", "notifyFailedToLoad error");
      return;
    }
    ((GdtAdListener)GdtAd.access$000((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get()).get()).a((GdtAd)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentGdtadApiGdtAdError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.GdtAd.1
 * JD-Core Version:    0.7.0.1
 */