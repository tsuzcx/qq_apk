import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atsw
  implements View.OnClickListener
{
  atsw(atsu paramatsu) {}
  
  public void onClick(View paramView)
  {
    this.a.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsw
 * JD-Core Version:    0.7.0.1
 */