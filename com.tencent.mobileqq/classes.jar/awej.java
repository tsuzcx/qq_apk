import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;

public class awej
  implements View.OnClickListener
{
  public awej(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    if (AutoReplyEditActivity.c(this.a))
    {
      AutoReplyEditActivity.a(this.a, false);
      return;
    }
    if (AutoReplyEditActivity.d(this.a))
    {
      AutoReplyEditActivity.b(this.a, false);
      return;
    }
    AutoReplyEditActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awej
 * JD-Core Version:    0.7.0.1
 */