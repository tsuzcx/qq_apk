import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ClickableToastView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bivz
  implements View.OnClickListener
{
  public bivz(ClickableToastView paramClickableToastView) {}
  
  public void onClick(View paramView)
  {
    if (ClickableToastView.a(this.a).a != null)
    {
      this.a.b();
      ClickableToastView.a(this.a).a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bivz
 * JD-Core Version:    0.7.0.1
 */