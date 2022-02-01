import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpjy
  implements View.OnClickListener
{
  bpjy(bpjw parambpjw) {}
  
  public void onClick(View paramView)
  {
    bozr.a().A();
    bpjw.a(this.a);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjy
 * JD-Core Version:    0.7.0.1
 */