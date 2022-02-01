import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asys
  implements View.OnClickListener
{
  asys(asyr paramasyr) {}
  
  public void onClick(View paramView)
  {
    afwr localafwr = (afwr)afur.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localafwr != null)
    {
      i = -1;
      localChatMessage = atvo.a(localafwr.a);
      if (!this.a.a(localChatMessage)) {
        break label57;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localafwr, localChatMessage, i);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label57:
      if (this.a.b(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asys
 * JD-Core Version:    0.7.0.1
 */