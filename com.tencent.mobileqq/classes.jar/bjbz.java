import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjbz
  implements View.OnClickListener
{
  public bjbz(QQToast paramQQToast, bjcc parambjcc, Toast paramToast) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bjcc.a != null)
    {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
      this.jdField_a_of_type_Bjcc.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjbz
 * JD-Core Version:    0.7.0.1
 */