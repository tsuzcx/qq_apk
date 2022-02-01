import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdoz
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  public TextView a;
  TextView b;
  
  public bdoz(bdox parambdox) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bdox.a != null) {
      this.jdField_a_of_type_Bdox.a.a(paramView, this.jdField_a_of_type_Int, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoz
 * JD-Core Version:    0.7.0.1
 */