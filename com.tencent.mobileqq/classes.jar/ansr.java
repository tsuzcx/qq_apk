import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ansr
  implements View.OnClickListener
{
  ansr(ansq paramansq) {}
  
  public void onClick(View paramView)
  {
    if ((ansq.a(this.a) != null) && (ansq.a(this.a).isShowing())) {
      ansq.a(this.a).dismiss();
    }
    ansq.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansr
 * JD-Core Version:    0.7.0.1
 */