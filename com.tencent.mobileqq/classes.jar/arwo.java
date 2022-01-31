import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arwo
  implements View.OnClickListener
{
  arwo(arwj paramarwj, Activity paramActivity, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    arwj.a(this.jdField_a_of_type_Arwj).setClickable(false);
    arwj.a(this.jdField_a_of_type_Arwj).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840250));
    arwj.a(this.jdField_a_of_type_Arwj).a(true);
    arwj.a(this.jdField_a_of_type_Arwj, arwj.a(this.jdField_a_of_type_Arwj).a());
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
    for (;;)
    {
      axqy.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
      return;
      this.jdField_a_of_type_Arwj.a("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arwo
 * JD-Core Version:    0.7.0.1
 */