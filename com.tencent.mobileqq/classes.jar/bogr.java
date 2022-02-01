import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bogr
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public bogr(bogn parambogn) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bogn.a.a != null) {
      this.jdField_a_of_type_Bogn.a.a.a(paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidWidgetCheckBox);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogr
 * JD-Core Version:    0.7.0.1
 */