package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

class GdtAdWSVerticalVideoItemView$3$1
  implements AdExposureChecker.ExposureCallback
{
  GdtAdWSVerticalVideoItemView$3$1(GdtAdWSVerticalVideoItemView.3 param3) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QZLog.w("AdExposureChecker", "onExposure");
    GdtAdUtil.a(this.a.this$0.a, GdtAdWSVerticalVideoItemView.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalVideoItemView.3.1
 * JD-Core Version:    0.7.0.1
 */