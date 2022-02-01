import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class augk
  implements View.OnClickListener
{
  public augk(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a) != null) {
      SendBottomBar.a(this.a).a();
    }
    if (SendBottomBar.a(this.a)) {
      auea.b(SendBottomBar.a(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      auea.a(SendBottomBar.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     augk
 * JD-Core Version:    0.7.0.1
 */