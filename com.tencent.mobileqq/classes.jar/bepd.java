import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.widget.DraggableGridView;

public class bepd
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public bepd(DraggableGridView paramDraggableGridView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void onClick(View paramView)
  {
    if (DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView) != null) {
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(paramView, this.jdField_a_of_type_Int, this.b);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView) != null) {
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(this.jdField_a_of_type_Int, this.b);
    }
    if ((DraggableGridView.c(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView)) && (!DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView.a((View)paramView.getParent(), paramView);
      paramView.setVisibility(4);
      paramView.setPressed(false);
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView, this.jdField_a_of_type_Int);
      DraggableGridView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView, this.b);
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).x = DraggableGridView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView);
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).y = DraggableGridView.c(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView);
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView, true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepd
 * JD-Core Version:    0.7.0.1
 */