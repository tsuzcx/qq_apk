import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.widget.HorizontalListView;

public class aysf
  extends aysb
  implements bhtl
{
  public ayjz a;
  public HorizontalListView a;
  
  public aysf(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((LinearLayout)a(paramInt)).findViewById(2131376228));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this);
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097) {
      this.jdField_a_of_type_Ayjz.b = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysf
 * JD-Core Version:    0.7.0.1
 */