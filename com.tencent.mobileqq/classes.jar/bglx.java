import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bglx
  implements View.OnClickListener
{
  bglx(bglw parambglw) {}
  
  public void onClick(View paramView)
  {
    if (bglw.a(this.a) != null) {
      bglw.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglx
 * JD-Core Version:    0.7.0.1
 */