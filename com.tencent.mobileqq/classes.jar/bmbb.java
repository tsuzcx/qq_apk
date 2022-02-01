import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmbb
  implements View.OnClickListener
{
  bmbb(bmba parambmba, bmbe parambmbe) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bmbe.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbb
 * JD-Core Version:    0.7.0.1
 */