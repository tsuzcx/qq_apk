package com.tencent.biz.pubaccount.weishi_new.recommend;

import UserGrowth.stGlobalConfig;
import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.weishi_new.RichBlockDialog;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSGuardInterfaceWrapper;
import com.tencent.biz.pubaccount.weishi_new.WSItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.ItemViewExposeListener;
import com.tencent.biz.pubaccount.weishi_new.WSStaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.recommend.presenter.WSGridPresenterFactory;
import com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridEventUtils;
import com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridPageUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSNoticeJumpUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;
import java.util.ArrayList;
import java.util.List;

public class WSGridPageFragment
  extends WSBaseFragment<WSGridPageContract.View, WSGridPageContract.Presenter>
  implements WSSimpleEventReceiver, WSGridPageContract.View
{
  private stNotificationRsp jdField_a_of_type_UserGrowthStNotificationRsp;
  private Context jdField_a_of_type_AndroidContentContext;
  private final RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new WSGridPageFragment.3(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RichBlockDialog jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog;
  private final WSGuardInterfaceWrapper jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSGuardInterfaceWrapper = new WSGridPageFragment.6(this);
  private final WSRecommendAdapter.ItemViewExposeListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter$ItemViewExposeListener = new WSGridPageFragment.4(this);
  private WSRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter;
  private WSGridItemExpose jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose;
  private WeiShiNoticeView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView;
  private final XRecyclerView.RefreshCallback jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback = new WSGridPageFragment.2(this);
  private XRecyclerView jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView;
  private String jdField_a_of_type_JavaLangString;
  private boolean c;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g;
  private boolean h;
  private boolean i;
  
  private static Intent a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_multi_sub_tab_page", paramBoolean1);
    localBundle.putString("key_sub_tab_id", paramString);
    localBundle.putBoolean("key_can_init_data", paramBoolean2);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public static Fragment a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    WSGridPageFragment localWSGridPageFragment = new WSGridPageFragment();
    localWSGridPageFragment.setArguments(a(paramString, paramBoolean1, paramBoolean2).getExtras());
    return localWSGridPageFragment;
  }
  
  private void j()
  {
    if (getArguments() != null)
    {
      this.g = getArguments().getBoolean("key_is_multi_sub_tab_page");
      this.jdField_a_of_type_JavaLangString = getArguments().getString("key_sub_tab_id");
      this.i = getArguments().getBoolean("key_can_init_data");
      WSLog.e("WSGridPageFragmentLog", "[WSGridPageFragment.java][onCreate] mSubTabId:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void k()
  {
    l();
    o();
    q();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372901);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370703));
  }
  
  private void l()
  {
    if (this.b) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165357));
    }
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131381622);
    if (this.g)
    {
      localView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, WeishiUIUtil.a(getActivity()), 0, 0);
    localView.setVisibility(0);
  }
  
  private void m()
  {
    WSLog.f("WSGridPageFragmentLog", "[WSGridPageFragment.java] initData! mSubTabId:" + this.jdField_a_of_type_JavaLangString);
    this.h = true;
    ((WSGridPageContract.Presenter)b()).a();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSGuardInterfaceWrapper.a(this.jdField_a_of_type_JavaLangString);
    WSSimpleEventBus.a().a(this);
    t();
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose = new WSGridItemExpose(this.jdField_a_of_type_JavaLangString);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView = ((WeiShiNoticeView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560142, null));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.setOnClickListener(new WSGridPageFragment.1(this));
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_UserGrowthStNotificationRsp == null) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.a();
    WSNoticeJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_UserGrowthStNotificationRsp, this.jdField_a_of_type_JavaLangString);
    WSReportDc00898.a(112, j, this.jdField_a_of_type_UserGrowthStNotificationRsp.cid);
    WSLog.e("WSGridPageFragmentLog", "[WSGridPageFragment.java][noticeViewClick] mSubTabId:" + this.jdField_a_of_type_JavaLangString + ", jumpUrl" + this.jdField_a_of_type_UserGrowthStNotificationRsp.jump_url);
    g();
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView = ((XRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376814));
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    if (localObject != null) {
      ((LoadingMoreHelper)localObject).a(12);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView$RefreshCallback);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter = new WSRecommendAdapter(getActivity(), (RecyclerViewWithHeaderFooter)localObject, this.jdField_a_of_type_JavaLangString);
    ((RecyclerViewWithHeaderFooter)localObject).setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter$ItemViewExposeListener);
    WSStaggeredGridLayoutManager localWSStaggeredGridLayoutManager = new WSStaggeredGridLayoutManager(2, 1);
    localWSStaggeredGridLayoutManager.setGapStrategy(0);
    ((RecyclerViewWithHeaderFooter)localObject).setLayoutManager(localWSStaggeredGridLayoutManager);
    ((RecyclerViewWithHeaderFooter)localObject).setItemAnimator(null);
    ((RecyclerViewWithHeaderFooter)localObject).addItemDecoration(new WSItemDecoration());
  }
  
  private void r()
  {
    if (this.c) {
      this.c = false;
    }
    do
    {
      return;
      if (!this.d) {
        this.d = true;
      }
      ((WSGridPageContract.Presenter)b()).a(true, false);
    } while (this.f);
    ((WSGridPageContract.Presenter)b()).a("");
  }
  
  private void s()
  {
    ((WSGridPageContract.Presenter)b()).b(this.d, this.e);
  }
  
  private void t()
  {
    if (GuardManager.a != null) {
      GuardManager.a.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSGuardInterfaceWrapper);
    }
  }
  
  private void u()
  {
    if (GuardManager.a != null) {
      GuardManager.a.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSGuardInterfaceWrapper);
    }
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
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    return localArrayList;
  }
  
  public List<stSimpleMetaFeed> a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.b();
  }
  
  public void a()
  {
    this.f = true;
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter();
    localRecyclerViewHeaderViewAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    localRecyclerViewHeaderViewAdapter.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    WSLog.e("WSGridPageFragmentLog", "[WSGridPageFragment.java][onTabSelected] mSubTabId:" + this.jdField_a_of_type_JavaLangString + ", index:" + paramInt);
    i();
    a(a(), false);
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSFallKeyPicMonitor.a().a(getActivity(), paramInt, paramstSimpleMetaFeed);
  }
  
  public void a(int paramInt, String paramString)
  {
    WSLog.d("WSGridPageFragmentLog", "[WSGridPageFragment.java][showError] mSubTabId:" + this.jdField_a_of_type_JavaLangString + ", code:" + paramInt + ", msg:" + paramString);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    WSReportDc00898.b(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new WSGridPageFragment.5(this));
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    if ((WSUserAuthDialog.a()) || (paramstGlobalConfig == null) || (paramstGlobalConfig.windows_config == null) || (paramstGlobalConfig.windows_config.size() == 0)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog = new RichBlockDialog(getActivity(), 0, 1, "feeds");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog.a(paramstGlobalConfig);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog.a(getActivity());
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, RspHeaderBean paramRspHeaderBean)
  {
    this.jdField_a_of_type_UserGrowthStNotificationRsp = paramstNotificationRsp;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.a(paramstNotificationRsp, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    List localList;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter != null)
    {
      localList = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.b();
      if (localList != null) {
        break label20;
      }
    }
    label20:
    do
    {
      return;
      if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
      {
        WSGridEventUtils.a((LikeRspEvent)paramWSSimpleBaseEvent, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter, localList);
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof FollowEvent))
      {
        WSGridEventUtils.a((FollowEvent)paramWSSimpleBaseEvent, localList);
        return;
      }
    } while (!(paramWSSimpleBaseEvent instanceof WSAddCommentEvent));
    WSGridEventUtils.a((WSAddCommentEvent)paramWSSimpleBaseEvent, localList);
  }
  
  public void a(String paramString)
  {
    WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramString);
  }
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.a(paramList);
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.a(paramList, paramBoolean, WSGridPageUtils.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      this.c = paramBoolean;
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.b();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, paramBoolean2);
  }
  
  public boolean a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return (localFragmentActivity != null) && (localFragmentActivity.isFinishing());
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Boolean) {
      WeishiUtils.c("feeds");
    }
  }
  
  public void b(List<stSimpleMetaFeed> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.a(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean);
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
    this.f = false;
    RecyclerViewHeaderViewAdapter localRecyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter)this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter();
    localRecyclerViewHeaderViewAdapter.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    localRecyclerViewHeaderViewAdapter.notifyDataSetChanged();
  }
  
  public void h()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.c();
  }
  
  public void i()
  {
    if (!this.h) {
      m();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    j();
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131560132, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    ((WSGridPageContract.Presenter)b()).f();
    super.onDestroyView();
    this.h = false;
    s();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.c();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.b();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendWSGridItemExpose.a();
    ImageManager.a().a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadListenerWrapper = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendAdapter.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = null;
      }
    }
    WSSimpleEventBus.a().b(this);
    u();
    WSRecommendAdapter.b = 0;
    WSMonitorUtil.a(getActivity());
  }
  
  public void onPause()
  {
    super.onPause();
    WSLog.e("WSGridPageFragmentLog", "[WSGridPageFragment.java][onResume] onPause:" + this.jdField_a_of_type_JavaLangString + ", mIsUserVisibleHint:" + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean) {
      WSPublicAccReport.getInstance().reportPageVisitExit("feeds");
    }
    ((WSGridPageContract.Presenter)b()).e();
  }
  
  public void onResume()
  {
    super.onResume();
    WSLog.e("WSGridPageFragmentLog", "[WSGridPageFragment.java][onResume] mSubTabId:" + this.jdField_a_of_type_JavaLangString + ", mIsUserVisibleHint:" + this.jdField_a_of_type_Boolean);
    ((WSGridPageContract.Presenter)b()).b();
    if (this.jdField_a_of_type_Boolean) {
      WSPublicAccReport.getInstance().reportPageVisitEnter("feeds");
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    WSLog.e("WSGridPageFragmentLog", "[WSGridPageFragment.java][onViewCreated] mCanInitData:" + this.i);
    k();
    n();
    if (this.i) {
      m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment
 * JD-Core Version:    0.7.0.1
 */