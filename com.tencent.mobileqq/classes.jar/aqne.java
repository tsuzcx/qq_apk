import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aqne
  implements View.OnClickListener
{
  aqne(aqnd paramaqnd) {}
  
  public void onClick(View paramView)
  {
    aelt localaelt = (aelt)aekt.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localaelt != null)
    {
      i = -1;
      localChatMessage = arni.a(localaelt.a);
      if (!this.a.b(localChatMessage)) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localaelt, localChatMessage, i);
      if (this.a.a != null) {
        this.a.a.g(localaelt.a);
      }
      return;
      label76:
      if (this.a.a(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqne
 * JD-Core Version:    0.7.0.1
 */