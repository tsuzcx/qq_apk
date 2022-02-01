import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amdv
  implements View.OnClickListener
{
  public amdv(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = anvx.a(2131713296);
    localObject = bhdj.a(SessionClearFragment.a(this.a), 230, anvx.a(2131713298), (String)localObject, 2131694291, 2131720187, new amdw(this), new amdx(this));
    SessionClearFragment.a(this.a, (Dialog)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdv
 * JD-Core Version:    0.7.0.1
 */