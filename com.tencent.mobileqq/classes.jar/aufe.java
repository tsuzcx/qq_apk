import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aufe
  implements View.OnClickListener
{
  aufe(aueo paramaueo) {}
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufe
 * JD-Core Version:    0.7.0.1
 */