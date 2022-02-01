import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axod
  implements View.OnClickListener
{
  axod(axoc paramaxoc) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof axoe)))
    {
      axoe localaxoe = (axoe)paramView.getTag();
      this.a.a.a(localaxoe);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axod
 * JD-Core Version:    0.7.0.1
 */