package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.lang.ref.WeakReference;

class GdtAdWSVerticalItemBottomController$1
  implements AdExposureChecker.ExposureCallback
{
  GdtAdWSVerticalItemBottomController$1(GdtAdWSVerticalItemBottomController paramGdtAdWSVerticalItemBottomController) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    WSLog.d("AdExposureChecker", "onExposure");
    GdtAdUtil.a(GdtAdWSVerticalItemBottomController.a(this.a), (WSVerticalItemData)this.a.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemBottomController.1
 * JD-Core Version:    0.7.0.1
 */