package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import java.util.List;

public class WSVerticalPageEventHandler
{
  private void a(RecyclerView paramRecyclerView, WSVerticalPageEventHandler.OnLoopHandle<WSVerticalVideoHolder> paramOnLoopHandle)
  {
    if (paramRecyclerView == null) {
      return;
    }
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if ((paramOnLoopHandle != null) && ((localViewHolder instanceof WSVerticalVideoHolder))) {
        paramOnLoopHandle.a((WSVerticalVideoHolder)localViewHolder);
      }
      i += 1;
    }
  }
  
  private void a(String paramString, RecyclerView paramRecyclerView)
  {
    a(paramRecyclerView, new WSVerticalPageEventHandler.1(this, paramString));
  }
  
  private void b(String paramString, RecyclerView paramRecyclerView)
  {
    a(paramRecyclerView, new WSVerticalPageEventHandler.2(this, paramString));
  }
  
  private void c(String paramString, RecyclerView paramRecyclerView)
  {
    a(paramRecyclerView, new WSVerticalPageEventHandler.3(this, paramString));
  }
  
  protected stSimpleMetaFeed a(WSVerticalItemData paramWSVerticalItemData)
  {
    if (paramWSVerticalItemData != null)
    {
      paramWSVerticalItemData = paramWSVerticalItemData.b();
      if (paramWSVerticalItemData != null) {
        return paramWSVerticalItemData;
      }
    }
    return null;
  }
  
  public void a(FollowEvent paramFollowEvent, List<WSVerticalItemData> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (WSVerticalItemData)paramList.get(i);
      if ((localObject != null) && (((WSVerticalItemData)localObject).b() != null) && (((WSVerticalItemData)localObject).b().poster != null))
      {
        localObject = ((WSVerticalItemData)localObject).b().poster;
        if (TextUtils.equals(((stSimpleMetaPerson)localObject).id, paramFollowEvent.getPersonId())) {
          ((stSimpleMetaPerson)localObject).followStatus = paramFollowEvent.getIsFollow();
        }
      }
      i += 1;
    }
  }
  
  public void a(LikeRspEvent paramLikeRspEvent, List<WSVerticalItemData> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.get(i);
      if ((localWSVerticalItemData != null) && (localWSVerticalItemData.b() != null) && (TextUtils.equals(paramLikeRspEvent.getFeedId(), localWSVerticalItemData.b().id)))
      {
        if (paramLikeRspEvent.getRspIsDing() != localWSVerticalItemData.b().is_ding)
        {
          int j;
          if (localWSVerticalItemData.b().is_ding == 1) {
            j = 1;
          } else {
            j = 0;
          }
          stSimpleMetaFeed localstSimpleMetaFeed;
          if (j != 0)
          {
            localstSimpleMetaFeed = localWSVerticalItemData.b();
            localstSimpleMetaFeed.ding_count -= 1;
          }
          else
          {
            localstSimpleMetaFeed = localWSVerticalItemData.b();
            localstSimpleMetaFeed.ding_count += 1;
          }
        }
        localWSVerticalItemData.b().is_ding = paramLikeRspEvent.getRspIsDing();
      }
      i += 1;
    }
  }
  
  public void a(WSAddCommentEvent paramWSAddCommentEvent, List<WSVerticalItemData> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.get(i);
      if ((localWSVerticalItemData != null) && (localWSVerticalItemData.b() != null) && (TextUtils.equals(paramWSAddCommentEvent.getFeedId(), localWSVerticalItemData.b().id)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSVerticalPageEventHandler.java][handleOnReceiveEventForComment] data.getItemInfo().total_comment_num:");
        localStringBuilder.append(localWSVerticalItemData.b().total_comment_num);
        localStringBuilder.append(", wsAddCommentEvent.getCommentNum():");
        localStringBuilder.append(paramWSAddCommentEvent.getCommentNum());
        WSLog.g("WSVerticalEventHandlerLog", localStringBuilder.toString());
        localWSVerticalItemData.b().total_comment_num = ((int)paramWSAddCommentEvent.getCommentNum());
      }
      i += 1;
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent, WSVerticalPageContract.View paramView)
  {
    WSLog.e("WSVerticalEventHandlerLog", "[WSVerticalPageEventHandler.java][handleOnReceiveEventForLike]");
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    if (paramView == null) {
      return;
    }
    WSVerticalPageAdapter localWSVerticalPageAdapter = paramView.b();
    if (localWSVerticalPageAdapter != null)
    {
      if (localWSVerticalPageAdapter.getDataList() == null) {
        return;
      }
      a(paramWSSimpleBaseEvent, localWSVerticalPageAdapter.getDataList());
      a(paramWSSimpleBaseEvent.getFeedId(), paramView.c());
    }
  }
  
  public void b(WSSimpleBaseEvent paramWSSimpleBaseEvent, WSVerticalPageContract.View paramView)
  {
    WSLog.e("WSVerticalEventHandlerLog", "[WSVerticalPageEventHandler.java][handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    if (paramView == null) {
      return;
    }
    WSVerticalPageAdapter localWSVerticalPageAdapter = paramView.b();
    if (localWSVerticalPageAdapter != null)
    {
      if (localWSVerticalPageAdapter.getDataList() == null) {
        return;
      }
      a(paramWSSimpleBaseEvent, localWSVerticalPageAdapter.getDataList());
      b(paramWSSimpleBaseEvent.getPersonId(), paramView.c());
    }
  }
  
  public void c(WSSimpleBaseEvent paramWSSimpleBaseEvent, WSVerticalPageContract.View paramView)
  {
    WSLog.e("WSVerticalEventHandlerLog", "[WSVerticalPageEventHandler.java][handleOnReceiveEventForComment]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    if (paramView == null) {
      return;
    }
    WSVerticalPageAdapter localWSVerticalPageAdapter = paramView.b();
    if (localWSVerticalPageAdapter != null)
    {
      if (localWSVerticalPageAdapter.getDataList() == null) {
        return;
      }
      a(paramWSSimpleBaseEvent, localWSVerticalPageAdapter.getDataList());
      c(paramWSSimpleBaseEvent.getFeedId(), paramView.c());
    }
  }
  
  public void d(@NonNull WSSimpleBaseEvent paramWSSimpleBaseEvent, WSVerticalPageContract.View paramView)
  {
    WSLog.e("WSVerticalEventHandlerLog", "[WSVerticalPageEventHandler.java][handleOnReceiveEventForClear]");
    if (paramView != null)
    {
      VideoFeedsRecyclerView localVideoFeedsRecyclerView = paramView.c();
      if (localVideoFeedsRecyclerView != null)
      {
        paramView = paramView.b();
        if (paramView == null) {
          return;
        }
        boolean bool = ((WSClearModeEvent)paramWSSimpleBaseEvent).isClearMode();
        paramView.a(bool);
        a(localVideoFeedsRecyclerView, new WSVerticalPageEventHandler.4(this, bool));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageEventHandler
 * JD-Core Version:    0.7.0.1
 */