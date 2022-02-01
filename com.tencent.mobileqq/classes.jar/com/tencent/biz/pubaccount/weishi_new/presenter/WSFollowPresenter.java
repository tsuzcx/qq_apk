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
  private int jdField_a_of_type_Int = 0;
  private stFollowFeedsGlobalConfig jdField_a_of_type_UserGrowthStFollowFeedsGlobalConfig;
  
  private void a(RecyclerView paramRecyclerView, String paramString)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      stSimpleMetaPerson localstSimpleMetaPerson;
      if ((localObject instanceof WSRecommendFollowHolder))
      {
        localObject = (WSRecommendFollowHolder)localObject;
        localstSimpleMetaPerson = ((WSRecommendFollowHolder)localObject).a();
        if ((localstSimpleMetaPerson != null) && (TextUtils.equals(localstSimpleMetaPerson.id, paramString))) {
          ((WSRecommendFollowHolder)localObject).a();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof WSFollowFriendFeedHolder))
        {
          localObject = (WSFollowFriendFeedHolder)localObject;
          localstSimpleMetaPerson = ((WSFollowFriendFeedHolder)localObject).a();
          if ((localstSimpleMetaPerson != null) && (TextUtils.equals(localstSimpleMetaPerson.id, paramString))) {
            ((WSFollowFriendFeedHolder)localObject).c();
          }
        }
      }
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
    if ((a() == null) || (((IWSFollowView)a()).a() == null)) {}
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter;
    do
    {
      return;
      localRecyclerViewWithHeaderFooter = ((IWSFollowView)a()).a().a();
    } while (localRecyclerViewWithHeaderFooter == null);
    int j = localRecyclerViewWithHeaderFooter.getChildCount();
    int i = 0;
    label53:
    RecyclerView.ViewHolder localViewHolder;
    if (i < j)
    {
      localViewHolder = localRecyclerViewWithHeaderFooter.getChildViewHolder(localRecyclerViewWithHeaderFooter.getChildAt(i));
      if (!(localViewHolder instanceof WSFollowPersonHolder)) {
        break label99;
      }
      a(((WSFollowPersonHolder)localViewHolder).a(), paramString);
    }
    for (;;)
    {
      i += 1;
      break label53;
      break;
      label99:
      if ((localViewHolder instanceof WSFollowFriendCollectionHolder)) {
        a(((WSFollowFriendCollectionHolder)localViewHolder).a(), paramString);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a() == null) || (((IWSFollowView)a()).a() == null)) {
      return;
    }
    Iterator localIterator = ((IWSFollowView)a()).a().a().iterator();
    label42:
    StringBuilder localStringBuilder;
    while (localIterator.hasNext())
    {
      localObject = (BaseViewHolder)localIterator.next();
      if ((localObject instanceof WSFollowFeedHolder))
      {
        localObject = (WSFollowFeedHolder)localObject;
        ((WSFollowFeedHolder)localObject).a(paramBoolean);
        localStringBuilder = new StringBuilder().append("updateMuteStatus title:");
        if (((WSFollowFeedHolder)localObject).a == null) {
          break label124;
        }
      }
    }
    label124:
    for (Object localObject = ((WSFollowFeedHolder)localObject).a.d;; localObject = "videoInfo is null!")
    {
      WSLog.e("WSFollowPresenter", (String)localObject);
      break label42;
      break;
    }
  }
  
  private void b(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    a(((WSPlayerMuteEvent)paramWSSimpleBaseEvent).isPlayerMute());
  }
  
  private void b(String paramString)
  {
    if ((a() == null) || (((IWSFollowView)a()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((IWSFollowView)a()).a().a();
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
            stFeed localstFeed = ((WSFollowFeedHolder)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.poster != null) && (TextUtils.equals(localstFeed.feed.poster.id, paramString))) {
              ((WSFollowFeedHolder)localObject).f();
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
    Object localObject = new StringBuilder().append("handleOnReceiveEventForFriendFeed event: ");
    if (localWSFriendFeedExposureEvent == null)
    {
      paramWSSimpleBaseEvent = "null";
      WSLog.b("WSFollowPresenter", paramWSSimpleBaseEvent);
      if ((localWSFriendFeedExposureEvent != null) && (localWSFriendFeedExposureEvent.video != null)) {
        break label68;
      }
    }
    label195:
    for (;;)
    {
      return;
      paramWSSimpleBaseEvent = Integer.valueOf(localWSFriendFeedExposureEvent.currentPosition);
      break;
      label68:
      paramWSSimpleBaseEvent = ((IWSFollowView)a()).a();
      if ((paramWSSimpleBaseEvent != null) && (paramWSSimpleBaseEvent.b() != null))
      {
        paramWSSimpleBaseEvent = ((IWSFollowView)a()).a();
        if ((paramWSSimpleBaseEvent != null) && (paramWSSimpleBaseEvent.a() != null))
        {
          paramWSSimpleBaseEvent = paramWSSimpleBaseEvent.a();
          int j = paramWSSimpleBaseEvent.getChildCount();
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label195;
            }
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
    if ((a() == null) || (((IWSFollowView)a()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((IWSFollowView)a()).a().a();
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
            stFeed localstFeed = ((WSFollowFeedHolder)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(localstFeed.feed.id, paramString)))
            {
              WSLog.b("WSFollowPresenter", "updateLikeStatus");
              ((WSFollowFeedHolder)localObject).e();
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
    Object localObject2 = new StringBuilder().append("handleItemExposeEvent event: ");
    if (localObject1 == null)
    {
      paramWSSimpleBaseEvent = "null";
      WSLog.b("WSFollowPresenter", paramWSSimpleBaseEvent);
      if ((localObject1 != null) && (((WSItemExposeEvent)localObject1).video != null)) {
        break label61;
      }
    }
    for (;;)
    {
      return;
      paramWSSimpleBaseEvent = ((WSItemExposeEvent)localObject1).video;
      break;
      label61:
      paramWSSimpleBaseEvent = ((IWSFollowView)a()).a();
      if ((paramWSSimpleBaseEvent != null) && (paramWSSimpleBaseEvent.b() != null))
      {
        localObject2 = ((IWSFollowView)a()).a();
        if ((localObject2 != null) && (((XRecyclerView)localObject2).a() != null))
        {
          localObject1 = ((WSItemExposeEvent)localObject1).video;
          List localList = WSFeedDataManager.a().b;
          if (paramWSSimpleBaseEvent.b().size() < localList.size()) {
            ((IWSFollowView)a()).a(localList);
          }
          int i = 0;
          while (i < localList.size())
          {
            if (((stFeed)localList.get(i)).feed == localObject1)
            {
              ((XRecyclerView)localObject2).a().scrollToPosition(i);
              this.jdField_a_of_type_Int = i;
              WSLog.b("WSFollowPresenter", "receive item expose event, position: " + i + ", feed: " + ((stSimpleMetaFeed)localObject1).feed_desc);
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
    if ((a() == null) || (((IWSFollowView)a()).a() == null)) {}
    for (;;)
    {
      return;
      RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = ((IWSFollowView)a()).a().a();
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
            stFeed localstFeed = ((WSFollowFeedHolder)localObject).a();
            if ((localstFeed != null) && (localstFeed.feed != null) && (TextUtils.equals(localstFeed.feed.id, paramString))) {
              ((WSFollowFeedHolder)localObject).a(localstFeed.feed);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void e(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.b("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
    Object localObject1 = ((IWSFollowView)a()).a();
    if ((localObject1 == null) || (((WSFollowAdapter)localObject1).b() == null)) {
      return;
    }
    localObject1 = ((WSFollowAdapter)localObject1).b();
    int i = 0;
    label50:
    Object localObject2;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (stFeed)((List)localObject1).get(i);
      if ((localObject2 != null) && (((stFeed)localObject2).feed != null) && (((stFeed)localObject2).feed.poster != null)) {
        break label105;
      }
    }
    for (;;)
    {
      i += 1;
      break label50;
      break;
      label105:
      if ((((stFeed)localObject2).feed_type == 1) && (((stFeed)localObject2).person_meta != null))
      {
        localObject2 = ((stFeed)localObject2).person_meta;
        int j = 0;
        while (j < ((ArrayList)localObject2).size())
        {
          stSimpleMetaPerson localstSimpleMetaPerson = (stSimpleMetaPerson)((ArrayList)localObject2).get(j);
          if (TextUtils.equals(localstSimpleMetaPerson.id, paramWSSimpleBaseEvent.getPersonId()))
          {
            localstSimpleMetaPerson.followStatus = paramWSSimpleBaseEvent.getIsFollow();
            a(localstSimpleMetaPerson.id);
          }
          j += 1;
        }
      }
      else if ((((stFeed)localObject2).feed_type == 2) && (((stFeed)localObject2).feed != null))
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
  
  private void f(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (WSVideoPlayEvent)paramWSSimpleBaseEvent;
    WSLog.b("WSFollowPresenter", "handleVideoPlayEvent mCurrentPosition: " + paramWSSimpleBaseEvent.mCurrentPosition);
  }
  
  private void g(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
    WSLog.b("WSFollowPresenter", "handleLikeEvent feedId: " + paramWSSimpleBaseEvent.getFeedId() + " isDing:" + paramWSSimpleBaseEvent.getRspIsDing());
    Object localObject = ((IWSFollowView)a()).a();
    if ((localObject == null) || (((WSFollowAdapter)localObject).b() == null)) {
      return;
    }
    localObject = ((WSFollowAdapter)localObject).b();
    int i = 0;
    label83:
    stFeed localstFeed;
    if (i < ((List)localObject).size())
    {
      localstFeed = (stFeed)((List)localObject).get(i);
      if ((localstFeed != null) && (localstFeed.feed != null)) {
        break label127;
      }
    }
    label127:
    while (!TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localstFeed.feed.id))
    {
      i += 1;
      break label83;
      break;
    }
    int j;
    label174:
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (paramWSSimpleBaseEvent.getRspIsDing() != localstFeed.feed.is_ding)
    {
      if (localstFeed.feed.is_ding != 1) {
        break label220;
      }
      j = 1;
      if (j == 0) {
        break label225;
      }
      localstSimpleMetaFeed = localstFeed.feed;
    }
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      localstFeed.feed.is_ding = paramWSSimpleBaseEvent.getRspIsDing();
      c(paramWSSimpleBaseEvent.getFeedId());
      break;
      label220:
      j = 0;
      break label174;
      label225:
      localstSimpleMetaFeed = localstFeed.feed;
    }
  }
  
  private void h(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.b("WSFollowPresenter", "[handleOnReceiveEventForFollow]");
    paramWSSimpleBaseEvent = (WSAddCommentEvent)paramWSSimpleBaseEvent;
    Object localObject = ((IWSFollowView)a()).a();
    if ((localObject == null) || (((WSFollowAdapter)localObject).b() == null)) {
      return;
    }
    localObject = ((WSFollowAdapter)localObject).b();
    int i = 0;
    label45:
    stFeed localstFeed;
    if (i < ((List)localObject).size())
    {
      localstFeed = (stFeed)((List)localObject).get(i);
      if ((localstFeed != null) && (localstFeed.feed != null)) {
        break label87;
      }
    }
    for (;;)
    {
      i += 1;
      break label45;
      break;
      label87:
      if (TextUtils.equals(paramWSSimpleBaseEvent.getFeedId(), localstFeed.feed.id)) {
        d(paramWSSimpleBaseEvent.getFeedId());
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof LikeRspEvent)) {
      g(paramWSSimpleBaseEvent);
    }
    do
    {
      return;
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
    } while (!(paramWSSimpleBaseEvent instanceof WSPlayerMuteEvent));
    b(paramWSSimpleBaseEvent);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a() == null) {
      return;
    }
    if (paramBoolean1) {
      ((IWSFollowView)a()).c();
    }
    long l = System.currentTimeMillis();
    WSFeedDataManager.a().a(paramBoolean1, paramBoolean2, "", 9, l, new WSFollowPresenter.1(this, paramBoolean1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPresenter
 * JD-Core Version:    0.7.0.1
 */