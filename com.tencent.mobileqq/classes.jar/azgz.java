import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class azgz
  implements View.OnClickListener
{
  public azgz(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    azhx.a(AutoReplyEditActivity.a(this.a), false);
    String str2 = String.valueOf(AutoReplyEditActivity.a(this.a).getText());
    String str1;
    if (AutoReplyEditActivity.a(this.a) != null)
    {
      str1 = AutoReplyEditActivity.a(this.a).getRawText();
      if (str2.equals(str1)) {
        break label75;
      }
      AutoReplyEditActivity.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = "";
      break;
      label75:
      AutoReplyEditActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgz
 * JD-Core Version:    0.7.0.1
 */