import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcjl
  implements View.OnClickListener
{
  bcjl(bcjk parambcjk, bcga parambcga) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bcga.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjl
 * JD-Core Version:    0.7.0.1
 */