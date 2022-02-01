import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atzo
  implements View.OnClickListener
{
  atzo(atzm paramatzm) {}
  
  public void onClick(View paramView)
  {
    atzm.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzo
 * JD-Core Version:    0.7.0.1
 */