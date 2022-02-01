import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.BaseVMPeakActivity;

class bnsk
  implements View.OnClickListener
{
  bnsk(bnsi parambnsi) {}
  
  public void onClick(View paramView)
  {
    bnsi.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsk
 * JD-Core Version:    0.7.0.1
 */