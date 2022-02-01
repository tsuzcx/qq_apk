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
    return new int[] { 15, 9, 7, 12 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 7)
    {
      if (paramInt != 12)
      {
        if (paramInt != 15) {
          return;
        }
        SubscribePlayerManager.a().d();
        return;
      }
      SubscribePlayerManager.a().c();
      return;
    }
    SubscribePlayerManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.WeiShiSubScribeHelper
 * JD-Core Version:    0.7.0.1
 */