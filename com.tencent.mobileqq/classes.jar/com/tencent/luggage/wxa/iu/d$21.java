package com.tencent.luggage.wxa.iu;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class d$21
  implements ViewGroup.OnHierarchyChangeListener
{
  d$21(d paramd, View paramView) {}
  
  public void onChildViewAdded(View paramView1, View paramView2)
  {
    EventCollector.getInstance().onChildViewAdded(paramView1, paramView2);
  }
  
  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    EventCollector.getInstance().onChildViewRemoved(paramView1, paramView2);
    if ((paramView2 == this.a) && (!this.b.au()))
    {
      paramView1 = new d.21.1(this);
      this.b.ar();
      if (this.b.C() == null)
      {
        this.b.c(paramView1);
        return;
      }
      paramView1.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.21
 * JD-Core Version:    0.7.0.1
 */