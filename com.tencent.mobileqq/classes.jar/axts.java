import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class axts
  implements View.OnClickListener
{
  axts(axtr paramaxtr) {}
  
  public void onClick(View paramView)
  {
    if (axtr.a(this.a).size() > 10) {
      QQToast.a(axtr.a(this.a), 1, 2131690229, 1).a();
    }
    while (axtr.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (axtr.a(this.a).size() > 1) {}
    for (int i = axtr.a(this.a).size() - 1;; i = 0)
    {
      AutoReplyText localAutoReplyText = new AutoReplyText("", i);
      localAutoReplyText.getExtra().putBoolean("addFlag", true);
      axtr.a(this.a).b(localAutoReplyText, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axts
 * JD-Core Version:    0.7.0.1
 */