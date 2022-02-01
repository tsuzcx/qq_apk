package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class RecyclerView$4
  implements ViewInfoStore.ProcessCallback
{
  RecyclerView$4(RecyclerView paramRecyclerView) {}
  
  public void processAppeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    this.this$0.animateAppearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2);
  }
  
  public void processDisappeared(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    this.this$0.mRecycler.unscrapView(paramViewHolder);
    this.this$0.animateDisappearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2);
  }
  
  public void processPersistent(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    paramViewHolder.setIsRecyclable(false);
    if (this.this$0.mDataSetHasChangedAfterLayout)
    {
      if (this.this$0.mItemAnimator.animateChange(paramViewHolder, paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
        this.this$0.postAnimationRunner();
      }
    }
    else if (this.this$0.mItemAnimator.animatePersistence(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      this.this$0.postAnimationRunner();
    }
  }
  
  public void unused(RecyclerView.ViewHolder paramViewHolder)
  {
    this.this$0.mLayout.removeAndRecycleView(paramViewHolder.itemView, this.this$0.mRecycler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.4
 * JD-Core Version:    0.7.0.1
 */