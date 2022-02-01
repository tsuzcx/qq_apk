import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayoh
  implements View.OnClickListener
{
  public ayoh(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    aype.a(AutoReplyEditActivity.a(this.a), true);
    Intent localIntent = new Intent();
    localIntent.putExtra("AutoReplyEditActivity:new_text", AutoReplyEditActivity.b(this.a));
    if (AutoReplyEditActivity.a(this.a) != null) {
      localIntent.putExtra("AutoReplyEditActivity:text", new AutoReplyText(AutoReplyText.trimRawString(String.valueOf(AutoReplyEditActivity.a(this.a).getText()), false), AutoReplyEditActivity.a(this.a).getTextId()));
    }
    this.a.getActivity().setResult(325, localIntent);
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayoh
 * JD-Core Version:    0.7.0.1
 */