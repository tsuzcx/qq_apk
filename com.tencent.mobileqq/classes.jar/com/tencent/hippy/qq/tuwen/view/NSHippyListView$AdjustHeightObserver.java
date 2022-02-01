package com.tencent.hippy.qq.tuwen.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.AdapterDataObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class NSHippyListView$AdjustHeightObserver
  extends RecyclerViewBase.AdapterDataObserver
{
  private final Handler handler = new Handler(Looper.getMainLooper());
  private HippyRootLayout hippyRootLayout;
  private int maxHeight;
  private final Runnable runnable = new NSHippyListView.AdjustHeightRunnable(this);
  
  private NSHippyListView$AdjustHeightObserver(NSHippyListView paramNSHippyListView) {}
  
  private void adjustHeight()
  {
    findHippyRootLayout();
    if (this.hippyRootLayout == null)
    {
      QLog.d("NSHippyListView", 1, "hippyRootLayout is null");
      return;
    }
    ensureParentHeight();
    if (this.maxHeight <= 0)
    {
      QLog.d("NSHippyListView", 1, "maxHeight=" + this.maxHeight + ", require >=0");
      return;
    }
    this.handler.removeCallbacks(this.runnable);
    this.handler.post(this.runnable);
  }
  
  private void ensureParentHeight()
  {
    if (this.maxHeight == 0)
    {
      View localView = (View)this.hippyRootLayout.getParent();
      if (localView != null) {
        this.maxHeight = localView.getHeight();
      }
    }
    else
    {
      return;
    }
    this.maxHeight = this.hippyRootLayout.getMaxHeight();
  }
  
  private void findHippyRootLayout()
  {
    if (this.hippyRootLayout != null) {}
    for (;;)
    {
      return;
      for (ViewParent localViewParent = this.this$0.getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
        if ((localViewParent instanceof HippyRootLayout))
        {
          this.hippyRootLayout = ((HippyRootLayout)localViewParent);
          return;
        }
      }
    }
  }
  
  void doAdjustHeight()
  {
    HippyTKDListViewAdapter localHippyTKDListViewAdapter = (HippyTKDListViewAdapter)this.this$0.getAdapter();
    if (localHippyTKDListViewAdapter == null) {
      QLog.d("NSHippyListView", 1, "adapter is null");
    }
    do
    {
      return;
      i = localHippyTKDListViewAdapter.getItemCount();
      QLog.d("NSHippyListView", 1, "adapter item count=" + i);
    } while (i <= 0);
    int j = localHippyTKDListViewAdapter.getListTotalHeight();
    QLog.d("NSHippyListView", 1, "itemsHeight = " + j);
    int i = j;
    if (j >= this.maxHeight) {
      i = this.maxHeight;
    }
    this.hippyRootLayout.setLoadedHeight(i);
  }
  
  public void onChanged()
  {
    adjustHeight();
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    adjustHeight();
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    adjustHeight();
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    adjustHeight();
  }
  
  public void onItemsRemoved(ArrayList<Integer> paramArrayList)
  {
    adjustHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.view.NSHippyListView.AdjustHeightObserver
 * JD-Core Version:    0.7.0.1
 */