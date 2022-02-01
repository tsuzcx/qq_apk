import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anss
  implements View.OnClickListener
{
  anss(ansq paramansq) {}
  
  public void onClick(View paramView)
  {
    if ((ansq.a(this.a) != null) && (ansq.a(this.a).isShowing())) {
      ansq.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anss
 * JD-Core Version:    0.7.0.1
 */