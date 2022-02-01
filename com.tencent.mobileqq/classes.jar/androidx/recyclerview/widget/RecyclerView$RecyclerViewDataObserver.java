package androidx.recyclerview.widget;

import androidx.core.view.ViewCompat;

class RecyclerView$RecyclerViewDataObserver
  extends RecyclerView.AdapterDataObserver
{
  RecyclerView$RecyclerViewDataObserver(RecyclerView paramRecyclerView) {}
  
  public void onChanged()
  {
    this.this$0.assertNotInLayoutOrScroll(null);
    this.this$0.mState.mStructureChanged = true;
    this.this$0.processDataSetCompletelyChanged(true);
    if (!this.this$0.mAdapterHelper.hasPendingUpdates()) {
      this.this$0.requestLayout();
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
    if ((RecyclerView.POST_UPDATES_ON_ANIMATION) && (this.this$0.mHasFixedSize) && (this.this$0.mIsAttached))
    {
      ViewCompat.postOnAnimation(this.this$0, this.this$0.mUpdateChildViewsRunnable);
      return;
    }
    this.this$0.mAdapterUpdateDuringMeasure = true;
    this.this$0.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.RecyclerViewDataObserver
 * JD-Core Version:    0.7.0.1
 */