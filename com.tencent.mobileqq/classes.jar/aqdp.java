import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqdp
  implements View.OnClickListener
{
  aqdp(aqdm paramaqdm) {}
  
  public void onClick(View paramView)
  {
    adqf.a(aqdm.a(this.a), -3, "user canceled");
    aqdm.a(this.a).a();
    aqdm.a(this.a).dismiss();
    aqdm.a(this.a, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdp
 * JD-Core Version:    0.7.0.1
 */