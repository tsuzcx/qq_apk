package com.tencent.hippy.qq.view.viola.list;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.hippy.views.list.HippyListAdapter.OnEndReachedEvent;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;

public class TkdListViewAdapter
  extends HippyListAdapter
{
  public TkdListViewAdapter(RecyclerView paramRecyclerView, HippyEngineContext paramHippyEngineContext)
  {
    super(paramRecyclerView, paramHippyEngineContext);
  }
  
  public void notifyEndReached()
  {
    if ((this.mParentRecyclerView instanceof TkdListView))
    {
      TkdListView localTkdListView = (TkdListView)this.mParentRecyclerView;
      if ((!localTkdListView.isLoading()) && (localTkdListView.shouldEmitEndReachedEvent()))
      {
        getOnEndReachedEvent().send(this.mParentRecyclerView, null);
        localTkdListView.setIsLoading(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.viola.list.TkdListViewAdapter
 * JD-Core Version:    0.7.0.1
 */