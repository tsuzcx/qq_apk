package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedAdapter;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.widget.pull2refresh.BaseAdapter.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

class WSFollowFriendCollectionHolder$1
  implements BaseAdapter.OnItemClickListener
{
  WSFollowFriendCollectionHolder$1(WSFollowFriendCollectionHolder paramWSFollowFriendCollectionHolder) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((WSFollowFriendCollectionHolder.a(this.a) == null) || (WSFollowFriendCollectionHolder.a(this.a).b() == null) || (paramInt >= WSFollowFriendCollectionHolder.a(this.a).b().size())) {}
    do
    {
      return;
      paramView = (WSFriendItemData)WSFollowFriendCollectionHolder.a(this.a).b().get(paramInt);
    } while (paramView == null);
    WSVerticalPageFragment.a(WSFollowFriendCollectionHolder.a(this.a), "friend_feed", "friend", null, paramView.b() + 1);
    WSFollowBeaconReport.a(paramInt + 1, 1000001, (stSimpleMetaFeed)((ArrayList)paramView.a()).get(0), paramView.a(), paramView.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFriendCollectionHolder.1
 * JD-Core Version:    0.7.0.1
 */