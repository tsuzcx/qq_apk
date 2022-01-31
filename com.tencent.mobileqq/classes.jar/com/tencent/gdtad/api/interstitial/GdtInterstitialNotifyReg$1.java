package com.tencent.gdtad.api.interstitial;

import aaoi;
import aaoq;
import aasd;
import aase;
import aasr;
import android.content.Context;
import com.tencent.ark.ark;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class GdtInterstitialNotifyReg$1
  implements Runnable
{
  public GdtInterstitialNotifyReg$1(GdtInterstitialParams paramGdtInterstitialParams, String paramString, WeakReference paramWeakReference, GdtInterstitialStatus paramGdtInterstitialStatus) {}
  
  public void run()
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null) {
          continue;
        }
        ark.arkNotify(aaoq.a().a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, localJSONObject1.toString(), "json");
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        JSONObject localJSONObject2;
        aase.d("GdtInterstitialNotifyReg", "sendEvent", localThrowable);
        continue;
      }
      aase.b("GdtInterstitialNotifyReg", String.format("sendEvent %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
      aasr.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus, this.jdField_a_of_type_JavaLangString, aaoq.a().a().jdField_a_of_type_JavaLangString);
      return;
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())
      {
        localObject = aasd.a(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a.a.info);
        if ((localObject != null) && (localObject != JSONObject.NULL))
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("adInfo", localObject);
          localJSONObject1.put("gdt", localJSONObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.1
 * JD-Core Version:    0.7.0.1
 */