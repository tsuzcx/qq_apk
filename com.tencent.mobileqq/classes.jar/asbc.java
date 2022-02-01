import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asbc
  implements View.OnClickListener
{
  asbc(asbb paramasbb) {}
  
  public void onClick(View paramView)
  {
    aezf localaezf = (aezf)AIOUtils.getHolder(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localaezf != null)
    {
      i = -1;
      localChatMessage = aszt.a(localaezf.a);
      if (!this.a.b(localChatMessage)) {
        break label83;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localaezf, localChatMessage, i);
      if (this.a.a != null) {
        this.a.a.h(localaezf.a);
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
 * Qualified Name:     asbc
 * JD-Core Version:    0.7.0.1
 */