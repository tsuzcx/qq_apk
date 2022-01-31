import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class atoj
  implements View.OnClickListener
{
  atoj(atof paramatof, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Atof.a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    atof.a(this.jdField_a_of_type_Atof).setClickable(false);
    atof.a(this.jdField_a_of_type_Atof).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840353));
    atof.a(this.jdField_a_of_type_Atof).a(true);
    azmj.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atoj
 * JD-Core Version:    0.7.0.1
 */