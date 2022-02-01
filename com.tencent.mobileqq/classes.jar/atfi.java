import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atfi
  implements View.OnClickListener
{
  atfi(atfh paramatfh) {}
  
  public void onClick(View paramView)
  {
    afqr localafqr = (afqr)AIOUtils.getHolder(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localafqr != null)
    {
      i = -1;
      localChatMessage = auea.a(localafqr.a);
      if (!this.a.b(localChatMessage)) {
        break label83;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localafqr, localChatMessage, i);
      if (this.a.a != null) {
        this.a.a.h(localafqr.a);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      if (this.a.a(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfi
 * JD-Core Version:    0.7.0.1
 */