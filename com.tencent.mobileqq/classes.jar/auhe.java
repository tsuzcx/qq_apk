import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auhe
  implements View.OnClickListener
{
  public auhe(ForwardFileOption paramForwardFileOption) {}
  
  public void onClick(View paramView)
  {
    ForwardFileOption.b(this.a);
    ForwardFileOption.a(this.a, paramView);
    bcst.b(null, "dc00898", "", "", "0X800AEEA", "0X800AEEA", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhe
 * JD-Core Version:    0.7.0.1
 */