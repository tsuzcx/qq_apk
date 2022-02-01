package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyAddFriendHelper$4
  implements View.OnClickListener
{
  NearbyAddFriendHelper$4(NearbyAddFriendHelper paramNearbyAddFriendHelper) {}
  
  public void onClick(View paramView)
  {
    NearbyAddFriendHelper.g(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyAddFriendHelper.4
 * JD-Core Version:    0.7.0.1
 */