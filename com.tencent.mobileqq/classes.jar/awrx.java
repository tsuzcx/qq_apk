import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awrx
  implements View.OnClickListener
{
  public awrx(LocationPickFragment paramLocationPickFragment, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    if (!bhnv.a())
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131693429, 0).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    LocationRoom.Venue localVenue = LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).a();
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[venue] pick confirm click: venue: " + localVenue);
    }
    if (LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).a()) {}
    for (;;)
    {
      bdll.b(null, "CliOper", "", "", "0X800A962", "0X800A962", i, 0, "", "0", "0", "");
      Intent localIntent = new Intent();
      localIntent.putExtra("key_picked_location", localVenue);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      break;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrx
 * JD-Core Version:    0.7.0.1
 */