import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcjq
  implements View.OnClickListener
{
  bcjq(bcjk parambcjk, bcgn parambcgn, bcox parambcox) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bcgn.a(this.jdField_a_of_type_Bcox.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjq
 * JD-Core Version:    0.7.0.1
 */