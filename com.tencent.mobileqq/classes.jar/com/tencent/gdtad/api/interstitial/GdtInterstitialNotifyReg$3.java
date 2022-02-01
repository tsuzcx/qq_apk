package com.tencent.gdtad.api.interstitial;

import abmn;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class GdtInterstitialNotifyReg$3
  implements Runnable
{
  public GdtInterstitialNotifyReg$3(abmn paramabmn, WeakReference paramWeakReference, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_OrgJsonJSONObject != null) && (!JSONObject.NULL.equals(this.jdField_a_of_type_OrgJsonJSONObject)) && (((GdtInterstitialFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a() != null) && (((GdtInterstitialFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a != null)) {
      ((GdtInterstitialFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a.a = this.jdField_a_of_type_OrgJsonJSONObject.toString();
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((GdtInterstitialFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.3
 * JD-Core Version:    0.7.0.1
 */