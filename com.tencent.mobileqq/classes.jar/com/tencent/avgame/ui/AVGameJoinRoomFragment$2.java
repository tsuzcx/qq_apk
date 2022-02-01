package com.tencent.avgame.ui;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVGameJoinRoomFragment$2
  implements View.OnClickListener
{
  AVGameJoinRoomFragment$2(AVGameJoinRoomFragment paramAVGameJoinRoomFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameJoinRoomFragment.2
 * JD-Core Version:    0.7.0.1
 */