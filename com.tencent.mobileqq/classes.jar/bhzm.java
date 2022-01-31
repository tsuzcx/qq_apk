import android.animation.Animator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

class bhzm
  extends bhzs
{
  bhzm(bhzk parambhzk, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, RecyclerView.ViewHolder paramViewHolder2)
  {
    super(parambhzk, paramViewHolder1, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.b) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Bhzk.mCallback.clearView(this.jdField_a_of_type_Bhzk.mRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
      }
      while (this.jdField_a_of_type_Bhzk.mOverdrawChild == this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView)
      {
        this.jdField_a_of_type_Bhzk.removeChildDrawingOrderCallbackIfNecessary(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView);
        return;
        this.jdField_a_of_type_Bhzk.mPendingCleanup.add(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView);
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_Int > 0) {
          this.jdField_a_of_type_Bhzk.postDispatchSwipe(this, this.jdField_a_of_type_Int);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhzm
 * JD-Core Version:    0.7.0.1
 */