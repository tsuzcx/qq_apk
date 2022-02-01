package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stSimpleMetaFeed;
import aevv;
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
import ayeo;
import bkrv;
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
import sbt;
import ucl;
import udy;
import ueh;
import ufp;
import ugb;
import uhd;
import uhg;
import uiw;
import uja;
import umz;
import unb;
import unh;
import uod;
import uof;
import upe;
import upg;
import upr;
import ups;
import uqc;
import uqh;
import uqi;
import uqk;
import uqn;
import uqp;
import uqt;
import uqu;
import uqv;
import uqx;
import uqy;
import uqz;
import urb;
import urc;
import uru;
import urv;
import usr;
import utw;
import uut;

public class WSVerticalPageFragment
  extends WSBaseFragment<uqu, uqt>
  implements SwipeRefreshLayout.OnRefreshListener, sbt, uhg, uod, uqc, uqu
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new uqy(this);
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSSwipeRefreshLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString;
  private List<uru> jdField_a_of_type_JavaUtilList;
  private ucl jdField_a_of_type_Ucl;
  private ueh<Object> jdField_a_of_type_Ueh;
  public ufp a;
  private uja jdField_a_of_type_Uja;
  private uqi jdField_a_of_type_Uqi;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ueh jdField_b_of_type_Ueh;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
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
  
  private ueh<Object> a(String paramString)
  {
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return new uqn(getActivity(), this);
    }
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return null;
    }
    if (TextUtils.equals(paramString, "qqchat")) {
      return new uqk(getActivity(), this);
    }
    return new uqp(getActivity(), this);
  }
  
  private void a(int paramInt, bkrv parambkrv)
  {
    if ((parambkrv instanceof utw))
    {
      parambkrv = (uru)((utw)parambkrv).a;
      if ((parambkrv != null) && ((parambkrv.a() instanceof stSimpleMetaFeed)))
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)parambkrv.a();
        if (TextUtils.equals(uut.a(this.jdField_a_of_type_JavaLangString), "feeds_fullscreen")) {
          unh.f();
        }
        uut.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramInt, localstSimpleMetaFeed);
        uut.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, localstSimpleMetaFeed);
        uut.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, localstSimpleMetaFeed);
        if ((localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null) && (!urv.b(localstSimpleMetaFeed))) {
          urv.a(BaseApplicationImpl.getContext(), parambkrv);
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
    upe.b("WSVerticalPageFragment", "startForResult() needScrollToPosition:" + paramInt1);
    aevv.a(paramActivity, a(paramString1, paramString2, paramList, paramInt1), PublicFragmentActivity.class, WSVerticalPageFragment.class, paramInt2);
    a(paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramList, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt, boolean paramBoolean)
  {
    upe.b("WSVerticalPageFragment", "start() needScrollToPosition:" + paramInt);
    paramString1 = a(paramString1, paramString2, paramList, paramInt);
    if (paramBoolean) {
      paramString1.setFlags(67108864);
    }
    aevv.a(paramContext, paramString1, PublicFragmentActivity.class, WSVerticalPageFragment.class);
    if ((paramContext instanceof Activity)) {
      a((Activity)paramContext);
    }
  }
  
  private boolean a(int paramInt)
  {
    List localList = this.jdField_a_of_type_Uqi.a();
    upe.b("WSVerticalPageFragment", "onCenterViewChanged currentPosition:" + paramInt + ", dataList.size:" + localList.size());
    if ((paramInt != 1) && (localList.size() - paramInt < ((uqt)this.jdField_a_of_type_Uck).a()))
    {
      upe.b("WSVerticalPageFragment", "onPreLoadMore");
      return true;
    }
    return false;
  }
  
  private void b(View paramView)
  {
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131380503);
    this.jdField_a_of_type_Ueh = a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Ueh != null) {
      this.jdField_a_of_type_Ueh.a(localViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380493));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366663));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131380511));
    l();
    c(paramView);
    d(paramView);
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout = ((WSSwipeRefreshLayout)paramView.findViewById(2131373097));
    int i = ayeo.a(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setProgressViewOffset(true, 0, i + upr.d);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setOnInterceptTouchEventListener(new uqx(this));
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)paramView.findViewById(2131381307));
    paramView = new uqh(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_Uqi = new uqi(getActivity(), this);
    this.jdField_a_of_type_Uqi.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Uqi);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Uqi.a(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      paramView.scrollToPosition(this.jdField_a_of_type_Int);
      return;
      c();
    }
  }
  
  private void i()
  {
    uhd.a().a(this);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Ufp == null)
    {
      upe.a("weishi-comment", "initCommentPresenter create!!!");
      this.jdField_a_of_type_Ufp = new ufp(this, urc.b(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Ufp.a(this);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Ufp.a(localViewStub);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localViewStub);
      return;
    }
    upe.a("weishi-comment", "initCommentPresenter 复用~~~~~~,pageIndex:" + this.jdField_a_of_type_Ufp.jdField_a_of_type_Int);
  }
  
  private void k()
  {
    if (getArguments() != null)
    {
      this.jdField_b_of_type_JavaLangString = getArguments().getString("key_play_scene");
      this.jdField_a_of_type_JavaUtilList = ((uqt)this.jdField_a_of_type_Uck).a((ArrayList)getArguments().getSerializable("key_feed_list"));
      WSPublicAccReport.getInstance().reportEnterVerticalVideo(this.jdField_a_of_type_JavaUtilList, 1, true, -1);
      this.jdField_a_of_type_Int = ((uqt)this.jdField_a_of_type_Uck).a(getArguments().getInt("key_feed_position"));
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(ups.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d(false);
    boolean bool = c();
    upe.e("WSVerticalPageFragment", "[WSVerticalPageFragment.java][initPlayerManager] isPlayerDoOnPause:" + bool);
  }
  
  private void m()
  {
    ((uqt)this.jdField_a_of_type_Uck).c();
    a(false, true);
  }
  
  private void n()
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_new_msg"))
    {
      if ((!umz.jdField_a_of_type_Boolean) && (!this.d)) {
        break label53;
      }
      WSPublicAccReport.getInstance().closePublicAccReport(1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ufp != null)
      {
        this.jdField_a_of_type_Ufp.a();
        this.jdField_a_of_type_Ufp = null;
      }
      return;
      label53:
      WSPublicAccReport.getInstance().closePublicAccReport(2);
    }
  }
  
  private void o()
  {
    if (TextUtils.equals("mini_app_personal_main", this.jdField_a_of_type_JavaLangString)) {
      ups.d("homepage_main");
    }
    while (!TextUtils.equals("mini_app_personal_guest", this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    ups.d("homepage_guest");
  }
  
  private void p()
  {
    if (TextUtils.equals("aio_home_page", this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Boolean) {
        ups.d("feeds_fullscreen");
      }
      return;
    }
    ups.d("fullscreen_videoplay");
  }
  
  public void D_()
  {
    upe.b("WSVerticalPageFragment", "onLoadMore");
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
    this.jdField_a_of_type_Uja = new uja();
    return this.jdField_a_of_type_Uja.a();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<uru> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public uja a()
  {
    return this.jdField_a_of_type_Uja;
  }
  
  public uqi a()
  {
    return this.jdField_a_of_type_Uqi;
  }
  
  @NonNull
  public uqt a()
  {
    return urb.a(this.jdField_a_of_type_JavaLangString, this);
  }
  
  public void a(int paramInt)
  {
    upe.e("WSVerticalPageFragment", "[WSVerticalPageFragment.java][onTabSelected] index:" + paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null) {
      return;
    }
    if (paramInt != 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    getActivity().setResult(paramInt, paramIntent);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_Ueh == null)
    {
      this.jdField_b_of_type_Ueh = new uqv(getActivity(), this);
      this.jdField_b_of_type_Ueh.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    upe.b("WSVerticalPageFragment", "onCenterViewChanged: " + paramViewHolder);
    if ((paramViewHolder instanceof usr))
    {
      paramViewHolder = (usr)paramViewHolder;
      int i = paramViewHolder.getLayoutPosition() - 1;
      this.jdField_a_of_type_Uqi.a(paramViewHolder, i);
      ((uqt)this.jdField_a_of_type_Uck).a(paramViewHolder, i);
      paramViewHolder.a(i);
      if (a(i + 1)) {
        a(false, false);
      }
      a(i, paramViewHolder);
      if (i > 0) {
        this.d = true;
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Uja != null) {
      this.jdField_a_of_type_Uja.a(paramView);
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSUserAuthEvent)) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_new_msg")))
    {
      udy.a(getActivity(), "fullscreen_videoplay");
      return;
    }
    ((uqt)this.jdField_a_of_type_Uck).a(paramWSSimpleBaseEvent);
  }
  
  public void a(List<uru> paramList)
  {
    this.jdField_a_of_type_Uqi.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ueh instanceof uqp)) {
      ((uqp)this.jdField_a_of_type_Ueh).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((uqt)this.jdField_a_of_type_Uck).a(paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaLangString);
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
    p();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d(true);
    }
  }
  
  public void b(Object paramObject)
  {
    if (this.jdField_a_of_type_Ueh != null) {
      this.jdField_a_of_type_Ueh.a(paramObject);
    }
  }
  
  public void b(List<uru> paramList)
  {
    this.jdField_a_of_type_Uqi.a(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ueh instanceof uqp)) {
      ((uqp)this.jdField_a_of_type_Ueh).a(paramBoolean, this.jdField_a_of_type_Uja);
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
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d(false);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d()) {
        g();
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ucl == null)
    {
      this.jdField_a_of_type_Ucl = new ucl(getActivity(), 1);
      this.jdField_a_of_type_Ucl.b(uut.a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Ucl.setOnDismissListener(new uqz(this));
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Ucl.a(ugb.a().a());
      this.jdField_a_of_type_Ucl.a(getActivity());
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      }
    }
  }
  
  public void d(int paramInt)
  {
    uof.a(this, paramInt);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_Ueh instanceof uqn)) {
      ((uqn)this.jdField_a_of_type_Ueh).b(paramInt);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setRefreshing(false);
    }
  }
  
  public void g()
  {
    VideoFeedsRecyclerView localVideoFeedsRecyclerView = a();
    if ((localVideoFeedsRecyclerView != null) && (!localVideoFeedsRecyclerView.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(), false);
    }
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
  
  public void h()
  {
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Ufp != null) {}
    for (boolean bool = this.jdField_a_of_type_Ufp.b();; bool = false)
    {
      if (!bool)
      {
        ((uqt)this.jdField_a_of_type_Uck).f();
        unh.b();
        if ((TextUtils.equals(a(), "follow_tab")) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)) {
          unh.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(), false);
        }
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals("qqchat")))
      {
        if ((!umz.jdField_a_of_type_Boolean) && (!this.d)) {
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
    upe.a("weishi-beacon", "进入播放页的时间：" + this.jdField_a_of_type_Long);
    if (getArguments() != null) {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("key_from");
    }
    super.onCreate(paramBundle);
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    k();
    unh.a(a(), uut.a(this.jdField_a_of_type_JavaLangString), b());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560000, paramViewGroup, false);
    upe.a("weishi-comment", "onCreateView before initUI~~~~~~~~~~~");
    b(paramLayoutInflater);
    m();
    upe.a("weishi-comment", "onCreateView after initData~~~~~~~~~~~");
    j();
    i();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((uqt)this.jdField_a_of_type_Uck).b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    o();
    uhd.a().b(this);
    uiw.a().a();
    WSVerticalDataManager.a().a();
    ugb.a().b("global_key_video_layer");
    n();
    if ((this.jdField_a_of_type_Uqi != null) && (this.jdField_a_of_type_Uqi.a() != null))
    {
      utw localutw = this.jdField_a_of_type_Uqi.a();
      if (localutw != null) {
        localutw.d();
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.removeOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "qqchat")) {
      ugb.a().b("global_key_personal_feed_list");
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_home_page"))
    {
      int i = 0;
      if (this.jdField_a_of_type_Uqi != null) {
        i = this.jdField_a_of_type_Uqi.a();
      }
      unb.a().a(this.jdField_b_of_type_Long, ((uqt)b()).a(), i, ups.jdField_a_of_type_Boolean, upg.jdField_a_of_type_Boolean, 2);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_c_of_type_Long;
    ((uqt)this.jdField_a_of_type_Uck).e();
    WSPublicAccReport.getInstance().reportPageVisitExit(uut.a(this.jdField_a_of_type_JavaLangString));
    if ((this.jdField_a_of_type_Uqi != null) && (this.jdField_a_of_type_Uqi.a() != null))
    {
      utw localutw = this.jdField_a_of_type_Uqi.a();
      if (localutw != null) {
        localutw.b();
      }
    }
  }
  
  public void onRefresh()
  {
    upe.b("WSVerticalPageFragment", "[WSVerticalPageFragment.java][onRefresh]");
    ((uqt)this.jdField_a_of_type_Uck).a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    unh.a(uut.a(this.jdField_a_of_type_JavaLangString), b());
    ((uqt)this.jdField_a_of_type_Uck).d();
    if ((this.jdField_a_of_type_Uqi != null) && (this.jdField_a_of_type_Uqi.a() != null))
    {
      utw localutw = this.jdField_a_of_type_Uqi.a();
      if (localutw != null) {
        localutw.a();
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
      upe.a("weishi-beacon", "播放页初始化耗时：" + l);
      unb.a().a(true, l, "fullscreen_videoplay", this.jdField_b_of_type_JavaLangString);
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "qqchat")) {
      ugb.a().a("global_key_personal_feed_list");
    }
    WSPublicAccReport.getInstance().reportPageVisitEnter(uut.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment
 * JD-Core Version:    0.7.0.1
 */