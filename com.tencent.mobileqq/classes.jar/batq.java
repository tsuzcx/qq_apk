import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class batq
  implements View.OnClickListener
{
  public batq(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batq
 * JD-Core Version:    0.7.0.1
 */