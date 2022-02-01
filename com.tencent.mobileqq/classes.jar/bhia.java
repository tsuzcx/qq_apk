import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhia
  implements View.OnClickListener
{
  public bhia(QQToast paramQQToast, bhid parambhid, Toast paramToast) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bhid.a != null)
    {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
      this.jdField_a_of_type_Bhid.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhia
 * JD-Core Version:    0.7.0.1
 */