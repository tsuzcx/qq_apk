import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbcz
  implements View.OnClickListener
{
  bbcz(bbcy parambbcy, bayt parambayt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bayt.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcz
 * JD-Core Version:    0.7.0.1
 */