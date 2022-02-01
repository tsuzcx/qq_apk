package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import com.tencent.ark.ark;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class GdtInterstitialNotifyReg$1
  implements Runnable
{
  GdtInterstitialNotifyReg$1(GdtInterstitialParams paramGdtInterstitialParams, String paramString, WeakReference paramWeakReference, GdtInterstitialStatus paramGdtInterstitialStatus) {}
  
  public void run()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      if ((this.a != null) && (this.a.b()))
      {
        Object localObject = GdtJsonPbUtil.a(this.a.d.a.info);
        if ((localObject != null) && (!JSONObject.NULL.equals(localObject)))
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("adInfo", localObject);
          localJSONObject1.put("gdt", localJSONObject2);
        }
      }
      ark.arkNotify(GdtInterstitialManager.a().d().a, this.b, localJSONObject1.toString(), "json");
    }
    catch (Throwable localThrowable)
    {
      GdtLog.d("GdtInterstitialNotifyReg", "sendEvent", localThrowable);
    }
    GdtLog.b("GdtInterstitialNotifyReg", String.format("sendEvent %s", new Object[] { this.b }));
    GdtAnalysisHelperForInterstitial.b((Context)this.c.get(), this.a, this.d, this.b, GdtInterstitialManager.a().d().a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialNotifyReg.1
 * JD-Core Version:    0.7.0.1
 */