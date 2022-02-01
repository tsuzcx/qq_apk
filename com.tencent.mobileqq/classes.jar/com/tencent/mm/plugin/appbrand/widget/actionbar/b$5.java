package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.Set;

class b$5
  implements View.OnClickListener
{
  private long b = 0L;
  
  b$5(b paramb) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.b < 250L)
    {
      Iterator localIterator = b.b(this.a).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).a(this.a);
      }
      this.b = 0L;
    }
    this.b = System.currentTimeMillis();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.5
 * JD-Core Version:    0.7.0.1
 */