package com.tencent.biz.richframework.part.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import java.util.ArrayList;
import zwp;
import zwr;
import zyl;

public class DemoBaseWidgetView
  extends BaseWidgetView
  implements zwr
{
  public DemoBaseWidgetView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(Context paramContext, View paramView)
  {
    VSNetworkHelper.a().a(getContext().hashCode(), new DemoBaseRequest(""), new zyl(this));
  }
  
  public void a(Object paramObject)
  {
    a();
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    zwp.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.demo.DemoBaseWidgetView
 * JD-Core Version:    0.7.0.1
 */