import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.CountDownLatch;

class bmzt
  implements View.OnClickListener
{
  bmzt(bmzr parambmzr) {}
  
  public void onClick(View paramView)
  {
    bnrh.b("AEPhotoListLogicBase", "batchCompressDialog cancel clicked");
    bmzr.a(this.a, true);
    this.a.i();
    if (bmzr.a(this.a) != null) {
      bmzr.a(this.a).countDown();
    }
    bmzr.a(this.a).cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzt
 * JD-Core Version:    0.7.0.1
 */