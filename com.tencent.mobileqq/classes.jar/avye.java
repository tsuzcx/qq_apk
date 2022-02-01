import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.widget.ListView;

public class avye
  implements View.OnLayoutChangeListener
{
  public avye(MultiAIOItemFragment paramMultiAIOItemFragment, ListView paramListView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView.getWidth() > 0) && (this.jdField_a_of_type_ComTencentWidgetListView.getHeight() > 0))
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeOnLayoutChangeListener(this);
      MultiAIOItemFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOItemFragment, this.jdField_a_of_type_ComTencentWidgetListView.getWidth(), this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avye
 * JD-Core Version:    0.7.0.1
 */