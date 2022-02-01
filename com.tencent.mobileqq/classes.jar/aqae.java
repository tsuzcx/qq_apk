import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqae
  implements View.OnClickListener
{
  aqae(aqab paramaqab) {}
  
  public void onClick(View paramView)
  {
    addh.a(aqab.a(this.a), -3, "user canceled");
    aqab.a(this.a).a();
    aqab.a(this.a).dismiss();
    aqab.a(this.a, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqae
 * JD-Core Version:    0.7.0.1
 */