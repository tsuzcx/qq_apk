package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsGlobalConfig;
import UserGrowth.stFriendFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSPlayerMuteEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFriendCollectionHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowPersonHolder;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSFollowView;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSRecommendFollowHolder;
import com.tencent.biz.pubaccount.weishi_new.util.WSLoadMoreReportHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class WSFollowPresenter
  extends WSBasePresenter<IWSFollowView>
{
  private int a = 0;
  private stFollowFeedsGlobalConfig b;
  private WSLoadMoreReportHelper c = new WSLoadMoreReportHelper("focus");
  
  private void a(RecyclerView paramRecyclerView, String paramString)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      stSimpleMetaPerson localstSimpleMetaPerson;
      if ((localObject instanceof WSRecommendFollowHolder))
      {
        localObject = (WSRecommendFollowHolder)localObject;
        localstSimpleMetaPerson = ((WSRecommendFollowHolder)localObject).b();
        if ((localstSimpleMetaPerson != null) && (TextUtils.equals(localstSimpleMetaPerson.id, paramString))) {
          ((WSRecommendFollowHolder)localObject).a();
        }
      }
      else if ((localObject instanceof WSFollowFriendFeedHolder))
      {
        localObject = (WSFollowFriendFeedHolder)localObject;
        localstSimpleMetaPerson = ((WSFollowFriendFeedHolder)localObject).c();
        if ((localstSimpleMetaPerson != null) && (TextUtils.equals(localstSimpleMetaPerson.id, paramString))) {
          ((WSFollowFriendFeedHolder)localObject).d();
        }
      }
      i += 1;
    }
  }
  
  private void a(FollowEvent paramFollowEvent, stFeed paramstFeed)
  {
    if ((paramstFeed.friendFeed != null) && (paramstFeed.friendFeed.friendFeeds != null))
    {
      paramstFeed = paramstFeed.friendFeed.friendFeeds;
      int i = 0;
      while (i < paramstFeed.size())
      {
        stSimpleMetaPerson localstSimpleMetaPerson = ((stSimpleMetaFeed)paramstFeed.get(i)).poster;
        if ((localstSimpleMetaPerson != null) && (TextUtils.equals(localstSimpleMetaPerson.id, paramFollowEvent.getPersonId())))
        {
          localstSimpleMetaPerson.followStatus = paramFollowEvent.getIsFollow();
          a(localstSimpleMetaPerson.id);
        }
        i += 1;
      }
    }
  }
  
  private void a(String paramString)
  {
    if (getView() != null)
    {
      if (((IWSFollowView)getView()).y() == null) {
        return;
      }
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((IWSFollowView)getView()).y().getRecyclerView();
      if (localRecyclerViewWithHeaderFooter == null) {
        return;
      }
      int j = localRecyclerViewWithHeaderFooter.getChildCount();
      int i = 0;
      while (i < j)
      {
        RecyclerView.ViewHolder localViewHolder = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
        if ((localViewHolder instanceof WSFollowPersonHolder)) {
          a(((WSFollowPersonHolder)localViewHolder).a(), paramString);
        } else if ((localViewHolder instanceof WSFollowFriendCollectionHolder)) {
          a(((WSFollowFriendCollectionHolder)localViewHolder).a(), paramString);
        }
        i += 1;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (getView() != null)
    {
      if (((IWSFollowView)getView()).x() == null) {
        return;
      }
      Iterator localIterator = ((IWSFollowView)getView()).x().a().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (BaseViewHolder)localIterator.next();
        if ((localObject instanceof WSFollowFeedHolder))
        {
          localObject = (WSFollowFeedHolder)localObject;
          ((WSFollowFeedHolder)localObject).a(paramBoolean);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateMuteStatus title:");
          if (((WSFollowFeedHolder)localObject).a != null) {
            localObject = ((WSFollowFeedHolder)localObject).a.g;
          } else {
            localObject = "videoInfo is null!";
          }
          localStringBuilder.append((String)localObject);
          WSLog.e("WSFollowPresenter", localStringBuilder.toString());
        }
      }
    }
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    a(((WSPlayerMuteEvent)paramWSSimpleBaseEvent).isPlayerMute());
  }
  
  private void b(String paramString)
  {
    if (getView() != null)
    {
      if (((IWSFollowView)getView()).y() == null) {
        return;
      }
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((IWSFollowView)getView()).y().getRecyclerView();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof WSFollowFeedHolder))
          {
            localObject = (WSFollowFeedHolder)localObject;
            stFeed localstFeed = ((WSFollowFeedHolder)localObject).i();
            if ((localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.poster != null) && (TextUtils.equals(localstFeed.feed.poster.id, paramString))) {
              ((WSFollowFeedHolder)localObject).h();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void c(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSFriendFeedExposureEvent localWSFriendFeedExposureEvent = (WSFriendFeedExposureEvent)paramWSSimpleBaseEvent;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleOnReceiveEventForFriendFeed event: ");
    if (localWSFriendFeedExposureEvent == null) {
      paramWSSimpleBaseEvent = "null";
    } else {
      paramWSSimpleBaseEvent = Integer.valueOf(localWSFriendFeedExposureEvent.currentPosition);
    }
    ((StringBuilder)localObject).append(paramWSSimpleBaseEvent);
    WSLog.b("WSFollowPresenter", ((StringBuilder)localObject).toString());
    if (localWSFriendFeedExposureEvent != null)
    {
      if (localWSFriendFeedExposureEvent.video == null) {
        return;
      }
      paramWSSimpleBaseEvent = ((IWSFollowView)getView()).x();
      if (paramWSSimpleBaseEvent != null)
      {
        if (paramWSSimpleBaseEvent.getDataList() == null) {
          return;
        }
        paramWSSimpleBaseEvent = ((IWSFollowView)getView()).y();
        if (paramWSSimpleBaseEvent != null)
        {
          if (paramWSSimpleBaseEvent.getRecyclerView() == null) {
            return;
          }
          paramWSSimpleBaseEvent = paramWSSimpleBaseEvent.getRecyclerView();
          int j = paramWSSimpleBaseEvent.getChildCount();
          int i = 0;
          while (i < j)
          {
            localObject = paramWSSimpleBaseEvent.getChildViewHolder(paramWSSimpleBaseEvent.getChildAt(i));
            if ((localObject instanceof WSFollowFriendCollectionHolder))
            {
              paramWSSimpleBaseEvent = ((WSFollowFriendCollectionHolder)localObject).a();
              paramWSSimpleBaseEvent.smoothScrollToPosition(localWSFriendFeedExposureEvent.currentPosition);
              if (paramWSSimpleBaseEvent.getAdapter() == null) {
                break;
              }
              paramWSSimpleBaseEvent.getAdapter().notifyItemChanged(localWSFriendFeedExposureEvent.currentPosition);
              return;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if (getView() != null)
    {
      if (((IWSFollowView)getView()).y() == null) {
        return;
      }
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((IWSFollowView)getView()).y().getRecyclerView();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof WSFollowFeedHolder))
          {
            localObject = (WSFollowFeedHolder)localObject;
            stFeed localstFeed = ((WSFollowFeedHolder)localObject).i();
            if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(localstFeed.feed.id, paramString)))
            {
              WSLog.b("WSFollowPresenter", "updateLikeStatus");
              ((WSFollowFeedHolder)localObject).g();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void d(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject1 = (WSItemExposeEvent)paramWSSimpleBaseEvent;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handleItemExposeEvent event: ");
    if (localObject1 == null) {
      paramWSSimpleBaseEvent = "null";
    } else {
      paramWSSimpleBaseEvent = ((WSItemExposeEvent)localObject1).video;
    }
    ((StringBuilder)localObject2).append(paramWSSimpleBaseEvent);
    WSLog.b("WSFollowPresenter", ((StringBuilder)localObject2).toString());
    if (localObject1 != null)
    {
      if (((WSItemExposeEvent)localObject1).video == null) {
        return;
      }
      paramWSSimpleBaseEvent = ((IWSFollowView)getView()).x();
      if (paramWSSimpleBaseEvent != null)
      {
        if (paramWSSimpleBaseEvent.getDataList() == null) {
          return;
        }
        localObject2 = ((IWSFollowView)getView()).y();
        if (localObject2 != null)
        {
          if (((XRecyclerView)localObject2).getRecyclerView() == null) {
            return;
          }
          localObject1 = ((WSItemExposeEvent)localObject1).video;
          List localList = WSFeedDataManager.a().b;
          if (paramWSSimpleBaseEvent.getDataList().size() < localList.size()) {
            ((IWSFollowView)getView()).a(localList);
          }
          int i = 0;
          while (i < localList.size())
          {
            if (((stFeed)localList.get(i)).feed == localObject1)
            {
              ((XRecyclerView)localObject2).getRecyclerView().scrollToPosition(i);
              this.a = i;
              paramWSSimpleBaseEvent = new StringBuilder();
              paramWSSimpleBaseEvent.append("receive item expose event, position: ");
              paramWSSimpleBaseEvent.append(i);
              paramWSSimpleBaseEvent.append(", feed: ");
              paramWSSimpleBaseEvent.append(((stSimpleMetaFeed)localObject1).feed_desc);
              WSLog.b("WSFollowPresenter", paramWSSimpleBaseEvent.toString());
              return;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void d(String paramString)
  {
    if (getView() != null)
    {
      if (((IWSFollowView)getView()).y() == null) {
        return;
      }
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((IWSFollowView)getView()).y().getRecyclerView();
      if (localRecyclerViewWithHeaderFooter != null)
      {
        int j = localRecyclerViewWithHeaderFooter.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
          if ((localObject instanceof WSFollowFeedHolder))
          {
            localObject = (WSFollowFeedHolder)localObject;
            stFeed localstFeed = ((WSFollowFeedHolder)localObject).i();
            if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(localstFeed.feed.id, paramString))) {
              ((WSFollowFeedHolder)localObject).a(localstFeed.feed);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private int e()
  {
    if ((getView() != null) && (((IWSFollowView)getView()).x() != null))
    {
      List localList = ((IWSFollowView)getView()).x().getDataList();
      if (localList != null) {
        return localList.size() - 1;
      }
    }
    return -1;
  }
  
  private void e(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.b("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = ((IWSFollowView)getView()).x();
    if (localObject1 != null)
    {
      if (((WSFollowAdapter)localObject1).getDataList() == null) {
        return;
      }
      localObject1 = ((WSFollowAdapter)localObject1).getDataList();
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        Object localObject2 = (stFeed)((List)localObject1).get(i);
        if ((localObject2 != null) && (((stFeed)localObject2).feed != null) && (((stFeed)localObject2).feed.poster != null))
        {
          int j;
          if ((((stFeed)localObject2).feed_type == 1) && (((stFeed)localObject2).person_meta != null))
          {
            localObject2 = ((stFeed)localObject2).person_meta;
            j = 0;
          }
          while (j < ((ArrayList)localObject2).size())
          {
            stSimpleMetaPerson localstSimpleMetaPerson = (stSimpleMetaPerson)((ArrayList)localObject2).get(j);
            if (TextUtils.equals(localstSimpleMetaPerson.id, paramWSSimpleBaseEvent.getPersonId()))
            {
              localstSimpleMetaPerson.followStatus = paramWSSimpleBaseEvent.getIsFollow();
              a(localstSimpleMetaPerson.id);
            }
            j += 1;
            continue;
            if ((((stFeed)localObject2).feed_type == 2) && (((stFeed)localObject2).feed != null))
            {
              localObject2 = ((stFeed)localObject2).feed.poster;
              if (TextUtils.equals(((stSimpleMetaPerson)localObject2).id, paramWSSimpleBaseEvent.getPersonId()))
              {
                ((stSimpleMetaPerson)localObject2).followStatus = paramWSSimpleBaseEvent.getIsFollow();
                b(paramWSSimpleBaseEvent.getPersonId());
              }
            }
            else if (((stFeed)localObject2).feed_type == 4)
            {
              a(paramWSSimpleBaseEvent, (stFeed)localObject2);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private void f(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (WSVideoPlayEvent)paramWSSimpleBaseEvent;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleVideoPlayEvent mCurrentPosition: ");
    localStringBuilder.append(paramWSSimpleBaseEvent.mCurrentPosition);
    WSLog.b("WSFollowPresenter", localStringBuilder.toString());
  }
  
  private void g(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleLikeEvent feedId: ");
    ((StringBuilder)localObject).append(paramWSSimpleBaseEvent.getFeedId());
    ((StringBuilder)localObject).append(" isDing:");
    ((StringBuilder)localObject).append(paramWSSimpleBaseEvent.getRspIsDing());
    WSLog.b("WSFollowPresenter", ((StringBuilder)localObject).toString());
    localObject = ((IWSFollowView)getView()).x();
    if (localObject != null)
    {
      if (((WSFollowAdapter)localObject).getDataList() == null) {
        return;
      }
      localObject = ((WSFollowAdapter)localObject).getDataList();
      int i = 0;
      while (i < ((List)localObject).size())
      {
        stFeed localstFeed = (stFeed)((List)localObject).get(i);
        if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localstFeed.feed.id)))
        {
          if (paramWSSimpleBaseEvent.getRspIsDing() != localstFeed.feed.is_ding)
          {
            int j;
            if (localstFeed.feed.is_ding == 1) {
              j = 1;
            } else {
              j = 0;
            }
            stSimpleMetaFeed localstSimpleMetaFeed;
            if (j != 0)
            {
              localstSimpleMetaFeed = localstFeed.feed;
              localstSimpleMetaFeed.ding_count -= 1;
            }
            else
            {
              localstSimpleMetaFeed = localstFeed.feed;
              localstSimpleMetaFeed.ding_count += 1;
            }
          }
          localstFeed.feed.is_ding = paramWSSimpleBaseEvent.getRspIsDing();
          c(paramWSSimpleBaseEvent.getFeedId());
        }
        i += 1;
      }
    }
  }
  
  private void h(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.b("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    Object localObject = ((IWSFollowView)getView()).x();
    if (localObject != null)
    {
      if (((WSFollowAdapter)localObject).getDataList() == null) {
        return;
      }
      localObject = ((WSFollowAdapter)localObject).getDataList();
      int i = 0;
      while (i < ((List)localObject).size())
      {
        stFeed localstFeed = (stFeed)((List)localObject).get(i);
        if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localstFeed.feed.id))) {
          d(paramWSSimpleBaseEvent.getFeedId());
        }
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
    {
      g(paramWSSimpleBaseEvent);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSVideoPlayEvent))
    {
      f(paramWSSimpleBaseEvent);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSItemExposeEvent))
    {
      d(paramWSSimpleBaseEvent);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof FollowEvent))
    {
      e(paramWSSimpleBaseEvent);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSAddCommentEvent))
    {
      h(paramWSSimpleBaseEvent);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSFriendFeedExposureEvent))
    {
      c(paramWSSimpleBaseEvent);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSPlayerMuteEvent)) {
      b(paramWSSimpleBaseEvent);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (getView() == null) {
      return;
    }
    if (paramBoolean1) {
      ((IWSFollowView)getView()).r();
    }
    long l = System.currentTimeMillis();
    WSFeedDataManager.a().a(paramBoolean1, paramBoolean2, "", 9, l, new WSFollowPresenter.1(this, paramBoolean1));
  }
  
  public void b()
  {
    this.c.b();
  }
  
  public void c()
  {
    this.c.a(e());
  }
  
  public void d()
  {
    this.c.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPresenter
 * JD-Core Version:    0.7.0.1
 */