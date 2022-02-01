package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSFriendFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class WSVerticalForFriendFeedPresenter
  extends AbsWSVerticalPagePresenter
{
  private int b;
  
  public WSVerticalForFriendFeedPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    paramArrayList = new ArrayList();
    Iterator localIterator = WeiShiCacheManager.a().a().iterator();
    while (localIterator.hasNext()) {
      paramArrayList.addAll((Collection)((WSFriendItemData)localIterator.next()).a());
    }
    paramArrayList = WSVerticalUtils.a(paramArrayList);
    if (paramArrayList != null) {
      this.b = paramArrayList.size();
    }
    return paramArrayList;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    paramViewHolder = WeiShiCacheManager.a().a();
    WSVerticalPageContract.View localView = a();
    int i;
    if (localView != null)
    {
      i = paramInt;
      if (paramInt >= this.b) {
        i = this.b - 1;
      }
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < paramViewHolder.size())
      {
        WSFriendItemData localWSFriendItemData = (WSFriendItemData)paramViewHolder.get(paramInt);
        if ((localWSFriendItemData.b() <= i) && (localWSFriendItemData.b() + localWSFriendItemData.a() > i))
        {
          localWSFriendItemData.a(true);
          paramViewHolder = new WSFriendFeedExposureEvent(((WSVerticalItemData)localView.a().a(i)).a(), paramInt);
          WSSimpleEventBus.a().a(paramViewHolder);
        }
      }
      else
      {
        return;
      }
      paramInt += 1;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    WSFriendFeedDataManager.a().a(paramBoolean2, paramBoolean1, this);
    return true;
  }
  
  public void d()
  {
    super.d();
    WSFriendFeedDataManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForFriendFeedPresenter
 * JD-Core Version:    0.7.0.1
 */