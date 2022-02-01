package com.tencent.biz.qqcircle.fragments.content;

import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ImmersiveEventHelper
{
  private final HashMap<View, Integer> a = new HashMap();
  private boolean b = false;
  
  private void b()
  {
    if (this.b)
    {
      d();
      return;
    }
    c();
  }
  
  private void c()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView != null)
      {
        this.a.put(localView, Integer.valueOf(localView.getVisibility()));
        localView.setVisibility(8);
      }
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if ((localView != null) && (this.a.get(localView) != null)) {
        localView.setVisibility(((Integer)this.a.get(localView)).intValue());
      }
    }
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        if (!this.b)
        {
          c();
          this.b = true;
        }
      }
      else if (this.b)
      {
        d();
        this.b = false;
      }
    }
    else
    {
      b();
      this.b ^= true;
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.a.put(paramView, Integer.valueOf(paramView.getVisibility()));
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      HashMap localHashMap = this.a;
      if (localHashMap == null) {
        return;
      }
      localHashMap.put(paramView, Integer.valueOf(paramInt));
    }
  }
  
  public void a(QCircleContentImmersiveEvent paramQCircleContentImmersiveEvent)
  {
    a(paramQCircleContentImmersiveEvent.getState());
  }
  
  public void b(View paramView)
  {
    if (paramView != null)
    {
      HashMap localHashMap = this.a;
      if (localHashMap == null) {
        return;
      }
      localHashMap.remove(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.ImmersiveEventHelper
 * JD-Core Version:    0.7.0.1
 */