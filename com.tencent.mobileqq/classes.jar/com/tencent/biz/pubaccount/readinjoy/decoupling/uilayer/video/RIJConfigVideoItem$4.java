package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoColumnItemViewHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class RIJConfigVideoItem$4
  implements View.OnClickListener
{
  RIJConfigVideoItem$4(String paramString, BigImgVideoColumnItemViewHolder paramBigImgVideoColumnItemViewHolder) {}
  
  public void onClick(View paramView)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.jdField_a_of_type_JavaLangString, false);
    VideoHandler.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoViewholderBigImgVideoColumnItemViewHolder.g);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJConfigVideoItem.4
 * JD-Core Version:    0.7.0.1
 */