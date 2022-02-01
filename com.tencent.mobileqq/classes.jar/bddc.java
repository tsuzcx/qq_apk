import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bddc
  implements View.OnClickListener
{
  bddc(bdcw parambdcw) {}
  
  public void onClick(View paramView)
  {
    bdcw.a(this.a, bdcw.a(this.a));
    bdcw.b(this.a, System.currentTimeMillis());
    if (bdcw.a(this.a) - bdcw.b(this.a) < 300L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdcw.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddc
 * JD-Core Version:    0.7.0.1
 */