package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ark.ark;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import java.lang.ref.WeakReference;
import yuf;
import yul;
import yxs;

public final class GdtInterstitialNotifyReg$2
  implements Runnable
{
  public GdtInterstitialNotifyReg$2(WeakReference paramWeakReference, GdtInterstitialParams paramGdtInterstitialParams) {}
  
  public void run()
  {
    try
    {
      ark.arkNotify(yul.a().a().a, "interstitial_view_pause_event", "{}", "json");
      yxs.b("GdtInterstitialNotifyReg", String.format("sendPause", new Object[0]));
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      String str = yul.a().a().a;
      if ((this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null) && (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a != null))
      {
        GdtAd localGdtAd = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a.a;
        AdReporterForAnalysis.reportForARKSendNotification(localContext, true, "interstitial_view_pause_event", str, localGdtAd);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        yxs.d("GdtInterstitialNotifyReg", "sendPause", localThrowable);
        continue;
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.2
 * JD-Core Version:    0.7.0.1
 */