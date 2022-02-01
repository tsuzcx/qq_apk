import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfwb
  implements View.OnClickListener
{
  bfwb(bfvp parambfvp) {}
  
  public void onClick(View paramView)
  {
    if ((bfvp.a(this.a) != null) && (bfvp.a(this.a).isShowing())) {
      bfvp.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfwb
 * JD-Core Version:    0.7.0.1
 */