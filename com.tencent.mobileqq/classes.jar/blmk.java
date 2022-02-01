import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.CountDownLatch;

class blmk
  implements View.OnClickListener
{
  blmk(blmi paramblmi) {}
  
  public void onClick(View paramView)
  {
    bmbx.b("AEPhotoListLogicBase", "batchCompressDialog cancel clicked");
    blmi.a(this.a, true);
    this.a.i();
    if (blmi.a(this.a) != null) {
      blmi.a(this.a).countDown();
    }
    blmi.a(this.a).cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmk
 * JD-Core Version:    0.7.0.1
 */