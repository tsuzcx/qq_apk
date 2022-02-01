package com.tencent.biz.qqcircle.widgets.pick;

import android.util.SparseArray;
import android.view.View;

class AbsSpinner$RecycleBin
{
  private final SparseArray<View> b = new SparseArray();
  
  AbsSpinner$RecycleBin(AbsSpinner paramAbsSpinner) {}
  
  View a(int paramInt)
  {
    View localView = (View)this.b.get(paramInt);
    if (localView != null) {
      this.b.delete(paramInt);
    }
    return localView;
  }
  
  void a()
  {
    SparseArray localSparseArray = this.b;
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localSparseArray.valueAt(i);
      if (localView != null) {
        AbsSpinner.a(this.a, localView, true);
      }
      i += 1;
    }
    localSparseArray.clear();
  }
  
  public void a(int paramInt, View paramView)
  {
    this.b.put(paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.AbsSpinner.RecycleBin
 * JD-Core Version:    0.7.0.1
 */