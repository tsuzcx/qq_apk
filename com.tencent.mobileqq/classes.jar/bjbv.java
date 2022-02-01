import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjbv
  implements View.OnClickListener
{
  public bjbv(BindGroupFragment paramBindGroupFragment) {}
  
  public void onClick(View paramView)
  {
    BindGroupFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbv
 * JD-Core Version:    0.7.0.1
 */