import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bicy
  implements View.OnClickListener
{
  public bicy(TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    this.a.removeAllViews();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bicy
 * JD-Core Version:    0.7.0.1
 */