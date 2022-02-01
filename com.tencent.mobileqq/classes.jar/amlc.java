import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amlc
  implements View.OnClickListener
{
  public amlc(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = anzj.a(2131712717);
    localObject = bhlq.a(SessionClearFragment.a(this.a), 230, anzj.a(2131712719), (String)localObject, 2131693994, 2131719410, new amld(this), new amle(this));
    SessionClearFragment.a(this.a, (Dialog)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlc
 * JD-Core Version:    0.7.0.1
 */