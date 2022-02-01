import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardStructingMsgOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atqc
  implements View.OnClickListener
{
  public atqc(ForwardStructingMsgOption paramForwardStructingMsgOption) {}
  
  public void onClick(View paramView)
  {
    ForwardStructingMsgOption.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqc
 * JD-Core Version:    0.7.0.1
 */