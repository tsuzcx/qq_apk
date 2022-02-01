import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.BaseVMPeakActivity;

class blyd
  implements View.OnClickListener
{
  blyd(blyb paramblyb) {}
  
  public void onClick(View paramView)
  {
    blyb.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyd
 * JD-Core Version:    0.7.0.1
 */