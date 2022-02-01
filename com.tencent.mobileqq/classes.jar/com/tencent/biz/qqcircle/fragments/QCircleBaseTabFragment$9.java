package com.tencent.biz.qqcircle.fragments;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.recyclerview.widget.RecyclerView;

class QCircleBaseTabFragment$9
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QCircleBaseTabFragment$9(QCircleBaseTabFragment paramQCircleBaseTabFragment, RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onGlobalLayout()
  {
    if (this.a.getChildCount() > 0)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      } else {
        this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
      this.d.a(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment.9
 * JD-Core Version:    0.7.0.1
 */