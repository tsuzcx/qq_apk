package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyTabAdapter$1
  implements View.OnClickListener
{
  ReadInJoyTabAdapter$1(ReadInJoyTabAdapter paramReadInJoyTabAdapter, TabChannelCoverInfo paramTabChannelCoverInfo1, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo2, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyTabAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo);
    if (ReadInJoyTabAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter) != null) {
      ReadInJoyTabAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyTabAdapter).a(this.jdField_a_of_type_Int);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.b;
    int j = ChannelCoverView.b;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {}
    for (int i = 1;; i = 0)
    {
      ChannelCoverView.a("0X8009496", localTabChannelCoverInfo, j, i, this.jdField_a_of_type_Int);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyTabAdapter.1
 * JD-Core Version:    0.7.0.1
 */