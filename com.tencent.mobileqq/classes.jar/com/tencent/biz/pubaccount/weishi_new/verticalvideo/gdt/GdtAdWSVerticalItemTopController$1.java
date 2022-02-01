package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.qflutter.utils.FLog;
import java.lang.ref.WeakReference;

class GdtAdWSVerticalItemTopController$1
  implements AdExposureChecker.ExposureCallback
{
  GdtAdWSVerticalItemTopController$1(GdtAdWSVerticalItemTopController paramGdtAdWSVerticalItemTopController) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    FLog.e("AdExposureChecker", "onExposure");
    GdtAdUtil.a(GdtAdWSVerticalItemTopController.a(this.a), (WSVerticalItemData)this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemTopController.1
 * JD-Core Version:    0.7.0.1
 */