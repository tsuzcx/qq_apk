import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.CustomedTabWidget;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class biwv
  implements View.OnClickListener
{
  public biwv(CustomedTabWidget paramCustomedTabWidget) {}
  
  public void onClick(View paramView)
  {
    this.a.setCurrentTab(this.a.indexOfChild(paramView));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biwv
 * JD-Core Version:    0.7.0.1
 */