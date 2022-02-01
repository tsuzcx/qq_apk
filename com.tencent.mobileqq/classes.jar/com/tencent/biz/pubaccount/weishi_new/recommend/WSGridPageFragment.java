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
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageIntentParams;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaData;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaWatchRecordEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.recommend.adapter.WSFollowDramaListAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.adapter.WSFollowDramaListAdapter.ItemViewExposedListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSExposeDataManager;
import com.tencent.biz.pubaccount.weishi_new.recommend.presenter.WSGridPresenterFactory;
import com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridEventUtils;
import com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridPageUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
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
  private stNotificationRsp jdField_a_of_type_UserGrowthStNotificationRsp;
  private Context jdField_a_of_type_AndroidContentContext;
  private final RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new WSGridPageFragment.3(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RichBlockDialog jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog;
  private final WSGuardInterfaceWrapper jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSGuardInterfaceWrapper = new WSGridPageFragment.6(this);
  private final WSRecommendAdapter.ItemViewExposeListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter$ItemViewExposeListener = new WSGridPageFragment.4(this);
  private WSRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
  private WSGridItemExpose jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose;
  private WSFollowDramaListAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendAdapterWSFollowDramaListAdapter;
  private WSXRecyclerView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView;
  private WeiShiNoticeView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView;
  private final XRecyclerView.RefreshCallback jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback = new WSGridPageFragment.2(this);
  private String jdField_a_of_type_JavaLangString;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean c;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j = false;
  private boolean k;
  
  private static Intent a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3)
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
  
  private View a()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      return localView;
    }
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560002, null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376872));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendAdapterWSFollowDramaListAdapter = new WSFollowDramaListAdapter(getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendAdapterWSFollowDramaListAdapter.setOnItemClickListener(new WSGridPageFragment.8(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendAdapterWSFollowDramaListAdapter.a(a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendAdapterWSFollowDramaListAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new WSItemDecoration());
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  private WSFollowDramaListAdapter.ItemViewExposedListener a()
  {
    return new WSGridPageFragment.9(this);
  }
  
  public static BaseFragment a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3)
  {
    WSGridPageFragment localWSGridPageFragment = new WSGridPageFragment();
    localWSGridPageFragment.setArguments(a(paramString1, paramBoolean1, paramBoolean2, paramString2, paramBoolean3).getExtras());
    return localWSGridPageFragment;
  }
  
  private RecyclerViewHeaderViewAdapter a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView;
    if ((localObject != null) && (((WSXRecyclerView)localObject).getRecyclerView() != null))
    {
      localObject = (RecyclerViewHeaderViewAdapter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView().getAdapter();
      if (localObject != null) {
        return localObject;
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    LoadingMoreHelper localLoadingMoreHelper = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getLoadMoreLayoutHelper();
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
    WSGridBeaconReport.b(this.jdField_a_of_type_JavaLangString, paramInt, paramWSFollowDramaItemData.a(), paramWSFollowDramaItemData.a());
    WSDramaPageFragment.a(new WSDramaPageIntentParams("grid_drama_follow", getContext()).a(paramWSFollowDramaItemData.a()));
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
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendAdapterWSFollowDramaListAdapter;
    if (localObject == null) {
      return;
    }
    localObject = ((WSFollowDramaListAdapter)localObject).getDataList();
    paramString = WSGridPageUtils.a((List)localObject, paramString);
    if (paramString == null) {
      return;
    }
    if (paramString.a() >= paramInt) {
      return;
    }
    paramString.a(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendAdapterWSFollowDramaListAdapter.notifyItemChanged(((List)localObject).indexOf(paramString));
  }
  
  private void n()
  {
    if (getArguments() != null)
    {
      this.g = getArguments().getBoolean("key_is_multi_sub_tab_page");
      this.jdField_a_of_type_JavaLangString = getArguments().getString("key_sub_tab_id");
      this.i = getArguments().getBoolean("key_can_init_data");
      this.jdField_b_of_type_JavaLangString = getArguments().getString("key_context_feed_id");
      this.k = getArguments().getBoolean("key_context_feed_show_musk");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSGridPageFragment.java][handleIntent] mSubTabId:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", mIsMultiSubTabPage:");
      localStringBuilder.append(this.g);
      localStringBuilder.append(", mCanInitData:");
      localStringBuilder.append(this.i);
      localStringBuilder.append(", this:");
      localStringBuilder.append(this);
      WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    }
  }
  
  private void o()
  {
    p();
    s();
    u();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372488);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370342));
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165327));
    }
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380853);
    if (this.g)
    {
      localView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, WeishiUIUtil.a(getActivity()), 0, 0);
    localView.setVisibility(0);
  }
  
  private void q()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java] initData! mSubTabId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    WSLog.f("WSGridPageFragmentLog", localStringBuilder.toString());
    this.h = true;
    ((WSGridPageContract.Presenter)b()).c();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSGuardInterfaceWrapper.a(this.jdField_a_of_type_JavaLangString);
    WSSimpleEventBus.a().a(this);
    x();
    if (((WSGridPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).c()) {
      ((WSGridPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).d();
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose = new WSGridItemExpose(this.jdField_a_of_type_JavaLangString);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView = ((WeiShiNoticeView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560025, null));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.setOnClickListener(new WSGridPageFragment.1(this));
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_UserGrowthStNotificationRsp == null) {
      return;
    }
    int m = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.a();
    WSNoticeJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_UserGrowthStNotificationRsp, this.jdField_a_of_type_JavaLangString);
    WSReportDc00898.a(112, m, this.jdField_a_of_type_UserGrowthStNotificationRsp.cid);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][noticeViewClick] mSubTabId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", jumpUrl");
    localStringBuilder.append(this.jdField_a_of_type_UserGrowthStNotificationRsp.jump_url);
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    k();
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView = ((WSXRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376306));
    a(WSExpABTestManager.a().c());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.setRefreshCallback(this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView().addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter = new WSRecommendAdapter(getActivity(), localRecyclerViewWithHeaderFooter, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.a(this.k);
    localRecyclerViewWithHeaderFooter.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter$ItemViewExposeListener);
    WSStaggeredGridLayoutManager localWSStaggeredGridLayoutManager = new WSStaggeredGridLayoutManager(2, 1);
    localWSStaggeredGridLayoutManager.setGapStrategy(0);
    localRecyclerViewWithHeaderFooter.setLayoutManager(localWSStaggeredGridLayoutManager);
    localRecyclerViewWithHeaderFooter.setItemAnimator(null);
    localRecyclerViewWithHeaderFooter.addItemDecoration(new WSItemDecoration());
  }
  
  private void v()
  {
    if (this.c)
    {
      this.c = false;
      return;
    }
    if (!this.d) {
      this.d = true;
    }
    ((WSGridPageContract.Presenter)b()).a(true, false);
    if (!this.f) {
      ((WSGridPageContract.Presenter)b()).a("");
    }
    if (((WSGridPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).c()) {
      ((WSGridPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).d();
    }
  }
  
  private void w()
  {
    ((WSGridPageContract.Presenter)b()).b(this.d, this.e);
  }
  
  private void x()
  {
    if (GuardManager.a != null) {
      GuardManager.a.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSGuardInterfaceWrapper);
    }
  }
  
  private void y()
  {
    if (GuardManager.a != null) {
      GuardManager.a.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSGuardInterfaceWrapper);
    }
  }
  
  private void z()
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.a()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][tryToLoadMoreFeeds] mSubTabId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    WSLog.a("WSGridPageFragmentLog", localStringBuilder.toString());
    a(WSExpABTestManager.a().d());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.a();
  }
  
  @NonNull
  public WSGridPageContract.Presenter a()
  {
    return WSGridPresenterFactory.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    if (((WSGridPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).c())
    {
      localArrayList.add(WSDramaFollowEvent.class);
      localArrayList.add(WSDramaWatchRecordEvent.class);
    }
    return localArrayList;
  }
  
  public List<stSimpleMetaFeed> a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.getDataList();
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_Boolean) {
      WeishiUtils.c("feeds");
    }
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSFallKeyPicMonitor.a().a(getActivity(), paramInt, paramstSimpleMetaFeed);
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][showError] mSubTabId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramString);
    WSLog.d("WSGridPageFragmentLog", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    WSReportDc00898.b(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new WSGridPageFragment.5(this));
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    if ((!WSUserAuthDialog.a()) && (paramstGlobalConfig != null) && (paramstGlobalConfig.windows_config != null))
    {
      if (paramstGlobalConfig.windows_config.size() == 0) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog = new RichBlockDialog(getActivity(), 0, 1, "feeds");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog.a(paramstGlobalConfig);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog.a(getActivity());
    }
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, RspHeaderBean paramRspHeaderBean)
  {
    this.jdField_a_of_type_UserGrowthStNotificationRsp = paramstNotificationRsp;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.a(paramstNotificationRsp, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(@NonNull WSFollowDramaData paramWSFollowDramaData, boolean paramBoolean)
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = a();
    if (localRecyclerViewHeaderViewAdapter == null) {
      return;
    }
    View localView = a();
    if (!localRecyclerViewHeaderViewAdapter.hasHeader(localView)) {
      localRecyclerViewHeaderViewAdapter.addHeader(localView);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendAdapterWSFollowDramaListAdapter.fillList(paramWSFollowDramaData.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(0);
    this.j = paramBoolean;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
    if (localObject != null)
    {
      localObject = ((WSRecommendAdapter)localObject).getDataList();
      if (localObject == null) {
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
      {
        WSGridEventUtils.a((LikeRspEvent)paramWSSimpleBaseEvent, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter, (List)localObject);
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
        ((WSGridPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).d();
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSDramaWatchRecordEvent))
      {
        paramWSSimpleBaseEvent = (WSDramaWatchRecordEvent)paramWSSimpleBaseEvent;
        a(paramWSSimpleBaseEvent.getDramaId(), paramWSSimpleBaseEvent.getEpisodeNum());
      }
    }
  }
  
  public void a(String paramString)
  {
    WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramString);
  }
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.fillList(paramList);
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.a(paramList, paramBoolean, WSGridPageUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView));
  }
  
  public void a(boolean paramBoolean)
  {
    WSXRecyclerView localWSXRecyclerView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView;
    if (localWSXRecyclerView != null)
    {
      this.c = paramBoolean;
      localWSXRecyclerView.startMachineRefresh();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadMoreComplete hasMore:");
    localStringBuilder.append(paramBoolean2);
    WSLog.a("WSGridPageFragmentLog", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.loadMoreComplete(true, paramBoolean2);
  }
  
  public boolean a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity != null) && (localFragmentActivity.isFinishing());
  }
  
  public void b()
  {
    this.f = true;
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView().getAdapter();
    a(localRecyclerViewHeaderViewAdapter, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView, this.jdField_b_of_type_AndroidViewView);
    localRecyclerViewHeaderViewAdapter.notifyDataSetChanged();
  }
  
  public void b(List<stSimpleMetaFeed> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.a(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.pullRefreshCompleted(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.a();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSGridPageFragment.java][onTabSelected] mSubTabId:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    WSLog.e("WSGridPageFragmentLog", ((StringBuilder)localObject).toString());
    localObject = a();
    if ((this.h) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.getItemCount() > 1))
    {
      int m = WSGridPageUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView);
      WSExposeDataManager.a().a(((List)localObject).subList(0, Math.min(m, ((List)localObject).size())));
      z();
    }
    else
    {
      m();
    }
    a((List)localObject, false);
  }
  
  public void h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][onTabUnselected] mSubTabId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    ((WSGridPageContract.Presenter)b()).j();
  }
  
  public void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][tryLoadMoreFeeds] mSubTabId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new WSGridPageFragment.7(this));
  }
  
  public void j()
  {
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = a();
    if (localRecyclerViewHeaderViewAdapter == null) {
      return;
    }
    if (!localRecyclerViewHeaderViewAdapter.hasHeader(this.jdField_b_of_type_AndroidViewView)) {
      return;
    }
    localRecyclerViewHeaderViewAdapter.removeHeader(this.jdField_b_of_type_AndroidViewView);
    localRecyclerViewHeaderViewAdapter.notifyDataSetChanged();
  }
  
  public void k()
  {
    this.f = false;
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSXRecyclerView.getRecyclerView().getAdapter();
    localRecyclerViewHeaderViewAdapter.removeHeader(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    localRecyclerViewHeaderViewAdapter.notifyDataSetChanged();
  }
  
  public void l()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.c();
  }
  
  public void m()
  {
    if (!this.h) {
      q();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    n();
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131560016, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    ((WSGridPageContract.Presenter)b()).g();
    super.onDestroyView();
    this.h = false;
    w();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.c();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.b();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.a();
    WSRecommendAdapter localWSRecommendAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
    if (localWSRecommendAdapter != null)
    {
      if (localWSRecommendAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = null;
      }
    }
    WSSimpleEventBus.a().b(this);
    y();
    WSRecommendAdapter.b = 0;
    WSMonitorUtil.a(getActivity());
    this.jdField_b_of_type_AndroidViewView = null;
  }
  
  public void onPause()
  {
    super.onPause();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][onResume] onPause:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mIsUserVisibleHint:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      WSPublicAccReport.getInstance().reportPageVisitExit("feeds");
    }
    ((WSGridPageContract.Presenter)b()).f();
  }
  
  public void onResume()
  {
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridPageFragment.java][onResume] mSubTabId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mIsUserVisibleHint:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    WSLog.e("WSGridPageFragmentLog", localStringBuilder.toString());
    ((WSGridPageContract.Presenter)b()).e();
    if (this.jdField_a_of_type_Boolean) {
      WSPublicAccReport.getInstance().reportPageVisitEnter("feeds");
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new StringBuilder();
    paramView.append("[WSGridPageFragment.java][onViewCreated] mCanInitData:");
    paramView.append(this.i);
    paramView.append(", this:");
    paramView.append(this);
    WSLog.e("WSGridPageFragmentLog", paramView.toString());
    o();
    r();
    if (this.i) {
      q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment
 * JD-Core Version:    0.7.0.1
 */