import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asyp
  implements View.OnClickListener
{
  asyp(asyo paramasyo) {}
  
  public void onClick(View paramView)
  {
    afwr localafwr = (afwr)afur.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localafwr != null)
    {
      i = -1;
      localChatMessage = atvo.a(localafwr.a);
      if (!this.a.b(localChatMessage)) {
        break label83;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localafwr, localChatMessage, i);
      if (this.a.a != null) {
        this.a.a.h(localafwr.a);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      if (this.a.a(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyp
 * JD-Core Version:    0.7.0.1
 */