import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bath
  implements View.OnClickListener
{
  bath(batg parambatg, bhgl parambhgl) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bhgl.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bath
 * JD-Core Version:    0.7.0.1
 */