package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ClipLayout;

class ReadInjoyIMAXAdFragment$3
  implements ValueAnimator.AnimatorUpdateListener
{
  ReadInjoyIMAXAdFragment$3(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2 = paramValueAnimator.getAnimatedFraction();
    ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setAlpha(f2 * 0.5F + 0.5F);
    if (f2 <= 0.26F) {
      ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).a(ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment), ReadInjoyIMAXAdFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment), ReadInjoyIMAXAdFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment), ReadInjoyIMAXAdFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment));
    }
    float f1;
    while (f2 <= 0.22F)
    {
      ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setVisibility(0);
      f1 = 0.97F - f2 / 0.22F * 0.4F;
      ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setScaleX(f1);
      ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setScaleY(f1);
      ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setAlpha(f1);
      return;
      if (f2 <= 0.866F) {
        ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).a((int)(ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment) * (1.0F - f2 / 0.866F)), (int)(ReadInjoyIMAXAdFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment) * (1.0F - f2)), (int)(ReadInjoyIMAXAdFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment) + (this.jdField_a_of_type_Int - ReadInjoyIMAXAdFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment)) * (f2 / 0.866F)), (int)(ReadInjoyIMAXAdFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment) + (this.b - ReadInjoyIMAXAdFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment)) * f2));
      } else {
        ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).a(0, (int)(ReadInjoyIMAXAdFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment) * (1.0F - f2)), this.jdField_a_of_type_Int, (int)(ReadInjoyIMAXAdFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment) + (this.b - ReadInjoyIMAXAdFragment.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment)) * f2));
      }
    }
    if (f2 <= 2.0F * 0.22F)
    {
      f1 = (f2 - 0.22F) / 0.22F;
      f2 = (f2 - 0.22F) / 0.22F * 0.3F + 0.5700001F;
      ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setScaleX(f2);
      ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setScaleY(f2);
      ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setAlpha(0.5700001F - 0.3F * f1);
      return;
    }
    if (f2 <= 0.68F)
    {
      f1 = (f2 - 0.52F) / 0.16F;
      ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setAlpha(0.4F - f1 * 0.4F);
      return;
    }
    ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setAlpha(0.0F);
    ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.3
 * JD-Core Version:    0.7.0.1
 */