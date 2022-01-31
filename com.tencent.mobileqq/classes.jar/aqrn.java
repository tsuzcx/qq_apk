import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ChatMessage;

class aqrn
  implements View.OnClickListener
{
  aqrn(aqrm paramaqrm) {}
  
  public void onClick(View paramView)
  {
    aeqi localaeqi = (aeqi)aepi.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localaeqi != null)
    {
      i = -1;
      localChatMessage = arrr.a(localaeqi.a);
      if (!this.a.b(localChatMessage)) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localaeqi, localChatMessage, i);
      if (this.a.a != null) {
        this.a.a.g(localaeqi.a);
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
 * Qualified Name:     aqrn
 * JD-Core Version:    0.7.0.1
 */