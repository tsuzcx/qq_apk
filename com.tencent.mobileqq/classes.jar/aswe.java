import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aswe
  implements View.OnClickListener
{
  aswe(aswb paramaswb) {}
  
  public void onClick(View paramView)
  {
    aswb.a(this.a, true);
    this.a.jdField_a_of_type_Asxe.f(true);
    this.a.jdField_a_of_type_Asxe.d(false);
    aswb.a(this.a);
    this.a.jdField_a_of_type_Asst.f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswe
 * JD-Core Version:    0.7.0.1
 */