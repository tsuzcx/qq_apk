import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aouc
  implements View.OnClickListener
{
  aouc(aoub paramaoub) {}
  
  public void onClick(View paramView)
  {
    acun localacun = (acun)actn.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localacun != null)
    {
      i = -1;
      localChatMessage = apue.a(localacun.a);
      if (!this.a.b(localChatMessage)) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localacun, localChatMessage, i);
      if (this.a.a != null) {
        this.a.a.g(localacun.a);
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
 * Qualified Name:     aouc
 * JD-Core Version:    0.7.0.1
 */