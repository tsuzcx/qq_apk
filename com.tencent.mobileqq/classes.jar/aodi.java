import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aodi
  implements View.OnClickListener
{
  aodi(aodh paramaodh) {}
  
  public void onClick(View paramView)
  {
    acju localacju = (acju)aciy.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localacju != null)
    {
      i = -1;
      localChatMessage = apck.a(localacju.a);
      if (!this.a.b(localChatMessage)) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localacju, localChatMessage, i);
      if (this.a.a != null) {
        this.a.a.g(localacju.a);
      }
      return;
      label76:
      if (this.a.a(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aodi
 * JD-Core Version:    0.7.0.1
 */