import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class azad
  implements View.OnClickListener
{
  azad(azac paramazac) {}
  
  public void onClick(View paramView)
  {
    if (azac.a(this.a).size() > 10) {
      QQToast.a(azac.a(this.a), 1, 2131690267, 1).a();
    }
    while (azac.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (azac.a(this.a).size() > 1) {}
    for (int i = azac.a(this.a).size() - 1;; i = 0)
    {
      AutoReplyText localAutoReplyText = new AutoReplyText("", i);
      localAutoReplyText.getExtra().putBoolean("addFlag", true);
      azac.a(this.a).b(localAutoReplyText, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azad
 * JD-Core Version:    0.7.0.1
 */