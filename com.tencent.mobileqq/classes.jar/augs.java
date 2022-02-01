import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class augs
  implements View.OnClickListener
{
  public augs(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.a(this.a).d();
      SendBottomBar.a(this.a).setText(anvx.a(2131713257));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SendBottomBar.a(this.a).e();
      SendBottomBar.a(this.a).setText(anvx.a(2131713269));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     augs
 * JD-Core Version:    0.7.0.1
 */