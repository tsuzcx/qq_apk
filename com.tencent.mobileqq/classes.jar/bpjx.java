import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpjx
  implements View.OnClickListener
{
  bpjx(bpjw parambpjw) {}
  
  public void onClick(View paramView)
  {
    bozr.a().z();
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjx
 * JD-Core Version:    0.7.0.1
 */