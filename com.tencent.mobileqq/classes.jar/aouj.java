import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aouj
  implements View.OnClickListener
{
  aouj(aoui paramaoui) {}
  
  public void onClick(View paramView)
  {
    acuj localacuj = (acuj)actj.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localacuj != null)
    {
      i = -1;
      localChatMessage = apug.a(localacuj.a);
      if (!this.a.a(localChatMessage)) {
        break label50;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localacuj, localChatMessage, i);
      return;
      label50:
      if (this.a.b(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aouj
 * JD-Core Version:    0.7.0.1
 */