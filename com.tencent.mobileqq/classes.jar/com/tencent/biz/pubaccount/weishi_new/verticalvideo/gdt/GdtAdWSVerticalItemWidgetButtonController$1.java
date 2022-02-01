package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.qflutter.utils.FLog;
import java.lang.ref.WeakReference;

class GdtAdWSVerticalItemWidgetButtonController$1
  implements AdExposureChecker.ExposureCallback
{
  GdtAdWSVerticalItemWidgetButtonController$1(GdtAdWSVerticalItemWidgetButtonController paramGdtAdWSVerticalItemWidgetButtonController) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    FLog.e("AdExposureChecker", "onExposure");
    GdtAdUtil.a(GdtAdWSVerticalItemWidgetButtonController.a(this.a), (WSVerticalItemData)this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemWidgetButtonController.1
 * JD-Core Version:    0.7.0.1
 */