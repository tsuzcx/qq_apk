import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axqs
  implements View.OnClickListener
{
  axqs(axqp paramaxqp, axre paramaxre) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Axre.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqs
 * JD-Core Version:    0.7.0.1
 */