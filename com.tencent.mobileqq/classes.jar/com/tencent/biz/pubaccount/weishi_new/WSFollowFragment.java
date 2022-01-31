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
import bhzz;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import tbb;
import tbc;
import tbd;
import tbe;
import tcq;
import tdn;
import tel;
import tff;
import tfi;
import tfk;
import tfr;
import tgd;
import tgg;
import thl;
import tho;
import thp;
import tih;
import tit;
import tjt;
import tlf;
import tlo;
import tlv;
import tnt;

public class WSFollowFragment
  extends WSBaseHomeFragment<tit, tih, List<stFeed>>
  implements tfi, tit
{
  public static boolean b;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private tbb jdField_a_of_type_Tbb;
  public tdn a;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  private tgd a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Tbb != null)
    {
      i = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      return null;
    }
    tgd localtgd;
    do
    {
      i += 1;
      if (i >= this.jdField_a_of_type_Tbb.a().size()) {
        break;
      }
      localtgd = c(i, paramBoolean);
    } while (localtgd == null);
    return localtgd;
    return null;
  }
  
  private boolean a(tgd paramtgd)
  {
    if (paramtgd == null) {}
    while (tlf.a(paramtgd.a()) < 50) {
      return false;
    }
    return true;
  }
  
  private tgd b(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt < 0) {
      return null;
    }
    tgd localtgd;
    do
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      localtgd = c(i, paramBoolean);
    } while (localtgd == null);
    return localtgd;
  }
  
  private tgd c(int paramInt, boolean paramBoolean)
  {
    Object localObject = (stFeed)this.jdField_a_of_type_Tbb.a().get(paramInt);
    if ((((stFeed)localObject).feed_type == 2) && (((stFeed)localObject).feed != null))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForLayoutPosition(paramInt);
      if ((localObject instanceof tgd))
      {
        localObject = (tgd)localObject;
        if ((a((tgd)localObject)) || (paramBoolean)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void c(tgd paramtgd)
  {
    this.jdField_a_of_type_Tbb.a(paramtgd);
    this.c = false;
  }
  
  private void e()
  {
    tff.a().a(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(tlv.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d(true);
    this.jdField_a_of_type_Tbb.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
  }
  
  private void g()
  {
    if (!this.e)
    {
      tjx.b = 2;
      return;
    }
    if ((!this.f) && (!this.g))
    {
      tjx.b = 3;
      return;
    }
    tjx.b = 1;
  }
  
  private void h()
  {
    int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
    if ((i < 0) || (j >= this.jdField_a_of_type_Tbb.a().size())) {
      return;
    }
    label37:
    RecyclerView.ViewHolder localViewHolder;
    if (i <= j)
    {
      localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(i);
      if (!(localViewHolder instanceof tfk)) {
        break label75;
      }
      ((tfk)localViewHolder).d();
    }
    for (;;)
    {
      i += 1;
      break label37;
      break;
      label75:
      if ((localViewHolder instanceof tfr)) {
        ((tfr)localViewHolder).a();
      }
    }
  }
  
  protected RecyclerView.LayoutManager a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new tbe(this.jdField_a_of_type_AndroidContentContext, 1, false);
    return this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  }
  
  protected bhzz a()
  {
    this.jdField_a_of_type_Tbb = new tbb(this);
    return this.jdField_a_of_type_Tbb;
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
    return localArrayList;
  }
  
  public tbb a()
  {
    return this.jdField_a_of_type_Tbb;
  }
  
  public tgd a(tgd paramtgd, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramtgd != null)
    {
      int i = paramtgd.getLayoutPosition();
      if (paramBoolean1) {
        return a(i + 1, paramBoolean2);
      }
      return b(i - 1, paramBoolean2);
    }
    return null;
  }
  
  @NonNull
  public tih a()
  {
    return new tih();
  }
  
  protected void a()
  {
    this.c = true;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder().append("onTabSelected: ");
    if (paramInt == 0) {}
    for (String str = "follow";; str = "recommend")
    {
      tlo.b("WSFollowFragment", str);
      if (paramInt == 0) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c()) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
      }
      return;
    }
    this.c = true;
    b(a(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition(), false));
    h();
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof tfk)) {
      ((tfk)localViewHolder).a(paramstSimpleMetaFeed);
    }
  }
  
  protected void a(Bundle paramBundle) {}
  
  protected void a(View paramView)
  {
    tcq.a().b(new tbc(this));
    f();
    e();
    paramView = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368481);
    if (this.jdField_a_of_type_Tdn == null)
    {
      this.jdField_a_of_type_Tdn = new tdn(this, 0);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Tdn.a(localViewStub);
      paramView.addView(localViewStub);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(new tbd(this));
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((tih)this.jdField_a_of_type_Taw).a(paramWSSimpleBaseEvent);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    ((tih)b()).a(false, false);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    if (!this.f) {
      this.f = true;
    }
    ((tih)b()).a(false, true);
  }
  
  public void a(List<stFeed> paramList)
  {
    d();
    if (this.jdField_a_of_type_Tbb != null) {
      this.jdField_a_of_type_Tbb.a(paramList);
    }
    tel.a().a(paramList);
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(true, true);
    }
  }
  
  public void a(List<stFeed> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Tbb.b(paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(true, paramBoolean);
      return;
    }
  }
  
  public void a(tgd paramtgd)
  {
    thl localthl = tel.a().a();
    if (localthl == null) {}
    while ((paramtgd == null) || (localthl.jdField_a_of_type_Tho == null) || (localthl.jdField_a_of_type_AndroidViewView == null) || (paramtgd.jdField_a_of_type_Thl == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null)) {
      return;
    }
    paramtgd.jdField_a_of_type_Thl.jdField_a_of_type_Tho = localthl.jdField_a_of_type_Tho;
    paramtgd.jdField_a_of_type_Thl.jdField_a_of_type_AndroidViewView = localthl.jdField_a_of_type_AndroidViewView;
    paramtgd.jdField_a_of_type_Thl.jdField_a_of_type_Thy = localthl.jdField_a_of_type_Thy;
    paramtgd.jdField_a_of_type_Thl.jdField_a_of_type_Tho.c(true);
    this.jdField_a_of_type_Tbb.a = paramtgd;
    tnt.a(paramtgd.jdField_a_of_type_Thl, false);
    tjt.a(paramtgd.jdField_a_of_type_Thl);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramtgd.jdField_a_of_type_Thl, true);
    tlo.a("WSFollowContinuePlayLog", "WSFollowFragment handleOnActivityResultFromVertical()2, title: " + paramtgd.jdField_a_of_type_Thl.jdField_a_of_type_Thp.d + ", playingHolder: " + paramtgd);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_a_of_type_Tbb.a(View.inflate(getActivity(), 2131560222, null));
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean1, paramBoolean2);
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_Boolean) {
      tlv.c("focus");
    }
  }
  
  public void b(List<stFeed> paramList)
  {
    this.e = true;
    this.jdField_a_of_type_Tbb.a(paramList);
    a(true, true);
  }
  
  public void b(tgd paramtgd)
  {
    if ((this.c) && (a(paramtgd)))
    {
      paramtgd.jdField_a_of_type_Thl.jdField_a_of_type_AndroidViewView = null;
      tlo.c("WSFollowContinuePlayLog", "[WSFollowFragment.java][onPlayFirstVideo] playVideo title:" + paramtgd.jdField_a_of_type_Thp.d + ", mPlayingHolder:" + paramtgd);
      c(paramtgd);
      paramtgd = a(paramtgd, true, true);
      tlo.a("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onPlayFirstVideo] setPrePlayingHolder prePlayHolder:" + paramtgd);
      this.jdField_a_of_type_Tbb.b(paramtgd);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a(paramBoolean);
  }
  
  public void c()
  {
    ((tih)b()).a(true, false);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.d = true;
      paramInt1 = paramIntent.getIntExtra("key_feed_position", 0);
      tlo.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical position:" + paramInt1);
      ThreadManager.getUIHandler().postDelayed(new WSFollowFragment.3(this), 100L);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    g();
    tcq.a().a(this.jdField_a_of_type_Tbb.a());
    tff.a().b(this);
    tgg.a().a();
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (!b)) {
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
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    tlo.b("WSFollowFragment", "setUserVisibleHint entered! visible: " + paramBoolean + ", isResumed: " + isResumed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment
 * JD-Core Version:    0.7.0.1
 */