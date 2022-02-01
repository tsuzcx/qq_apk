package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyAddFriendHelper$1
  implements View.OnClickListener
{
  NearbyAddFriendHelper$1(NearbyAddFriendHelper paramNearbyAddFriendHelper) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer))
    {
      String str = this.a.e.b;
      if (this.a.e.a == 1006) {
        str = this.a.e.g;
      }
      NearbyAddFriendHelper.a(this.a, (Integer)localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyAddFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */