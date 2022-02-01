import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class bcoe
  extends bcoa
  implements HorizontalListView.OnScrollStateChangedListener
{
  public bcfx a;
  public HorizontalListView a;
  
  public bcoe(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)((LinearLayout)a(paramInt)).findViewById(2131377222));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this);
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097) {
      this.jdField_a_of_type_Bcfx.b = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getCurrentX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcoe
 * JD-Core Version:    0.7.0.1
 */