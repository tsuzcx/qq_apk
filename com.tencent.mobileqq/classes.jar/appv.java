import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class appv
  implements View.OnClickListener
{
  appv(appt paramappt) {}
  
  public void onClick(View paramView)
  {
    if ((appt.a(this.a) == 0) && (!TextUtils.isEmpty(appt.b(this.a)))) {
      appt.a(this.a, null);
    }
    appt.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appv
 * JD-Core Version:    0.7.0.1
 */