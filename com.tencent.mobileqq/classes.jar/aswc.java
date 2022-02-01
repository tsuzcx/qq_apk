import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aswc
  implements View.OnClickListener
{
  aswc(aswb paramaswb) {}
  
  public void onClick(View paramView)
  {
    aszt.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Asst.d());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswc
 * JD-Core Version:    0.7.0.1
 */