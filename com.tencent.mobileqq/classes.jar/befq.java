import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class befq
  implements View.OnClickListener
{
  befq(befp parambefp) {}
  
  public void onClick(View paramView)
  {
    if (befp.a(this.a).isShowing()) {
      befp.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befq
 * JD-Core Version:    0.7.0.1
 */