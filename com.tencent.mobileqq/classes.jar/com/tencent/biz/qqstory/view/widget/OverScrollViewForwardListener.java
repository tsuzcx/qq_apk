package com.tencent.biz.qqstory.view.widget;

import android.view.View;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class OverScrollViewForwardListener
  implements OverScrollViewListener
{
  private CopyOnWriteArraySet a = new CopyOnWriteArraySet();
  
  public OverScrollViewForwardListener(OverScrollViewListener paramOverScrollViewListener)
  {
    if (paramOverScrollViewListener != null) {
      this.a.add(paramOverScrollViewListener);
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((OverScrollViewListener)localIterator.next()).a(paramInt, paramView, paramListView);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      OverScrollViewListener localOverScrollViewListener = (OverScrollViewListener)localIterator.next();
      if ((bool) || (localOverScrollViewListener.a(paramInt, paramView, paramListView))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((OverScrollViewListener)localIterator.next()).b(paramInt, paramView, paramListView);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((OverScrollViewListener)localIterator.next()).c(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.OverScrollViewForwardListener
 * JD-Core Version:    0.7.0.1
 */