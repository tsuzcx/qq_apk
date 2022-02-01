import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdde
  implements View.OnClickListener
{
  bdde(bdcy parambdcy) {}
  
  public void onClick(View paramView)
  {
    bdcy.a(this.a, bdcy.a(this.a));
    bdcy.b(this.a, System.currentTimeMillis());
    if (bdcy.a(this.a) - bdcy.b(this.a) < 300L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdcy.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdde
 * JD-Core Version:    0.7.0.1
 */