import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

class bfhj
  implements View.OnClickListener
{
  bfhj(bfhh parambfhh, bfhl parambfhl) {}
  
  public void onClick(View paramView)
  {
    if ((bfhh.a(this.jdField_a_of_type_Bfhh) != null) && (bfhh.a(this.jdField_a_of_type_Bfhh).isShowing())) {
      bfhh.a(this.jdField_a_of_type_Bfhh).dismiss();
    }
    if ((this.jdField_a_of_type_Bfhl != null) && (bfhh.a(this.jdField_a_of_type_Bfhh) != null)) {
      this.jdField_a_of_type_Bfhl.a(bfhh.a(this.jdField_a_of_type_Bfhh).getTimeInMillis());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhj
 * JD-Core Version:    0.7.0.1
 */