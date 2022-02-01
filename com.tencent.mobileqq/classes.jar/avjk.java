import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avjk
  implements View.OnClickListener
{
  avjk(avji paramavji) {}
  
  public void onClick(View paramView)
  {
    this.a.g();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjk
 * JD-Core Version:    0.7.0.1
 */