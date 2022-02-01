package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;

class GdtAdWSVerticalVideoItemView$4
  implements AdExposureChecker.ExposureCallback
{
  GdtAdWSVerticalVideoItemView$4(GdtAdWSVerticalVideoItemView paramGdtAdWSVerticalVideoItemView) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    WSLog.d("AdExposureChecker", "onExposure");
    GdtAdUtil.a(BaseApplicationImpl.getContext(), GdtAdWSVerticalVideoItemView.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalVideoItemView.4
 * JD-Core Version:    0.7.0.1
 */