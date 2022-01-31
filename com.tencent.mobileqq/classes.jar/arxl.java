import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arxl
  implements View.OnClickListener
{
  arxl(arxh paramarxh, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Arxh.a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    arxh.a(this.jdField_a_of_type_Arxh).setClickable(false);
    arxh.a(this.jdField_a_of_type_Arxh).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840253));
    arxh.a(this.jdField_a_of_type_Arxh).a(true);
    axqw.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxl
 * JD-Core Version:    0.7.0.1
 */