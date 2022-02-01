package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelectPositionFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChannelTopPositionView$1
  implements View.OnClickListener
{
  ChannelTopPositionView$1(ChannelTopPositionView paramChannelTopPositionView) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChannelTopPositionView", 2, "onclick");
    }
    if (ChannelTopPositionView.a(this.a) != null) {
      PublicFragmentActivity.a(ChannelTopPositionView.a(this.a), ReadInJoySelectPositionFragment.class);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ChannelTopPositionView.1
 * JD-Core Version:    0.7.0.1
 */