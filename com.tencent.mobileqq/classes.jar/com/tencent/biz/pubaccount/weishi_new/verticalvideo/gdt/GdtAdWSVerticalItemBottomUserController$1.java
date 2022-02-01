package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.lang.ref.WeakReference;

class GdtAdWSVerticalItemBottomUserController$1
  implements AdExposureChecker.ExposureCallback
{
  GdtAdWSVerticalItemBottomUserController$1(GdtAdWSVerticalItemBottomUserController paramGdtAdWSVerticalItemBottomUserController) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    WSLog.d("AdExposureChecker", "onExposure");
    GdtAdUtil.a(GdtAdWSVerticalItemBottomUserController.a(this.a), (WSVerticalItemData)this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemBottomUserController.1
 * JD-Core Version:    0.7.0.1
 */