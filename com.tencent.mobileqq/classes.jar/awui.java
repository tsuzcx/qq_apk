import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awui
  implements View.OnClickListener
{
  awui(awud paramawud, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awui
 * JD-Core Version:    0.7.0.1
 */