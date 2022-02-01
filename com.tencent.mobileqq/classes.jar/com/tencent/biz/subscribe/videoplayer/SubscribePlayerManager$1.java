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
    SubscribePlayerManager.b(this.b).removeCallbacks(SubscribePlayerManager.a(this.b));
    SubscribePlayerManager.a(this.b, true);
    SubscribePlayerManager localSubscribePlayerManager = this.b;
    AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = this.a;
    SubscribePlayerManager.a(localSubscribePlayerManager, localAutoVideoMsgViewHolder, localAutoVideoMsgViewHolder.l);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.1
 * JD-Core Version:    0.7.0.1
 */