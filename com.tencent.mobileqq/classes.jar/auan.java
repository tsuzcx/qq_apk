import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auan
  implements View.OnClickListener
{
  auan(auam paramauam, bcfr parambcfr) {}
  
  public void onClick(View paramView)
  {
    ((aual)this.jdField_a_of_type_Bcfr).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auan
 * JD-Core Version:    0.7.0.1
 */