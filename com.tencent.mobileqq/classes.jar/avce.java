import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.6;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avce
  implements View.OnClickListener
{
  public avce(BaseListenTogetherPanel.6 param6) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avce
 * JD-Core Version:    0.7.0.1
 */