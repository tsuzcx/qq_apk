package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stFeed;
import UserGrowth.stFollowFeedsGlobalConfig;
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
import bjwv;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSPlayerMuteEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import ujh;
import ujj;
import ujk;
import ujl;
import ujm;
import ulf;
import umj;
import unc;
import unw;
import unz;
import uou;
import upc;
import upf;
import upg;
import upp;
import uql;
import url;
import urt;
import urw;
import urx;
import utp;
import uud;
import uvi;
import uvm;
import uvr;
import uvw;
import uwz;
import uxr;
import uya;
import uyo;
import vdq;

public class WSFollowFragment
  extends WSBaseHomeFragment<uud, utp, List<stFeed>>
  implements unz, uud, uwz
{
  public static boolean c;
  private long jdField_a_of_type_Long;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private ujh jdField_a_of_type_Ujh;
  public umj a;
  private boolean d = true;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  private upp a(int paramInt, boolean paramBoolean)
  {
    int n;
    if (this.jdField_a_of_type_Ujh != null)
    {
      n = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      return null;
    }
    upp localupp;
    do
    {
      n += 1;
      if (n >= this.jdField_a_of_type_Ujh.a().size()) {
        break;
      }
      localupp = c(n, paramBoolean);
    } while (localupp == null);
    return localupp;
    return null;
  }
  
  private void a(WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.c()))
    {
      uvm.a(paramWSPlayerManager.a());
      this.d = true;
      this.e = true;
    }
  }
  
  private boolean a(upp paramupp)
  {
    if (paramupp == null) {}
    while (uxr.a(paramupp.a()) < 50) {
      return false;
    }
    return true;
  }
  
  private upp b(int paramInt, boolean paramBoolean)
  {
    int n = paramInt;
    if (paramInt < 0) {
      return null;
    }
    upp localupp;
    do
    {
      n -= 1;
      if (n < 0) {
        break;
      }
      localupp = c(n, paramBoolean);
    } while (localupp == null);
    return localupp;
  }
  
  private void b(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof uou)) {
      ((uou)localViewHolder).h();
    }
    do
    {
      return;
      if ((localViewHolder instanceof upf))
      {
        ((upf)localViewHolder).a();
        return;
      }
      if ((localViewHolder instanceof upg))
      {
        ((upg)localViewHolder).a();
        return;
      }
    } while (!(localViewHolder instanceof upc));
    ((upc)localViewHolder).a();
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if ((this.d) && (paramWSPlayerManager != null) && ((paramWSPlayerManager.c()) || (paramWSPlayerManager.b())))
    {
      uvm.a(paramWSPlayerManager.a(), false);
      paramWSPlayerManager.g();
    }
    this.d = false;
  }
  
  private void b(upp paramupp)
  {
    this.jdField_a_of_type_Ujh.a(paramupp);
    this.f = false;
  }
  
  private upp c(int paramInt, boolean paramBoolean)
  {
    Object localObject = (stFeed)this.jdField_a_of_type_Ujh.a().get(paramInt);
    if ((((stFeed)localObject).feed_type == 2) && (((stFeed)localObject).feed != null))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForLayoutPosition(paramInt);
      if ((localObject instanceof upp))
      {
        localObject = (upp)localObject;
        if ((a((upp)localObject)) || (paramBoolean)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void e(boolean paramBoolean)
  {
    uya.e("WS_VIDEO_PLAY_TIME", "[WSFollowFragment.java][reportVideoPlay] tabSelectedIndex:" + WSHomeFragment.a + ", isPlay:" + paramBoolean);
    if ((WSHomeFragment.a != 0) || (this.jdField_a_of_type_Ujh == null)) {
      return;
    }
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_Ujh.a());
      return;
    }
    b(this.jdField_a_of_type_Ujh.a());
  }
  
  private void g()
  {
    unw.a().a(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(uyo.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(true);
    this.jdField_a_of_type_Ujh.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
  }
  
  private void i()
  {
    if (!this.i)
    {
      uvu.b = 2;
      return;
    }
    if ((!this.j) && (!this.k))
    {
      uvu.b = 3;
      return;
    }
    uvu.b = 1;
  }
  
  private void j()
  {
    int n = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
    int i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
    if ((n < 0) || (i1 >= this.jdField_a_of_type_Ujh.a().size())) {}
    for (;;)
    {
      return;
      while (n <= i1)
      {
        b(n);
        n += 1;
      }
    }
  }
  
  private void k()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getChildCount();
    int n = 0;
    while (n < i1)
    {
      b(n);
      n += 1;
    }
  }
  
  private void l()
  {
    uya.b("WSFollowFragment", "showErrorView");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    uvi.a(135, 1, null);
    uvr.b(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ujl(this));
  }
  
  public stFollowFeedsGlobalConfig a()
  {
    if (b() != null) {
      return ((utp)b()).a();
    }
    return null;
  }
  
  protected RecyclerView.LayoutManager a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new ujm(this.jdField_a_of_type_AndroidContentContext, 1, false);
    return this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  }
  
  protected bjwv a()
  {
    this.jdField_a_of_type_Ujh = new ujh(this);
    return this.jdField_a_of_type_Ujh;
  }
  
  public XRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView;
  }
  
  public ArrayList<Class> a()
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
  
  public ujh a()
  {
    return this.jdField_a_of_type_Ujh;
  }
  
  public upp a(upp paramupp, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramupp != null)
    {
      int n = paramupp.getLayoutPosition();
      if (paramBoolean1) {
        return a(n + 1, paramBoolean2);
      }
      return b(n - 1, paramBoolean2);
    }
    return null;
  }
  
  @NonNull
  public utp a()
  {
    return new utp();
  }
  
  protected void a()
  {
    this.f = true;
  }
  
  public void a(int paramInt)
  {
    Object localObject2 = new StringBuilder().append("onTabSelected: ");
    if (paramInt == 0) {}
    for (Object localObject1 = "follow";; localObject1 = "recommend")
    {
      uya.b("WSFollowFragment", (String)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
      if (localObject1 != null) {
        break;
      }
      return;
    }
    if (paramInt != 0)
    {
      if (((WSPlayerManager)localObject1).c()) {
        ((WSPlayerManager)localObject1).d();
      }
      url.a().a(false);
      return;
    }
    this.f = true;
    a(a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition(), false));
    localObject2 = url.a();
    if (!((WSPlayerManager)localObject1).i()) {}
    for (boolean bool = true;; bool = false)
    {
      ((url)localObject2).a(bool);
      if (this.l) {
        break;
      }
      k();
      this.l = true;
      return;
    }
    j();
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof uou)) {
      ((uou)localViewHolder).a(paramstSimpleMetaFeed);
    }
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected void a(View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    ulf.a().b(new ujj(this));
    h();
    g();
    paramView = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368903);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370247));
    if (this.jdField_a_of_type_Umj == null)
    {
      this.jdField_a_of_type_Umj = new umj(this, 0);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      paramView.addView(localViewStub);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(new ujk(this));
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((utp)this.jdField_a_of_type_Ujc).a(paramWSSimpleBaseEvent);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    ((utp)b()).a(false, false);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    if (!this.j) {
      this.j = true;
    }
    ((utp)b()).a(false, true);
  }
  
  public void a(List<stFeed> paramList)
  {
    e();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_Ujh != null) {
      this.jdField_a_of_type_Ujh.a(paramList);
    }
    unc.a().a(paramList);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, true);
    }
  }
  
  public void a(List<stFeed> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Ujh.b(paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(true, paramBoolean);
      return;
    }
  }
  
  public void a(upp paramupp)
  {
    if ((this.f) && (a(paramupp)))
    {
      uya.c("WSFollowContinuePlayLog", "[WSFollowFragment.java][onPlayFirstVideo] playVideo title:" + paramupp.jdField_a_of_type_Urx.d + ", mPlayingHolder:" + paramupp);
      b(paramupp);
      paramupp = a(paramupp, true, true);
      uya.a("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onPlayFirstVideo] setPrePlayingHolder prePlayHolder:" + paramupp);
      this.jdField_a_of_type_Ujh.b(paramupp);
    }
  }
  
  public void a(upp paramupp, String paramString1, String paramString2)
  {
    urt localurt = unc.a().a();
    if (localurt == null) {}
    while ((paramupp == null) || (localurt.jdField_a_of_type_Urw == null) || (localurt.jdField_a_of_type_Usr == null) || (paramupp.jdField_a_of_type_Urt == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null)) {
      return;
    }
    paramupp.jdField_a_of_type_Urt.jdField_a_of_type_Urw = localurt.jdField_a_of_type_Urw;
    paramupp.jdField_a_of_type_Urt.jdField_a_of_type_Usr = localurt.jdField_a_of_type_Usr;
    paramupp.jdField_a_of_type_Urt.jdField_a_of_type_Usf = localurt.jdField_a_of_type_Usf;
    paramupp.jdField_a_of_type_Urt.jdField_a_of_type_Urw.c(true);
    this.jdField_a_of_type_Ujh.a = paramupp;
    vdq.a(paramString1, paramString2, paramupp.jdField_a_of_type_Urt, false);
    if (!this.e) {
      uvm.a(paramupp.jdField_a_of_type_Urt);
    }
    paramString1 = a(paramupp, true, true);
    this.jdField_a_of_type_Ujh.b(paramString1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramupp.jdField_a_of_type_Urt, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_Ujh.a());
    this.d = true;
    this.e = false;
    uya.a("WSFollowContinuePlayLog", "WSFollowFragment handleOnActivityResultFromVertical()2, title: " + paramupp.jdField_a_of_type_Urt.jdField_a_of_type_Urx.d + ", playingHolder: " + paramupp);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_Ujh != null) && (this.jdField_a_of_type_Ujh.a().size() == 0)) {
      l();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, List<stFeed> paramList, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (!this.jdField_a_of_type_Boolean)) {
      this.h = true;
    }
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Boolean) {
      uyo.d("focus");
    }
  }
  
  public void b(List<stFeed> paramList)
  {
    this.i = true;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Ujh.a(paramList);
    b(true, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_a_of_type_Ujh.a(View.inflate(getActivity(), 2131560396, null));
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.f = paramBoolean;
  }
  
  public boolean c()
  {
    return (a() != null) && (a().showMute);
  }
  
  public void d()
  {
    ((utp)b()).a(true, false);
  }
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean d()
  {
    return (!this.m) && (c());
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public void f()
  {
    this.m = true;
    uxr.a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.g = true;
      paramInt1 = paramIntent.getIntExtra("key_feed_position", 0);
      String str = paramIntent.getStringExtra("key_from");
      paramIntent = paramIntent.getStringExtra("key_play_scene");
      uya.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical position:" + paramInt1);
      ThreadManager.getUIHandler().postDelayed(new WSFollowFragment.3(this, str, paramIntent), 100L);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Umj != null) {
      return this.jdField_a_of_type_Umj.b();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.m = uxr.b();
    uya.a("weishi-beacon", "进入瀑布流的时间：" + this.jdField_a_of_type_Long);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    i();
    ulf.a().a(this.jdField_a_of_type_Ujh.a());
    unw.a().b(this);
    uql.a().a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().clearOnScrollListeners();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Boolean)
    {
      WSPublicAccReport.getInstance().reportPageVisitExit("focus");
      url.a().a(false);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (!c)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
    }
    e(false);
  }
  
  public void onResume()
  {
    super.onResume();
    url localurl;
    if (this.jdField_a_of_type_Boolean)
    {
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
      localurl = url.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.i()) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      localurl.a(bool);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e();
        e(true);
      }
      if (this.jdField_a_of_type_Long > 0L)
      {
        long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long = 0L;
        uya.a("weishi-beacon", "关注页初始化耗时：" + l1);
        uvw.a().a(true, l1, "focus", "focus");
      }
      return;
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    uya.b("WSFollowFragment", "setUserVisibleHint entered! visible: " + paramBoolean + ", isResumed: " + isResumed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment
 * JD-Core Version:    0.7.0.1
 */