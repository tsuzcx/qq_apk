import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgal
  implements View.OnClickListener
{
  public bgal(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    blgx.b(paramView);
    this.a.getActivity().doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgal
 * JD-Core Version:    0.7.0.1
 */