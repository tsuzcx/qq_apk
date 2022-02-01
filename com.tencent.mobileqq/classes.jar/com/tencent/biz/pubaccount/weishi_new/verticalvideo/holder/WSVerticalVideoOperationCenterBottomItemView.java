package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSVerticalVideoOperationCenterBottomItemView
  extends AbsWSVideoItemView
{
  private AbsWsUIGroup<WSVerticalItemData> a;
  private AbsWsUIGroup<WSVerticalItemData> b;
  private WSVerticalItemData c;
  private int i;
  
  public WSVerticalVideoOperationCenterBottomItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449759);
    this.a = new WSVerticalItemTopController(this.g, this.e);
    this.a.a(localViewStub);
  }
  
  private void l()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449749);
    this.b = new WSVerticalItemCenterBottomController(this.g, this.f);
    this.b.a(localViewStub);
  }
  
  private void m()
  {
    if (this.h == null) {
      return;
    }
    this.h.setOnClickListener(new WSVerticalVideoOperationCenterBottomItemView.1(this));
  }
  
  public void a()
  {
    super.a();
    AbsWsUIGroup localAbsWsUIGroup = this.a;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.g();
    }
    localAbsWsUIGroup = this.b;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.g();
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.i = paramInt;
    AbsWsUIGroup localAbsWsUIGroup = this.a;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.b(paramInt);
    }
    localAbsWsUIGroup = this.b;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.b(paramInt);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    this.c = paramWSVerticalItemData;
    AbsWsUIGroup localAbsWsUIGroup = this.a;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(paramWSVerticalItemData);
    }
    localAbsWsUIGroup = this.b;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(paramWSVerticalItemData);
    }
  }
  
  public void b()
  {
    super.b();
    if ((this.e != null) && (!TextUtils.equals(this.e.k(), "aio_home_page"))) {
      f();
    }
    l();
    m();
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  public void c() {}
  
  public void d()
  {
    WSShareParam localWSShareParam = new WSShareParam();
    localWSShareParam.a = e();
    localWSShareParam.b = 3;
    localWSShareParam.c = this.i;
    localWSShareParam.d = WSVerticalBeaconReport.c(this.e.k());
    localWSShareParam.e = this.e.l();
    localWSShareParam.f = "more_operations";
    localWSShareParam.a(this.e);
    WeishiShareUtil.b(this.g, localWSShareParam);
    WSVerticalBeaconReport.a(this.e.k(), this.e.l(), e());
  }
  
  public void d(int paramInt) {}
  
  public stSimpleMetaFeed e()
  {
    WSVerticalItemData localWSVerticalItemData = this.c;
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))) {
      return this.c.b();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationCenterBottomItemView
 * JD-Core Version:    0.7.0.1
 */