import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axot
  implements View.OnClickListener
{
  axot(axop paramaxop) {}
  
  public void onClick(View paramView)
  {
    this.a.b(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axot
 * JD-Core Version:    0.7.0.1
 */