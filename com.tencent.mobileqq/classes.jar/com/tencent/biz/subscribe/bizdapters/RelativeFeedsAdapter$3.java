package com.tencent.biz.subscribe.bizdapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;

class RelativeFeedsAdapter$3
  extends RecyclerView.OnScrollListener
{
  RelativeFeedsAdapter$3(RelativeFeedsAdapter paramRelativeFeedsAdapter) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    try
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if ((this.a.a instanceof StaggeredGridLayoutManager))
      {
        paramRecyclerView = (StaggeredGridLayoutManager)this.a.a;
        paramRecyclerView.computeVerticalScrollExtent(new RecyclerView.State());
        int[] arrayOfInt = new int[paramRecyclerView.getColumnCountForAccessibility(null, null)];
        paramRecyclerView.findFirstVisibleItemPositions(arrayOfInt);
        if ((this.a.b(arrayOfInt[0]) <= 0) && (!RelativeFeedsAdapter.b(this.a)))
        {
          RelativeFeedsAdapter.a(this.a, true);
          paramRecyclerView.invalidateSpanAssignments();
        }
        if (arrayOfInt[0] > 2)
        {
          RelativeFeedsAdapter.a(this.a, false);
          return;
        }
      }
    }
    catch (Exception paramRecyclerView)
    {
      paramRecyclerView.printStackTrace();
      QLog.e("RelativeFeedsAdapter", 1, "onScrollStateChanged error", paramRecyclerView);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.3
 * JD-Core Version:    0.7.0.1
 */