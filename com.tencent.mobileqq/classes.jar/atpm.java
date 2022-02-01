import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atpm
  implements View.OnClickListener
{
  atpm(atpf paramatpf) {}
  
  public void onClick(View paramView)
  {
    atvo.a(this.a.a, this.a.d());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpm
 * JD-Core Version:    0.7.0.1
 */