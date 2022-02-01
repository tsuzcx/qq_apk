import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awky
  implements View.OnClickListener
{
  awky(awkt paramawkt, Activity paramActivity, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    awkt.a(this.jdField_a_of_type_Awkt).setClickable(false);
    awkt.a(this.jdField_a_of_type_Awkt).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840624));
    awkt.a(this.jdField_a_of_type_Awkt).a(true);
    awkt.a(this.jdField_a_of_type_Awkt, awkt.a(this.jdField_a_of_type_Awkt).a());
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
    for (;;)
    {
      bdla.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Awkt.a("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awky
 * JD-Core Version:    0.7.0.1
 */