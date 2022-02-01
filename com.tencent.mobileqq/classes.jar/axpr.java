import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axpr
  implements View.OnClickListener
{
  axpr(axop paramaxop) {}
  
  public void onClick(View paramView)
  {
    this.a.i(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpr
 * JD-Core Version:    0.7.0.1
 */