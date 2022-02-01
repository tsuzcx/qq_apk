package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSFollowFriendFeedHolder$1
  implements View.OnClickListener
{
  WSFollowFriendFeedHolder$1(WSFollowFriendFeedHolder paramWSFollowFriendFeedHolder) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.a(WSFollowFriendFeedHolder.a(this.a))) {
      ToastUtil.a().a(2131720723);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      WSFollowFriendFeedHolder.a(this.a);
      WSFollowBeaconReport.b(WSFollowFriendFeedHolder.a(this.a) + 1, 1004001, WSFollowFriendFeedHolder.a(this.a), WSFollowFriendFeedHolder.a(this.a).a(), WSFollowFriendFeedHolder.a(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder.1
 * JD-Core Version:    0.7.0.1
 */