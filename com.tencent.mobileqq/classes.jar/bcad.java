import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcad
  implements View.OnClickListener
{
  bcad(bcac parambcac, bjak parambjak) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bjak.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcad
 * JD-Core Version:    0.7.0.1
 */