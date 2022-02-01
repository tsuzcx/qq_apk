package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSVerticalVideoItemView
  extends AbsWSVideoItemView
{
  private AbsWsUIGroup<WSVerticalItemData> a;
  private AbsWsUIGroup<WSVerticalItemData> b;
  private GestureDetector c;
  private WSVerticalItemData i;
  private int j;
  
  public WSVerticalVideoItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.i;
    if ((localObject != null) && ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed)))
    {
      localObject = this.b;
      if ((localObject instanceof WSVerticalItemBottomOperationController)) {
        ((WSVerticalItemBottomOperationController)localObject).a(paramMotionEvent);
      }
    }
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449759);
    this.a = new WSVerticalItemTopController(this.g, this.e);
    this.a.a(localViewStub);
    a(this.a);
  }
  
  private void l()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449746);
    WSVerticalItemBottomContentController localWSVerticalItemBottomContentController = new WSVerticalItemBottomContentController(this.g, this.f);
    localWSVerticalItemBottomContentController.a(localViewStub);
    a(localWSVerticalItemBottomContentController);
  }
  
  private void m()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449748);
    this.b = new WSVerticalItemBottomOperationController(this.g, this.f);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void n()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449762);
    WSVerticalItemWidgetAreaController localWSVerticalItemWidgetAreaController = new WSVerticalItemWidgetAreaController(this.g, this.f);
    localWSVerticalItemWidgetAreaController.a(localViewStub);
    a(localWSVerticalItemWidgetAreaController);
  }
  
  private void o()
  {
    if (this.h == null) {
      return;
    }
    this.c = new GestureDetector(this.h.getContext(), new WSVerticalVideoItemView.1(this));
    this.h.setOnTouchListener(new WSVerticalVideoItemView.2(this));
  }
  
  private void p()
  {
    if ((g() instanceof WSVerticalItemVideoAreaController)) {
      ((WSVerticalItemVideoAreaController)g()).n();
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.j = paramInt;
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    this.i = paramWSVerticalItemData;
  }
  
  public void b()
  {
    super.b();
    f();
    l();
    m();
    n();
    o();
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  public void b(WSVerticalItemData paramWSVerticalItemData)
  {
    this.i = paramWSVerticalItemData;
    c(paramWSVerticalItemData);
  }
  
  public void c()
  {
    Object localObject = this.i;
    if ((localObject != null) && ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed)))
    {
      localObject = this.i.b();
      WSLikeAnimationManger.a().a(((stSimpleMetaFeed)localObject).id);
    }
  }
  
  public void d()
  {
    WSShareParam localWSShareParam = new WSShareParam();
    localWSShareParam.a = e();
    localWSShareParam.b = 2;
    localWSShareParam.c = this.j;
    localWSShareParam.d = WSVerticalBeaconReport.c(this.e.k());
    localWSShareParam.e = this.e.l();
    localWSShareParam.f = "more_operations";
    localWSShareParam.a(this.e);
    WeishiShareUtil.a(this.g, localWSShareParam);
    WSVerticalBeaconReport.a(this.e.k(), this.e.l(), e());
  }
  
  public void d(int paramInt)
  {
    AbsWsUIGroup localAbsWsUIGroup;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        localAbsWsUIGroup = this.b;
        if ((localAbsWsUIGroup instanceof WSVerticalItemBottomOperationController)) {
          ((WSVerticalItemBottomOperationController)localAbsWsUIGroup).s();
        }
      }
      else
      {
        localAbsWsUIGroup = this.a;
        if ((localAbsWsUIGroup instanceof WSVerticalItemTopController)) {
          ((WSVerticalItemTopController)localAbsWsUIGroup).b();
        }
      }
    }
    else
    {
      localAbsWsUIGroup = this.b;
      if ((localAbsWsUIGroup instanceof WSVerticalItemBottomOperationController)) {
        ((WSVerticalItemBottomOperationController)localAbsWsUIGroup).r();
      }
    }
  }
  
  public stSimpleMetaFeed e()
  {
    WSVerticalItemData localWSVerticalItemData = this.i;
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))) {
      return this.i.b();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoItemView
 * JD-Core Version:    0.7.0.1
 */