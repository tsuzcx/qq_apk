import android.animation.Animator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

class bkrf
  extends bkrl
{
  bkrf(bkrd parambkrd, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, RecyclerView.ViewHolder paramViewHolder2)
  {
    super(parambkrd, paramViewHolder1, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.b) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Bkrd.mCallback.clearView(this.jdField_a_of_type_Bkrd.mRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
      }
      while (this.jdField_a_of_type_Bkrd.mOverdrawChild == this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView)
      {
        this.jdField_a_of_type_Bkrd.removeChildDrawingOrderCallbackIfNecessary(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView);
        return;
        this.jdField_a_of_type_Bkrd.mPendingCleanup.add(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView);
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_Int > 0) {
          this.jdField_a_of_type_Bkrd.postDispatchSwipe(this, this.jdField_a_of_type_Int);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkrf
 * JD-Core Version:    0.7.0.1
 */