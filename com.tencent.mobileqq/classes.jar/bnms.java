import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnms
  implements View.OnClickListener
{
  bnms(bnmq parambnmq) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnms
 * JD-Core Version:    0.7.0.1
 */