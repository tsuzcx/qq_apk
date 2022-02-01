package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.gdtad.aditem.GdtAd;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class GdtAdWSVerticalVideoItemView$3
  implements Runnable
{
  GdtAdWSVerticalVideoItemView$3(GdtAdWSVerticalVideoItemView paramGdtAdWSVerticalVideoItemView) {}
  
  public void run()
  {
    AdExposureChecker localAdExposureChecker = new AdExposureChecker(null, new WeakReference(this.this$0.jdField_a_of_type_AndroidViewView));
    if ((GdtAdWSVerticalVideoItemView.a(this.this$0) instanceof WSVerticalItemData))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = GdtAdWSVerticalVideoItemView.a(this.this$0).a();
      if ((localstSimpleMetaFeed instanceof stSimpleMetaFeed))
      {
        localstSimpleMetaFeed = (stSimpleMetaFeed)localstSimpleMetaFeed;
        stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = GdtAdWSVerticalVideoItemView.a(this.this$0).a();
        if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null))
        {
          if ((localstSimpleMetaGdtAdInfo != null) && (!localstSimpleMetaGdtAdInfo.isGdtAdOriginalImpressionReport))
          {
            GdtAdUtil.b(this.this$0.jdField_a_of_type_AndroidContentContext, GdtAdWSVerticalVideoItemView.a(this.this$0));
            localstSimpleMetaGdtAdInfo.isGdtAdOriginalImpressionReport = true;
          }
          localAdExposureChecker = new AdExposureChecker(new GdtAd(GdtAdUtil.a(localstSimpleMetaFeed)), new WeakReference(this.this$0.jdField_a_of_type_AndroidViewView));
          if (this.this$0.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
            this.this$0.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new GdtAdWSVerticalVideoItemView.3.1(this);
          }
          localAdExposureChecker.setCallback(new WeakReference(this.this$0.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
          QZLog.w("AdExposureChecker", "startonExposure");
          this.this$0.jdField_a_of_type_JavaUtilArrayList.add(localAdExposureChecker);
        }
      }
    }
    for (;;)
    {
      localAdExposureChecker.startCheck();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalVideoItemView.3
 * JD-Core Version:    0.7.0.1
 */