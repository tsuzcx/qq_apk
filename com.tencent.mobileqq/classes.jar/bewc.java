import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bewc
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  public TextView a;
  public TextView b;
  
  public bewc(bewa parambewa) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bewa.a != null) {
      this.jdField_a_of_type_Bewa.a.a(paramView, this.jdField_a_of_type_Int, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewc
 * JD-Core Version:    0.7.0.1
 */