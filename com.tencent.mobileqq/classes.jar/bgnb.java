import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgnb
  implements View.OnClickListener
{
  bgnb(bgmp parambgmp) {}
  
  public void onClick(View paramView)
  {
    if ((bgmp.a(this.a) != null) && (bgmp.a(this.a).isShowing())) {
      bgmp.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgnb
 * JD-Core Version:    0.7.0.1
 */