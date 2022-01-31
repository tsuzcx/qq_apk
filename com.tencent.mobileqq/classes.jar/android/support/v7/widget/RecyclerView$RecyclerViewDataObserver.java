package android.support.v7.widget;

import android.support.v4.view.ViewCompat;

class RecyclerView$RecyclerViewDataObserver
  extends RecyclerView.AdapterDataObserver
{
  private RecyclerView$RecyclerViewDataObserver(RecyclerView paramRecyclerView) {}
  
  public void onChanged()
  {
    this.this$0.assertNotInLayoutOrScroll(null);
    if (RecyclerView.access$3100(this.this$0).hasStableIds())
    {
      RecyclerView.State.access$1802(this.this$0.mState, true);
      RecyclerView.access$4000(this.this$0);
    }
    for (;;)
    {
      if (!this.this$0.mAdapterHelper.hasPendingUpdates()) {
        this.this$0.requestLayout();
      }
      return;
      RecyclerView.State.access$1802(this.this$0.mState, true);
      RecyclerView.access$4000(this.this$0);
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.this$0.assertNotInLayoutOrScroll(null);
    if (this.this$0.mAdapterHelper.onItemRangeChanged(paramInt1, paramInt2, paramObject)) {
      triggerUpdateProcessor();
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.this$0.assertNotInLayoutOrScroll(null);
    if (this.this$0.mAdapterHelper.onItemRangeInserted(paramInt1, paramInt2)) {
      triggerUpdateProcessor();
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$0.assertNotInLayoutOrScroll(null);
    if (this.this$0.mAdapterHelper.onItemRangeMoved(paramInt1, paramInt2, paramInt3)) {
      triggerUpdateProcessor();
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.this$0.assertNotInLayoutOrScroll(null);
    if (this.this$0.mAdapterHelper.onItemRangeRemoved(paramInt1, paramInt2)) {
      triggerUpdateProcessor();
    }
  }
  
  void triggerUpdateProcessor()
  {
    if ((RecyclerView.access$4100(this.this$0)) && (RecyclerView.access$4200(this.this$0)) && (RecyclerView.access$4300(this.this$0)))
    {
      ViewCompat.postOnAnimation(this.this$0, RecyclerView.access$4400(this.this$0));
      return;
    }
    RecyclerView.access$4502(this.this$0, true);
    this.this$0.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.RecyclerViewDataObserver
 * JD-Core Version:    0.7.0.1
 */