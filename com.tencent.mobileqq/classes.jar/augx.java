import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class augx
  implements View.OnClickListener
{
  public augx(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     augx
 * JD-Core Version:    0.7.0.1
 */