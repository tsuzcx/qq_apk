import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awrz
  implements View.OnClickListener
{
  public awrz(LocationPickFragment paramLocationPickFragment, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).e();
    bdll.b(null, "CliOper", "", "", "0X800A961", "0X800A961", 0, 0, "0", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrz
 * JD-Core Version:    0.7.0.1
 */