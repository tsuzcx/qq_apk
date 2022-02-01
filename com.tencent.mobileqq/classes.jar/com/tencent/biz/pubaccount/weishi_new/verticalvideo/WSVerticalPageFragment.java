package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import adxr;
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
import android.widget.ProgressBar;
import axkp;
import bjwy;
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
import rzt;
import ujd;
import ukq;
import ukz;
import umj;
import unw;
import unz;
import uql;
import uqp;
import url;
import uvu;
import uvw;
import uwc;
import uwz;
import uxp;
import uya;
import uyc;
import uyn;
import uyo;
import uyy;
import uzd;
import uze;
import uzg;
import uzj;
import uzl;
import uzp;
import uzq;
import uzr;
import uzt;
import uzu;
import uzv;
import uzx;
import uzy;
import vaq;
import vbn;
import vct;
import vdc;
import vdq;

public class WSVerticalPageFragment
  extends WSBaseFragment<uzq, uzp>
  implements SwipeRefreshLayout.OnRefreshListener, rzt, unz, uwz, uyy, uzq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new uzu(this);
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSSwipeRefreshLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString;
  private List<vaq> jdField_a_of_type_JavaUtilList;
  private ujd jdField_a_of_type_Ujd;
  private ukz<Object> jdField_a_of_type_Ukz;
  public umj a;
  private uqp jdField_a_of_type_Uqp;
  private uxp jdField_a_of_type_Uxp;
  private uze jdField_a_of_type_Uze;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ukz jdField_b_of_type_Ukz;
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
  
  private ukz<Object> a(String paramString)
  {
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return new uzj(getActivity(), this);
    }
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return null;
    }
    if (TextUtils.equals(paramString, "qqchat")) {
      return new uzg(getActivity(), this);
    }
    return new uzl(getActivity(), this);
  }
  
  private void a(int paramInt, bjwy parambjwy)
  {
    if ((parambjwy instanceof vct))
    {
      parambjwy = (vaq)((vct)parambjwy).a;
      if ((parambjwy != null) && ((parambjwy.a() instanceof stSimpleMetaFeed)))
      {
        parambjwy = (stSimpleMetaFeed)parambjwy.a();
        if (TextUtils.equals(vdq.a(this.jdField_a_of_type_JavaLangString), "feeds_fullscreen")) {
          uwc.f();
        }
        vdq.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramInt, parambjwy);
        vdq.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, parambjwy);
        vdq.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, parambjwy);
      }
    }
  }
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130772200, 2130772199);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt1, int paramInt2)
  {
    uya.b("WSVerticalPageFragment", "startForResult() needScrollToPosition:" + paramInt1);
    adxr.a(paramActivity, a(paramString1, paramString2, paramList, paramInt1), PublicFragmentActivity.class, WSVerticalPageFragment.class, paramInt2);
    a(paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramList, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt, boolean paramBoolean)
  {
    uya.b("WSVerticalPageFragment", "start() needScrollToPosition:" + paramInt);
    paramString1 = a(paramString1, paramString2, paramList, paramInt);
    if (paramBoolean) {
      paramString1.setFlags(67108864);
    }
    adxr.a(paramContext, paramString1, PublicFragmentActivity.class, WSVerticalPageFragment.class);
    if ((paramContext instanceof Activity)) {
      a((Activity)paramContext);
    }
  }
  
  private void a(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if (paramWSPlayerManager == null) {
      return;
    }
    vdq.a(paramString1, paramString2, paramWSPlayerManager.a(), true);
    paramWSPlayerManager.g();
  }
  
  private boolean a(int paramInt)
  {
    List localList = this.jdField_a_of_type_Uze.a();
    uya.b("WSVerticalPageFragment", "onCenterViewChanged currentPosition:" + paramInt + ", dataList.size:" + localList.size());
    if ((paramInt != 1) && (localList.size() - paramInt < ((uzp)this.jdField_a_of_type_Ujc).a()))
    {
      uya.b("WSVerticalPageFragment", "onPreLoadMore");
      return true;
    }
    return false;
  }
  
  private void b(View paramView)
  {
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131380415);
    this.jdField_a_of_type_Ukz = a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Ukz != null) {
      this.jdField_a_of_type_Ukz.a(localViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380405));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366743));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131380423));
    k();
    c(paramView);
    d(paramView);
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout = ((WSSwipeRefreshLayout)paramView.findViewById(2131373176));
    int i = axkp.a(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setProgressViewOffset(true, 0, i + uyn.f);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setOnInterceptTouchEventListener(new uzt(this));
  }
  
  private void c(boolean paramBoolean)
  {
    uzp localuzp = (uzp)b();
    if ((localuzp instanceof vdc)) {
      ((vdc)localuzp).a(paramBoolean);
    }
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)paramView.findViewById(2131381203));
    paramView = new uzd(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_Uze = new uze(getActivity(), this);
    this.jdField_a_of_type_Uze.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Uze);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Uze.a(this.jdField_a_of_type_JavaUtilList);
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
    unw.a().a(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Umj == null)
    {
      uya.a("weishi-comment", "initCommentPresenter create!!!");
      this.jdField_a_of_type_Umj = new umj(this, uzy.b(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Umj.a(this);
    }
  }
  
  private void j()
  {
    if (getArguments() != null)
    {
      this.jdField_b_of_type_JavaLangString = getArguments().getString("key_play_scene");
      this.jdField_a_of_type_JavaUtilList = ((uzp)this.jdField_a_of_type_Ujc).a((ArrayList)getArguments().getSerializable("key_feed_list"));
      WSPublicAccReport.getInstance().reportEnterVerticalVideo(this.jdField_a_of_type_JavaUtilList, 1, true, -1);
      this.jdField_a_of_type_Int = ((uzp)this.jdField_a_of_type_Ujc).a(getArguments().getInt("key_feed_position"));
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(uyo.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(false);
    boolean bool = c();
    uya.e("WSVerticalPageFragment", "[WSVerticalPageFragment.java][initPlayerManager] isPlayerDoOnPause:" + bool);
  }
  
  private void l()
  {
    ((uzp)this.jdField_a_of_type_Ujc).c();
    a(false, true);
  }
  
  private void m()
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_new_msg"))
    {
      if ((!uvu.jdField_a_of_type_Boolean) && (!this.e)) {
        break label53;
      }
      WSPublicAccReport.getInstance().closePublicAccReport(1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Umj != null)
      {
        this.jdField_a_of_type_Umj.a();
        this.jdField_a_of_type_Umj = null;
      }
      return;
      label53:
      WSPublicAccReport.getInstance().closePublicAccReport(2);
    }
  }
  
  private void n()
  {
    if (TextUtils.equals("mini_app_personal_main", this.jdField_a_of_type_JavaLangString)) {
      uyo.d("homepage_main");
    }
    while (!TextUtils.equals("mini_app_personal_guest", this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    uyo.d("homepage_guest");
  }
  
  private void o()
  {
    if (TextUtils.equals("aio_home_page", this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Boolean) {
        uyo.d("feeds_fullscreen");
      }
      return;
    }
    uyo.d("fullscreen_videoplay");
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
    this.jdField_a_of_type_Uqp = new uqp();
    return this.jdField_a_of_type_Uqp.a();
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
  
  public List<vaq> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public uqp a()
  {
    return this.jdField_a_of_type_Uqp;
  }
  
  public uze a()
  {
    return this.jdField_a_of_type_Uze;
  }
  
  @NonNull
  public uzp a()
  {
    return uzx.a(this.jdField_a_of_type_JavaLangString, this);
  }
  
  public void a(int paramInt)
  {
    uya.e("WSVerticalPageFragment", "[WSVerticalPageFragment.java][onTabSelected] index:" + paramInt);
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
    url.a().a(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Uxp == null) {
      this.jdField_a_of_type_Uxp = new uxp();
    }
    if (!this.d)
    {
      this.d = true;
      this.jdField_a_of_type_Uxp.a(this, paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    getActivity().setResult(paramInt, paramIntent);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_Ukz == null)
    {
      this.jdField_b_of_type_Ukz = new uzr(getActivity(), this);
      this.jdField_b_of_type_Ukz.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    if (this.jdField_a_of_type_Ujd == null)
    {
      this.jdField_a_of_type_Ujd = new ujd(getActivity(), 1);
      this.jdField_a_of_type_Ujd.b(vdq.a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Ujd.setOnDismissListener(new uzv(this));
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Ujd.a(paramstGlobalConfig);
      this.jdField_a_of_type_Ujd.a(getActivity());
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    uya.b("WSVerticalPageFragment", "onCenterViewChanged: " + paramViewHolder);
    if ((paramViewHolder instanceof vbn))
    {
      paramViewHolder = (vbn)paramViewHolder;
      int i = paramViewHolder.getLayoutPosition() - 1;
      this.jdField_a_of_type_Uze.a(paramViewHolder, i);
      ((uzp)this.jdField_a_of_type_Ujc).a(paramViewHolder, i);
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
    if (this.jdField_a_of_type_Uqp != null) {
      this.jdField_a_of_type_Uqp.a(paramView);
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSUserAuthEvent)) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_new_msg")))
    {
      ukq.a(getActivity(), "fullscreen_videoplay");
      return;
    }
    ((uzp)this.jdField_a_of_type_Ujc).a(paramWSSimpleBaseEvent);
  }
  
  public void a(List<vaq> paramList)
  {
    this.jdField_a_of_type_Uze.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ukz instanceof uzl)) {
      ((uzl)this.jdField_a_of_type_Ukz).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((uzp)this.jdField_a_of_type_Ujc).a(paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_Ukz != null) {
      this.jdField_a_of_type_Ukz.a(paramObject);
    }
  }
  
  public void b(List<vaq> paramList)
  {
    this.jdField_a_of_type_Uze.a(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ukz instanceof uzl)) {
      ((uzl)this.jdField_a_of_type_Ukz).a(paramBoolean, this.jdField_a_of_type_Uqp);
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
    if ((this.jdField_a_of_type_Ukz instanceof uzj)) {
      ((uzj)this.jdField_a_of_type_Ukz).c(paramInt);
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
    if (this.jdField_a_of_type_Umj != null) {}
    for (boolean bool = this.jdField_a_of_type_Umj.b();; bool = false)
    {
      if (!bool)
      {
        ((uzp)this.jdField_a_of_type_Ujc).f();
        uwc.b();
        if ((TextUtils.equals(a(), "follow_tab")) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)) {
          uwc.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(), false);
        }
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals("qqchat")))
      {
        if ((!uvu.jdField_a_of_type_Boolean) && (!this.e)) {
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
    uya.a("weishi-beacon", "进入播放页的时间：" + this.jdField_a_of_type_Long);
    if (getArguments() != null) {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("key_from");
    }
    super.onCreate(paramBundle);
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    j();
    uwc.a(a(), vdq.a(this.jdField_a_of_type_JavaLangString), b());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560012, paramViewGroup, false);
    uya.a("weishi-comment", "onCreateView before initUI~~~~~~~~~~~");
    b(paramLayoutInflater);
    l();
    uya.a("weishi-comment", "onCreateView after initData~~~~~~~~~~~");
    i();
    h();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((uzp)this.jdField_a_of_type_Ujc).b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    n();
    unw.a().b(this);
    uql.a().a();
    WSVerticalDataManager.a().a();
    m();
    if ((this.jdField_a_of_type_Uze != null) && (this.jdField_a_of_type_Uze.a() != null))
    {
      vct localvct = this.jdField_a_of_type_Uze.a();
      if (localvct != null) {
        localvct.c();
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.removeOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_home_page"))
    {
      int i = 0;
      if (this.jdField_a_of_type_Uze != null) {
        i = this.jdField_a_of_type_Uze.a();
      }
      uvw.a().a(this.jdField_b_of_type_Long, ((uzp)b()).a(), i, uyo.jdField_a_of_type_Boolean, uyc.jdField_a_of_type_Boolean, 2);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_c_of_type_Long;
    ((uzp)this.jdField_a_of_type_Ujc).e();
    WSPublicAccReport.getInstance().reportPageVisitExit(vdq.a(this.jdField_a_of_type_JavaLangString));
    if ((this.jdField_a_of_type_Uze != null) && (this.jdField_a_of_type_Uze.a() != null))
    {
      vct localvct = this.jdField_a_of_type_Uze.a();
      if (localvct != null) {
        localvct.b();
      }
    }
  }
  
  public void onRefresh()
  {
    uya.b("WSVerticalPageFragment", "[WSVerticalPageFragment.java][onRefresh]");
    ((uzp)this.jdField_a_of_type_Ujc).a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    uwc.a(vdq.a(this.jdField_a_of_type_JavaLangString), b());
    ((uzp)this.jdField_a_of_type_Ujc).d();
    if ((this.jdField_a_of_type_Uze != null) && (this.jdField_a_of_type_Uze.a() != null))
    {
      vct localvct = this.jdField_a_of_type_Uze.a();
      if (localvct != null) {
        localvct.a();
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
      uya.a("weishi-beacon", "播放页初始化耗时：" + l);
      uvw.a().a(true, l, "fullscreen_videoplay", this.jdField_b_of_type_JavaLangString);
    }
    WSPublicAccReport.getInstance().reportPageVisitEnter(vdq.a(this.jdField_a_of_type_JavaLangString));
  }
  
  public void y_()
  {
    uya.b("WSVerticalPageFragment", "onLoadMore");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment
 * JD-Core Version:    0.7.0.1
 */