import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbcc
  implements View.OnClickListener
{
  bbcc(bbcb parambbcb, bayb parambayb) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bayb.b(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcc
 * JD-Core Version:    0.7.0.1
 */