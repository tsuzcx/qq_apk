import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amdu
  implements View.OnClickListener
{
  public amdu(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    if (SessionClearFragment.a(this.a) == 0)
    {
      SessionClearFragment.a(this.a).setText(anvx.a(2131713295));
      SessionClearFragment.a(this.a, 1);
      SessionClearFragment.a(this.a).b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SessionClearFragment.a(this.a).setText(anvx.a(2131713293));
      SessionClearFragment.a(this.a, 0);
      SessionClearFragment.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdu
 * JD-Core Version:    0.7.0.1
 */