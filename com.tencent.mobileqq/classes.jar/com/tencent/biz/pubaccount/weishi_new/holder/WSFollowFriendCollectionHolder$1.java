package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedAdapter;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.widget.pull2refresh.BaseAdapter.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

class WSFollowFriendCollectionHolder$1
  implements BaseAdapter.OnItemClickListener
{
  WSFollowFriendCollectionHolder$1(WSFollowFriendCollectionHolder paramWSFollowFriendCollectionHolder) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    if ((WSFollowFriendCollectionHolder.a(this.a) != null) && (WSFollowFriendCollectionHolder.a(this.a).getDataList() != null))
    {
      if (paramInt >= WSFollowFriendCollectionHolder.a(this.a).getDataList().size()) {
        return;
      }
      paramView = (WSFriendItemData)WSFollowFriendCollectionHolder.a(this.a).getDataList().get(paramInt);
      if (paramView == null) {
        return;
      }
      WSLauncher.VerticalPageLauncher.a(new WSVerticalPageOpenParams(WSFollowFriendCollectionHolder.b(this.a), "friend_feed", "friend").a(paramView.e() + 1));
      WSFollowBeaconReport.a(paramInt + 1, 1000001, (stSimpleMetaFeed)((ArrayList)paramView.b()).get(0), paramView.c(), paramView.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFriendCollectionHolder.1
 * JD-Core Version:    0.7.0.1
 */