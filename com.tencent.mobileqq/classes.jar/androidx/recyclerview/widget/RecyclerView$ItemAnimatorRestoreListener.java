package androidx.recyclerview.widget;

class RecyclerView$ItemAnimatorRestoreListener
  implements RecyclerView.ItemAnimator.ItemAnimatorListener
{
  RecyclerView$ItemAnimatorRestoreListener(RecyclerView paramRecyclerView) {}
  
  public void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder.setIsRecyclable(true);
    if ((paramViewHolder.mShadowedHolder != null) && (paramViewHolder.mShadowingHolder == null)) {
      paramViewHolder.mShadowedHolder = null;
    }
    paramViewHolder.mShadowingHolder = null;
    if ((!paramViewHolder.shouldBeKeptAsChild()) && (!this.this$0.removeAnimatingView(paramViewHolder.itemView)) && (paramViewHolder.isTmpDetached())) {
      this.this$0.removeDetachedView(paramViewHolder.itemView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.ItemAnimatorRestoreListener
 * JD-Core Version:    0.7.0.1
 */