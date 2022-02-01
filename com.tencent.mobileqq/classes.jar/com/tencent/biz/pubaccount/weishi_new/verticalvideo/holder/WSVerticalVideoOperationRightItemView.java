package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.guide.WSCommentAtHelper;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSVerticalVideoOperationRightItemView
  extends AbsWSVideoItemView
  implements View.OnClickListener
{
  private AbsWsUIGroup<WSVerticalItemData> a;
  private AbsWsUIGroup<WSVerticalItemData> b;
  private AbsWsUIGroup<WSVerticalItemData> c;
  private AbsWsUIGroup<WSVerticalItemData> i;
  private AbsWsUIGroup<WSVerticalItemData> j;
  private AbsWsUIGroup<WSVerticalItemData> k;
  private AbsWsUIGroup<WSVerticalItemData> l;
  private AbsWsUIGroup<WSVerticalItemData> m;
  private final Handler n = new Handler(Looper.getMainLooper());
  private GestureDetector o;
  private WSVerticalItemData p;
  private int q;
  private boolean r;
  
  public WSVerticalVideoOperationRightItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void A()
  {
    if (this.h == null) {
      return;
    }
    this.o = new GestureDetector(this.h.getContext(), new WSVerticalVideoOperationRightItemView.2(this));
    this.h.setOnTouchListener(new WSVerticalVideoOperationRightItemView.3(this));
  }
  
  private void B()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = l();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null))
    {
      ((WSVerticalItemAvatarAreaController)this.b).b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSVerticalVideoOperationRightItemView.java][updateFollowBtnUI] title:");
      localStringBuilder.append(localstSimpleMetaFeed.feed_desc);
      WSLog.e("WSVerticalVideoOperationRightItemView", localStringBuilder.toString());
    }
  }
  
  private void C()
  {
    if ((g() instanceof WSVerticalItemVideoAreaController)) {
      ((WSVerticalItemVideoAreaController)g()).n();
    }
  }
  
  private WSVerticalItemAtPopGuideController D()
  {
    AbsWsUIGroup localAbsWsUIGroup = this.m;
    if ((localAbsWsUIGroup instanceof WSVerticalItemAtPopGuideController)) {
      return (WSVerticalItemAtPopGuideController)localAbsWsUIGroup;
    }
    return null;
  }
  
  private void E()
  {
    Object localObject = D();
    if (localObject != null) {
      ((WSVerticalItemAtPopGuideController)localObject).m();
    }
    localObject = n();
    if (localObject != null) {
      ((WSVerticalItemBottomCommentController)localObject).l();
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.p;
    if ((localObject != null) && ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed)))
    {
      localObject = this.a;
      if ((localObject instanceof WSVerticalItemBottomOperationController)) {
        ((WSVerticalItemBottomOperationController)localObject).a(paramMotionEvent);
      }
    }
  }
  
  private void q()
  {
    if (!((WSVerticalPageContract.Presenter)this.e.aO_()).o()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449759);
    WSVerticalItemTopTextController localWSVerticalItemTopTextController = new WSVerticalItemTopTextController(this.g, this.f);
    localWSVerticalItemTopTextController.a(localViewStub);
    a(localWSVerticalItemTopTextController);
  }
  
  private void r()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449746);
    this.i = new WSVerticalItemBottomContentController(this.g, this.f);
    this.i.a(localViewStub);
    a(this.i);
  }
  
  private void s()
  {
    if (!((WSVerticalPageContract.Presenter)this.e.aO_()).r()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449748);
    this.k = new WSVerticalItemBottomCommentController(this.g, this);
    this.k.a(localViewStub);
    a(this.k);
  }
  
  private void t()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449762);
    this.l = new WSVerticalItemWidgetAreaController(this.g, this.f);
    this.l.a(localViewStub);
    a(this.l);
  }
  
  private void u()
  {
    int i1 = this.f.f();
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131427847);
    WSVerticalItemWidgetAdvBigCardController localWSVerticalItemWidgetAdvBigCardController = new WSVerticalItemWidgetAdvBigCardController(this.g, this.f, i1);
    localWSVerticalItemWidgetAdvBigCardController.a(localViewStub);
    localWSVerticalItemWidgetAdvBigCardController.a(new WSVerticalVideoOperationRightItemView.1(this));
    a(localWSVerticalItemWidgetAdvBigCardController);
  }
  
  private void v()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449758);
    WSVerticalItemTagController localWSVerticalItemTagController = new WSVerticalItemTagController(this.g, this.f);
    localWSVerticalItemTagController.a(localViewStub);
    a(localWSVerticalItemTagController);
  }
  
  private void w()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449756);
    this.a = new WSVerticalItemRightOperationController(this.g, this.f);
    this.a.a(localViewStub);
    a(this.a);
  }
  
  private void x()
  {
    if (!e()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449744);
    this.b = new WSVerticalItemAvatarAreaController(this.g, this.f);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void y()
  {
    if (!((WSVerticalPageContract.Presenter)this.e.aO_()).r()) {
      return;
    }
    if (this.m == null)
    {
      ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449743);
      this.m = new WSVerticalItemAtPopGuideController(this.g, this);
      this.m.a(localViewStub);
      a(this.m);
    }
  }
  
  private void z()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449745);
    this.c = WSVerticalPageBottomBarFactory.a(this.e, this.e.k(), this.f);
    this.c.a(localViewStub);
    a(this.c);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.q = paramInt;
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    this.p = paramWSVerticalItemData;
  }
  
  public void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    AbsWsUIGroup localAbsWsUIGroup = this.a;
    if ((localAbsWsUIGroup instanceof WSVerticalItemRightOperationController)) {
      ((WSVerticalItemRightOperationController)localAbsWsUIGroup).b(paramBoolean);
    }
    localAbsWsUIGroup = this.b;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i1);
    }
    localAbsWsUIGroup = this.i;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i1);
    }
    localAbsWsUIGroup = this.j;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i1);
    }
  }
  
  public void b()
  {
    super.b();
    r();
    s();
    w();
    t();
    v();
    x();
    f();
    z();
    q();
    u();
    A();
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    this.r = false;
  }
  
  public void b(WSVerticalItemData paramWSVerticalItemData)
  {
    this.p = paramWSVerticalItemData;
    c(paramWSVerticalItemData);
  }
  
  public void b(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    AbsWsUIGroup localAbsWsUIGroup = this.i;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i1);
    }
    localAbsWsUIGroup = this.j;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i1);
    }
    localAbsWsUIGroup = this.l;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(i1);
    }
  }
  
  public void c()
  {
    Object localObject = this.p;
    if ((localObject != null) && ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed)))
    {
      localObject = this.p.b();
      WSLikeAnimationManger.a().a(((stSimpleMetaFeed)localObject).id);
    }
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    E();
  }
  
  public void c(boolean paramBoolean)
  {
    AbsWsUIGroup localAbsWsUIGroup = this.a;
    if ((localAbsWsUIGroup instanceof WSVerticalItemRightOperationController)) {
      ((WSVerticalItemRightOperationController)localAbsWsUIGroup).a(paramBoolean);
    }
  }
  
  public void d()
  {
    WSShareParam localWSShareParam = new WSShareParam();
    localWSShareParam.a = l();
    localWSShareParam.b = 2;
    localWSShareParam.c = this.q;
    localWSShareParam.d = WSVerticalBeaconReport.c(this.e.k());
    localWSShareParam.e = this.e.l();
    localWSShareParam.f = "more_operations";
    localWSShareParam.a(this.e);
    WeishiShareUtil.a(this.g, localWSShareParam);
    WSVerticalBeaconReport.a(this.e.k(), this.e.l(), l());
  }
  
  public void d(int paramInt)
  {
    AbsWsUIGroup localAbsWsUIGroup;
    if (paramInt == 0)
    {
      localAbsWsUIGroup = this.a;
      if ((localAbsWsUIGroup instanceof WSVerticalItemBottomOperationController))
      {
        ((WSVerticalItemBottomOperationController)localAbsWsUIGroup).r();
        return;
      }
    }
    if ((paramInt == 1) && ((this.b instanceof WSVerticalItemAvatarAreaController)))
    {
      B();
      return;
    }
    if (paramInt == 2)
    {
      localAbsWsUIGroup = this.a;
      if ((localAbsWsUIGroup instanceof WSVerticalItemBottomOperationController))
      {
        ((WSVerticalItemBottomOperationController)localAbsWsUIGroup).s();
        return;
      }
    }
    if (paramInt == 3) {
      ((WSVerticalItemBottomOperationController)this.a).q();
    }
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449747);
    this.j = new WSVerticalItemBottomFlexibleController(this.g, this.f);
    this.j.a(localViewStub);
    a(this.j);
  }
  
  public stSimpleMetaFeed l()
  {
    WSVerticalItemData localWSVerticalItemData = this.p;
    if (localWSVerticalItemData != null) {
      return localWSVerticalItemData.b();
    }
    return null;
  }
  
  public AbsWsUIGroup<WSVerticalItemData> m()
  {
    return this.c;
  }
  
  public WSVerticalItemBottomCommentController n()
  {
    return (WSVerticalItemBottomCommentController)this.k;
  }
  
  public boolean o()
  {
    return this.r;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    E();
  }
  
  public void p()
  {
    this.r = true;
    y();
    Object localObject = D();
    if (localObject != null)
    {
      this.n.removeCallbacksAndMessages(null);
      ((WSVerticalItemAtPopGuideController)localObject).l();
      localObject = n();
      if (localObject != null)
      {
        ((WSVerticalItemBottomCommentController)localObject).a(new WSVerticalVideoOperationRightItemView.WSPAGViewListener(this));
        WSCommentAtHelper.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationRightItemView
 * JD-Core Version:    0.7.0.1
 */