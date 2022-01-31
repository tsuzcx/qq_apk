import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class atnk
  implements View.OnClickListener
{
  atnk(atnf paramatnf, Activity paramActivity, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    atnf.a(this.jdField_a_of_type_Atnf).setClickable(false);
    atnf.a(this.jdField_a_of_type_Atnf).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840353));
    atnf.a(this.jdField_a_of_type_Atnf).a(true);
    atnf.a(this.jdField_a_of_type_Atnf, atnf.a(this.jdField_a_of_type_Atnf).a());
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
    for (;;)
    {
      azmj.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
      return;
      this.jdField_a_of_type_Atnf.a("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnk
 * JD-Core Version:    0.7.0.1
 */