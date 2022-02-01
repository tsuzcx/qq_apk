package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnSubRegionClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FeedItemCellTypePgcSmall$1
  implements View.OnClickListener
{
  FeedItemCellTypePgcSmall$1(FeedItemCellTypePgcSmall paramFeedItemCellTypePgcSmall) {}
  
  public void onClick(View paramView)
  {
    OnSubRegionClickListener localOnSubRegionClickListener = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().a();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(null, ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypePgcSmall.1
 * JD-Core Version:    0.7.0.1
 */