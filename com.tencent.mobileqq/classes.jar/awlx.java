import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awlx
  implements View.OnClickListener
{
  awlx(awlt paramawlt, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Awlt.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
      }
      awlt.a(this.jdField_a_of_type_Awlt).setClickable(false);
      awlt.a(this.jdField_a_of_type_Awlt).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840624));
      awlt.a(this.jdField_a_of_type_Awlt).a(true);
      bdla.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlx
 * JD-Core Version:    0.7.0.1
 */