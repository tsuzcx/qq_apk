package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;

public class GdtAdWSVerticalItemWidgetAreaController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private GdtAdWSVerticalItemWidgetButtonController g;
  private ViewStub h;
  private WSVerticalVideoHolder i;
  
  public GdtAdWSVerticalItemWidgetAreaController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.i = paramWSVerticalVideoHolder;
  }
  
  private void b(WSVerticalItemData paramWSVerticalItemData)
  {
    if ((l() != null) && (l().new_icon != null) && (l().new_icon.tag_type == 0))
    {
      if (this.g == null)
      {
        this.g = new GdtAdWSVerticalItemWidgetButtonController(this.a, this.i);
        this.g.a(this.h);
      }
      this.g.a(paramWSVerticalItemData);
    }
  }
  
  private stSimpleMetaFeed l()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))) {
      return localWSVerticalItemData.b();
    }
    return null;
  }
  
  protected void a() {}
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    b(paramWSVerticalItemData);
  }
  
  protected void b() {}
  
  protected void f()
  {
    GdtAdWSVerticalItemWidgetButtonController localGdtAdWSVerticalItemWidgetButtonController = this.g;
    if (localGdtAdWSVerticalItemWidgetButtonController != null) {
      localGdtAdWSVerticalItemWidgetButtonController.f();
    }
  }
  
  protected int i()
  {
    return 2131626094;
  }
  
  protected void j()
  {
    this.h = ((ViewStub)c(2131449426));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemWidgetAreaController
 * JD-Core Version:    0.7.0.1
 */