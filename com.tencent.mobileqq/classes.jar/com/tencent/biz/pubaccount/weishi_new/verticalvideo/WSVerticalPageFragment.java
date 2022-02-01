package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import aeow;
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
import android.widget.ProgressBar;
import ayqu;
import blij;
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
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import slx;
import uxa;
import uyn;
import uyw;
import vaj;
import vbw;
import vbz;
import vem;
import vex;
import vft;
import vki;
import vkk;
import vkq;
import vlo;
import vme;
import vmp;
import vmr;
import vnc;
import vnd;
import vnq;
import vnv;
import vnw;
import vny;
import vob;
import vod;
import voh;
import voi;
import voj;
import vol;
import vom;
import von;
import vop;
import voq;
import vpj;
import vqg;
import vrn;
import vrx;
import vsj;

public class WSVerticalPageFragment
  extends WSBaseFragment<voi, voh>
  implements SwipeRefreshLayout.OnRefreshListener, slx, vbz, vlo, vnq, voi
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new vom(this);
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSSwipeRefreshLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString;
  private List<vpj> jdField_a_of_type_JavaUtilList;
  private uxa jdField_a_of_type_Uxa;
  private uyw<Object> jdField_a_of_type_Uyw;
  public vaj a;
  private vex jdField_a_of_type_Vex;
  private vme jdField_a_of_type_Vme;
  private vnw jdField_a_of_type_Vnw;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private uyw jdField_b_of_type_Uyw;
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
  
  private uyw<Object> a(String paramString)
  {
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return new vob(getActivity(), this);
    }
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return null;
    }
    if (TextUtils.equals(paramString, "qqchat")) {
      return new vny(getActivity(), this);
    }
    return new vod(getActivity(), this);
  }
  
  private void a(int paramInt, blij paramblij)
  {
    if ((paramblij instanceof vrn))
    {
      paramblij = (vpj)((vrn)paramblij).a;
      if ((paramblij != null) && ((paramblij.a() instanceof stSimpleMetaFeed)))
      {
        paramblij = (stSimpleMetaFeed)paramblij.a();
        if (TextUtils.equals(vsj.a(this.jdField_a_of_type_JavaLangString), "feeds_fullscreen")) {
          vkq.f();
        }
        vsj.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramInt, paramblij);
        vsj.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramblij);
        vsj.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramblij);
      }
    }
  }
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130772200, 2130772199);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt1, int paramInt2)
  {
    vmp.b("WSVerticalPageFragment", "startForResult() needScrollToPosition:" + paramInt1);
    aeow.a(paramActivity, a(paramString1, paramString2, paramList, paramInt1), PublicFragmentActivity.class, WSVerticalPageFragment.class, paramInt2);
    a(paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramList, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt, boolean paramBoolean)
  {
    vmp.b("WSVerticalPageFragment", "start() needScrollToPosition:" + paramInt);
    paramString1 = a(paramString1, paramString2, paramList, paramInt);
    if (paramBoolean) {
      paramString1.setFlags(67108864);
    }
    aeow.a(paramContext, paramString1, PublicFragmentActivity.class, WSVerticalPageFragment.class);
    if ((paramContext instanceof Activity)) {
      a((Activity)paramContext);
    }
  }
  
  private void a(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if (paramWSPlayerManager == null) {
      return;
    }
    vsj.a(paramString1, paramString2, paramWSPlayerManager.a(), true);
    paramWSPlayerManager.g();
  }
  
  private boolean a(int paramInt)
  {
    List localList = this.jdField_a_of_type_Vnw.b();
    vmp.b("WSVerticalPageFragment", "onCenterViewChanged currentPosition:" + paramInt + ", dataList.size:" + localList.size());
    if ((paramInt != 1) && (localList.size() - paramInt < ((voh)this.jdField_a_of_type_Uwz).a()))
    {
      vmp.b("WSVerticalPageFragment", "onPreLoadMore");
      return true;
    }
    return false;
  }
  
  private void b(View paramView)
  {
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131380754);
    this.jdField_a_of_type_Uyw = a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Uyw != null) {
      this.jdField_a_of_type_Uyw.a(localViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380743));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131380762));
    k();
    c(paramView);
    d(paramView);
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout = ((WSSwipeRefreshLayout)paramView.findViewById(2131373387));
    int i = ayqu.a(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setProgressViewOffset(true, 0, i + vnc.f);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setOnInterceptTouchEventListener(new vol(this));
  }
  
  private void c(boolean paramBoolean)
  {
    voh localvoh = (voh)b();
    if ((localvoh instanceof vrx)) {
      ((vrx)localvoh).a(paramBoolean);
    }
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)paramView.findViewById(2131381566));
    paramView = new vnv(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_Vnw = new vnw(getActivity(), this);
    this.jdField_a_of_type_Vnw.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Vnw);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Vnw.a(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      paramView.scrollToPosition(this.jdField_a_of_type_Int);
      return;
      c();
    }
  }
  
  private boolean d()
  {
    if ((TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_home_page")) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      return true;
    }
    return false;
  }
  
  private void h()
  {
    vbw.a().a(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Vaj == null)
    {
      vmp.a("weishi-comment", "initCommentPresenter create!!!");
      this.jdField_a_of_type_Vaj = new vaj(this, voq.b(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Vaj.a(this);
    }
  }
  
  private void j()
  {
    if (getArguments() != null)
    {
      this.jdField_b_of_type_JavaLangString = getArguments().getString("key_play_scene");
      this.jdField_a_of_type_JavaUtilList = ((voh)this.jdField_a_of_type_Uwz).a((ArrayList)getArguments().getSerializable("key_feed_list"));
      vsj.a(this.jdField_a_of_type_JavaUtilList, 1, true, -1, a(), b());
      this.jdField_a_of_type_Int = ((voh)this.jdField_a_of_type_Uwz).a(getArguments().getInt("key_feed_position"));
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(vnd.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(false);
    boolean bool = d();
    vmp.e("WSVerticalPageFragment", "[WSVerticalPageFragment.java][initPlayerManager] isPlayerDoOnPause:" + bool);
  }
  
  private void l()
  {
    ((voh)this.jdField_a_of_type_Uwz).c();
    a(false, true);
  }
  
  private void m()
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_new_msg"))
    {
      if ((!vki.jdField_a_of_type_Boolean) && (!this.e)) {
        break label53;
      }
      WSPublicAccReport.getInstance().closePublicAccReport(1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Vaj != null)
      {
        this.jdField_a_of_type_Vaj.a();
        this.jdField_a_of_type_Vaj = null;
      }
      return;
      label53:
      WSPublicAccReport.getInstance().closePublicAccReport(2);
    }
  }
  
  private void n()
  {
    if (TextUtils.equals("mini_app_personal_main", this.jdField_a_of_type_JavaLangString)) {
      vnd.d("homepage_main");
    }
    while (!TextUtils.equals("mini_app_personal_guest", this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    vnd.d("homepage_guest");
  }
  
  private void o()
  {
    if (TextUtils.equals("aio_home_page", this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Boolean) {
        vnd.d("feeds_fullscreen");
      }
      return;
    }
    vnd.d("fullscreen_videoplay");
  }
  
  public void A_()
  {
    vmp.b("WSVerticalPageFragment", "onLoadMore");
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
    this.jdField_a_of_type_Vex = new vex();
    return this.jdField_a_of_type_Vex.a();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSUserAuthEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    return localArrayList;
  }
  
  public List<vpj> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public vex a()
  {
    return this.jdField_a_of_type_Vex;
  }
  
  public vnw a()
  {
    return this.jdField_a_of_type_Vnw;
  }
  
  @NonNull
  public voh a()
  {
    return vop.a(this.jdField_a_of_type_JavaLangString, this);
  }
  
  public void a(int paramInt)
  {
    vmp.e("WSVerticalPageFragment", "[WSVerticalPageFragment.java][onTabSelected] index:" + paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null) {
      return;
    }
    if (paramInt != 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      c(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e();
    c(true);
    vft.a().a(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Vme == null) {
      this.jdField_a_of_type_Vme = new vme();
    }
    if (!this.d)
    {
      this.d = true;
      this.jdField_a_of_type_Vme.a(this, paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    getActivity().setResult(paramInt, paramIntent);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_Uyw == null)
    {
      this.jdField_b_of_type_Uyw = new voj(getActivity(), this);
      this.jdField_b_of_type_Uyw.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    if (this.jdField_a_of_type_Uxa == null)
    {
      this.jdField_a_of_type_Uxa = new uxa(getActivity(), 1);
      this.jdField_a_of_type_Uxa.b(vsj.a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Uxa.setOnDismissListener(new von(this));
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Uxa.a(paramstGlobalConfig);
      this.jdField_a_of_type_Uxa.a(getActivity());
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    vmp.b("WSVerticalPageFragment", "onCenterViewChanged: " + paramViewHolder);
    if ((paramViewHolder instanceof vqg))
    {
      paramViewHolder = (vqg)paramViewHolder;
      int i = paramViewHolder.getLayoutPosition() - 1;
      this.jdField_a_of_type_Vnw.a(paramViewHolder, i);
      ((voh)this.jdField_a_of_type_Uwz).a(paramViewHolder, i);
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
    if (this.jdField_a_of_type_Vex != null) {
      this.jdField_a_of_type_Vex.a(paramView);
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSUserAuthEvent)) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_new_msg")))
    {
      uyn.a(getActivity(), "fullscreen_videoplay");
      return;
    }
    ((voh)this.jdField_a_of_type_Uwz).a(paramWSSimpleBaseEvent);
  }
  
  public void a(List<vpj> paramList)
  {
    this.jdField_a_of_type_Vnw.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Uyw instanceof vod)) {
      ((vod)this.jdField_a_of_type_Uyw).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((voh)this.jdField_a_of_type_Uwz).a(paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaLangString);
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
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(Object paramObject)
  {
    if (this.jdField_a_of_type_Uyw != null) {
      this.jdField_a_of_type_Uyw.a(paramObject);
    }
  }
  
  public void b(List<vpj> paramList)
  {
    this.jdField_a_of_type_Vnw.a(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Uyw instanceof vod)) {
      ((vod)this.jdField_a_of_type_Uyw).a(paramBoolean, this.jdField_a_of_type_Vex);
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
  
  public boolean c()
  {
    return (getActivity() != null) && (getActivity().isFinishing());
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setRefreshing(false);
    }
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_Uyw instanceof vob)) {
      ((vob)this.jdField_a_of_type_Uyw).c(paramInt);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void f()
  {
    VideoFeedsRecyclerView localVideoFeedsRecyclerView = a();
    if ((localVideoFeedsRecyclerView != null) && (!localVideoFeedsRecyclerView.a()))
    {
      a(a(), b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(), false);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Vaj != null) {}
    for (boolean bool = this.jdField_a_of_type_Vaj.b();; bool = false)
    {
      if (!bool)
      {
        ((voh)this.jdField_a_of_type_Uwz).f();
        vkq.b();
        if ((TextUtils.equals(a(), "follow_tab")) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)) {
          vkq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(), false);
        }
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals("qqchat")))
      {
        if ((!vki.jdField_a_of_type_Boolean) && (!this.e)) {
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
    vmp.a("weishi-beacon", "进入播放页的时间：" + this.jdField_a_of_type_Long);
    if (getArguments() != null) {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("key_from");
    }
    super.onCreate(paramBundle);
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    j();
    vkq.a(a(), vsj.a(this.jdField_a_of_type_JavaLangString), b());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560056, paramViewGroup, false);
    vmp.a("weishi-comment", "onCreateView before initUI~~~~~~~~~~~");
    b(paramLayoutInflater);
    l();
    vmp.a("weishi-comment", "onCreateView after initData~~~~~~~~~~~");
    i();
    h();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((voh)this.jdField_a_of_type_Uwz).b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    n();
    vbw.a().b(this);
    vem.a().a();
    WSVerticalDataManager.a().a();
    m();
    if ((this.jdField_a_of_type_Vnw != null) && (this.jdField_a_of_type_Vnw.a() != null))
    {
      vrn localvrn = this.jdField_a_of_type_Vnw.a();
      if (localvrn != null) {
        localvrn.c();
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.removeOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_home_page"))
    {
      int i = 0;
      if (this.jdField_a_of_type_Vnw != null) {
        i = this.jdField_a_of_type_Vnw.a();
      }
      vkk.a().a(this.jdField_b_of_type_Long, ((voh)b()).a(), i, vnd.jdField_a_of_type_Boolean, vmr.jdField_a_of_type_Boolean, 2);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_c_of_type_Long;
    ((voh)this.jdField_a_of_type_Uwz).e();
    WSPublicAccReport.getInstance().reportPageVisitExit(vsj.a(this.jdField_a_of_type_JavaLangString));
    if ((this.jdField_a_of_type_Vnw != null) && (this.jdField_a_of_type_Vnw.a() != null))
    {
      vrn localvrn = this.jdField_a_of_type_Vnw.a();
      if (localvrn != null) {
        localvrn.b();
      }
    }
  }
  
  public void onRefresh()
  {
    vmp.b("WSVerticalPageFragment", "[WSVerticalPageFragment.java][onRefresh]");
    ((voh)this.jdField_a_of_type_Uwz).a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    vkq.a(vsj.a(this.jdField_a_of_type_JavaLangString), b());
    ((voh)this.jdField_a_of_type_Uwz).d();
    if ((this.jdField_a_of_type_Vnw != null) && (this.jdField_a_of_type_Vnw.a() != null))
    {
      vrn localvrn = this.jdField_a_of_type_Vnw.a();
      if (localvrn != null) {
        localvrn.a();
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
      vmp.a("weishi-beacon", "播放页初始化耗时：" + l);
      vkk.a().a(true, l, "fullscreen_videoplay", this.jdField_b_of_type_JavaLangString);
    }
    WSPublicAccReport.getInstance().reportPageVisitEnter(vsj.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment
 * JD-Core Version:    0.7.0.1
 */