import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcio
  implements View.OnClickListener
{
  bcio(bcin parambcin) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcio
 * JD-Core Version:    0.7.0.1
 */