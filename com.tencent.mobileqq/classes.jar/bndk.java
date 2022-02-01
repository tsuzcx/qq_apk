import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.CountDownLatch;

class bndk
  implements View.OnClickListener
{
  bndk(bnda parambnda) {}
  
  public void onClick(View paramView)
  {
    bnda.a(this.a, true);
    bnda.a(this.a).countDown();
    this.a.a.c();
    bnda.a(this.a).cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndk
 * JD-Core Version:    0.7.0.1
 */