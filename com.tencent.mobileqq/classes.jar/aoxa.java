import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aoxa
  implements View.OnClickListener
{
  aoxa(aowx paramaowx) {}
  
  public void onClick(View paramView)
  {
    acmy.a(aowx.a(this.a), -3, "user canceled");
    aowx.a(this.a).a();
    aowx.a(this.a).dismiss();
    aowx.a(this.a, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxa
 * JD-Core Version:    0.7.0.1
 */