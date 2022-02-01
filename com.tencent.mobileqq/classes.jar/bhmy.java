import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhmy
  implements View.OnClickListener
{
  bhmy(bhmv parambhmv) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmy
 * JD-Core Version:    0.7.0.1
 */