import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbce
  implements View.OnClickListener
{
  bbce(bbcd parambbcd, bays parambays) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bays.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbce
 * JD-Core Version:    0.7.0.1
 */