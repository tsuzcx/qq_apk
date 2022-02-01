package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentHeaderSubscribe$1
  implements View.OnClickListener
{
  ComponentHeaderSubscribe$1(ComponentHeaderSubscribe paramComponentHeaderSubscribe) {}
  
  public void onClick(View paramView)
  {
    ComponentHeaderSubscribe.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSubscribe.1
 * JD-Core Version:    0.7.0.1
 */