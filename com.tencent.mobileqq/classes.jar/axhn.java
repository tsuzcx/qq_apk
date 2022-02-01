import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axhn
  implements View.OnClickListener
{
  axhn(axhm paramaxhm) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof axho)) && (this.a.a != null))
    {
      axho localaxho = (axho)paramView.getTag();
      this.a.a.a(this.a, paramView, localaxho);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axhn
 * JD-Core Version:    0.7.0.1
 */