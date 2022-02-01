import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class avzg
  implements View.OnKeyListener
{
  public avzg(LocationPickFragment paramLocationPickFragment, EditText paramEditText) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).b()))
    {
      LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).e();
      return true;
    }
    if ((paramInt == 84) || (paramInt == 66))
    {
      LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim());
      LocationPickFragment.b(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzg
 * JD-Core Version:    0.7.0.1
 */