import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayyw
  implements View.OnClickListener
{
  public ayyw(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onClick(View paramView)
  {
    AccountOnlineStateActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyw
 * JD-Core Version:    0.7.0.1
 */