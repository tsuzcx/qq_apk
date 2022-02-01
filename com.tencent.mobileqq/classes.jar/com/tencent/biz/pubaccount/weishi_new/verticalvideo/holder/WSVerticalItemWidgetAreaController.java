package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.Context;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalItemWidgetAreaController
  extends AbsWsVerticalUIGroup
{
  private WSVerticalItemWidgetController g;
  private ViewStub h;
  private final WSVerticalVideoHolder i;
  
  public WSVerticalItemWidgetAreaController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.i = paramWSVerticalVideoHolder;
  }
  
  private void b(WSVerticalItemData paramWSVerticalItemData)
  {
    if (this.g == null)
    {
      this.g = new WSVerticalItemWidgetController(this.a, this.i);
      this.g.a(this.h);
    }
    this.g.a(paramWSVerticalItemData);
  }
  
  protected void a() {}
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    b(paramWSVerticalItemData);
  }
  
  protected void b() {}
  
  public void d(int paramInt)
  {
    WSVerticalItemWidgetController localWSVerticalItemWidgetController = this.g;
    if (localWSVerticalItemWidgetController != null) {
      localWSVerticalItemWidgetController.d(paramInt);
    }
  }
  
  protected void e(int paramInt)
  {
    WSVerticalItemWidgetController localWSVerticalItemWidgetController = this.g;
    if (localWSVerticalItemWidgetController != null) {
      localWSVerticalItemWidgetController.e(paramInt);
    }
  }
  
  protected void f()
  {
    WSVerticalItemWidgetController localWSVerticalItemWidgetController = this.g;
    if (localWSVerticalItemWidgetController != null) {
      localWSVerticalItemWidgetController.g();
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetAreaController
 * JD-Core Version:    0.7.0.1
 */