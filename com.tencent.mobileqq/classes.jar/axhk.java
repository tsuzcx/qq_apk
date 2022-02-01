import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axhk
  implements View.OnClickListener
{
  axhk(axhi paramaxhi, axhd paramaxhd) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Axhi.dismiss();
    if (this.jdField_a_of_type_Axhd.a != null) {
      this.jdField_a_of_type_Axhd.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axhk
 * JD-Core Version:    0.7.0.1
 */