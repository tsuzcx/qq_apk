import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayfc
  implements View.OnClickListener
{
  public ayfc(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    ((Activity)this.a.getContext()).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfc
 * JD-Core Version:    0.7.0.1
 */