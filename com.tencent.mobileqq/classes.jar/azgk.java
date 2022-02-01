import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class azgk
  implements View.OnClickListener
{
  azgk(azgj paramazgj) {}
  
  public void onClick(View paramView)
  {
    if (azgj.a(this.a).size() > 10) {
      QQToast.a(azgj.a(this.a), 1, 2131690204, 1).a();
    }
    while (azgj.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (azgj.a(this.a).size() > 1) {}
    for (int i = azgj.a(this.a).size() - 1;; i = 0)
    {
      AutoReplyText localAutoReplyText = new AutoReplyText("", i);
      localAutoReplyText.getExtra().putBoolean("addFlag", true);
      azgj.a(this.a).b(localAutoReplyText, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgk
 * JD-Core Version:    0.7.0.1
 */