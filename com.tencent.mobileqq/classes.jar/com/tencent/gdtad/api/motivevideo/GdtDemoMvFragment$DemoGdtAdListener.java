package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class GdtDemoMvFragment$DemoGdtAdListener
  implements GdtAdListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  
  public GdtDemoMvFragment$DemoGdtAdListener(GdtDemoMvFragment paramGdtDemoMvFragment, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private long a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null)) {
      return paramGdtAd.getAd().getAId();
    }
    return -2147483648L;
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    GdtDemoMvFragment.a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtDemoMvFragment, paramGdtAd);
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "demo数据构造成功", 0).a();
    QLog.i("GdtDemoMvFragment", 1, String.format("onAdLoaded %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
    GdtPreLoader.a().a(paramGdtAd.getAd());
  }
  
  public void a(com.tencent.gdtad.api.GdtAd paramGdtAd, GdtAdError paramGdtAdError)
  {
    paramGdtAd = new StringBuilder();
    paramGdtAd.append("onAdFailedToLoad ");
    paramGdtAd.append(paramGdtAdError.a());
    QLog.e("GdtDemoMvFragment", 1, paramGdtAd.toString());
  }
  
  public void b(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("GdtDemoMvFragment", 1, String.format("onAdImpression %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void c(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("GdtDemoMvFragment", 1, String.format("onAdClicked %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
  
  public void d(com.tencent.gdtad.api.GdtAd paramGdtAd)
  {
    QLog.i("GdtDemoMvFragment", 1, String.format("onAdClosed %d", new Object[] { Long.valueOf(a(paramGdtAd)) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment.DemoGdtAdListener
 * JD-Core Version:    0.7.0.1
 */