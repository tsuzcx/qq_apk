import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgdf
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  protected bgdf(bgdd parambgdd) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bgdd.a != null) {
      this.jdField_a_of_type_Bgdd.a.a(paramView, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdf
 * JD-Core Version:    0.7.0.1
 */