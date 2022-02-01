package androidx.recyclerview.widget;

import android.animation.Animator;
import java.util.List;

class ItemTouchHelper$3
  extends ItemTouchHelper.RecoverAnimation
{
  ItemTouchHelper$3(ItemTouchHelper paramItemTouchHelper, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, RecyclerView.ViewHolder paramViewHolder2)
  {
    super(paramViewHolder1, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.mOverridden) {
      return;
    }
    if (this.val$swipeDir <= 0)
    {
      this.this$0.mCallback.clearView(this.this$0.mRecyclerView, this.val$prevSelected);
    }
    else
    {
      this.this$0.mPendingCleanup.add(this.val$prevSelected.itemView);
      this.mIsPendingCleanup = true;
      int i = this.val$swipeDir;
      if (i > 0) {
        this.this$0.postDispatchSwipe(this, i);
      }
    }
    if (this.this$0.mOverdrawChild == this.val$prevSelected.itemView) {
      this.this$0.removeChildDrawingOrderCallbackIfNecessary(this.val$prevSelected.itemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper.3
 * JD-Core Version:    0.7.0.1
 */