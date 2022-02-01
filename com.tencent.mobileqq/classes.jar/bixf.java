import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bixf
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public bixf(DraggableGridView paramDraggableGridView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void onClick(View paramView)
  {
    if (DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView) != null) {
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(paramView, this.jdField_a_of_type_Int, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixf
 * JD-Core Version:    0.7.0.1
 */