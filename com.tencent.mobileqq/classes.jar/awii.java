import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.7;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awii
  implements View.OnClickListener
{
  public awii(BaseListenTogetherPanel.7 param7) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awii
 * JD-Core Version:    0.7.0.1
 */