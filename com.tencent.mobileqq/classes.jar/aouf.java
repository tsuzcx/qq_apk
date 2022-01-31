import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aouf
  implements View.OnClickListener
{
  aouf(aoue paramaoue) {}
  
  public void onClick(View paramView)
  {
    acun localacun = (acun)actn.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localacun != null)
    {
      i = -1;
      localChatMessage = apue.a(localacun.a);
      if (!this.a.a(localChatMessage)) {
        break label50;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localacun, localChatMessage, i);
      return;
      label50:
      if (this.a.b(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aouf
 * JD-Core Version:    0.7.0.1
 */