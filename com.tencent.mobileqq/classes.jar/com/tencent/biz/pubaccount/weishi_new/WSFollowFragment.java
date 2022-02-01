package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stFeed;
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
import bkrs;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
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
import ucp;
import ucr;
import ucs;
import uct;
import ucu;
import uen;
import ufp;
import ugj;
import uhd;
import uhg;
import uhk;
import uhs;
import uhv;
import uhw;
import uif;
import uiw;
import ukb;
import uke;
import ukf;
import ukx;
import ull;
import umq;
import umu;
import umw;
import unb;
import uod;
import uov;
import upe;
import ups;
import uut;

public class WSFollowFragment
  extends WSBaseHomeFragment<ull, ukx, List<stFeed>>
  implements uhg, ull, uod
{
  public static boolean c;
  private long jdField_a_of_type_Long;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private ucp jdField_a_of_type_Ucp;
  public ufp a;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  
  private uif a(int paramInt, boolean paramBoolean)
  {
    int k;
    if (this.jdField_a_of_type_Ucp != null)
    {
      k = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      return null;
    }
    uif localuif;
    do
    {
      k += 1;
      if (k >= this.jdField_a_of_type_Ucp.a().size()) {
        break;
      }
      localuif = c(k, paramBoolean);
    } while (localuif == null);
    return localuif;
    return null;
  }
  
  private boolean a(uif paramuif)
  {
    if (paramuif == null) {}
    while (uov.a(paramuif.a()) < 50) {
      return false;
    }
    return true;
  }
  
  private uif b(int paramInt, boolean paramBoolean)
  {
    int k = paramInt;
    if (paramInt < 0) {
      return null;
    }
    uif localuif;
    do
    {
      k -= 1;
      if (k < 0) {
        break;
      }
      localuif = c(k, paramBoolean);
    } while (localuif == null);
    return localuif;
  }
  
  private void b(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof uhk)) {
      ((uhk)localViewHolder).d();
    }
    do
    {
      return;
      if ((localViewHolder instanceof uhv))
      {
        ((uhv)localViewHolder).a();
        return;
      }
      if ((localViewHolder instanceof uhw))
      {
        ((uhw)localViewHolder).a();
        return;
      }
    } while (!(localViewHolder instanceof uhs));
    ((uhs)localViewHolder).a();
  }
  
  private void b(uif paramuif)
  {
    this.jdField_a_of_type_Ucp.a(paramuif);
    this.d = false;
  }
  
  private uif c(int paramInt, boolean paramBoolean)
  {
    Object localObject = (stFeed)this.jdField_a_of_type_Ucp.a().get(paramInt);
    if ((((stFeed)localObject).feed_type == 2) && (((stFeed)localObject).feed != null))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForLayoutPosition(paramInt);
      if ((localObject instanceof uif))
      {
        localObject = (uif)localObject;
        if ((a((uif)localObject)) || (paramBoolean)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void f()
  {
    uhd.a().a(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(ups.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d(true);
    this.jdField_a_of_type_Ucp.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
  }
  
  private void h()
  {
    if (!this.g)
    {
      umz.b = 2;
      return;
    }
    if ((!this.h) && (!this.i))
    {
      umz.b = 3;
      return;
    }
    umz.b = 1;
  }
  
  private void i()
  {
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
    int m = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
    if ((k < 0) || (m >= this.jdField_a_of_type_Ucp.a().size())) {}
    for (;;)
    {
      return;
      while (k <= m)
      {
        b(k);
        k += 1;
      }
    }
  }
  
  private void j()
  {
    int m = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getChildCount();
    int k = 0;
    while (k < m)
    {
      b(k);
      k += 1;
    }
  }
  
  private void k()
  {
    upe.b("WSFollowFragment", "showErrorView");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    umq.a(135, 1, null);
    umw.b(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new uct(this));
  }
  
  protected RecyclerView.LayoutManager a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new ucu(this.jdField_a_of_type_AndroidContentContext, 1, false);
    return this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  }
  
  protected bkrs a()
  {
    this.jdField_a_of_type_Ucp = new ucp(this);
    return this.jdField_a_of_type_Ucp;
  }
  
  public XRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView;
  }
  
  public ucp a()
  {
    return this.jdField_a_of_type_Ucp;
  }
  
  public uif a(uif paramuif, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramuif != null)
    {
      int k = paramuif.getLayoutPosition();
      if (paramBoolean1) {
        return a(k + 1, paramBoolean2);
      }
      return b(k - 1, paramBoolean2);
    }
    return null;
  }
  
  @NonNull
  public ukx a()
  {
    return new ukx();
  }
  
  protected void a()
  {
    this.d = true;
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onTabSelected: ");
    if (paramInt == 0) {}
    for (String str = "follow";; str = "recommend")
    {
      upe.b("WSFollowFragment", str);
      if (paramInt == 0) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c()) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
      }
      return;
    }
    this.d = true;
    a(a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition(), false));
    if (!this.j)
    {
      j();
      this.j = true;
      return;
    }
    i();
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof uhk)) {
      ((uhk)localViewHolder).a(paramstSimpleMetaFeed);
    }
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected void a(View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    uen.a().b(new ucr(this));
    g();
    f();
    paramView = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368800);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370179));
    if (this.jdField_a_of_type_Ufp == null)
    {
      this.jdField_a_of_type_Ufp = new ufp(this, 0);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Ufp.a(localViewStub);
      paramView.addView(localViewStub);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(new ucs(this));
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((ukx)this.jdField_a_of_type_Uck).a(paramWSSimpleBaseEvent);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    ((ukx)b()).a(false, false);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    if (!this.h) {
      this.h = true;
    }
    ((ukx)b()).a(false, true);
  }
  
  public void a(List<stFeed> paramList)
  {
    e();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_Ucp != null) {
      this.jdField_a_of_type_Ucp.a(paramList);
    }
    ugj.a().a(paramList);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, true);
    }
  }
  
  public void a(List<stFeed> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Ucp.b(paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(true, paramBoolean);
      return;
    }
  }
  
  public void a(uif paramuif)
  {
    if ((this.d) && (a(paramuif)))
    {
      upe.c("WSFollowContinuePlayLog", "[WSFollowFragment.java][onPlayFirstVideo] playVideo title:" + paramuif.jdField_a_of_type_Ukf.d + ", mPlayingHolder:" + paramuif);
      b(paramuif);
      paramuif = a(paramuif, true, true);
      upe.a("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onPlayFirstVideo] setPrePlayingHolder prePlayHolder:" + paramuif);
      this.jdField_a_of_type_Ucp.b(paramuif);
    }
  }
  
  public void a(uif paramuif, String paramString1, String paramString2)
  {
    ukb localukb = ugj.a().a();
    if (localukb == null) {}
    while ((paramuif == null) || (localukb.jdField_a_of_type_Uke == null) || (localukb.jdField_a_of_type_AndroidViewView == null) || (paramuif.jdField_a_of_type_Ukb == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null)) {
      return;
    }
    paramuif.jdField_a_of_type_Ukb.jdField_a_of_type_Uke = localukb.jdField_a_of_type_Uke;
    paramuif.jdField_a_of_type_Ukb.jdField_a_of_type_AndroidViewView = localukb.jdField_a_of_type_AndroidViewView;
    paramuif.jdField_a_of_type_Ukb.jdField_a_of_type_Uko = localukb.jdField_a_of_type_Uko;
    paramuif.jdField_a_of_type_Ukb.jdField_a_of_type_Uke.c(true);
    this.jdField_a_of_type_Ucp.a = paramuif;
    uut.a(paramString1, paramString2, paramuif.jdField_a_of_type_Ukb, false);
    umu.a(paramuif.jdField_a_of_type_Ukb);
    paramString1 = a(paramuif, true, true);
    this.jdField_a_of_type_Ucp.b(paramString1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramuif.jdField_a_of_type_Ukb, true);
    upe.a("WSFollowContinuePlayLog", "WSFollowFragment handleOnActivityResultFromVertical()2, title: " + paramuif.jdField_a_of_type_Ukb.jdField_a_of_type_Ukf.d + ", playingHolder: " + paramuif);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_Ucp != null) && (this.jdField_a_of_type_Ucp.a().size() == 0)) {
      k();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, List<stFeed> paramList, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (!this.jdField_a_of_type_Boolean)) {
      this.f = true;
    }
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Boolean) {
      ups.d("focus");
    }
  }
  
  public void b(List<stFeed> paramList)
  {
    this.g = true;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Ucp.a(paramList);
    b(true, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_a_of_type_Ucp.a(View.inflate(getActivity(), 2131560374, null));
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public void d()
  {
    ((ukx)b()).a(true, false);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(WSVideoPlayEvent.class);
    localArrayList.add(WSItemExposeEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    localArrayList.add(WSFriendFeedExposureEvent.class);
    return localArrayList;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.e = true;
      paramInt1 = paramIntent.getIntExtra("key_feed_position", 0);
      String str = paramIntent.getStringExtra("key_from");
      paramIntent = paramIntent.getStringExtra("key_play_scene");
      upe.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical position:" + paramInt1);
      ThreadManager.getUIHandler().postDelayed(new WSFollowFragment.3(this, str, paramIntent), 100L);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Ufp != null) {
      return this.jdField_a_of_type_Ufp.b();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    upe.a("weishi-beacon", "进入瀑布流的时间：" + this.jdField_a_of_type_Long);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    h();
    uen.a().a(this.jdField_a_of_type_Ucp.a());
    uhd.a().b(this);
    uiw.a().a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().clearOnScrollListeners();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Boolean) {
      WSPublicAccReport.getInstance().reportPageVisitExit("focus");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (!c)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boolean) {
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e();
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = 0L;
      upe.a("weishi-beacon", "关注页初始化耗时：" + l);
      unb.a().a(true, l, "focus", "focus");
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    upe.b("WSFollowFragment", "setUserVisibleHint entered! visible: " + paramBoolean + ", isResumed: " + isResumed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment
 * JD-Core Version:    0.7.0.1
 */