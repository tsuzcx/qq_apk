import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenSdkIMBlockFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjfa
  implements View.OnClickListener
{
  public bjfa(OpenSdkIMBlockFragment paramOpenSdkIMBlockFragment) {}
  
  public void onClick(View paramView)
  {
    bjhg.a(OpenSdkIMBlockFragment.a(this.a), "0X800B65B");
    OpenSdkIMBlockFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfa
 * JD-Core Version:    0.7.0.1
 */