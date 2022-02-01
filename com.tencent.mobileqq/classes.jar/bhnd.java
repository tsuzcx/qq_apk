import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhnd
  implements View.OnClickListener
{
  bhnd(bhmr parambhmr) {}
  
  public void onClick(View paramView)
  {
    if ((bhmr.a(this.a) != null) && (bhmr.a(this.a).isShowing())) {
      bhmr.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhnd
 * JD-Core Version:    0.7.0.1
 */