package com.tencent.avgame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVGameRoomCenterFragment$1
  implements View.OnClickListener
{
  AVGameRoomCenterFragment$1(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomCenterFragment.1
 * JD-Core Version:    0.7.0.1
 */