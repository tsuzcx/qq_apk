package com.tencent.biz.pubaccount.readinjoy.viola;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ViolaFragment$2
  implements View.OnClickListener
{
  ViolaFragment$2(ViolaFragment paramViolaFragment, Bundle paramBundle, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.mViolaUiDelegate.d();
    ViolaFragment.access$000(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidViewViewGroup);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.2
 * JD-Core Version:    0.7.0.1
 */