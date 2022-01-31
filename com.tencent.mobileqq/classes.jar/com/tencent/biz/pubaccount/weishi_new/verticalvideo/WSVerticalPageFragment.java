package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stSimpleMetaFeed;
import abqm;
import adky;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import biac;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import rgv;
import tdn;
import tdt;
import tff;
import tfi;
import tgg;
import tgk;
import tlo;
import tlu;
import tlv;
import tme;
import tmf;
import tmi;
import tmj;
import tmk;
import tml;
import tmn;
import tmv;
import tnj;
import tnt;

public class WSVerticalPageFragment
  extends WSBaseFragment<tmj, tmi>
  implements rgv, tdt, tfi, tmj
{
  private int jdField_a_of_type_Int;
  public FrameLayout a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString;
  private List<tmv> jdField_a_of_type_JavaUtilList;
  public tdn a;
  private tgk jdField_a_of_type_Tgk;
  private tmf jdField_a_of_type_Tmf;
  
  private int a(String paramString)
  {
    if ((TextUtils.equals(paramString, "recommend_tab")) || (TextUtils.equals(paramString, "mini_app_personal_main")) || (TextUtils.equals(paramString, "mini_app_personal_guest"))) {
      return 1;
    }
    if (TextUtils.equals(paramString, "follow_tab")) {
      return 0;
    }
    return -1;
  }
  
  @NotNull
  private static Intent a(String paramString, List<stSimpleMetaFeed> paramList, int paramInt)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_from", paramString);
    if ((paramList != null) && (paramList.size() > 0)) {
      localBundle.putSerializable("key_feed_list", new ArrayList(paramList));
    }
    localBundle.putInt("key_feed_position", paramInt);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void a(int paramInt, biac parambiac)
  {
    if ((parambiac instanceof tnj))
    {
      parambiac = (tmv)((tnj)parambiac).a;
      if ((parambiac != null) && ((parambiac.a() instanceof stSimpleMetaFeed)))
      {
        parambiac = (stSimpleMetaFeed)parambiac.a();
        tnt.a(paramInt, parambiac);
        tnt.a(parambiac);
      }
    }
  }
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130772188, 2130772187);
  }
  
  public static void a(Activity paramActivity, String paramString, List<stSimpleMetaFeed> paramList, int paramInt)
  {
    tlo.b("WSVerticalPageFragment", "start() needScrollToPosition:" + paramInt);
    adky.a(paramActivity, a(paramString, paramList, paramInt), PublicFragmentActivity.class, WSVerticalPageFragment.class);
    a(paramActivity);
  }
  
  public static void a(Activity paramActivity, String paramString, List<stSimpleMetaFeed> paramList, int paramInt1, int paramInt2)
  {
    tlo.b("WSVerticalPageFragment", "startForResult() needScrollToPosition:" + paramInt1);
    adky.a(paramActivity, a(paramString, paramList, paramInt1), PublicFragmentActivity.class, WSVerticalPageFragment.class, paramInt2);
    a(paramActivity);
  }
  
  private void a(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131379514);
    int i = tlu.a(getActivity());
    localRelativeLayout.setPadding(localRelativeLayout.getPaddingLeft(), i + localRelativeLayout.getPaddingTop(), localRelativeLayout.getPaddingRight(), localRelativeLayout.getPaddingBottom());
    paramView.findViewById(2131379515).setOnClickListener(new tmk(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)paramView.findViewById(2131380255));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366413));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131379512));
    b(paramView.findViewById(2131368683));
    paramView.findViewById(2131379516).setOnClickListener(new tml(this));
    j();
    i();
  }
  
  private boolean a(int paramInt)
  {
    List localList = this.jdField_a_of_type_Tmf.a();
    tlo.b("WSVerticalPageFragment", "onCenterViewChanged currentPosition:" + paramInt + ", dataList.size:" + localList.size());
    if ((paramInt != 1) && (localList.size() - paramInt < ((tmi)this.jdField_a_of_type_Taw).a()))
    {
      tlo.b("WSVerticalPageFragment", "onPreLoadMore");
      return true;
    }
    return false;
  }
  
  private void b(View paramView)
  {
    if (this.jdField_a_of_type_Tgk != null) {
      this.jdField_a_of_type_Tgk.a(paramView);
    }
  }
  
  private void f()
  {
    tff.a().a(this);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Tdn == null)
    {
      tlo.a("weishi-comment", "initCommentPresenter create!!!");
      this.jdField_a_of_type_Tdn = new tdn(this, a(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Tdn.a(this);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Tdn.a(localViewStub);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localViewStub);
      return;
    }
    tlo.a("weishi-comment", "initCommentPresenter 复用~~~~~~,pageIndex:" + this.jdField_a_of_type_Tdn.jdField_a_of_type_Int);
  }
  
  private void h()
  {
    if (getArguments() != null)
    {
      this.jdField_a_of_type_JavaUtilList = ((tmi)this.jdField_a_of_type_Taw).a((ArrayList)getArguments().getSerializable("key_feed_list"));
      WSPublicAccReport.getInstance().reportEnterVerticalVideo(this.jdField_a_of_type_JavaUtilList, 1, true, -1);
      this.jdField_a_of_type_Int = ((tmi)this.jdField_a_of_type_Taw).a(getArguments().getInt("key_feed_position"));
    }
  }
  
  private void i()
  {
    tme localtme = new tme(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(localtme);
    this.jdField_a_of_type_Tmf = new tmf(getActivity(), this);
    this.jdField_a_of_type_Tmf.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Tmf);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Tmf.a(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      localtme.scrollToPosition(this.jdField_a_of_type_Int);
      return;
      a(false);
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(tlv.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d(false);
  }
  
  private void k()
  {
    a(false, true);
  }
  
  private void l()
  {
    tnj localtnj = this.jdField_a_of_type_Tmf.a();
    if (localtnj != null) {
      localtnj.a();
    }
    m();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Tgk != null) {
      this.jdField_a_of_type_Tgk.a(a());
    }
  }
  
  private void n()
  {
    if (TextUtils.equals("mini_app_personal_main", this.jdField_a_of_type_JavaLangString)) {
      tlv.c("homepage_main");
    }
    while (!TextUtils.equals("mini_app_personal_guest", this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    tlv.c("homepage_guest");
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
    this.jdField_a_of_type_Tgk = new tgk();
    return this.jdField_a_of_type_Tgk.a();
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
    return localArrayList;
  }
  
  public tmf a()
  {
    return this.jdField_a_of_type_Tmf;
  }
  
  @NonNull
  public tmi a()
  {
    return tmn.a(this.jdField_a_of_type_JavaLangString, this);
  }
  
  public void a()
  {
    tlo.b("WSVerticalPageFragment", "onLoadMore");
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    getActivity().setResult(paramInt, paramIntent);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    tlo.b("WSVerticalPageFragment", "onCenterViewChanged: " + paramViewHolder);
    if ((paramViewHolder instanceof biac))
    {
      paramViewHolder = (biac)paramViewHolder;
      int i = paramViewHolder.getLayoutPosition() - 1;
      this.jdField_a_of_type_Tmf.a(paramViewHolder, i);
      ((tmi)this.jdField_a_of_type_Taw).a(paramViewHolder, i);
      if (a(i + 1)) {
        a(false, false);
      }
      a(i, paramViewHolder);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((tmi)this.jdField_a_of_type_Taw).a(paramWSSimpleBaseEvent);
  }
  
  public void a(List<tmv> paramList)
  {
    this.jdField_a_of_type_Tmf.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((tmi)this.jdField_a_of_type_Taw).a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    super.b();
    tlv.c("fullscreen_videoPlay");
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d(true);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d(false);
    }
  }
  
  public boolean onBackEvent()
  {
    ((tmi)this.jdField_a_of_type_Taw).e();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    tlo.a("weishi-comment", "onCreate before ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    if (getArguments() != null) {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("key_from");
    }
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    h();
    tnt.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559859, paramViewGroup, false);
    tlo.a("weishi-comment", "onCreateView before initUI~~~~~~~~~~~");
    a(paramLayoutInflater);
    k();
    tlo.a("weishi-comment", "onCreateView after initData~~~~~~~~~~~");
    g();
    f();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((tmi)this.jdField_a_of_type_Taw).b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = null;
    }
    this.jdField_a_of_type_Tmf = null;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    n();
    tff.a().b(this);
    tgg.a().a();
    tnt.a();
    abqm.a(getActivity());
  }
  
  public void onPause()
  {
    super.onPause();
    ((tmi)this.jdField_a_of_type_Taw).d();
    WSPublicAccReport.getInstance().reportPageVisitExit("fullscreen_videoPlay");
  }
  
  public void onResume()
  {
    super.onResume();
    ((tmi)this.jdField_a_of_type_Taw).c();
    com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.b = false;
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
    }
    WSPublicAccReport.getInstance().reportPageVisitEnter("fullscreen_videoPlay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment
 * JD-Core Version:    0.7.0.1
 */