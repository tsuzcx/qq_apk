import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aqnh
  implements View.OnClickListener
{
  aqnh(aqng paramaqng) {}
  
  public void onClick(View paramView)
  {
    aelt localaelt = (aelt)aekt.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localaelt != null)
    {
      i = -1;
      localChatMessage = arni.a(localaelt.a);
      if (!this.a.a(localChatMessage)) {
        break label50;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localaelt, localChatMessage, i);
      return;
      label50:
      if (this.a.b(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnh
 * JD-Core Version:    0.7.0.1
 */