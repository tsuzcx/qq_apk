import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auqd
  implements View.OnClickListener
{
  public auqd(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.a(this.a).d();
      SendBottomBar.a(this.a).setText(anzj.a(2131712678));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SendBottomBar.a(this.a).e();
      SendBottomBar.a(this.a).setText(anzj.a(2131712690));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqd
 * JD-Core Version:    0.7.0.1
 */