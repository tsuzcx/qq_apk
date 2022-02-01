package com.tencent.gdtad.jsbridge;

import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.log.GdtLog;

class GdtBannerFragmentForJS$2
  implements GdtAdListener
{
  GdtBannerFragmentForJS$2(GdtBannerFragmentForJS paramGdtBannerFragmentForJS) {}
  
  private long a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null)) {
      return paramGdtAd.getAd().getAId();
    }
    return -2147483648L;
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    GdtLog.b("GdtBannerFragmentForJS", String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd, GdtAdError paramGdtAdError)
  {
    paramGdtAd = new StringBuilder();
    paramGdtAd.append("onAdFailedToLoad ");
    paramGdtAd.append(paramGdtAdError.a());
    GdtLog.d("GdtBannerFragmentForJS", paramGdtAd.toString());
    paramGdtAd = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAdFailedToLoad ");
    localStringBuilder.append(paramGdtAdError.a());
    Toast.makeText(paramGdtAd, localStringBuilder.toString(), 0).show();
  }
  
  public void b(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    GdtLog.b("GdtBannerFragmentForJS", String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void c(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    GdtLog.b("GdtBannerFragmentForJS", String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
  }
  
  public void d(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    GdtLog.b("GdtBannerFragmentForJS", String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    Toast.makeText(BaseApplicationImpl.getContext(), String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }), 0).show();
    this.a.a.removeView(GdtBannerFragmentForJS.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS.2
 * JD-Core Version:    0.7.0.1
 */