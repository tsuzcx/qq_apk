import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axpq
  implements View.OnClickListener
{
  axpq(axop paramaxop) {}
  
  public void onClick(View paramView)
  {
    this.a.j(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpq
 * JD-Core Version:    0.7.0.1
 */