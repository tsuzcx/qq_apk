package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.open.base.ToastUtil;

class WSFollowFriendFeedHolder$1
  implements View.OnClickListener
{
  WSFollowFriendFeedHolder$1(WSFollowFriendFeedHolder paramWSFollowFriendFeedHolder) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.a(WSFollowFriendFeedHolder.a(this.a)))
    {
      ToastUtil.a().a(2131918123);
      return;
    }
    WSFollowFriendFeedHolder.b(this.a);
    WSFollowBeaconReport.b(WSFollowFriendFeedHolder.c(this.a) + 1, 1004001, WSFollowFriendFeedHolder.d(this.a), WSFollowFriendFeedHolder.e(this.a).c(), WSFollowFriendFeedHolder.e(this.a).d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder.1
 * JD-Core Version:    0.7.0.1
 */