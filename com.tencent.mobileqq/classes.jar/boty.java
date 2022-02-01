import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.BaseVMPeakActivity;

class boty
  implements View.OnClickListener
{
  boty(botw parambotw) {}
  
  public void onClick(View paramView)
  {
    botw.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boty
 * JD-Core Version:    0.7.0.1
 */