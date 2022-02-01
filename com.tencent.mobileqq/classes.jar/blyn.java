import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blyn
  implements View.OnClickListener
{
  blyn(blyk paramblyk) {}
  
  public void onClick(View paramView)
  {
    bmbc.a().am();
    blyk.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyn
 * JD-Core Version:    0.7.0.1
 */