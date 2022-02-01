import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aoyr
  implements View.OnClickListener
{
  aoyr(aoyp paramaoyp) {}
  
  public void onClick(View paramView)
  {
    if ((aoyp.a(this.a) != null) && (aoyp.a(this.a).isShowing())) {
      aoyp.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyr
 * JD-Core Version:    0.7.0.1
 */