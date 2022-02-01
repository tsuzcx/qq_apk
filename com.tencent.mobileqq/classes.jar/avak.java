import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avak
  implements View.OnClickListener
{
  public avak(ForwardPluginShareStructMsgOption paramForwardPluginShareStructMsgOption) {}
  
  public void onClick(View paramView)
  {
    ForwardPluginShareStructMsgOption.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avak
 * JD-Core Version:    0.7.0.1
 */