package com.tencent.avgame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVGameRoomCenterFragment$2
  implements View.OnClickListener
{
  AVGameRoomCenterFragment$2(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  public void onClick(View paramView)
  {
    AVGameRoomCenterFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomCenterFragment.2
 * JD-Core Version:    0.7.0.1
 */