import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blju
  implements View.OnClickListener
{
  blju(bljt parambljt) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blju
 * JD-Core Version:    0.7.0.1
 */