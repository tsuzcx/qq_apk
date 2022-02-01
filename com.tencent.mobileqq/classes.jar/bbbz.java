import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbbz
  implements View.OnClickListener
{
  bbbz(bbby parambbby) {}
  
  public void onClick(View paramView)
  {
    bbby.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbz
 * JD-Core Version:    0.7.0.1
 */