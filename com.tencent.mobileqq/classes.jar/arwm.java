import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arwm
  implements View.OnClickListener
{
  arwm(arwh paramarwh, Activity paramActivity, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    arwh.a(this.jdField_a_of_type_Arwh).setClickable(false);
    arwh.a(this.jdField_a_of_type_Arwh).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840253));
    arwh.a(this.jdField_a_of_type_Arwh).a(true);
    arwh.a(this.jdField_a_of_type_Arwh, arwh.a(this.jdField_a_of_type_Arwh).a());
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
    for (;;)
    {
      axqw.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
      return;
      this.jdField_a_of_type_Arwh.a("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arwm
 * JD-Core Version:    0.7.0.1
 */