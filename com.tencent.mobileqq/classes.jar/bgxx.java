import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

class bgxx
  implements View.OnClickListener
{
  bgxx(bgxv parambgxv, bgxz parambgxz) {}
  
  public void onClick(View paramView)
  {
    if ((bgxv.a(this.jdField_a_of_type_Bgxv) != null) && (bgxv.a(this.jdField_a_of_type_Bgxv).isShowing())) {
      bgxv.a(this.jdField_a_of_type_Bgxv).dismiss();
    }
    if ((this.jdField_a_of_type_Bgxz != null) && (bgxv.a(this.jdField_a_of_type_Bgxv) != null)) {
      this.jdField_a_of_type_Bgxz.a(bgxv.a(this.jdField_a_of_type_Bgxv).getTimeInMillis());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxx
 * JD-Core Version:    0.7.0.1
 */