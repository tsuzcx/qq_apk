package com.tencent.biz.pubaccount.weishi_new.recommend;

import UserGrowth.stGlobalConfig;
import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.RichBlockDialog;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSGuardInterfaceWrapper;
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.ItemViewExposeListener;
import com.tencent.biz.pubaccount.weishi_new.WSStaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageIntentParams;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaData;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSChangeItemViewVisibilityEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaWatchRecordEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSaveFirstItemLocationCoverEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.recommend.adapter.WSFollowDramaListAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.adapter.WSFollowDramaListAdapter.ItemViewExposedListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSExposeDataManager;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.AbsWSGridBaseHolder;
import com.tencent.biz.pubaccount.weishi_new.recommend.presenter.WSGridPresenterFactory;
import com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridEventUtils;
import com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridPageUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionAnimUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSNoticeJumpUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;
import com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;
import java.util.ArrayList;
import java.util.List;

public class WSGridPageFragment
  extends WSBaseFragment<WSGridPageContract.View, WSGridPageContract.Presenter>
  implements WSSimpleEventReceiver, WSGridPageContract.View, OnTabSelectedListener
{
  private boolean A;
  private String B;
  private String C;
  private final XRecyclerView.RefreshCallback D = new WSGridPageFragment.2(this);
  private final RecyclerView.OnScrollListener E = new WSGridPageFragment.3(this);
  private final WSRecommendAdapter.ItemViewExposeListener F = new WSGridPageFragment.4(this);
  private final WSGuardInterfaceWrapper G = new WSGridPageFragment.6(this);
  private ViewGroup f;
  private WSXRecyclerView g;
  private LinearLayout h;
  private WeiShiNoticeView i;
  private View j;
  private WSGridItemExpose k;
  private stNotificationRsp l;
  private RichBlockDialog m;
  private WSRecommendAdapter n;
  private Context o;
  private View p;
  private WSFollowDramaListAdapter q;
  private RecyclerView r;
  private boolean s;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z = false;
  
  private void C()
  {
    this.i = ((WeiShiNoticeView)LayoutInflater.from(this.o).inflate(2131626068, null));
    this.i.setOnClickListener(new WSGridPageFragment.1(this));
  }
  
  private void D()
  {
    if (this.l == null) {
      return;
    }
    int i1 = this.i.getType();
    WSNoticeJumpUtils.a(this.o, this.l, this.B);
    WSReportDc00898.a(112, i1, this.l.cid);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][noticeViewClick] mSubTabId:");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", jumpUrl");
    localStringBuilder.append(this.l.jump_url);
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    o();
  }
  
  private void E()
  {
    this.g = ((WSXRecyclerView)this.f.findViewById(2131444517));
    a(WSExpABTestManager.a().o());
    this.g.setRefreshCallback(this.D);
    this.g.getRecyclerView().addOnScrollListener(this.E);
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.g.getRecyclerView();
    this.n = new WSRecommendAdapter(getActivity(), localRecyclerViewWithHeaderFooter, this.B, this.C);
    this.n.a(this.A);
    localRecyclerViewWithHeaderFooter.setAdapter(this.n);
    this.n.a(this.F);
    WSStaggeredGridLayoutManager localWSStaggeredGridLayoutManager = new WSStaggeredGridLayoutManager(2, 1);
    localWSStaggeredGridLayoutManager.setGapStrategy(0);
    localRecyclerViewWithHeaderFooter.setLayoutManager(localWSStaggeredGridLayoutManager);
    localRecyclerViewWithHeaderFooter.setItemAnimator(null);
    localRecyclerViewWithHeaderFooter.addItemDecoration(new WSItemDecoration());
  }
  
  private void F()
  {
    if (this.s)
    {
      this.s = false;
      return;
    }
    if (!this.t) {
      this.t = true;
    }
    ((WSGridPageContract.Presenter)aO_()).a(true, false);
    if (!this.v) {
      ((WSGridPageContract.Presenter)aO_()).a("");
    }
    if (((WSGridPageContract.Presenter)this.b).k()) {
      ((WSGridPageContract.Presenter)this.b).b();
    }
  }
  
  private void G()
  {
    ((WSGridPageContract.Presenter)aO_()).b(this.t, this.u);
  }
  
  private void H()
  {
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.registerCallBack(this.G);
    }
  }
  
  private void I()
  {
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.unregisterCallback(this.G);
    }
  }
  
  private RecyclerViewHeaderViewAdapter J()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((WSXRecyclerView)localObject).getRecyclerView() != null))
    {
      localObject = (RecyclerViewHeaderViewAdapter)this.g.getRecyclerView().getAdapter();
      if (localObject != null) {
        return localObject;
      }
    }
    return null;
  }
  
  private View K()
  {
    View localView = this.p;
    if (localView != null) {
      return localView;
    }
    this.p = LayoutInflater.from(getContext()).inflate(2131626045, null);
    this.r = ((RecyclerView)this.p.findViewById(2131445207));
    this.r.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    this.q = new WSFollowDramaListAdapter(getContext());
    this.q.setOnItemClickListener(new WSGridPageFragment.8(this));
    this.q.a(L());
    this.r.setAdapter(this.q);
    this.r.addItemDecoration(new WSItemDecoration());
    return this.p;
  }
  
  private WSFollowDramaListAdapter.ItemViewExposedListener L()
  {
    return new WSGridPageFragment.9(this);
  }
  
  private void M()
  {
    if (!this.g.a()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][tryToLoadMoreFeeds] mSubTabId:");
    localStringBuilder.append(this.B);
    WSLog.a("WSGridPageFragmentLog", localStringBuilder.toString());
    a(WSExpABTestManager.a().p());
  }
  
  private void N()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((WSXRecyclerView)localObject).getRecyclerView();
      if (localObject == null) {
        return;
      }
      int i1 = 0;
      while (i1 < ((RecyclerView)localObject).getChildCount())
      {
        RecyclerView.ViewHolder localViewHolder = ((RecyclerView)localObject).getChildViewHolder(((RecyclerView)localObject).getChildAt(i1));
        if (!(localViewHolder instanceof AbsWSGridBaseHolder))
        {
          i1 += 1;
        }
        else
        {
          localObject = (AbsWSGridBaseHolder)localViewHolder;
          WSVideoTransitionAnimUtil.a(((AbsWSGridBaseHolder)localObject).itemView);
          WSVideoTransitionAnimUtil.a(WSVideoTransitionAnimUtil.c(((AbsWSGridBaseHolder)localObject).itemView));
        }
      }
    }
  }
  
  public static BaseFragment a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3)
  {
    WSGridPageFragment localWSGridPageFragment = new WSGridPageFragment();
    localWSGridPageFragment.setArguments(b(paramString1, paramBoolean1, paramBoolean2, paramString2, paramBoolean3).getExtras());
    return localWSGridPageFragment;
  }
  
  private void a(int paramInt)
  {
    LoadingMoreHelper localLoadingMoreHelper = this.g.getLoadMoreLayoutHelper();
    if (localLoadingMoreHelper != null) {
      localLoadingMoreHelper.setPreLoaderCount(paramInt);
    }
  }
  
  private void a(int paramInt, @Nullable WSFollowDramaItemData paramWSFollowDramaItemData)
  {
    if (paramWSFollowDramaItemData == null)
    {
      WSLog.a("WSGridPageFragmentLog", "onFollowDramaItemClick() itemData is null.");
      return;
    }
    WSGridBeaconReport.b(this.B, paramInt, paramWSFollowDramaItemData.a(), paramWSFollowDramaItemData.c());
    WSDramaPageFragment.a(new WSDramaPageIntentParams("grid_drama_follow", getContext()).a(paramWSFollowDramaItemData.a()));
  }
  
  private void a(@Nullable RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramViewHolder != null)
    {
      if (paramViewHolder.itemView == null) {
        return;
      }
      paramViewHolder = paramViewHolder.itemView;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      paramViewHolder.setVisibility(i1);
    }
  }
  
  private void a(@NonNull WSChangeItemViewVisibilityEvent paramWSChangeItemViewVisibilityEvent)
  {
    if (this.n != null)
    {
      Object localObject1 = this.g;
      if (localObject1 != null)
      {
        localObject1 = ((WSXRecyclerView)localObject1).getRecyclerView();
        if (localObject1 == null) {
          return;
        }
        int i1 = 0;
        int i2 = 1;
        while (i1 < ((RecyclerView)localObject1).getChildCount())
        {
          RecyclerView.ViewHolder localViewHolder = ((RecyclerView)localObject1).getChildViewHolder(((RecyclerView)localObject1).getChildAt(i1));
          if ((localViewHolder instanceof AbsWSGridBaseHolder))
          {
            Object localObject2 = (AbsWSGridBaseHolder)localViewHolder;
            if ((((AbsWSGridBaseHolder)localObject2).b instanceof stSimpleMetaFeed))
            {
              localObject2 = (stSimpleMetaFeed)((AbsWSGridBaseHolder)localObject2).b;
              if ((paramWSChangeItemViewVisibilityEvent.isChangeFirstItem()) && (i2 != 0) && (((WSGridPageContract.Presenter)this.b).m()))
              {
                a(localViewHolder, paramWSChangeItemViewVisibilityEvent.isShow());
                return;
              }
              if ((!TextUtils.isEmpty(paramWSChangeItemViewVisibilityEvent.getFeedId())) && (paramWSChangeItemViewVisibilityEvent.getFeedId().equals(((stSimpleMetaFeed)localObject2).id)))
              {
                a(localViewHolder, paramWSChangeItemViewVisibilityEvent.isShow());
                return;
              }
              i2 = 0;
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void a(@NonNull RecyclerViewHeaderViewAdapter paramRecyclerViewHeaderViewAdapter, @NonNull View paramView1, @Nullable View paramView2)
  {
    if ((paramView2 != null) && (paramRecyclerViewHeaderViewAdapter.hasHeader(paramView2)))
    {
      paramRecyclerViewHeaderViewAdapter.removeHeader(paramView2);
      paramRecyclerViewHeaderViewAdapter.addHeader(paramView1);
      paramRecyclerViewHeaderViewAdapter.addHeader(paramView2);
      return;
    }
    paramRecyclerViewHeaderViewAdapter.addHeader(paramView1);
  }
  
  private void a(@Nullable String paramString, int paramInt)
  {
    Object localObject = this.q;
    if (localObject == null) {
      return;
    }
    localObject = ((WSFollowDramaListAdapter)localObject).getDataList();
    paramString = WSGridPageUtils.a((List)localObject, paramString);
    if (paramString == null) {
      return;
    }
    if (paramString.e() >= paramInt) {
      return;
    }
    paramString.a(paramInt);
    this.q.notifyItemChanged(((List)localObject).indexOf(paramString));
  }
  
  private static Intent b(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_multi_sub_tab_page", paramBoolean1);
    localBundle.putBoolean("key_context_feed_show_musk", paramBoolean3);
    localBundle.putString("key_sub_tab_id", paramString1);
    localBundle.putBoolean("key_can_init_data", paramBoolean2);
    localBundle.putString("key_context_feed_id", paramString2);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void t()
  {
    if (getArguments() != null)
    {
      this.w = getArguments().getBoolean("key_is_multi_sub_tab_page");
      this.B = getArguments().getString("key_sub_tab_id");
      this.y = getArguments().getBoolean("key_can_init_data");
      this.C = getArguments().getString("key_context_feed_id");
      this.A = getArguments().getBoolean("key_context_feed_show_musk");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSGridPageFragment.java][handleIntent] mSubTabId:");
      localStringBuilder.append(this.B);
      localStringBuilder.append(", mIsMultiSubTabPage:");
      localStringBuilder.append(this.w);
      localStringBuilder.append(", mCanInitData:");
      localStringBuilder.append(this.y);
      localStringBuilder.append(", this:");
      localStringBuilder.append(this);
      WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    }
  }
  
  private void v()
  {
    w();
    C();
    E();
    this.j = this.f.findViewById(2131440012);
    this.h = ((LinearLayout)this.f.findViewById(2131437600));
  }
  
  private void w()
  {
    if (this.e) {
      this.f.setBackgroundColor(this.o.getResources().getColor(2131165564));
    }
    View localView = this.f.findViewById(2131449831);
    if (this.w)
    {
      localView.setVisibility(8);
      return;
    }
    this.f.setPadding(0, WeishiUIUtil.a(getActivity()), 0, 0);
    localView.setVisibility(0);
  }
  
  private void x()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java] initData! mSubTabId:");
    localStringBuilder.append(this.B);
    WSLog.f("WSGridPageFragmentLog", localStringBuilder.toString());
    this.x = true;
    ((WSGridPageContract.Presenter)aO_()).a();
    this.G.a(this.B);
    WSSimpleEventBus.a().a(this);
    H();
    if (((WSGridPageContract.Presenter)this.b).k()) {
      ((WSGridPageContract.Presenter)this.b).b();
    }
  }
  
  private void y()
  {
    this.k = new WSGridItemExpose(this.B);
  }
  
  public void A()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSGridPageFragment.java][onTabSelected] mSubTabId:");
    ((StringBuilder)localObject).append(this.B);
    WSLog.e("WSGridPageFragmentLog", ((StringBuilder)localObject).toString());
    localObject = f();
    if ((this.x) && (this.n.getItemCount() > 1))
    {
      int i1 = WSGridPageUtils.a(this.g);
      WSExposeDataManager.a().a(((List)localObject).subList(0, Math.min(i1, ((List)localObject).size())));
      M();
    }
    else
    {
      q();
    }
    a((List)localObject, false);
  }
  
  public void B()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][onTabUnselected] mSubTabId:");
    localStringBuilder.append(this.B);
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    ((WSGridPageContract.Presenter)aO_()).j();
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSFallKeyPicMonitor.a().a(getActivity(), paramInt, paramstSimpleMetaFeed);
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][showError] mSubTabId:");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramString);
    WSLog.d("WSGridPageFragmentLog", localStringBuilder.toString());
    this.h.setVisibility(0);
    WSReportDc00898.b(false);
    this.h.setOnClickListener(new WSGridPageFragment.5(this));
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    if ((!WSUserAuthDialog.a()) && (paramstGlobalConfig != null) && (paramstGlobalConfig.windows_config != null))
    {
      if (paramstGlobalConfig.windows_config.size() == 0) {
        return;
      }
      if (this.m == null) {
        this.m = new RichBlockDialog(getActivity(), 0, 1, "feeds");
      }
      this.m.a(paramstGlobalConfig);
      this.m.a(getActivity());
    }
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, RspHeaderBean paramRspHeaderBean)
  {
    this.l = paramstNotificationRsp;
    this.i.a(paramstNotificationRsp, this.B);
  }
  
  public void a(@NonNull WSFollowDramaData paramWSFollowDramaData, boolean paramBoolean)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = J();
    if (localRecyclerViewHeaderViewAdapter == null) {
      return;
    }
    View localView = K();
    if (!localRecyclerViewHeaderViewAdapter.hasHeader(localView)) {
      localRecyclerViewHeaderViewAdapter.addHeader(localView);
    }
    this.q.fillList(paramWSFollowDramaData.a());
    this.r.scrollToPosition(0);
    this.z = paramBoolean;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      localObject = ((WSRecommendAdapter)localObject).getDataList();
      if (localObject == null) {
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
      {
        WSGridEventUtils.a((LikeRspEvent)paramWSSimpleBaseEvent, this.n, (List)localObject);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof FollowEvent))
      {
        WSGridEventUtils.a((FollowEvent)paramWSSimpleBaseEvent, (List)localObject);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSAddCommentEvent))
      {
        WSGridEventUtils.a((WSAddCommentEvent)paramWSSimpleBaseEvent, (List)localObject);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSDramaFollowEvent))
      {
        ((WSGridPageContract.Presenter)this.b).b();
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSDramaWatchRecordEvent))
      {
        paramWSSimpleBaseEvent = (WSDramaWatchRecordEvent)paramWSSimpleBaseEvent;
        a(paramWSSimpleBaseEvent.getDramaId(), paramWSSimpleBaseEvent.getEpisodeNum());
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSChangeItemViewVisibilityEvent))
      {
        a((WSChangeItemViewVisibilityEvent)paramWSSimpleBaseEvent);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSSaveFirstItemLocationCoverEvent)) {
        N();
      }
    }
  }
  
  public void a(String paramString)
  {
    WeishiActivityHelper.a(this.o, paramString);
  }
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    this.n.fillList(paramList);
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    this.k.a(paramList, paramBoolean, WSGridPageUtils.a(this.g));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      WSPublicAccReport.getInstance().reportPageVisitEnter("feeds");
      return;
    }
    WSPublicAccReport.getInstance().reportPageVisitExit("feeds");
  }
  
  protected boolean aN_()
  {
    if (WSComboExpHelper.a.a()) {
      return false;
    }
    return super.aN_();
  }
  
  public boolean aR_()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity != null) && (localFragmentActivity.isFinishing());
  }
  
  public boolean aS_()
  {
    return this.d;
  }
  
  public String aT_()
  {
    return this.C;
  }
  
  public void aU_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][tryLoadMoreFeeds] mSubTabId:");
    localStringBuilder.append(this.B);
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    this.g.getViewTreeObserver().addOnGlobalLayoutListener(new WSGridPageFragment.7(this));
  }
  
  public void b()
  {
    this.v = true;
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter)this.g.getRecyclerView().getAdapter();
    a(localRecyclerViewHeaderViewAdapter, this.i, this.p);
    localRecyclerViewHeaderViewAdapter.notifyDataSetChanged();
  }
  
  public void b(List<stSimpleMetaFeed> paramList)
  {
    this.n.a(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    this.g.pullRefreshCompleted(paramBoolean);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadMoreComplete hasMore:");
    localStringBuilder.append(paramBoolean2);
    WSLog.a("WSGridPageFragmentLog", localStringBuilder.toString());
    this.g.loadMoreComplete(true, paramBoolean2);
  }
  
  public void c()
  {
    this.k.b();
  }
  
  public void c_(boolean paramBoolean)
  {
    WSXRecyclerView localWSXRecyclerView = this.g;
    if (localWSXRecyclerView != null)
    {
      this.s = paramBoolean;
      localWSXRecyclerView.startMachineRefresh();
    }
  }
  
  public int d()
  {
    return this.k.a();
  }
  
  public List<stSimpleMetaFeed> f()
  {
    return this.n.getDataList();
  }
  
  protected void i()
  {
    super.i();
    if (this.d) {
      WeishiUtils.m("feeds");
    }
  }
  
  public void l()
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = J();
    if (localRecyclerViewHeaderViewAdapter == null) {
      return;
    }
    if (!localRecyclerViewHeaderViewAdapter.hasHeader(this.p)) {
      return;
    }
    localRecyclerViewHeaderViewAdapter.removeHeader(this.p);
    localRecyclerViewHeaderViewAdapter.notifyDataSetChanged();
  }
  
  @NonNull
  public WSGridPageContract.Presenter n()
  {
    return WSGridPresenterFactory.a(this.B);
  }
  
  public void o()
  {
    this.v = false;
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter)this.g.getRecyclerView().getAdapter();
    localRecyclerViewHeaderViewAdapter.removeHeader(this.i);
    localRecyclerViewHeaderViewAdapter.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    t();
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.o = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131626059, paramViewGroup, false);
    this.f = ((ViewGroup)paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    ((WSGridPageContract.Presenter)aO_()).e();
    super.onDestroyView();
    this.x = false;
    G();
    this.k.d();
    this.k.c();
    this.k.b();
    WSRecommendAdapter localWSRecommendAdapter = this.n;
    if (localWSRecommendAdapter != null)
    {
      if (localWSRecommendAdapter.b != null) {
        this.n.b = null;
      }
      if (this.n.c != null) {
        this.n.c = null;
      }
    }
    WSSimpleEventBus.a().b(this);
    I();
    WSRecommendAdapter.f = 0;
    WSMonitorUtil.a(getActivity());
    this.p = null;
  }
  
  public void onPause()
  {
    super.onPause();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][onResume] onPause:");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", mIsUserVisibleHint:");
    localStringBuilder.append(this.d);
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    ((WSGridPageContract.Presenter)aO_()).d();
  }
  
  public void onResume()
  {
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][onResume] mSubTabId:");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", mIsUserVisibleHint:");
    localStringBuilder.append(this.d);
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    ((WSGridPageContract.Presenter)aO_()).c();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new StringBuilder();
    paramView.append("[WSGridPageFragment.java][onViewCreated] mCanInitData:");
    paramView.append(this.y);
    paramView.append(", this:");
    paramView.append(this);
    WSLog.e("WSGridPageFragmentLog", paramView.toString());
    v();
    y();
    if (this.y) {
      x();
    }
  }
  
  public void p()
  {
    if (aR_()) {
      return;
    }
    this.k.d();
  }
  
  public void q()
  {
    if (!this.x) {
      x();
    }
  }
  
  public void r()
  {
    this.j.setVisibility(0);
  }
  
  public void s()
  {
    this.h.setVisibility(8);
  }
  
  public void u()
  {
    this.j.setVisibility(8);
  }
  
  public ArrayList<Class> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    localArrayList.add(WSChangeItemViewVisibilityEvent.class);
    if (((WSGridPageContract.Presenter)this.b).k())
    {
      localArrayList.add(WSDramaFollowEvent.class);
      localArrayList.add(WSDramaWatchRecordEvent.class);
    }
    if (((WSGridPageContract.Presenter)this.b).l()) {
      localArrayList.add(WSSaveFirstItemLocationCoverEvent.class);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment
 * JD-Core Version:    0.7.0.1
 */