import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axul
  implements View.OnClickListener
{
  public axul(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    if (AutoReplyEditActivity.c(this.a)) {
      AutoReplyEditActivity.a(this.a, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AutoReplyEditActivity.d(this.a)) {
        AutoReplyEditActivity.b(this.a, false);
      } else {
        AutoReplyEditActivity.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axul
 * JD-Core Version:    0.7.0.1
 */