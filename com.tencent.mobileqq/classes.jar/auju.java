import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auju
  implements View.OnClickListener
{
  auju(aujr paramaujr) {}
  
  public void onClick(View paramView)
  {
    aujr.a(this.a, true);
    this.a.jdField_a_of_type_Auku.f(true);
    this.a.jdField_a_of_type_Auku.d(false);
    aujr.a(this.a);
    this.a.jdField_a_of_type_Augj.f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auju
 * JD-Core Version:    0.7.0.1
 */