package com.tencent.biz.subscribe.videoplayer;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.AutoVideoItemBuilder.AutoVideoMsgViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribePlayerManager$1
  implements View.OnClickListener
{
  SubscribePlayerManager$1(SubscribePlayerManager paramSubscribePlayerManager, AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder) {}
  
  public void onClick(View paramView)
  {
    SubscribePlayerManager.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager).removeCallbacks(SubscribePlayerManager.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager));
    SubscribePlayerManager.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager, true);
    SubscribePlayerManager localSubscribePlayerManager = this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager;
    AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAutoVideoItemBuilder$AutoVideoMsgViewHolder;
    SubscribePlayerManager.a(localSubscribePlayerManager, localAutoVideoMsgViewHolder, localAutoVideoMsgViewHolder.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.1
 * JD-Core Version:    0.7.0.1
 */