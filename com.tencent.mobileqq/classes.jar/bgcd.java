import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgcd
  implements View.OnClickListener
{
  bgcd(bgcb parambgcb) {}
  
  public void onClick(View paramView)
  {
    if (bgcb.a(this.a) != null)
    {
      bgcb.a(this.a).a(paramView);
      if (bgcb.a(this.a) != null) {
        bgcb.a(this.a).b(paramView, 0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcd
 * JD-Core Version:    0.7.0.1
 */