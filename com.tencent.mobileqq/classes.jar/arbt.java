import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arbt
  implements View.OnClickListener
{
  arbt(arbp paramarbp, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Arbp.a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    arbp.a(this.jdField_a_of_type_Arbp).setClickable(false);
    arbp.a(this.jdField_a_of_type_Arbp).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840206));
    arbp.a(this.jdField_a_of_type_Arbp).a(true);
    awqx.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbt
 * JD-Core Version:    0.7.0.1
 */