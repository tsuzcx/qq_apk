import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auqc
  implements View.OnClickListener
{
  public auqc(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.b(this.a, true);
      aunh.a("0X800942B");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SendBottomBar.c(this.a, false);
      SendBottomBar.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqc
 * JD-Core Version:    0.7.0.1
 */