import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;

public class auiu
  implements View.OnClickListener
{
  public auiu(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    aujh.a(AutoReplyEditActivity.a(this.a), true);
    paramView = new Intent();
    paramView.putExtra("AutoReplyEditActivity:new_text", AutoReplyEditActivity.b(this.a));
    if (AutoReplyEditActivity.a(this.a) != null) {
      paramView.putExtra("AutoReplyEditActivity:text", new AutoReplyText(AutoReplyText.trimRawString(String.valueOf(AutoReplyEditActivity.a(this.a).getText()), false), AutoReplyEditActivity.a(this.a).getTextId()));
    }
    this.a.getActivity().setResult(325, paramView);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auiu
 * JD-Core Version:    0.7.0.1
 */