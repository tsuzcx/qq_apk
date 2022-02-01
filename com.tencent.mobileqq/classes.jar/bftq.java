import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bftq
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  protected bftq(bfto parambfto) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bfto.a != null) {
      this.jdField_a_of_type_Bfto.a.a(paramView, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bftq
 * JD-Core Version:    0.7.0.1
 */