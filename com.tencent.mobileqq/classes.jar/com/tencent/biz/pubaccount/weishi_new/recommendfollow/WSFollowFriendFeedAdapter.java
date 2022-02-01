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
  
  public Activity a()
  {
    WSFollowAdapter localWSFollowAdapter = this.a;
    if (localWSFollowAdapter != null) {
      return localWSFollowAdapter.f();
    }
    return null;
  }
  
  public void a(BaseViewHolder<WSFriendItemData> paramBaseViewHolder)
  {
    super.onViewAttachedToWindow(paramBaseViewHolder);
    boolean bool = paramBaseViewHolder instanceof WSFollowFriendFeedHolder;
    if (bool)
    {
      WSFollowAdapter localWSFollowAdapter = this.a;
      if ((localWSFollowAdapter != null) && (localWSFollowAdapter.g().getUserVisibleHint()) && (this.a.g().isResumed())) {
        ((WSFollowFriendFeedHolder)paramBaseViewHolder).b();
      }
    }
    if (bool) {
      ((WSFollowFriendFeedHolder)paramBaseViewHolder).a();
    }
  }
  
  public void b(BaseViewHolder<WSFriendItemData> paramBaseViewHolder)
  {
    super.onViewDetachedFromWindow(paramBaseViewHolder);
    paramBaseViewHolder.onViewDetachedFromWindow();
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
  
  public void onBindCustomViewHolder(BaseViewHolder<WSFriendItemData> paramBaseViewHolder, int paramInt)
  {
    WSFriendItemData localWSFriendItemData = (WSFriendItemData)getItem(paramInt);
    if (localWSFriendItemData == null) {
      return;
    }
    if ((paramBaseViewHolder instanceof WSFollowFriendFeedHolder)) {
      ((WSFollowFriendFeedHolder)paramBaseViewHolder).a(localWSFriendItemData, paramInt);
    }
  }
  
  public BaseViewHolder<WSFriendItemData> onCreateCustomViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return WSFollowFriendFeedHolder.a(paramViewGroup, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedAdapter
 * JD-Core Version:    0.7.0.1
 */