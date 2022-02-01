import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.ui.ForceUserUpdateActivity;

public class blpn
  implements View.OnClickListener
{
  public blpn(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpn
 * JD-Core Version:    0.7.0.1
 */