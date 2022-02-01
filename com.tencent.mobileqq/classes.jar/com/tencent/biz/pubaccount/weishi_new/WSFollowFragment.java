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
import blig;
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
import uxe;
import uxg;
import uxh;
import uxi;
import uxj;
import uzf;
import vaj;
import vbc;
import vbw;
import vbz;
import vcu;
import vdd;
import vdg;
import vdh;
import vdq;
import vem;
import vft;
import vgb;
import vgh;
import vgi;
import via;
import viq;
import vjx;
import vka;
import vkf;
import vkk;
import vlo;
import vmg;
import vmp;
import vnd;
import vsj;

public class WSFollowFragment
  extends WSBaseHomeFragment<viq, via, List<stFeed>>
  implements vbz, viq, vlo
{
  public static boolean c;
  private long jdField_a_of_type_Long;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private uxe jdField_a_of_type_Uxe;
  public vaj a;
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
  
  private vdq a(int paramInt, boolean paramBoolean)
  {
    int n;
    if (this.jdField_a_of_type_Uxe != null)
    {
      n = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      return null;
    }
    vdq localvdq;
    do
    {
      n += 1;
      if (n >= this.jdField_a_of_type_Uxe.b().size()) {
        break;
      }
      localvdq = c(n, paramBoolean);
    } while (localvdq == null);
    return localvdq;
    return null;
  }
  
  private void a(WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.c()))
    {
      vka.a(paramWSPlayerManager.a());
      this.d = true;
      this.e = true;
    }
  }
  
  private boolean a(vdq paramvdq)
  {
    if (paramvdq == null) {}
    while (vmg.a(paramvdq.a()) < 50) {
      return false;
    }
    return true;
  }
  
  private vdq b(int paramInt, boolean paramBoolean)
  {
    int n = paramInt;
    if (paramInt < 0) {
      return null;
    }
    vdq localvdq;
    do
    {
      n -= 1;
      if (n < 0) {
        break;
      }
      localvdq = c(n, paramBoolean);
    } while (localvdq == null);
    return localvdq;
  }
  
  private void b(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof vcu)) {
      ((vcu)localViewHolder).i();
    }
    do
    {
      return;
      if ((localViewHolder instanceof vdg))
      {
        ((vdg)localViewHolder).a();
        return;
      }
      if ((localViewHolder instanceof vdh))
      {
        ((vdh)localViewHolder).a();
        return;
      }
    } while (!(localViewHolder instanceof vdd));
    ((vdd)localViewHolder).b();
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if ((this.d) && (paramWSPlayerManager != null) && ((paramWSPlayerManager.c()) || (paramWSPlayerManager.b())))
    {
      vka.a(paramWSPlayerManager.a(), false);
      paramWSPlayerManager.g();
    }
    this.d = false;
  }
  
  private void b(vdq paramvdq)
  {
    this.jdField_a_of_type_Uxe.a(paramvdq);
    this.f = false;
  }
  
  private vdq c(int paramInt, boolean paramBoolean)
  {
    Object localObject = (stFeed)this.jdField_a_of_type_Uxe.b().get(paramInt);
    if ((((stFeed)localObject).feed_type == 2) && (((stFeed)localObject).feed != null))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForLayoutPosition(paramInt);
      if ((localObject instanceof vdq))
      {
        localObject = (vdq)localObject;
        if ((a((vdq)localObject)) || (paramBoolean)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void e(boolean paramBoolean)
  {
    vmp.e("WS_VIDEO_PLAY_TIME", "[WSFollowFragment.java][reportVideoPlay] tabSelectedIndex:" + WSHomeFragment.a + ", isPlay:" + paramBoolean);
    if ((WSHomeFragment.a != 0) || (this.jdField_a_of_type_Uxe == null)) {
      return;
    }
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_Uxe.a());
      return;
    }
    b(this.jdField_a_of_type_Uxe.a());
  }
  
  private void g()
  {
    vbw.a().a(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(vnd.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(true);
    this.jdField_a_of_type_Uxe.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
  }
  
  private void i()
  {
    if (!this.i)
    {
      vki.b = 2;
      return;
    }
    if ((!this.j) && (!this.k))
    {
      vki.b = 3;
      return;
    }
    vki.b = 1;
  }
  
  private void j()
  {
    int n = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
    int i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
    if ((n < 0) || (i1 >= this.jdField_a_of_type_Uxe.b().size())) {}
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
    vmp.b("WSFollowFragment", "showErrorView");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    vjx.a(135, 1, null);
    vkf.b(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new uxi(this));
  }
  
  public stFollowFeedsGlobalConfig a()
  {
    if (b() != null) {
      return ((via)b()).a();
    }
    return null;
  }
  
  protected RecyclerView.LayoutManager a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new uxj(this.jdField_a_of_type_AndroidContentContext, 1, false);
    return this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  }
  
  protected blig a()
  {
    this.jdField_a_of_type_Uxe = new uxe(this);
    return this.jdField_a_of_type_Uxe;
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
  
  public uxe a()
  {
    return this.jdField_a_of_type_Uxe;
  }
  
  public vdq a(vdq paramvdq, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramvdq != null)
    {
      int n = paramvdq.getLayoutPosition();
      if (paramBoolean1) {
        return a(n + 1, paramBoolean2);
      }
      return b(n - 1, paramBoolean2);
    }
    return null;
  }
  
  @NonNull
  public via a()
  {
    return new via();
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
      vmp.b("WSFollowFragment", (String)localObject1);
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
      vft.a().a(false);
      return;
    }
    this.f = true;
    a(a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition(), false));
    localObject2 = vft.a();
    if (!((WSPlayerManager)localObject1).i()) {}
    for (boolean bool = true;; bool = false)
    {
      ((vft)localObject2).a(bool);
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
    if ((localViewHolder instanceof vcu)) {
      ((vcu)localViewHolder).a(paramstSimpleMetaFeed);
    }
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected void a(View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    uzf.a().b(new uxg(this));
    h();
    g();
    paramView = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369065);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370426));
    if (this.jdField_a_of_type_Vaj == null)
    {
      this.jdField_a_of_type_Vaj = new vaj(this, 0);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      paramView.addView(localViewStub);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(new uxh(this));
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((via)this.jdField_a_of_type_Uwz).a(paramWSSimpleBaseEvent);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    ((via)b()).a(false, false);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    if (!this.j) {
      this.j = true;
    }
    ((via)b()).a(false, true);
  }
  
  public void a(List<stFeed> paramList)
  {
    e();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_Uxe != null) {
      this.jdField_a_of_type_Uxe.a(paramList);
    }
    vbc.a().a(paramList);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, true);
    }
  }
  
  public void a(List<stFeed> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Uxe.b(paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(true, paramBoolean);
      return;
    }
  }
  
  public void a(vdq paramvdq)
  {
    if ((this.f) && (a(paramvdq)))
    {
      vmp.c("WSFollowContinuePlayLog", "[WSFollowFragment.java][onPlayFirstVideo] playVideo title:" + paramvdq.jdField_a_of_type_Vgi.d + ", mPlayingHolder:" + paramvdq);
      b(paramvdq);
      paramvdq = a(paramvdq, true, true);
      vmp.a("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onPlayFirstVideo] setPrePlayingHolder prePlayHolder:" + paramvdq);
      this.jdField_a_of_type_Uxe.b(paramvdq);
    }
  }
  
  public void a(vdq paramvdq, String paramString1, String paramString2)
  {
    vgb localvgb = vbc.a().a();
    if (localvgb == null) {}
    while ((paramvdq == null) || (localvgb.jdField_a_of_type_Vgh == null) || (localvgb.jdField_a_of_type_Vhc == null) || (paramvdq.jdField_a_of_type_Vgb == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null)) {
      return;
    }
    paramvdq.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh = localvgb.jdField_a_of_type_Vgh;
    paramvdq.jdField_a_of_type_Vgb.jdField_a_of_type_Vhc = localvgb.jdField_a_of_type_Vhc;
    paramvdq.jdField_a_of_type_Vgb.jdField_a_of_type_Vgq = localvgb.jdField_a_of_type_Vgq;
    paramvdq.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh.c(true);
    this.jdField_a_of_type_Uxe.a = paramvdq;
    vsj.a(paramString1, paramString2, paramvdq.jdField_a_of_type_Vgb, false);
    if (!this.e) {
      vka.a(paramvdq.jdField_a_of_type_Vgb);
    }
    paramString1 = a(paramvdq, true, true);
    this.jdField_a_of_type_Uxe.b(paramString1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramvdq.jdField_a_of_type_Vgb, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_Uxe.a());
    this.d = true;
    this.e = false;
    vmp.a("WSFollowContinuePlayLog", "WSFollowFragment handleOnActivityResultFromVertical()2, title: " + paramvdq.jdField_a_of_type_Vgb.jdField_a_of_type_Vgi.d + ", playingHolder: " + paramvdq);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_Uxe != null) && (this.jdField_a_of_type_Uxe.b().size() == 0)) {
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
      vnd.d("focus");
    }
  }
  
  public void b(List<stFeed> paramList)
  {
    this.i = true;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Uxe.a(paramList);
    b(true, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_a_of_type_Uxe.a(View.inflate(getActivity(), 2131560446, null));
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
    ((via)b()).a(true, false);
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
    vmg.a();
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
      vmp.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical position:" + paramInt1);
      ThreadManager.getUIHandler().postDelayed(new WSFollowFragment.3(this, str, paramIntent), 100L);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Vaj != null) {
      return this.jdField_a_of_type_Vaj.b();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.m = vmg.b();
    vmp.a("weishi-beacon", "进入瀑布流的时间：" + this.jdField_a_of_type_Long);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    i();
    uzf.a().a(this.jdField_a_of_type_Uxe.b());
    vbw.a().b(this);
    vem.a().a();
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
      vft.a().a(false);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (!c)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
    }
    e(false);
  }
  
  public void onResume()
  {
    super.onResume();
    vft localvft;
    if (this.jdField_a_of_type_Boolean)
    {
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
      localvft = vft.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.i()) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      localvft.a(bool);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e();
        e(true);
      }
      if (this.jdField_a_of_type_Long > 0L)
      {
        long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long = 0L;
        vmp.a("weishi-beacon", "关注页初始化耗时：" + l1);
        vkk.a().a(true, l1, "focus", "focus");
      }
      return;
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    vmp.b("WSFollowFragment", "setUserVisibleHint entered! visible: " + paramBoolean + ", isResumed: " + isResumed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment
 * JD-Core Version:    0.7.0.1
 */