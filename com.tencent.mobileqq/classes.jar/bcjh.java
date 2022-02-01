import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcjh
  implements View.OnClickListener
{
  bcjh(bcjg parambcjg, bcfq parambcfq) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bcfq.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjh
 * JD-Core Version:    0.7.0.1
 */