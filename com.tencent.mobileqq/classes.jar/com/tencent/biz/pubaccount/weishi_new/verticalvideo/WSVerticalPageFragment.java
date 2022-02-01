package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.RichBlockDialog;
import com.tencent.biz.pubaccount.weishi_new.WSAutoShowCommentParams;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.instancestate.WSInstanceStateManager;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeDefaultObserver;
import com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeObserver;
import com.tencent.biz.pubaccount.weishi_new.miniaio.MiniAIOPresenter;
import com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiHelper;
import com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiReport;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSOpenWeiShiData;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSBlockPage;
import com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSSystemNavigationBarUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.IWSEpisodeChoiceView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSEpisodeChoicePanel;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.WSVerticalDeltaTimeCalculatorManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalBaseHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCollectionTopAreaController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCommonTopAreaController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageTopAreaFactory;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WSVerticalPageFragment
  extends WSBaseFragment<WSVerticalPageContract.View, WSVerticalPageContract.Presenter>
  implements SwipeRefreshLayout.OnRefreshListener, WSSimpleEventReceiver, OnTabSelectedListener, WSVerticalDialogListener, WSVerticalPageContract.View, ListEventListener
{
  private static final WSVideoPageChangeObserver g = new WSVideoPageChangeDefaultObserver();
  private int A;
  private String B;
  private String C;
  private String D;
  private String E;
  private String F;
  private String G;
  private boolean H;
  private boolean I;
  private boolean J;
  private boolean K;
  private long L;
  private long M = 0L;
  private boolean N;
  private boolean O;
  private RecyclerView.OnScrollListener P = new WSVerticalPageFragment.3(this);
  public WsCommentPresenter f;
  private WSVideoPageChangeObserver h = g;
  private SystemBarCompact i;
  private WSSwipeRefreshLayout j;
  private VideoFeedsRecyclerView k;
  private TextView l;
  private ProgressBar m;
  private RichBlockDialog n;
  private WSBlockPage o;
  private ViewStub p;
  private final WSInstanceStateManager q = new WSInstanceStateManager();
  private WSVerticalDeltaTimeCalculatorManager r;
  private WSVerticalPageAdapter s;
  private List<WSVerticalItemData> t;
  private WSPlayerManager u;
  private MiniAIOPresenter v;
  private AbsWsUIGroup<Object> w;
  private AbsWsUIGroup x;
  private WSVerticalBaseHolder y;
  private WSEpisodeChoicePanel z;
  
  private void M()
  {
    WSSimpleEventBus.a().a(this);
  }
  
  private void N()
  {
    if (this.f == null)
    {
      WSLog.a("weishi-comment", "initCommentPresenter create!!!");
      this.f = new WsCommentPresenter(this, WSVerticalUtils.c(this.B));
      this.f.a(this);
      WSAutoShowCommentParams localWSAutoShowCommentParams = ((WSVerticalPageContract.Presenter)this.b).t();
      if (localWSAutoShowCommentParams != null)
      {
        this.f.a(localWSAutoShowCommentParams.getCommentId());
        this.f.b(localWSAutoShowCommentParams.getReplyId());
      }
    }
  }
  
  private void O()
  {
    if (getArguments() != null)
    {
      this.C = getArguments().getString("key_play_scene");
      this.D = getArguments().getString("key_sub_tab_id");
      this.E = getArguments().getString("key_feed_id");
      this.L = getArguments().getLong("key_start_time");
      this.J = getArguments().getBoolean("key_cal_delta_time");
      this.F = getArguments().getString("share_data_key");
      this.G = getArguments().getString("scheme_src_type");
      this.t = ((WSVerticalPageContract.Presenter)this.b).a((ArrayList)getArguments().getSerializable("key_feed_list"));
      this.A = ((WSVerticalPageContract.Presenter)this.b).a(getArguments().getInt("key_feed_position"));
      ((WSVerticalPageContract.Presenter)this.b).a(getArguments());
    }
  }
  
  private void P()
  {
    this.u = new WSPlayerManager(WeishiUtils.h());
    this.u.f(false);
    this.u.e(false);
    boolean bool = Q();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalPageFragment.java][initPlayerManager] isPlayerDoOnPause:");
    localStringBuilder.append(bool);
    WSLog.e("WSVerticalPageFragmentLog", localStringBuilder.toString());
  }
  
  private boolean Q()
  {
    if (!ba_())
    {
      this.u.q();
      return true;
    }
    return false;
  }
  
  private void R()
  {
    ((WSVerticalPageContract.Presenter)this.b).a();
    b(false, true);
  }
  
  private WSPlayerParam S()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = T();
    if (localWSVerticalVideoHolder != null) {
      return localWSVerticalVideoHolder.f;
    }
    return null;
  }
  
  private WSVerticalVideoHolder T()
  {
    WSVerticalPageAdapter localWSVerticalPageAdapter = b();
    if (localWSVerticalPageAdapter != null) {
      return localWSVerticalPageAdapter.b();
    }
    return null;
  }
  
  private void U()
  {
    WsCommentPresenter localWsCommentPresenter = this.f;
    if (localWsCommentPresenter != null)
    {
      localWsCommentPresenter.e();
      this.f = null;
    }
  }
  
  private void V()
  {
    if (TextUtils.equals("mini_app_personal_main", this.B))
    {
      WeishiUtils.m("homepage_main");
      return;
    }
    if (TextUtils.equals("mini_app_personal_guest", this.B)) {
      WeishiUtils.m("homepage_guest");
    }
  }
  
  private void W()
  {
    if (TextUtils.equals("aio_home_page", this.B))
    {
      if (this.d) {
        WeishiUtils.m("feeds_fullscreen");
      }
    }
    else {
      WeishiUtils.m("fullscreen_videoplay");
    }
  }
  
  private TextView a(@NonNull RecyclerView paramRecyclerView)
  {
    TextView localTextView = (TextView)LayoutInflater.from(getContext()).inflate(2131626086, null);
    paramRecyclerView.addOnLayoutChangeListener(new WSVerticalPageFragment.2(this, paramRecyclerView, localTextView));
    return localTextView;
  }
  
  public static WSVerticalPageFragment a(Bundle paramBundle)
  {
    WSVerticalPageFragment localWSVerticalPageFragment = new WSVerticalPageFragment();
    localWSVerticalPageFragment.setArguments(paramBundle);
    return localWSVerticalPageFragment;
  }
  
  public static WSVerticalPageFragment a(WSVerticalPageOpenParams paramWSVerticalPageOpenParams)
  {
    WSVerticalPageFragment localWSVerticalPageFragment = new WSVerticalPageFragment();
    localWSVerticalPageFragment.setArguments(paramWSVerticalPageOpenParams.v().getExtras());
    return localWSVerticalPageFragment;
  }
  
  private void a(int paramInt, BaseViewHolder paramBaseViewHolder, Map<String, String> paramMap)
  {
    if ((paramBaseViewHolder instanceof WSVerticalVideoHolder))
    {
      paramBaseViewHolder = (WSVerticalItemData)((WSVerticalVideoHolder)paramBaseViewHolder).e;
      if ((paramBaseViewHolder != null) && ((paramBaseViewHolder.b() instanceof stSimpleMetaFeed)))
      {
        paramBaseViewHolder = paramBaseViewHolder.b();
        if (TextUtils.equals(WSVerticalBeaconReport.c(this.B), "feeds_fullscreen")) {
          WSReportDC898Vertical.f();
        }
        WSVerticalBeaconReport.a(this.B, this.C, paramInt, paramBaseViewHolder, paramMap);
      }
    }
  }
  
  private void a(@Nullable Bundle paramBundle, @Nullable stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramBundle != null)
    {
      if (paramstSimpleMetaFeed == null) {
        return;
      }
      boolean bool = paramBundle.getBoolean("key_is_show_open_ws_dialog", false);
      paramBundle = new StringBuilder();
      paramBundle.append("isShowOpenWSDialog = ");
      paramBundle.append(bool);
      WSLog.e("WSVerticalPageFragmentLog", paramBundle.toString());
      if (!bool) {
        return;
      }
      paramBundle = WSExpABTestManager.a().x();
      paramBundle.e(paramstSimpleMetaFeed.weishi_jump_url);
      String str = WSVerticalBeaconReport.c(this.B);
      WSOpenWeiShiHelper.a().a(getContext(), paramBundle, WSOpenWeiShiReport.a(paramstSimpleMetaFeed, str, this.D, this.C));
    }
  }
  
  private void a(@Nullable WsCommentPresenter paramWsCommentPresenter, @Nullable WSAutoShowCommentParams paramWSAutoShowCommentParams)
  {
    if (paramWsCommentPresenter != null)
    {
      if (paramWSAutoShowCommentParams == null) {
        return;
      }
      if (!paramWSAutoShowCommentParams.isShowCommentPanel())
      {
        WSLog.e("WSVerticalPageFragmentLog", "no auto show comment panel.");
        return;
      }
      paramWsCommentPresenter.i();
    }
  }
  
  private void a(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if (paramWSPlayerManager == null) {
      return;
    }
    WSVerticalPageAdapter localWSVerticalPageAdapter = this.s;
    if ((localWSVerticalPageAdapter != null) && (localWSVerticalPageAdapter.b() != null)) {
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayerManager.r(), true, this.s.b().getAdapterPosition() - 1, ((WSVerticalPageContract.Presenter)this.b).n());
    }
    paramWSPlayerManager.t();
  }
  
  private boolean a(@Nullable WSVerticalPageAdapter paramWSVerticalPageAdapter)
  {
    return (paramWSVerticalPageAdapter != null) && (paramWSVerticalPageAdapter.a() != null) && (paramWSVerticalPageAdapter.a().size() != 0);
  }
  
  private void b(View paramView)
  {
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131449410);
    this.w = WSVerticalPageTopAreaFactory.a(this, this.B);
    AbsWsUIGroup localAbsWsUIGroup = this.w;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(localViewStub);
    }
    this.p = ((ViewStub)paramView.findViewById(2131449396));
    this.m = ((ProgressBar)paramView.findViewById(2131449419));
    P();
    c(paramView);
    d(paramView);
  }
  
  private void c(View paramView)
  {
    this.j = ((WSSwipeRefreshLayout)paramView.findViewById(2131440881));
    int i1 = WSDeviceUtils.a(getActivity());
    this.j.setProgressViewOffset(true, 0, WeishiUIUtil.s + i1);
    this.j.setOnRefreshListener(this);
    this.j.setOnInterceptTouchEventListener(new WSVerticalPageFragment.1(this));
  }
  
  private void d(View paramView)
  {
    this.k = ((VideoFeedsRecyclerView)paramView.findViewById(2131450284));
    this.k.setEnableFooterView(false);
    this.k.setExtraFooterCount(1);
    this.l = a(this.k);
    this.k.addFooterView(this.l);
    paramView = new WSVerticalLinearLayoutManager(getActivity(), this.k, 1, false);
    this.k.setLayoutManager(paramView);
    this.s = new WSVerticalPageAdapter(getActivity(), this);
    this.s.a(this.u);
    this.k.setAdapter(this.s);
    this.k.a(this);
    this.k.addOnScrollListener(this.P);
    List localList = this.t;
    if ((localList != null) && (localList.size() > 0)) {
      this.s.fillList(this.t);
    } else {
      r();
    }
    paramView.scrollToPosition(this.A);
  }
  
  private boolean e(int paramInt)
  {
    if ((paramInt != 0) && (paramInt + 1 < ((WSVerticalPageContract.Presenter)this.b).b()))
    {
      WSLog.b("WSVerticalPageFragmentLog", "onPreLoadMoreUp");
      return true;
    }
    return false;
  }
  
  private boolean f(int paramInt)
  {
    List localList = this.s.getDataList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCenterViewChanged currentPosition:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", dataList.size:");
    localStringBuilder.append(localList.size());
    WSLog.b("WSVerticalPageFragmentLog", localStringBuilder.toString());
    if ((paramInt != 0) && (localList.size() - paramInt - 1 < ((WSVerticalPageContract.Presenter)this.b).b()))
    {
      WSLog.b("WSVerticalPageFragmentLog", "onPreLoadMore");
      return true;
    }
    return false;
  }
  
  private void g(boolean paramBoolean)
  {
    WSVerticalPageContract.Presenter localPresenter = (WSVerticalPageContract.Presenter)aO_();
    if ((localPresenter instanceof AbsWSVerticalPagePresenter)) {
      ((AbsWSVerticalPagePresenter)localPresenter).b(paramBoolean);
    }
  }
  
  public void A()
  {
    WSLog.e("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onTabSelected]");
    this.d = true;
    WSPlayerManager localWSPlayerManager = this.u;
    if (localWSPlayerManager == null) {
      return;
    }
    localWSPlayerManager.p();
    g(true);
    WSPlayerAudioControl.a().a(true);
    W();
  }
  
  public void B()
  {
    WSLog.e("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onTabUnselected]");
    this.d = false;
    WSPlayerManager localWSPlayerManager = this.u;
    if (localWSPlayerManager == null) {
      return;
    }
    localWSPlayerManager.q();
    g(false);
  }
  
  public stSimpleMetaFeed C()
  {
    WSVerticalPageAdapter localWSVerticalPageAdapter = this.s;
    if ((localWSVerticalPageAdapter != null) && (localWSVerticalPageAdapter.getDataList() != null) && (this.s.getDataList().size() > 0)) {
      return ((WSVerticalItemData)this.s.getDataList().get(0)).b();
    }
    return null;
  }
  
  @NonNull
  public WSVerticalPageContract.Presenter D()
  {
    return WSVerticalPresenterFactory.a(this.B, this);
  }
  
  public void E()
  {
    Object localObject = c();
    if ((localObject != null) && (!((VideoFeedsRecyclerView)localObject).b()))
    {
      a(k(), l(), this.u);
      localObject = this.u;
      ((WSPlayerManager)localObject).b(((WSPlayerManager)localObject).r(), false);
    }
  }
  
  public stSimpleMetaFeed F()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = T();
    if ((localWSVerticalVideoHolder != null) && (localWSVerticalVideoHolder.e != null)) {
      return ((WSVerticalItemData)localWSVerticalVideoHolder.e).b();
    }
    return null;
  }
  
  public void G()
  {
    ((WSVerticalPageContract.Presenter)this.b).a(this.B);
  }
  
  public String H()
  {
    return this.G;
  }
  
  public int I()
  {
    return this.A;
  }
  
  public MiniAIOPresenter J()
  {
    return this.v;
  }
  
  public boolean K()
  {
    return ((WSVerticalPageContract.Presenter)this.b).k();
  }
  
  public WSPlayerParam L()
  {
    return ((WSVerticalPageContract.Presenter)this.b).l();
  }
  
  public void a(int paramInt)
  {
    WSPlayerManager localWSPlayerManager = this.u;
    if (localWSPlayerManager != null) {
      localWSPlayerManager.e(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.o == null) {
      this.o = new WSBlockPage();
    }
    if (!this.I)
    {
      this.I = true;
      this.o.a(this, paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    getActivity().setResult(paramInt, paramIntent);
  }
  
  public void a(int paramInt, WSPlayerParam paramWSPlayerParam)
  {
    this.r.a(paramInt, paramWSPlayerParam);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.x == null)
    {
      this.x = new WSVerticalPageErrorViewController(getActivity(), this);
      this.x.a(this.p);
    }
    this.p.setVisibility(0);
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    if (this.n == null)
    {
      int i1 = WSVerticalUtils.a(this.B);
      String str = WSVerticalBeaconReport.c(this.B);
      this.n = new RichBlockDialog(getActivity(), 1, i1, str);
      this.n.setOnDismissListener(new WSVerticalPageFragment.4(this));
    }
    if (!this.H)
    {
      this.H = true;
      this.n.a(paramstGlobalConfig);
      this.n.a(getActivity());
      paramstGlobalConfig = this.u;
      if (paramstGlobalConfig != null) {
        paramstGlobalConfig.q();
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCenterViewChanged: ");
    ((StringBuilder)localObject).append(paramViewHolder);
    WSLog.b("WSVerticalPageFragmentLog", ((StringBuilder)localObject).toString());
    if ((paramViewHolder instanceof WSVerticalBaseHolder))
    {
      localObject = (WSVerticalBaseHolder)paramViewHolder;
      int i1 = ((WSVerticalBaseHolder)localObject).getLayoutPosition() - 1;
      this.s.a((RecyclerView.ViewHolder)localObject, i1);
      ((WSVerticalPageContract.Presenter)this.b).a((RecyclerView.ViewHolder)localObject, i1);
      ((WSVerticalBaseHolder)localObject).c(i1);
      if (f(i1)) {
        b(false, false);
      } else if (e(i1)) {
        G();
      }
      a(i1, (BaseViewHolder)localObject, ((WSVerticalPageContract.Presenter)this.b).n());
      WSVerticalBaseHolder localWSVerticalBaseHolder = this.y;
      if ((localWSVerticalBaseHolder != null) && (localWSVerticalBaseHolder != paramViewHolder)) {
        localWSVerticalBaseHolder.d(i1);
      }
      this.y = ((WSVerticalBaseHolder)localObject);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(View paramView)
  {
    MiniAIOPresenter localMiniAIOPresenter = this.v;
    if (localMiniAIOPresenter != null) {
      localMiniAIOPresenter.a(paramView);
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((WSVerticalPageContract.Presenter)this.b).a(paramWSSimpleBaseEvent);
  }
  
  public void a(WSVideoPageChangeObserver paramWSVideoPageChangeObserver)
  {
    if (paramWSVideoPageChangeObserver == null) {
      return;
    }
    this.h = paramWSVideoPageChangeObserver;
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    this.r.a(paramWSPlayerParam);
    ((WSVerticalPageContract.Presenter)this.b).a(paramWSPlayerParam);
    if (!this.O)
    {
      this.O = true;
      a(this.f, ((WSVerticalPageContract.Presenter)this.b).t());
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    this.r.a(paramWSPlayerParam, paramInt1, paramInt2, paramString);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    ((WSVerticalPageContract.Presenter)this.b).a(paramWSPlayerParam, paramBoolean);
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject = T();
    if (localObject == null) {
      return;
    }
    localObject = ((WSVerticalVideoHolder)localObject).c;
    if ((localObject instanceof AbsWSVideoItemView)) {
      ((AbsWSVideoItemView)localObject).b(paramWSVerticalItemData);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData, int paramInt)
  {
    this.r.a(paramWSVerticalItemData, paramInt, this.B, this.C);
  }
  
  public void a(String paramString)
  {
    WSUserAuthDialog.a(getActivity(), paramString);
  }
  
  public void a(List<WSVerticalItemData> paramList)
  {
    this.s.fillList(paramList);
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
      WSVerticalBeaconReport.a(WSVerticalBeaconReport.c(this.B), this.C, ((WSVerticalPageContract.Presenter)aO_()).n());
      return;
    }
    B();
    WSVerticalBeaconReport.b(WSVerticalBeaconReport.c(this.B), this.C, ((WSVerticalPageContract.Presenter)aO_()).n());
  }
  
  protected MiniMsgUserParam aV_()
  {
    this.v = new MiniAIOPresenter();
    return this.v.a();
  }
  
  public void aX_()
  {
    WSSwipeRefreshLayout localWSSwipeRefreshLayout = this.j;
    if (localWSSwipeRefreshLayout != null) {
      localWSSwipeRefreshLayout.setRefreshing(false);
    }
  }
  
  public WSVerticalPageAdapter b()
  {
    return this.s;
  }
  
  public void b(int paramInt)
  {
    if (this.u != null)
    {
      boolean bool;
      if ((!((WSVerticalPageContract.Presenter)aO_()).p()) && (WSExpABTestManager.a().j())) {
        bool = true;
      } else {
        bool = false;
      }
      this.u.e(bool);
      if (this.u.h())
      {
        if (bool)
        {
          WSPlayerManager localWSPlayerManager = this.u;
          localWSPlayerManager.b(localWSPlayerManager.r(), false);
          return;
        }
        E();
      }
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    WSLog.d("WSVerticalPageFragmentLog", "[WSVerticalPageFragment][onCenterViewIdle]");
    ((WSVerticalPageContract.Presenter)this.b).c(paramViewHolder);
  }
  
  public void b(List<WSVerticalItemData> paramList)
  {
    this.s.b(paramList);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((WSVerticalPageContract.Presenter)this.b).a(paramBoolean1, paramBoolean2, this.B);
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    this.r.c(S());
  }
  
  public VideoFeedsRecyclerView c()
  {
    return this.k;
  }
  
  public void c(@ColorInt int paramInt)
  {
    WSSystemNavigationBarUtil.b(getActivity(), paramInt);
  }
  
  public void c(List<WSVerticalItemData> paramList)
  {
    this.s.a(paramList);
  }
  
  @Nullable
  public stSimpleMetaFeed d(@Nullable List<WSVerticalItemData> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0) && (paramList.get(0) != null)) {
      return ((WSVerticalItemData)paramList.get(0)).b();
    }
    return null;
  }
  
  public TextView d()
  {
    return this.l;
  }
  
  public void d(int paramInt)
  {
    AbsWsUIGroup localAbsWsUIGroup = this.w;
    if ((localAbsWsUIGroup instanceof WSVerticalPageCollectionTopAreaController)) {
      ((WSVerticalPageCollectionTopAreaController)localAbsWsUIGroup).d(paramInt);
    }
  }
  
  public WSPlayerManager e()
  {
    return this.u;
  }
  
  public void e(boolean paramBoolean)
  {
    AbsWsUIGroup localAbsWsUIGroup = this.w;
    if ((localAbsWsUIGroup instanceof WSVerticalPageCommonTopAreaController)) {
      ((WSVerticalPageCommonTopAreaController)localAbsWsUIGroup).a(paramBoolean);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    AbsWsUIGroup localAbsWsUIGroup = this.w;
    if ((localAbsWsUIGroup instanceof WSVerticalPageCommonTopAreaController)) {
      ((WSVerticalPageCommonTopAreaController)localAbsWsUIGroup).a(paramBoolean, this.v);
    }
  }
  
  public List<WSVerticalItemData> g()
  {
    return this.t;
  }
  
  protected boolean h()
  {
    return true;
  }
  
  protected void i()
  {
    super.i();
    W();
  }
  
  public String k()
  {
    return this.B;
  }
  
  public String l()
  {
    return this.C;
  }
  
  public String m()
  {
    return this.D;
  }
  
  public String n()
  {
    return this.E;
  }
  
  public void o()
  {
    WSLog.b("WSVerticalPageFragmentLog", "onLoadMore");
  }
  
  public boolean onBackEvent()
  {
    WsCommentPresenter localWsCommentPresenter = this.f;
    boolean bool2 = false;
    boolean bool1;
    if (localWsCommentPresenter != null) {
      bool1 = localWsCommentPresenter.r();
    } else {
      bool1 = false;
    }
    if ((this.b != null) && (!bool1)) {
      ((WSVerticalPageContract.Presenter)this.b).h();
    }
    if (!bool1)
    {
      bool1 = bool2;
      if (!super.onBackEvent()) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalPageFragment.java][onCreate] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(", getArguments():");
    localStringBuilder.append(getArguments());
    WSLog.e("WSVerticalPageFragmentLog", localStringBuilder.toString());
    this.M = System.currentTimeMillis();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("进入播放页的时间：");
    localStringBuilder.append(this.M);
    WSLog.a("weishi-beacon", localStringBuilder.toString());
    if (getArguments() != null) {
      this.B = getArguments().getString("key_from");
    }
    super.onCreate(paramBundle);
    ((WSVerticalPageContract.Presenter)this.b).d();
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.i = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    O();
    this.r = new WSVerticalDeltaTimeCalculatorManager();
    this.r.a(this.B, this.C, this.L, this.J);
    WSReportDC898Vertical.a(k(), WSVerticalBeaconReport.c(this.B), l());
    a(getArguments(), d(g()));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626061, paramViewGroup, false);
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("[WSVerticalPageFragment.java][onCreateView] savedInstanceState:");
    paramViewGroup.append(paramBundle);
    WSLog.e("WSVerticalPageFragmentLog", paramViewGroup.toString());
    b(paramLayoutInflater);
    R();
    N();
    M();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WSLog.e("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onDestroyView]");
    ((WSVerticalPageContract.Presenter)this.b).destroy();
    Object localObject = this.k;
    if (localObject != null)
    {
      ((VideoFeedsRecyclerView)localObject).h();
      this.k = null;
    }
    this.u = null;
    V();
    WSSimpleEventBus.a().b(this);
    WSLikeAnimationManger.a().b();
    U();
    localObject = this.s;
    if ((localObject != null) && (((WSVerticalPageAdapter)localObject).a() != null))
    {
      localObject = this.s.a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WSVerticalVideoHolder localWSVerticalVideoHolder = (WSVerticalVideoHolder)((Iterator)localObject).next();
        if (localWSVerticalVideoHolder != null) {
          localWSVerticalVideoHolder.e();
        }
      }
    }
    localObject = this.k;
    if (localObject != null) {
      ((VideoFeedsRecyclerView)localObject).removeOnScrollListener(this.P);
    }
    WSMonitorUtil.a(getActivity());
  }
  
  public void onPause()
  {
    super.onPause();
    WSLog.e("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onPause]");
    this.r.b(S());
    ((WSVerticalPageContract.Presenter)this.b).g();
    Object localObject = this.s;
    if ((localObject != null) && (((WSVerticalPageAdapter)localObject).b() != null))
    {
      localObject = this.s.b();
      if (localObject != null) {
        ((WSVerticalVideoHolder)localObject).d();
      }
    }
    ((WSVerticalPageContract.Presenter)this.b).j();
  }
  
  public void onRefresh()
  {
    WSLog.b("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onRefresh]");
    ((WSVerticalPageContract.Presenter)this.b).b(this.B);
  }
  
  public void onResume()
  {
    super.onResume();
    WSLog.e("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onResume]");
    WSReportDC898Vertical.a(WSVerticalBeaconReport.c(this.B), l());
    ((WSVerticalPageContract.Presenter)this.b).f();
    Object localObject = this.s;
    if ((localObject != null) && (((WSVerticalPageAdapter)localObject).b() != null))
    {
      localObject = this.s.b();
      if (localObject != null) {
        ((WSVerticalVideoHolder)localObject).c();
      }
    }
    com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.j = false;
    localObject = this.i;
    if (localObject != null) {
      ((SystemBarCompact)localObject).setStatusBarVisible(2, 0);
    }
    if (this.M > 0L)
    {
      long l1 = System.currentTimeMillis() - this.M;
      this.M = 0L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("播放页初始化耗时：");
      ((StringBuilder)localObject).append(l1);
      WSLog.a("weishi-beacon", ((StringBuilder)localObject).toString());
      WsBeaconReportPresenter.a().a(true, l1, "fullscreen_videoplay", this.C);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.q.a(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalPageFragment.java][onSaveInstanceState] outState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSVerticalPageFragmentLog", localStringBuilder.toString());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new StringBuilder();
    paramView.append("[WSVerticalPageFragment.java][onViewCreated] savedInstanceState:");
    paramView.append(paramBundle);
    WSLog.e("WSVerticalPageFragmentLog", paramView.toString());
    ((WSVerticalPageContract.Presenter)this.b).e();
    paramBundle = this.r;
    paramView = this.t;
    if ((paramView != null) && (paramView.size() > 0)) {
      paramView = (WSVerticalItemData)this.t.get(0);
    } else {
      paramView = null;
    }
    paramBundle.a(paramView);
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalPageFragment.java][onViewStateRestored] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSVerticalPageFragmentLog", localStringBuilder.toString());
    this.q.b(paramBundle);
  }
  
  public String p()
  {
    return this.F;
  }
  
  public boolean q()
  {
    return ba_();
  }
  
  public void r()
  {
    this.m.setVisibility(0);
  }
  
  public void s()
  {
    this.p.setVisibility(8);
  }
  
  public boolean t()
  {
    return (getActivity() != null) && (getActivity().isFinishing());
  }
  
  public void u()
  {
    this.m.setVisibility(8);
  }
  
  public IWSEpisodeChoiceView v()
  {
    if (this.z == null) {
      this.z = WSEpisodeChoicePanel.a(this);
    }
    return this.z;
  }
  
  public WSVideoPageChangeObserver w()
  {
    return this.h;
  }
  
  public void x()
  {
    Object localObject = this.u;
    if (localObject == null) {
      return;
    }
    this.N = ((WSPlayerManager)localObject).s();
    this.u.e(true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEntireViewStartDrag() mIsPlayLoopBeforeDrag = ");
    ((StringBuilder)localObject).append(this.N);
    WSLog.e("WSVerticalPageFragmentLog", ((StringBuilder)localObject).toString());
  }
  
  public void y()
  {
    Object localObject = this.u;
    if (localObject == null) {
      return;
    }
    ((WSPlayerManager)localObject).e(this.N);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEntireViewEndDrag() mIsPlayLoopBeforeDrag = ");
    ((StringBuilder)localObject).append(this.N);
    WSLog.e("WSVerticalPageFragmentLog", ((StringBuilder)localObject).toString());
  }
  
  public ArrayList<Class> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSUserAuthEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    localArrayList.add(WSClearModeEvent.class);
    localArrayList.add(WSDramaFollowEvent.class);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment
 * JD-Core Version:    0.7.0.1
 */