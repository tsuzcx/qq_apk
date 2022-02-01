package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSPlayerMuteEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.event.WSVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFriendCollectionHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowPersonHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowSeparateHolder1;
import com.tencent.biz.pubaccount.weishi_new.holder.WSPlayableHolder;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPresenter;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSFollowView;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class WSFollowFragment
  extends WSBaseHomeFragment<IWSFollowView, WSFollowPresenter, List<stFeed>>
  implements WSSimpleEventReceiver, IWSFollowView, OnTabSelectedListener
{
  public static boolean d;
  private long jdField_a_of_type_Long = 0L;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private WSFollowAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
  public WsCommentPresenter a;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private boolean e = true;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  
  private WSPlayableHolder a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter != null)
    {
      int i1 = paramInt;
      if (paramInt < 0) {
        return null;
      }
      while (i1 < this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.getDataList().size())
      {
        WSPlayableHolder localWSPlayableHolder = c(i1, paramBoolean);
        if (localWSPlayableHolder != null) {
          return localWSPlayableHolder;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof WSFollowFeedHolder))
    {
      ((WSFollowFeedHolder)localViewHolder).h();
      return;
    }
    if ((localViewHolder instanceof WSFollowPersonHolder))
    {
      ((WSFollowPersonHolder)localViewHolder).a();
      return;
    }
    if ((localViewHolder instanceof WSFollowSeparateHolder1))
    {
      ((WSFollowSeparateHolder1)localViewHolder).a();
      return;
    }
    if ((localViewHolder instanceof WSFollowFriendCollectionHolder)) {
      ((WSFollowFriendCollectionHolder)localViewHolder).b();
    }
  }
  
  private void a(WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.c()))
    {
      WSFollowBeaconReport.a(paramWSPlayerManager.a());
      this.e = true;
      this.f = true;
    }
  }
  
  private boolean a(WSPlayableHolder paramWSPlayableHolder)
  {
    boolean bool = false;
    if (paramWSPlayableHolder == null) {
      return false;
    }
    if (WSFeedUtils.a(paramWSPlayableHolder.a()) >= 50) {
      bool = true;
    }
    return bool;
  }
  
  private WSPlayableHolder b(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      return null;
    }
    while (i1 >= 0)
    {
      WSPlayableHolder localWSPlayableHolder = c(i1, paramBoolean);
      if (localWSPlayableHolder != null) {
        return localWSPlayableHolder;
      }
      i1 -= 1;
    }
    return null;
  }
  
  private void b(WSPlayableHolder paramWSPlayableHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(paramWSPlayableHolder);
    this.g = false;
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if ((this.e) && (paramWSPlayerManager != null) && ((paramWSPlayerManager.c()) || (paramWSPlayerManager.b())))
    {
      WSFollowBeaconReport.a(paramWSPlayerManager.a(), false);
      paramWSPlayerManager.g();
    }
    this.e = false;
  }
  
  private WSPlayableHolder c(int paramInt, boolean paramBoolean)
  {
    Object localObject = (stFeed)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.getDataList().get(paramInt);
    if ((((stFeed)localObject).feed_type == 2) && (((stFeed)localObject).feed != null))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView().findViewHolderForLayoutPosition(paramInt);
      if ((localObject instanceof WSPlayableHolder))
      {
        localObject = (WSPlayableHolder)localObject;
        if ((a((WSPlayableHolder)localObject)) || (paramBoolean)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFollowFragment.java][reportVideoPlay] tabSelectedIndex:");
    ((StringBuilder)localObject).append(WSHomeFragment.a);
    ((StringBuilder)localObject).append(", isPlay:");
    ((StringBuilder)localObject).append(paramBoolean);
    WSLog.e("WS_VIDEO_PLAY_TIME", ((StringBuilder)localObject).toString());
    if (WSHomeFragment.a == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
      if (localObject == null) {
        return;
      }
      if (paramBoolean)
      {
        a(((WSFollowAdapter)localObject).a());
        return;
      }
      b(((WSFollowAdapter)localObject).a());
    }
  }
  
  private void j()
  {
    WSSimpleEventBus.a().a(this);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(WeishiUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
  }
  
  private void l()
  {
    if (!this.j)
    {
      com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.b = 2;
      return;
    }
    if ((!this.k) && (!this.l))
    {
      com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.b = 3;
      return;
    }
    com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.b = 1;
  }
  
  private void m()
  {
    int i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
    int i2 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
    if (i1 >= 0)
    {
      if (i2 >= this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.getDataList().size()) {
        return;
      }
      while (i1 <= i2)
      {
        a(i1);
        i1 += 1;
      }
    }
  }
  
  private void n()
  {
    int i2 = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView().getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      a(i1);
      i1 += 1;
    }
  }
  
  private void o()
  {
    WSLog.b("WSFollowFragment", "showErrorView");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    WSReportDc00898.b(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new WSFollowFragment.4(this));
  }
  
  protected RecyclerView.LayoutManager a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new WSFollowLinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 1, false);
    return this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  }
  
  public WSFollowAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
  }
  
  public WSPlayableHolder a(WSPlayableHolder paramWSPlayableHolder, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramWSPlayableHolder != null)
    {
      int i1 = paramWSPlayableHolder.getLayoutPosition();
      if (paramBoolean1) {
        return a(i1 + 1, paramBoolean2);
      }
      return b(i1 - 1, paramBoolean2);
    }
    return null;
  }
  
  @NonNull
  public WSFollowPresenter a()
  {
    return new WSFollowPresenter();
  }
  
  protected BaseAdapter a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter = new WSFollowAdapter(this);
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
  }
  
  public XRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(WSVideoPlayEvent.class);
    localArrayList.add(WSItemExposeEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    localArrayList.add(WSFriendFeedExposureEvent.class);
    localArrayList.add(WSPlayerMuteEvent.class);
    return localArrayList;
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_Boolean) {
      WeishiUtils.c("focus");
    }
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof WSFollowFeedHolder)) {
      ((WSFollowFeedHolder)localViewHolder).a(paramstSimpleMetaFeed);
    }
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected void a(View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
    }
    WeiShiCacheManager.a().b(new WSFollowFragment.1(this));
    k();
    j();
    paramView = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369048);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370342));
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter = new WsCommentPresenter(this, 0);
      ViewStub localViewStub = new ViewStub(getBaseActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      paramView.addView(localViewStub);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView().addOnScrollListener(new WSFollowFragment.2(this));
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((WSFollowPresenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramWSSimpleBaseEvent);
  }
  
  public void a(WSPlayableHolder paramWSPlayableHolder)
  {
    if ((this.g) && (a(paramWSPlayableHolder)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSFollowFragment.java][onPlayFirstVideo] playVideo title:");
      localStringBuilder.append(paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d);
      localStringBuilder.append(", mPlayingHolder:");
      localStringBuilder.append(paramWSPlayableHolder);
      WSLog.c("WSFollowContinuePlayLog", localStringBuilder.toString());
      b(paramWSPlayableHolder);
      paramWSPlayableHolder = a(paramWSPlayableHolder, true, true);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSFollowFragment.java][onPlayFirstVideo] setPrePlayingHolder prePlayHolder:");
      localStringBuilder.append(paramWSPlayableHolder);
      WSLog.a("WS_VIDEO_PRE_PLAY", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b(paramWSPlayableHolder);
    }
  }
  
  public void a(WSPlayableHolder paramWSPlayableHolder, String paramString1, String paramString2, int paramInt)
  {
    WSPlayerParam localWSPlayerParam = WSFeedDataManager.a().a();
    if (localWSPlayerParam == null) {
      return;
    }
    if (paramWSPlayableHolder == null) {
      return;
    }
    if ((localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null) && (localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null) && (paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null))
    {
      paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
      paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView;
      paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport = localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport;
      paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.c(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a = paramWSPlayableHolder;
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false, paramInt, null);
      if (!this.f) {
        WSFollowBeaconReport.a(paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      }
      paramString1 = a(paramWSPlayableHolder, true, true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b(paramString1);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a());
      this.e = true;
      this.f = false;
      paramString1 = new StringBuilder();
      paramString1.append("WSFollowFragment handleOnActivityResultFromVertical()2, title: ");
      paramString1.append(paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d);
      paramString1.append(", playingHolder: ");
      paramString1.append(paramWSPlayableHolder);
      WSLog.a("WSFollowContinuePlayLog", paramString1.toString());
    }
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    ((WSFollowPresenter)b()).a(false, false);
    ((WSFollowPresenter)b()).c();
  }
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    if (!this.k) {
      this.k = true;
    }
    ((WSFollowPresenter)b()).a(false, true);
  }
  
  public void a(List<stFeed> paramList)
  {
    f();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    WSFollowAdapter localWSFollowAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
    if (localWSFollowAdapter != null) {
      localWSFollowAdapter.fillList(paramList);
    }
    WSFeedDataManager.a().a(paramList);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.loadMoreComplete(true, true);
    }
  }
  
  public void a(List<stFeed> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.appendList(paramList);
    b(true, paramBoolean ^ true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.pullRefreshCompleted(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      WSFollowAdapter localWSFollowAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter;
      if ((localWSFollowAdapter != null) && (localWSFollowAdapter.getDataList().size() == 0)) {
        o();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, List<stFeed> paramList, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (!this.jdField_a_of_type_Boolean)) {
      this.i = true;
    }
  }
  
  protected void b()
  {
    this.g = true;
  }
  
  public void b(List<stFeed> paramList)
  {
    this.j = true;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.fillList(paramList);
    b(true, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.addFooterView(View.inflate(getBaseActivity(), 2131560411, null));
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.loadMoreComplete(paramBoolean1, paramBoolean2);
  }
  
  public boolean b()
  {
    return this.i;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.g = paramBoolean;
  }
  
  public boolean c()
  {
    return WSExpABTestManager.a().e();
  }
  
  public void d(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean d()
  {
    return (!this.n) && (c());
  }
  
  public void e()
  {
    ((WSFollowPresenter)b()).a(true, false);
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public void g()
  {
    WSLog.b("WSFollowFragment", "onTabSelected");
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
    if (localWSPlayerManager == null) {
      return;
    }
    this.g = true;
    a(a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition(), false));
    WSPlayerAudioControl.a().a(localWSPlayerManager.i() ^ true);
    if (!this.m)
    {
      n();
      this.m = true;
      return;
    }
    m();
  }
  
  public void h()
  {
    WSLog.b("WSFollowFragment", "onTabUnSelected");
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
    if (localWSPlayerManager == null) {
      return;
    }
    if (localWSPlayerManager.c()) {
      localWSPlayerManager.d();
    }
    WSPlayerAudioControl.a().a(false);
    ((WSFollowPresenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).e();
  }
  
  public void i()
  {
    this.n = true;
    WSFeedUtils.a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.h = true;
      paramInt1 = paramIntent.getIntExtra("key_feed_position", 0);
      String str = paramIntent.getStringExtra("key_from");
      paramIntent = paramIntent.getStringExtra("key_play_scene");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSFollowFragment.java][onActivityResult] from vertical position:");
      localStringBuilder.append(paramInt1);
      WSLog.e("WSFollowContinuePlayLog", localStringBuilder.toString());
      ThreadManager.getUIHandler().postDelayed(new WSFollowFragment.3(this, str, paramIntent, paramInt1), 100L);
    }
  }
  
  public boolean onBackEvent()
  {
    WsCommentPresenter localWsCommentPresenter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter;
    if (localWsCommentPresenter != null) {
      return localWsCommentPresenter.b();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.n = WSFeedUtils.a();
    paramBundle = new StringBuilder();
    paramBundle.append("进入瀑布流的时间：");
    paramBundle.append(this.jdField_a_of_type_Long);
    WSLog.a("weishi-beacon", paramBundle.toString());
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    l();
    WeiShiCacheManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.getDataList());
    WSSimpleEventBus.a().b(this);
    WSLikeAnimationManger.a().a();
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
    if (localWSPlayerManager != null)
    {
      localWSPlayerManager.d(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView().clearOnScrollListeners();
    WSMonitorUtil.a(getActivity());
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Boolean)
    {
      WSPublicAccReport.getInstance().reportPageVisitExit("focus");
      WSPlayerAudioControl.a().a(false);
    }
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
    if ((localWSPlayerManager != null) && (!d)) {
      localWSPlayerManager.f();
    }
    e(false);
    ((WSFollowPresenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).e();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boolean)
    {
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
      WSPlayerAudioControl.a().a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.i() ^ true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
    if (localObject != null)
    {
      ((WSPlayerManager)localObject).e();
      e(true);
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = 0L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("关注页初始化耗时：");
      ((StringBuilder)localObject).append(l1);
      WSLog.a("weishi-beacon", ((StringBuilder)localObject).toString());
      WsBeaconReportPresenter.a().a(true, l1, "focus", "focus");
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUserVisibleHint entered! visible: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", isResumed: ");
    localStringBuilder.append(isResumed());
    WSLog.b("WSFollowFragment", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment
 * JD-Core Version:    0.7.0.1
 */