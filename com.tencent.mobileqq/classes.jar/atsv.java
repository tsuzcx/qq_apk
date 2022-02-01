import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atsv
  implements View.OnClickListener
{
  atsv(atsu paramatsu, String paramString) {}
  
  public void onClick(View paramView)
  {
    atvo.a(this.jdField_a_of_type_Atsu.a, this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsv
 * JD-Core Version:    0.7.0.1
 */