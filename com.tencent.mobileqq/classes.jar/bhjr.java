import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhjr
  implements View.OnClickListener
{
  bhjr(bhjq parambhjq) {}
  
  public void onClick(View paramView)
  {
    bhjq.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjr
 * JD-Core Version:    0.7.0.1
 */