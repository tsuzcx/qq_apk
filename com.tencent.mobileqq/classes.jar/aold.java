import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aold
  implements View.OnClickListener
{
  aold(aolb paramaolb) {}
  
  public void onClick(View paramView)
  {
    if ((aolb.a(this.a) != null) && (aolb.a(this.a).isShowing())) {
      aolb.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aold
 * JD-Core Version:    0.7.0.1
 */