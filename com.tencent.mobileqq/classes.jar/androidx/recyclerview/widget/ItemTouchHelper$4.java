package androidx.recyclerview.widget;

class ItemTouchHelper$4
  implements Runnable
{
  ItemTouchHelper$4(ItemTouchHelper paramItemTouchHelper, ItemTouchHelper.RecoverAnimation paramRecoverAnimation, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.mRecyclerView != null) && (this.this$0.mRecyclerView.isAttachedToWindow()) && (!this.val$anim.mOverridden) && (this.val$anim.mViewHolder.getAdapterPosition() != -1))
    {
      RecyclerView.ItemAnimator localItemAnimator = this.this$0.mRecyclerView.getItemAnimator();
      if (((localItemAnimator == null) || (!localItemAnimator.isRunning(null))) && (!this.this$0.hasRunningRecoverAnim())) {
        this.this$0.mCallback.onSwiped(this.val$anim.mViewHolder, this.val$swipeDir);
      }
    }
    else
    {
      return;
    }
    this.this$0.mRecyclerView.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper.4
 * JD-Core Version:    0.7.0.1
 */