import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arxn
  implements View.OnClickListener
{
  arxn(arxj paramarxj, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Arxj.a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    arxj.a(this.jdField_a_of_type_Arxj).setClickable(false);
    arxj.a(this.jdField_a_of_type_Arxj).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840250));
    arxj.a(this.jdField_a_of_type_Arxj).a(true);
    axqy.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxn
 * JD-Core Version:    0.7.0.1
 */