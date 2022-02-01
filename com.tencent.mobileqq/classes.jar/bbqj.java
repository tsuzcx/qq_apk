import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbqj
  implements View.OnClickListener
{
  bbqj(bbqi parambbqi, bbmx parambbmx) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bbmx.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqj
 * JD-Core Version:    0.7.0.1
 */