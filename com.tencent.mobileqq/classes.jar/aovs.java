import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aovs
  implements View.OnClickListener
{
  aovs(aovq paramaovq) {}
  
  public void onClick(View paramView)
  {
    if ((aovq.a(this.a) != null) && (aovq.a(this.a).isShowing())) {
      aovq.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovs
 * JD-Core Version:    0.7.0.1
 */