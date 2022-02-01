import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.CountDownLatch;

class bolv
  implements View.OnClickListener
{
  bolv(boll paramboll) {}
  
  public void onClick(View paramView)
  {
    boll.a(this.a, true);
    boll.a(this.a).countDown();
    this.a.a.g();
    boll.a(this.a).cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bolv
 * JD-Core Version:    0.7.0.1
 */