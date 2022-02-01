import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bint
  implements View.OnClickListener
{
  bint(binq parambinq) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bint
 * JD-Core Version:    0.7.0.1
 */