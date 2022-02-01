package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoySocializeRecommendFollowView$ViewHolder
  implements View.OnClickListener
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RecommendFollowInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  private ReadInJoySocializeRecommendFollowView$ViewHolder(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadInJoySocializeRecommendFollowView localReadInJoySocializeRecommendFollowView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView;
      RecommendFollowInfo localRecommendFollowInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.isFollowed) {}
      for (boolean bool = true;; bool = false)
      {
        localReadInJoySocializeRecommendFollowView.a(localRecommendFollowInfo, bool);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X800984A", "0X800984A", 0, 0, "1", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.uin + "", "", "", false);
        break;
      }
      ReadInJoySocializeRecommendFollowView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X8009849", "0X8009849", 0, 0, "1", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.uin + "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.ViewHolder
 * JD-Core Version:    0.7.0.1
 */