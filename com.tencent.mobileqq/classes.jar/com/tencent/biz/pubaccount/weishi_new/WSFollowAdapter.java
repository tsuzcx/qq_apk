package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSplitBlock;
import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFriendCollectionHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowHolderFactory;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowPersonHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowSeparateHolder1;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowSeparateHolder2;
import com.tencent.biz.pubaccount.weishi_new.holder.WSPlayableHolder;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPlayerStatusListenerImpl;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class WSFollowAdapter
  extends BaseAdapter<stFeed, BaseViewHolder<stFeed>>
{
  public WSFollowFragment a;
  public WSPlayableHolder b;
  private WSPlayableHolder c;
  private WSPlayableHolder d;
  private WSPlayerManager e;
  private HashSet<BaseViewHolder> f = new HashSet();
  private boolean g;
  
  public WSFollowAdapter(WSFollowFragment paramWSFollowFragment)
  {
    super(paramWSFollowFragment.getBaseActivity());
    this.a = paramWSFollowFragment;
    this.g = paramWSFollowFragment.C();
  }
  
  private void a(WSFollowFeedHolder paramWSFollowFeedHolder)
  {
    if ((this.d == null) && (this.a.w()) && (this.e != null))
    {
      this.d = paramWSFollowFeedHolder;
      b(this.d);
      paramWSFollowFeedHolder = new StringBuilder();
      paramWSFollowFeedHolder.append("[WSFollowAdapter.java][onPrePlayFirstVideo] playerParam:");
      paramWSFollowFeedHolder.append(this.d.b);
      paramWSFollowFeedHolder.append(", mFistPlayableHolder:");
      paramWSFollowFeedHolder.append(this.d);
      paramWSFollowFeedHolder.append(", mFistPlayableHolder.mVideoInfo:");
      paramWSFollowFeedHolder.append(this.d.a);
      WSLog.e("WSFollowAdapter", paramWSFollowFeedHolder.toString());
      this.e.a(this.d.b);
      this.a.f(false);
    }
  }
  
  private String c(WSPlayableHolder paramWSPlayableHolder)
  {
    if (paramWSPlayableHolder == null) {
      return "WSPlayableHolder is null.";
    }
    if (paramWSPlayableHolder.b == null) {
      return "WSPlayableHolder.mPlayerParam is null.";
    }
    if (paramWSPlayableHolder.b.c == null) {
      return "WSPlayableHolder.mPlayerParam.mVideoInfo is null.";
    }
    return paramWSPlayableHolder.b.c.g;
  }
  
  private void h()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new WSFollowAdapter.1(this));
    this.e.a(localWSVideoPreDownloadManager);
  }
  
  public HashSet<BaseViewHolder> a()
  {
    return this.f;
  }
  
  public void a(WSPlayableHolder paramWSPlayableHolder)
  {
    this.e.n();
    this.b = paramWSPlayableHolder;
    this.e.b(paramWSPlayableHolder.b, false);
    this.e.b(true);
    this.e.c(this.g);
    WSFeedDataManager.a().a(paramWSPlayableHolder.b);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.e = paramWSPlayerManager;
    paramWSPlayerManager = new WSFollowPlayerStatusListenerImpl(this);
    this.e.a(paramWSPlayerManager);
    h();
  }
  
  public void a(BaseViewHolder<stFeed> paramBaseViewHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[************************************************************************************************************]onViewAttachedToWindow holder = ");
    localStringBuilder.append(paramBaseViewHolder);
    WSLog.e("WSFollowAdapter", localStringBuilder.toString());
    if (this.a.getUserVisibleHint()) {
      if ((paramBaseViewHolder instanceof WSFollowFeedHolder)) {
        ((WSFollowFeedHolder)paramBaseViewHolder).l();
      } else if ((paramBaseViewHolder instanceof WSFollowSeparateHolder1)) {
        ((WSFollowSeparateHolder1)paramBaseViewHolder).a();
      } else if ((paramBaseViewHolder instanceof WSFollowSeparateHolder2)) {
        ((WSFollowSeparateHolder2)paramBaseViewHolder).a();
      } else if ((paramBaseViewHolder instanceof WSFollowFriendCollectionHolder)) {
        ((WSFollowFriendCollectionHolder)paramBaseViewHolder).c();
      }
    }
    if ((paramBaseViewHolder instanceof WSFollowFeedHolder))
    {
      ((WSFollowFeedHolder)paramBaseViewHolder).j();
      return;
    }
    if ((paramBaseViewHolder instanceof WSFollowFriendCollectionHolder)) {
      ((WSFollowFriendCollectionHolder)paramBaseViewHolder).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if ((this.e != null) && (this.a.d))
    {
      this.e.c(paramBoolean);
      WSPlayerAudioControl.a().a(paramBoolean ^ true);
    }
  }
  
  public void b(WSPlayableHolder paramWSPlayableHolder)
  {
    this.c = paramWSPlayableHolder;
    paramWSPlayableHolder = new StringBuilder();
    paramWSPlayableHolder.append("[WSFollowAdapter.java][setPrePlayingHolder]\nplayingTitle:");
    paramWSPlayableHolder.append(c(this.b));
    paramWSPlayableHolder.append("\nprePlayTitle:");
    paramWSPlayableHolder.append(c(this.c));
    paramWSPlayableHolder.append("\nPlayingHolder:");
    paramWSPlayableHolder.append(this.b);
    paramWSPlayableHolder.append("\nPrePlayHolder:");
    paramWSPlayableHolder.append(this.c);
    WSLog.e("WS_VIDEO_PRE_PLAY", paramWSPlayableHolder.toString());
  }
  
  public void b(BaseViewHolder<stFeed> paramBaseViewHolder)
  {
    super.onViewDetachedFromWindow(paramBaseViewHolder);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[************************************************************************************************************]onViewDetachedFromWindow holder = ");
    localStringBuilder.append(paramBaseViewHolder);
    WSLog.e("WSFollowAdapter", localStringBuilder.toString());
    if ((paramBaseViewHolder instanceof WSFollowFeedHolder)) {
      ((WSFollowFeedHolder)paramBaseViewHolder).onViewDetachedFromWindow();
    }
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    WSPlayableHolder localWSPlayableHolder = this.c;
    if (localWSPlayableHolder != null)
    {
      localObject = this.b;
      if (localWSPlayableHolder != localObject)
      {
        if ((localObject != null) && (((WSPlayableHolder)localObject).b != null) && (this.b.b.d != null))
        {
          int i = this.b.b.d.E();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[WSFollowAdapter.java][tryPrePlayVideo] playingPlayerState:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", prePlayVideoHolder:");
          ((StringBuilder)localObject).append(localWSPlayableHolder);
          WSLog.e("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject).toString());
          if ((i != 0) && (i != 1) && (i != 2))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[WSFollowAdapter.java][tryPrePlayVideo] goto prePlayVideo prePlayVideoHolder:");
            ((StringBuilder)localObject).append(localWSPlayableHolder);
            WSLog.a("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject).toString());
            this.e.a(localWSPlayableHolder.b);
          }
        }
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFollowAdapter.java][tryPrePlayVideo] prePlayVideoHolder:");
    ((StringBuilder)localObject).append(localWSPlayableHolder);
    WSLog.d("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject).toString());
  }
  
  public stSimpleMetaFeed d()
  {
    Object localObject = getDataList();
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return null;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        stFeed localstFeed = (stFeed)((Iterator)localObject).next();
        if ((localstFeed.feed != null) && (!TextUtils.isEmpty(localstFeed.feed.id))) {
          return localstFeed.feed;
        }
      }
    }
    return null;
  }
  
  public WSPlayerManager e()
  {
    return this.e;
  }
  
  public Activity f()
  {
    return this.a.getBaseActivity();
  }
  
  public WSFollowFragment g()
  {
    return this.a;
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    Object localObject = getDataList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (stFeed)((List)localObject).get(paramInt);
      if (localObject == null) {
        return 2;
      }
      stSplitBlock localstSplitBlock = ((stFeed)localObject).recommend_splitter;
      if ((localstSplitBlock != null) && (((stFeed)localObject).feed_type == 3))
      {
        paramInt = localstSplitBlock.style;
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            return 102;
          }
        }
        else {
          return 101;
        }
      }
      return ((stFeed)localObject).feed_type;
    }
    return 2;
  }
  
  public void onBindCustomViewHolder(BaseViewHolder<stFeed> paramBaseViewHolder, int paramInt)
  {
    Object localObject = (stFeed)getItem(paramInt);
    if (localObject == null) {
      return;
    }
    if ((paramBaseViewHolder instanceof WSFollowFeedHolder))
    {
      paramBaseViewHolder.bindData(localObject);
      paramBaseViewHolder = (WSFollowFeedHolder)paramBaseViewHolder;
      paramBaseViewHolder.a = WSPlayerUtils.a(((stFeed)localObject).feed);
      WSFeedDataManager.a().b(paramBaseViewHolder);
      paramBaseViewHolder.c = WSFeedDataManager.a().a(paramBaseViewHolder);
      paramBaseViewHolder.b = WSFeedDataManager.a().a(paramBaseViewHolder, 0L, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("===> WSFollowAdapter onBindCustomViewHolder position:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", title: ");
      ((StringBuilder)localObject).append(paramBaseViewHolder.a.g);
      ((StringBuilder)localObject).append(", feedHolder:");
      ((StringBuilder)localObject).append(paramBaseViewHolder);
      ((StringBuilder)localObject).append(", feedHolder.mVideoInfo:");
      ((StringBuilder)localObject).append(paramBaseViewHolder.a);
      WSLog.a("WSFollowAdapter", ((StringBuilder)localObject).toString());
      a(paramBaseViewHolder);
      this.a.a(paramBaseViewHolder);
      return;
    }
    if ((paramBaseViewHolder instanceof WSFollowPersonHolder))
    {
      ((WSFollowPersonHolder)paramBaseViewHolder).a((stFeed)localObject);
      return;
    }
    if ((paramBaseViewHolder instanceof WSFollowSeparateHolder1))
    {
      ((WSFollowSeparateHolder1)paramBaseViewHolder).a((stFeed)localObject);
      return;
    }
    if ((paramBaseViewHolder instanceof WSFollowSeparateHolder2))
    {
      ((WSFollowSeparateHolder2)paramBaseViewHolder).a((stFeed)localObject);
      return;
    }
    if ((paramBaseViewHolder instanceof WSFollowFriendCollectionHolder)) {
      ((WSFollowFriendCollectionHolder)paramBaseViewHolder).a((stFeed)localObject);
    }
  }
  
  public BaseViewHolder<stFeed> onCreateCustomViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = WSFollowHolderFactory.a(paramInt, paramViewGroup, this);
    this.f.add(paramViewGroup);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("===> WSFollowAdapter onCreateCustomViewHolder viewHolder:");
    localStringBuilder.append(paramViewGroup);
    WSLog.a("WSFollowContinuePlayLog", localStringBuilder.toString());
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter
 * JD-Core Version:    0.7.0.1
 */