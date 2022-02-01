import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.CountDownLatch;

class blqb
  implements View.OnClickListener
{
  blqb(blpr paramblpr) {}
  
  public void onClick(View paramView)
  {
    blpr.a(this.a, true);
    blpr.a(this.a).countDown();
    this.a.a.c();
    blpr.a(this.a).cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqb
 * JD-Core Version:    0.7.0.1
 */