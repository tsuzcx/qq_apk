import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bfeu
  implements View.OnClickListener
{
  private bfev jdField_a_of_type_Bfev;
  private bfew jdField_a_of_type_Bfew;
  
  public bfeu(bfew parambfew)
  {
    this.jdField_a_of_type_Bfew = parambfew;
  }
  
  public void a(bfev parambfev)
  {
    this.jdField_a_of_type_Bfev = parambfev;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    bfew.a(this.jdField_a_of_type_Bfew, i);
    if (this.jdField_a_of_type_Bfev != null) {
      this.jdField_a_of_type_Bfev.a((bfex)bfew.a(this.jdField_a_of_type_Bfew).get(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfeu
 * JD-Core Version:    0.7.0.1
 */