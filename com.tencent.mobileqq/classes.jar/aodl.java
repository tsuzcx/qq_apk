import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aodl
  implements View.OnClickListener
{
  aodl(aodk paramaodk) {}
  
  public void onClick(View paramView)
  {
    acju localacju = (acju)aciy.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localacju != null)
    {
      i = -1;
      localChatMessage = apck.a(localacju.a);
      if (!this.a.a(localChatMessage)) {
        break label50;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localacju, localChatMessage, i);
      return;
      label50:
      if (this.a.b(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aodl
 * JD-Core Version:    0.7.0.1
 */