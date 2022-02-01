package com.tencent.biz.pubaccount.readinjoy.viola;

import android.os.Bundle;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;

class ViolaFragment$11
  implements IServiceInfo
{
  ViolaFragment$11(ViolaFragment paramViolaFragment, Bundle paramBundle) {}
  
  public ColorNote getColorNote()
  {
    if (ViolaFragment.access$300(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment) != null) {
      return ViolaFragment.access$300(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment).a();
    }
    ViolaFragment.access$302(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment, new ViolaColorNote(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getUrl()).a(this.jdField_a_of_type_AndroidOsBundle.getString("param")).a(this.jdField_a_of_type_AndroidOsBundle.getBoolean("useTransParentFragment")).a(ViolaFragment.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment)));
    return ViolaFragment.access$300(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.11
 * JD-Core Version:    0.7.0.1
 */