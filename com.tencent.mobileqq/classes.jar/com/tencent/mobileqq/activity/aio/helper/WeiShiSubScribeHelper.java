package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager;
import com.tencent.mobileqq.activity.aio.item.AutoVideoItemBuilder.AutoVideoMsgViewHolder;
import com.tencent.widget.AbsListView;

public class WeiShiSubScribeHelper
  implements ILifeCycleHelper
{
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    SubscribePlayerManager.a().a(paramAbsListView, paramInt);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    SubscribePlayerManager.a().a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(Object paramObject)
  {
    if (AutoVideoItemBuilder.AutoVideoMsgViewHolder.class.isInstance(paramObject)) {
      SubscribePlayerManager.a().a((AutoVideoItemBuilder.AutoVideoMsgViewHolder)paramObject);
    }
  }
  
  public String getTag()
  {
    return "WeiShiSubScribeHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14, 8, 6, 11 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      SubscribePlayerManager.a().a();
      return;
    case 11: 
      SubscribePlayerManager.a().b();
      return;
    }
    SubscribePlayerManager.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.WeiShiSubScribeHelper
 * JD-Core Version:    0.7.0.1
 */