import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.mobileqq.location.ui.MapWidget;

public class atoy
  implements View.OnClickListener
{
  public atoy(LocationShareFragment paramLocationShareFragment, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareFragment).a()) {
      return;
    }
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareFragment.getActivity(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareFragment).a());
    azmj.b(null, "CliOper", "", "", "0X800A95C", "0X800A95C", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atoy
 * JD-Core Version:    0.7.0.1
 */