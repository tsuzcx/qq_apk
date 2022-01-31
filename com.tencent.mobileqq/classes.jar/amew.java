import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback;

public class amew
  implements Runnable
{
  public amew(ItemTouchHelper paramItemTouchHelper, amfb paramamfb, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) && (this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.isAttachedToWindow()) && (!this.jdField_a_of_type_Amfb.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Amfb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.getAdapterPosition() != -1))
    {
      RecyclerView.ItemAnimator localItemAnimator = this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator();
      if (((localItemAnimator == null) || (!localItemAnimator.isRunning(null))) && (!this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper.a())) {
        this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.jdField_a_of_type_Amfb.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, this.jdField_a_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amew
 * JD-Core Version:    0.7.0.1
 */