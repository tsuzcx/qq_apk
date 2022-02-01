import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.ui.ForceUserUpdateActivity;

public class bmqp
  implements View.OnClickListener
{
  public bmqp(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqp
 * JD-Core Version:    0.7.0.1
 */