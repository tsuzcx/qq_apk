import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avfu
  implements View.OnClickListener
{
  avfu(avfq paramavfq, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Avfq.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
      }
      avfq.a(this.jdField_a_of_type_Avfq).setClickable(false);
      avfq.a(this.jdField_a_of_type_Avfq).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840585));
      avfq.a(this.jdField_a_of_type_Avfq).a(true);
      bcef.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfu
 * JD-Core Version:    0.7.0.1
 */