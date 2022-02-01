package com.tencent.avgame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVGameJoinRoomFragment$2
  implements View.OnClickListener
{
  AVGameJoinRoomFragment$2(AVGameJoinRoomFragment paramAVGameJoinRoomFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getQBaseActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameJoinRoomFragment.2
 * JD-Core Version:    0.7.0.1
 */