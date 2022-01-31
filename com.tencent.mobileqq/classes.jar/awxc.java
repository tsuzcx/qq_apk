import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.widget.HorizontalListView;

public class awxc
  extends awwy
  implements bfso
{
  public awow a;
  public HorizontalListView a;
  
  public awxc(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((LinearLayout)a(paramInt)).findViewById(2131375734));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this);
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097) {
      this.jdField_a_of_type_Awow.b = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxc
 * JD-Core Version:    0.7.0.1
 */