import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axzd
  implements View.OnClickListener
{
  public axzd(StuffContainerView paramStuffContainerView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzd
 * JD-Core Version:    0.7.0.1
 */