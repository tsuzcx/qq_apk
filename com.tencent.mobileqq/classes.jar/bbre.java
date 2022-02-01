import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbre
  implements View.OnClickListener
{
  bbre(bbrd parambbrd, bbmy parambbmy) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bbmy.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbre
 * JD-Core Version:    0.7.0.1
 */