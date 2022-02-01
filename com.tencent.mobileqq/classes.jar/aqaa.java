import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqaa
  implements View.OnClickListener
{
  aqaa(apzy paramapzy) {}
  
  public void onClick(View paramView)
  {
    if ((apzy.a(this.a) == 0) && (!TextUtils.isEmpty(apzy.b(this.a)))) {
      apzy.a(this.a, null);
    }
    apzy.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqaa
 * JD-Core Version:    0.7.0.1
 */