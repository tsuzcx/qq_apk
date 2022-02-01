package com.tencent.biz.pubaccount.NativeAd.module;

import android.view.View;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import java.net.URL;

class AdModuleSinglePic$1
  implements IPublicAccountImageDownListener
{
  AdModuleSinglePic$1(AdModuleSinglePic paramAdModuleSinglePic, View paramView, ResizeURLImageView paramResizeURLImageView) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleSinglePic.a = 2;
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370364).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setPublicAccountImageDownListener(null);
    AdModuleSinglePic.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleSinglePic, null);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleSinglePic.a = 3;
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370364).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131366458).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131366458).setOnClickListener(new AdModuleSinglePic.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleSinglePic.1
 * JD-Core Version:    0.7.0.1
 */