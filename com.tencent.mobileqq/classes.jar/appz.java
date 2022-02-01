import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class appz
  implements View.OnClickListener
{
  appz(appw paramappw) {}
  
  public void onClick(View paramView)
  {
    adhh.a(appw.a(this.a), -3, "user canceled");
    appw.a(this.a).a();
    appw.a(this.a).dismiss();
    appw.a(this.a, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appz
 * JD-Core Version:    0.7.0.1
 */