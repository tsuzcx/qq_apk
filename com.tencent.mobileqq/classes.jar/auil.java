import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auil
  implements View.OnClickListener
{
  public auil(ForwardPluginShareStructMsgOption paramForwardPluginShareStructMsgOption) {}
  
  public void onClick(View paramView)
  {
    ForwardPluginShareStructMsgOption.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auil
 * JD-Core Version:    0.7.0.1
 */