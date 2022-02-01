package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish;

public class FeedItemCellTypeNewPolymericHeaderPgc
  extends FeedItemCellTypeNewPolymericBaseHeader
{
  protected void a(LinearLayout paramLinearLayout)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
      paramLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish);
    }
  }
  
  protected FeedItemCell v()
  {
    return c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
  }
  
  protected FeedItemCell w()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeNewPolymericHeaderPgc
 * JD-Core Version:    0.7.0.1
 */