package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import afez;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import ayxh;
import blsy;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import rsp;
import ucn;
import uea;
import uej;
import ufr;
import uhf;
import uhi;
import ujq;
import uju;
import ukq;
import uoa;
import uoc;
import uoi;
import upe;
import upu;
import uqf;
import uqh;
import uqs;
import uqt;
import urd;
import uri;
import urj;
import url;
import uro;
import urq;
import uru;
import urv;
import urw;
import ury;
import urz;
import usa;
import usc;
import usd;
import usv;
import usw;
import uts;
import uuy;
import uvv;

public class WSVerticalPageFragment
  extends WSBaseFragment<urv, uru>
  implements SwipeRefreshLayout.OnRefreshListener, rsp, uhi, upe, urd, urv
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new urz(this);
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSSwipeRefreshLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString;
  private List<usv> jdField_a_of_type_JavaUtilList;
  private ucn jdField_a_of_type_Ucn;
  private uej<Object> jdField_a_of_type_Uej;
  public ufr a;
  private uju jdField_a_of_type_Uju;
  private upu jdField_a_of_type_Upu;
  private urj jdField_a_of_type_Urj;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private uej jdField_b_of_type_Uej;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  @NotNull
  private static Intent a(String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_from", paramString1);
    localBundle.putString("key_play_scene", paramString2);
    if ((paramList != null) && (paramList.size() > 0)) {
      localBundle.putSerializable("key_feed_list", new ArrayList(paramList));
    }
    localBundle.putInt("key_feed_position", paramInt);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public static WSVerticalPageFragment a(String paramString1, String paramString2)
  {
    WSVerticalPageFragment localWSVerticalPageFragment = new WSVerticalPageFragment();
    localWSVerticalPageFragment.setArguments(a(paramString1, paramString2, null, 0).getExtras());
    return localWSVerticalPageFragment;
  }
  
  private uej<Object> a(String paramString)
  {
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return new uro(getActivity(), this);
    }
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return null;
    }
    if (TextUtils.equals(paramString, "qqchat")) {
      return new url(getActivity(), this);
    }
    return new urq(getActivity(), this);
  }
  
  private void a(int paramInt, blsy paramblsy)
  {
    if ((paramblsy instanceof uuy))
    {
      paramblsy = (usv)((uuy)paramblsy).a;
      if ((paramblsy != null) && ((paramblsy.a() instanceof stSimpleMetaFeed)))
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramblsy.a();
        if (TextUtils.equals(uvv.a(this.jdField_a_of_type_JavaLangString), "feeds_fullscreen")) {
          uoi.f();
        }
        uvv.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramInt, localstSimpleMetaFeed);
        uvv.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, localstSimpleMetaFeed);
        uvv.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, localstSimpleMetaFeed);
        if ((localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null) && (!usw.b(localstSimpleMetaFeed))) {
          usw.a(BaseApplicationImpl.getContext(), paramblsy);
        }
      }
    }
  }
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130772192, 2130772191);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt1, int paramInt2)
  {
    uqf.b("WSVerticalPageFragment", "startForResult() needScrollToPosition:" + paramInt1);
    afez.a(paramActivity, a(paramString1, paramString2, paramList, paramInt1), PublicFragmentActivity.class, WSVerticalPageFragment.class, paramInt2);
    a(paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramList, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt, boolean paramBoolean)
  {
    uqf.b("WSVerticalPageFragment", "start() needScrollToPosition:" + paramInt);
    paramString1 = a(paramString1, paramString2, paramList, paramInt);
    if (paramBoolean) {
      paramString1.setFlags(67108864);
    }
    afez.a(paramContext, paramString1, PublicFragmentActivity.class, WSVerticalPageFragment.class);
    if ((paramContext instanceof Activity)) {
      a((Activity)paramContext);
    }
  }
  
  private boolean a(int paramInt)
  {
    List localList = this.jdField_a_of_type_Urj.a();
    uqf.b("WSVerticalPageFragment", "onCenterViewChanged currentPosition:" + paramInt + ", dataList.size:" + localList.size());
    if ((paramInt != 1) && (localList.size() - paramInt < ((uru)this.jdField_a_of_type_Ucm).a()))
    {
      uqf.b("WSVerticalPageFragment", "onPreLoadMore");
      return true;
    }
    return false;
  }
  
  private void b(View paramView)
  {
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131380689);
    this.jdField_a_of_type_Uej = a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Uej != null) {
      this.jdField_a_of_type_Uej.a(localViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380679));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366713));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131380697));
    k();
    c(paramView);
    d(paramView);
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout = ((WSSwipeRefreshLayout)paramView.findViewById(2131373210));
    int i = ayxh.a(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setProgressViewOffset(true, 0, i + uqs.f);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setOnInterceptTouchEventListener(new ury(this));
  }
  
  private boolean c()
  {
    if ((TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_home_page")) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      return true;
    }
    return false;
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)paramView.findViewById(2131381486));
    paramView = new uri(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_Urj = new urj(getActivity(), this);
    this.jdField_a_of_type_Urj.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Urj);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Urj.a(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      paramView.scrollToPosition(this.jdField_a_of_type_Int);
      return;
      c();
    }
  }
  
  private void h()
  {
    uhf.a().a(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Ufr == null)
    {
      uqf.a("weishi-comment", "initCommentPresenter create!!!");
      this.jdField_a_of_type_Ufr = new ufr(this, usd.b(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Ufr.a(this);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Ufr.a(localViewStub);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localViewStub);
      return;
    }
    uqf.a("weishi-comment", "initCommentPresenter 复用~~~~~~,pageIndex:" + this.jdField_a_of_type_Ufr.jdField_a_of_type_Int);
  }
  
  private void j()
  {
    if (getArguments() != null)
    {
      this.jdField_b_of_type_JavaLangString = getArguments().getString("key_play_scene");
      this.jdField_a_of_type_JavaUtilList = ((uru)this.jdField_a_of_type_Ucm).a((ArrayList)getArguments().getSerializable("key_feed_list"));
      WSPublicAccReport.getInstance().reportEnterVerticalVideo(this.jdField_a_of_type_JavaUtilList, 1, true, -1);
      this.jdField_a_of_type_Int = ((uru)this.jdField_a_of_type_Ucm).a(getArguments().getInt("key_feed_position"));
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(uqt.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(false);
    boolean bool = c();
    uqf.e("WSVerticalPageFragment", "[WSVerticalPageFragment.java][initPlayerManager] isPlayerDoOnPause:" + bool);
  }
  
  private void l()
  {
    ((uru)this.jdField_a_of_type_Ucm).c();
    a(false, true);
  }
  
  private void m()
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_new_msg"))
    {
      if ((!uoa.jdField_a_of_type_Boolean) && (!this.e)) {
        break label53;
      }
      WSPublicAccReport.getInstance().closePublicAccReport(1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ufr != null)
      {
        this.jdField_a_of_type_Ufr.a();
        this.jdField_a_of_type_Ufr = null;
      }
      return;
      label53:
      WSPublicAccReport.getInstance().closePublicAccReport(2);
    }
  }
  
  private void n()
  {
    if (TextUtils.equals("mini_app_personal_main", this.jdField_a_of_type_JavaLangString)) {
      uqt.d("homepage_main");
    }
    while (!TextUtils.equals("mini_app_personal_guest", this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    uqt.d("homepage_guest");
  }
  
  private void o()
  {
    if (TextUtils.equals("aio_home_page", this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Boolean) {
        uqt.d("feeds_fullscreen");
      }
      return;
    }
    uqt.d("fullscreen_videoplay");
  }
  
  public void D_()
  {
    uqf.b("WSVerticalPageFragment", "onLoadMore");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public VideoFeedsRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public MiniMsgUserParam a()
  {
    this.jdField_a_of_type_Uju = new uju();
    return this.jdField_a_of_type_Uju.a();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<usv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public uju a()
  {
    return this.jdField_a_of_type_Uju;
  }
  
  public urj a()
  {
    return this.jdField_a_of_type_Urj;
  }
  
  @NonNull
  public uru a()
  {
    return usc.a(this.jdField_a_of_type_JavaLangString, this);
  }
  
  public void a(int paramInt)
  {
    uqf.e("WSVerticalPageFragment", "[WSVerticalPageFragment.java][onTabSelected] index:" + paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null) {
      return;
    }
    if (paramInt != 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e();
    ukq.a().a(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Upu == null) {
      this.jdField_a_of_type_Upu = new upu();
    }
    if (!this.d)
    {
      this.d = true;
      this.jdField_a_of_type_Upu.a(this, paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    getActivity().setResult(paramInt, paramIntent);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_Uej == null)
    {
      this.jdField_b_of_type_Uej = new urw(getActivity(), this);
      this.jdField_b_of_type_Uej.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    if (this.jdField_a_of_type_Ucn == null)
    {
      this.jdField_a_of_type_Ucn = new ucn(getActivity(), 1);
      this.jdField_a_of_type_Ucn.b(uvv.a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Ucn.setOnDismissListener(new usa(this));
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Ucn.a(paramstGlobalConfig);
      this.jdField_a_of_type_Ucn.a(getActivity());
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    uqf.b("WSVerticalPageFragment", "onCenterViewChanged: " + paramViewHolder);
    if ((paramViewHolder instanceof uts))
    {
      paramViewHolder = (uts)paramViewHolder;
      int i = paramViewHolder.getLayoutPosition() - 1;
      this.jdField_a_of_type_Urj.a(paramViewHolder, i);
      ((uru)this.jdField_a_of_type_Ucm).a(paramViewHolder, i);
      paramViewHolder.a(i);
      if (a(i + 1)) {
        a(false, false);
      }
      a(i, paramViewHolder);
      if (i > 0) {
        this.e = true;
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Uju != null) {
      this.jdField_a_of_type_Uju.a(paramView);
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSUserAuthEvent)) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_new_msg")))
    {
      uea.a(getActivity(), "fullscreen_videoplay");
      return;
    }
    ((uru)this.jdField_a_of_type_Ucm).a(paramWSSimpleBaseEvent);
  }
  
  public void a(List<usv> paramList)
  {
    this.jdField_a_of_type_Urj.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Uej instanceof urq)) {
      ((urq)this.jdField_a_of_type_Uej).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((uru)this.jdField_a_of_type_Ucm).a(paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    super.b();
    o();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(true);
    }
  }
  
  public void b(Object paramObject)
  {
    if (this.jdField_a_of_type_Uej != null) {
      this.jdField_a_of_type_Uej.a(paramObject);
    }
  }
  
  public void b(List<usv> paramList)
  {
    this.jdField_a_of_type_Urj.a(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Uej instanceof urq)) {
      ((urq)this.jdField_a_of_type_Uej).a(paramBoolean, this.jdField_a_of_type_Uju);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(false);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d()) {
        f();
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setRefreshing(false);
    }
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_Uej instanceof uro)) {
      ((uro)this.jdField_a_of_type_Uej).c(paramInt);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void f()
  {
    VideoFeedsRecyclerView localVideoFeedsRecyclerView = a();
    if ((localVideoFeedsRecyclerView != null) && (!localVideoFeedsRecyclerView.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(), false);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSUserAuthEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    return localArrayList;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Ufr != null) {}
    for (boolean bool = this.jdField_a_of_type_Ufr.b();; bool = false)
    {
      if (!bool)
      {
        ((uru)this.jdField_a_of_type_Ucm).f();
        uoi.b();
        if ((TextUtils.equals(a(), "follow_tab")) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)) {
          uoi.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(), false);
        }
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals("qqchat")))
      {
        if ((!uoa.jdField_a_of_type_Boolean) && (!this.e)) {
          break label120;
        }
        WSPublicAccReport.getInstance().closePublicAccReport(1);
      }
      while ((bool) || (super.onBackEvent()))
      {
        return true;
        label120:
        WSPublicAccReport.getInstance().closePublicAccReport(2);
      }
      return false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    uqf.a("weishi-beacon", "进入播放页的时间：" + this.jdField_a_of_type_Long);
    if (getArguments() != null) {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("key_from");
    }
    super.onCreate(paramBundle);
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    j();
    uoi.a(a(), uvv.a(this.jdField_a_of_type_JavaLangString), b());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560006, paramViewGroup, false);
    uqf.a("weishi-comment", "onCreateView before initUI~~~~~~~~~~~");
    b(paramLayoutInflater);
    l();
    uqf.a("weishi-comment", "onCreateView after initData~~~~~~~~~~~");
    i();
    h();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((uru)this.jdField_a_of_type_Ucm).b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    n();
    uhf.a().b(this);
    ujq.a().a();
    WSVerticalDataManager.a().a();
    m();
    if ((this.jdField_a_of_type_Urj != null) && (this.jdField_a_of_type_Urj.a() != null))
    {
      uuy localuuy = this.jdField_a_of_type_Urj.a();
      if (localuuy != null) {
        localuuy.c();
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.removeOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_home_page"))
    {
      int i = 0;
      if (this.jdField_a_of_type_Urj != null) {
        i = this.jdField_a_of_type_Urj.a();
      }
      uoc.a().a(this.jdField_b_of_type_Long, ((uru)b()).a(), i, uqt.jdField_a_of_type_Boolean, uqh.jdField_a_of_type_Boolean, 2);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_c_of_type_Long;
    ((uru)this.jdField_a_of_type_Ucm).e();
    WSPublicAccReport.getInstance().reportPageVisitExit(uvv.a(this.jdField_a_of_type_JavaLangString));
    if ((this.jdField_a_of_type_Urj != null) && (this.jdField_a_of_type_Urj.a() != null))
    {
      uuy localuuy = this.jdField_a_of_type_Urj.a();
      if (localuuy != null) {
        localuuy.b();
      }
    }
  }
  
  public void onRefresh()
  {
    uqf.b("WSVerticalPageFragment", "[WSVerticalPageFragment.java][onRefresh]");
    ((uru)this.jdField_a_of_type_Ucm).a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    uoi.a(uvv.a(this.jdField_a_of_type_JavaLangString), b());
    ((uru)this.jdField_a_of_type_Ucm).d();
    if ((this.jdField_a_of_type_Urj != null) && (this.jdField_a_of_type_Urj.a() != null))
    {
      uuy localuuy = this.jdField_a_of_type_Urj.a();
      if (localuuy != null) {
        localuuy.a();
      }
    }
    com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = 0L;
      uqf.a("weishi-beacon", "播放页初始化耗时：" + l);
      uoc.a().a(true, l, "fullscreen_videoplay", this.jdField_b_of_type_JavaLangString);
    }
    WSPublicAccReport.getInstance().reportPageVisitEnter(uvv.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment
 * JD-Core Version:    0.7.0.1
 */