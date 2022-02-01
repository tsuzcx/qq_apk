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
import blsv;
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
import ucr;
import uct;
import ucu;
import ucv;
import ucw;
import uep;
import ufr;
import ugl;
import uhf;
import uhi;
import uhz;
import uih;
import uik;
import uil;
import uiu;
import ujq;
import ukq;
import ukz;
import ulc;
import uld;
import ulv;
import umj;
import uno;
import uns;
import unx;
import uoc;
import upe;
import upw;
import uqf;
import uqt;
import uvv;

public class WSFollowFragment
  extends WSBaseHomeFragment<umj, ulv, List<stFeed>>
  implements uhi, umj, upe
{
  public static boolean c;
  private long jdField_a_of_type_Long;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private ucr jdField_a_of_type_Ucr;
  public ufr a;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  private uiu a(int paramInt, boolean paramBoolean)
  {
    int m;
    if (this.jdField_a_of_type_Ucr != null)
    {
      m = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      return null;
    }
    uiu localuiu;
    do
    {
      m += 1;
      if (m >= this.jdField_a_of_type_Ucr.a().size()) {
        break;
      }
      localuiu = c(m, paramBoolean);
    } while (localuiu == null);
    return localuiu;
    return null;
  }
  
  private boolean a(uiu paramuiu)
  {
    if (paramuiu == null) {}
    while (upw.a(paramuiu.a()) < 50) {
      return false;
    }
    return true;
  }
  
  private uiu b(int paramInt, boolean paramBoolean)
  {
    int m = paramInt;
    if (paramInt < 0) {
      return null;
    }
    uiu localuiu;
    do
    {
      m -= 1;
      if (m < 0) {
        break;
      }
      localuiu = c(m, paramBoolean);
    } while (localuiu == null);
    return localuiu;
  }
  
  private void b(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof uhz)) {
      ((uhz)localViewHolder).h();
    }
    do
    {
      return;
      if ((localViewHolder instanceof uik))
      {
        ((uik)localViewHolder).a();
        return;
      }
      if ((localViewHolder instanceof uil))
      {
        ((uil)localViewHolder).a();
        return;
      }
    } while (!(localViewHolder instanceof uih));
    ((uih)localViewHolder).a();
  }
  
  private void b(uiu paramuiu)
  {
    this.jdField_a_of_type_Ucr.a(paramuiu);
    this.d = false;
  }
  
  private uiu c(int paramInt, boolean paramBoolean)
  {
    Object localObject = (stFeed)this.jdField_a_of_type_Ucr.a().get(paramInt);
    if ((((stFeed)localObject).feed_type == 2) && (((stFeed)localObject).feed != null))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForLayoutPosition(paramInt);
      if ((localObject instanceof uiu))
      {
        localObject = (uiu)localObject;
        if ((a((uiu)localObject)) || (paramBoolean)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void g()
  {
    uhf.a().a(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(uqt.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(true);
    this.jdField_a_of_type_Ucr.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
  }
  
  private void i()
  {
    if (!this.g)
    {
      uoa.b = 2;
      return;
    }
    if ((!this.h) && (!this.i))
    {
      uoa.b = 3;
      return;
    }
    uoa.b = 1;
  }
  
  private void j()
  {
    int m = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
    int n = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
    if ((m < 0) || (n >= this.jdField_a_of_type_Ucr.a().size())) {}
    for (;;)
    {
      return;
      while (m <= n)
      {
        b(m);
        m += 1;
      }
    }
  }
  
  private void k()
  {
    int n = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getChildCount();
    int m = 0;
    while (m < n)
    {
      b(m);
      m += 1;
    }
  }
  
  private void l()
  {
    uqf.b("WSFollowFragment", "showErrorView");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    uno.a(135, 1, null);
    unx.b(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ucv(this));
  }
  
  public stFollowFeedsGlobalConfig a()
  {
    if (b() != null) {
      return ((ulv)b()).a();
    }
    return null;
  }
  
  protected RecyclerView.LayoutManager a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new ucw(this.jdField_a_of_type_AndroidContentContext, 1, false);
    return this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  }
  
  protected blsv a()
  {
    this.jdField_a_of_type_Ucr = new ucr(this);
    return this.jdField_a_of_type_Ucr;
  }
  
  public XRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView;
  }
  
  public ucr a()
  {
    return this.jdField_a_of_type_Ucr;
  }
  
  public uiu a(uiu paramuiu, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramuiu != null)
    {
      int m = paramuiu.getLayoutPosition();
      if (paramBoolean1) {
        return a(m + 1, paramBoolean2);
      }
      return b(m - 1, paramBoolean2);
    }
    return null;
  }
  
  @NonNull
  public ulv a()
  {
    return new ulv();
  }
  
  protected void a()
  {
    this.d = true;
  }
  
  public void a(int paramInt)
  {
    Object localObject2 = new StringBuilder().append("onTabSelected: ");
    if (paramInt == 0) {}
    for (Object localObject1 = "follow";; localObject1 = "recommend")
    {
      uqf.b("WSFollowFragment", (String)localObject1);
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
      ukq.a().a(false);
      return;
    }
    this.d = true;
    a(a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition(), false));
    localObject2 = ukq.a();
    if (!((WSPlayerManager)localObject1).i()) {}
    for (boolean bool = true;; bool = false)
    {
      ((ukq)localObject2).a(bool);
      if (this.j) {
        break;
      }
      k();
      this.j = true;
      return;
    }
    j();
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof uhz)) {
      ((uhz)localViewHolder).a(paramstSimpleMetaFeed);
    }
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected void a(View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    uep.a().b(new uct(this));
    h();
    g();
    paramView = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368878);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370279));
    if (this.jdField_a_of_type_Ufr == null)
    {
      this.jdField_a_of_type_Ufr = new ufr(this, 0);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Ufr.a(localViewStub);
      paramView.addView(localViewStub);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(new ucu(this));
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((ulv)this.jdField_a_of_type_Ucm).a(paramWSSimpleBaseEvent);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    ((ulv)b()).a(false, false);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    if (!this.h) {
      this.h = true;
    }
    ((ulv)b()).a(false, true);
  }
  
  public void a(List<stFeed> paramList)
  {
    e();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_Ucr != null) {
      this.jdField_a_of_type_Ucr.a(paramList);
    }
    ugl.a().a(paramList);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, true);
    }
  }
  
  public void a(List<stFeed> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Ucr.b(paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(true, paramBoolean);
      return;
    }
  }
  
  public void a(uiu paramuiu)
  {
    if ((this.d) && (a(paramuiu)))
    {
      uqf.c("WSFollowContinuePlayLog", "[WSFollowFragment.java][onPlayFirstVideo] playVideo title:" + paramuiu.jdField_a_of_type_Uld.d + ", mPlayingHolder:" + paramuiu);
      b(paramuiu);
      paramuiu = a(paramuiu, true, true);
      uqf.a("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onPlayFirstVideo] setPrePlayingHolder prePlayHolder:" + paramuiu);
      this.jdField_a_of_type_Ucr.b(paramuiu);
    }
  }
  
  public void a(uiu paramuiu, String paramString1, String paramString2)
  {
    ukz localukz = ugl.a().a();
    if (localukz == null) {}
    while ((paramuiu == null) || (localukz.jdField_a_of_type_Ulc == null) || (localukz.jdField_a_of_type_AndroidViewView == null) || (paramuiu.jdField_a_of_type_Ukz == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null)) {
      return;
    }
    paramuiu.jdField_a_of_type_Ukz.jdField_a_of_type_Ulc = localukz.jdField_a_of_type_Ulc;
    paramuiu.jdField_a_of_type_Ukz.jdField_a_of_type_AndroidViewView = localukz.jdField_a_of_type_AndroidViewView;
    paramuiu.jdField_a_of_type_Ukz.jdField_a_of_type_Ulm = localukz.jdField_a_of_type_Ulm;
    paramuiu.jdField_a_of_type_Ukz.jdField_a_of_type_Ulc.c(true);
    this.jdField_a_of_type_Ucr.a = paramuiu;
    uvv.a(paramString1, paramString2, paramuiu.jdField_a_of_type_Ukz, false);
    uns.a(paramuiu.jdField_a_of_type_Ukz);
    paramString1 = a(paramuiu, true, true);
    this.jdField_a_of_type_Ucr.b(paramString1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramuiu.jdField_a_of_type_Ukz, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_Ucr.a());
    uqf.a("WSFollowContinuePlayLog", "WSFollowFragment handleOnActivityResultFromVertical()2, title: " + paramuiu.jdField_a_of_type_Ukz.jdField_a_of_type_Uld.d + ", playingHolder: " + paramuiu);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_Ucr != null) && (this.jdField_a_of_type_Ucr.a().size() == 0)) {
      l();
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
      uqt.d("focus");
    }
  }
  
  public void b(List<stFeed> paramList)
  {
    this.g = true;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.isShown()) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Ucr.a(paramList);
    b(true, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_a_of_type_Ucr.a(View.inflate(getActivity(), 2131560388, null));
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.d = paramBoolean;
  }
  
  public boolean c()
  {
    return (a() != null) && (a().showMute);
  }
  
  public void d()
  {
    ((ulv)b()).a(true, false);
  }
  
  public boolean d()
  {
    return (!this.k) && (c());
  }
  
  public void f()
  {
    this.k = true;
    upw.a();
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
    localArrayList.add(WSPlayerMuteEvent.class);
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
      uqf.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical position:" + paramInt1);
      ThreadManager.getUIHandler().postDelayed(new WSFollowFragment.3(this, str, paramIntent), 100L);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Ufr != null) {
      return this.jdField_a_of_type_Ufr.b();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.k = upw.b();
    uqf.a("weishi-beacon", "进入瀑布流的时间：" + this.jdField_a_of_type_Long);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    i();
    uep.a().a(this.jdField_a_of_type_Ucr.a());
    uhf.a().b(this);
    ujq.a().a();
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
      ukq.a().a(false);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (!c)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ukq localukq;
    if (this.jdField_a_of_type_Boolean)
    {
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
      localukq = ukq.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.i()) {
        break label121;
      }
    }
    label121:
    for (boolean bool = true;; bool = false)
    {
      localukq.a(bool);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e();
      }
      if (this.jdField_a_of_type_Long > 0L)
      {
        long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long = 0L;
        uqf.a("weishi-beacon", "关注页初始化耗时：" + l);
        uoc.a().a(true, l, "focus", "focus");
      }
      return;
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    uqf.b("WSFollowFragment", "setUserVisibleHint entered! visible: " + paramBoolean + ", isResumed: " + isResumed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment
 * JD-Core Version:    0.7.0.1
 */