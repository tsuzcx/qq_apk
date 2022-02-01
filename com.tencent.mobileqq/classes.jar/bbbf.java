import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbbf
  implements View.OnClickListener
{
  bbbf(bbbc parambbbc) {}
  
  public void onClick(View paramView)
  {
    bbbc.a(this.a).onAction(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbf
 * JD-Core Version:    0.7.0.1
 */