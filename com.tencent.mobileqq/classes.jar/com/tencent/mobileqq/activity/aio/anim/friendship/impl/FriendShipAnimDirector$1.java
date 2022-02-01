package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendShipAnimDirector$1
  implements View.OnClickListener
{
  FriendShipAnimDirector$1(FriendShipAnimDirector paramFriendShipAnimDirector) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.FriendShipAnimDirector.1
 * JD-Core Version:    0.7.0.1
 */