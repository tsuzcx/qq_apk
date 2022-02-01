package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public class WSFollowFriendFeedAdapter
  extends BaseAdapter<WSFriendItemData, BaseViewHolder<WSFriendItemData>>
{
  private WSFollowAdapter a;
  
  public WSFollowFriendFeedAdapter(Context paramContext, WSFollowAdapter paramWSFollowAdapter)
  {
    super(paramContext);
    this.a = paramWSFollowAdapter;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public Activity a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public BaseViewHolder<WSFriendItemData> a(ViewGroup paramViewGroup, int paramInt)
  {
    return WSFollowFriendFeedHolder.a(paramViewGroup, this);
  }
  
  public void a(BaseViewHolder<WSFriendItemData> paramBaseViewHolder)
  {
    super.onViewAttachedToWindow(paramBaseViewHolder);
    if (((paramBaseViewHolder instanceof WSFollowFriendFeedHolder)) && (this.a != null) && (this.a.a().getUserVisibleHint()) && (this.a.a().isResumed())) {
      ((WSFollowFriendFeedHolder)paramBaseViewHolder).b();
    }
    if ((paramBaseViewHolder instanceof WSFollowFriendFeedHolder)) {
      ((WSFollowFriendFeedHolder)paramBaseViewHolder).a();
    }
  }
  
  public void a(BaseViewHolder<WSFriendItemData> paramBaseViewHolder, int paramInt)
  {
    WSFriendItemData localWSFriendItemData = (WSFriendItemData)a(paramInt);
    if (localWSFriendItemData == null) {}
    while (!(paramBaseViewHolder instanceof WSFollowFriendFeedHolder)) {
      return;
    }
    ((WSFollowFriendFeedHolder)paramBaseViewHolder).a(localWSFriendItemData, paramInt);
  }
  
  public void b(BaseViewHolder<WSFriendItemData> paramBaseViewHolder)
  {
    super.onViewDetachedFromWindow(paramBaseViewHolder);
    paramBaseViewHolder.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedAdapter
 * JD-Core Version:    0.7.0.1
 */