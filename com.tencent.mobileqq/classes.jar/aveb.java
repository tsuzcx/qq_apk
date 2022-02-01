import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aveb
  implements View.OnClickListener
{
  public aveb(IphoneTitleBarFragment paramIphoneTitleBarFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aveb
 * JD-Core Version:    0.7.0.1
 */