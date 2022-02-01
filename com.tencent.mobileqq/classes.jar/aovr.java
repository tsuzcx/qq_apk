import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aovr
  implements View.OnClickListener
{
  aovr(aovq paramaovq) {}
  
  public void onClick(View paramView)
  {
    if ((aovq.a(this.a) != null) && (aovq.a(this.a).isShowing())) {
      aovq.a(this.a).dismiss();
    }
    aovq.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovr
 * JD-Core Version:    0.7.0.1
 */