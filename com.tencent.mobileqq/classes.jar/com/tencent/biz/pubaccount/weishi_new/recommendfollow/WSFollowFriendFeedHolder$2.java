package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSFollowFriendFeedHolder$2
  implements View.OnClickListener
{
  WSFollowFriendFeedHolder$2(WSFollowFriendFeedHolder paramWSFollowFriendFeedHolder) {}
  
  public void onClick(View paramView)
  {
    WSFollowFriendFeedHolder.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder.2
 * JD-Core Version:    0.7.0.1
 */