package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import com.tencent.ark.ark;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtReporterForAnalysis;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class GdtInterstitialNotifyReg$1
  implements Runnable
{
  GdtInterstitialNotifyReg$1(GdtInterstitialParams paramGdtInterstitialParams, String paramString, WeakReference paramWeakReference, GdtInterstitialStatus paramGdtInterstitialStatus) {}
  
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
        ark.arkNotify(GdtInterstitialManager.a().a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, localJSONObject1.toString(), "json");
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        JSONObject localJSONObject2;
        GdtLog.d("GdtInterstitialNotifyReg", "sendEvent", localThrowable);
        continue;
      }
      GdtLog.b("GdtInterstitialNotifyReg", String.format("sendEvent %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
      GdtReporterForAnalysis.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus, this.jdField_a_of_type_JavaLangString, GdtInterstitialManager.a().a().jdField_a_of_type_JavaLangString);
      return;
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())
      {
        localObject = GdtJsonPbUtil.a(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a.a.info);
        if ((localObject != null) && (!JSONObject.NULL.equals(localObject)))
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("adInfo", localObject);
          localJSONObject1.put("gdt", localJSONObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.1
 * JD-Core Version:    0.7.0.1
 */