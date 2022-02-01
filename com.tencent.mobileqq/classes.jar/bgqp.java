import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgqp
  implements View.OnClickListener
{
  bgqp(bgqo parambgqo) {}
  
  public void onClick(View paramView)
  {
    bgqo.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgqp
 * JD-Core Version:    0.7.0.1
 */