import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.ui.ForceUserUpdateActivity;

public class bmqo
  implements View.OnClickListener
{
  public bmqo(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void onClick(View paramView)
  {
    ForceUserUpdateActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqo
 * JD-Core Version:    0.7.0.1
 */