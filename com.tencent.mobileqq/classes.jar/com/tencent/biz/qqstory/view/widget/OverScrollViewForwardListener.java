package com.tencent.biz.qqstory.view.widget;

import android.view.View;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class OverScrollViewForwardListener
  implements OverScrollViewListener
{
  private CopyOnWriteArraySet<OverScrollViewListener> a = new CopyOnWriteArraySet();
  
  public OverScrollViewForwardListener(OverScrollViewListener paramOverScrollViewListener)
  {
    if (paramOverScrollViewListener != null) {
      this.a.add(paramOverScrollViewListener);
    }
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((OverScrollViewListener)localIterator.next()).onNotCompleteVisable(paramInt, paramView, paramListView);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((OverScrollViewListener)localIterator.next()).onViewCompleteVisable(paramInt, paramView, paramListView);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    for (boolean bool = false;; bool = true)
    {
      if (!localIterator.hasNext()) {
        break label58;
      }
      OverScrollViewListener localOverScrollViewListener = (OverScrollViewListener)localIterator.next();
      if ((!bool) && (!localOverScrollViewListener.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView))) {
        break;
      }
    }
    label58:
    return bool;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((OverScrollViewListener)localIterator.next()).onViewNotCompleteVisableAndReleased(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.OverScrollViewForwardListener
 * JD-Core Version:    0.7.0.1
 */