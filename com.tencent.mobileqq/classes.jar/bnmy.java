import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnmy
  implements View.OnClickListener
{
  bnmy(bnmu parambnmu) {}
  
  public void onClick(View paramView)
  {
    bnmu.a(this.a).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmy
 * JD-Core Version:    0.7.0.1
 */