import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqdl
  implements View.OnClickListener
{
  aqdl(aqdj paramaqdj) {}
  
  public void onClick(View paramView)
  {
    if ((aqdj.a(this.a) == 0) && (!TextUtils.isEmpty(aqdj.b(this.a)))) {
      aqdj.a(this.a, null);
    }
    aqdj.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdl
 * JD-Core Version:    0.7.0.1
 */