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
import com.tencent.biz.pubaccount.weishi_new.ui.HomeTabSelectListener;
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
  implements WSSimpleEventReceiver, IWSFollowView, HomeTabSelectListener
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
    int i1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter != null)
    {
      i1 = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      return null;
    }
    WSPlayableHolder localWSPlayableHolder;
    do
    {
      i1 += 1;
      if (i1 >= this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b().size()) {
        break;
      }
      localWSPlayableHolder = c(i1, paramBoolean);
    } while (localWSPlayableHolder == null);
    return localWSPlayableHolder;
    return null;
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
    if (paramWSPlayableHolder == null) {}
    while (WSFeedUtils.a(paramWSPlayableHolder.a()) < 50) {
      return false;
    }
    return true;
  }
  
  private WSPlayableHolder b(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      return null;
    }
    WSPlayableHolder localWSPlayableHolder;
    do
    {
      i1 -= 1;
      if (i1 < 0) {
        break;
      }
      localWSPlayableHolder = c(i1, paramBoolean);
    } while (localWSPlayableHolder == null);
    return localWSPlayableHolder;
  }
  
  private void b(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof WSFollowFeedHolder)) {
      ((WSFollowFeedHolder)localViewHolder).i();
    }
    do
    {
      return;
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
    } while (!(localViewHolder instanceof WSFollowFriendCollectionHolder));
    ((WSFollowFriendCollectionHolder)localViewHolder).b();
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
    Object localObject = (stFeed)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b().get(paramInt);
    if ((((stFeed)localObject).feed_type == 2) && (((stFeed)localObject).feed != null))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForLayoutPosition(paramInt);
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
    WSLog.e("WS_VIDEO_PLAY_TIME", "[WSFollowFragment.java][reportVideoPlay] tabSelectedIndex:" + WSHomeFragment.a + ", isPlay:" + paramBoolean);
    if ((WSHomeFragment.a != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter == null)) {
      return;
    }
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a());
      return;
    }
    b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a());
  }
  
  private void h()
  {
    WSSimpleEventBus.a().a(this);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(WeishiUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
  }
  
  private void j()
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
  
  private void k()
  {
    int i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
    int i2 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
    if ((i1 < 0) || (i2 >= this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b().size())) {}
    for (;;)
    {
      return;
      while (i1 <= i2)
      {
        b(i1);
        i1 += 1;
      }
    }
  }
  
  private void l()
  {
    int i2 = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      b(i1);
      i1 += 1;
    }
  }
  
  private void m()
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
    this.g = true;
  }
  
  public void a(int paramInt)
  {
    Object localObject2 = new StringBuilder().append("onTabSelected: ");
    if (paramInt == 0) {}
    for (Object localObject1 = "follow";; localObject1 = "recommend")
    {
      WSLog.b("WSFollowFragment", (String)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
      if (localObject1 != null) {
        break;
      }
      return;
    }
    if (paramInt != 0)
    {
      if (((WSPlayerManager)localObject1).c()) {
        ((WSPlayerManager)localObject1).d();
      }
      WSPlayerAudioControl.a().a(false);
      return;
    }
    this.g = true;
    a(a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition(), false));
    localObject2 = WSPlayerAudioControl.a();
    if (!((WSPlayerManager)localObject1).i()) {}
    for (boolean bool = true;; bool = false)
    {
      ((WSPlayerAudioControl)localObject2).a(bool);
      if (this.m) {
        break;
      }
      l();
      this.m = true;
      return;
    }
    k();
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof WSFollowFeedHolder)) {
      ((WSFollowFeedHolder)localViewHolder).a(paramstSimpleMetaFeed);
    }
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected void a(View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    WeiShiCacheManager.a().c(new WSFollowFragment.1(this));
    i();
    h();
    paramView = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369316);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370703));
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter = new WsCommentPresenter(this, 0);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      paramView.addView(localViewStub);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(new WSFollowFragment.2(this));
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((WSFollowPresenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramWSSimpleBaseEvent);
  }
  
  public void a(WSPlayableHolder paramWSPlayableHolder)
  {
    if ((this.g) && (a(paramWSPlayableHolder)))
    {
      WSLog.c("WSFollowContinuePlayLog", "[WSFollowFragment.java][onPlayFirstVideo] playVideo title:" + paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d + ", mPlayingHolder:" + paramWSPlayableHolder);
      b(paramWSPlayableHolder);
      paramWSPlayableHolder = a(paramWSPlayableHolder, true, true);
      WSLog.a("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onPlayFirstVideo] setPrePlayingHolder prePlayHolder:" + paramWSPlayableHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b(paramWSPlayableHolder);
    }
  }
  
  public void a(WSPlayableHolder paramWSPlayableHolder, String paramString1, String paramString2, int paramInt)
  {
    WSPlayerParam localWSPlayerParam = WSFeedDataManager.a().a();
    if (localWSPlayerParam == null) {}
    while ((paramWSPlayableHolder == null) || (localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper == null) || (localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView == null) || (paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null)) {
      return;
    }
    paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
    paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView;
    paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport = localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport;
    paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.c(true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a = paramWSPlayableHolder;
    WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false, paramInt);
    if (!this.f) {
      WSFollowBeaconReport.a(paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
    }
    paramString1 = a(paramWSPlayableHolder, true, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b(paramString1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a());
    this.e = true;
    this.f = false;
    WSLog.a("WSFollowContinuePlayLog", "WSFollowFragment handleOnActivityResultFromVertical()2, title: " + paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d + ", playingHolder: " + paramWSPlayableHolder);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    ((WSFollowPresenter)b()).a(false, false);
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(paramList);
    }
    WSFeedDataManager.a().a(paramList);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, true);
    }
  }
  
  public void a(List<stFeed> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b(paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(true, paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b().size() == 0)) {
      m();
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
    super.b();
    if (this.jdField_a_of_type_Boolean) {
      WeishiUtils.c("focus");
    }
  }
  
  public void b(List<stFeed> paramList)
  {
    this.j = true;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(paramList);
    b(true, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.a(View.inflate(getActivity(), 2131560524, null));
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean1, paramBoolean2);
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
      WSLog.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical position:" + paramInt1);
      ThreadManager.getUIHandler().postDelayed(new WSFollowFragment.3(this, str, paramIntent, paramInt1), 100L);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter.b();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.n = WSFeedUtils.a();
    WSLog.a("weishi-beacon", "进入瀑布流的时间：" + this.jdField_a_of_type_Long);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    j();
    WeiShiCacheManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowAdapter.b());
    WSSimpleEventBus.a().b(this);
    WSLikeAnimationManger.a().a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().clearOnScrollListeners();
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (!d)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
    }
    e(false);
  }
  
  public void onResume()
  {
    super.onResume();
    WSPlayerAudioControl localWSPlayerAudioControl;
    if (this.jdField_a_of_type_Boolean)
    {
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
      localWSPlayerAudioControl = WSPlayerAudioControl.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.i()) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      localWSPlayerAudioControl.a(bool);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e();
        e(true);
      }
      if (this.jdField_a_of_type_Long > 0L)
      {
        long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long = 0L;
        WSLog.a("weishi-beacon", "关注页初始化耗时：" + l1);
        WsBeaconReportPresenter.a().a(true, l1, "focus", "focus");
      }
      return;
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    WSLog.b("WSFollowFragment", "setUserVisibleHint entered! visible: " + paramBoolean + ", isResumed: " + isResumed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment
 * JD-Core Version:    0.7.0.1
 */