package android.support.v7.widget;

class RecyclerView$ItemAnimatorRestoreListener
  implements RecyclerView.ItemAnimator.ItemAnimatorListener
{
  private RecyclerView$ItemAnimatorRestoreListener(RecyclerView paramRecyclerView) {}
  
  public void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder.setIsRecyclable(true);
    if ((paramViewHolder.mShadowedHolder != null) && (paramViewHolder.mShadowingHolder == null)) {
      paramViewHolder.mShadowedHolder = null;
    }
    paramViewHolder.mShadowingHolder = null;
    if ((!RecyclerView.ViewHolder.access$6400(paramViewHolder)) && (!RecyclerView.access$6500(this.this$0, paramViewHolder.itemView)) && (paramViewHolder.isTmpDetached())) {
      this.this$0.removeDetachedView(paramViewHolder.itemView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.ItemAnimatorRestoreListener
 * JD-Core Version:    0.7.0.1
 */