import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atow
  implements View.OnClickListener
{
  atow(atov paramatov) {}
  
  public void onClick(View paramView)
  {
    aggl localaggl = (aggl)agej.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localaggl != null)
    {
      i = -1;
      localChatMessage = aunj.a(localaggl.a);
      if (!this.a.a(localChatMessage)) {
        break label57;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localaggl, localChatMessage, i);
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
 * Qualified Name:     atow
 * JD-Core Version:    0.7.0.1
 */