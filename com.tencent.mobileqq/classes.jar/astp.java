import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class astp
  implements View.OnClickListener
{
  public astp(AIOEmotionBaseFragment paramAIOEmotionBaseFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a("0X8009980");
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astp
 * JD-Core Version:    0.7.0.1
 */