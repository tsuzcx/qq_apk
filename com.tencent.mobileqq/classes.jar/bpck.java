import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpck
  implements View.OnClickListener
{
  bpck(bpcg parambpcg) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(34);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpck
 * JD-Core Version:    0.7.0.1
 */