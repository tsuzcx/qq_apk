import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

class bgqa
  implements View.OnClickListener
{
  bgqa(bgpy parambgpy, bgqc parambgqc) {}
  
  public void onClick(View paramView)
  {
    if ((bgpy.a(this.jdField_a_of_type_Bgpy) != null) && (bgpy.a(this.jdField_a_of_type_Bgpy).isShowing())) {
      bgpy.a(this.jdField_a_of_type_Bgpy).dismiss();
    }
    if ((this.jdField_a_of_type_Bgqc != null) && (bgpy.a(this.jdField_a_of_type_Bgpy) != null)) {
      this.jdField_a_of_type_Bgqc.a(bgpy.a(this.jdField_a_of_type_Bgpy).getTimeInMillis());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgqa
 * JD-Core Version:    0.7.0.1
 */