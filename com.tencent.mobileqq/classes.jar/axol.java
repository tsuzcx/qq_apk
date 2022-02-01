import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axol
  implements View.OnClickListener
{
  axol(axoj paramaxoj) {}
  
  public void onClick(View paramView)
  {
    axoo localaxoo = (axoo)paramView.getTag();
    if (this.a.a != null) {
      this.a.a.a(paramView, localaxoo.a, localaxoo.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axol
 * JD-Core Version:    0.7.0.1
 */