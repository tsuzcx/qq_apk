package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoCoverView$1
  implements View.OnClickListener
{
  VideoCoverView$1(VideoCoverView paramVideoCoverView, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.b(this.jdField_a_of_type_AndroidContentContext);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.1
 * JD-Core Version:    0.7.0.1
 */