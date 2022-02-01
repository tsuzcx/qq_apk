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
  public WSPlayableHolder a;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private HashSet<BaseViewHolder> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private WSPlayableHolder b;
  private WSPlayableHolder c;
  
  public WSFollowAdapter(WSFollowFragment paramWSFollowFragment)
  {
    super(paramWSFollowFragment.getBaseActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment = paramWSFollowFragment;
    this.jdField_a_of_type_Boolean = paramWSFollowFragment.c();
  }
  
  private String a(WSPlayableHolder paramWSPlayableHolder)
  {
    if (paramWSPlayableHolder == null) {
      return "WSPlayableHolder is null.";
    }
    if (paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam == null) {
      return "WSPlayableHolder.mPlayerParam is null.";
    }
    if (paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null) {
      return "WSPlayableHolder.mPlayerParam.mVideoInfo is null.";
    }
    return paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d;
  }
  
  private void a(WSFollowFeedHolder paramWSFollowFeedHolder)
  {
    if ((this.c == null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null))
    {
      this.c = paramWSFollowFeedHolder;
      b(this.c);
      paramWSFollowFeedHolder = new StringBuilder();
      paramWSFollowFeedHolder.append("[WSFollowAdapter.java][onPrePlayFirstVideo] playerParam:");
      paramWSFollowFeedHolder.append(this.c.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      paramWSFollowFeedHolder.append(", mFistPlayableHolder:");
      paramWSFollowFeedHolder.append(this.c);
      paramWSFollowFeedHolder.append(", mFistPlayableHolder.mVideoInfo:");
      paramWSFollowFeedHolder.append(this.c.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo);
      WSLog.e("WSFollowAdapter", paramWSFollowFeedHolder.toString());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.c.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b(false);
    }
  }
  
  private void b()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new WSFollowAdapter.1(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  public stSimpleMetaFeed a()
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
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getBaseActivity();
  }
  
  public WSFollowFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public HashSet<BaseViewHolder> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a()
  {
    WSPlayableHolder localWSPlayableHolder = this.b;
    if (localWSPlayableHolder != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder;
      if (localWSPlayableHolder != localObject)
      {
        if ((localObject != null) && (((WSPlayableHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null))
        {
          int i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.e();
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
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
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
  
  public void a(WSPlayableHolder paramWSPlayableHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder = paramWSPlayableHolder;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_Boolean);
    WSFeedDataManager.a().a(paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new WSFollowPlayerStatusListenerImpl(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    b();
  }
  
  public void a(BaseViewHolder<stFeed> paramBaseViewHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[************************************************************************************************************]onViewAttachedToWindow holder = ");
    localStringBuilder.append(paramBaseViewHolder);
    WSLog.e("WSFollowAdapter", localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getUserVisibleHint()) {
      if ((paramBaseViewHolder instanceof WSFollowFeedHolder)) {
        ((WSFollowFeedHolder)paramBaseViewHolder).h();
      } else if ((paramBaseViewHolder instanceof WSFollowSeparateHolder1)) {
        ((WSFollowSeparateHolder1)paramBaseViewHolder).a();
      } else if ((paramBaseViewHolder instanceof WSFollowSeparateHolder2)) {
        ((WSFollowSeparateHolder2)paramBaseViewHolder).a();
      } else if ((paramBaseViewHolder instanceof WSFollowFriendCollectionHolder)) {
        ((WSFollowFriendCollectionHolder)paramBaseViewHolder).b();
      }
    }
    if ((paramBaseViewHolder instanceof WSFollowFeedHolder))
    {
      ((WSFollowFeedHolder)paramBaseViewHolder).g();
      return;
    }
    if ((paramBaseViewHolder instanceof WSFollowFriendCollectionHolder)) {
      ((WSFollowFriendCollectionHolder)paramBaseViewHolder).a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(paramBoolean);
      WSPlayerAudioControl.a().a(paramBoolean ^ true);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(WSPlayableHolder paramWSPlayableHolder)
  {
    this.b = paramWSPlayableHolder;
    paramWSPlayableHolder = new StringBuilder();
    paramWSPlayableHolder.append("[WSFollowAdapter.java][setPrePlayingHolder]\nplayingTitle:");
    paramWSPlayableHolder.append(a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder));
    paramWSPlayableHolder.append("\nprePlayTitle:");
    paramWSPlayableHolder.append(a(this.b));
    paramWSPlayableHolder.append("\nPlayingHolder:");
    paramWSPlayableHolder.append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder);
    paramWSPlayableHolder.append("\nPrePlayHolder:");
    paramWSPlayableHolder.append(this.b);
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
      paramBaseViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo = WSPlayerUtils.a(((stFeed)localObject).feed);
      WSFeedDataManager.a().a(paramBaseViewHolder);
      paramBaseViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate = WSFeedDataManager.a().a(paramBaseViewHolder);
      paramBaseViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = WSFeedDataManager.a().a(paramBaseViewHolder, 0L, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("===> WSFollowAdapter onBindCustomViewHolder position:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", title: ");
      ((StringBuilder)localObject).append(paramBaseViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d);
      ((StringBuilder)localObject).append(", feedHolder:");
      ((StringBuilder)localObject).append(paramBaseViewHolder);
      ((StringBuilder)localObject).append(", feedHolder.mVideoInfo:");
      ((StringBuilder)localObject).append(paramBaseViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo);
      WSLog.a("WSFollowAdapter", ((StringBuilder)localObject).toString());
      a(paramBaseViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a(paramBaseViewHolder);
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
    this.jdField_a_of_type_JavaUtilHashSet.add(paramViewGroup);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("===> WSFollowAdapter onCreateCustomViewHolder viewHolder:");
    localStringBuilder.append(paramViewGroup);
    WSLog.a("WSFollowContinuePlayLog", localStringBuilder.toString());
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter
 * JD-Core Version:    0.7.0.1
 */