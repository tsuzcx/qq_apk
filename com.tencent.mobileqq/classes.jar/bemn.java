import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bemn
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  protected bemn(beml parambeml) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Beml.a != null) {
      this.jdField_a_of_type_Beml.a.a(paramView, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemn
 * JD-Core Version:    0.7.0.1
 */