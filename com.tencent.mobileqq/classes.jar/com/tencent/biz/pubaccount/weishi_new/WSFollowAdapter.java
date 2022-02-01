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
    super(paramWSFollowFragment.getActivity());
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
      WSLog.e("WSFollowAdapter", "[WSFollowAdapter.java][onPrePlayFirstVideo] playerParam:" + this.c.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam + ", mFistPlayableHolder:" + this.c + ", mFistPlayableHolder.mVideoInfo:" + this.c.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.c.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.b(false);
    }
  }
  
  private void c()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new WSFollowAdapter.1(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  public int a(int paramInt)
  {
    Object localObject = b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (stFeed)((List)localObject).get(paramInt);
      if (localObject == null) {
        return 2;
      }
      stSplitBlock localstSplitBlock = ((stFeed)localObject).recommend_splitter;
      if ((localstSplitBlock != null) && (((stFeed)localObject).feed_type == 3)) {}
      switch (localstSplitBlock.style)
      {
      default: 
        return ((stFeed)localObject).feed_type;
      case 1: 
        return 101;
      }
      return 102;
    }
    return 2;
  }
  
  public stSimpleMetaFeed a()
  {
    Object localObject = b();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
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
    return null;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getActivity();
  }
  
  public WSFollowFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public BaseViewHolder<stFeed> a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = WSFollowHolderFactory.a(paramInt, paramViewGroup, this);
    this.jdField_a_of_type_JavaUtilHashSet.add(paramViewGroup);
    WSLog.a("WSFollowContinuePlayLog", "===> WSFollowAdapter onCreateCustomViewHolder viewHolder:" + paramViewGroup);
    return paramViewGroup;
  }
  
  public HashSet<BaseViewHolder> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a()
  {
    WSPlayableHolder localWSPlayableHolder = this.b;
    if ((localWSPlayableHolder == null) || (localWSPlayableHolder == this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder)) {
      WSLog.d("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + localWSPlayableHolder);
    }
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper == null));
      i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.e();
      WSLog.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] playingPlayerState:" + i + ", prePlayVideoHolder:" + localWSPlayableHolder);
    } while ((i == 0) || (i == 1) || (i == 2));
    WSLog.a("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] goto prePlayVideo prePlayVideoHolder:" + localWSPlayableHolder);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
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
    c();
  }
  
  public void a(BaseViewHolder<stFeed> paramBaseViewHolder)
  {
    WSLog.e("WSFollowAdapter", "[************************************************************************************************************]onViewAttachedToWindow holder = " + paramBaseViewHolder);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getUserVisibleHint())
    {
      if ((paramBaseViewHolder instanceof WSFollowFeedHolder)) {
        ((WSFollowFeedHolder)paramBaseViewHolder).i();
      }
    }
    else
    {
      if (!(paramBaseViewHolder instanceof WSFollowFeedHolder)) {
        break label115;
      }
      ((WSFollowFeedHolder)paramBaseViewHolder).g();
    }
    label115:
    while (!(paramBaseViewHolder instanceof WSFollowFriendCollectionHolder))
    {
      return;
      if ((paramBaseViewHolder instanceof WSFollowSeparateHolder1))
      {
        ((WSFollowSeparateHolder1)paramBaseViewHolder).a();
        break;
      }
      if ((paramBaseViewHolder instanceof WSFollowSeparateHolder2))
      {
        ((WSFollowSeparateHolder2)paramBaseViewHolder).a();
        break;
      }
      if (!(paramBaseViewHolder instanceof WSFollowFriendCollectionHolder)) {
        break;
      }
      ((WSFollowFriendCollectionHolder)paramBaseViewHolder).b();
      break;
    }
    ((WSFollowFriendCollectionHolder)paramBaseViewHolder).a();
  }
  
  public void a(BaseViewHolder<stFeed> paramBaseViewHolder, int paramInt)
  {
    stFeed localstFeed = (stFeed)a(paramInt);
    if (localstFeed == null) {}
    do
    {
      return;
      if ((paramBaseViewHolder instanceof WSFollowFeedHolder))
      {
        paramBaseViewHolder.a(localstFeed);
        paramBaseViewHolder = (WSFollowFeedHolder)paramBaseViewHolder;
        paramBaseViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo = WSPlayerUtils.a(localstFeed.feed);
        WSFeedDataManager.a().a(paramBaseViewHolder);
        paramBaseViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate = WSFeedDataManager.a().a(paramBaseViewHolder);
        paramBaseViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = WSFeedDataManager.a().a(paramBaseViewHolder, 0L, paramInt);
        WSLog.a("WSFollowAdapter", "===> WSFollowAdapter onBindCustomViewHolder position:" + paramInt + ", title: " + paramBaseViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d + ", feedHolder:" + paramBaseViewHolder + ", feedHolder.mVideoInfo:" + paramBaseViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo);
        a(paramBaseViewHolder);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a(paramBaseViewHolder);
        return;
      }
      if ((paramBaseViewHolder instanceof WSFollowPersonHolder))
      {
        ((WSFollowPersonHolder)paramBaseViewHolder).a(localstFeed);
        return;
      }
      if ((paramBaseViewHolder instanceof WSFollowSeparateHolder1))
      {
        ((WSFollowSeparateHolder1)paramBaseViewHolder).a(localstFeed);
        return;
      }
      if ((paramBaseViewHolder instanceof WSFollowSeparateHolder2))
      {
        ((WSFollowSeparateHolder2)paramBaseViewHolder).a(localstFeed);
        return;
      }
    } while (!(paramBaseViewHolder instanceof WSFollowFriendCollectionHolder));
    ((WSFollowFriendCollectionHolder)paramBaseViewHolder).a(localstFeed);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    WSPlayerAudioControl localWSPlayerAudioControl;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(paramBoolean);
      localWSPlayerAudioControl = WSPlayerAudioControl.a();
      if (paramBoolean) {
        break label46;
      }
    }
    label46:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localWSPlayerAudioControl.a(paramBoolean);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(WSPlayableHolder paramWSPlayableHolder)
  {
    this.b = paramWSPlayableHolder;
    WSLog.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][setPrePlayingHolder]\nplayingTitle:" + a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder) + "\nprePlayTitle:" + a(this.b) + "\nPlayingHolder:" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSPlayableHolder + "\nPrePlayHolder:" + this.b);
  }
  
  public void b(BaseViewHolder<stFeed> paramBaseViewHolder)
  {
    super.onViewDetachedFromWindow(paramBaseViewHolder);
    WSLog.e("WSFollowAdapter", "[************************************************************************************************************]onViewDetachedFromWindow holder = " + paramBaseViewHolder);
    if ((paramBaseViewHolder instanceof WSFollowFeedHolder)) {
      ((WSFollowFeedHolder)paramBaseViewHolder).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter
 * JD-Core Version:    0.7.0.1
 */