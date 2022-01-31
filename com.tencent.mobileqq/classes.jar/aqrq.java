import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aqrq
  implements View.OnClickListener
{
  aqrq(aqrp paramaqrp) {}
  
  public void onClick(View paramView)
  {
    aeqi localaeqi = (aeqi)aepi.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localaeqi != null)
    {
      i = -1;
      localChatMessage = arrr.a(localaeqi.a);
      if (!this.a.a(localChatMessage)) {
        break label50;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localaeqi, localChatMessage, i);
      return;
      label50:
      if (this.a.b(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrq
 * JD-Core Version:    0.7.0.1
 */