import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayss
  implements View.OnClickListener
{
  public ayss(OnlineStatusLocationFragment paramOnlineStatusLocationFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.getActivity() != null) && (!this.a.getActivity().isFinishing())) {
      this.a.getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayss
 * JD-Core Version:    0.7.0.1
 */