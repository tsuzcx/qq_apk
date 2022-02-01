import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcjb
  implements View.OnClickListener
{
  bcjb(bcja parambcja, bcfi parambcfi) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bcfi.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjb
 * JD-Core Version:    0.7.0.1
 */