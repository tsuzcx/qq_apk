package com.tencent.mobileqq.activity.qwallet;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RedPacketKSongFragment$1
  implements View.OnClickListener
{
  RedPacketKSongFragment$1(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.b.setVisibility(8);
    this.a.a.setVisibility(8);
    RedPacketKSongFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.1
 * JD-Core Version:    0.7.0.1
 */