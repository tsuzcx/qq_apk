import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class botd
  implements View.OnClickListener
{
  botd(botb parambotb) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botd
 * JD-Core Version:    0.7.0.1
 */