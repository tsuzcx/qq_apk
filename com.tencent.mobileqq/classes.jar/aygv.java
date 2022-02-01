import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aygv
  implements View.OnClickListener
{
  aygv(ayfx paramayfx) {}
  
  public void onClick(View paramView)
  {
    ayfx.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygv
 * JD-Core Version:    0.7.0.1
 */