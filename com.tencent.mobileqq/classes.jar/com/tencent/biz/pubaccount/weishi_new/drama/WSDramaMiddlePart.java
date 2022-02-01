package com.tencent.biz.pubaccount.weishi_new.drama;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.Checkable;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsSingleCheckAdapter;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSCenterLayoutManager;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeAdapter;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.drama.gallery.WSDramaGalleryAdapter;
import com.tencent.biz.pubaccount.weishi_new.drama.gallery.WSDramaGalleryItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.part.WSAbsPart;
import com.tencent.biz.pubaccount.weishi_new.drama.presenter.WSDramaEpisodePresenter;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class WSDramaMiddlePart
  extends WSAbsPart
  implements WSDramaEpisodeContract.View, WSSimpleEventReceiver
{
  public static final int a = WeishiUIUtil.c() / 2 - ScreenUtil.dip2px(51.5F) / 2;
  private final WSDramaPageFragment e;
  private final WSDramaEpisodePresenter f;
  private DiniFlyAnimationView g;
  private TextView h;
  private RecyclerView i;
  private RecyclerView j;
  private WSEpisodeAdapter k;
  private WSDramaGalleryAdapter l;
  private WSDramaMiddlePart.OnDramaDataListener m;
  private Bundle n;
  private String o;
  private String p;
  private int q = -1;
  private boolean r = true;
  
  public WSDramaMiddlePart(WSDramaPageFragment paramWSDramaPageFragment, ViewStub paramViewStub)
  {
    super(paramWSDramaPageFragment.getContext(), paramViewStub);
    this.e = paramWSDramaPageFragment;
    this.f = new WSDramaEpisodePresenter(this);
  }
  
  public static WSDramaMiddlePart a(WSDramaPageFragment paramWSDramaPageFragment, ViewStub paramViewStub, Bundle paramBundle)
  {
    paramWSDramaPageFragment = new WSDramaMiddlePart(paramWSDramaPageFragment, paramViewStub);
    paramWSDramaPageFragment.a(paramBundle);
    return paramWSDramaPageFragment;
  }
  
  private <M extends Checkable, VH extends BaseViewHolder<M>> void a(RecyclerView paramRecyclerView, WSAbsSingleCheckAdapter<M, VH> paramWSAbsSingleCheckAdapter, RecyclerView.ItemDecoration paramItemDecoration, int paramInt)
  {
    paramRecyclerView.setAdapter(paramWSAbsSingleCheckAdapter);
    paramRecyclerView.addItemDecoration(paramItemDecoration);
    paramItemDecoration = new WSCenterLayoutManager(this.b, paramInt);
    paramItemDecoration.setOrientation(0);
    paramRecyclerView.setLayoutManager(paramItemDecoration);
    paramWSAbsSingleCheckAdapter.a(paramItemDecoration);
  }
  
  private void a(WSDramaItemData paramWSDramaItemData, int paramInt)
  {
    this.o = paramWSDramaItemData.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSDramaMiddlePart.java][dramaChecked] mDramaId:");
    ((StringBuilder)localObject).append(this.o);
    WSLog.d("WSDramaMiddlePartnel-log", ((StringBuilder)localObject).toString());
    localObject = this.m;
    if (localObject != null) {
      ((WSDramaMiddlePart.OnDramaDataListener)localObject).a(paramWSDramaItemData, paramInt);
    }
  }
  
  private void a(WSEpisodeItemData paramWSEpisodeItemData, int paramInt)
  {
    WSDramaMiddlePart.OnDramaDataListener localOnDramaDataListener = this.m;
    if (localOnDramaDataListener != null) {
      localOnDramaDataListener.a(paramWSEpisodeItemData, paramInt);
    }
  }
  
  private void a(WSDramaFollowEvent paramWSDramaFollowEvent)
  {
    Object localObject1 = this.l;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((WSDramaGalleryAdapter)localObject1).getDataList();
    int i1 = 0;
    while (i1 < ((List)localObject1).size())
    {
      Object localObject2 = (WSDramaItemData)((List)localObject1).get(i1);
      if ((localObject2 != null) && (TextUtils.equals(((WSDramaItemData)localObject2).b(), paramWSDramaFollowEvent.getDramaId())))
      {
        localObject2 = ((WSDramaItemData)localObject2).f().dramaInfo;
        int i2 = paramWSDramaFollowEvent.getStatus();
        boolean bool = true;
        if (i2 != 1) {
          bool = false;
        }
        ((stDramaInfo)localObject2).isFollowed = bool;
      }
      i1 += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    this.j.getLayoutManager().smoothScrollToPosition(this.j, new RecyclerView.State(), paramInt1);
    this.h.setText(paramString);
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaMiddlePart.java][loadDramaData] dramaId:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", episodeId:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", episodeNum:");
    localStringBuilder.append(paramInt);
    WSLog.a("WSDramaMiddlePartnel-log", localStringBuilder.toString());
    a(paramString1);
    a(paramBoolean, paramString2, paramInt);
  }
  
  private void b(int paramInt)
  {
    if (paramInt >= this.k.getItemCount()) {
      return;
    }
    this.k.a(paramInt);
    ((WSCenterLayoutManager)this.i.getLayoutManager()).scrollToPositionWithOffset(Math.max(0, paramInt), a);
    c(0);
    WSDramaBeaconReport.a((WSEpisodeItemData)this.k.getItem(paramInt), i(), k());
    u();
  }
  
  private void b(String paramString)
  {
    WSDramaUtils.a(this.e, l(), q(), paramString);
  }
  
  private void c(int paramInt)
  {
    this.q = paramInt;
  }
  
  private void p()
  {
    this.g.setRepeatCount(-1);
    this.g.setRepeatMode(1);
    this.g.setAnimation("wsdrama_enter/data.json");
    this.g.setImageAssetsFolder("wsdrama_enter/images");
    this.g.setOnClickListener(new WSDramaMiddlePart.1(this));
  }
  
  private String q()
  {
    Object localObject = this.k;
    localObject = (WSEpisodeItemData)((WSEpisodeAdapter)localObject).getItem(((WSEpisodeAdapter)localObject).b());
    if (localObject != null) {
      return ((WSEpisodeItemData)localObject).b();
    }
    return "";
  }
  
  private void r()
  {
    Bundle localBundle = a();
    if (localBundle == null) {
      return;
    }
    this.o = localBundle.getString("drama_id");
    this.p = localBundle.getString("from");
  }
  
  private void s()
  {
    this.k = new WSEpisodeAdapter(this.b, this.i);
    a(this.i, this.k, new WSEpisodeItemDecoration(), WSEpisodeItemDecoration.a);
    this.k.a(new WSDramaMiddlePart.2(this));
  }
  
  private void t()
  {
    this.l = new WSDramaGalleryAdapter(this, this.j);
    a(this.j, this.l, new WSDramaGalleryItemDecoration(), WSDramaGalleryItemDecoration.b);
    this.l.a(new WSDramaMiddlePart.3(this));
  }
  
  private void u()
  {
    c(-1);
  }
  
  private void v()
  {
    c(0);
    int i1 = this.l.b() + 1;
    if (i1 > this.l.getItemCount() - 1) {
      return;
    }
    a((WSDramaItemData)this.l.getItem(i1), i1);
  }
  
  private WSDramaEpisodePresenter w()
  {
    return this.f;
  }
  
  public Bundle a()
  {
    return this.n;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(stDramaFeed paramstDramaFeed)
  {
    WSDramaMiddlePart.OnDramaDataListener localOnDramaDataListener = this.m;
    if (localOnDramaDataListener != null) {
      localOnDramaDataListener.a(paramstDramaFeed);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.n = paramBundle;
  }
  
  public void a(WSDramaMiddlePart.OnDramaDataListener paramOnDramaDataListener)
  {
    this.m = paramOnDramaDataListener;
  }
  
  public void a(AbsWSDramaHolder paramAbsWSDramaHolder, int paramInt)
  {
    if ((i() != 0) && (i() != 1)) {
      c(2);
    }
    paramAbsWSDramaHolder = paramAbsWSDramaHolder.c;
    this.o = paramAbsWSDramaHolder.b();
    int i1 = paramAbsWSDramaHolder.f().dramaInfo.curWatchedFeedNum;
    Object localObject = this.k;
    int i2 = i1 - 1;
    localObject = (WSEpisodeItemData)((WSEpisodeAdapter)localObject).getItem(Math.max(0, i2));
    if (!this.r)
    {
      WSDramaBeaconReport.a((WSEpisodeItemData)localObject, this.k.c(), this.k.d(), k());
      WSDramaBeaconReport.a((WSEpisodeItemData)localObject, i(), k());
      WSDramaBeaconReport.a(paramAbsWSDramaHolder, paramInt, i(), false, k());
    }
    u();
    this.r = false;
    this.l.a(paramInt);
    a(false, paramAbsWSDramaHolder.b(), paramAbsWSDramaHolder.f().dramaInfo.curWatchedFeedID, i1);
    a(paramAbsWSDramaHolder.f().dramaInfo.name, paramInt, Math.max(0, i2));
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof WSDramaVideoExposureEvent))
    {
      b(((WSDramaVideoExposureEvent)paramWSSimpleBaseEvent).getCurrentEpisodeNum() - 1);
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof WSDramaFollowEvent)) {
      a((WSDramaFollowEvent)paramWSSimpleBaseEvent);
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaMiddlePart.java][loadDramaFeedIds] dramaId:");
    localStringBuilder.append(paramString);
    WSLog.a("WSDramaMiddlePartnel-log", localStringBuilder.toString());
    this.o = paramString;
    w().a();
  }
  
  public void a(List<WSDramaItemData> paramList)
  {
    this.g.setVisibility(0);
    this.g.playAnimation();
    this.l.fillList(paramList);
  }
  
  public void a(List<WSEpisodeItemData> paramList, stDramaInfo paramstDramaInfo)
  {
    this.k.fillList(paramList);
    if (paramstDramaInfo != null) {
      paramList = paramstDramaInfo.name;
    } else {
      paramList = "";
    }
    this.h.setText(paramList);
    int i1 = paramstDramaInfo.curWatchedFeedNum;
    this.i.post(new WSDramaMiddlePart.4(this, i1 - 1));
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaMiddlePart.java][loadDramaFeeds] episodeId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", episodeNum:");
    localStringBuilder.append(paramInt);
    WSLog.a("WSDramaMiddlePartnel-log", localStringBuilder.toString());
    w().a(paramBoolean, paramString, paramInt);
  }
  
  protected int b()
  {
    return 2131626056;
  }
  
  public void b(stDramaFeed paramstDramaFeed)
  {
    WSDramaMiddlePart.OnDramaDataListener localOnDramaDataListener = this.m;
    if (localOnDramaDataListener != null) {
      localOnDramaDataListener.b(paramstDramaFeed);
    }
  }
  
  public void c()
  {
    super.c();
    r();
    g();
    t();
    s();
    p();
    WSSimpleEventBus.a().a(this);
  }
  
  public void d()
  {
    super.d();
    WSSimpleEventBus.a().b(this);
    WSEpisodeAdapter localWSEpisodeAdapter = this.k;
    WSDramaBeaconReport.a((WSEpisodeItemData)localWSEpisodeAdapter.getItem(localWSEpisodeAdapter.b()), this.k.c(), this.k.d(), k());
  }
  
  public void e()
  {
    super.e();
    if (this.g.getVisibility() == 0) {
      this.g.playAnimation();
    }
  }
  
  public void f()
  {
    super.f();
    this.g.clearAnimation();
  }
  
  protected void g()
  {
    this.g = ((DiniFlyAnimationView)a(2131432166));
    this.h = ((TextView)a(2131432173));
    this.i = ((RecyclerView)a(2131432167));
    this.j = ((RecyclerView)a(2131432165));
  }
  
  public void h()
  {
    int i1 = this.k.b() + 1;
    if (i1 > this.k.getItemCount() - 1)
    {
      v();
      return;
    }
    WSEpisodeItemData localWSEpisodeItemData = (WSEpisodeItemData)this.k.getItem(i1);
    b(i1);
    a(false, localWSEpisodeItemData.b(), i1 + 1);
  }
  
  public int i()
  {
    return this.q;
  }
  
  public void j()
  {
    int i1 = this.k.b() + 1;
    if (i1 >= this.k.getItemCount()) {
      return;
    }
    WSEpisodeItemData localWSEpisodeItemData = (WSEpisodeItemData)this.k.getItem(i1);
    w().a(localWSEpisodeItemData.b(), localWSEpisodeItemData.c());
  }
  
  public String k()
  {
    return this.p;
  }
  
  public String l()
  {
    return this.o;
  }
  
  public ArrayList<Class> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSDramaVideoExposureEvent.class);
    localArrayList.add(WSDramaFollowEvent.class);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaMiddlePart
 * JD-Core Version:    0.7.0.1
 */