import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.forward.ForwardReplyMsgOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avaz
  implements View.OnClickListener
{
  public avaz(ForwardReplyMsgOption paramForwardReplyMsgOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.hideSoftInputFromWindow();
      ForwardReplyMsgOption.a(this.a, ForwardReplyMsgOption.a(this.a).uniseq);
      this.a.F();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avaz
 * JD-Core Version:    0.7.0.1
 */