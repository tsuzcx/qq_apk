package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnSubRegionClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.GameLiveInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.liveroom.LiveRoomProxyActivity;

class UgcProteusItem$2
  implements View.OnClickListener
{
  UgcProteusItem$2(UgcProteusItem paramUgcProteusItem, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 120) {
      LiveRoomProxyActivity.open(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.a.c, "kandian feed click");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      OnSubRegionClickListener localOnSubRegionClickListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().a();
      if (localOnSubRegionClickListener != null) {
        localOnSubRegionClickListener.a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a(), 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.UgcProteusItem.2
 * JD-Core Version:    0.7.0.1
 */