import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atot
  implements View.OnClickListener
{
  atot(atos paramatos) {}
  
  public void onClick(View paramView)
  {
    aggl localaggl = (aggl)agej.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localaggl != null)
    {
      i = -1;
      localChatMessage = aunj.a(localaggl.a);
      if (!this.a.b(localChatMessage)) {
        break label83;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localaggl, localChatMessage, i);
      if (this.a.a != null) {
        this.a.a.h(localaggl.a);
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
 * Qualified Name:     atot
 * JD-Core Version:    0.7.0.1
 */