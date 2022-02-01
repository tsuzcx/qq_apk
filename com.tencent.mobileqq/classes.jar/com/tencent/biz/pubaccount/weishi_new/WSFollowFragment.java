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
  public static boolean j;
  private long A = 0L;
  public WsCommentPresenter k;
  private WSFollowAdapter l;
  private LinearLayoutManager m;
  private WSPlayerManager n;
  private LinearLayout o;
  private WSPlayableHolder p;
  private boolean q = true;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  private void G()
  {
    WSSimpleEventBus.a().a(this);
  }
  
  private void H()
  {
    this.n = new WSPlayerManager(WeishiUtils.h());
    this.n.e(true);
    this.l.a(this.n);
  }
  
  private void I()
  {
    if (!this.v)
    {
      com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.e = 2;
      return;
    }
    if ((!this.w) && (!this.x))
    {
      com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.e = 3;
      return;
    }
    com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.e = 1;
  }
  
  private void J()
  {
    int i = this.m.findFirstVisibleItemPosition();
    int i1 = this.m.findLastVisibleItemPosition();
    if (i >= 0)
    {
      if (i1 >= this.l.getDataList().size()) {
        return;
      }
      while (i <= i1)
      {
        a(i);
        i += 1;
      }
    }
  }
  
  private void K()
  {
    int i1 = this.h.getRecyclerView().getChildCount();
    int i = 0;
    while (i < i1)
    {
      a(i);
      i += 1;
    }
  }
  
  private void L()
  {
    WSLog.b("WSFollowFragment", "showErrorView");
    this.o.setVisibility(0);
    WSReportDc00898.b(false);
    this.o.setOnClickListener(new WSFollowFragment.4(this));
  }
  
  private WSPlayableHolder a(int paramInt, boolean paramBoolean)
  {
    if (this.l != null)
    {
      int i = paramInt;
      if (paramInt < 0) {
        return null;
      }
      while (i < this.l.getDataList().size())
      {
        WSPlayableHolder localWSPlayableHolder = c(i, paramBoolean);
        if (localWSPlayableHolder != null) {
          return localWSPlayableHolder;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.h.getRecyclerView().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof WSFollowFeedHolder))
    {
      ((WSFollowFeedHolder)localViewHolder).l();
      return;
    }
    if ((localViewHolder instanceof WSFollowPersonHolder))
    {
      ((WSFollowPersonHolder)localViewHolder).b();
      return;
    }
    if ((localViewHolder instanceof WSFollowSeparateHolder1))
    {
      ((WSFollowSeparateHolder1)localViewHolder).a();
      return;
    }
    if ((localViewHolder instanceof WSFollowFriendCollectionHolder)) {
      ((WSFollowFriendCollectionHolder)localViewHolder).c();
    }
  }
  
  private void a(WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.g()))
    {
      WSFollowBeaconReport.a(paramWSPlayerManager.r());
      this.q = true;
      this.r = true;
    }
  }
  
  private WSPlayableHolder b(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt < 0) {
      return null;
    }
    while (i >= 0)
    {
      WSPlayableHolder localWSPlayableHolder = c(i, paramBoolean);
      if (localWSPlayableHolder != null) {
        return localWSPlayableHolder;
      }
      i -= 1;
    }
    return null;
  }
  
  private void b(WSPlayableHolder paramWSPlayableHolder)
  {
    this.p = paramWSPlayableHolder;
    this.l.a(paramWSPlayableHolder);
    this.s = false;
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if ((this.q) && (paramWSPlayerManager != null) && ((paramWSPlayerManager.g()) || (paramWSPlayerManager.f())))
    {
      WSFollowBeaconReport.a(paramWSPlayerManager.r(), false);
      paramWSPlayerManager.t();
    }
    this.q = false;
  }
  
  private WSPlayableHolder c(int paramInt, boolean paramBoolean)
  {
    Object localObject = (stFeed)this.l.getDataList().get(paramInt);
    if ((((stFeed)localObject).feed_type == 2) && (((stFeed)localObject).feed != null))
    {
      localObject = this.h.getRecyclerView().findViewHolderForLayoutPosition(paramInt);
      if ((localObject instanceof WSPlayableHolder))
      {
        localObject = (WSPlayableHolder)localObject;
        if ((c((WSPlayableHolder)localObject)) || (paramBoolean)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private boolean c(WSPlayableHolder paramWSPlayableHolder)
  {
    boolean bool = false;
    if (paramWSPlayableHolder == null) {
      return false;
    }
    if (WSFeedUtils.a(paramWSPlayableHolder.k()) >= 50) {
      bool = true;
    }
    return bool;
  }
  
  private void i(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFollowFragment.java][reportVideoPlay] tabSelectedIndex:");
    ((StringBuilder)localObject).append(WSHomeFragment.f);
    ((StringBuilder)localObject).append(", isPlay:");
    ((StringBuilder)localObject).append(paramBoolean);
    WSLog.e("WS_VIDEO_PLAY_TIME", ((StringBuilder)localObject).toString());
    if (WSHomeFragment.f == 0)
    {
      localObject = this.l;
      if (localObject == null) {
        return;
      }
      if (paramBoolean)
      {
        a(((WSFollowAdapter)localObject).e());
        return;
      }
      b(((WSFollowAdapter)localObject).e());
    }
  }
  
  public void A()
  {
    WSLog.b("WSFollowFragment", "onTabSelected");
    WSPlayerManager localWSPlayerManager = this.n;
    if (localWSPlayerManager == null) {
      return;
    }
    this.s = true;
    int i = this.m.findFirstVisibleItemPosition();
    WSPlayableHolder localWSPlayableHolder = this.p;
    if (localWSPlayableHolder == null) {
      localWSPlayableHolder = a(i, true);
    }
    a(localWSPlayableHolder);
    WSPlayerAudioControl.a().a(localWSPlayerManager.o() ^ true);
    if (!this.y)
    {
      K();
      this.y = true;
      return;
    }
    J();
  }
  
  public void B()
  {
    WSLog.b("WSFollowFragment", "onTabUnSelected");
    WSPlayerManager localWSPlayerManager = this.n;
    if (localWSPlayerManager == null) {
      return;
    }
    if (localWSPlayerManager.g()) {
      localWSPlayerManager.n();
    }
    WSPlayerAudioControl.a().a(false);
    ((WSFollowPresenter)this.b).d();
  }
  
  public boolean C()
  {
    return WSExpABTestManager.a().k();
  }
  
  public boolean D()
  {
    return (!this.z) && (C());
  }
  
  public void E()
  {
    this.z = true;
    WSFeedUtils.b();
  }
  
  public boolean F()
  {
    return this.q;
  }
  
  public WSPlayableHolder a(WSPlayableHolder paramWSPlayableHolder, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramWSPlayableHolder != null)
    {
      int i = paramWSPlayableHolder.getLayoutPosition();
      if (paramBoolean1) {
        return a(i + 1, paramBoolean2);
      }
      return b(i - 1, paramBoolean2);
    }
    return null;
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    RecyclerView.ViewHolder localViewHolder = this.h.getRecyclerView().findViewHolderForAdapterPosition(paramInt);
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
    H();
    G();
    paramView = (FrameLayout)this.g.findViewById(2131436011);
    this.o = ((LinearLayout)this.g.findViewById(2131437600));
    if (this.k == null)
    {
      this.k = new WsCommentPresenter(this, 0);
      ViewStub localViewStub = new ViewStub(getBaseActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      paramView.addView(localViewStub);
    }
    this.h.getRecyclerView().addOnScrollListener(new WSFollowFragment.2(this));
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((WSFollowPresenter)this.b).a(paramWSSimpleBaseEvent);
  }
  
  public void a(WSPlayableHolder paramWSPlayableHolder)
  {
    if ((this.s) && (paramWSPlayableHolder != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSFollowFragment.java][onPlayFirstVideo] playVideo title:");
      localStringBuilder.append(paramWSPlayableHolder.a.g);
      localStringBuilder.append(", mPlayingHolder:");
      localStringBuilder.append(paramWSPlayableHolder);
      WSLog.c("WSFollowContinuePlayLog", localStringBuilder.toString());
      b(paramWSPlayableHolder);
      paramWSPlayableHolder = a(paramWSPlayableHolder, true, true);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSFollowFragment.java][onPlayFirstVideo] setPrePlayingHolder prePlayHolder:");
      localStringBuilder.append(paramWSPlayableHolder);
      WSLog.a("WS_VIDEO_PRE_PLAY", localStringBuilder.toString());
      this.l.b(paramWSPlayableHolder);
    }
  }
  
  public void a(WSPlayableHolder paramWSPlayableHolder, String paramString1, String paramString2, int paramInt)
  {
    WSPlayerParam localWSPlayerParam = WSFeedDataManager.a().b();
    if (localWSPlayerParam == null) {
      return;
    }
    if (paramWSPlayableHolder == null) {
      return;
    }
    if ((localWSPlayerParam.d != null) && (localWSPlayerParam.b != null) && (paramWSPlayableHolder.b != null) && (this.n != null))
    {
      paramWSPlayableHolder.b.d = localWSPlayerParam.d;
      paramWSPlayableHolder.b.b = localWSPlayerParam.b;
      paramWSPlayableHolder.b.l = localWSPlayerParam.l;
      paramWSPlayableHolder.b.d.d(true);
      this.l.b = paramWSPlayableHolder;
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayableHolder.b, false, paramInt, null);
      if (!this.r) {
        WSFollowBeaconReport.a(paramWSPlayableHolder.b);
      }
      paramString1 = a(paramWSPlayableHolder, true, true);
      this.l.b(paramString1);
      this.n.a(paramWSPlayableHolder.b, true);
      this.n.c(this.l.b());
      this.q = true;
      this.r = false;
      paramString1 = new StringBuilder();
      paramString1.append("WSFollowFragment handleOnActivityResultFromVertical()2, title: ");
      paramString1.append(paramWSPlayableHolder.b.c.g);
      paramString1.append(", playingHolder: ");
      paramString1.append(paramWSPlayableHolder);
      WSLog.a("WSFollowContinuePlayLog", paramString1.toString());
    }
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    ((WSFollowPresenter)aO_()).a(false, false);
    ((WSFollowPresenter)aO_()).b();
  }
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    if (!this.w) {
      this.w = true;
    }
    ((WSFollowPresenter)aO_()).a(false, true);
  }
  
  public void a(List<stFeed> paramList)
  {
    u();
    if (this.o.isShown()) {
      this.o.setVisibility(8);
    }
    WSFollowAdapter localWSFollowAdapter = this.l;
    if (localWSFollowAdapter != null) {
      localWSFollowAdapter.fillList(paramList);
    }
    WSFeedDataManager.a().a(paramList);
    if (this.h != null) {
      this.h.loadMoreComplete(true, true);
    }
  }
  
  public void a(List<stFeed> paramList, boolean paramBoolean)
  {
    if (this.o.isShown()) {
      this.o.setVisibility(8);
    }
    this.l.appendList(paramList);
    c(true, paramBoolean ^ true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (paramBoolean2) {
      return;
    }
    if (paramBoolean1)
    {
      A();
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
      return;
    }
    B();
    WSPublicAccReport.getInstance().reportPageVisitExit("focus");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, List<stFeed> paramList, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (!this.d)) {
      this.u = true;
    }
  }
  
  public void b(List<stFeed> paramList)
  {
    this.v = true;
    if (this.o.isShown()) {
      this.o.setVisibility(8);
    }
    this.l.fillList(paramList);
    c(true, true);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      WSFollowAdapter localWSFollowAdapter = this.l;
      if ((localWSFollowAdapter != null) && (localWSFollowAdapter.getDataList().size() == 0)) {
        L();
      }
    }
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.l.addFooterView(View.inflate(getBaseActivity(), 2131626456, null));
    }
    this.h.loadMoreComplete(paramBoolean1, paramBoolean2);
  }
  
  public void e(boolean paramBoolean)
  {
    this.h.pullRefreshCompleted(paramBoolean);
  }
  
  public void f(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void g(boolean paramBoolean)
  {
    if (!this.d) {
      return;
    }
    this.s = paramBoolean;
  }
  
  public void h(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  protected void i()
  {
    super.i();
    if (this.d) {
      WeishiUtils.m("focus");
    }
  }
  
  protected void o()
  {
    this.s = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.t = true;
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
    WsCommentPresenter localWsCommentPresenter = this.k;
    if (localWsCommentPresenter != null) {
      return localWsCommentPresenter.r();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.A = System.currentTimeMillis();
    this.z = WSFeedUtils.c();
    paramBundle = new StringBuilder();
    paramBundle.append("进入瀑布流的时间：");
    paramBundle.append(this.A);
    WSLog.a("weishi-beacon", paramBundle.toString());
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    I();
    WeiShiCacheManager.a().a(this.l.getDataList());
    WSSimpleEventBus.a().b(this);
    WSLikeAnimationManger.a().b();
    WSPlayerManager localWSPlayerManager = this.n;
    if (localWSPlayerManager != null)
    {
      localWSPlayerManager.d(true);
      this.n = null;
    }
    this.h.getRecyclerView().clearOnScrollListeners();
    WSMonitorUtil.a(getActivity());
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.d) {
      WSPlayerAudioControl.a().a(false);
    }
    WSPlayerManager localWSPlayerManager = this.n;
    if ((localWSPlayerManager != null) && (!j)) {
      localWSPlayerManager.q();
    }
    i(false);
    ((WSFollowPresenter)this.b).d();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.d) {
      WSPlayerAudioControl.a().a(this.n.o() ^ true);
    }
    Object localObject = this.n;
    if (localObject != null)
    {
      ((WSPlayerManager)localObject).p();
      i(true);
    }
    if (this.A > 0L)
    {
      long l1 = System.currentTimeMillis() - this.A;
      this.A = 0L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("关注页初始化耗时：");
      ((StringBuilder)localObject).append(l1);
      WSLog.a("weishi-beacon", ((StringBuilder)localObject).toString());
      WsBeaconReportPresenter.a().a(true, l1, "focus", "focus");
    }
  }
  
  protected BaseAdapter p()
  {
    this.l = new WSFollowAdapter(this);
    return this.l;
  }
  
  protected RecyclerView.LayoutManager q()
  {
    this.m = new WSFollowLinearLayoutManager(this.f, 1, false);
    return this.m;
  }
  
  public void t()
  {
    ((WSFollowPresenter)aO_()).a(true, false);
  }
  
  @NonNull
  public WSFollowPresenter v()
  {
    return new WSFollowPresenter();
  }
  
  public boolean w()
  {
    return this.u;
  }
  
  public WSFollowAdapter x()
  {
    return this.l;
  }
  
  public XRecyclerView y()
  {
    return this.h;
  }
  
  public ArrayList<Class> z()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment
 * JD-Core Version:    0.7.0.1
 */