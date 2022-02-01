package com.tencent.hippy.qq.tuwen.view;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class NSHippyListView$AdjustHeightRunnable
  implements Runnable
{
  private final WeakReference<NSHippyListView.AdjustHeightObserver> observerWeakRef;
  
  public NSHippyListView$AdjustHeightRunnable(NSHippyListView.AdjustHeightObserver paramAdjustHeightObserver)
  {
    this.observerWeakRef = new WeakReference(paramAdjustHeightObserver);
  }
  
  public void run()
  {
    NSHippyListView.AdjustHeightObserver localAdjustHeightObserver = (NSHippyListView.AdjustHeightObserver)this.observerWeakRef.get();
    if (localAdjustHeightObserver != null)
    {
      localAdjustHeightObserver.doAdjustHeight();
      return;
    }
    QLog.d("NSHippyListView", 1, "AdjustHeightRunnable observerWeakRef is recycled");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.view.NSHippyListView.AdjustHeightRunnable
 * JD-Core Version:    0.7.0.1
 */