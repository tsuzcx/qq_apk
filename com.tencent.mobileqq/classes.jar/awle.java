import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qphone.base.util.QLog;

public class awle
  implements bpfj
{
  public awle(LocationPickFragment paramLocationPickFragment, View paramView1, View paramView2, View paramView3, ImageView paramImageView, View paramView4) {}
  
  public void cancelAnimator() {}
  
  public void displayPanel() {}
  
  public void displayPanelFinish()
  {
    if (LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment) != null) {
      LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).setEnabled(false);
    }
    bdla.b(null, "CliOper", "", "", "0X800A95F", "0X800A95F", LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).b(), 0, "", "0", "0", "");
    this.b.setVisibility(8);
    this.c.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment.getString(2131693696));
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).b())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849681);
    }
  }
  
  public void fadeBackground(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[panel] fadeBackground: invoked. alpha: " + paramFloat);
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(Math.round(0.7F * paramFloat * 255.0F), 0, 0, 0));
  }
  
  public void hidePanel()
  {
    LocationPickFragment.b(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment);
  }
  
  public void hidePanelFinish()
  {
    if (LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment) != null) {
      LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).setEnabled(true);
    }
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).setDisplayFromType(2);
    this.d.requestFocus();
    this.b.setVisibility(0);
    this.c.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment.getString(2131693694));
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (!LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).b())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849680);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awle
 * JD-Core Version:    0.7.0.1
 */