import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axyo
  implements View.OnClickListener
{
  public axyo(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    ShortVideoCommentsView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyo
 * JD-Core Version:    0.7.0.1
 */