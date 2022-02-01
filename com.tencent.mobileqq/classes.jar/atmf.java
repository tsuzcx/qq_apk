import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atmf
  implements View.OnClickListener
{
  public atmf(ForwardFileOption paramForwardFileOption) {}
  
  public void onClick(View paramView)
  {
    ForwardFileOption.a(this.a);
    ForwardFileOption.a(this.a, paramView);
    bcef.b(null, "dc00898", "", "", "0X800AEEA", "0X800AEEA", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmf
 * JD-Core Version:    0.7.0.1
 */