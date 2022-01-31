import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.widget.DraggableGridView;

public class bbig
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  
  public bbig(DraggableGridView paramDraggableGridView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(this.jdField_a_of_type_Int);
  }
  
  public Object getItem(int paramInt)
  {
    return DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(this.jdField_a_of_type_Int, paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView.getContext()), this.jdField_a_of_type_Int, paramInt, paramViewGroup);
    }
    DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(localView, this.jdField_a_of_type_Int, paramInt);
    paramView = new bbie(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView, this.jdField_a_of_type_Int, paramInt);
    localView.setOnClickListener(paramView);
    localView.setOnLongClickListener(paramView);
    if ((!DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView)) && ((DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).y != this.jdField_a_of_type_Int) || (DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).x != paramInt) || (!DraggableGridView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView)))) {
      localView.setVisibility(0);
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbig
 * JD-Core Version:    0.7.0.1
 */