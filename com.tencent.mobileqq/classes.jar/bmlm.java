import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmlm
  implements View.OnClickListener
{
  bmlm(bmll parambmll, bmlp parambmlp) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bmlp.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlm
 * JD-Core Version:    0.7.0.1
 */