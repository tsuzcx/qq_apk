import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aoww
  implements View.OnClickListener
{
  aoww(aowu paramaowu) {}
  
  public void onClick(View paramView)
  {
    if ((aowu.a(this.a) == 0) && (!TextUtils.isEmpty(aowu.b(this.a)))) {
      aowu.a(this.a, null);
    }
    aowu.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoww
 * JD-Core Version:    0.7.0.1
 */