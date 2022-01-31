import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;

public class atks
  implements View.OnClickListener
{
  public atks(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    atlh.a(AutoReplyEditActivity.a(this.a), false);
    String str = String.valueOf(AutoReplyEditActivity.a(this.a).getText());
    if (AutoReplyEditActivity.a(this.a) != null) {}
    for (paramView = AutoReplyEditActivity.a(this.a).getRawText(); !str.equals(paramView); paramView = "")
    {
      AutoReplyEditActivity.a(this.a);
      return;
    }
    AutoReplyEditActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atks
 * JD-Core Version:    0.7.0.1
 */