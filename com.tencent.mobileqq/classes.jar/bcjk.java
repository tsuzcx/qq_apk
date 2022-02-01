import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcjk
  implements View.OnClickListener
{
  bcjk(bcje parambcje, bcgf parambcgf, bcor parambcor) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bcgf.a(this.jdField_a_of_type_Bcor.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjk
 * JD-Core Version:    0.7.0.1
 */