import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;

final class bnbc
  implements View.OnClickListener
{
  bnbc(AIOLongCaptureCtrl paramAIOLongCaptureCtrl) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbc
 * JD-Core Version:    0.7.0.1
 */