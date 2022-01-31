import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.qphone.base.util.QLog;

public class arww
  implements View.OnClickListener
{
  public arww(LocationPickFragment paramLocationPickFragment, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    if (!bbfj.a())
    {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, 2131694011, 0).a();
      return;
    }
    paramView = LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).a();
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[venue] pick confirm click: venue: " + paramView);
    }
    if (LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).a()) {}
    for (;;)
    {
      axqy.b(null, "CliOper", "", "", "0X800A962", "0X800A962", i, 0, "", "0", "0", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("key_picked_location", paramView);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arww
 * JD-Core Version:    0.7.0.1
 */