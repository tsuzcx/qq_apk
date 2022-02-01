import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfml
  implements View.OnClickListener
{
  bfml(bfmi parambfmi) {}
  
  public void onClick(View paramView)
  {
    this.a.b(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfml
 * JD-Core Version:    0.7.0.1
 */