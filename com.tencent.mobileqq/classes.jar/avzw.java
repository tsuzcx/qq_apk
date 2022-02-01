import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avzw
  implements View.OnClickListener
{
  avzw(avzs paramavzs, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Avzs.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
      }
      avzs.a(this.jdField_a_of_type_Avzs).setClickable(false);
      avzs.a(this.jdField_a_of_type_Avzs).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840540));
      avzs.a(this.jdField_a_of_type_Avzs).a(true);
      bcst.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzw
 * JD-Core Version:    0.7.0.1
 */