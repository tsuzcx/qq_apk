import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgtz
  implements View.OnClickListener
{
  bgtz(bgtw parambgtw) {}
  
  public void onClick(View paramView)
  {
    this.a.setWarnToastVisible(false, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtz
 * JD-Core Version:    0.7.0.1
 */