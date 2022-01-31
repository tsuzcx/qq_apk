import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class atss
  implements View.OnClickListener
{
  atss(atso paramatso, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Atso.a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    atso.a(this.jdField_a_of_type_Atso).setClickable(false);
    atso.a(this.jdField_a_of_type_Atso).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840354));
    atso.a(this.jdField_a_of_type_Atso).a(true);
    azqs.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atss
 * JD-Core Version:    0.7.0.1
 */