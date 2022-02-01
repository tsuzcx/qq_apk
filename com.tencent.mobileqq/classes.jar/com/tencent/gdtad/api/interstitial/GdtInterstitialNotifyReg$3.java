package com.tencent.gdtad.api.interstitial;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

class GdtInterstitialNotifyReg$3
  implements Runnable
{
  GdtInterstitialNotifyReg$3(GdtInterstitialNotifyReg paramGdtInterstitialNotifyReg, WeakReference paramWeakReference, JSONObject paramJSONObject) {}
  
  public void run()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (this.jdField_a_of_type_OrgJsonJSONObject != null) && (!JSONObject.NULL.equals(this.jdField_a_of_type_OrgJsonJSONObject)) && (((GdtInterstitialFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) && (((GdtInterstitialFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a != null)) {
      ((GdtInterstitialFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a.a = this.jdField_a_of_type_OrgJsonJSONObject.toString();
    }
    localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((GdtInterstitialFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.3
 * JD-Core Version:    0.7.0.1
 */