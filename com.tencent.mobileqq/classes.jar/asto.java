import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asto
  implements View.OnClickListener
{
  public asto(AIOEmotionBaseFragment paramAIOEmotionBaseFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asto
 * JD-Core Version:    0.7.0.1
 */