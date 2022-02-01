import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgcs
  implements View.OnClickListener
{
  bgcs(bgcr parambgcr) {}
  
  public void onClick(View paramView)
  {
    if (bgcr.a(this.a) != null) {
      bgcr.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcs
 * JD-Core Version:    0.7.0.1
 */