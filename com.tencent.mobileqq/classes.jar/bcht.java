import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcht
  implements View.OnClickListener
{
  bcht(bchs parambchs, bcfj parambcfj) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bcfj.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcht
 * JD-Core Version:    0.7.0.1
 */