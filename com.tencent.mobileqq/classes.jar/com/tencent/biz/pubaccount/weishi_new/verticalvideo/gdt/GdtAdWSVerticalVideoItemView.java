package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewStub;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GdtAdWSVerticalVideoItemView
  extends AbsWSVideoItemView
{
  public static GdtAppReceiver c;
  public ArrayList<AdExposureChecker> a = new ArrayList();
  public AdExposureChecker.ExposureCallback b = null;
  private AbsWsUIGroup<WSVerticalItemData> i;
  private AbsWsUIGroup<WSVerticalItemData> j;
  private AbsWsUIGroup<WSVerticalItemData> k;
  private WSVerticalItemData l;
  private GestureDetector m;
  private int n;
  
  public GdtAdWSVerticalVideoItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void l()
  {
    if (!e()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449759);
    this.i = new GdtAdWSVerticalItemTopController(this.g, this.e);
    this.i.a(localViewStub);
  }
  
  private void m()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449746);
    this.j = new GdtAdWSVerticalItemBottomController(this.g, this.f);
    this.j.a(localViewStub);
  }
  
  private void n()
  {
    if (!e()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449762);
    this.k = new GdtAdWSVerticalItemWidgetAreaController(this.g, this.f);
    this.k.a(localViewStub);
  }
  
  private void o()
  {
    if (this.h == null) {
      return;
    }
    if (c == null)
    {
      c = new GdtAppReceiver();
      c.register(BaseApplicationImpl.getContext());
    }
    this.m = new GestureDetector(this.h.getContext(), new GdtAdWSVerticalVideoItemView.1(this));
    this.h.setOnTouchListener(new GdtAdWSVerticalVideoItemView.2(this));
  }
  
  private void p()
  {
    new GdtAdWSVerticalVideoItemView.3(this).run();
  }
  
  private void q()
  {
    Object localObject = this.l;
    if ((localObject != null) && (((WSVerticalItemData)localObject).b() != null) && (this.h != null) && (this.f != null) && (this.f.f != null))
    {
      if (this.l.e() == null) {
        return;
      }
      localObject = new GdtAd(GdtAdUtil.a(this.l.b()));
      if (this.b == null) {
        this.b = new GdtAdWSVerticalVideoItemView.4(this);
      }
      AdExposureChecker.onClick(this.h.getContext(), (Ad)localObject, new WeakReference(this.b));
      GdtAdUtil.a(this.h.getContext(), this.l.b(), c, this.f.f, false);
      this.l.e().isGdtAdclicked = true;
    }
  }
  
  public void a()
  {
    super.a();
    AbsWsUIGroup localAbsWsUIGroup = this.i;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.g();
    }
    localAbsWsUIGroup = this.j;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.g();
    }
    localAbsWsUIGroup = this.k;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.g();
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.n = paramInt;
    AbsWsUIGroup localAbsWsUIGroup = this.i;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.b(paramInt);
    }
    localAbsWsUIGroup = this.j;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.b(paramInt);
    }
    localAbsWsUIGroup = this.k;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.b(paramInt);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    this.l = paramWSVerticalItemData;
    AbsWsUIGroup localAbsWsUIGroup = this.i;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(paramWSVerticalItemData);
    }
    localAbsWsUIGroup = this.j;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(paramWSVerticalItemData);
    }
    localAbsWsUIGroup = this.k;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(paramWSVerticalItemData);
    }
  }
  
  public void b()
  {
    super.b();
    l();
    n();
    m();
    o();
  }
  
  public void b(int paramInt)
  {
    p();
  }
  
  public void c()
  {
    Object localObject = this.l;
    if ((localObject != null) && ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed)))
    {
      localObject = this.l.b();
      WSLikeAnimationManger.a().a(((stSimpleMetaFeed)localObject).id);
    }
  }
  
  public void d()
  {
    WSShareParam localWSShareParam = new WSShareParam();
    localWSShareParam.a = f();
    localWSShareParam.b = 2;
    localWSShareParam.c = this.n;
    localWSShareParam.d = WSVerticalBeaconReport.c(this.e.k());
    localWSShareParam.e = this.e.l();
    localWSShareParam.f = "more_operations";
    localWSShareParam.a(this.e);
    WeishiShareUtil.a(this.g, localWSShareParam);
  }
  
  public void d(int paramInt) {}
  
  public boolean e()
  {
    return true;
  }
  
  public stSimpleMetaFeed f()
  {
    WSVerticalItemData localWSVerticalItemData = this.l;
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))) {
      return this.l.b();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalVideoItemView
 * JD-Core Version:    0.7.0.1
 */