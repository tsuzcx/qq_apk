import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arvt
  implements View.OnClickListener
{
  public arvt(DBFixConfigActivity paramDBFixConfigActivity) {}
  
  public void onClick(View paramView)
  {
    ThreadManager.post(this.a.a, 8, null, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvt
 * JD-Core Version:    0.7.0.1
 */