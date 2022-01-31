import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aoug
  implements View.OnClickListener
{
  aoug(aouf paramaouf) {}
  
  public void onClick(View paramView)
  {
    acuj localacuj = (acuj)actj.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localacuj != null)
    {
      i = -1;
      localChatMessage = apug.a(localacuj.a);
      if (!this.a.b(localChatMessage)) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localacuj, localChatMessage, i);
      if (this.a.a != null) {
        this.a.a.g(localacuj.a);
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
 * Qualified Name:     aoug
 * JD-Core Version:    0.7.0.1
 */