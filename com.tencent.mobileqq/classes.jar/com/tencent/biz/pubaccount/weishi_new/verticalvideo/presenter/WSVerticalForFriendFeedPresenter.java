package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
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
  private int a;
  
  public WSVerticalForFriendFeedPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    paramArrayList = new ArrayList();
    Iterator localIterator = WeiShiCacheManager.a().e().iterator();
    while (localIterator.hasNext()) {
      paramArrayList.addAll((Collection)((WSFriendItemData)localIterator.next()).b());
    }
    paramArrayList = WSVerticalUtils.a(paramArrayList);
    if (paramArrayList != null) {
      this.a = paramArrayList.size();
    }
    return paramArrayList;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    paramViewHolder = WeiShiCacheManager.a().e();
    if (z() != null)
    {
      int j = this.a;
      int i = paramInt;
      if (paramInt >= j) {
        i = j - 1;
      }
      paramInt = 0;
      while (paramInt < paramViewHolder.size())
      {
        WSFriendItemData localWSFriendItemData = (WSFriendItemData)paramViewHolder.get(paramInt);
        if ((localWSFriendItemData.e() <= i) && (localWSFriendItemData.e() + localWSFriendItemData.d() > i))
        {
          localWSFriendItemData.a(true);
          paramViewHolder = new WSFriendFeedExposureEvent(c(i), paramInt);
          WSSimpleEventBus.a().a(paramViewHolder);
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    WSFriendFeedDataManager.a().a(paramBoolean2, paramBoolean1, this);
    return true;
  }
  
  public void destroy()
  {
    super.destroy();
    WSFriendFeedDataManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForFriendFeedPresenter
 * JD-Core Version:    0.7.0.1
 */